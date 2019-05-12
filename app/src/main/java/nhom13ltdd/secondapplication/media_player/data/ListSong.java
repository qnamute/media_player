package nhom13ltdd.secondapplication.media_player.data;

import java.util.ArrayList;

import nhom13ltdd.secondapplication.media_player.element.Song;

public class ListSong {
    private static ArrayList<Song> listSong;

    public static  ArrayList<Song> getListSong(){
        if(listSong== null){
            listSong = new ArrayList<>();
        }
        return listSong;
    }
}
