package csc1035.project2;

import org.hibernate.Session;

/**
 * This class has the methods that implement the functions of CRUD
 */
public class QuizController<Quiz> implements QuizCriteria<Quiz> {

    @Override
    public void createQuiz(Quiz q) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(q);
        session.getTransaction().commit();
    }

    @Override
    public Quiz getByName(Class<Quiz> q, String quizName) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Quiz a = session.get(q, quizName);
        session.getTransaction().commit();
        return a;
    }

    @Override
    public void updateQuiz(Quiz q) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.saveOrUpdate(q);
        session.getTransaction().commit();
    }

    @Override
    public void deleteQuiz(Class<Quiz> q, String quizName) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Quiz entry = session.get(q, quizName);
        session.delete(entry);
        session.getTransaction().commit();
    }
}
