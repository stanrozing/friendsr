package com.example.rozin.friendsr;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rozin on 20-2-2018.
 */

public class FriendsAdapter extends ArrayAdapter<Friend> {

    // declare your list of friends
    private ArrayList friends;

    // put the friends in the list
    public FriendsAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Friend> objects) {
        super(context, resource, objects);
        friends = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        // instantiate your views and friend
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.grid_item, parent, false);
        }
        ImageView image = convertView.findViewById(R.id.imageView);
        TextView text = convertView.findViewById(R.id.textView);
        Friend f = (Friend)friends.get(position);

        // make sure the correct name and image appear
        text.setText(f.getName());
        image.setImageResource(f.getDrawableId());

        return convertView;
    }
}
