package Game;

import static Game.SelectPlayersFXMLController.getNumberOfPlayers;
import Main.StartGame;
import Players.PlayerList;
import Questions.Question;
import Server.ServerConnection;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.PauseTransition;
import javafx.animation.Timeline;
import javafx.animation.Transition;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
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
import javax.swing.SwingUtilities;

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
    private Label questionNumber;
    @FXML
    private Label questionsLeft;
    @FXML
    private Label questionID;
    @FXML
    private Label category;
    @FXML
    private Label difficulty;
    @FXML
    private Button backButton;
    @FXML
    private Button feedbackLastButton;
    @FXML
    private Button feedbackThisButton;
    @FXML
    private Label questionLabel;
    @FXML
    private Label timerLabel;
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
    private Timeline timeline;
    
    // Make timeSeconds a Property
    private static final Integer STARTTIME = 15;
    private Integer timeSeconds;
    
    

    
    /**
    * The constructor.
    * The constructor is called before the initialize() method.
    */
    public PlayGameFXMLController () {
    }

    @FXML
    private void changeSceneBack(){
        StartGame.changeScene("/Menu/MenuFXML.fxml", StartGame.getStyle());
    }

    private void setNameAndScore(PlayerList list) {
        
        playerName1.setText(list.get(0).getName());
        playerScore1.setText(Integer.toString(list.get(0).getScore()));
        numberOfPlayers++;
                
        if (list.get(1).getActive()){
            playerName2.setText(list.get(1).getName());
            playerScore2.setText(Integer.toString(list.get(1).getScore()));
            playerName2.setVisible(true);
            playerScore2.setVisible(true);
            numberOfPlayers++;
        }
        if (list.get(2).getActive()){
            playerName3.setText(list.get(2).getName());
            playerScore3.setText(Integer.toString(list.get(2).getScore()));
            playerName3.setVisible(true);
            playerScore3.setVisible(true);
            numberOfPlayers++;
        }
        if (list.get(3).getActive()){
            playerName4.setText(list.get(3).getName());
            playerScore4.setText(Integer.toString(list.get(3).getScore()));
            playerName4.setVisible(true);
            playerScore4.setVisible(true);
            numberOfPlayers++;
        }
        if (list.get(4).getActive()){
            playerName5.setText(list.get(4).getName());
            playerScore5.setText(Integer.toString(list.get(4).getScore()));
            playerName5.setVisible(true);
            playerScore5.setVisible(true);
            numberOfPlayers++;
        }
        if (list.get(5).getActive()){
            playerName6.setText(list.get(5).getName());
            playerScore6.setText(Integer.toString(list.get(5).getScore()));
            playerName6.setVisible(true);
            playerScore6.setVisible(true);
            numberOfPlayers++;
        }
        if (list.get(6).getActive()){
            playerName7.setText(list.get(6).getName());
            playerScore7.setText(Integer.toString(list.get(6).getScore()));
            playerName7.setVisible(true);
            playerScore7.setVisible(true);
            numberOfPlayers++;
        }
        if (list.get(7).getActive()){
            playerName8.setText(list.get(7).getName());
            playerScore8.setText(Integer.toString(list.get(7).getScore()));
            playerName8.setVisible(true);
            playerScore8.setVisible(true);
            numberOfPlayers++;
        }
        if (list.get(8).getActive()){
            playerName9.setText(list.get(8).getName());
            playerScore9.setText(Integer.toString(list.get(8).getScore()));
            playerName9.setVisible(true);
            playerScore9.setVisible(true);
            numberOfPlayers++;
        }
        if (list.get(9).getActive()){
            playerName10.setText(list.get(9).getName());
            playerScore10.setText(Integer.toString(list.get(9).getScore()));
            playerName10.setVisible(true);
            playerScore10.setVisible(true);
            numberOfPlayers++;
        }
         
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        players = new PlayerList();
        players.addPlayers(getNumberOfPlayers());
        timerLabel.setText("100");
        setNameAndScore(players);
        currentPlayer = 1;
        nextQuestion();
        indicateCurrentPlayer(currentPlayer);
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
        startTimer();
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
            playerScore1.setStyle("-fx-text-fill: green;"
                                +"-fx-font-size: 18;"
                                +"-fx-font-weight: bold;");
            playerName1.setStyle("-fx-text-fill: green;"
                                +"-fx-font-size: 18;"
                                +"-fx-font-weight: bold;");
            players.get(playerNumber).increaseScore();
        } 
        else if (playerNumber == 2){
            temp = Integer.parseInt(playerScore2.getText());
            temp++;
            playerScore2.setText(Integer.toString(temp));
            playerScore2.setStyle("-fx-text-fill: green;"
                                +"-fx-font-size: 18;"
                                +"-fx-font-weight: bold;");
            playerName2.setStyle("-fx-text-fill: green;"
                                +"-fx-font-size: 18;"
                                +"-fx-font-weight: bold;");
            players.get(playerNumber).increaseScore();
        }
        else if (playerNumber == 3){
            temp = Integer.parseInt(playerScore3.getText());
            temp++;
            playerScore3.setText(Integer.toString(temp));
            playerScore3.setStyle("-fx-text-fill: green;"
                                +"-fx-font-size: 18;"
                                +"-fx-font-weight: bold;");
            playerName3.setStyle("-fx-text-fill: green;"
                                +"-fx-font-size: 18;"
                                +"-fx-font-weight: bold;");
            players.get(playerNumber).increaseScore();
        }
        else if (playerNumber == 4){
            temp = Integer.parseInt(playerScore4.getText());
            temp++;
            playerScore4.setText(Integer.toString(temp));
            playerScore4.setStyle("-fx-text-fill: green;"
                                +"-fx-font-size: 18;"
                                +"-fx-font-weight: bold;");
            playerName4.setStyle("-fx-text-fill: green;"
                                +"-fx-font-size: 18;"
                                +"-fx-font-weight: bold;");
            players.get(playerNumber).increaseScore();
        }
        else if (playerNumber == 5){
            temp = Integer.parseInt(playerScore5.getText());
            temp++;
            playerScore5.setText(Integer.toString(temp));
            playerScore5.setStyle("-fx-text-fill: green;"
                                +"-fx-font-size: 18;"
                                +"-fx-font-weight: bold;");
            playerName5.setStyle("-fx-text-fill: green;"
                                +"-fx-font-size: 18;"
                                +"-fx-font-weight: bold;");
            players.get(playerNumber).increaseScore();
        }
        else if (playerNumber == 6){
            temp = Integer.parseInt(playerScore6.getText());
            temp++;
            playerScore6.setText(Integer.toString(temp));
            playerScore6.setStyle("-fx-text-fill: green;"
                                +"-fx-font-size: 18;"
                                +"-fx-font-weight: bold;");
            playerName6.setStyle("-fx-text-fill: green;"
                                +"-fx-font-size: 18;"
                                +"-fx-font-weight: bold;");
            players.get(playerNumber).increaseScore();
        }
        else if (playerNumber == 7){
            temp = Integer.parseInt(playerScore7.getText());
            temp++;
            playerScore7.setText(Integer.toString(temp));
            playerScore7.setStyle("-fx-text-fill: green;"
                                +"-fx-font-size: 18;"
                                +"-fx-font-weight: bold;");
            playerName7.setStyle("-fx-text-fill: green;"
                                +"-fx-font-size: 18;"
                                +"-fx-font-weight: bold;");
            players.get(playerNumber).increaseScore();
        }
        else if (playerNumber == 8){
            temp = Integer.parseInt(playerScore8.getText());
            temp++;
            playerScore8.setText(Integer.toString(temp));
            playerScore8.setStyle("-fx-text-fill: green;"
                                +"-fx-font-size: 18;"
                                +"-fx-font-weight: bold;");
            playerName8.setStyle("-fx-text-fill: green;"
                                +"-fx-font-size: 18;"
                                +"-fx-font-weight: bold;");
            players.get(playerNumber).increaseScore();
        }
        else if (playerNumber == 9){
            temp = Integer.parseInt(playerScore9.getText());
            temp++;
            playerScore9.setText(Integer.toString(temp));
            playerScore9.setStyle("-fx-text-fill: green;"
                                +"-fx-font-size: 18;"
                                +"-fx-font-weight: bold;");
            playerName9.setStyle("-fx-text-fill: green;"
                                +"-fx-font-size: 18;"
                                +"-fx-font-weight: bold;");
            players.get(playerNumber).increaseScore();
        }
        else if (playerNumber == 10){
            temp = Integer.parseInt(playerScore10.getText());
            temp++;
            playerScore10.setText(Integer.toString(temp));
            playerScore10.setStyle("-fx-text-fill: green;"
                                +"-fx-font-size: 18;"
                                +"-fx-font-weight: bold;");
            playerName10.setStyle("-fx-text-fill: green;"
                                +"-fx-font-size: 18;"
                                +"-fx-font-weight: bold;");
            players.get(playerNumber).increaseScore();
        }
    }

    private void nextRound() {
        
        questionButton1.setStyle("questionbutton");
        questionButton2.setStyle("questionbutton");
        questionButton3.setStyle("questionbutton");
        questionButton4.setStyle("questionbutton");
        playerName1.setStyle("label");
        playerScore1.setStyle("label");
        playerName2.setStyle("label");
        playerScore2.setStyle("label");
        playerName3.setStyle("label");
        playerScore3.setStyle("label");
        playerName4.setStyle("label");
        playerScore4.setStyle("label");
        playerName5.setStyle("label");
        playerScore5.setStyle("label");
        playerName6.setStyle("label");
        playerScore6.setStyle("label");
        playerName7.setStyle("label");
        playerScore7.setStyle("label");
        playerName8.setStyle("label");
        playerScore8.setStyle("label");
        playerName9.setStyle("label");
        playerScore9.setStyle("label");
        playerName10.setStyle("label");
        playerScore10.setStyle("label");
        
        nextPlayer();
        nextQuestion();
        indicateCurrentPlayer(currentPlayer);
        
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
    private void indicateCurrentPlayer(int playerNumber) {
        if (playerNumber == 1){
            playerScore1.setStyle("-fx-font-size: 18;"
                                +"-fx-font-weight: bold;");
            playerName1.setStyle("-fx-font-size: 18;"
                                +"-fx-font-weight: bold;");
        } 
        else if (playerNumber == 2){
            playerScore2.setStyle("-fx-font-size: 18;"
                                +"-fx-font-weight: bold;");
            playerName2.setStyle("-fx-font-size: 18;"
                                +"-fx-font-weight: bold;");
        }
        else if (playerNumber == 3){
            playerScore3.setStyle("-fx-font-size: 18;"
                                +"-fx-font-weight: bold;");
            playerName3.setStyle("-fx-font-size: 18;"
                                +"-fx-font-weight: bold;");
        }
        else if (playerNumber == 4){
            playerScore4.setStyle("-fx-font-size: 18;"
                                +"-fx-font-weight: bold;");
            playerName4.setStyle("-fx-font-size: 18;"
                                +"-fx-font-weight: bold;");
        }
        else if (playerNumber == 5){
            playerScore5.setStyle("-fx-font-size: 18;"
                                +"-fx-font-weight: bold;");
            playerName5.setStyle("-fx-font-size: 18;"
                                +"-fx-font-weight: bold;");
        }
        else if (playerNumber == 6){
            playerScore6.setStyle("-fx-font-size: 18;"
                                +"-fx-font-weight: bold;");
            playerName6.setStyle("-fx-font-size: 18;"
                                +"-fx-font-weight: bold;");
        }
        else if (playerNumber == 7){
            playerScore7.setStyle("-fx-font-size: 18;"
                                +"-fx-font-weight: bold;");
            playerName7.setStyle("-fx-font-size: 18;"
                                +"-fx-font-weight: bold;");
        }
        else if (playerNumber == 8){
            playerScore8.setStyle("-fx-font-size: 18;"
                                +"-fx-font-weight: bold;");
            playerName8.setStyle("-fx-font-size: 18;"
                                +"-fx-font-weight: bold;");
        }
        else if (playerNumber == 9){
            playerScore9.setStyle("-fx-font-size: 18;"
                                +"-fx-font-weight: bold;");
            playerName9.setStyle("-fx-font-size: 18;"
                                +"-fx-font-weight: bold;");
        }
        else if (playerNumber == 10){
            playerScore10.setStyle("-fx-font-size: 18;"
                                +"-fx-font-weight: bold;");
            playerName10.setStyle("-fx-font-size: 18;"
                                +"-fx-font-weight: bold;");
        }    
    }
        private void startTimer() {
            //TODO
        }
         
}
