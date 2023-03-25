package com.mygdx.game.MazeGame.GameScreen;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Engine.Screen.EngineScreenMgt;


public final class ScreenMgt extends EngineScreenMgt {
    private static ScreenMgt screenMgt = null;

    private EngineScreenMgt[] screens;


    private ScreenMgt() {
    };

    public EngineScreenMgt[] createScreens() {
        screens = new EngineScreenMgt[] {new MenuScreen(), new EndScreen("You Win!", "Next Level")
                , new EndScreen("Game Over!", "Restart"), new GameScreen(), new InstructionScreen()};
        return screens;
    }
    public static ScreenMgt getInstance(){
        if(screenMgt == null){
            screenMgt = new ScreenMgt();
        }
        return screenMgt;
    }


    public void newGame(){
        screens[2] = new GameScreen();
    }

}