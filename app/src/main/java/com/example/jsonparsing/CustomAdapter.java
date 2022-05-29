package com.example.jsonparsing;

import static java.security.AccessController.getContext;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;

public class CustomAdapter extends BaseAdapter {

    private ArrayList<HashMap<String, String>> dataSet;
    Context mContext;

    // View lookup cache
    private static class ViewHolder {
        TextView txtName, txtShowToTime, txtShowFromTime, txtShowDesc;
        ImageView ivLogo;

    }

    public CustomAdapter(ArrayList data, Context context) {
        //super(context, R.layout.list_item, data);
        Log.e("DS","%%%");
        this.dataSet = data;
        this.mContext = context;
    }

    @Override
    public int getCount() {
        return dataSet.size();
    }

    @Nullable
    @Override
    public HashMap<String, String> getItem(int position) {
        return dataSet.get(position);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder; // view lookup cache stored in tag

        if (convertView == null) {

            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(mContext.getApplicationContext());
            convertView = inflater.inflate(R.layout.list_item, parent, false);
            viewHolder.txtName = (TextView) convertView.findViewById(R.id.txtShowTitle);
            viewHolder.txtShowToTime = (TextView) convertView.findViewById(R.id.txtShowEndTime);
            viewHolder.txtShowFromTime = (TextView) convertView.findViewById(R.id.txtShowStartTime);
            viewHolder.txtShowDesc = (TextView) convertView.findViewById(R.id.txtShowDesc);
            viewHolder.ivLogo = (ImageView)convertView.findViewById(R.id.ivShowImage);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.txtName.setText(getItem(position).get("show_title"));
        viewHolder.txtShowToTime.setText(getItem(position).get("end_time"));
        viewHolder.txtShowFromTime.setText(getItem(position).get("start_time"));
        viewHolder.txtShowDesc.setText(getItem(position).get("description"));
        Picasso.with(mContext).load(getItem(position).get("image")).into(viewHolder.ivLogo);
        //viewHolder.ivLogo.set(getItem(position).get("show_title"));
        // Return the completed view to render on screen
        return convertView;
    }

}
