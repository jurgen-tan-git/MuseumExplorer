package com.mygdx.game.MazeGame.GameEntity;

import static java.lang.Math.floor;

import java.util.ArrayList;
import java.util.Random;

public class MazeGenerate {

    private Random rand = new Random();

    private int rows = 21;
    private int cols = 21;

    private int startX = 1;
    private int startY = 0;
    private int endX = 19;
    private int endY = 20;
    private int[][] maze = new int[rows][cols];



    public int[][] generateMaze() {
        // Initialize maze to all walls
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                maze[i][j] = 1;
            }
        }
        // Start at a random cell and carve out maze
        int x = rand.nextInt(cols - 2) + 1;
        int y = rand.nextInt(rows - 2) + 1;

        DFS(x, y);

        // Row 0 starts from the top left of the screen & Column 0 starts from the left to the right
        // Make entrance and the tile above of it
        maze[endY][startX] = 0;
        maze[endY-1][startX] = 0;

        // Make exit and the tile below of it
        maze[startY][endX] = 0;
        maze[startY+1][endX] = 0;
        generateCoins();
        return maze;
    }
    public int[][] resetMaze(){
        generateMaze();
        return maze;
    }
    private void DFS(int x, int y) {
        maze[y][x] = 0;
        ArrayList<int[]> neighbors = new ArrayList<int[]>();
        // Add unvisited neighbors
        if (y > 1 && maze[y - 2][x] == 1) {
            neighbors.add(new int[]{x, y - 2, x, y - 1}); // top
        }
        if (x > 1 && maze[y][x - 2] == 1) {
            neighbors.add(new int[]{x - 2, y, x - 1, y}); // left
        }
        if (y < rows - 2 && maze[y + 2][x] == 1) {
            neighbors.add(new int[]{x, y + 2, x, y + 1}); // bottom
        }
        if (x < cols - 2 && maze[y][x + 2] == 1) {
            neighbors.add(new int[]{x + 2, y, x + 1, y}); // right
        }
        // Randomly choose a neighbor to visit
        while (!neighbors.isEmpty()) {
            int r = rand.nextInt(neighbors.size());
            int[] n = neighbors.remove(r);
            int nx = n[0];
            int ny = n[1];
            int mx = n[2];
            int my = n[3];
            if (maze[ny][nx] == 1) {
                maze[my][mx] = 0;
                DFS(nx, ny);
            }
        }
    }

    private void generateCoins() {
        int count = 10;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (i == rand.nextInt((int)(cols * 2))) {
                    count -= 1;
                    if (count >= 0)
                        maze[i][j] = -1;
                }

            }
        }

    }

    // Input the player X and Y as perimeter to convert to the column and row
    public int[] coordinateConverter(float x, float y){
//        System.out.println(floor(x/30)); //Column
//        System.out.println(floor((630 - y )/30)); //Row
        int column = (int) floor(x/30);
        int row = (int) floor((630 - y )/30) ;

        if (column < 0){
            column = 0;
        }

        if (column > 20){
            column = 20;
        }

        if (row < 0){
            row = 0;
        }

        if (row > 20){
            row = 20;
        }
        return new int[] {row, column};
    }



    public int getStartX(){
        return startX;
    }

    public int getStartY(){
        return startY;
    }

    public int getEndX(){
        return endX;
    }

    public int getEndY(){
        return endY;
    }

    public int getRows(){
        return rows;
    }

    public int getCols(){
        return cols;
    }

}
