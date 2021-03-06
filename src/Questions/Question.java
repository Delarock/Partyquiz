package Questions;

/**
 *
 * @author Morten
 */
public class Question {
    private int qID;
    private String questionString, answerA, answerB, answerC, answerD, category, subcategory, difficulty;
    private Boolean correctA, correctB, correctC, correctD;
    
    public Question(String spørsmål){
        questionString = spørsmål;
        answerA = "Dette er svar alternativ A";
        answerB = "Dette er svar alternativ B";
        answerC = "Dette er svar alternativ C";
        answerD = "Dette er svar alternativ D";
        category = "Underholdning";
        subcategory = "Film";
        difficulty = "N/A";
        correctA = false;
        correctB = false;
        correctC = true;
        correctD = false;
        
    }
    public Question(int Id, String Question, String A, String B, String C, String D, boolean IsA,  boolean IsB, boolean IsC, boolean IsD, String Category, String Subcategory)
    {
        qID = Id;
        questionString = Question;
        answerA = A;
        correctA = IsA;
        answerB = B;
        correctB = IsB;
        answerC = C;
        correctC = IsC;
        answerD = D;
        correctD = IsD;
        category = Category;
        subcategory = Subcategory;
         
    }
    public int getQuestionID(){
        return qID;
    }
    public String getQuestion(){
        return questionString;
    }
    public String getAnswerA(){
        return answerA;
    }
    public String getAnswerB(){
        return answerB;
    }
    public String getAnswerC(){
        return answerC;
    }
    public String getAnswerD(){
        return answerD;
    }
    public String getCategory(){
        return category;
    }
    public String getSubcategory(){
        return subcategory;
    }
    public String getDifficulty(){
        return difficulty;
    }
    public boolean isACorrect(){
        return correctA;
    }
    public boolean isBCorrect(){
        return correctB;
    }
    public boolean isCCorrect(){
        return correctC;
    }
    public boolean isDCorrect(){
        return correctD;
    }
       
    
}
