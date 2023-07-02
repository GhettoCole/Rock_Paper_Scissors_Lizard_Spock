import java.util.Random;
import java.util.Scanner;

public class Main {

    public static String generateComputerChoice(Random random) {
        int randomNumber = random.nextInt(3) + 1;
        String computerChoice = "";

        switch (randomNumber) {
            case 1:
                computerChoice = "rock";
                break;
            case 2:
                computerChoice = "paper";
                break;
            case 3:
                computerChoice = "scissors";
                break;
        }

        System.out.println("\nThe Computer already made its choice");
        return computerChoice;
    }

    public static void showMenu() {
        System.out.println("Options to choose from:\n1. Rock\n2. Paper\n3. Scissors\n4. Lizard\n5. Spock");
    }

    public static String getUserChoice(Scanner scanner) {
        System.out.print("\nPlease make your choice: ");
        return scanner.nextLine();
    }

    public static String chooseWinner(String computerChoice, String userChoice) {
        String winner = "No Winner";
        String customMessage = "Both choose the same";
        String finalMessage;

        if (computerChoice.equals(userChoice)) {
            finalMessage = "It's a tie!";
        } else if (computerChoice.equals("rock")) {
            if (userChoice.equals("scissors") || userChoice.equals("lizard")) {
                winner = "Computer";
            } else {
                winner = "User";
            }
        } else if (computerChoice.equals("paper")) {
            if (userChoice.equals("rock") || userChoice.equals("spock")) {
                winner = "Computer";
            } else {
                winner = "User";
            }
        } else if (computerChoice.equals("scissors")) {
            if (userChoice.equals("paper") || userChoice.equals("lizard")) {
                winner = "Computer";
            } else {
                winner = "User";
            }
        } else if (computerChoice.equals("lizard")) {
            if (userChoice.equals("paper") || userChoice.equals("spock")) {
                winner = "Computer";
            } else {
                winner = "User";
            }
        } else if (computerChoice.equals("spock")) {
            if (userChoice.equals("rock") || userChoice.equals("scissors")) {
                winner = "Computer";
            } else {
                winner = "User";
            }
        }

        if (!winner.equals("No Winner")) {
            customMessage = getCustomMessage(computerChoice, userChoice);
        }

        finalMessage = winner + " won (" + customMessage + ")";
        return finalMessage;
    }

    public static String getCustomMessage(String computerChoice, String userChoice) {
        switch (computerChoice) {
            case "rock":
                switch (userChoice) {
                    case "lizard":
                        return "Rock crushes Lizard";
                    default:
                        return "Rock crushes Scissors";
                }
            case "paper":
                switch (userChoice) {
                    case "spock":
                        return "Paper disproves Spock";
                    default:
                        return "Paper covers Rock";
                }
            case "scissors":
                switch (userChoice) {
                    case "lizard":
                        return "Scissors decapitate Lizard";
                    default:
                        return "Scissors cut Paper";
                }
            case "lizard":
                switch (userChoice) {
                    case "spock":
                        return "Lizard poisons Spock";
                    default:
                        return "Lizard eats Paper";
                }
            case "spock":
                switch (userChoice) {
                    case "rock":
                        return "Spock vaporizes Rock";
                    default:
                        return "Spock smashes Scissors";
                }
        }
        return "";
    }

    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        String computerChoice;
        String userChoice;
        String winner;

        showMenu();
        computerChoice = generateComputerChoice(random);
        userChoice = getUserChoice(scanner);
        winner = chooseWinner(computerChoice, userChoice);

        System.out.println("\nYou choose: " + userChoice + "\nComputer choose: " + computerChoice);
        System.out.println(winner);
    }
}
