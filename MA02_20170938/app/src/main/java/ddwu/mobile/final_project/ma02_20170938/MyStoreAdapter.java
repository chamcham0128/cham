package ddwu.mobile.final_project.ma02_20170938;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MyStoreAdapter extends BaseAdapter {

    public static final String TAG = "MyStoreAdapter";

    private LayoutInflater inflater;
    private Context context;
    private int layout;
    private ArrayList<NaverStoreDto> list;

    public MyStoreAdapter(Context context, int resource, ArrayList<NaverStoreDto> list) {
        this.context = context;
        this.layout = resource;
        this.list = list;

        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return list.size();
    }


    @Override
    public NaverStoreDto getItem(int position) {
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
            viewHolder.stTitle = view.findViewById(R.id.stTitle);
            viewHolder.stTel = view.findViewById(R.id.stTel);
            viewHolder.stAddr = view.findViewById(R.id.stAddr);

            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder)view.getTag();
        }

        NaverStoreDto dto = list.get(position);

        viewHolder.stTitle.setText(dto.getTitle());
        viewHolder.stTel.setText(dto.getTelephone());
        viewHolder.stAddr.setText(dto.getAddress());

        return view;
    }

    public void setList(ArrayList<NaverStoreDto> list) {
        this.list = list;
    }


    static class ViewHolder {
        public TextView stTitle = null;
        public TextView stTel = null;
        public TextView stAddr = null;
    }


   }

