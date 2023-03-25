package com.mygdx.game.Engine.Entity;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.MazeGame.GameEntity.GameEntityMgt;
import com.mygdx.game.MazeGame.GameEntity.MazeRender;

import java.util.ArrayList;

public abstract class EngineEntityMgt implements iEntity {

    //parent class attributes
    private int objHP, coord_x, coord_y;
    private boolean alive;
    private Color color;
    private Texture texturePath;
    private SpriteBatch batch;
    private Texture img;

    private ArrayList<MovableObject> movableObjects;
    private ArrayList<Obstacle> obstacleList;



    public EngineEntityMgt(){
    }

    public EngineEntityMgt(int hp, int pos_x, int pos_y, boolean alive, Color color, Texture tp) {
        this.objHP = hp;
        this.coord_x = pos_x;
        this.coord_y = pos_y;
        this.alive = alive;
        this.color = color;
        this.texturePath = tp;
        this.movableObjects = new ArrayList<>();
        this.obstacleList = new ArrayList<>();
    }




    public SpriteBatch getBatch() {
        return batch;
    }
    public void setBatch(SpriteBatch batch){
        this.batch = batch;
    }

    public ArrayList<MovableObject> createMovable(int numMovable) {
        for (int i = 0; i < numMovable; i++) {
            int objHP = 10;
            int coord_x = 30;
            int coord_y = 0;
            boolean alive = true;
            Color color = Color.YELLOW;
            Texture img = new Texture("DinoSprites_doux.gif");
            int score = 0;
            MovableObject newMovable = new MovableObject(objHP, coord_x, coord_y, alive, color, new Texture("DinoSprites_doux.gif"), score);
            movableObjects.add(newMovable);
        }
        return movableObjects;
    }

    //Obstacles
    public ArrayList<Obstacle> createObstacle(int numObstacle) {
//
        return obstacleList;
    }

    public void updatePos(ArrayList<MovableObject> players, ArrayList<Obstacle> obstacles) {
        int x, y;

        //img = new Texture("test.gif");
        MovableObject player1 = players.get(0);
        Obstacle obstacle = obstacles.get(0);
        System.out.println(player1.getCoord_x());
        for (int i = 0; i < players.size(); i++) {
            //batch = new SpriteBatch();
        }

        for (int i = 0; i < obstacles.size(); i++) {
            System.out.println("Object " + i + " in objects2, coord_x: " + obstacles.get(i).getCoord_x());
        }

        //return x, y;
    }

    public int getObjHP() {
        return objHP;
    }

    public void setObjHP(int objHP) {
        this.objHP = objHP;
    }

    public int getCoord_x() {
        return coord_x;
    }

    public void setCoord_x(int coord_x) {
        this.coord_x = coord_x;
    }

    public int getCoord_y() {
        return coord_y;
    }

    public void setCoord_y(int coord_y) {
        this.coord_y = coord_y;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void movementType(String type){}

    public void movementSpeed(int speed){}

    public void move(int x, int y){}



    public void create(){
        //img = new Texture(texturePath);
    }
    public void initialise(){}
    public void load(){
        batch.begin();
        batch.draw(img, coord_x, coord_y);
        batch.end();
    }
    public void draw(){
        batch.begin();
        batch.draw(img, coord_x, coord_y);
        batch.end();
    }
    public void update(){
        batch.begin();
        batch.draw(img, coord_x, coord_y);
        batch.end();
    }
    public void dispose(){
        img.dispose();
    }
    public void render(){
        batch.begin();
        batch.draw(img, coord_x, coord_y);
        batch.end();}


}
