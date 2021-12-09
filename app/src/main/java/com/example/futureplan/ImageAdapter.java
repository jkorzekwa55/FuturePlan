package com.example.futureplan;

import android.app.Activity;
import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter {
    public int[] images_id = {R.drawable.awatar1,R.drawable.awatar2,R.drawable.awatar3,R.drawable.awatar4,R.drawable.awatar5,R.drawable.awatar6,R.drawable.awatar7,R.drawable.awatar8,R.drawable.awatar9};
    Context ctx;
    ImageAdapter(Context ctx)
    {
        this.ctx = ctx;
    }
    @Override
    public int getCount() {
        return images_id.length;
    }

    @Override
    public Object getItem(int position) {
        return images_id[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            LayoutInflater inflater = ((Activity)ctx).getLayoutInflater();
            convertView = inflater.inflate(R.layout.custom_image_layout, parent,false);

        }
        ImageView i1 = convertView.findViewById(R.id.myImage);
        i1.setImageResource(images_id[position]);

        return convertView;
    }


}
