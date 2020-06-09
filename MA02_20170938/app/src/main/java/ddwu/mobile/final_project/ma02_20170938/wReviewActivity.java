package ddwu.mobile.final_project.ma02_20170938;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import static android.os.Environment.getExternalStoragePublicDirectory;

public class wReviewActivity extends AppCompatActivity {
    final static String TAG = "wReviewActivity";
    private static final int REQUEST_TAKE_PHOTO = 200;
    private File photoFile;

    private ImageView mImageView;
    private String mCurrentPhotoPath;
    private TextView tvTitle;
    private EditText etReview;
    private String title;
    private ReviewDBHelper helper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write);
        mImageView = findViewById(R.id.imageView);
        tvTitle = findViewById(R.id.tvTitle);
        title = getIntent().getStringExtra("title");
        tvTitle.setText(title);
        etReview = findViewById(R.id.etReview);
        helper = new ReviewDBHelper(this);

        Log.i(TAG, getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).getAbsolutePath());
        Log.i(TAG, getExternalFilesDir(Environment.DIRECTORY_PICTURES).getAbsolutePath());
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnTakePic:
                takePictureIntent();
                break;
            case R.id.btnSaveReview:
                galleryAddPic();
                SQLiteDatabase db = helper.getWritableDatabase();

                ContentValues row = new ContentValues();
                row.put(ReviewDBHelper.COL_NAME, title);
                row.put(ReviewDBHelper.COL_REVIEW, etReview.getText().toString());
                row.put(ReviewDBHelper.COL_IMAGE, mCurrentPhotoPath);
                long result = db.insert(ReviewDBHelper.TABLE_NAME, null, row);
                helper.close();

                Intent intent = new Intent(wReviewActivity.this, MainActivity.class);
                startActivity(intent);

                break;
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_TAKE_PHOTO && resultCode == RESULT_OK) {
            setPic();
        }
    }

    private void takePictureIntent() {
        Intent takePicIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        if (takePicIntent.resolveActivity(getPackageManager()) != null) {
            // 사진을 저장할 파일 생성
            photoFile = null;
            try {
                photoFile = createImageFile();
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            if (photoFile != null) {
                Uri photoURI = FileProvider.getUriForFile(this,
                        "ddwucom.mobile.ma02_20170938.fileprovider",
                        photoFile);
                takePicIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
                startActivityForResult(takePicIntent, REQUEST_TAKE_PHOTO);
            }
        }
    }


    private void setPic() {

        int targetW = mImageView.getWidth();
        int targetH = mImageView.getHeight();

        BitmapFactory.Options bmOptions = new BitmapFactory.Options();
        bmOptions.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(mCurrentPhotoPath, bmOptions);
        int photoW = bmOptions.outWidth;
        int photoH = bmOptions.outHeight;

        int scaleFactor = Math.min(photoW / targetW, photoH / targetH);

        bmOptions.inJustDecodeBounds = false;
        bmOptions.inSampleSize = scaleFactor;

        Bitmap bitmap = BitmapFactory.decodeFile(mCurrentPhotoPath, bmOptions);
        mImageView.setImageBitmap(bitmap);
    }


    private File createImageFile() throws IOException {

        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "JPEG_" + timeStamp + "_";

        File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile(
                imageFileName,
                ".jpg",
                storageDir
        );

        mCurrentPhotoPath = image.getAbsolutePath();
        Log.i(TAG, "Created file path: " + mCurrentPhotoPath);
        return image;
    }


    private void galleryAddPic() {
        Intent mediaScanIntent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
        File f = new File(mCurrentPhotoPath);
        Uri contentUri = Uri.fromFile(f);
        mediaScanIntent.setData(contentUri);
        this.sendBroadcast(mediaScanIntent);
    }


}
