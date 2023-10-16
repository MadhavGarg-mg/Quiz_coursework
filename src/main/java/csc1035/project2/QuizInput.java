package csc1035.project2;

import org.hibernate.Session;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class QuizInput {

    /**
     * function that calls methods to create list of answers, questions and CorrectAnswers
     * @param quiz list of ids relating to questions
     */

    public static void getQsAndAnswers(List<Integer> quiz){
        List<String> questions = getQuestionList(quiz);
        List<String> answers = getAnswerList(quiz);
        List<Boolean> CorrectAnswers = playQuiz(questions, answers);
    }

    /**
     * function that generates a list of questions based on the ids held in Quiz
     * @param Quiz list of ids
     * @return a list of questions
     */

    public static List<String> getQuestionList(List<Integer> Quiz){
        List<String> questions = new ArrayList<>();
        for (int i=0;i<Quiz.size();i++){
            int id = Quiz.get(i);
            String question = getQuestion(id);
            questions.add(question);
        }
        return questions;
    }

    /**
     * function that generates a list of answers based on the ids held in Quiz
     * @param Quiz list of ids
     * @return a list of answers
     */

    public static List<String> getAnswerList(List<Integer> Quiz){
        List<String> answers = new ArrayList<>();
        for (int i=0;i<Quiz.size();i++){
            int id = Quiz.get(i);
            String answer = getAnswer(id);
            answers.add(answer);
        }
        return answers;
    }

    /**
     * function that gets a question based on an id
     * @param id id of a question
     * @return a question
     */


    public static String getQuestion(int id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        String hql = "SELECT Q.question FROM Questions Q WHERE Q.id = :id";
        Query query = session.createQuery(hql);
        query.setParameter("id",id);
        String question = ((org.hibernate.query.Query<?>) query).list().toString();
        session.getTransaction().commit();
        return question;
    }

    /**
     * function that gets an answer based on an id
     * @param id id of an answer
     * @return an answer
     */

    public static String getAnswer(int id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        String hql = "SELECT Q.answer FROM Questions Q WHERE Q.id = :id";
        Query query = session.createQuery(hql);
        query.setParameter("id",id);
        String answer = ((org.hibernate.query.Query<?>) query).list().toString();
        session.getTransaction().commit();
        return answer;
    }

    /**
     * function that allows the user to enter answers to questions which is then compared to see if they have
     * inputted the correct answer. It also keeps a record of what answers they got correct and incorrect
     * @param questions list of questions
     * @param answers list of answers
     * @return list of correct and incorrect answers
     */

    public static List<Boolean> playQuiz(List<String> questions, List<String> answers){
        List<Boolean> CorrectAnswers = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int count = 0;
        System.out.println("-----Lets Play!-----");
        for(int i=0;i<questions.size();i++){
            System.out.println("Question "+(i+1)+": "+questions.get(i));
            System.out.println("Answer:");
            String answer = sc.nextLine();
            String comparedAnswer = (answers.get(i)).toString().replace("[", "").replace("]", "");
            if(Objects.equals(answer,comparedAnswer)){
                System.out.println("Correct! Well done");
                count = count +1;
                CorrectAnswers.add(true);
            }
            else{
                System.out.println("Sorry this is the incorrect answer\n" +
                        "The correct answer was: "+ answers.get(i));
                CorrectAnswers.add(false);
            }
        }
        quizReport(count, questions, answers, CorrectAnswers);
        return CorrectAnswers;
    }

    /**
     * Creates a quiz report that includes the correctly answered questions, the incorrectly answered questions and
     * their final score
     * @param count number of correct answers
     * @param questions list of questions
     * @param answers list of answers
     * @param CorrectAnswers list of correct and incorrect answers
     */

    public static void quizReport(int count, List<String> questions, List<String> answers, List<Boolean> CorrectAnswers){
        System.out.println("Thanks for playing!\n" +
                "Generating quiz report...");
        System.out.println("------Quiz Report------\n" +
                "| Incorrect Questions |");
        for(int i=0;i<questions.size();i++){
            if(!CorrectAnswers.get(i)){
                System.out.println(questions.get(i)+"\n" +
                        "Correct answer: "+ answers.get(i));
            }
        }
        System.out.println("| Correct Questions |");
        for(int i=0;i<questions.size();i++){
            if(CorrectAnswers.get(i)){
                System.out.println(questions.get(i));
            }
        }
        System.out.println("Final score: "+count+"/"+questions.size());
    }

}
