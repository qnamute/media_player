package nhom13ltdd.secondapplication.media_player.element;

import android.content.Context;
import android.view.View;

import nhom13ltdd.secondapplication.media_player.R;

public class SongsElement extends BaseListElement {

    public  SongsElement(Context context){
        updateData();
        this.context = context;
    }

    @Override
    public void updateData() {
        this.setElementName("Songs");
        this.setIconResource(R.drawable.ic_search);
        this.setNumber(0);
    }

    @Override
    public View.OnClickListener getOnClickListenner() {
        return null;
    }
}
