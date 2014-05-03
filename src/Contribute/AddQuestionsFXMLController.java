package Contribute;

import Main.StartGame;
import Server.ArrayOfQuizCategory;
import Server.QuizCategory;
import Server.ServerConnection;
import java.util.ArrayList;
import java.util.List;
import javafx.beans.value.ObservableListValue;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;

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
  private ToggleGroup answers;
  @FXML
  private ToggleGroup category;
  @FXML
  private RadioButton answer1Radio;
  @FXML
  private RadioButton answer2Radio;
  @FXML
  private RadioButton answer3Radio;
  @FXML
  private RadioButton answer4Radio;
  @FXML
  private RadioButton categorySport;
  @FXML
  private RadioButton categoryGeography;
  @FXML
  private RadioButton categoryEntertainment;
  @FXML
  private RadioButton categoryMixed;
  @FXML
  private RadioButton categoryScience;
  @FXML
  private RadioButton categoryHistory;
  @FXML
  private RadioButton categoryFoodAndDrink;
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
      
//      getAndSetCategoriesSelection();
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
      ServerConnection server = new ServerConnection();
      server.addQuestionForReview(questionString.getText(), answer1String.getText(), answer2String.getText(), answer3String.getText(), answer4String.getText(), getCorrectAnswerChar(), getCategory());
      StartGame.changeScene("/Menu/MenuFXML.fxml");
      
  }

    private int getCorrectAnswerChar() {
        if (answer1Radio.isSelected()){
            return 1;
        }
        else if (answer2Radio.isSelected()){
            return 2;
        }
        else if (answer3Radio.isSelected()){
            return 3;
        }
        else{
            return 4;
        }
    }
    private int getCategory(){
        if (categorySport.isSelected()){
            return 1;
        }
        if (categoryGeography.isSelected()){
            return 2;
        }
        if (categoryEntertainment.isSelected()){
            return 3;
        }
        if (categoryMixed.isSelected()){
            return 4;
        }
        if (categoryScience.isSelected()){
            return 5;
        }
        if (categoryHistory.isSelected()){
            return 6;
        }
        if (categoryFoodAndDrink.isSelected()){
            return 7;
        }
        else return 4;
    }

//    private void getAndSetCategoriesSelection() {
//        category = new ChoiceBox(FXCollections.observableArrayList("First", "Second", "Third"));
//        ServerConnection server = new ServerConnection();
//        List<QuizCategory> arrayCategory = server.getCategories().getQuizCategory();
//        ArrayList list = new ArrayList();
//        String tempString = "\"All\"";
//        for ( QuizCategory q: arrayCategory){
//            tempString = tempString + ",\"" + q.getDescription().getValue() + "\"";  
//        }
//        //category.setItems(FXCollections.observableArrayList("New Document", "Open ", "Save", "Save as"));
//        category = new ChoiceBox(FXCollections.observableArrayList(tempString));
//    }
}
