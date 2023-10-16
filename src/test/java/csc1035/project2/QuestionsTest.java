package csc1035.project2;

import csc1035.project2.Questions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 */
class QuestionsTest {

    Questions q1 = new Questions("What is 2+2? 1,4,7","Maths","MCQ","4",true);

    QuestionsTest() throws Exception {
    }

    /**
     * Test of ToString method, of class Questions.
     */
    @Test
    void testToString() {
        assertEquals("Questions{id='0', question='What is 2+2? 1,4,7', topic='maths', type='mcq', answer='4', incorrectQuestion=true}", q1.toString());
    }

    /**
     * Test of getId method, of class Questions.
     */
    @Test
    void getId() {
        assertEquals(0, q1.getId());
    }

    /**
     * Test of getQuestion method, of class Questions.
     */
    @Test
    void getQuestion() {
        assertEquals("What is 2+2? 1,4,7", q1.getQuestion());
    }

    /**
     * Test of getTopic method, of class Questions.
     */
    @Test
    void getTopic() {
        assertEquals("maths", q1.getTopic());
    }

    /**
     * Test of getType method, of class Questions.
     */
    @Test
    void getType() {
        assertEquals("mcq", q1.getType());
    }

    /**
     * Test of getAnswer method, of class Questions.
     */
    @Test
    void getAnswer() {
        assertEquals("4", q1.getAnswer());
    }

    /**
     * Test of getIncorrectQuestions method, of class Questions.
     */
    @Test
    void getIncorrectQuestions() {
        assertTrue(q1.getIncorrectQuestions());
    }

    /**
     * Test of setID method, of class Questions.
     */
    @Test
    void setID() {
        int expectedId = 2;
        q1.setID(2);
        assertEquals(expectedId, q1.getId());
    }

    /**
     * Test of setQuestion method, of class Questions.
     */
    @Test
    void setQuestion() {
        String expectedQuestion = "What is 1+1? 1,2,7";
        q1.setQuestion("What is 1+1? 1,2,7");
        assertEquals(expectedQuestion, q1.getQuestion());
    }

    /**
     * Test of setTopic method, of class Questions.
     * @throws Exception if the topic is not programming, databases, architecture, or maths
     */
    @Test
    void setTopic() throws Exception {
        String expectedTopic = "databases";
        q1.setTopic("databases");
        assertEquals(expectedTopic, q1.getTopic());
    }

    /**
     * Test of setType method, of class Questions.
     * @throws Exception if the type is not MCQ, or SAQ
     */
    @Test
    void setType() throws Exception {
        String expectedType = "saq";
        q1.setType("SAQ");
        assertEquals(expectedType, q1.getType());
    }

    /**
     * Test of setAnswer method, of class Questions.
     */
    @Test
    void setAnswer() {
        String expectedAnswer = "2";
        q1.setAnswer("2");
        assertEquals(expectedAnswer, q1.getAnswer());
    }

    /**
     * Test of setIncorrectQuestion method, of class Questions.
     */
    @Test
    void setIncorrectQuestion() {
        Boolean expectedIncorrectQuestion = false;
        q1.setIncorrectQuestion(false);
        assertEquals(expectedIncorrectQuestion, q1.getIncorrectQuestions());
    }
}