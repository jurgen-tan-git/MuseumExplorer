package com.mygdx.game.Engine.Collision;

public class EngineCollisionMgt {
    private EngineCollidable engineCollidable;
    private EngineNonCollidable engineNonCollidable;


    public void createCollidable(){
        engineCollidable = new EngineCollidable();
    }
    public EngineCollidable getCollidable(){
        return engineCollidable;
    }

    public void createNonCollidable(){
        engineNonCollidable = new EngineNonCollidable();
    }
    public EngineNonCollidable getNonCollidable(){
        return engineNonCollidable;
    }


}
