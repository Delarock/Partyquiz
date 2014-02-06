/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Menu;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

/**
 *
 * @author Morten
 */
public class MenuScene{
    
    public Scene MenuScene(){
        StackPane root = new StackPane();
        Scene scene = new Scene(root, 1200, 600);
        Button newGame = new Button("Start New Game");
        Button contributeQuestion = new Button("Send in Question");
        Button approveQuestion = new Button("Approve Questions");
        Button quitGame = new Button("Quit Game");
        VBox buttonBox = new VBox();
        
        
        newGame.setPrefSize(150, 50);
        newGame.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            }
        });
        
        contributeQuestion.setPrefSize(150, 50);
        contributeQuestion.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            }
        });
        
        approveQuestion.setPrefSize(150, 50);
        approveQuestion.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            }
        });
        
        quitGame.setPrefSize(150, 50);
        quitGame.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            }
        });
        
        buttonBox.alignmentProperty().set(Pos.CENTER);
        buttonBox.setPadding(new Insets(10.0, 10.0, 10.0, 10.0));
        buttonBox.setSpacing(10);
        //buttonBox.setStyle("-fx-background-color: #336699;");
        
        buttonBox.getChildren().addAll(newGame, contributeQuestion, approveQuestion, quitGame);
        root.getChildren().add(buttonBox);
        scene.getStylesheets().add("/Resources/SceneCSS.css");
        return scene;
    }
    
}
