package nhom13ltdd.secondapplication.media_player.adapter;

import android.content.Context;
import android.media.Image;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

import nhom13ltdd.secondapplication.media_player.R;
import nhom13ltdd.secondapplication.media_player.element.BaseListElement;

public class ElementListAdapter extends BaseAdapter {

    public List<BaseListElement> listElements;

    public Context context;

    public ElementListAdapter(List<BaseListElement> listElements, Context context){
        this.listElements = listElements;
        this.context = context;
    }

    @Override
    public int getCount() {
        return listElements.size();
    }

    @Override
    public Object getItem(int position) {
        return listElements.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView icon;
        TextView elementName,elementNumber;
        convertView = View.inflate(context, R.layout.list_item, null);
        icon = (ImageView)convertView.findViewById(R.id.image);
        elementName = (TextView)convertView.findViewById(R.id.element_name);
        elementNumber = (TextView)convertView.findViewById(R.id.element_number);
        icon.setImageResource(listElements.get(position).getIconResource());
        elementName.setText(listElements.get(position).getElementName());
        elementNumber.setText(String.valueOf(listElements.get(position).getNumber()));
        return  convertView;
    }
}
