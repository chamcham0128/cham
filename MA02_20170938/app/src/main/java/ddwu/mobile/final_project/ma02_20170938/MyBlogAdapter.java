package ddwu.mobile.final_project.ma02_20170938;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MyBlogAdapter extends BaseAdapter {

    public static final String TAG = "MyBlogAdapter";

    private LayoutInflater inflater;
    private Context context;
    private int layout;
    private ArrayList<NaverBlogDto> list;


    public MyBlogAdapter(Context context, int resource, ArrayList<NaverBlogDto> list) {
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
    public NaverBlogDto getItem(int position) {
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
            viewHolder.bgTitle = view.findViewById(R.id.bgTitle);
            viewHolder.bgDes = view.findViewById(R.id.bgDes);
            viewHolder.bgrName = view.findViewById(R.id.bgrName);

            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }

        NaverBlogDto dto = list.get(position);

        viewHolder.bgTitle.setText(dto.getTitle());
        viewHolder.bgDes.setText(dto.getDescription());
        viewHolder.bgrName.setText(dto.getBloggername());

        return view;
    }

    public void setList(ArrayList<NaverBlogDto> list) {
        this.list = list;
    }

    static class ViewHolder {
        public TextView bgTitle = null;
        public TextView bgDes = null;
        public TextView bgrName = null;
    }


}

