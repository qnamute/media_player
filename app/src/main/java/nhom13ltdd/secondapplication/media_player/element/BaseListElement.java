package nhom13ltdd.secondapplication.media_player.element;

import android.content.Context;
import android.view.View;

public abstract class BaseListElement {

    public Context context;

    private int iconResource;
    private String elementName;
    private int number;

    public int getIconResource() {
        return iconResource;
    }

    public void setIconResource(int iconResource) {
        this.iconResource = iconResource;
    }

    public String getElementName() {
        return elementName;
    }

    public void setElementName(String elementName) {
        this.elementName = elementName;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public abstract void updateData();

    public abstract View.OnClickListener getOnClickListenner();

}
