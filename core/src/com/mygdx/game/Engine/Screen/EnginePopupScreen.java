package com.mygdx.game.Engine.Screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.XmlReader;
import com.mygdx.game.Engine.Input.InputMgt;
import com.mygdx.game.MazeGame.GameSimulation.GameSimulationMgt;


public abstract class EnginePopupScreen extends EngineScreenMgt {

    private GameSimulationMgt game;
    private InputMgt input;
    private Stage stage;
    private Skin skin;
    private Label scoreLabel;
    private Dialog dialog;



    private boolean restartClicked = false;
    private boolean menuClicked = false;



    public EnginePopupScreen(GameSimulationMgt game, InputMgt input) {
        this.game = game;
        this.input = input;
        stage = new Stage();
        skin = new Skin(Gdx.files.internal("skin/craftacular-ui.json"));


    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
        XmlReader xml = new XmlReader();
        XmlReader.Element root = xml.parse(Gdx.files.internal("QnA.xml"));
        skin = new Skin(Gdx.files.internal("skin/craftacular-ui.json"));
        Gdx.input.setInputProcessor(stage);
        // create a dialog box with a message and a button
        Array<XmlReader.Element> questions = new Array<>();
        for(XmlReader.Element child : root.getChildrenByName("question")){
            if(child.hasAttribute("id")){
                questions.add(child);
            }
        }
        int currentqnIndex=0;
        XmlReader.Element question = questions.get(currentqnIndex);
        String questionText = question.getChildByName("text").getText();
        Label questionLabel = new Label(questionText, skin, "title");
        questionLabel.setPosition(Gdx.graphics.getWidth() / 2f - questionLabel.getWidth() / 2f, Gdx.graphics.getHeight() / 2f);

        XmlReader.Element answer = question.getChildByName("answer");
        String correctAnswer = answer.getChildByName("correct").getText();
        final String wrongAnswer = answer.getChildByName("wrong").getText();

        final TextButton correctButton = new TextButton(correctAnswer, skin);
        correctButton.setSize(correctButton.getWidth(), correctButton.getHeight());
        correctButton.setPosition(Gdx.graphics.getWidth()/2f - correctButton.getWidth()/2f, Gdx.graphics.getHeight()/2f - correctButton.getHeight());
        final TextButton wrongButton = new TextButton(wrongAnswer, skin);
        wrongButton.setSize(wrongButton.getWidth(), wrongButton.getHeight());
        wrongButton.setPosition(Gdx.graphics.getWidth()/2f - wrongButton.getWidth()/2f, Gdx.graphics.getHeight()/2f - 2*wrongButton.getHeight());
        // add a listener to the button to perform an action when clicked
        // add listeners to the buttons to perform actions when clicked
        correctButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                System.out.println("Correct button clicked!");
                // perform some action for a correct answer
                correctButton.setColor(Color.GREEN);
            }
        });
        wrongButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                System.out.println("Wrong button clicked!");
                // perform some action for a wrong answer
                wrongButton.setColor(Color.RED);
            }
        });
        stage.addActor(questionLabel);
        stage.addActor(correctButton);
        stage.addActor(wrongButton);
        currentqnIndex++;

        System.out.println(currentqnIndex);
    }

    @Override
    public void render(float delta) {
        stage.act();
        stage.draw();

    }

    @Override
    public void dispose() {
        stage.dispose();
        skin.dispose();
    }

    public boolean getrestartClicked() {
        return restartClicked;
    }

    public boolean getmenuClicked() {
        return menuClicked;
    }

    public void resetmenuClicked(){
        menuClicked = false;
    }

    public void resetRestartClicked(){
        restartClicked = false;
    }

}

