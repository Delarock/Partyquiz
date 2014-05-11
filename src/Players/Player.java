package Players;

/**
 *
 * @author Morten
 */
public class Player {
    String playerName;
    int playerScore;
    boolean playerActive;
    
    Player(String Name){
        playerName = Name;
        playerScore = 0;
        playerActive = false;
  
        }
    public String getName(){
            return playerName;
    }
    public int getScore(){
        return playerScore;
    }
    public boolean getActive(){
        return playerActive;
    }
    public void setActive(){
        playerActive = true;
    }
    public void increaseScore(){
        playerScore++;
    }
    
    
}
