package nhom13ltdd.secondapplication.media_player.activity;

import android.app.SearchManager;
import android.content.Context;
import android.database.MatrixCursor;
import android.provider.BaseColumns;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.SimpleCursorAdapter;

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
    View listHeader, listFooter;
    //Path dữ liệu qua lại giữa text tìm kiếm và list danh sách gợi ý
    android.support.v4.widget.SimpleCursorAdapter suggestionAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.list_element);

        final String[] from = new String[]{"Song name"};
        final int[] to = new int[]{
                android.R.id.text1
        };
        suggestionAdapter = new android.support.v4.widget.SimpleCursorAdapter(this, android.R.layout.simple_list_item_1, null, from, to, CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);

        offlineListElement = new ArrayList<>();
        addElement();

        listView.setAdapter(elementListAdapter);
        setUpHeaderAndFooter();
    }

    private void setUpHeaderAndFooter(){
        listHeader = View.inflate(this, R.layout.home_list_header, null);
        listFooter = View.inflate(this, R.layout.home_list_footer, null);
        listView.addHeaderView(listHeader);
        listView.addFooterView(listFooter);
    }

    private  void addElement(){
        offlineListElement.add(new SongsElement(this));
        offlineListElement.add(new SongsElement(this));
        offlineListElement.add(new SongsElement(this));
        offlineListElement.add(new SongsElement(this));
        offlineListElement.add(new SongsElement(this));
        offlineListElement.add(new SongsElement(this));
        offlineListElement.add(new SongsElement(this));
        offlineListElement.add(new SongsElement(this));
        offlineListElement.add(new SongsElement(this));
        offlineListElement.add(new SongsElement(this));

        elementListAdapter = new ElementListAdapter(offlineListElement, this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);

        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        android.support.v7.widget.SearchView searchView = (android.support.v7.widget.SearchView)menu.findItem(R.id.menu_search).getActionView();
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));

        searchView.setSuggestionsAdapter(suggestionAdapter);

        searchView.setOnQueryTextListener(new android.support.v7.widget.SearchView.OnQueryTextListener(){
            @Override
            public boolean onQueryTextSubmit(String query){
                return false;
            }
            @Override
            public boolean onQueryTextChange(String newText){
                getSuggestion(newText);
                return true;
            }
        });
        return true;
    }

    //Lấy dữ liệu từ db => đổ ra 1 list Song
    private void getSuggestion(String text){
        MatrixCursor c = new MatrixCursor(new String[]{BaseColumns._ID, "songName"});
        for(int i = 0; i < ListSong.getListSong().size(); i++ ){
            if(ListSong.getListSong().get(i).getSongName().toLowerCase().contains(text.toLowerCase())){
                c.addRow(new Object[] {i, ListSong.getListSong().get(i).getSongName()});
            }
        }
        c.addRow(new Object[]{1, ListSong.getListSong().get(0).getSongName()});
        suggestionAdapter.changeCursor(c);
    }
}
