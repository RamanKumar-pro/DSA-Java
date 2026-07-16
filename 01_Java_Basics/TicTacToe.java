import java.util.*;

public class TicTacToe {

    public static void main(String[] args) {
        char[][] board = {
            {' ', '|', ' ', '|', ' '},
            {'-', '+', '-', '+', '-'},
            {' ', '|', ' ', '|', ' '},
            {'-', '+', '-', '+', '-'},
            {' ', '|', ' ', '|', ' '}
        };

        Scanner scanner = new Scanner(System.in);
        char currentPlayer = 'X';
        boolean gameIsOver = false;

        System.out.println("Welcome to Tic-Tac-Toe!");
        System.out.println("Player X starts. Enter a number from 1-9 to make your move.");

        while (!gameIsOver) {
            printBoard(board);
            System.out.print("Player " + currentPlayer + ", enter your move (1-9): ");

            int move = -1;
            while (true) {
                try {
                    move = scanner.nextInt();
                    if (isValidMove(board, move)) {
                        break;
                    } else {
                        System.out.println("This move is not valid. The spot is taken or input is out of range. Try again.");
                    }
                } catch (Exception e) {
                    System.out.println("Invalid input. Please enter a number from 1-9.");
                    scanner.next(); // Clear the invalid input
                }
            }

            placeMove(board, move, currentPlayer);

            if (checkWinner(board, currentPlayer)) {
                printBoard(board);
                System.out.println("Congratulations! Player " + currentPlayer + " wins!");
                gameIsOver = true;
            } else if (isBoardFull(board)) {
                printBoard(board);
                System.out.println("It's a draw!");
                gameIsOver = true;
            } else {
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            }
        }
        scanner.close();
    }

    public static void printBoard(char[][] board) {
        System.out.println();
        System.out.println(" " + board[0][0] + " | " + board[0][2] + " | " + board[0][4] + " ");
        System.out.println("---+---+---");
        System.out.println(" " + board[2][0] + " | " + board[2][2] + " | " + board[2][4] + " ");
        System.out.println("---+---+---");
        System.out.println(" " + board[4][0] + " | " + board[4][2] + " | " + board[4][4] + " ");
        System.out.println();
    }

    public static void placeMove(char[][] board, int position, char player) {
        switch (position) {
            case 1: board[0][0] = player; break;
            case 2: board[0][2] = player; break;
            case 3: board[0][4] = player; break;
            case 4: board[2][0] = player; break;
            case 5: board[2][2] = player; break;
            case 6: board[2][4] = player; break;
            case 7: board[4][0] = player; break;
            case 8: board[4][2] = player; break;
            case 9: board[4][4] = player; break;
            default: break;
        }
    }

    public static boolean isValidMove(char[][] board, int position) {
        if (position < 1 || position > 9) {
            return false;
        }
        switch (position) {
            case 1: return board[0][0] == ' ';
            case 2: return board[0][2] == ' ';
            case 3: return board[0][4] == ' ';
            case 4: return board[2][0] == ' ';
            case 5: return board[2][2] == ' ';
            case 6: return board[2][4] == ' ';
            case 7: return board[4][0] == ' ';
            case 8: return board[4][2] == ' ';
            case 9: return board[4][4] == ' ';
            default: return false;
        }
    }

    public static boolean checkWinner(char[][] board, char player) {
        // Check rows
        for (int i = 0; i < 5; i += 2) {
            if (board[i][0] == player && board[i][2] == player && board[i][4] == player) {
                return true;
            }
        }
        // Check columns
        for (int j = 0; j < 5; j += 2) {
            if (board[0][j] == player && board[2][j] == player && board[4][j] == player) {
                return true;
            }
        }
        // Check diagonals
        if (board[0][0] == player && board[2][2] == player && board[4][4] == player) {
            return true;
        }
        if (board[0][4] == player && board[2][2] == player && board[4][0] == player) {
            return true;
        }
        return false;
    }

    public static boolean isBoardFull(char[][] board) {
        for (int i = 1; i <= 9; i++) {
            if (isValidMove(board, i)) {
                return false; // Found an empty spot
            }
        }
        return true;
    }
}
