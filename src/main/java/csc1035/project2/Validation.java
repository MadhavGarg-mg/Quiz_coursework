package csc1035.project2;


import java.util.Scanner;

public class Validation {

    /**
     * function that gets question information from the user
     * @return the question
     * @throws Exception
     */
    public static Questions questionInformation() throws Exception {
        Scanner sc = new Scanner(System.in);
        Controller c = new Controller();
        Questions q = new Questions();
        System.out.println("Enter id");
        int id = sc.nextInt();
        q.setID(id);
        question(sc, q);
        return q;
    }

    /**
     * function that adds a question to the database
     * @throws Exception
     */

    public static void createQuestion() throws Exception {
        Scanner sc = new Scanner(System.in);
        Controller<Questions> c = new Controller<Questions>();
        Questions q = new Questions();
        question(sc, q);
        c.createQuestion(q);
    }

    /**
     * function that updates a question within the database
     * @throws Exception
     */

    public static void updateQuestion() throws Exception {
        Controller<Questions> c = new Controller<Questions>();
        c.updateQuestion(questionInformation());

    }

    /**
     * function that deletes a question from the database
     * @throws Exception
     */

    public static void deleteQuestion() throws Exception {
        Controller<Questions> c = new Controller<Questions>();
        c.deleteQuestion(Questions.class, questionInformation().getId());
    }

    /**
     * function that takes user input for each aspect of a question which is then set for each field
     * @param sc scanner to take user input
     * @param q object instance of the class Questions
     * @throws Exception
     */

    private static void question(Scanner sc, Questions q) throws Exception {
        System.out.println("Enter Question:");
        sc.nextLine();
        String question = sc.nextLine();
        q.setQuestion(question);
        String topic = checkTopic();
        q.setTopic(topic);
        String type = checkType();
        q.setType(type);
        System.out.println("Enter Answer:");
        String answer = sc.nextLine();
        q.setAnswer(answer);
        q.setIncorrectQuestion(false);
    }

    /**
     * function that prompts the user to enter a topic until they enter one of the four topics
     * @return the topic the user entered, which is one of the four listed
     */

    public static String checkTopic(){
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.print("Enter Topic:");
            String topic = sc.nextLine();
            if(topic.equalsIgnoreCase("Maths") || topic.equalsIgnoreCase("Programming")
                    || topic.equalsIgnoreCase("Databases") || topic.equalsIgnoreCase("Architecture")){
                return topic;
            }
            else{
                System.out.println("Input invalid, please re-enter...");
            }
        }
    }

    /**
     * function that prompts user to enter a type until they enter one of the two types
     * @return the type the user entered, which is one of the two listed
     */

    public static String checkType(){
        Scanner sc = new Scanner(System.in);//creates scanner to read in user's input
        while(true){//creates a loop that continues while true
            System.out.print("Enter Type:");//prompts user to enter a lot number
            String type = sc.nextLine();
            if(type.equalsIgnoreCase("SAQ") || type.equalsIgnoreCase("MCQ")){
                return type;
            }
            else{
                System.out.println("Input invalid, please re-enter...");
            }
        }
    }

    /**
     * function that prompts the user to enter a length until they enter the correct length which is either 5,10,15,20
     * @return the user inputted length
     */

    public static int checkLength(){
        Scanner sc = new Scanner(System.in);
        Menu m = new Menu();
        while(true){
            System.out.println("""
                Choose Length:
                --> 5
                --> 10
                --> 15
                --> 20""");
            int length = m.success(sc);
            if(length == 5 || length == 10 || length == 15 || length == 20){
                return length;
            }
            else{
                System.out.println("This isn't a valid length, please re-enter");
            }
        }

    }

}

