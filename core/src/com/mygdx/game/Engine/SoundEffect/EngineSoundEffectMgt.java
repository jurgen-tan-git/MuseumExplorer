package com.mygdx.game.Engine.SoundEffect;

import com.mygdx.game.Engine.Screen.EngineScreenMgt;
import com.mygdx.game.MazeGame.GameScreen.EndScreen;
import com.mygdx.game.MazeGame.GameScreen.GameScreen;
import com.mygdx.game.MazeGame.GameScreen.MenuScreen;
import com.mygdx.game.MazeGame.GameScreen.ScreenMgt;

public abstract class EngineSoundEffectMgt {
    private static EngineSoundEffectMgt soundEffect;

    private EngineSoundEffectMgt[] sounds;


    public abstract EngineSoundEffectMgt[] createScreens();
}
