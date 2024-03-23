package com.example.bloopyoctopus;

public class Octopus {

    private int octopusX, octopusY, currentFrame, velocity;

    public static int maxFrame;
    public Octopus(){
        octopusX = AppConstants.SCREEN_WIDTH/2-AppConstants.getBitmapBank().getOctoWidth()/2;
        octopusY = AppConstants.SCREEN_HEIGHT/2-AppConstants.getBitmapBank().getOctoHeight()/2;

        currentFrame = 0;
        maxFrame=0;
        velocity = 0;
    }

    public int getCurrentFrame(){
        return currentFrame;
    }

    public void setCurrentFrame(int currentFrame){
        this.currentFrame = currentFrame;
    }

    public int getVelocity(){
        return velocity;
    }

    public void setVelocity(int velocity){
        this.velocity = velocity;
    }
    public int getOctopusX(){
        return octopusX;
    }

    public int getOctopusY(){
        return octopusY;
    }

    public void setOctopusX(int octopusX){
        this.octopusX = octopusX;
    }

    public void setOctopusY (int octopusY){
        this.octopusY = octopusY;
    }
}
