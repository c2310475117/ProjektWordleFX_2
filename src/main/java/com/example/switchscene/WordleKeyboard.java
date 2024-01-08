package com.example.switchscene;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
//import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import java.io.IOException;

public class WordleKeyboard extends Application {
    private TextField textField = new TextField();
    private static final int MAX_TEXT_LENGTH = 5; //Textlänge
    private static final String SOLUTION_WORD  = "BAUER"; //das Lösungswort
    private final Map<Character, Button> letterButtons = new HashMap<>();
    private final Set<Character> attemptedLetters = new HashSet<>(); //Buchstabenspeicher

    @Override
    public void start(Stage primaryStage) {
        //Hauptlayout, das enthält alles
        BorderPane mainLayout = new BorderPane();
        mainLayout.setPadding(new Insets(20)); //Fensterrand Abstand

        //Eingabefeld
        textField.setMaxWidth(300); //Breite des Eingabefelds
        textField.setAlignment(Pos.CENTER);
        textField.setEditable(true);
        textField.textProperty().addListener((observable, oldValue, newValue) -> {
            if(newValue.length() > MAX_TEXT_LENGTH){
                textField.setText(oldValue);
            }
        });

        VBox topContainer = new VBox(20, textField);
        topContainer.setAlignment(Pos.TOP_CENTER);
        //topContainer.setPadding(new Insets(20, 0, 20, 0));

        //Tastatur Layout
        GridPane gridPane = createKeyboardGridPane();
        mainLayout.setTop(topContainer);
        mainLayout.setCenter(gridPane);

        //Szene einrichten und anzeigen
        Scene scene = new Scene(mainLayout, 800, 400);
        primaryStage.setTitle("Wordle Keyboard");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    private GridPane createKeyboardGridPane() {
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        //Tastenreihen
        String[] rows = {
                "Q W E R T Z U I O P",
                " A S D F G H J K L ",
                "  Y X C V B N M  "
        };

        //Tasten auf der Tastatur
        for (int i = 0; i < rows.length; i++) {
            String row = rows[i].trim(); //Entfernt führende Leerzeichen
            String[] keys = row.split(" ");
            for (int j = 0; j < keys.length; j++) {
                String key = keys[j];
                Button btn = createKeyButton(key);
                gridPane.add(btn, j + (i == 2 ? 1 : 0), i); //Versetze jede Reihe um 1 weniger als die vorige
            }
        }

        //ENTER Button
        Button enterButton = createKeyButton("✓");
        enterButton.setOnAction(e -> submitWord());
        enterButton.setMinSize(90, 60); //Größe Enter Button
        gridPane.add(enterButton, 0, 3, 2, 1);

        //DELETE Button
        Button deleteButton = createKeyButton("✕");
        deleteButton.setOnAction(e -> deleteLastCharacter());
        gridPane.add(deleteButton,9, 1);

        return gridPane;
    }

    private Button createKeyButton(String text) {
        Button button = new Button(text);
        button.setOnAction(e -> appendLetter(text));
        button.setMinSize(60,60); //Größe Keyboardtasten
        button.setFont(Font.font("Arial",20));
        letterButtons.put(text.charAt(0), button);
        return button;
    }

    //Buchstaben einfügen
    private void appendLetter(String text) {
        if("✓".equals(text)) {
            submitWord();
        }
        else if("✕".equals(text)) {
            deleteLastCharacter();
        }
        else if (textField.getText().length() < MAX_TEXT_LENGTH) {
            textField.appendText(text);
        }
        // Hier könntest du die Logik hinzufügen, um die Farbe der Taste zu ändern
    }

    //Buchstaben löschen
    private void deleteLastCharacter(){
        String text = textField.getText();
        if(!text.isEmpty()){
            textField.setText(text.substring(0, text.length() -1));
        }
    }

    //Enter Aktion
    private void submitWord() {
        //Hier Logik rein um das eingegebene Wort zu überprüfen
        String word = textField.getText().toUpperCase();
        if (word.length() == MAX_TEXT_LENGTH) {
            Map<Character, String> colorMapping = new HashMap<>();

            //Prüfen auf die korrekte Position (grün)
            for (int i = 0; i < word.length(); i++) {
                char letter = word.charAt(i);
                attemptedLetters.add(letter); //fügt Buchstaben zu den Versuchten hinzu
                Button button = letterButtons.get(letter);


                if (SOLUTION_WORD.charAt(i) == letter) {
                    colorMapping.put(letter, "-fx-background-color: green;");
                } else if (SOLUTION_WORD.indexOf(letter) >= 0) {
                    colorMapping.putIfAbsent(letter, "-fx-background-color: orange;");
                } else {
                    colorMapping.putIfAbsent(letter, "-fx-background-color: grey;");
                }
            }

            for (Map.Entry<Character, String> entry : colorMapping.entrySet()) {
                Button button = letterButtons.get(entry.getKey());
                if (button != null) {
                    button.setStyle(entry.getValue());
                }
            }
            System.out.println("Lösungswort: " + textField.getText());
            textField.clear();
        }
    }
    public static void main(String[] args) {
        launch(args);
    }
}