package Game;

import static Game.SelectConfigFXMLController.questionsPerPlayerInUser;
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
  static int questionsPerPlayer = 0;
  static int timeLimit = 0;
  static boolean timeLimitInUse = false;
  static boolean questionsPerPlayerInUser = false;
  private StartGame startgame;
  private Config localConfig = StartGame.getConfig();
  
  /**
  * The constructor.
  * The constructor is called before the initialize() method.
  */
  public SelectConfigFXMLController() {
  }
  
  @FXML
  private void changeSceneBack(){
      StartGame.updateConfig(localConfig);
      StartGame.changeScene("/Menu/MenuFXML.fxml", StartGame.getStyle());
  }
  
  @FXML
  private void changeSceneForward(){
      setTimeLimitAndStatus();
      setQuestionNumber();
      StartGame.updateConfig(localConfig);
      StartGame.changeScene("/Game/SelectPlayersFXML.fxml", StartGame.getStyle());
  }
  public boolean getTimeLimitStatus(){
      return timeLimitInUse;
  }
  public static int getTimeLimit(){
      return timeLimit;
  }
  @FXML
  private void setTimeLimitAndStatus(){
      if (tenSec.isSelected()){
          timeLimit = 10;
          timeLimitInUse = true;
      }
      else if (thirthySec.isSelected()){
          timeLimit = 30;
          timeLimitInUse = true;
      }
      else if (oneMin.isSelected()){
          timeLimit = 60;
          timeLimitInUse = true;
      }
      else if (twoMin.isSelected()){
          timeLimit = 120;
          timeLimitInUse = true;
      }
      else {
          timeLimit = 9999;
          timeLimitInUse = false;
      }
      localConfig.setCurrentTimeLimit(timeLimit);
      localConfig.setTimeLimitInUse(timeLimitInUse);
  }
  @FXML
  private void setQuestionNumber(){
    if (fiveQuestions.isSelected()){
        questionsPerPlayer = 5;
        questionsPerPlayerInUser = true;
    }
    else if (tenQuestions.isSelected()){
        questionsPerPlayer = 10;
        questionsPerPlayerInUser = true;
    }
    else if (twentyQuestions.isSelected()){
        questionsPerPlayer = 20;
        questionsPerPlayerInUser = true;
    }
    else if (thirthyQuestions.isSelected()){
        questionsPerPlayer = 30;
        questionsPerPlayerInUser = true;
    }
    else if (fiftyQuestions.isSelected()){
        questionsPerPlayer = 50;
        questionsPerPlayerInUser = true;
    }
    else if (hundredQuestions.isSelected()){
        questionsPerPlayer = 100;
        questionsPerPlayerInUser = true;
    }
    else {
        questionsPerPlayer = 0;
        questionsPerPlayerInUser = false;    
    }
    
    localConfig.setCurrentQuestionPerPlayerLimit(questionsPerPlayer);
    localConfig.setQuestionLimitInUse(questionsPerPlayerInUser);
    
  }
  public int getQuestionsPerPlayer(){
      return questionsPerPlayer; 
  }
  public static boolean getQuestionPerPlayerInUse(){
      return questionsPerPlayerInUser;
  }
  
}
