package com.mygdx.game;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.mygdx.game.MazeGame.GameSimulation.GameSimulationMgt;

// Please note that on macOS your application needs to be started with the -XstartOnFirstThread JVM argument
public class DesktopLauncher {
	public static void main (String[] arg) {
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.setWindowedMode(630, 630);
		config.setForegroundFPS(60);
		config.setTitle("Museum Explorer");
		new Lwjgl3Application(new GameSimulationMgt(), config);

	}
}
