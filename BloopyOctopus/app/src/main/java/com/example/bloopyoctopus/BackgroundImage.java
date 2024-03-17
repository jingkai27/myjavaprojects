package com.example.bloopyoctopus;

public class BackgroundImage {

    private int backgroundImageX, backgroundImageY, backgroundVelocity;

    public BackgroundImage(){
        backgroundImageX = 0;
        backgroundImageY = 0;
        backgroundVelocity = 4;
    }

    public int getX(){
        return backgroundImageX;
    }

    public int getY(){
        return backgroundImageY;
    }

    public void setX(int x){
        this.backgroundImageX = x;
    }

    public void setY(int y){
        this.backgroundImageY = y;
    }

    public int getVelocity(){
        return backgroundVelocity;
    }
    public void setVelocity(int s){
        this.backgroundVelocity = s;
    }

}
