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

public class ControllerSceneStart {

    @FXML
    public TextField EingabeSpielerName;
    private Stage stage;
    private Scene scene;
    private Parent root;

    int lenght;

    @FXML
    public TextField EingabeWortLange;

    public void switchToSceneIntermedia(ActionEvent event) throws IOException {

        String username = EingabeSpielerName.getText(); //
        // System.out.println("username :" + username); // Test ob etwas gespeichert wurde


        GameManagerSingleton gameManager = GameManagerSingleton.getGaMaSi();
        gameManager.setUsername(username);
        gameManager.setWordLength(lenght);

        FXMLLoader loader = new FXMLLoader(getClass().getResource("SceneIntermedia.fxml")); // Erstellt ein FXMLloader Objekt und weist ihm die Ressource zu
        root = loader.load(); // root ist der Rückgabewert

        // root = FXMLLoader.load(getClass().getResource("SceneIntermedia.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public void switchToSceneAdvanced(ActionEvent event) throws IOException {

        String username = EingabeSpielerName.getText(); //speichert den Input aus get.Text in einer Variable um diese weiterzuverarbeiten
        // System.out.println("username :" + username); // Test ob etwas gespeichert wurde

        GameManagerSingleton gameManager = GameManagerSingleton.getGaMaSi(); // die EINZIGE GameMangerSingleton Instanz wird aufgerufen
        gameManager.setUsername(username); // username wird im GameMangerSingelton Objekt (gameManger) gespeichert

        FXMLLoader loader = new FXMLLoader(getClass().getResource("SceneAdvanced.fxml")); // Erstellt ein FXMLloader Objekt und weist ihm die Ressource zu
        root = loader.load(); // root ist der Rückgabewert

        // root = FXMLLoader.load(getClass().getResource("SceneIntermedia.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
}

