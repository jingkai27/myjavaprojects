package com.example.bloopyoctopus;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class BitmapBank {

    Bitmap background_game;

    Bitmap [] octopus;

    public BitmapBank(Resources resources){
        // 2 mins, vid 8
        background_game = BitmapFactory.decodeResource(resources, R.drawable.backie);
        background_game = scaleImage(background_game);
        octopus = new Bitmap[1];
        octopus[0] = BitmapFactory.decodeResource(resources, R.drawable.octo);
        // Define your desired width and height
        int desiredWidth = 250; // specify your desired width
        int desiredHeight = 250; // specify your desired height

        // Resize the bitmap
        octopus[0] = Bitmap.createScaledBitmap(octopus[0], desiredWidth, desiredHeight, true);

    }

    public Bitmap getOcto (int frame){
        return octopus[frame];
    }

    public int getOctoWidth(){
        return octopus[0].getWidth();
    }

    public int getOctoHeight(){
        return octopus[0].getHeight();
    }


    public Bitmap getBackground_game(){
        return background_game;
    }

    // return background width
    public int getBackgroundWidth(){
        return background_game.getWidth();
    }

    //return background height
    public int getBackgroundHeight(){
        return background_game.getHeight();
    }

    public Bitmap scaleImage(Bitmap bitmap){
        float widthHeightRatio = getBackgroundWidth()/getBackgroundHeight();
        // call createScaledBitmap() to create new bitmap

        int backgroundScaleWidth = (int) widthHeightRatio * AppConstants.SCREEN_HEIGHT;
        return Bitmap.createScaledBitmap(bitmap, backgroundScaleWidth, AppConstants.SCREEN_HEIGHT, false);
    }
}
