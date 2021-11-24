package com.example.gravity.objects;

import android.graphics.Color;

import com.example.gravity.R;
import com.example.my_framework.CoreFW;
import com.example.my_framework.GraphicsFW;

public class HUD {

    private int passedDistance;
    private int currentSpeedPlayer;
    private int currentShieldsPlayer;

    CoreFW coreFW;

    private final int HEIGHT_HUG = 40;

    public HUD(CoreFW coreFW) {
        this.coreFW = coreFW;
    }

    public void update(int passedDistance, int currentSpeedPlayer, int currentShieldsPlayer){

        this.currentShieldsPlayer = currentShieldsPlayer;
        this.currentSpeedPlayer = currentSpeedPlayer;
        this.passedDistance = passedDistance;

    }

    public void drawing(GraphicsFW graphicsFW){

        graphicsFW.drawLine(0, HEIGHT_HUG, graphicsFW.getWidthFrameBuffer(), HEIGHT_HUG, coreFW.getColor(R.color.Honeydew));
        graphicsFW.drawText(coreFW.getString(R.string.txt_hud_passedDistance)+":"+passedDistance, 10, 30, Color.GREEN, 25, null);
        graphicsFW.drawText(coreFW.getString(R.string.txt_hud_currentSpeedPlayer)+":"+currentSpeedPlayer, 350, 30, Color.GREEN, 25, null);
        graphicsFW.drawText(coreFW.getString(R.string.txt_hud_currentShieldsPlayer)+":"+currentShieldsPlayer, 660, 30, Color.GREEN, 25, null);
    }

    public int getHEIGHT_HUG(){

        return HEIGHT_HUG;

    }

}
