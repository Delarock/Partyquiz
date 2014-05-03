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
  private static TextField nameField1;
  @FXML
  private static TextField nameField2;
  @FXML
  private static TextField nameField3;
  @FXML
  private static TextField nameField4;
  @FXML
  private static TextField nameField5;
  @FXML
  private static TextField nameField6;
  @FXML
  private static TextField nameField7;
  @FXML
  private static TextField nameField8;
  @FXML
  private static TextField nameField9;
  @FXML
  private static TextField nameField10;
  public static int numberOfPlayers = 0;
  
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
      StartGame.changeScene("/Game/SelectConfigFXML.fxml");
  }
  
  @FXML
  private void changeSceneForward(){
      StartGame.changeScene("/Game/PlayGameFXML.fxml");
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
        numberOfPlayers = 2;
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
        numberOfPlayers = 3;
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
        numberOfPlayers = 4;
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
        numberOfPlayers = 5;
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
        numberOfPlayers = 6;
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
        numberOfPlayers = 7;
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
        numberOfPlayers = 8;
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
        numberOfPlayers = 9;
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
        numberOfPlayers = 10;
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
        numberOfPlayers = 1;
     }       
   }
  public static int getNumberOfPlayers()
     {
         return numberOfPlayers;
     }
  public static String getName1(){
      return nameField1.getText();
  }
  public static String getName2(){
      return nameField2.getText();
  }
  public static String getName3(){
      return nameField3.getText();
  }
  public static String getName4(){
      return nameField4.getText();
  }
  public static String getName5(){
      return nameField5.getText();
  }
  public static String getName6(){
      return nameField6.getText();
  }
  public static String getName7(){
      return nameField7.getText();
  }
  public static String getName8(){
      return nameField8.getText();
  }
  public static String getName9(){
      return nameField9.getText();
  }
  public static String getName10(){
      return nameField10.getText();
  }

}
