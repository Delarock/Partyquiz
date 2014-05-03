package Server;
 
import Questions.Question;


public class ServerConnection {
     IQuizitionService service = new QuizitionService().getBasicHttpBindingIQuizitionService();
     ArrayOfQuizQuestion questionList = getNewQuestionList();
     ObjectFactory factory = new ObjectFactory();
     
    public ServerConnection()
    {
        
    }
 
    public void addQuestionForReview(String question, String answerA, String answerB, String answerC, String answerD, int correct, int category) 
    {
        
        service.addQuestionAsStrings(question, answerA, answerB, answerC, answerD, category, correct);
        
    }
    public Question getNextQuestion()
    {
        if (questionList.getQuizQuestion().isEmpty()){
            questionList = getNewQuestionList();
        } 
        
        int qId = questionList.getQuizQuestion().get(0).getQuestionId();
        String question = questionList.getQuizQuestion().get(0).getText().getValue();
        String answerA = questionList.getQuizQuestion().get(0).getAnswers().getValue().getQuizAnswer().get(0).getText().getValue();
        String answerB = questionList.getQuizQuestion().get(0).getAnswers().getValue().getQuizAnswer().get(1).getText().getValue();
        String answerC = questionList.getQuizQuestion().get(0).getAnswers().getValue().getQuizAnswer().get(2).getText().getValue();
        String answerD = questionList.getQuizQuestion().get(0).getAnswers().getValue().getQuizAnswer().get(3).getText().getValue();
        Boolean isA = questionList.getQuizQuestion().get(0).getAnswers().getValue().getQuizAnswer().get(0).isIsCorrect();
        Boolean isB = questionList.getQuizQuestion().get(0).getAnswers().getValue().getQuizAnswer().get(1).isIsCorrect();
        Boolean isC = questionList.getQuizQuestion().get(0).getAnswers().getValue().getQuizAnswer().get(2).isIsCorrect();
        Boolean isD = questionList.getQuizQuestion().get(0).getAnswers().getValue().getQuizAnswer().get(3).isIsCorrect();
        String category = questionList.getQuizQuestion().get(0).getCategory().getValue().getDescription().getValue();
        String subcategory = questionList.getQuizQuestion().remove(0).getCategory().getValue().getDescription().getValue();
        
        
        return new Question(qId, question, answerA, answerB, answerC, answerD, isA, isB, isC, isD, category, subcategory);
         
    }
    public ArrayOfQuizQuestion getNewQuestionList(){
       ArrayOfQuizQuestion localQuestionArray = service.getQuestions(50, null);
       return localQuestionArray;
    }
    
    public void transferApprovedQuestion(String question, String answerA, String answerB, String answerC, String answerD, String correct, String category, String subcategory)
    {
        //TODO
         
    }
    public void rejectAndDeleteQuestion()
    {
        //TODO
    }
     
    public void complainOnLastQuestion(int lastQuestion)
    {
        //TODO
    }
     
    public void correctAnswer(int question)
    {
        //TODO
    }

    public ArrayOfQuizCategory getCategories() {
        return service.getAllCategories();
    }
    

    
}
