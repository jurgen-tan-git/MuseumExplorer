package com.mygdx.game.MazeGame.GameSimulation;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.math.Rectangle;
import com.mygdx.game.MazeGame.GameCollidable.GameCollidable;
import com.mygdx.game.MazeGame.GameCollidable.GameCollisionMgt;
import com.mygdx.game.Engine.Entity.Player;
import com.mygdx.game.Engine.Input.InputMgt;
import com.mygdx.game.Engine.Simulation.EngineSimulation;
import com.mygdx.game.MazeGame.GameBehaviour.BehaviourMgt;
import com.mygdx.game.MazeGame.GameBehaviour.PopUp;
import com.mygdx.game.MazeGame.GameEntity.Coin;
import com.mygdx.game.MazeGame.GameEntity.MazeGenerate;
import com.mygdx.game.MazeGame.GameEntity.MazeRender;
import com.mygdx.game.MazeGame.GameEntity.Wall;
import com.mygdx.game.MazeGame.GameEntity.GameEntityMgt;
import com.mygdx.game.MazeGame.Countdown;
import com.mygdx.game.MazeGame.GameScreen.EndScreen;
import com.mygdx.game.MazeGame.GameScreen.ScreenMgt;
import com.mygdx.game.MazeGame.GameScreen.Music;


public class GameSimulationMgt extends EngineSimulation {
	private int x;
	private int y;

	private GameEntityMgt gameEntityMgr;
	private BehaviourMgt behaviourMgt;
	private MazeRender mazeRender;
	private MazeGenerate mazeGenerate;

	private int[] playerRowCol;
	private int[][] maze;
	private int cellSize;
	private SpriteBatch batch;

	private InputMgt input; //declare variable
	private ScreenMgt screenMgt; // declare variable
	private GameCollisionMgt collisionMgt;
	private GameCollidable collidable;
	private Coin coin;
	private Wall wall;
	private Screen[] screenArray;// declare array variable
	private EndScreen winScreen;// declare variable
	private EndScreen loseScreen;// declare variable
	private Music music;


	private Player player;

	private PopUp PopUp;
	private Countdown countdown;


	public void create() {
		//batch being initialized with a new instance of SpriteBatch class
		batch = new SpriteBatch();
		behaviourMgt = behaviourMgt.getInstance();
		PopUp = behaviourMgt.getEvent();
		collisionMgt = collisionMgt.getInstance();
		collisionMgt.createCollidable();
		collidable = collisionMgt.getGameCollidable();

		gameEntityMgr = gameEntityMgr.getInstance();
		gameEntityMgr.createMazeRender();
		mazeRender = gameEntityMgr.getMazeRender();

		player = gameEntityMgr.createPlayer();

		mazeRender.createMazeGenerate();
		mazeGenerate = mazeRender.getMazeGenerate();
		maze = mazeRender.getMaze();

		cellSize = mazeRender.getCellSize();
		coin = mazeRender.getCoin();
		wall = mazeRender.getWall();

		mazeRender.resetPosition();
		x = mazeRender.getX();
		y = mazeRender.getY();

		Rectangle playerBounds = new Rectangle(x, y, player.getPlayer().getSprite().getWidth() * player.getPlayer().getSprite().getScaleX(), player.getPlayer().getSprite().getHeight() * player.getPlayer().getSprite().getScaleY());
		player.getPlayer().setBounds(playerBounds);
		player.getPlayer().setScale(1.1f);


		//input being initialized with a new instance of inputMgt class
		input = input.getInstance();

		//screenMgt being initialized with a new instance of screenMgt class
		screenMgt = screenMgt.getInstance();


		//calling the method to play music
		music = new Music();
		music.setMusic(Gdx.audio.newMusic(Gdx.files.internal("puzzle.mp3")));
		music.playMusic();
		//calls the createScreens method from screenMgt
		screenArray = screenMgt.createScreens();

		//cast index 1 of screenArray to an object called endScreenObject
		winScreen = (EndScreen) screenArray[1];
		loseScreen = (EndScreen) screenArray[2];

		//set the input processor to our input manager to handle inputs
		Gdx.input.setInputProcessor(input);


		//calls the setScreen method and passes an argument
		//sets the index 0 as the current screen
		setScreen(screenArray[0]);


		PopUp.createPopup();

	}


	public void render() {
		batch.begin();

		// Clear the screen
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		super.render();

		if (getScreen() == screenArray[0] && input.getMouseInput().isMouseClicked() == true) {
				setScreen(screenArray[4]);

		}

		if (getScreen() == screenArray[4] && input.getLetterInput().isSpacePressed() == true) {
			setScreen(screenArray[3]);
		}

		if (getScreen() == screenArray[3]) {
			mazeRender.renderMaze();
			player.getPlayer().draw(batch);

			countdown = countdown.getInstance();
			countdown.setIsPaused(PopUp.getIsPaused());
			countdown.render();


			if (input.getArrowInput().isLeftPressed()) {
				player.getPlayer().move(-3, 0);
			}
			if (input.getArrowInput().isRightPressed()) {
				player.getPlayer().move(3, 0);
			}
			if (input.getArrowInput().isUpPressed()) {
				player.getPlayer().move(0, 3);
			}
			if (input.getArrowInput().isDownPressed()) {
				player.getPlayer().move(0, -3);
			}
			playerRowCol = mazeGenerate.coordinateConverter(player.getPlayer().getX(), player.getPlayer().getY());


			if (collidable.detectBorderCollision(player.getPlayer(), Gdx.graphics.getWidth(), Gdx.graphics.getHeight())) {
				collidable.handleBorderCollision(player.getPlayer(), Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
			}

			for (int i = 0; i < 21; i++) {
				for (int j = 0; j < 21; j++) {
					if (maze[i][j] == -1) {
						// if value = -1 render coin
						Rectangle coinBound = new Rectangle(j * cellSize, Gdx.graphics.getHeight() - (i + 1) * cellSize, cellSize, cellSize);
						coin.getCoinTexture().setBounds(coinBound);
					}
					if (maze[i][j] == 1) {
						// if value = 1, render wall
						Rectangle wallBound = new Rectangle(j * cellSize, Gdx.graphics.getHeight() - (i + 1) * cellSize, cellSize, cellSize);
						wall.getWallTexture().setBounds(wallBound);
					}
					if (collidable.isColliding(player.getPlayer(), mazeRender.getWall().getWallTexture())) {
						collidable.reactCollision(player.getPlayer(), mazeRender.getWall().getWallTexture());
					}


					if (collidable.isColliding(player.getPlayer(), mazeRender.getCoin().getCoinTexture()) && (maze[playerRowCol[0]][playerRowCol[1]] == -1)) {
						this.pause();

					}


					if (PopUp.getIsPaused() == false) {

						Gdx.input.setInputProcessor(input);
						player.getPlayer().setSpeed(1);

					}
					if (collidable.isColliding(player.getPlayer(), mazeRender.getLadder().getLadderTexture())) {
						winScreen.setScore(PopUp.getScore(), countdown.getTime());
						setScreen(screenArray[1]);
						input.resetKeycode();
					}
				}

			}
			if(countdown.getTime() == 0){
				setScreen(screenArray[2]);
			}
		}

		restart();

		//if menuClicked() is set to true, reset the click to false
		//
		if (winScreen.getmenuClicked() == true || loseScreen.getmenuClicked() == true) {
			winScreen.resetmenuClicked();
			loseScreen.resetmenuClicked();

			maze = mazeGenerate.resetMaze();
			mazeRender.resetPosition();

			player.getPlayer().setPosition(x, y);
			setScreen(screenArray[0]);
		}

		batch.end();
		PopUp.renderPopup();
		quit();

	}

	@Override
	public void restart() {
		if (winScreen.getrestartClicked() == true || loseScreen.getrestartClicked() == true) {
			winScreen.resetRestartClicked();
			loseScreen.resetRestartClicked();

			maze = mazeGenerate.resetMaze();
			mazeRender.resetPosition();

			winScreen.setScore(PopUp.resetScore(), countdown.getTime());
			loseScreen.setScore(PopUp.resetScore(), countdown.getTime());

			player.getPlayer().setPosition(x, y);
			input.resetKeycode();

			setScreen(screenArray[3]);

			countdown.createCountDown();
		}
	}

	@Override
	public void pause() {
		player.getPlayer().setSpeed(0);
		PopUp.showDialog();
		maze[playerRowCol[0]][playerRowCol[1]] = 0;
		input.resetKeycode();
	}

	@Override
	public void quit() {
		if (input.getLetterInput().isEscapePressed()){
			screenMgt.quit();
		}
	}

	public void dispose() {
		//dispose off the resources
		batch.dispose();
	}
}
