package com.mygdx.game.MazeGame.GameBehaviour;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.XmlReader;
import com.mygdx.game.Engine.Behaviour.EnginePopUp;
import com.mygdx.game.MazeGame.GameScreen.EndScreen;

public class PopUp extends EnginePopUp {
    private static Stage stage;
    private static Skin skin;
    private Dialog dialog;
    int currentQuestionIndex = 0;
    boolean isPaused = false;
    private Array<XmlReader.Element> questions;
    private TextButton button;
    private TextButton button1;
    private int score = 0;

    private void setupDialog(XmlReader.Element question) {
        String questionText = question.getChildByName("text").getText();
        Label questionLabel = new Label(questionText, skin, "default");
        questionLabel.setWrap(true);
        questionLabel.setFontScale(0.8f);
        dialog.getContentTable().add(questionLabel).width(600f);

        String answerText = question.getChildByName("answer").getText();
        Label label = new Label(answerText, skin, "default");
         // set font size to 80% of default size
        label.setAlignment(Align.center);
        label.setWrap(true);
        button = new TextButton("", skin);
        button.add(label).width(300).height(100);
        //dialog.getButtonTable().add(button).width(300).height(100);

        String choiceText = question.getChildByName("choice").getText();
        Label label1 = new Label(choiceText, skin, "default");
        // set font size to 80% of default size
        label1.setAlignment(Align.center);
        label1.setWrap(true);
        button1 = new TextButton("", skin);
        button1.add(label1).width(300).height(100);
        //dialog.getButtonTable().add(button1).width(300).height(100);
        TextButton[] buttons = { button, button1};
        Array<TextButton> buttonArray = new Array<TextButton>(buttons);
        buttonArray.shuffle();
        for (TextButton button : buttonArray) {
            dialog.getButtonTable().add(button).width(300).height(100);
        }
        button.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                resetDialog();
                currentQuestionIndex++;
                dialog.hide(); // hide the dialog box after the button is clicked
                System.out.println("Button clicked!");
                System.out.println("plus score");
                score++;
                System.out.println(score);
                if (currentQuestionIndex >= questions.size - 1) {
                    dialog.hide();
                    System.out.println("No more questions!");
                    isPaused = false;

                } else {
                    XmlReader.Element question = questions.get(currentQuestionIndex);
                    setupDialog(question);
                    dialog.setVisible(false);
                    isPaused = false;
                }
            }
        });


        button1.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                resetDialog();
                currentQuestionIndex++;
                dialog.hide(); // hide the dialog box after the button is clicked
                System.out.println("Button1 clicked!");

                System.out.println("minus score");

                if (currentQuestionIndex >= questions.size - 1) {
                    dialog.hide();
                    System.out.println("No more questions!");
                    isPaused = false;
                } else {
                    XmlReader.Element question = questions.get(currentQuestionIndex);
                    setupDialog(question);
                    dialog.setVisible(false);
                    isPaused = false;
                }
            }
        });
    }

    private void resetDialog() {
        if (dialog.getContentTable() != null) {
            dialog.getContentTable().clear();
        }
        if (dialog.getButtonTable() != null) {
            dialog.getButtonTable().clear();
        }
    }

    public void createPopup() {
        stage = new Stage();
        XmlReader xml = new XmlReader();
        XmlReader.Element root = xml.parse(Gdx.files.internal("QnA.xml"));
        skin = new Skin(Gdx.files.internal("skin/craftacular-ui.json"));
        Gdx.input.setInputProcessor(stage);
        // create a dialog box with a message and a button
        dialog = new Dialog("", skin);
        questions = new Array<>();
        for(XmlReader.Element child : root.getChildrenByName("question")){
            if(child.hasAttribute("id")){
                questions.add(child);
            }
        }

        //Randomize the order of questions
        questions.shuffle();

        XmlReader.Element question = questions.get(currentQuestionIndex);
        setupDialog(question);

        // add a listener to the button to perform an action when clicked
        button.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {            // perform some action here
                resetDialog();
                currentQuestionIndex++;
                dialog.hide(); // hide the dialog box after the button is clicked

                System.out.println("Button clicked!");
                System.out.println("plus score");
                score++;
                System.out.println(score);
                if (currentQuestionIndex >= questions.size - 1) {
                    dialog.hide();
                    System.out.println("No more questions!");
                    isPaused = false;

                } else {
                    XmlReader.Element question = questions.get(currentQuestionIndex);
                    setupDialog(question);
                    dialog.setVisible(false);
                    isPaused = false;
                }

            }
        });
        //button for selected wrong option
        button1.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {            // perform some action here
                resetDialog();
                currentQuestionIndex++;
                dialog.hide(); // hide the dialog box after the button is clicked

                System.out.println("Button clicked!");
                System.out.println("minus score");

                if (currentQuestionIndex >= questions.size - 1) {
                    dialog.hide();
                    System.out.println("No more questions!");
                    isPaused = false;

                } else {
                    XmlReader.Element question = questions.get(currentQuestionIndex);
                    setupDialog(question);
                    dialog.setVisible(false);
                    isPaused = false;
                }

            }
        });
        dialog.setVisible(false);
    }

    public int getScore(){
        return score;
    }
    public int resetScore(){
        score=0;
        return score;
    }
    public boolean getIsPaused(){
        return isPaused;
    }


    public void renderPopup(){
        stage.act();
        stage.draw();
    }
    public void showDialog() {
        // add the dialog box to the stage
        dialog.setVisible(true);
        dialog.show(stage);
        Gdx.input.setInputProcessor(stage);
        isPaused = true;
    }
    public void dispose(){
        stage.dispose();
        skin.dispose();
    }

}
