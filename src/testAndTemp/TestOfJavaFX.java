/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package testAndTemp;

import Menu.MenuScene;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;


public class TestOfJavaFX extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
                        //scene.getStylesheets().add("Resources/StackPaneCSS.css");
			primaryStage.setScene(new MenuScene().MenuScene());
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

