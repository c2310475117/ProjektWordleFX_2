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

public class ControllerSceneAdvanced {
    @FXML // um Felder im Controller mit den FXML Elementen zu verbinden
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Label NamedesSpielers;

    @FXML
    private Label TimeLable;

    @FXML
    private Label Loesungswort;
    @FXML
    private Label Wortlange;

    private GameManagerSingleton gameManager;

    public void initialize() {
        // die Methode GameMangerSingelton.getGaMaSi wird aufgerufen
        // + gibt eine Instanz der Methode GameMangerSingelton zurück
        // + wird in der Variable gamemanger gespeichert
        // Es wird KEINE neue Instanz erstellt
        gameManager = GameManagerSingleton.getGaMaSi();
        // Der Benutzername wird von der gespeicherten Instanz aus GameMangerSingelton abgerufen
        String username = gameManager.getUsername();
        NamedesSpielers.setText(username.toUpperCase()); // der username

        String solutionWord = gameManager.getSolutionWord();
        Loesungswort.setText(solutionWord);

        String formattedTime = gameManager.getFormattedTime();
        TimeLable.setText(formattedTime);

        int lenght = gameManager.getWordLength();
        Wortlange.setText(String.valueOf(lenght)); // wandelt int in String um
    }

    public void switchToSceneFinnishAdvanced(ActionEvent actionEvent) throws IOException {
        String username = GameManagerSingleton.getGaMaSi().getUsername();
        String solutionWord = GameManagerSingleton.getGaMaSi().getSolutionWord();
        String formattedTime = GameManagerSingleton.getGaMaSi().getFormattedTime();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("SceneFinnishAdvanced.fxml"));
        root = loader.load();

        // Der Benutzername wird in der nächsten Szene angezeigt
        ControllerSceneAdvanced sceneAdvanced = loader.getController();
        sceneAdvanced.NamedesSpielers.setText(username.toUpperCase());
        sceneAdvanced.Loesungswort.setText(solutionWord);
        sceneAdvanced.TimeLable.setText(formattedTime);

        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
