package ddwu.mobile.final_project.ma02_20170938;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;
import java.util.ArrayList;

public class MyReviewAdapter extends BaseAdapter {

    public static final String TAG = "MyReviewAdapter";

    private LayoutInflater inflater;
    private Context context;
    private int layout;
    private ArrayList<MyReviewDto> list;
    MyReviewDto dto;
    private ImageView iv;


    public MyReviewAdapter(Context context, int resource, ArrayList<MyReviewDto> list) {
        this.context = context;
        this.layout = resource;
        this.list = list;

        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public int getCount() {
        return list.size();
    }


    @Override
    public MyReviewDto getItem(int position) {
        return list.get(position);
    }


    @Override
    public long getItemId(int position) {
        return list.get(position).get_id();
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Log.d(TAG, "getView with position : " + position);
        View view = convertView;
        ViewHolder viewHolder = null;

        if (view == null) {
            view = inflater.inflate(layout, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.mstTitle = view.findViewById(R.id.mstTitle);
            viewHolder.myReview = view.findViewById(R.id.myreview);
            viewHolder.iv = view.findViewById(R.id.ivImage);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }

        dto = list.get(position);

        viewHolder.mstTitle.setText(dto.getTitle());
        viewHolder.myReview.setText(dto.getReview());
        File file = new File(dto.getImage());
        if (file.exists()) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            Bitmap bitmap = BitmapFactory.decodeFile(file.getAbsolutePath());
            viewHolder.iv.setImageBitmap(bitmap);
        }


        return view;
    }

    public void setList(ArrayList<MyReviewDto> list) {
        this.list = list;
    }

    static class ViewHolder {
        public TextView mstTitle = null;
        public TextView myReview = null;
        public ImageView iv = null;
    }


}

