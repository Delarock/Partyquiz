/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Main;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class StartGame extends Application {
    private static Stage primaryStage;
    private static AnchorPane rootLayout;
            
    @Override
    public void start(Stage primarystage) {
        primaryStage = primarystage;
        //this.primeryStage.setTitle("Quiz Game!");
    
        try {
          // Load the root layout from the fxml file
          FXMLLoader loader = new FXMLLoader(StartGame.class.getResource("/Menu/MenuFXML.fxml"));
          rootLayout = (AnchorPane) loader.load();
          Scene scene = new Scene(rootLayout);
          primaryStage.setScene(scene);
          primaryStage.show();
        } catch (IOException e) {
          // Exception gets thrown if the fxml file could not be loaded
          e.printStackTrace();
        }
    }

    /**
     * Changes scene to an FXML indicated in the string fxml
     * @param fxml
     */
    public static void changeScene(String fxml) {
        try {
            // Load the fxml file and set into the center of the main layout
            FXMLLoader loader = new FXMLLoader(StartGame.class.getResource(fxml));
            AnchorPane newLayout = (AnchorPane) loader.load();
            Scene newScene = new Scene(newLayout);
            primaryStage.setScene(newScene);
            primaryStage.show();
        } catch (IOException e) {
            // Exception gets thrown if the fxml file could not be loaded
            e.printStackTrace();
        }
    }
            
}
    