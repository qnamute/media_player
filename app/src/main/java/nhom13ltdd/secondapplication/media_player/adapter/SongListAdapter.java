package nhom13ltdd.secondapplication.media_player.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

import nhom13ltdd.secondapplication.media_player.R;
import nhom13ltdd.secondapplication.media_player.element.Song;

public class SongListAdapter  extends BaseAdapter {

    ArrayList<Song> listSong;
    Context context;

    public SongListAdapter(Context context){
        listSong = new ArrayList<>();
        this.context = context;
    }

    @Override
    public int getCount() {
        return listSong.size();
    }

    @Override
    public Object getItem(int position) {
        return listSong.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = View.inflate(context, R.layout.song_list_item, null);

        return convertView;
    }
}
