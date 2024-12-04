package com.example.volumeareaapp;

import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;

// The class will be responsible for creating
// the view for each item and binding data to it
public class MyCustomAdapter extends ArrayAdapter<Shape> {

    private ArrayList<Shape> shapeArrayList;
    private Context context;

    public MyCustomAdapter(@NonNull Context context,ArrayList<Shape> shapeArrayList) {
        super(context, R.layout.grid_item_layout, shapeArrayList);
        this.context = context;
        this.shapeArrayList = shapeArrayList;
    }

    // View Holder: Used to cache references to the views within an item layout
    private static class MyViewHolder {
        TextView shapeName;
        ImageView shapeImg;
    }
}
