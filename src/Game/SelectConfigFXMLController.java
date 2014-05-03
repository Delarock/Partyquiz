package Game;

import Main.StartGame;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class SelectConfigFXMLController {
  @FXML
  private Button buttonBack;
  @FXML
  private Button buttonNext;
  @FXML
  private ToggleGroup gameTypeGroup;
  @FXML
  private ToggleGroup gameTimeGroup;
  @FXML
  private ToggleGroup gameQuestionGroup;
  @FXML
  private RadioButton fiveQuestions;
  @FXML
  private RadioButton tenQuestions;
  @FXML
  private RadioButton twentyQuestions;
  @FXML
  private RadioButton thirthyQuestions;
  @FXML
  private RadioButton fiftyQuestions;
  @FXML
  private RadioButton hundredQuestions;
  @FXML
  private RadioButton unlimitedQuestions;
  @FXML
  private RadioButton tenSec;
  @FXML
  private RadioButton thirthySec;
  @FXML
  private RadioButton oneMin;
  @FXML
  private RadioButton twoMin;
  @FXML
  private RadioButton unlimitedTime;
  @FXML
  private RadioButton roundRobin;
  @FXML
  private RadioButton everyoneAnswers;
  @FXML
  private RadioButton drinkingGame;  
  // Reference to the main application
  private StartGame startgame;
  
  /**
  * The constructor.
  * The constructor is called before the initialize() method.
  */
  public SelectConfigFXMLController() {
  }
  
  @FXML
  private void changeSceneBack(){
      StartGame.changeScene("/Menu/MenuFXML.fxml");
  }
  
  @FXML
  private void changeSceneForward(){
      StartGame.changeScene("/Game/SelectPlayersFXML.fxml");
  }
}
