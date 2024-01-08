package com.example.switchscene;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

//https://www.youtube.com/watch?v=B4t0Y40U4HI
public class WordleGuiController {
    private String word = "bunny";
    public TextField guessInput;
    public Label box00 = new Label();
    public Label box01 = new Label();
    public Label box02 = new Label();
    public Label box03 = new Label();
    public Label box04 = new Label();
    public Label box10 = new Label();
    public Label box11 = new Label();
    public Label box12 = new Label();
    public Label box13 = new Label();
    public Label box14 = new Label();
    public Label box20 = new Label();
    public Label box21 = new Label();
    public Label box22 = new Label();
    public Label box23 = new Label();
    public Label box24 = new Label();
    public Label box30 = new Label();
    public Label box31 = new Label();
    public Label box32 = new Label();
    public Label box33 = new Label();
    public Label box34 = new Label();
    public Label box40 = new Label();
    public Label box41 = new Label();
    public Label box42 = new Label();
    public Label box43 = new Label();
    public Label box44 = new Label();
    public Label box50 = new Label();
    public Label box51 = new Label();
    public Label box52 = new Label();
    public Label box53 = new Label();
    public Label box54 = new Label();

    @FXML
    protected void checkGuess1() {
        String guess = guessInput.getText();
        Label[] row0 = {box00, box01, box02, box03, box04};

        for (int i = 0; i < guess.length(); i++) {
            String letter = guess.substring(i, i + 1);
            row0[i].setText(letter);
            if (letter.equals(word.substring(i, i + 1))) {
                row0[i].setStyle("-fx-background-color: #31a127;");
            } else if (word.contains(letter)) {
                row0[i].setStyle("-fx-background-color: #f0b63a;");
            } else {
                row0[i].setStyle("-fx-background-color: #919191;");
            }
        }
        guessInput.clear();
    }
    @FXML
    protected void checkGuess2() {
        String guess = guessInput.getText();
        Label[] row1 = {box10, box11, box12, box13, box14};

        for (int i = 0; i < guess.length(); i++) {
            String letter = guess.substring(i, i + 1);
            row1[i].setText(letter);
            if (letter.equals(word.substring(i, i + 1))) {
                row1[i].setStyle("-fx-background-color: #31a127;");
            } else if (word.contains(letter)) {
                row1[i].setStyle("-fx-background-color: #f0b63a;");
            } else {
                row1[i].setStyle("-fx-background-color: #919191;");
            }
        }
        guessInput.clear();
    }
    @FXML
    protected void checkGuess3() {
        String guess = guessInput.getText();
        Label[] row2 = {box20, box21, box22, box23, box24};

        for (int i = 0; i < guess.length(); i++) {
            String letter = guess.substring(i, i + 1);
            row2[i].setText(letter);
            if (letter.equals(word.substring(i, i + 1))) {
                row2[i].setStyle("-fx-background-color: #31a127;");
            } else if (word.contains(letter)) {
                row2[i].setStyle("-fx-background-color: #f0b63a;");
            } else {
                row2[i].setStyle("-fx-background-color: #919191;");
            }
        }
        guessInput.clear();
    }
    @FXML
    protected void checkGuess4() {
        String guess = guessInput.getText();
        Label[] row3 = {box30, box31, box32, box33, box34};

        for (int i = 0; i < guess.length(); i++) {
            String letter = guess.substring(i, i + 1);
            row3[i].setText(letter);
            if (letter.equals(word.substring(i, i + 1))) {
                row3[i].setStyle("-fx-background-color: #31a127;");
            } else if (word.contains(letter)) {
                row3[i].setStyle("-fx-background-color: #f0b63a;");
            } else {
                row3[i].setStyle("-fx-background-color: #919191;");
            }
        }
        guessInput.clear();
    }
    @FXML
    protected void checkGuess5() {
        String guess = guessInput.getText();
        Label[] row4 = {box40, box41, box42, box43, box44};

        for (int i = 0; i < guess.length(); i++) {
            String letter = guess.substring(i, i + 1);
            row4[i].setText(letter);
            if (letter.equals(word.substring(i, i + 1))) {
                row4[i].setStyle("-fx-background-color: #31a127;");
            } else if (word.contains(letter)) {
                row4[i].setStyle("-fx-background-color: #f0b63a;");
            } else {
                row4[i].setStyle("-fx-background-color: #919191;");
            }
        }
        guessInput.clear();
    }
    @FXML
    protected void checkGuess6() {
        String guess = guessInput.getText();
        Label[] row5 = {box50, box51, box52, box53, box54};

        for (int i = 0; i < guess.length(); i++) {
            String letter = guess.substring(i, i + 1);
            row5[i].setText(letter);
            if (letter.equals(word.substring(i, i + 1))) {
                row5[i].setStyle("-fx-background-color: #31a127;");
            } else if (word.contains(letter)) {
                row5[i].setStyle("-fx-background-color: #f0b63a;");
            } else {
                row5[i].setStyle("-fx-background-color: #919191;");
            }
        }
        guessInput.clear();
    }
}