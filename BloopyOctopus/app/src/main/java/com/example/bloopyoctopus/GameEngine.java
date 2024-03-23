package com.example.bloopyoctopus;

import android.graphics.Canvas;

public class GameEngine {
    BackgroundImage backgroundImage;

    Octopus octopus;

    static int gameState;

    public GameEngine (){
        backgroundImage = new BackgroundImage();
        octopus = new Octopus();

        //0: Not started
        //1: Start
        //2: Game Over
        gameState = 0;
    }

    public void updateAndDrawableBackgroundImage(Canvas canvas){
        backgroundImage.setX(backgroundImage.getX() -backgroundImage.getVelocity());
        if (backgroundImage.getX() <- AppConstants.getBitmapBank().getBackgroundWidth()){
            backgroundImage.setX(0);
        }
        canvas.drawBitmap(AppConstants.getBitmapBank().getBackground_game(), backgroundImage.getX(),
                backgroundImage.getY(),null);

        if (backgroundImage.getX() <- (AppConstants.getBitmapBank().getBackgroundWidth() - AppConstants.SCREEN_WIDTH)){
            canvas.drawBitmap(AppConstants.getBitmapBank().getBackground_game(),
                    backgroundImage.getX()+AppConstants.getBitmapBank().getBackgroundWidth(),
                    backgroundImage.getY(),
                    null);
        }
    }
    public void updateAndDrawOctopus (Canvas canvas){
        if (gameState == 1){
            if (octopus.getOctopusY() < (AppConstants.SCREEN_HEIGHT - AppConstants.getBitmapBank().getOctoHeight())
            || octopus.getVelocity() < 0){
                octopus.setVelocity(octopus.getVelocity() + AppConstants.gravity);
                octopus.setOctopusY(octopus.getOctopusX() + octopus.getVelocity());
            }

        }
        if (octopus.getOctopusY() <(AppConstants.SCREEN_HEIGHT) - AppConstants.getBitmapBank().getOctoHeight()){
            octopus.setVelocity(octopus.getVelocity()+AppConstants.gravity);
            octopus.setOctopusY(octopus.getOctopusY() + octopus.getVelocity());
        }

        int currentFrame = octopus.getCurrentFrame();
        canvas.drawBitmap(AppConstants.getBitmapBank().getOcto(currentFrame),
                octopus.getOctopusX(),
                octopus.getOctopusY(),
                null);
        currentFrame++;
        if (currentFrame > octopus.maxFrame){
            currentFrame = 0;
        }
        octopus.setCurrentFrame(currentFrame);
    }
}
