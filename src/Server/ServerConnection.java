package Server;
 
import Questions.Question;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import com.microsoft.sqlserver.jdbc.*;
import java.util.logging.Level;
import java.util.logging.Logger;
 
public class ServerConnection {
    Connection connection = null;
    Statement statement = null;
    ResultSet result = null;
    ResultSetMetaData metadata = null;
     
    static final String DATABASE_URL = "jdbc:mysql://gamequizition.com.mysql/gamequizition_c";
     
    public ServerConnection()
    {
            try {
                try {
                    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                    String connectionUrl = "jdbc:sqlserver://uoa8wmjmki.database.windows.net:1433;database=gamequizition;user=Chips@uoa8wmjmki;password=Jeghaterpassordregler!x9;encrypt=true;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
                    connection = DriverManager.getConnection(connectionUrl);
                    statement = connection.createStatement();
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(ServerConnection.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                //establish connection to database
                //connection = DriverManager.getConnection(DATABASE_URL, "gamequizition_c", "6MNuDJq3");
                //connection = DriverManager.getConnection("jdbc:sqlserver://uoa8wmjmki.database.windows.net:1433;database=gamequizition;user=Chips@uoa8wmjmki;password=Jeghaterpassordregler!x9;encrypt=true;hostNameInCertificate=*.database.windows.net;loginTimeout=30");
                 
                //create statement for querying database
                //statement = connection.createStatement();
             
            }catch (SQLException e) 
            {
                System.out.println("Connection failure " + e);
                e.printStackTrace();
            }
    }
 
    public void addQuestionForReview(String question, String answerA, String answerB, String answerC, String answerD, String correct, String category, String subcategory) 
    {
        int acorrect = 0, bcorrect = 0, ccorrect = 0, dcorrect = 0;
        if (correct == "A")
            acorrect = 1;
        if (correct == "B")
            bcorrect = 1;
        if (correct == "C")
            ccorrect = 1;
        else
            dcorrect = 1;
             
        try {
            statement.execute(
                    "INSERT INTO `gamequizition`.`nyespørsmål` " + 
                    "(`spørsmål`, `svara`, `acorrect`, `svarb`, `bcorrect`, `svarc`, " + 
                    "`ccorrect`, `svard`, `dcorrect`, `kategori`, `delkategori`) " + 
                    "VALUES (" +
                    " '" + question + "'," +
                    " '" + answerA + "'," +
                    " '" + acorrect + "'," +
                    " '" + answerB + "'," +
                    " '" + bcorrect + "'," +
                    " '" + answerC + "'," +
                    " '" + ccorrect + "'," +
                    " '" + answerD + "'," +
                    " '" + dcorrect + "'," +
                    " '" + category + "'," +
                    " '" + subcategory + "')");
        } catch (SQLException e) {
            System.out.println("Query failed");
            e.printStackTrace();
        }
         
    }
    public Question getNextQuestion(String table)
    {
         
        try {
            result = statement.executeQuery("SELECT * FROM `gamequizition`.`"+table+"` LIMIT 1");
            result.next();
            Question question = new Question(result.getInt(1), result.getString(2), result.getString(3), result.getString(4), result.getString(5), 
                        result.getString(6), result.getInt(7), result.getInt(8), result.getInt(9), result.getInt(10), 
                        result.getString(11), result.getString(12));
             
            return question;
        } catch (SQLException e) {
             
            e.printStackTrace();
            return null;
        }
         
         
    }
    public void transferApprovedQuestion(String question, String answerA, String answerB, String answerC, String answerD, String correct, String category, String subcategory)
    {
        int acorrect = 0, bcorrect = 0, ccorrect = 0, dcorrect = 0;
        if (correct == "A")
            acorrect = 1;
        if (correct == "B")
            bcorrect = 1;
        if (correct == "C")
            ccorrect = 1;
        else
            dcorrect = 1;
             
        try {
            statement.execute(
                    "INSERT INTO `gamequizition`.`spørsmål` " + 
                    "(`spørsmål`, `svara`, `acorrect`, `svarb`, `bcorrect`, `svarc`, " + 
                    "`ccorrect`, `svard`, `dcorrect`, `kategori`, `delkategori`) " + 
                    "VALUES (" +
                    " '" + question + "'," +
                    " '" + answerA + "'," +
                    " '" + acorrect + "'," +
                    " '" + answerB + "'," +
                    " '" + bcorrect + "'," +
                    " '" + answerC + "'," +
                    " '" + ccorrect + "'," +
                    " '" + answerD + "'," +
                    " '" + dcorrect + "'," +
                    " '" + category + "'," +
                    " '" + subcategory + "')");
        } catch (SQLException e) {
            System.out.println("Query failed");
            e.printStackTrace();
        }
         
    }
    public void rejectAndDeleteQuestion()
    {
        try {
            statement.execute("DELETE FROM `gamequizition`.`nyespørsmål` LIMIT 1");
            System.out.println("Removing question failed");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
     
    public void complainOnLastQuestion(int lastQuestion)
    {
        try {
            result = statement.executeQuery("SELECT antallKlager FROM `gamequizition`.`spørsmål` WHERE idspørsmål ='" +  lastQuestion + "'");
            result.next();
            int tempAntall = result.getInt(1);
            tempAntall ++;
            statement.execute("UPDATE `gamequizition`.`spørsmål` SET `antallKlager`='" + tempAntall + "' WHERE `idspørsmål`='" +  lastQuestion + "'");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
         
    }
     
    public void correctAnswer(int question)
    {
        try {
            result = statement.executeQuery("SELECT antallRiktig FROM `gamequizition`.`spørsmål` WHERE idspørsmål ='" +  question + "'");
            result.next();
            int tempAntall;
            tempAntall = result.getInt(1);
            tempAntall ++;
 
            statement.execute("UPDATE `gamequizition`.`spørsmål` SET `antallRiktig`='" + tempAntall + "' WHERE `idspørsmål`='" +  question + "'");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public void registerATry(int question)
    {
        try {
            result = statement.executeQuery("SELECT antallForsøk FROM `gamequizition`.`spørsmål` WHERE idspørsmål ='" +  question + "'");
            result.next();
            int tempAntall;
            tempAntall = result.getInt(1);
            tempAntall ++;
 
            statement.execute("UPDATE `gamequizition_c`.`spørsmål` SET `antallForsøk`='" + tempAntall + "' WHERE `idspørsmål`='" +  question + "'");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public Question getNextRandomQuestion(String table) {
        try {
                result = statement.executeQuery("SELECT TOP 1 * FROM "+table+" ORDER BY NEWID()");//ORDER BY RAND() LIMIT 1
                result.next();
                Question question = new Question(result.getInt(1), result.getString(2), result.getString(3), result.getString(4), result.getString(5), 
                        result.getString(6), result.getInt(7), result.getInt(8), result.getInt(9), result.getInt(10), 
                        result.getString(11), result.getString(12));

                return question;
                } catch (SQLException e) {

                e.printStackTrace();
                return null;
                }    
    }
}
