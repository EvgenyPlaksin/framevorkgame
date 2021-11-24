package com.example.gravity.clases;

import com.example.my_framework.CoreFW;
import com.example.my_framework.GraphicsFW;
import com.example.gravity.Utilits.UtilResource;

import java.util.ArrayList;

public class LoaderAssets  {
    public LoaderAssets(CoreFW coreFW, GraphicsFW graphicsFW) {
        loadTexture(graphicsFW);
        loadSpritePlayer(graphicsFW);
        loadSpriteEnemy(graphicsFW);
        loadOther(graphicsFW);
        loadAudio(coreFW);

    }

    private void loadAudio(CoreFW coreFW) {
        UtilResource.gameMusic = coreFW.getAudioFW().newMusic("muzyka-dlya-fona_-_skazochnaya-muzyka (1).mp3");
        UtilResource.hit = coreFW.getAudioFW().newSound("hit.mp3");
        UtilResource.touch = coreFW.getAudioFW().newSound("touch.mp3");
        UtilResource.explode = coreFW.getAudioFW().newSound("dead.mp3");
    }

    private void loadOther(GraphicsFW graphicsFW) {

        UtilResource.shieldHitEnemy = graphicsFW.newSprite(UtilResource.textureAtlas,
                254, 0,125, 44);

    }

    private void loadSpriteEnemy(GraphicsFW graphicsFW) {
        UtilResource.spriteEnemy = new ArrayList<>();
        UtilResource.spriteEnemy.add(graphicsFW.newSprite(UtilResource.textureAtlas,0,106,
                125,64));
        UtilResource.spriteEnemy.add(graphicsFW.newSprite(UtilResource.textureAtlas,128,106,
                125,64));
        UtilResource.spriteEnemy.add(graphicsFW.newSprite(UtilResource.textureAtlas,256,106,
                125,64));
        UtilResource.spriteEnemy.add(graphicsFW.newSprite(UtilResource.textureAtlas,384,106,
                125,64));
    }

    private void loadSpritePlayer(GraphicsFW graphicsFW) {
        UtilResource.spritePlayer=new ArrayList<>();
        UtilResource.spritePlayerBoost=new ArrayList<>();
        UtilResource.spriteExplosinPlayer = new ArrayList<>();

        UtilResource.spriteExplosinPlayer.add(graphicsFW.newSprite(UtilResource.textureAtlas,0,212,
                120,40));
        UtilResource.spriteExplosinPlayer.add(graphicsFW.newSprite(UtilResource.textureAtlas,123,212,
                120,40));
        UtilResource.spriteExplosinPlayer.add(graphicsFW.newSprite(UtilResource.textureAtlas,257,212,
                120,40));
        UtilResource.spriteExplosinPlayer.add(graphicsFW.newSprite(UtilResource.textureAtlas,378,212,
                120,40));

        UtilResource.spritePlayer.add(graphicsFW.newSprite(UtilResource.textureAtlas,0,0,
                130,40));
        UtilResource.spritePlayer.add(graphicsFW.newSprite(UtilResource.textureAtlas,0,0,
                130,40));
        UtilResource.spritePlayer.add(graphicsFW.newSprite(UtilResource.textureAtlas,0,0,
                130,40));
        UtilResource.spritePlayer.add(graphicsFW.newSprite(UtilResource.textureAtlas,0,0,
                130,40));
        UtilResource.spritePlayerBoost.add(graphicsFW.newSprite(UtilResource.textureAtlas,118,0,
                150,40));
        UtilResource.spritePlayerBoost.add(graphicsFW.newSprite(UtilResource.textureAtlas,118,0,
                150,40));
        UtilResource.spritePlayerBoost.add(graphicsFW.newSprite(UtilResource.textureAtlas,118,0,
                150,40));
        UtilResource.spritePlayerBoost.add(graphicsFW.newSprite(UtilResource.textureAtlas,118,0,
                150,40));


    }

    private void loadTexture(GraphicsFW graphicsFW) {
        UtilResource.textureAtlas = graphicsFW.newTexture("Безымянный.png");
    }

}


