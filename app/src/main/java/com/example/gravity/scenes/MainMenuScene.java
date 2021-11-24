package com.example.gravity.scenes;
import android.graphics.Color;

import com.example.gravity.R;
import com.example.gravity.Utilits.UtilResource;
import com.example.my_framework.CoreFW;
import com.example.my_framework.SceneFW;

public class MainMenuScene extends SceneFW {

    public MainMenuScene(CoreFW coreFW) {
        super(coreFW);
    }

    @Override
    public void update() {
        if(coreFW.getTouchListenerFW().getTouchUp(250,250,100,50)){
            coreFW.setScene(new GameScene(coreFW));
            UtilResource.touch.play(1);
        }

        if(coreFW.getTouchListenerFW().getTouchUp(250,450,250,50)) {
            coreFW.setScene(new TopDistance(coreFW));
            UtilResource.touch.play(1);
        }

    }

    @Override
    public void drawing() {
        graphicsFW.clearScene(Color.BLACK);
        graphicsFW.drawText(coreFW.getString(R.string.txt_mainMenu_nameGame),200, 120,coreFW.getColor(R.color.Honeydew), 70,null );
        graphicsFW.drawText(coreFW.getString(R.string.txt_mainMenu_newGame), 250, 230,coreFW.getColor(R.color.MediumBlue), 50,null );
        graphicsFW.drawText(coreFW.getString(R.string.txt_mainMenu_settings), 250, 300,coreFW.getColor(R.color.MediumBlue), 50,null );
        graphicsFW.drawText(coreFW.getString(R.string.txt_mainMenu_present), 250, 380,coreFW.getColor(R.color.Red), 50,null );
        graphicsFW.drawText(coreFW.getString(R.string.txt_mainMenu_exitGame), 20, 600, coreFW.getColor(R.color.Honeydew), 50,null );
        graphicsFW.drawText(coreFW.getString(R.string.txt_mainMenu_results), 250, 450, coreFW.getColor(R.color.Honeydew), 50,null );
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {

    }
}


