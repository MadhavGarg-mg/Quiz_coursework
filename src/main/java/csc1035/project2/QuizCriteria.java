package csc1035.project2;

/**
 * This class has the functions of the quizzes' CRUD
 */
public interface QuizCriteria<Quiz> {

    /**
     * This function is used to add a quiz to the database
     * @param q represents the quiz
     */
    void createQuiz(Quiz q);

    /**
     * This function is used to give a quiz from the database using its name
     * @param q represents the Quiz class
     * @param quizName represents the quiz name
     * @return question using the quizName
     */
    Quiz getByName(Class<Quiz> q, String quizName);

    /**
     * This function updates a quiz in the database
     * @param q represents the quiz
     */
    void updateQuiz(Quiz q);

    /**
     * This function is used to give a quiz from the database using its name
     * @param q represents the Quiz class
     * @param quizName represents the quiz name
     */
    void deleteQuiz(Class<Quiz> q, String quizName);
}