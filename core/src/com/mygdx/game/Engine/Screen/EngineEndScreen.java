package com.mygdx.game.Engine.Screen;


public abstract class EngineEndScreen extends EngineScreenMgt {
    private boolean restartClicked;
    private boolean menuClicked ;

    private int score;
    private long start;
    public long end;
    private String endtext = "";

    private int timer = 0;



    public abstract void show();

    public abstract void render(float delta);

    @Override
    public abstract void dispose();

    public abstract boolean getrestartClicked();

    public abstract boolean getmenuClicked();

    public abstract void resetmenuClicked();

    public abstract void resetRestartClicked();
    public void setScore(){
        score = 1000 - (int)((end-start)/10000);
    }

    public abstract int getScore();
    public void setStart(long time){
        start = time;
    }
    public void setEnd(long time){
        end = time;
    }
}

