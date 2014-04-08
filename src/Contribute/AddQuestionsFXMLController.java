package Contribute;

import Main.StartGame;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class AddQuestionsFXMLController {
  
  @FXML
  private TextField questionString;
  @FXML
  private TextField answer1String;
  @FXML
  private TextField answer2String;
  @FXML
  private TextField answer3String;
  @FXML
  private TextField answer4String;
  @FXML
  private TextField category;
  @FXML
  private TextField subcategory;
  @FXML
  private ToggleGroup answers;
  @FXML
  private RadioButton answer1Radio;
  @FXML
  private RadioButton answer2Radio;
  @FXML
  private RadioButton answer3Radio;
  @FXML
  private RadioButton answer4Radio;
  @FXML
  private Button buttonBack;
  @FXML
  private Button buttonSend;
  
  
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
      StartGame.changeScene("/Menu/MenuFXML.fxml");
  }  
  @FXML
  private void sendQuestion(){
      StartGame.changeScene("/Menu/MenuFXML.fxml");
  }
}
