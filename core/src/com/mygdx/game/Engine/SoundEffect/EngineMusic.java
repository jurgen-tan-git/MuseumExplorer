package com.mygdx.game.Engine.SoundEffect;


import com.badlogic.gdx.audio.Music;
import com.mygdx.game.Engine.Screen.EngineScreenMgt;

import java.io.FileNotFoundException;

public abstract class EngineMusic extends EngineScreenMgt implements Music {
    private Music music;

    public void setMusic(Music music) {
        try {
            this.music = music;
        }catch(Exception e) {
            System.out.println("The file was not found. Please check the file path.");
        }
    }
    public void playMusic(){
        music.setLooping(true);
        music.play();
    }

    public void stopMusic(Music music){
        music.stop();
    }

    @Override
    public void play() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void stop() {

    }

    @Override
    public boolean isPlaying() {
        return false;
    }

    @Override
    public void setLooping(boolean isLooping) {

    }

    @Override
    public boolean isLooping() {
        return false;
    }

    @Override
    public void setVolume(float volume) {

    }

    @Override
    public float getVolume() {
        return 0;
    }

    @Override
    public void setPan(float pan, float volume) {

    }

    @Override
    public void setPosition(float position) {

    }

    @Override
    public float getPosition() {
        return 0;
    }

    @Override
    public void dispose() {

    }

    @Override
    public void setOnCompletionListener(OnCompletionListener listener) {

    }
}
