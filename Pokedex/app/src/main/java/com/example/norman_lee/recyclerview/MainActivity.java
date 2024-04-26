package com.example.norman_lee.recyclerview;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.gson.Gson;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    CharaAdapter charaAdapter;
    ImageView imageViewAdded;

    DataSource dataSource;

    final String KEY_DATA = "data";
    final String LOGCAT = "RV";
    final String PREF_FILE = "mainsharedpref";
    final int REQUEST_CODE_IMAGE = 1000;

    SharedPreferences mPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //TODO 11.1 Get references to the widgets
        recyclerView = findViewById(R.id.charaRecyclerView);
        imageViewAdded = findViewById(R.id.imageViewAdded);

        //TODO 12.7 Load the Json string from shared Preferences
        //TODO 12.8 Initialize your dataSource object with the Json string
        //TODO 11.2 Create your dataSource object by calling Utils.firstLoadImages
        mPreferences = getSharedPreferences(PREF_FILE, MODE_PRIVATE);
        Gson gson = new Gson();
        String json = mPreferences.getString(KEY_DATA, "");
        if( json.isEmpty() ){
            ArrayList<Integer> arrayListIds = new ArrayList<>();
            arrayListIds.add( R.drawable.pikachu);
            arrayListIds.add( R.drawable.psyduck);
            arrayListIds.add( R.drawable.squirtle);
            arrayListIds.add( R.drawable.spearow);
            arrayListIds.add( R.drawable.bulbasaur);
            dataSource = Utils.firstLoadImages(this, arrayListIds);
            Log.i("Apple","Load from drawables");
        }else{
            dataSource = gson.fromJson(json, LocalStorage.class);
            Log.i("Apple","Load from json");
        }
        //TODO 11.3 --> Go to CharaAdapter

        //TODO 11.8 Complete the necessary code to initialize your RecyclerView
        charaAdapter = new CharaAdapter(this, dataSource);
        recyclerView.setAdapter(charaAdapter);
        recyclerView.setLayoutManager(new GridLayoutManager(MainActivity.this, 3));

        //TODO 12.9 [OPTIONAL] Add code to delete a RecyclerView item upon swiping. See notes for the code.

        //TODO 12.1 Set up an Explicit Intent to DataEntry Activity with startActivityForResult (no coding)
        //TODO 12.5a Set up an Activity Launcher to process the data returned
        final ActivityResultLauncher<Intent> launcher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        // YOU SAY WHAT YOU WANT TO DO WHEN YOU GET THE RESULT
                        // get a Bundle object which contains the Extras
                        Bundle b = result.getData().getExtras();
                        String name = b.getString(DataEntry.KEY_NAME);
                        String path = b.getString(DataEntry.KEY_PATH);
                        dataSource.addData(name, path);
                        charaAdapter.notifyDataSetChanged();

                        // -- Displays the selected image at the big ? widget --
                        dataSource.putImageOnImageView(  dataSource.getSize()-1, imageViewAdded);
                    }
                }

        );

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, DataEntry.class);
                launcher.launch(intent);

            }
        });
    }

    //TODO 12.6 Complete onPause to store the DataSource object in SharedPreferences as a JSON string
    @Override
    protected void onPause(){
        super.onPause();
        SharedPreferences.Editor prefsEditor = mPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson( dataSource );
        prefsEditor.putString(KEY_DATA, json);
        prefsEditor.apply();
    }

    //TODO 12.5b Write onActivityResult to get the data passed back from DataEntry and add to DataSource object
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if( requestCode == REQUEST_CODE_IMAGE && resultCode == Activity.RESULT_OK){
        }


    }
}
