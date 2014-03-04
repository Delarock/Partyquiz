package Game;

import Main.StartGame;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class SelectPlayersFXMLController {
  @FXML
  private Button buttonBack;
  @FXML
  private Button buttonNext;
  @FXML
  private ToggleGroup playerGroup;
  @FXML
  private RadioButton radioPlayers1;
  @FXML
  private RadioButton radioPlayers2;
  @FXML
  private RadioButton radioPlayers3;
  @FXML
  private RadioButton radioPlayers4;
  @FXML
  private RadioButton radioPlayers5;
  @FXML
  private RadioButton radioPlayers6;
  @FXML
  private RadioButton radioPlayers7;
  @FXML
  private RadioButton radioPlayers8;
  @FXML
  private RadioButton radioPlayers9;
  @FXML
  private RadioButton radioPlayers10;
  @FXML
  private TextField nameField1;
  @FXML
  private TextField nameField2;
  @FXML
  private TextField nameField3;
  @FXML
  private TextField nameField4;
  @FXML
  private TextField nameField5;
  @FXML
  private TextField nameField6;
  @FXML
  private TextField nameField7;
  @FXML
  private TextField nameField8;
  @FXML
  private TextField nameField9;
  @FXML
  private TextField nameField10;
  
  // Reference to the main application
  private StartGame startgame;
  
  /**
  * The constructor.
  * The constructor is called before the initialize() method.
  */
  public SelectPlayersFXMLController() {
  }
  
  @FXML
  private void changeSceneBack(){
      StartGame.changeScene("/Menu/MenuFXML.fxml");
  }
  
  @FXML
  private void changeSceneForward(){
      //StartGame.changeScene("");
  }
  @FXML
  private void checkPlayers(){
      
     if (radioPlayers2.isSelected()){
        nameField2.setDisable(false);
        nameField3.setDisable(true);
        nameField4.setDisable(true);
        nameField5.setDisable(true);
        nameField6.setDisable(true);
        nameField7.setDisable(true);
        nameField8.setDisable(true);
        nameField9.setDisable(true);
        nameField10.setDisable(true);
     }
     else if (radioPlayers3.isSelected()){
        nameField2.setDisable(false);
        nameField3.setDisable(false);
        nameField4.setDisable(true);
        nameField5.setDisable(true);
        nameField6.setDisable(true);
        nameField7.setDisable(true);
        nameField8.setDisable(true);
        nameField9.setDisable(true);
        nameField10.setDisable(true);
     }
     else if (radioPlayers4.isSelected()){
        nameField2.setDisable(false);
        nameField3.setDisable(false);
        nameField4.setDisable(false);
        nameField5.setDisable(true);
        nameField6.setDisable(true);
        nameField7.setDisable(true);
        nameField8.setDisable(true);
        nameField9.setDisable(true);
        nameField10.setDisable(true);
     }
     else if (radioPlayers5.isSelected()){
        nameField2.setDisable(false);
        nameField3.setDisable(false);
        nameField4.setDisable(false);
        nameField5.setDisable(false);
        nameField6.setDisable(true);
        nameField7.setDisable(true);
        nameField8.setDisable(true);
        nameField9.setDisable(true);
        nameField10.setDisable(true);
     }
     else if (radioPlayers6.isSelected()){
        nameField2.setDisable(false);
        nameField3.setDisable(false);
        nameField4.setDisable(false);
        nameField5.setDisable(false);
        nameField6.setDisable(false);
        nameField7.setDisable(true);
        nameField8.setDisable(true);
        nameField9.setDisable(true);
        nameField10.setDisable(true);
     }
     else if (radioPlayers7.isSelected()){
        nameField2.setDisable(false);
        nameField3.setDisable(false);
        nameField4.setDisable(false);
        nameField5.setDisable(false);
        nameField6.setDisable(false);
        nameField7.setDisable(false);
        nameField8.setDisable(true);
        nameField9.setDisable(true);
        nameField10.setDisable(true);
     }
     else if (radioPlayers8.isSelected()){
        nameField2.setDisable(false);
        nameField3.setDisable(false);
        nameField4.setDisable(false);
        nameField5.setDisable(false);
        nameField6.setDisable(false);
        nameField7.setDisable(false);
        nameField8.setDisable(false);
        nameField9.setDisable(true);
        nameField10.setDisable(true);
     }
     else if (radioPlayers9.isSelected()){
        nameField2.setDisable(false);
        nameField3.setDisable(false);
        nameField4.setDisable(false);
        nameField5.setDisable(false);
        nameField6.setDisable(false);
        nameField7.setDisable(false);
        nameField8.setDisable(false);
        nameField9.setDisable(false);
        nameField10.setDisable(true);
     }
     else if (radioPlayers10.isSelected()){
        nameField2.setDisable(false);
        nameField3.setDisable(false);
        nameField4.setDisable(false);
        nameField5.setDisable(false);
        nameField6.setDisable(false);
        nameField7.setDisable(false);
        nameField8.setDisable(false);
        nameField9.setDisable(false);
        nameField10.setDisable(false);
     }
     else{
        nameField2.setDisable(true);
        nameField3.setDisable(true);
        nameField4.setDisable(true);
        nameField5.setDisable(true);
        nameField6.setDisable(true);
        nameField7.setDisable(true);
        nameField8.setDisable(true);
        nameField9.setDisable(true);
        nameField10.setDisable(true);
     }
         
   }
}
