package nhom13ltdd.secondapplication.media_player.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import nhom13ltdd.secondapplication.media_player.R;

public class ListSongActivity extends AppCompatActivity {

    ListView listSong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_song);

        listSong = findViewById(R.id.list_song);
    }
}
