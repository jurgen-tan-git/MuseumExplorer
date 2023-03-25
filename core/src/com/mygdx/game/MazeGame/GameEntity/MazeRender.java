package com.mygdx.game.MazeGame.GameEntity;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.mygdx.game.Engine.Entity.EngineEntityMgt;

public class MazeRender extends GameEntityMgt {
    private MazeGenerate mazeGenerate;
    private SpriteBatch batch;
    private Floor floor;
    private Ladder ladder;
    private Wall wall;
    private Coin coin;
    private int rows;
    private int cols;
    private int cellSize = 30;
    private int[][] maze;
    private int startX;
    private int startY;
    private int endX;
    private int endY;
    //
    private int x;
    private int y = 0;
    private boolean reached;


    public MazeRender(SpriteBatch batch){
        this.batch = batch;
        wall = new Wall();
        floor = new Floor();
        coin = new Coin();
        ladder = new Ladder();
    }

    public void createMazeGenerate(){
        mazeGenerate = new MazeGenerate();
        rows = mazeGenerate.getRows();
        cols = mazeGenerate.getCols();

        startX = mazeGenerate.getStartX();
        startY = mazeGenerate.getStartY();

        endX = mazeGenerate.getEndX();
        endY = mazeGenerate.getEndY();

        x = startX * cellSize;
        maze = mazeGenerate.generateMaze();
    }


    public Wall getWall(){
        return wall;
    }

    public Coin getCoin(){
        return coin;
    }


    public void renderMaze() {
        batch.begin();
        // Render maze
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // if value = 0 or -1, render floor
                if (maze[i][j] <= 0) {

                    floor.getFloorTexture().setPosition(j * cellSize, Gdx.graphics.getHeight() - (i + 1) * cellSize);
                    floor.getFloorTexture().draw(batch, cellSize);
                    if (maze[i][j] == -1) {
                        // if value = -1 render coin
                        Rectangle coinBound = new Rectangle(j * cellSize, Gdx.graphics.getHeight() - (i + 1) * cellSize, cellSize, cellSize);
                        coin.getCoinTexture().setBounds(coinBound);
                        coin.getCoinTexture().setPosition(j * cellSize, Gdx.graphics.getHeight() - (i + 1) * cellSize);
                        coin.getCoinTexture().draw(batch, cellSize);
                    }
                }

                    if (maze[i][j] == 1) {
                        // if value = 1, render wall
                        Rectangle wallBound = new Rectangle(j * cellSize, Gdx.graphics.getHeight() - (i + 1) * cellSize, cellSize, cellSize);
                        wall.getWallTexture().setBounds(wallBound);
                        wall.getWallTexture().setPosition(j * cellSize, Gdx.graphics.getHeight() - (i + 1) * cellSize);
                        wall.getWallTexture().draw(batch, cellSize);
                    }

                ladder.getLadderTexture().setPosition(startX * cellSize, startY * cellSize);
                ladder.getLadderTexture().draw(batch, cellSize);

                ladder.getLadderTexture().setPosition(endX * cellSize, endY * cellSize);
                ladder.getLadderTexture().draw(batch, cellSize);

            }
        }
        batch.end();
    }
    public void resetPosition(){
        x = mazeGenerate.getStartX() * getCellSize();
        y = 0;
    }
    public int getCellSize() {
        return cellSize;
    }

    public boolean getReached(){
        return reached;
    }
    public void setReached(){
        reached = true;
    }

    public int[][] getMaze(){
        return maze;
    }


    public MazeGenerate getMazeGenerate(){
        return mazeGenerate;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }
    public Ladder getLadder() {
        return ladder;
    }
}

