package adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.giaodiendangnhap.R;

import java.util.List;

import entity.Album;

public class AlbumAdapter extends BaseAdapter {
    private List<Album> list;
    private Context context;
    private int layout;

    public AlbumAdapter(List<Album> list, Context context, int layout) {
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
        TextView textView_stt, textView_maalbum, textView_tenalbum;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout, null);
            viewHolder.textView_stt = view.findViewById(R.id.textView_stt);
            viewHolder.textView_maalbum = view.findViewById(R.id.textView_maalbum);
            viewHolder.textView_tenalbum = view.findViewById(R.id.textView_tenalbum);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        Album album = list.get(i);
        viewHolder.textView_stt.setText((i+1)+"");
        viewHolder.textView_maalbum.setText(album.getMaAblum());
        viewHolder.textView_tenalbum.setText(album.getTenAlbum());
        return view;
    }
}
