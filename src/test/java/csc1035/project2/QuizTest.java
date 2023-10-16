package csc1035.project2;
import csc1035.project2.QuizController;
import org.hibernate.Session;
import java.util.ArrayList;
import java.util.List;

public class QuizTest {
    public static void main(String[] args) throws Exception {
        List<Questions> questionsList = new ArrayList<>();
        questionsList.add(new Questions("What is 2+2? 1,4,7","Maths","MCQ","4",true));
        questionsList.add(new Questions("What is 2+3? 1,4,6","Maths","SAQ","5",false));
        questionsList.add(new Questions("What is 2+3? 1,4,6","Maths","SAQ","5",false));


        Quiz qz = new Quiz();
        QuizController qc = new QuizController();
        qc.createQuiz(qz);
    }
}
