package Server;
 
import Questions.Question;
import java.util.List;
import javax.xml.bind.JAXBElement;
 
public class ServerConnection {
     QuizitionService service = new QuizitionService();
     ArrayOfQuizQuestion questionList = getNewQuestionList();
     ObjectFactory factory = new ObjectFactory();
     
    public ServerConnection()
    {
        
    }
 
    public void addQuestionForReview(String question, String answerA, String answerB, String answerC, String answerD, String correct, String category) 
    {
        QuizAnswer tempAnswerA = new QuizAnswer();
            tempAnswerA.setIsCorrect(correct == "A");
            tempAnswerA.setText(factory.createQuizAnswerText(answerA));
        QuizAnswer tempAnswerB = new QuizAnswer();
            tempAnswerB.setIsCorrect(correct == "B");
            tempAnswerB.setText(factory.createQuizAnswerText(answerB));
        QuizAnswer tempAnswerC = new QuizAnswer();
            tempAnswerC.setIsCorrect(correct == "C");
            tempAnswerC.setText(factory.createQuizAnswerText(answerC));
        QuizAnswer tempAnswerD = new QuizAnswer();
            tempAnswerD.setIsCorrect(correct == "D");
            tempAnswerD.setText(factory.createQuizAnswerText(answerD));
        
        List<QuizAnswer> answerList = null;
            answerList.add(tempAnswerA);
            answerList.add(tempAnswerB);
            answerList.add(tempAnswerC);
            answerList.add(tempAnswerD);
         ArrayOfQuizAnswer answers = factory.createArrayOfQuizAnswer(); //Hvordan gi verdi til denne?
         JAXBElement<ArrayOfQuizAnswer> JAXanswers = factory.createArrayOfQuizAnswer(answers);
         
        QuizQuestion tempQuestion = factory.createQuizQuestion();
            tempQuestion.setText(factory.createString(question));
            tempQuestion.setAnswers(JAXanswers);
            tempQuestion.setCategory(null);
        //service.getBasicHttpBindingIQuizitionService().addQuestion(new QuizQuestion();
    }
    public Question getNextQuestion()
    {
        if (questionList.getQuizQuestion().isEmpty()){
            questionList = getNewQuestionList();
        } 
        for (QuizQuestion question : questionList.getQuizQuestion())
        {
            System.out.println(question.getQuestionId().toString());
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
       ArrayOfQuizQuestion localQuestionArray = service.getBasicHttpBindingIQuizitionService().getQuestions(50, null);
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
    

    
}
