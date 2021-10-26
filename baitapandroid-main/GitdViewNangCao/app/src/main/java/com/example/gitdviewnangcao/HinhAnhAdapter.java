package com.example.gitdviewnangcao;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.List;

public class HinhAnhAdapter extends BaseAdapter {
    private List<HinhAnh> list;
    private Context context;
    private int layout;

    public HinhAnhAdapter(List<HinhAnh> list, Context context, int layout) {
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
        ImageView imageView;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        ViewHolder viewHolder;

        if (view == null) {
            viewHolder = new ViewHolder();
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(layout, null);
            viewHolder.imageView = view.findViewById(R.id.imageView);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.imageView.setImageResource(list.get(i).getHinhanh());

        return view;
    }
}
