package com.mygdx.game.Engine.Screen;


public abstract class  EngineGameScreen extends EngineScreenMgt {



    @Override
    public abstract void show();

    public abstract void update();

    public void render(float delta){
        clear();
    }

    public void dispose(){
        super.dispose();
    }

}
