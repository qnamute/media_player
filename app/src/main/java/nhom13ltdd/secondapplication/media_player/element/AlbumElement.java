package nhom13ltdd.secondapplication.media_player.element;

import android.content.Context;
import android.view.View;

import nhom13ltdd.secondapplication.media_player.R;

public class AlbumElement extends BaseListElement {

    public  AlbumElement(Context context){
        updateData();
        this.context = context;
    }

    @Override
    public void updateData() {
        this.setNumber(0);
        this.setElementName("Album");
        this.setIconResource(R.drawable.ic_play);
    }

    @Override
    public View.OnClickListener getOnClickListenner() {
        return null;
    }
}
