package ddwu.mobile.final_project.ma02_20170938;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;

public class ShowMyReviewActivity extends AppCompatActivity {

    ArrayList<MyReviewDto> resultList;
    MyReviewAdapter adapter;
    ListView rvList;
    ReviewDBHelper helper;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_showmyreview);

        rvList = findViewById(R.id.rvList);
        helper = new ReviewDBHelper(this);
        resultList = new ArrayList<MyReviewDto>();
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from " + ReviewDBHelper.TABLE_NAME, null);


        while (cursor.moveToNext()) {
            MyReviewDto item = new MyReviewDto();
            item.set_id(cursor.getInt(0));
            item.setTitle(cursor.getString(1));
            item.setImage(cursor.getString(2));
            item.setReview(cursor.getString(3));
            resultList.add(item);
        }
        cursor.close();
        helper.close();

        adapter = new MyReviewAdapter(this, R.layout.listview_myreview, resultList);
        rvList.setAdapter(adapter);

    }

}
