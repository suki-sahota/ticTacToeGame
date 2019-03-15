/*
 * Suki Sahota
 * Description: Tic Tac Toe Game Driver
 */
import java.util.*;
public class TicTacToeDriver {
    public static void main(String[] args) {
        // Establish keyboard Scanner
        Scanner keyboard = new Scanner(System.in);
        Random random_variable = new Random();
        System.out.println();

        // Prompt both users for their name and save as variables xName and oName
        System.out.print("Welcome to a game of Tic-Tac-Toe! Please enter your name now if you would like to be player X. ");
        String xName = keyboard.nextLine();
        System.out.print("And who will be player O? Please enter your name. ");
        String oName = keyboard.nextLine();
        // Declare char variable which determines whos turn it is
        char player;
        // Pseudorandomly determine which user goes first
        if (random_variable.nextBoolean()) {
            player = TicTacToe.PLAYER_X;
        } else {
            player = TicTacToe.PLAYER_O;
        }
        System.out.println();

        // Message to notify users who will go first
        System.out.println("Thank you for that. It looks like the computer has selected player '" + player + "' to go second.");
        // Create TicTacToe object called game with both players
        TicTacToe game = new TicTacToe(xName, oName);
        String playAgain = "Y";
        do {
            // Start message
            System.out.println("Let's Begin!");

            // Initialize board for new game of Tic-Tac-Toe
            game.initializeBoard();

            // While loop to control flow of game
            while (!game.isWinner(player) && game.getMoveCount() < 9) {
                // Switch player so users take turns playing on the board
                if (player == TicTacToe.PLAYER_X) {
                    player = TicTacToe.PLAYER_O;
                } else {
                    player = TicTacToe.PLAYER_X;
                }
                // User takes a turn
                game.takeATurn(keyboard, player);
            }

            // Display end of game results
            game.displayResults();
            System.out.println();

            // Prompt users and ask if they would like to play again
            System.out.print("Do you want to play again (Y/N)? ");
            playAgain = keyboard.next();
        } while (playAgain.equalsIgnoreCase("Y"));
        System.out.println();

        // Exit message
        System.out.println("Thank you for playing Tic-Tac-Toe.");
        System.out.println();
        System.out.println("\tHAVE A NICE DAY!");
        System.out.println();
    }
}
