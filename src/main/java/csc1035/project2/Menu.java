package csc1035.project2;
import java.util.*;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        Controller<Questions> c = new Controller<>();
        QuizCreator qc = new QuizCreator();
        boolean quit = false;

        while (!quit) {//sets the condition to loop until false
            System.out.println("""
                    ------Quizzes------
                    Menu:
                    1)Create Question
                    2)Update Question
                    3)Delete Question
                    4)Create Quiz
                    5)Print list of Questions from a file
                    6)Export list of Questions to a file
                    7)Exit
                    """);//prints out menu
            int choice = success(sc);//stores user input in the variable choice
            switch(choice){
                case 1 -> {Validation.createQuestion();}
                case 2 -> {Validation.updateQuestion();}
                case 3 -> {Validation.deleteQuestion();}

                case 4 -> {
                    List<Integer> Quiz = qc.createQuiz();
                QuizInput.getQsAndAnswers(Quiz);} //Create Quiz

                case 5 -> {System.out.println("Enter file name you want to import:");
                sc.nextLine();
                String filename = sc.nextLine();
                System.out.println(c.readFile(filename));}

                case 6 -> {
                System.out.println("Enter file name that you want to export your list to:");
                sc.nextLine();
                String filename = sc.nextLine();
                System.out.println("""
                        Export list:
                        1)By Topic
                        2)By Type
                        3)By Topic and Type""");
                int list = success(sc);
                List<Questions> entries = createList(list);
                System.out.println("List created!");
                c.writeFile(entries, filename);}

                case 7 -> {
                    System.out.println("Quitting");
                    quit = true;
                }


            default -> {System.out.println("Exiting");}

        }
    }
    }
    static int success(Scanner sc) {
        boolean success = false;
        int num = 0;
        while (!success) {
            try {
                num = sc.nextInt();
                if (num > 0){
                    success = true;}
                else System.out.println("Invalid input. Try again");
            } catch (InputMismatchException e) {
                System.out.println("You entered the wrong input. Please enter a number");
                sc.next();
            }
        }
        return num;
    }

    public static List<Questions> createList(int list){
        Scanner sc = new Scanner(System.in);
        Controller<Questions> c = new Controller<>();
        if(Objects.equals(list,1)) {
            String topic = Validation.checkTopic();
            return c.getAllByTopic(Questions.class, topic);
        }
        if(Objects.equals(list,2)){
            String type = Validation.checkType();
            return c.getAllByType(Questions.class, type);
        }
        if(Objects.equals(list,3)){
            String topic = Validation.checkTopic();
            String type = Validation.checkType();
            return c.getAllByTypeAndTopic(Questions.class, type, topic);
        }

        return null;
    }
}


