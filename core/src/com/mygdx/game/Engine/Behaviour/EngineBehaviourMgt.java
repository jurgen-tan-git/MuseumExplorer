package com.mygdx.game.Engine.Behaviour;
import com.mygdx.game.MazeGame.GameBehaviour.PopUp;

public abstract class EngineBehaviourMgt {

    private EnginePopUp popup;
    private EnginePowerUp powerUp;

    public abstract void createEvent();
    public EnginePopUp getEvent(){
        return popup;
    }
    public abstract void createPowerUp();
    public EnginePowerUp getPowerUp(){
        return powerUp;
    }

}
