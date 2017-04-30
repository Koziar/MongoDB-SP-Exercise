import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by Luke on 25/04/2017.
 */
public class Menu {

    private BufferedReader br;
    private int selectedOption;
    private boolean running;
    private Server server;

    private final String Q1 = "1. How many Twitter users are in our database?";
    private final String Q2 = "2. Which Twitter users link the most to other Twitter users?";
    private final String Q3 = "3. Who are the most mentioned Twitter users?";
    private final String Q4 = "4. Who are the most active Twitter users?";
    private final String Q5 = "5. Who are the five most grumpy (most negative tweets)?";
    private final String Q6 = "6. Who are the five most happy (most positive tweets)?";

    public Menu() {
        server = new Server();
        running = true;
    }

    public void startMenu() {
        while(running) {
            System.out.println("");
            System.out.println("Main Menu");
            System.out.println("---------------------------");
            System.out.println(Q1);
            System.out.println(Q2);
            System.out.println(Q3);
            System.out.println(Q4);
            System.out.println(Q5);
            System.out.println(Q6);
            System.out.println("7. ::Exit the program::");
            System.out.println("----------------------------");
            System.out.println("");
            System.out.print("Please select an option from 1-7");
            System.out.println("");
            System.out.println("");

            br = new BufferedReader(new InputStreamReader(System.in));
            try {
                selectedOption = Integer.parseInt(br.readLine());
                switch (selectedOption) {
                    case 1:
                        answerTheQuestion(1);
                        break;
                    case 2:
                        answerTheQuestion(2);
                        break;
                    case 3:
                        answerTheQuestion(3);
                        break;
                    case 4:
                        answerTheQuestion(4);
                        break;
                    case 5:
                        answerTheQuestion(5);
                        break;
                    case 6:
                        answerTheQuestion(6);
                        break;
                    case 7:
                        quitProgram();
                        break;
                    default:
                        System.out.println("There is no such an option, try again.");
                        break;
                }
            } catch (Exception e) {
                System.out.println("");
                System.out.println("You didn't enter a valid number, try again.");
            }
        }
    }

    private void answerTheQuestion(int questionNumber) {
        switch (questionNumber) {
            case 1:
                System.out.println("");
                System.out.println(Q1);
                System.out.println("---------------------------");
                System.out.println("Answer: ");
                server.distinctUsers();
                System.out.println("---------------------------");
                System.out.println("1. < Back to main menu");
                System.out.println("");
                break;
            case 2:
                System.out.println("");
                System.out.println(Q2);
                System.out.println("---------------------------");
                System.out.println("Answer: ");
                server.findUsersThatLink();
                System.out.println("---------------------------");
                System.out.println("1. < Back to main menu");
                System.out.println("");
                break;
            case 3:
                System.out.println("");
                System.out.println(Q3);
                System.out.println("---------------------------");
                System.out.println("Answer: ");
                server.findMostMentioned();
                System.out.println("---------------------------");
                System.out.println("1. < Back to main menu");
                System.out.println("");
                break;
            case 4:
                System.out.println("");
                System.out.println(Q4);
                System.out.println("---------------------------");
                System.out.println("Answer: ");
                server.findMostActive();
                System.out.println("---------------------------");
                System.out.println("1. < Back to main menu");
                System.out.println("");
                break;
            case 5:
                System.out.println("");
                System.out.println(Q5);
                System.out.println("---------------------------");
                System.out.println("Answer: ");
                server.findMostGrumpy();
                System.out.println("---------------------------");
                System.out.println("1. < Back to main menu");
                System.out.println("");
                break;
            case 6:
                System.out.println("");
                System.out.println(Q6);
                System.out.println("---------------------------");
                System.out.println("Answer: ");
                server.findMostHappy();
                System.out.println("---------------------------");
                System.out.println("1. < Back to main menu");
                System.out.println("");
                break;
        }

        br = new BufferedReader(new InputStreamReader(System.in));
        try {
            selectedOption = Integer.parseInt(br.readLine());
            switch (selectedOption) {
                case 1:
                    this.startMenu();
                    break;
                default:
                    System.out.println("There is no such an option, try again.");
                    answerTheQuestion(questionNumber);
                    break;
            }
        } catch (Exception e) {
            System.out.println("You didn't enter a valid number, try again.");
            answerTheQuestion(questionNumber);
        }
    }

    private void quitProgram() {
        System.out.println("You have quit the program");
        running = false;
    }
}
