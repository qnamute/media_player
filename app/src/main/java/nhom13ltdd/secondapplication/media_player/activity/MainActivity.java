package nhom13ltdd.secondapplication.media_player.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import nhom13ltdd.secondapplication.media_player.R;
import nhom13ltdd.secondapplication.media_player.adapter.ElementListAdapter;
import nhom13ltdd.secondapplication.media_player.data.ListSong;
import nhom13ltdd.secondapplication.media_player.element.BaseListElement;
import nhom13ltdd.secondapplication.media_player.element.SongsElement;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ElementListAdapter elementListAdapter;
    List<BaseListElement> offlineListElement;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.list_element);
        offlineListElement = new ArrayList<>();
        addElement();
        listView.setAdapter(elementListAdapter);
        ListSong.getListSong();
    }

    private  void addElement(){
        offlineListElement.add(new SongsElement(this));
        offlineListElement.add(new SongsElement(this));
        offlineListElement.add(new SongsElement(this));
        offlineListElement.add(new SongsElement(this));
        offlineListElement.add(new SongsElement(this));

        elementListAdapter = new ElementListAdapter(offlineListElement, this);
    }
}
