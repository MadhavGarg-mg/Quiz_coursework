package csc1035.project2;

import java.util.ArrayList;
import java.util.List;

/**
 * This is an interface with multiple functions implemented in the Controller
 * @param <Questions> represents the question class
 */
public interface Criteria<Questions> {

        /**
         * This function is used to add a question to the database
         * @param q represents the question
         */
        void createQuestion(Questions q);

        /**
         * This function is used to give a question from the database using its id
         * @param q represents the Questions class
         * @param id represents the question id
         * @return question using the question id
         */
        Questions getById(Class<Questions> q, int id);

        /**
         * This function updates a question in the database
         * @param q represents the question
         */
        void updateQuestion(Questions q);

        /**
         * This function deletes a question from the database using its id
         * @param q represents the Questions class
         * @param id represents the question id
         */
        void deleteQuestion(Class<Questions> q, int id);

        /**
         * This function gives all the questions from the database
         * @param c represents the Questions class
         * @return List of questions
         */
        List<Questions> getAll(Class<Questions> c);

        /**
         * This function gives all the questions for a specific topic from the database
         * @param c represents the Questions class
         * @param topic represents the question topic
         * @return List of questions for a specific topic
         */
        List<Questions> getAllByTopic(Class<Questions> c, String topic);

        /**
         * This function gives all the questions for a specific type from the database
         * @param c represents the Questions class
         * @param type represents the question type
         * @return List of questions for a specific topic
         */
        List<Questions> getAllByType(Class<Questions> c, String type);

        /**
         * This function gives all the questions for a specific type and topic from the database
         * @param c represents the Questions class
         * @param type represents the question type
         * @param topic represents the question topic
         * @return List of questions for a specific topic and type
         */
        List<Questions> getAllByTypeAndTopic(Class<Questions> c, String type, String topic);

        /**
         * This function changes the incorrectQuestion to false if the user answers the correct answer
         * @param c represents the question
         * @param answer represents the question's answer
         */
        void checkAnswer(Questions c, String answer);

        /**
         * This function is used to write a list of questions to a file
         * @param q represents the list of questions
         * @param filename represents the name of file
         */
        void writeFile(List<Questions> q, String filename);

        /**
         * This function is used to read a list of questions from a file
         * @param filename represents the name of the file
         * @return List of questions in the file
         */
        ArrayList<Questions> readFile(String filename);
}