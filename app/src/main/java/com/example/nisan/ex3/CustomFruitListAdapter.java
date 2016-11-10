package com.example.nisan.ex3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by narzoan on 11/10/2016.
 */

public class CustomFruitListAdapter extends ArrayAdapter<String> {
    private final Context context;
    private final String[] values;

    public CustomFruitListAdapter(Context context, String[] values){
        super(context,R.layout.custom_list_item, values);
        this.context = context;
        this.values = values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.custom_list_item,parent,false);
        TextView textView = (TextView) rowView.findViewById(R.id.label_id);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.icon_id);

        textView.setText(values[position]);
        imageView.setImageResource(R.mipmap.ic_launcher);

        return rowView;
    }
}
