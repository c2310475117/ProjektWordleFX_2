package com.example.switchscene;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage stage) {
         try {
             // Default Stage Contructor
             // Stage stage = new Stage();
             // Stage stage = new Stage(StageStyle.DECORATED);
             // stage.setTitle("Stage 1");

             // BorderPane root = new BorderPane();
             Parent root = FXMLLoader.load (Main.class.getResource("SceneStart.fxml"));


             // Scene scene1 = new Scene(root, 400, 400);
             // Scene scene1 = new Scene(root);
             // scene1.setFill(Color.GRAY);
             // Scene scene1 = new Scene(root, Color.RED);
             Scene scene = new Scene(root, 600, 600, Color.RED);
             stage.setScene(scene);
             stage.show();

             //scene.setCursor(Cursor.CROSSHAIR);

            /*
            stage1.setScene(scene1);
            stage1.show();

            stage1.setMaxHeight(1000);
            stage1.setMinHeight(500);
            stage1.setMaxWidth(1000);
            stage1.setMinWidth(500);
            */
         } catch (Exception e){
             e.printStackTrace();
         }
    }

    public static void main(String[] args) {
        launch(args);
    }
}