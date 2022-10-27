package ticTacToe.Application;

import ticTacToe.Application.Board;
import ticTacToe.Application.Human;

import java.util.Scanner;

import static ticTacToe.Application.Mark.O;
import static ticTacToe.Application.Mark.X;

public class TicTacToe {
    private static final Scanner scanner = new Scanner(System.in);
    private static Board board = new Board();
    private static Human player1;
    private static Human player2;

    public static void main(String[] args) {
       registerPlayers();
       playGame();
    }
    public static void registerPlayers(){
        System.out.println("Welcome To Tic Tac Toe Game");

        System.out.println("Enter your name: ");
        String newPlayer1 = scanner.nextLine();
        player1 = new Human(newPlayer1, X);
        System.out.printf("%s ,Your Mark is X %n", newPlayer1);

        System.out.println("Enter your name: ");
        String newPlayer2 = scanner.nextLine();
        player2 = new Human(newPlayer2, O);
        System.out.printf("%s ,Your Mark is O %n", newPlayer2);
    }

    public static void playGame(){
        while (!board.playerDraw() || !board.playerWins()){
            player1Turns();
            player2Turns();
        }
    }

    private static void player1Turns() {
        System.out.println("Enter Your Mark Position: ");
        int position = scanner.nextInt();
        player1.marking(board, position);
        board.display();
        if(board.playerDraw() || board.playerWins()){
            System.out.println(player1 + "wins");
        }
    }

    private static void player2Turns() {
        int position;
        System.out.println("Enter Your Mark Position: ");
        position = scanner.nextInt();
        player2.marking(board, position);
        board.display();
        board.playerDraw();
        board.playerWins();
    }
}