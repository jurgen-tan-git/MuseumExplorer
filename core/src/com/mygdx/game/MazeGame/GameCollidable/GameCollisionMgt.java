package com.mygdx.game.MazeGame.GameCollidable;

import com.mygdx.game.Engine.Collision.EngineCollisionMgt;

public class GameCollisionMgt extends EngineCollisionMgt {

    private static GameCollisionMgt gameCollidableMgt;

    private GameCollisionMgt(){

    }

    public static GameCollisionMgt getInstance(){
        if (gameCollidableMgt == null){
            gameCollidableMgt = new GameCollisionMgt();
        }
        return gameCollidableMgt;
    }
    public GameCollidable getGameCollidable(){
        return new GameCollidable();
    }

}
