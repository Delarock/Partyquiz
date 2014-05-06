/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Game;

/**
 *
 * @author Morten
 */
public class Config {
    private static int currentPlayers;
    private static int currentTimeLimit;
    private static int currentQuestionPerPlayerLimit;
    private static boolean timeLimitInUse;
    private static boolean questionLimitInUse;
    private static int currentCssTemplate;

    public Config() {
        currentPlayers = 1;
        currentTimeLimit = 9999;
        currentQuestionPerPlayerLimit = 0;
        timeLimitInUse = false;
        questionLimitInUse = false;
        currentCssTemplate = 1;
        
    }
    public void setCurrentPlayers(int i){
        currentPlayers = i;
    }
    public void setCurrentTimeLimit(int i){
        currentTimeLimit = i;
    }
    public void setCurrentQuestionPerPlayerLimit(int i){
        currentQuestionPerPlayerLimit = i;
    }
    public void setTimeLimitInUse(boolean b){
        timeLimitInUse = b;
    }
    public void setQuestionLimitInUse(boolean b){
        questionLimitInUse = b;
    }
    public void setCurrentCssTemplate(int i){
        currentCssTemplate = i;
    }
    public int getCurrentPlayers(){
        return currentPlayers;
    }
    public int getCurrentTimeLimit(){
        return currentTimeLimit;
    }
    public boolean getTimeLimitInUse(){
        return timeLimitInUse;
    }
    public int getCurrentQuestionPerPlayerLimit(){
        return currentQuestionPerPlayerLimit;
    }
    public boolean getQuestionLimitInUse(){
        return questionLimitInUse;
    }
    public int getCurrentCssTemplate(){
        return currentCssTemplate;
    }


        
        
    
    
}
