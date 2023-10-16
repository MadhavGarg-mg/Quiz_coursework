package csc1035.project2;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


/**
 * This class represents the pool of question for the quiz.
 *
 * @author Group43
 */
@Entity(name = "Questions")
public class Questions implements Serializable {

    @ManyToMany(mappedBy = "questions")
    private List<Quiz> quizzes;

    @Id
    @GeneratedValue (strategy = GenerationType.SEQUENCE)
    @Column(updatable = false, nullable = false)
    private int id;

    @Column
    private String question;

    @Column
    private String topic;

    @Column
    private String type;

    @Column
    private String answer;

    @Column
    private boolean incorrectQuestion;

    /**
     * This constructor sets up all the internal fields of a Question object.
     * @param question represents the question
     * @param topic represents the topic of the question
     * @param type represents the type of the question
     * @param answer represents the answer of the question
     * @param incorrectQuestion represents whether the answer was answered correctly or incorrectly
     * @throws Exception if the topic is not programming, databases, architecture, or maths
     * @throws Exception if the type is not MCQ, or SAQ
     */
    public Questions(String question, String topic, String type, String answer, boolean incorrectQuestion) throws Exception{
        this.id = id;
        this.question = question;
        topic = topic.toLowerCase();
        if(topic.equals("programming") || topic.equals("databases") || topic.equals("architecture") || topic.equals("maths")){
            this.topic = topic;}
        else throw new Exception("The topic must be programming, databases, architecture, or maths.");
        type = type.toLowerCase();
        if(type.equals("mcq") || type.equals("saq")){
            this.type = type;}
        else throw new Exception("The type must be MCQ, or SAQ.");
        this.answer = answer;
        this.incorrectQuestion = incorrectQuestion;
    }

    /**
     * This is the default constructor
     */
    public Questions() {
    }

    /**
     * Returns a human-readable version of a Question object
     * @return String representation of the question
     */
    public String toString() {
        return "Questions{" +
                "id='" + id + '\'' +
                ", question='" + question + '\'' +
                ", topic='" + topic + '\'' +
                ", type='" + type + '\'' +
                ", answer='" + answer + '\'' +
                ", incorrectQuestion=" + incorrectQuestion +
                '}';
    }

    /**
     * Sets the question id to the desired question id
     * @param id represents the question id
     */
    public void setID(int id){
        this.id = id;
    }

    /**
     * Sets the question to the desired question
     * @param question is the question
     */
    public void setQuestion(String question) {
        this.question = question;
    }

    /**
     * Sets the question topic to the desired question topic
     * @param topic represents the topic of the question
     * @throws Exception if the topic is not programming, databases, architecture, or maths
     */
    public void setTopic(String topic) throws Exception {
        topic = topic.toLowerCase();
        if(topic.equals("programming") || topic.equals("databases") || topic.equals("architecture") || topic.equals("maths")){
            this.topic = topic;}
        else throw new Exception("The topic must be programming, databases, architecture, or maths.");
    }

    /**
     * Sets the question type to the desired question type
     * @param type represents the type of the question
     * @throws Exception if the type is not MCQ, or SAQ
     */
    public void setType(String type) throws Exception {
        type = type.toLowerCase();
        if(type.equals("mcq") || type.equals("saq")){
            this.type = type;}
        else throw new Exception("The topic must be programming, databases, architecture, or maths.");
    }

    /**
     * Sets the answer for the question
     * @param answer represents the answer to the question
     */

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    /**
     * Sets the incorrectQuestion to either true or false
     * @param incorrectQuestions represents whether the answer was answered correctly or incorrectly
     */
    public void setIncorrectQuestion(boolean incorrectQuestions) {
        this.incorrectQuestion = incorrectQuestions;
    }

    /**
     * Sets the quizzes as quizzes
     * @param quizzes represents the quizzes the question is in
     */
    public void setQuizzes(List<Quiz> quizzes){
        this.quizzes = quizzes;
    }

    /**
     * Returns the question id
     * @return id
     */
    public int getId(){
        return id;
    }

    /**
     * Returns the question
     * @return question
     */
    public String getQuestion() {
        return question;
    }

    /**
     * Returns the topic of the question
     * @return topic
     */
    public String getTopic() {
        return topic;
    }

    /**
     * Returns the type of the question
     * @return type
     */
    public String getType() {
        return type;
    }

    /**
     * Returns the answer of the question
     * @return answer
     */
    public String getAnswer() {
        return answer;
    }

    /**
     * Returns whether the answer was answered correctly or incorrectly
     * @return incorrectQuestion
     */
    public boolean getIncorrectQuestions() {
        return incorrectQuestion;
    }

    /**
     * Returns the quizzes the question is in
     * @return Quizzes
     */
    public List<Quiz> getQuizzes(){
        return quizzes;
    }
}