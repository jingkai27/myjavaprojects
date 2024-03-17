package com.example.bloopyoctopus;

import android.graphics.Canvas;

public class GameEngine {
    BackgroundImage backgroundImage;

    public GameEngine (){
        backgroundImage = new BackgroundImage();
    }

    public void updateAndDrawableBackgroundImage(Canvas canvas){
        backgroundImage.setX(backgroundImage.getX() -backgroundImage.getVelocity());
        if (backgroundImage.getX() <- AppConstants.getBitmapBank().getBackgroundWidth()){
            backgroundImage.setX(0);
        }
        canvas.drawBitmap(AppConstants.getBitmapBank().getBackground(), backgroundImage.getX(),
                backgroundImage.getY(),null);

    }
}
