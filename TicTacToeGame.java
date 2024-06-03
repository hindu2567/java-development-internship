import java.util.Scanner;

public class TicTacToeGame {
    private static char[][] board;
    private static final int SIZE = 3;
    private static final char EMPTY = '-';
    private static final char PLAYER_X = 'X';
    private static final char PLAYER_O = 'O';
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean playAgain;
        do {
            initializeBoard();
            playGame();
            playAgain = promptPlayAgain();
        } while (playAgain);
        System.out.println("Thanks for playing!");
    }

    private static void initializeBoard() {
        board = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = EMPTY;
            }
        }
    }

    private static void playGame() {
        char currentPlayer = PLAYER_X;
        boolean gameWon = false;
        while (!gameWon && !isBoardFull()) {
            displayBoard();
            playerMove(currentPlayer);
            gameWon = checkWin(currentPlayer);
            if (!gameWon) {
                currentPlayer = (currentPlayer == PLAYER_X) ? PLAYER_O : PLAYER_X;
            }
        }
        displayBoard();
        if (gameWon) {
            System.out.println("Player " + currentPlayer + " wins!");
        } else {
            System.out.println("It's a draw!");
        }
    }

    private static void displayBoard() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void playerMove(char player) {
        int row, col;
        while (true) {
            System.out.println("Player " + player + ", enter your move (row [1-3] and column [1-3]): ");
            row = scanner.nextInt() - 1;
            col = scanner.nextInt() - 1;
            if (row >= 0 && row < SIZE && col >= 0 && col < SIZE && board[row][col] == EMPTY) {
                board[row][col] = player;
                break;
            } else {
                System.out.println("This move is not valid");
            }
        }
    }

    private static boolean checkWin(char player) {
        for (int i = 0; i < SIZE; i++) {
            if ((board[i][0] == player && board[i][1] == player && board[i][2] == player) ||
                (board[0][i] == player && board[1][i] == player && board[2][i] == player)) {
                return true;
            }
        }
        if ((board[0][0] == player && board[1][0] == player && board[2][0] == player) ||
            (board[0][2] == player && board[1][2] == player && board[2][2] == player)) {
            return true;
        }
        if ((board[0][0] == player && board[1][1] == player && board[2][2] == player) ||
            (board[0][2] == player && board[1][1] == player && board[2][0] == player)) {
            return true;
        }
        return false;
    }

    private static boolean isBoardFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j] == EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean promptPlayAgain() {
        System.out.println("Do you want to play again? (yes/no): ");
        String response = scanner.next().trim().toLowerCase();
        return response.equals("yes");
    }
}