package Menu;

import Main.StartGame;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

public class MenuFXMLController {
  @FXML
  private Button buttonStart;
  @FXML
  private Button buttonQuestion;
  @FXML
  private Button buttonQuit;
  @FXML
  private ToggleGroup templates;
  @FXML
  private RadioButton flower;
  @FXML
  private RadioButton metalic;
  @FXML
  private RadioButton water;
  
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
  private void changeScene(){
      StartGame.changeScene("/Game/SelectConfigFXML.fxml", getCssTemplate());
  }
  @FXML
  private void changeAddQuestion(){
      StartGame.changeScene("/Contribute/AddQuestionsFXML.fxml", getCssTemplate());
  } 
  @FXML
  private void quitGame(){
      StartGame.quitGame();
  }
  public String getCssTemplate(){
      if (metalic.isSelected())
          return "/Resources/colorTemplateMetalic.css";
      if (water.isSelected())
          return "/Resources/colorTemplateWater.css";
      else
          return "/Resources/colorTemplateFlower.css";
  }
  @FXML
  private void changeCss(){
      StartGame.changeStyle(getCssTemplate());
  }
}
  
  
  
