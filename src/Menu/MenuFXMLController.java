package Menu;

import Main.StartGame;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class MenuFXMLController {
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
  public MenuFXMLController() {
  }
  
  /**
  * Initializes the controller class. This method is automatically called
  * after the fxml file has been loaded.
  */
  @FXML
  private void initialize() {
             
  }
  @FXML
  private void changeScene(){
      StartGame.changeScene("/Game/SelectPlayersFXML.fxml");
  }  
}
  
  
  
