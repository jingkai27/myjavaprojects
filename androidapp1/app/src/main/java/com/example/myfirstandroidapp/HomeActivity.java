package com.example.myfirstandroidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;


//TODO 1.1 Put in some images in the drawables folder
//TODO 1.2 Go to activity_main.xml and modify the layout

public class HomeActivity extends AppCompatActivity {

    //TODO 1.2 Instance variables are declared for you, please import the libraries
    ArrayList<Integer> images;
    Button charaButton;
    ImageView charaImage;
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //TODO 1.3 Instantiate An ArrayList object
        //TODO 1.4 Add the image IDs to the ArrayList
        images = new ArrayList<>();
        images.add(R.drawable.anya);
        images.add(R.drawable.edogawaconan);
        images.add(R.drawable.nickwilde);
        images.add(R.drawable.ashketchum);
        //TODO 1.5 Get references to the charaButton and charaImage widgets using findViewById
        charaButton = findViewById(R.id.charaButton);
        charaImage = findViewById(R.id.charaImageView);
        //TODO 1.6 For charaButton, invoke the setOnClickListener method
        charaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("TAG", "Button is clicked");
                int index = count % images.size();
                count = count + 1;
                int image_id = images.get(index);

                charaImage.setImageResource(image_id);
            }
        });
    }
}

        //TODO 1.7 Create an anonymous class which implements View.OnClickListener interface
        //TODO 1.8 Within onClick, write code to randomly select an image ID from the ArrayList and display it in the ImageView
        //TODO 1.9 [On your own] Create another button, which when clicked, will cause one image to always be displayed