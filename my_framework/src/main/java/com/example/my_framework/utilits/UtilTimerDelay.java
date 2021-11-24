package com.example.my_framework.utilits;

public class UtilTimerDelay {

    double startTime;
    double nowTime;
    double elapsedTime;
    final double SECOND = 1000000000;

    public void startTime(){

        startTime = System.nanoTime()/SECOND;

    }

    public boolean timerDelay(Double second){

        nowTime = System.nanoTime()/SECOND;
        elapsedTime = nowTime - startTime;
        if(elapsedTime>second){

            return true;

        }
        return false;

    }

}
