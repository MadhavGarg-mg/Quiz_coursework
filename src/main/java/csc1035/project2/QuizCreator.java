package csc1035.project2;

import org.hibernate.Session;

import javax.persistence.Query;
import java.util.*;

public class QuizCreator {

    /**
     * Function that prompts the user to enter criteria to base their quiz on
     * @return the created Quiz
     */
    public static List createQuiz(){
        Scanner sc = new Scanner(System.in);
        Menu m = new Menu();
        System.out.println("------Create Quiz-------");
        System.out.println("""
                Menu: Create Quiz based on
                1)Topic
                2)Type
                3)Topic and Type""");
        int choice = m.success(sc);
        List results = createList(choice);
        int length = Validation.checkLength();
        List Quiz = createLength(results, length);
        return Quiz;
    }

    /**
     * function that creates a list of all ids that relate to the entered type, topic or type and topic
     * @param choice the number the user entered that corresponds to their quiz being based on type, topic or both
     * @return a list of ids
     */

    public static List createList(int choice) {
        Controller<Questions> c = new Controller<>();
        if (Objects.equals(choice, 1)) {
            String topic = Validation.checkTopic();
            List results = getIDbyTopic(topic);
            return results;
        }
        else if(Objects.equals(choice,2)){
            String type = Validation.checkType();
            List results = getIDbyType(type);
            return results;
        }
        else if(Objects.equals(choice,3)){
            String type = Validation.checkType();
            String topic = Validation.checkTopic();
            List results = getIDbyTopicAndType(type, topic);
            return results;
        }
        return null;
    }

    /**
     * function that selects the ids from the table question where the topic entered is the same as the topic in the
     * topic column
     * @param topic the topic entered by the user
     * @return a list of ids
     */

    public static List getIDbyTopic(String topic){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        String hql = "SELECT Q.id FROM Questions Q WHERE Q.topic = :topic";
        Query query = session.createQuery(hql);
        query.setParameter("topic",topic);
        List results = ((org.hibernate.query.Query<?>) query).list();
        session.getTransaction().commit();
        return results;
    }

    /**
     * function that selects the ids from the table question where the type entered is the same as the type in the
     * type column
     * @param type the type entered by the user
     * @return a list of ids
     */

    public static List getIDbyType(String type){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        String hql = "SELECT Q.id FROM Questions Q WHERE Q.type = :type";
        Query query = session.createQuery(hql);
        query.setParameter("type",type);
        List results = ((org.hibernate.query.Query<?>) query).list();
        session.getTransaction().commit();
        return results;
    }

    /**
     * function that selects the ids from the table question where the type and topic entered is the same as the
     * type and topic in their corresponding columns
     * @param type the type entered by the user
     * @param topic the topic entered by the user
     * @return a list of ids
     */

    public static List getIDbyTopicAndType(String type, String topic){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        String hql = "SELECT Q.id FROM Questions Q WHERE Q.type = :type and topic =: topic";
        Query query = session.createQuery(hql);
        query.setParameter("type",type);
        query.setParameter("topic", topic);
        List results = ((org.hibernate.query.Query<?>) query).list();
        session.getTransaction().commit();
        return results;
    }

    /**
     * function that creates a list of ids at random depending on the given length
     * @param results list of ids
     * @param length length of either 5,10,15,20 which is inputted by the user
     * @return a list of ids at the length given
     */

    public static List<Integer> createLength(List<Integer> results, int length){
        Random rand = new Random();
        List<Integer> Quiz = new ArrayList<>();
        for (int i=0;i<length;i++){
            int randIndex = rand.nextInt(results.size());
            Quiz.add(results.get(randIndex));
            results.remove(randIndex);
        }
        return Quiz;
    }
}
