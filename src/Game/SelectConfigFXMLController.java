package Game;

import Main.StartGame;
import Menu.MenuFXMLController;
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
  int questionsPerPlayer = 0;
  int timeLimit = 0;
  boolean timeLimitInUse = false;
  private StartGame startgame;
  
  /**
  * The constructor.
  * The constructor is called before the initialize() method.
  */
  public SelectConfigFXMLController() {
  }
  
  @FXML
  private void changeSceneBack(){
      StartGame.changeScene("/Menu/MenuFXML.fxml", StartGame.getStyle());
  }
  
  @FXML
  private void changeSceneForward(){
      StartGame.changeScene("/Game/SelectPlayersFXML.fxml", StartGame.getStyle());
  }
  public boolean getTimeLimitStatus(){
      return timeLimitInUse;
  }
  public int getTimeLimit(){
      return timeLimit;
  }
  private void setTimeLimitAndStatus(){
      if (tenSec.isSelected()){
          timeLimit = 10;
          timeLimitInUse = true;
      }
      if (thirthySec.isSelected()){
          timeLimit = 30;
          timeLimitInUse = true;
      }
      if (oneMin.isSelected()){
          timeLimit = 60;
          timeLimitInUse = true;
      }
      if (twoMin.isSelected()){
          timeLimit = 120;
          timeLimitInUse = true;
      }
      else {
          timeLimit = 9999;
          timeLimitInUse = false;
      }
  }
  private void setQuestionNumber(){
    if (fiveQuestions.isSelected())
        questionsPerPlayer = 5;
    if (tenQuestions.isSelected())
        questionsPerPlayer = 10;
    if (twentyQuestions.isSelected())
        questionsPerPlayer = 20;
    if (thirthyQuestions.isSelected())
        questionsPerPlayer = 30;
    if (fiftyQuestions.isSelected())
        questionsPerPlayer = 50;
    if (hundredQuestions.isSelected())
        questionsPerPlayer = 100;
    else questionsPerPlayer = 0;
    
  }
  public int getQuestionsPerPlayer(){
      return questionsPerPlayer; 
  }
  
}
