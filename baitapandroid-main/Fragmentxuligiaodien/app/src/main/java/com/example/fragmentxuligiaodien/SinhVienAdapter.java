package com.example.fragmentxuligiaodien;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class SinhVienAdapter extends BaseAdapter {
    List<SinhVien> list;
    int layout;
    Context context;

    public SinhVienAdapter(List<SinhVien> list, int layout, Context context) {
        this.list = list;
        this.layout = layout;
        this.context = context;
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
        ImageView imageView_anh;
        TextView textView_hoten;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            viewHolder = new ViewHolder();
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(layout, null);
            viewHolder.imageView_anh = view.findViewById(R.id.imageView_anh);
            viewHolder.textView_hoten = view.findViewById(R.id.textView_ten);

            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        SinhVien sinhVien = list.get(i);
        viewHolder.textView_hoten.setText(sinhVien.getHoten());


        return view;
    }
}
