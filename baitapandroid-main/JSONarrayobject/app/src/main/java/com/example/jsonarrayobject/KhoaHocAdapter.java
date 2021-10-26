package com.example.jsonarrayobject;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class KhoaHocAdapter extends BaseAdapter {
    private Context context;
    private List<KhoaHoc> list;
    private int layout;

    public KhoaHocAdapter(Context context, List<KhoaHoc> list, int layout) {
        this.context = context;
        this.list = list;
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
        TextView textView1, textView2;
        ImageView imageView;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(layout, null);
            viewHolder = new ViewHolder();
            viewHolder.textView1 = view.findViewById(R.id.textView_khoahoc);
            viewHolder.textView2 = view.findViewById(R.id.textView_hocphi);
            viewHolder.imageView = view.findViewById(R.id.imageView_anh);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }


        viewHolder.textView1.setText(list.get(i).getKhoahoc());
        viewHolder.textView2.setText(list.get(i).getHocphi());
        viewHolder.imageView.setImageBitmap(list.get(i).getBitmap());

        return view;

    }
}
