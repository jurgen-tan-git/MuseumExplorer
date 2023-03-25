package com.mygdx.game.MazeGame.GameBehaviour;

import com.mygdx.game.Engine.Behaviour.EngineBehaviourMgt;


public class BehaviourMgt extends EngineBehaviourMgt {
    private static PopUp popup;
    private static BehaviourMgt behaviourMgt = null;
    private BehaviourMgt(){
        popup = new PopUp();

    }
    public static BehaviourMgt getInstance(){
        if (behaviourMgt == null){
            behaviourMgt = new BehaviourMgt();
        }
        return behaviourMgt;
    }

    @Override
    public void createEvent() {
        popup = new PopUp();
    }

    public PopUp getEvent(){
        return popup;
    }

    @Override
    public void createPowerUp() {

    }
}
