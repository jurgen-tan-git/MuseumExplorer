package com.mygdx.game.Engine.Simulation;


import com.badlogic.gdx.Game;
import com.mygdx.game.Engine.Entity.EngineEntityMgt;
import com.mygdx.game.Engine.Screen.EngineScreenMgt;
import com.mygdx.game.Engine.SoundEffect.EngineSoundEffect;
import com.mygdx.game.Engine.SoundEffect.EngineSoundEffectMgt;
import com.mygdx.game.MazeGame.GameBehaviour.BehaviourMgt;
import com.mygdx.game.Engine.Collision.*;

public abstract class EngineSimulation extends Game{
    private EngineScreenMgt screenMgt;
    private EngineSoundEffectMgt soundEffect;
    private EngineEntityMgt entityMgt;
    private EngineCollisionMgt collisionMgt;
    private BehaviourMgt behaviourMgt;

    //pregame of the game
    public abstract void create();

    //update of the game
    public void render(){
        super.render();
    }

    //restart the game
    public abstract void restart();

    //pause the game
    public abstract void pause();

    public abstract void quit();

    //dispose off all the resources used
    public abstract void dispose();


    }
