package Game;

import static Game.SelectPlayersFXMLController.getNumberOfPlayers;
import Main.StartGame;
import Players.PlayerList;
import Questions.Question;
import Server.ServerConnection;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.KeyFrame;
import javafx.animation.PauseTransition;
import javafx.animation.Timeline;
import javafx.animation.Transition;
import javafx.beans.property.ObjectProperty;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author Morten
 */
public class PlayGameFXMLController implements Initializable{
  
    @FXML
    private Label playerName1;
    @FXML
    private Label playerName2;
    @FXML
    private Label playerName3;
    @FXML
    private Label playerName4;
    @FXML 
    private Label playerName5;
    @FXML
    private Label playerName6;
    @FXML
    private Label playerName7;
    @FXML
    private Label playerName8;
    @FXML
    private Label playerName9;
    @FXML
    private Label playerName10;
    @FXML
    private Label playerScore1;
    @FXML
    private Label playerScore2;
    @FXML
    private Label playerScore3;
    @FXML
    private Label playerScore4;
    @FXML
    private Label playerScore5;
    @FXML
    private Label playerScore6;
    @FXML
    private Label playerScore7;
    @FXML
    private Label playerScore8;
    @FXML
    private Label playerScore9;
    @FXML
    private Label playerScore10;
    @FXML
    private Button backButton;
    @FXML
    private Label questionLabel;
    @FXML
    private Button questionButton1;
    @FXML
    private Button questionButton2;
    @FXML
    private Button questionButton3;
    @FXML
    private Button questionButton4;

    // Reference to the main application
    private StartGame startgame;
    ServerConnection server = new ServerConnection();
    int numberOfPlayers = 0;
    private Question currentQuestion = new Question("Dette er spørsmål nr 1");
    private int currentPlayer;
    private PlayerList players;
    private PauseTransition smallBreak = new PauseTransition(Duration.millis(2000));
    boolean canAnswer = true;
    /**
    * The constructor.
    * The constructor is called before the initialize() method.
    */
    public PlayGameFXMLController () {
    }

    @FXML
    private void changeSceneBack(){
        StartGame.changeScene("/Menu/MenuFXML.fxml");
    }

    private void setNameAndScore(PlayerList list) {
        
        playerName1.setText(list.get(0).getName());
        playerScore1.setText(Integer.toString(list.get(0).getScore()));
        numberOfPlayers++;
                
        if (list.get(1).getActive()){
            playerName2.setText(list.get(1).getName());
            playerScore2.setText(Integer.toString(list.get(1).getScore()));
            numberOfPlayers++;
        }
        if (list.get(2).getActive()){
            playerName3.setText(list.get(2).getName());
            playerScore3.setText(Integer.toString(list.get(2).getScore()));
            numberOfPlayers++;
        }
        if (list.get(3).getActive()){
            playerName4.setText(list.get(3).getName());
            playerScore4.setText(Integer.toString(list.get(3).getScore()));
            numberOfPlayers++;
        }
        if (list.get(4).getActive()){
            playerName5.setText(list.get(4).getName());
            playerScore5.setText(Integer.toString(list.get(4).getScore()));
            numberOfPlayers++;
        }
        if (list.get(5).getActive()){
            playerName6.setText(list.get(5).getName());
            playerScore6.setText(Integer.toString(list.get(5).getScore()));
            numberOfPlayers++;
        }
        if (list.get(6).getActive()){
            playerName7.setText(list.get(6).getName());
            playerScore7.setText(Integer.toString(list.get(6).getScore()));
            numberOfPlayers++;
        }
        if (list.get(7).getActive()){
            playerName8.setText(list.get(7).getName());
            playerScore8.setText(Integer.toString(list.get(7).getScore()));
            numberOfPlayers++;
        }
        if (list.get(8).getActive()){
            playerName9.setText(list.get(8).getName());
            playerScore9.setText(Integer.toString(list.get(8).getScore()));
            numberOfPlayers++;
        }
        if (list.get(9).getActive()){
            playerName10.setText(list.get(9).getName());
            playerScore10.setText(Integer.toString(list.get(9).getScore()));
            numberOfPlayers++;
        }
           
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        players = new PlayerList();
        players.addPlayers(getNumberOfPlayers());
        setNameAndScore(players);
        currentPlayer = 1;
        addQuestionInfo();
    } 

    private void addQuestionInfo() {
        questionButton1.setText(currentQuestion.getAnswerA());
        questionButton2.setText(currentQuestion.getAnswerB());
        questionButton3.setText(currentQuestion.getAnswerC());
        questionButton4.setText(currentQuestion.getAnswerD());
        questionLabel.setText(currentQuestion.getQuestion());
        
    }
    private void nextQuestion(){
        getNextQuestion();
        addQuestionInfo();
        canAnswer = true; 
    }
    @FXML
    private void onPressingButtonA(){
        if (currentQuestion.isACorrect() && canAnswer){
            canAnswer = false;
            addScore(currentPlayer);
            questionButton1.setStyle("-fx-background-color: green;");
            smallDelay();
        }
        else if (canAnswer){
            canAnswer = false;
            questionButton1.setStyle("-fx-background-color: red;");
            smallDelay();
        }   
    }
    @FXML
    private void onPressingButtonB(){
        if (currentQuestion.isBCorrect()&& canAnswer){
            canAnswer = false;
            addScore(currentPlayer);
            questionButton2.setStyle("-fx-background-color: green;");
            smallDelay();
            
        }
        else if(canAnswer){
            canAnswer = false;
            questionButton2.setStyle("-fx-background-color: red;");
            smallDelay();
            
        }
            
    }
    @FXML
    private void onPressingButtonC(){
        if (currentQuestion.isCCorrect() && canAnswer){
            canAnswer = false;
            addScore(currentPlayer);
            questionButton3.setStyle("-fx-background-color: green;");
            smallDelay();
            
        }
        else if (canAnswer){
            canAnswer = false;
            questionButton3.setStyle("-fx-background-color: red;");
            smallDelay();
            
        }
            
    }
    @FXML
    private void onPressingButtonD(){
        if (currentQuestion.isDCorrect() && canAnswer){
            canAnswer = false;
            addScore(currentPlayer);
            questionButton4.setStyle("-fx-background-color: green;");
            smallDelay();
            
        }
        else if (canAnswer){
            canAnswer = false;
            questionButton4.setStyle("-fx-background-color: red;");
            smallDelay();
            
        }
    }

    private void addScore(int playerNumber) {
        int temp;
        if (playerNumber == 1){
            temp = Integer.parseInt(playerScore1.getText());
            temp++;
            playerScore1.setText(Integer.toString(temp));
            players.get(playerNumber).increaseScore();
        } 
        else if (playerNumber == 2){
            temp = Integer.parseInt(playerScore2.getText());
            temp++;
            playerScore2.setText(Integer.toString(temp));
            players.get(playerNumber).increaseScore();
        }
        else if (playerNumber == 3){
            temp = Integer.parseInt(playerScore3.getText());
            temp++;
            playerScore3.setText(Integer.toString(temp));
            players.get(playerNumber).increaseScore();
        }
        else if (playerNumber == 4){
            temp = Integer.parseInt(playerScore4.getText());
            temp++;
            playerScore4.setText(Integer.toString(temp));
            players.get(playerNumber).increaseScore();
        }
        else if (playerNumber == 5){
            temp = Integer.parseInt(playerScore5.getText());
            temp++;
            playerScore5.setText(Integer.toString(temp));
            players.get(playerNumber).increaseScore();
        }
        else if (playerNumber == 6){
            temp = Integer.parseInt(playerScore6.getText());
            temp++;
            playerScore6.setText(Integer.toString(temp));
            players.get(playerNumber).increaseScore();
        }
        else if (playerNumber == 7){
            temp = Integer.parseInt(playerScore7.getText());
            temp++;
            playerScore7.setText(Integer.toString(temp));
            players.get(playerNumber).increaseScore();
        }
        else if (playerNumber == 8){
            temp = Integer.parseInt(playerScore8.getText());
            temp++;
            playerScore8.setText(Integer.toString(temp));
            players.get(playerNumber).increaseScore();
        }
        else if (playerNumber == 9){
            temp = Integer.parseInt(playerScore9.getText());
            temp++;
            playerScore9.setText(Integer.toString(temp));
            players.get(playerNumber).increaseScore();
        }
        else if (playerNumber == 10){
            temp = Integer.parseInt(playerScore10.getText());
            temp++;
            playerScore10.setText(Integer.toString(temp));
            players.get(playerNumber).increaseScore();
        }
    }

    private void nextRound() {
        
        questionButton1.setStyle("-fx-text-fill:white;"
                                 +"-fx-font-size: 20px;"
                                 +"-fx-background-color: linear-gradient(#999999 0%, #000000 50%, #999999 100%);"
                                 +"-fx-padding: 5 30 5 30;");
        questionButton2.setStyle("-fx-text-fill:white;"
                                 +"-fx-font-size: 20px;"
                                 +"-fx-background-color: linear-gradient(#999999 0%, #000000 50%, #999999 100%);"
                                 +"-fx-padding: 5 30 5 30;");
        questionButton3.setStyle("-fx-text-fill:white;"
                                 +"-fx-font-size: 20px;"
                                 +"-fx-background-color: linear-gradient(#999999 0%, #000000 50%, #999999 100%);"
                                 +"-fx-padding: 5 30 5 30;");
        questionButton4.setStyle("-fx-text-fill:white;"
                                 +"-fx-font-size: 20px;"
                                 +"-fx-background-color: linear-gradient(#999999 0%, #000000 50%, #999999 100%);"
                                 +"-fx-padding: 5 30 5 30;");
        nextPlayer();
        nextQuestion();
        
        
    }

    private void nextPlayer() {
        if (currentPlayer >= numberOfPlayers)
            currentPlayer = 1;
        else
            currentPlayer++;
    }

    private void smallDelay() {
        smallBreak.onFinishedProperty().set(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent actionEvent) {
            nextRound();
          }
        });
        smallBreak.play();
    }
    private void getNextQuestion() 
    {
        
        currentQuestion = server.getNextQuestion();
         
    }

}
