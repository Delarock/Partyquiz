package Contribute;

import Main.StartGame;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class AddQuestionsFXMLController {
  @FXML
  private Button buttonStart;
  @FXML
  private Button buttonQuestion;
  @FXML
  private Button buttonQuit;
  
  // Reference to the main application
  private StartGame startgame;
  
  /**
  * The constructor.
  * The constructor is called before the initialize() method.
  */
  public AddQuestionsFXMLController() {
  }
  
  /**
  * Initializes the controller class. This method is automatically called
  * after the fxml file has been loaded.
  */
  
  @FXML
  private void changeBack(){
      StartGame.changeScene("/Game/SelectPlayersFXML.fxml");
  }  
  @FXML
  private void quitGame(){
      StartGame.quitGame();
  }
}
