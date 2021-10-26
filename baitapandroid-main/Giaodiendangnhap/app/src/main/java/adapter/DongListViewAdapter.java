package adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.giaodiendangnhap.R;

import java.util.List;

import entity.Dong_Listview;

public class DongListViewAdapter extends BaseAdapter {
    private List<Dong_Listview> list;
    private Context context;
    private int layout;

    public DongListViewAdapter(List<Dong_Listview> list, Context context, int layout) {
        this.list = list;
        this.context = context;
        this.layout = layout;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    private class ViewHolder {
        TextView textView;
        ImageView imageView;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout, null);
            viewHolder.imageView = view.findViewById(R.id.imageView_dongLV);
            viewHolder.textView = view.findViewById(R.id.textView_dongLV);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        Dong_Listview dong_listview = list.get(i);
        if (dong_listview.getTen().length() <= 3) {
            viewHolder.imageView.setImageResource(android.R.drawable.btn_star_big_on);
        } else {
            viewHolder.imageView.setImageResource(android.R.drawable.presence_online);
        }
        viewHolder.textView.setText(dong_listview.getTen());
        return view;
    }
}
