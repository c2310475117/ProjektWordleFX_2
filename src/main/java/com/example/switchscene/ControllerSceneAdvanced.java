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

public class ControllerSceneAdvanced {
    @FXML
    private Stage stage;
    private Scene scene;
    private Parent root;


    @FXML
    private Label NamedesSpielers;

    @FXML
    private Label timeLabel;


    public void initialize() {
        // You can use the initialize method to set up your UI when the controller is loaded.
        GameManager gameManager = GameManager.getInstance();
        String formattedTime = gameManager.getFormattedTime();
        timeLabel.setText(formattedTime);
        String username = GameManager.getInstance().getUsername();
        NamedesSpielers.setText(username.toUpperCase()); // der username
    }

    public void displayName(String username) {
        NamedesSpielers.setText(username.toUpperCase());
    }

    public void switchToSceneFinnishAdvanced(ActionEvent actionEvent) throws IOException {
        String username = NamedesSpielers.getText();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("SceneFinnishAdvanced.fxml"));
        root = loader.load();

        // Verwende den ControllerSceneAdvanced für SceneFinnishAdvanced
        ControllerSceneAdvanced sceneAdvanced = loader.getController();
        sceneAdvanced.displayName(username);

        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
