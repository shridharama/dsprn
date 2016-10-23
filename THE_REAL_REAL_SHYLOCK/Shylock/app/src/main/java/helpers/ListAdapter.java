package helpers;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.shylock.shylock.R;

import java.util.List;

/**
 * Created by achint on 10/23/16.
 */

public class ListAdapter extends ArrayAdapter<Content> {
    private Typeface mTypeFaceLight;
    private Typeface mTypeFaceRegular;

    public ListAdapter(Context context, List<Content> objects) {
        super(context, 0, objects);

        mTypeFaceLight = Typeface.createFromAsset(context.getAssets(), "OpenSans-Light.ttf");
        mTypeFaceRegular = Typeface.createFromAsset(context.getAssets(), "OpenSans-Regular.ttf");
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Content c = getItem(position);
        ViewHolder holder = null;

        if(convertView == null) {
            holder = new ViewHolder();

            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, null);
            holder.tvName = (TextView) convertView.findViewById(R.id.tvName);
            holder.tvDesc = (TextView) convertView.findViewById(R.id.tvDesc);

            convertView.setTag(holder);

        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.tvName.setTypeface(mTypeFaceRegular.DEFAULT_BOLD);
        holder.tvDesc.setTypeface(mTypeFaceRegular.DEFAULT_BOLD);

        holder.tvName.setText(c.name);
        holder.tvDesc.setText(c.desc);



        return convertView;

    }

    private class ViewHolder {
        TextView tvName, tvDesc;
    }
}
