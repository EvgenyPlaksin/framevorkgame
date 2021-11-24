package com.example.gravity.objects;

import com.example.my_framework.ObjectFW;
import com.example.my_framework.utilits.UtilRandomFW;

public class Star extends ObjectFW {

    public Star(int sceneWidth, int sceneHeight, int minScreenY) {
        this.maxScreenX = sceneWidth;
        this.maxScreenY = sceneHeight;
        this.minScreenX = minScreenY;
        this.minScreenY = 0;
        this.speed = 2;
        this.x = UtilRandomFW.getGap(minScreenX,maxScreenX );
        this.y = UtilRandomFW.getCasualNumber(maxScreenY);
    }

    public void update(double speedPlayer){
        y+=speedPlayer;
        y+=speed;
        if(y>maxScreenY){
            y = minScreenY;
            x = UtilRandomFW.getGap(minScreenX,maxScreenX );
        }
    }
    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }
}
