package com.example.listnangcao;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class TraiCayAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<TraiCay> list;

    public TraiCayAdapter(Context context, int layout, List<TraiCay> list) {
        this.context = context;
        this.layout = layout;
        this.list = list;
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
        TextView textViewTen, textViewMota;
        ImageView imageView;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        ViewHolder viewHolder;
        if (view == null) {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(layout, null);
            viewHolder = new ViewHolder();
            viewHolder.textViewTen = view.findViewById(R.id.textView);
            viewHolder.textViewMota = view.findViewById(R.id.textView1);
            viewHolder.imageView = view.findViewById(R.id.imageView);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }

        Animation animation = AnimationUtils.loadAnimation(context, R.anim.anim_scale);
        view.startAnimation(animation);

        viewHolder.textViewTen.setText(list.get(i).getName());
        viewHolder.textViewMota.setText(list.get(i).getMota());
        viewHolder.imageView.setImageResource(list.get(i).getHinhanh());

        return view;
    }
}
