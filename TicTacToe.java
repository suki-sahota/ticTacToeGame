/*
 * Suki Sahota
 * Description: Tic Tac Toe Game
 */
import java.util.*; 
public class TicTacToe {
    // Constants
    public static final char PLAYER_X = 'X';
    public static final char PLAYER_O = 'O';
    
    // Instance variables
    private String xName = "";
    private String oName = "";
    private char[] board = new char[10];
    private int moveCount = 0;
    
    // Two-argument constructor
    public TicTacToe(String xName, String oName) {
        this.xName = xName;
        this.oName = oName;
    }

    // No-argument constructor
    public TicTacToe() {
        xName = "Player X";
        oName = "Player O";
    }

    // Getter
    public int getMoveCount() {
        return moveCount;
    }
    
    // Method to initialize board
    public void initializeBoard() {
        moveCount = 0;
        board[0] = '0';
        board[1] = '1';
        board[2] = '2';
        board[3] = '3';
        board[4] = '4';
        board[5] = '5';
        board[6] = '6';
        board[7] = '7';
        board[8] = '8';
        board[9] = '9';
    }
    
    // Method to take a turn
    public void takeATurn(Scanner keyboard, char player) {
        // Create generic string labelled name which can be used for both users
        String name = "";
        // Determine which user is playing this turn
        if (player == PLAYER_X) {
            name = xName;
        } else {
            name = oName;
        }
        System.out.println();

        // Display the updated board
        displayBoard();
        System.out.println();

        // Create response variable and initialize to -1 so user receives unique message first time through do-while loop
        int response = -1;
        // Outer loop to validate user response as a valid move
        do {
            // Message for user on first time through outer loop
            if (response == -1) {
                System.out.print("Where would you like to play, " + name + "? ");
            } 
            // Message for user if it is not their first time through outer validation loop
            else {
                System.out.print("The position you selected is not an open position on the board. " + name + ", please choose an open position on the board. ");
            }
            // Inner loop to validate user response as an integer
            while (true) {
                if (keyboard.hasNextInt()) {
                    // Capture user response in response variable
                    response = Math.abs(keyboard.nextInt());
                    // Flush the buffer from the Scanner
                    keyboard.nextLine();
                    break;
                } else {
                    System.out.println("I'm sorry, but the input you provided is not an integer. Please enter an open position on the board where you would like to play, " + name + ". ");
                    // Flush the buffer from the Scanner
                    keyboard.nextLine();
                }
            }
        } while (!validMove(response));
        // Allow player to make the move which was validated above
        board[response] = player;
        moveCount++;
    }
    
    // Method that returns true if there is a winner
    public boolean isWinner(char player) {
        if (board[1] == player && board[2] == player && board[3] == player) {
            return true;
        }
        if (board[4] == player && board[5] == player && board[6] == player) {
            return true;
        }
        if (board[7] == player && board[8] == player && board[9] == player) {
            return true;
        }
        if (board[1] == player && board[4] == player && board[7] == player) {
            return true;
        }
        if (board[2] == player && board[5] == player && board[8] == player) {
            return true;
        }
        if (board[3] == player && board[6] == player && board[9] == player) {
            return true;
        }
        if (board[1] == player && board[5] == player && board[9] == player) {
            return true;
        }
        if (board[3] == player && board[5] == player && board[7] == player) {
            return true;
        }
        // Return false if no winner yet
        return false;
    }
    
    // Method to display updated board for users
    public void displayBoard() {
        System.out.println();
        System.out.println(" " + board[1] + " | " + board[2] + " | " + board[3]);
        System.out.println(" --------- ");
        System.out.println(" " + board[4] + " | " + board[5] + " | " + board[6]);
        System.out.println(" --------- ");
        System.out.println(" " + board[7] + " | " + board[8] + " | " + board[9]);
    }
    
    // Method which validates user choice as an open position on the board
    private boolean validMove(int spot) {
        if (spot >= 1 && spot <= 9 && board[spot] != PLAYER_X && board[spot] != PLAYER_O) {
            // Return true if valid move
            return true;
        } else {
            // Return false if invalid move
            return false;
        }
    }
    
    // Method to display results at the end of game
    public void displayResults() {
        if (isWinner(PLAYER_X)) {
            displayBoard();
            System.out.println();
            System.out.println("CONGRATULATIONS " + xName + " YOU WON!");
        } else if (isWinner(PLAYER_O)) {
            displayBoard();
            System.out.println();
            System.out.println("CONGRATULATIONS " + oName + " YOU WON!");
        } else if (moveCount == 9) {
            displayBoard();
            System.out.println();
            System.out.println("The game is a tie. - The CAT won.");
        }
    }
}
