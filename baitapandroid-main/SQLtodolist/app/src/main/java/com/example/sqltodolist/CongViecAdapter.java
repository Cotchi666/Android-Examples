package com.example.sqltodolist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CongViecAdapter extends BaseAdapter {
    private MainActivity context;
    private List<CongViec> congViecList;
    private int layout;

    public CongViecAdapter(MainActivity context, List<CongViec> congViecList, int layout) {
        this.context = context;
        this.congViecList = congViecList;
        this.layout = layout;
    }

    @Override
    public int getCount() {
        return congViecList.size();
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
        ImageView imageView_xoa, imageView_sua;
        TextView textView_ten;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout, null);
            viewHolder.imageView_sua = view.findViewById(R.id.imageView_sua);
            viewHolder.imageView_xoa = view.findViewById(R.id.imageView_xoa);
            viewHolder.textView_ten = view.findViewById(R.id.textView_ten);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        CongViec congViec = congViecList.get(i);
        viewHolder.textView_ten.setText(congViec.getName());
        viewHolder.imageView_sua.setOnClickListener(view1 -> {
            context.dialogSua(congViec.getName(), congViec.getId());
        });
        viewHolder.imageView_xoa.setOnClickListener(view1 -> {
            context.dialogRemove(congViec.getId());
        });
        return view;
    }


}
