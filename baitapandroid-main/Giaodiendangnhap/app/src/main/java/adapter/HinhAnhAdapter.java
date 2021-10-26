package adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.example.giaodiendangnhap.R;

import java.util.List;

public class HinhAnhAdapter extends BaseAdapter {
    List<Integer> litst;
    Context context;
    int layout;

    public HinhAnhAdapter(List<Integer> litst, Context context, int layout) {
        this.litst = litst;
        this.context = context;
        this.layout = layout;
    }

    @Override
    public int getCount() {
        return litst.size();
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
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout, null);
            viewHolder.imageView = view.findViewById(R.id.imageView_ha);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.imageView.setMaxWidth(50);
        viewHolder.imageView.setMaxHeight(50);
        viewHolder.imageView.setImageResource(litst.get(i));

        return view;
    }
}
