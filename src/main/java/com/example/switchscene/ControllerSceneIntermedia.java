package com.example.switchscene;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;


public class ControllerSceneIntermedia {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Label NamedesSpielers;

    public void initialize() {
        String username = GameManager.getInstance().getUsername();
        NamedesSpielers.setText(username.toUpperCase()); // der username
    }

    public void displayName(String username) {
        NamedesSpielers.setText(username.toUpperCase());
    }

    public void switchToSceneFinnishIntermedia(ActionEvent event) throws IOException {

        String username = NamedesSpielers.getText();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("SceneFinnishIntermedia.fxml"));
        root = loader.load();

        // Verwende den ControllerSceneAdvanced für SceneFinnishAdvanced
        ControllerSceneIntermedia sceneIntermedia = loader.getController();
        sceneIntermedia.displayName(username);

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}