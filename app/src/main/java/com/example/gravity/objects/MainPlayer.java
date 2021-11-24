package com.example.gravity.objects;

import android.graphics.Rect;

import com.example.gravity.clases.GameManager;
import com.example.my_framework.AnimationFW;
import com.example.my_framework.CoreFW;
import com.example.my_framework.GraphicsFW;
import com.example.my_framework.ObjectFW;
import com.example.gravity.Utilits.UtilResource;
import com.example.my_framework.utilits.UtilTimerDelay;

public class MainPlayer extends ObjectFW {
    final  int GRAVITY = -3;
    final int MAX_SPEED=15;
    final int MIN_SPEED=1;
    AnimationFW animMainPlayer;
    AnimationFW animMainPlayerBoost;
    AnimationFW animExplosionPlayer;
    CoreFW coreFW;
    UtilTimerDelay timeronShealdHit;
    UtilTimerDelay timerOnGameOver;
    boolean boosting;

    private int ShieldsPlayer;
    boolean hitEnemy;
    boolean isGameOver;

    public MainPlayer(CoreFW coreFW,int maxScreenX, int maxScreenY, int minScreenY) {
        x=250;
        y=390;
        speed =3;
        boosting=false;
        hitEnemy = false;

        timerOnGameOver = new UtilTimerDelay();
        isGameOver = false;

        timeronShealdHit = new UtilTimerDelay();

        radius = UtilResource.spritePlayer.get(0).getHeight()/5;

        ShieldsPlayer = 3;
        this.coreFW=coreFW;
        this.maxScreenX=maxScreenX - UtilResource.spritePlayer.get(0).getWidth();
        this.maxScreenY= maxScreenY;
        this.minScreenX = minScreenY;

        animMainPlayer =new AnimationFW(speed,UtilResource.spritePlayer.get(0),
                UtilResource.spritePlayer.get(1),
                UtilResource.spritePlayer.get(2),
                UtilResource.spritePlayer.get(3));
        animMainPlayerBoost =new AnimationFW(speed,UtilResource.spritePlayerBoost.get(0),
                UtilResource.spritePlayerBoost.get(1),
                UtilResource.spritePlayerBoost.get(2),
                UtilResource.spritePlayerBoost.get(3));
        animExplosionPlayer = new AnimationFW (speed,UtilResource.spriteExplosinPlayer.get(0),
                UtilResource.spriteExplosinPlayer.get(1),
                UtilResource.spriteExplosinPlayer.get(2),
                UtilResource.spriteExplosinPlayer.get(3));
    }

    public  void update(){
        if (coreFW.getTouchListenerFW().getTouchDown(0,maxScreenY,maxScreenX,maxScreenY)){
            startBoosting();
        }
        if (coreFW.getTouchListenerFW().getTouchUp(0,maxScreenY,maxScreenX,maxScreenY)){
            stopBoosting();
        }

        if (boosting){
            speed+=0.1;
        }else speed-=5;
        if (speed>MAX_SPEED){
            speed=MAX_SPEED;
        }
        if (speed<MIN_SPEED){
            speed=MIN_SPEED;
        }

        x-=speed+GRAVITY;
        if (x<minScreenY){
            x=minScreenY;
        }
        if (x>maxScreenY){
            x=maxScreenY;
        }

        if (boosting){
            animMainPlayerBoost.runAnimation();
        } else animMainPlayer.runAnimation();

        hitBox = new Rect(x, y, UtilResource.spritePlayer.get(0).getWidth(),UtilResource.spritePlayer.get(0).getHeight());
        if(isGameOver){

            animExplosionPlayer.runAnimation();

        }
    }

    private void stopBoosting() {
        boosting=false;
    }

    private void startBoosting() {
        boosting = true;
    }

    public void drawing(GraphicsFW graphicsFW){

        if(!isGameOver){

        if(!hitEnemy) {

            if (boosting) {
                animMainPlayerBoost.drawingAnimation(graphicsFW, x, y);
            } else animMainPlayer.drawingAnimation(graphicsFW, x, y);
        }else {

            graphicsFW.drawTexture(UtilResource.shieldHitEnemy, x, y);
            if (timeronShealdHit.timerDelay(0.2)) {
                hitEnemy = false;
            } else hitEnemy = true;
        }
        }else{
            animExplosionPlayer.drawingAnimation(graphicsFW, x, y);
            if(timerOnGameOver.timerDelay(0.5)){

                GameManager.gameOver = true;

            }
        }
    }

    public double getSpeedPlayer(){
        return speed;
    }

    public int getShieldsPlayer() {

        return ShieldsPlayer;
    }

    public void hitEnemy() {
        if(ShieldsPlayer==0){
            UtilResource.explode.play(1);
            isGameOver = true;
            timerOnGameOver.startTime();

        }
        if(ShieldsPlayer>0) {
            ShieldsPlayer--;

        }
        hitEnemy = true;
        timeronShealdHit.startTime();

    }
}

