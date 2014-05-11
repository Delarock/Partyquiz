/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Main;

import Game.Config;
import Menu.MenuFXMLController;
import com.sun.javafx.css.Stylesheet;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class StartGame extends Application {
    private static Stage primaryStage;
    private static AnchorPane rootLayout;
    private static Config currentConfig;
            
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
          primarystage.getScene().getStylesheets().add("/Resources/colorTemplateFlower.css");
          currentConfig = new Config();
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
    public static void changeScene(String fxml, String css) {
        try {
            // Load the fxml file and set into the center of the main layout
            FXMLLoader loader = new FXMLLoader(StartGame.class.getResource(fxml));
            AnchorPane newLayout = (AnchorPane) loader.load();
            Scene newScene = new Scene(newLayout);
            newScene.getStylesheets().clear();
            newScene.getStylesheets().add(css);
            primaryStage.setScene(newScene);
            primaryStage.show();
        } catch (IOException e) {
            // Exception gets thrown if the fxml file could not be loaded
            e.printStackTrace();
        }
    }
    public static void changeStyle(String css) {
        primaryStage.getScene().getStylesheets().clear();
        primaryStage.getScene().getStylesheets().add(css);
    }
    public static String getStyle(){
        return primaryStage.getScene().getStylesheets().get(0);
    }
    public static Config getConfig(){
        return currentConfig;
    }
    public static void updateConfig(Config config){
        currentConfig = config;
    }
    
    public static void quitGame(){
        Platform.exit();
        System.exit(0);
    }   
}
    