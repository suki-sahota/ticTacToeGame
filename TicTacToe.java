/*
 * Suki Sahota
 * Description: Tic Tac Toe Game
 */
import java.util.*; 
public class TicTacToe {
    //constants
    public static final char PLAYER_X = 'X';
    public static final char PLAYER_O = 'O';
    
    //instance variables
    private String xName = "";
    private String oName = "";
    private char[] board = new char[10];
    private int moveCount = 0;
    
    //constructor
    public TicTacToe(String xName, String oName) {
        this.xName = xName;
        this.oName = oName;
    }

    //no-argument constructor
    public TicTacToe() {
        xName = "Player X";
        oName = "Player O";
    }

    //getter
    public int getMoveCount() {
        return moveCount;
    }
    
    //method to initialize board
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
    
    //method to take a turn
    public void takeATurn(Scanner keyboard, char player) {
        //create generic string labelled name which can be used for both users
        String name = "";
        //determine which user is playing this turn
        if (player == PLAYER_X) {
            name = xName;
        } else {
            name = oName;
        }
        System.out.println();

        //display the updated board
        displayBoard();
        System.out.println();

        //create response variable and initialize to -1 so user receives unique message first time through do-while loop
        int response = -1;
        //outer loop to validate user response as a valid move
        do {
            //message for user on first time through outer loop
            if (response == -1) {
                System.out.print("Where would you like to play, " + name + "? ");
            } 
            //message for user if it is not their first time through outer validation loop
            else {
                System.out.print("The position you selected is not an open position on the board. " + name + ", please choose an open position on the board. ");
            }
            //inner loop to validate user response as an integer
            while (true) {
                if (keyboard.hasNextInt()) {
                    //capture user response in response variable
                    response = Math.abs(keyboard.nextInt());
                    keyboard.nextLine();
                    break;
                } else {
                    System.out.println("I'm sorry, but the input you provided is not an integer. Please enter an open position on the board where you would like to play, " + name + ". ");
                    //flush the buffer from the Scanner
                    keyboard.nextLine();
                }
            }
        } while (!validMove(response));
        //allow player to make the move which was validated above
        board[response] = player;
        moveCount++;
    }
    
    //method that returns true if there is a winner
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
        //return false if no winner yet
        return false;
    }
    
    //method to display updated board for users
    public void displayBoard() {
        System.out.println();
        System.out.println(" " + board[1] + " | " + board[2] + " | " + board[3]);
        System.out.println(" --------- ");
        System.out.println(" " + board[4] + " | " + board[5] + " | " + board[6]);
        System.out.println(" --------- ");
        System.out.println(" " + board[7] + " | " + board[8] + " | " + board[9]);
    }
    
    //method which validates user choice as an open position on the board
    private boolean validMove(int spot) {
        if (spot >= 1 && spot <= 9 && board[spot] != PLAYER_X && board[spot] != PLAYER_O) {
            //return true if valid move
            return true;
        } else {
            //return false if invalid move
            return false;
        }
    }
    
    //method to display results at the end of game
    public void displayResults() {
        if (isWinner(PLAYER_X)) {
            displayBoard();
            System.out.println();
            System.out.println("CONGRATULATIONS " + xName + " YOU WON!");
        } else if(isWinner(PLAYER_O)) {
            displayBoard();
            System.out.println();
            System.out.println("CONGRATULATIONS " + oName + " YOU WON!");
        } else if(moveCount == 9) {
            displayBoard();
            System.out.println();
            System.out.println("The game is a tie. - The CAT won.");
        }
    }
}