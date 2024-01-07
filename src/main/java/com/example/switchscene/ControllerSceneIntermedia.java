package com.example.switchscene;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;


public class ControllerSceneIntermedia {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Label NamedesSpielers;
    @FXML
    private Label Loesungswort;
    private GameManagerSingleton gameManager;

    @FXML
    private Label Wortlange;


    public void initialize() {
        gameManager = GameManagerSingleton.getGaMaSi();

        String username = gameManager.getUsername();
        NamedesSpielers.setText(username.toUpperCase()); // der username

        String solutionWord = gameManager.getSolutionWord();
        Loesungswort.setText(solutionWord);

        int lenght = gameManager.getWordLength();
        Wortlange.setText(String.valueOf(lenght)); // wandelt int in String um
    }

    public void switchToSceneFinnishIntermedia(ActionEvent event) throws IOException {

        String username = GameManagerSingleton.getGaMaSi().getUsername();
        String solutionWord = GameManagerSingleton.getGaMaSi().getSolutionWord();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("SceneFinnishIntermedia.fxml"));
        root = loader.load();

        // Verwende den ControllerSceneAdvanced für SceneFinnishAdvanced
        ControllerSceneIntermedia sceneIntermedia = loader.getController();
        sceneIntermedia.NamedesSpielers.setText(username.toUpperCase());
        sceneIntermedia.Loesungswort.setText(solutionWord);

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}