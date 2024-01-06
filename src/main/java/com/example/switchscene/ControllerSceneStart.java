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
import java.util.Optional;

public class ControllerSceneStart {

    @FXML
    public TextField EingabeSpielerName;
    private Stage stage;
    private Scene scene;
    private Parent root;

    public TextField WordLengthField;

    @FXML
    public Label Loesungswort;

    public void Loesungswort() {
        Loesungswort.setText("Eingabe");
    }

    public double Timer() {
        return 0;
    }


    public void switchToSceneIntermedia(ActionEvent event) throws IOException {

        String username = EingabeSpielerName.getText(); //speichert den Input aus get.Text in einer Variable um diese weiterzuverarbeiten
        // System.out.println("username :" + username); // Test ob etwas gespeichert wurde

        GameManager gameManager = GameManager.getInstance(); // Game Manger wird initialisiert
        gameManager.setUsername(username); // username wird im GameManager gespeichert

        FXMLLoader loader = new FXMLLoader(getClass().getResource("SceneIntermedia.fxml")); // Erstellt ein FXMLloader Objekt und weist ihm die Ressource zu
        root = loader.load(); // root ist der Rückgabewert

        ControllerSceneIntermedia sceneIntermedia = loader.getController(); // Erstellt eine Instance der ControllerSceneIntermedia
        sceneIntermedia.displayName(username); // ruft die Methode displayName (aus der Classe ControllerSceneIntermedia) auf, und übergibt ihm den usernamen

        // root = FXMLLoader.load(getClass().getResource("SceneIntermedia.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public void switchToSceneAdvanced(ActionEvent event) throws IOException {

        String username = EingabeSpielerName.getText(); //speichert den Input aus get.Text in einer Variable um diese weiterzuverarbeiten
        // System.out.println("username :" + username); // Test ob etwas gespeichert wurde

        GameManager gameManager = GameManager.getInstance();
        gameManager.setUsername(username);

        FXMLLoader loader = new FXMLLoader(getClass().getResource("SceneAdvanced.fxml")); // Erstellt ein FXMLloader Objekt und weist ihm die Ressource zu
        root = loader.load(); // root ist der Rückgabewert

        ControllerSceneAdvanced sceneAdvanced = loader.getController(); // Erstellt eine Instance der ControllerSceneIntermedia
        sceneAdvanced.displayName(username); // ruft die Methode displayName (aus der Classe ControllerSceneIntermedia) auf, und übergibt ihm den usernamen

        // root = FXMLLoader.load(getClass().getResource("SceneIntermedia.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
}

