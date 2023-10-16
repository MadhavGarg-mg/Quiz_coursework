package csc1035.project2;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * This Class establishes the quiz table and links it to the questions class' table
 */
@Entity(name = "Quiz")
public class Quiz {
    @Id
    @Column(updatable = false, nullable = false)
    private String quizName;

    @ManyToMany
    @JoinTable(
            name = "QuizQuestions",
            joinColumns = {@JoinColumn(name = "QuizName")},
            inverseJoinColumns = {@JoinColumn(name = "questions")})
    private List<Questions> questions;

    /**
     * This constructor sets up all the internal fields of a Question object.
     * @param quizName represents the name for a quiz
     */
    public Quiz(String quizName, List<Questions> questions) {
        this.quizName = quizName;
        this.questions = questions;
    }

    public Quiz() {
    }

    /**
     * Returns the quiz name
     * @return quiz name
     */
    public String getQuizName() {
        return quizName;
    }

    /**
     * Returns a human-readable version of a quiz object
     * @return String representation of the quiz
     */
    public String toString() {
        return "Questions{" +
                "Quiz Name='" + quizName + '\'' +
                ", Questions =" + questions +
                '}';
    }
}
