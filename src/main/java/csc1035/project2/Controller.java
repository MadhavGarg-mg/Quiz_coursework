package csc1035.project2;

import org.hibernate.Session;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * This is a controller implementing functions from the Criteria interface
 * @param <Questions> represents the question class
 */
public class Controller <Questions> implements Criteria<Questions>{

    /**
     * This function is used to add a question to the database
     * @param q represents the question
     */
    @Override
    public void createQuestion(Questions q) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(q);
        session.getTransaction().commit();
    }

    /**
     * This function is used to give a question from the database using its id
     * @param q represents the Questions class
     * @param id represents the question id
     * @return question using the question id
     */
    @Override
    public Questions getById(Class<Questions> q, int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Questions a = session.get(q, id);
        session.getTransaction().commit();
        return a;
    }

    /**
     * This function updates a question in the database
     * @param q represents the question
     */
    @Override
    public void updateQuestion(Questions q) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.saveOrUpdate(q);
        session.getTransaction().commit();
    }

    /**
     * This function deletes a question from the database using its id
     * @param q represents the Questions class
     * @param id represents the question id
     */
    @Override
    public void deleteQuestion(Class<Questions> q, int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Questions entry = session.get(q, id);
        session.delete(entry);
        session.getTransaction().commit();
    }

    /**
     * This function gives all the questions from the database
     * @param c represents the Questions class
     * @return List of questions
     */
    @Override
    public List<Questions> getAll(Class<Questions> c) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<Questions> entries = null;
        entries = session.createQuery("from "+c.getSimpleName()).list();
        session.getTransaction().commit();
        return entries;
    }

    /**
     * This function gives all the questions for a specific topic from the database
     * @param c represents the Questions class
     * @param topic represents the question topic
     * @return List of questions for a specific topic
     */
    @Override
    public List<Questions> getAllByTopic(Class<Questions> c, String topic) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<Questions> entries = null;
        entries = session.createQuery("from Questions where topic =:topic ")
                .setParameter("topic", topic).list();
        session.getTransaction().commit();
        return entries;}

    /**
     * This function gives all the questions for a specific type from the database
     * @param c represents the Questions class
     * @param type represents the question type
     * @return List of questions for a specific topic
     */
    @Override
    public List<Questions> getAllByType(Class<Questions> c, String type) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<Questions> entries = null;
        entries = session.createQuery("from Questions where type =:type ")
                .setParameter("type", type).list();
        session.getTransaction().commit();
        return entries;}

    /**
     * This function gives all the questions for a specific type and topic from the database
     * @param c represents the Questions class
     * @param type represents the question type
     * @param topic represents the question topic
     * @return List of questions for a specific topic and type
     */
    @Override
    public List<Questions> getAllByTypeAndTopic(Class<Questions> c, String type, String topic) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<Questions> entries = null;
        entries = session.createQuery("from Questions where type =:type and topic =: topic")
                .setParameter("type",  type).setParameter("topic", topic).list();
        session.getTransaction().commit();
        return entries;}

    /**
     * This function changes the incorrectQuestion to false if the user answers the correct answer
     * @param c represents the question
     * @param answer represents the question's answer
     */
    @Override
    public void checkAnswer(Questions c, String answer) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.createQuery("update Questions set incorrectQuestion= false where answer =:answer")
                .setParameter("answer",  answer.toLowerCase()).executeUpdate();
        session.getTransaction().commit();}

    /**
     * This function is used to write a list of questions to a file
     * @param q represents the list of questions
     * @param filename represents the name of file
     */
    @Override
    public void writeFile(List<Questions> q, String filename){
        try(FileOutputStream fr = new FileOutputStream(filename)){
            ObjectOutputStream os = new ObjectOutputStream(fr);
            os.writeObject(q);
            os.close();
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * This function is used to read a list of questions from a file
     * @param filename represents the name of the file
     * @return List of questions in the file
     */
    @Override
    public ArrayList<Questions> readFile(String filename){
        try(FileInputStream fi = new FileInputStream(filename);
            ObjectInputStream oi = new ObjectInputStream(fi)){

            return (ArrayList<Questions>)oi.readObject();
        }
        catch (FileNotFoundException e){
            System.out.println("File not found");
        }
        catch (IOException e){
            System.out.println("IO exception");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
