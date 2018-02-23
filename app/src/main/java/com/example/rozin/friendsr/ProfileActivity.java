package com.example.rozin.friendsr;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {

    // declare retrievedfriend here so it cn be used in the entire class
    private Friend retrievedFriend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        // make retrievedfriend the friend you clicked on in MainActivity
        Intent intent = getIntent();
        retrievedFriend = (Friend) intent.getSerializableExtra("clicked_friend");

        // instantiate the views and rating bar
        ImageView pic = findViewById(R.id.imageViewPic);
        RatingBar Rbar = findViewById(R.id.ratingBar);
        TextView name = findViewById(R.id.textViewName);
        TextView bio = findViewById(R.id.textViewBio);

        // make sure the correct picture, name and bio appears
        pic.setImageResource(retrievedFriend.getDrawableId());
        name.setText(retrievedFriend.getName());
        bio.setText(retrievedFriend.getBio());

        // set listener on the ratingbar
        Rbar.setOnRatingBarChangeListener(new OnRatingBarChangeListener());

        // check if there is a saved rating for this friend and apply it
        SharedPreferences prefs = getSharedPreferences("settings", MODE_PRIVATE);
        float rating = prefs.getFloat(retrievedFriend.getName(), 0);
        if(rating != 0) {
            retrievedFriend.setRating(rating);
            Rbar.setRating(rating);
        }



    }

    private class OnRatingBarChangeListener implements RatingBar.OnRatingBarChangeListener {
        @Override
        public void onRatingChanged(RatingBar ratingBar, float rating, boolean b) {

            // put the rating in the sharedPreferences
            SharedPreferences.Editor editor = getSharedPreferences("settings", MODE_PRIVATE).edit();
            editor.putFloat(retrievedFriend.getName(), rating);
            editor.apply();

            // set the rating of the friend on the correct value
            retrievedFriend.setRating(rating);
        }
    }
}
