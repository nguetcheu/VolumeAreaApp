package com.example.volumeareaapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

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

    // GetView(): Used to create and return a view for a specific item in Grid

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        // 1- Get the shape objet for the current position
        Shape shapes = getItem(position);

        // 2- Inflating Layout:
        MyViewHolder myViewHolder;

        if (convertView == null){
            // No view went off-screen --> Create a new view
            myViewHolder = new MyViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());

            convertView = inflater.inflate(
                    R.layout.grid_item_layout,
                    parent,
                    false
            );

            // Finding the views
            myViewHolder.shapeName = (TextView) convertView.findViewById(R.id.textView);
            myViewHolder.shapeImg = (ImageView) convertView.findViewById(R.id.imageView);

            convertView.setTag(myViewHolder);
        } else {
            // a view went off-screen --> re-use it
            myViewHolder = (MyViewHolder) convertView.getTag();
        }

        myViewHolder.shapeName.setText(shapes.shapeName);
        myViewHolder.shapeImg.setImageResource(shapes.shapeImg);
        return convertView;
    }
}
