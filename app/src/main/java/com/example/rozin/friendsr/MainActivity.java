package com.example.rozin.friendsr;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // initiate a list with friends
    ArrayList<Friend> friends = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // create all of the friends and add them to the list
        Friend Arya = new Friend("Arya", "I am no one", R.drawable.arya);
        friends.add(Arya);
        Friend Cersei = new Friend("Cersei", "I am the Queen", R.drawable.cersei);
        friends.add(Cersei);
        Friend Daenerys = new Friend("Daenerys", "Daenerys of the House Targaryen, the First of Her Name, The Unburnt, Queen of the Andals, the Rhoynar and the First Men, Queen of Meereen, Khaleesi of the Great Grass Sea, Protector of the Realm, Lady Regnant of the Seven Kingdoms, Breaker of Chains and Mother of Dragons", R.drawable.daenerys);
        friends.add(Daenerys);
        Friend Jaime = new Friend("Jaime", "One handed king-slayer", R.drawable.jaime);
        friends.add(Jaime);
        Friend Jon = new Friend("Jon", "I am just a bastard", R.drawable.jon);
        friends.add(Jon);
        Friend Jorah = new Friend("Jorah", "I serve Khaleesi", R.drawable.jorah);
        friends.add(Jorah);
        Friend Margaery = new Friend("Margaery", "R.I.P.", R.drawable.margaery);
        friends.add(Margaery);
        Friend Melisandre = new Friend("Melisandre", "I serve the lord of light", R.drawable.melisandre);
        friends.add(Melisandre);
        Friend Sansa = new Friend("Sansa", "Lady of Winterfell", R.drawable.sansa);
        friends.add(Sansa);
        Friend Tyrion = new Friend("Tyrion", "Proud Dwarf and hand of the Queen", R.drawable.tyrion);
        friends.add(Tyrion);

        // Set the adapter and listener to your gridview
        FriendsAdapter adapter = new FriendsAdapter(this, R.layout.grid_item, friends);
        GridView gridview = findViewById(R.id.gridview);
        gridview.setAdapter(adapter);
        gridview.setOnItemClickListener(new GridItemClickListener());

    }

    private class GridItemClickListener implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            // get the friend you clicked on
            Friend clickedFriend = (Friend) adapterView.getItemAtPosition(i);

            // start ProfileActivity and remember the friend
            Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
            intent.putExtra("clicked_friend", clickedFriend);
            startActivity(intent);

        }
    }



}
