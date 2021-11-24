package com.example.gravity.scenes;

import android.graphics.Color;

import com.example.gravity.R;
import com.example.gravity.Utilits.SettingGame;
import com.example.gravity.Utilits.UtilResource;
import com.example.gravity.clases.GameManager;
import com.example.gravity.generator.GeneratorBackground;
import com.example.my_framework.CoreFW;
import com.example.my_framework.SceneFW;


public class GameScene extends SceneFW {

    enum GameState {
        READY, RUNNING, PAUSE, GAMEOVER
    }

    GameState gameState;

    GameManager gameManager;

    public GameScene(CoreFW coreFW) {
        super(coreFW);
        gameState = GameState.READY;

        gameManager=new GameManager(coreFW, sceneWidth,sceneHeight);

        UtilResource.gameMusic.play(true, 1f);
    }

    @Override
    public void update() {
        if (gameState == GameState.READY) {
            updateStateReady();
        }
        if (gameState == GameState.RUNNING) {
            updateStateRunning();
        }
        if (gameState == GameState.PAUSE) {
            updateStatePause();
        }
        if (gameState == GameState.GAMEOVER) {
            updateStateGameOver();
        }
    }

    private void updateStateGameOver() {

        SettingGame.addDistance(gameManager.getPassedDistance());
        if(coreFW.getTouchListenerFW().getTouchUp(265, 300,100, 55)){

            coreFW.setScene(new GameScene(coreFW));


        }
        if(coreFW.getTouchListenerFW().getTouchUp(265, 380, 100, 55)){

           coreFW.setScene(new MainMenuScene(coreFW));


        }
    }

    private void updateStatePause() {
    }

    private void updateStateRunning() {



        gameManager.update();
        if(GameManager.gameOver){

            gameState = GameState.GAMEOVER;

        }

    }

    private void updateStateReady() {

        if(coreFW.getTouchListenerFW().getTouchUp(0, sceneHeight, sceneWidth, sceneHeight)){

            gameState = GameState.RUNNING;



        }
    }

    @Override
    public void drawing() {

        if (gameState==GameState.READY){
            drawingStateReady();
        }

        if (gameState==GameState.RUNNING){
            drawingStateRunning();
        }

        if (gameState==GameState.PAUSE){
            drawingStatePause();
        }

        if (gameState==GameState.GAMEOVER){
            drawingStateGameOver();
        }
    }

    private void drawingStateReady() {
        graphicsFW.clearScene(Color.BLACK);
        graphicsFW.drawText(coreFW.getString(R.string.txt_GameScene_stateReady), 250, 300, coreFW.getColor(R.color.Honeydew), 60, null);
    }

    private void drawingStateGameOver() {

        graphicsFW.clearScene(Color.BLACK);
        graphicsFW.drawText(coreFW.getString(R.string.txt_gameSceneGameOver_gameOver), 162, 150, coreFW.getColor(R.color.purple_500), 80, null);
        graphicsFW.drawText(coreFW.getString(R.string.txt_gameSceneGameOver_restart), 265, 300, coreFW.getColor(R.color.Honeydew), 50, null);
        graphicsFW.drawText(coreFW.getString(R.string.txt_gameSceneGameOver_exit), 265, 380, coreFW.getColor(R.color.Honeydew), 50, null);
        graphicsFW.drawText(coreFW.getString(R.string.txt_gameSceneGameOver_distance) + " "+gameManager.getPassedDistance(), 138, 220, coreFW.getColor(R.color.Honeydew), 45, null);
    }

    private void drawingStatePause() {
    }

    private void drawingStateRunning() {
        graphicsFW.clearScene(Color.BLACK);



        gameManager.drawing(coreFW, graphicsFW);
    }

    @Override
    public void pause() {

        UtilResource.gameMusic.stop();
    }

    @Override
    public void resume() {

        UtilResource.gameMusic.play(true, 0.5f);

    }

    @Override
    public void dispose() {

        UtilResource.explode.dispose();
        UtilResource.hit.dispose();
        UtilResource.touch.dispose();
        UtilResource.gameMusic.dispose();

    }
}

