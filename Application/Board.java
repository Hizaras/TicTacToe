package ticTacToe.Application;

import static ticTacToe.Application.Mark.*;
public class Board {
    private final Mark[][] board = {{E, E, E},{E, E, E},{E, E, E}};

    public Mark [][] getBoardSurface() {
        return board;
    }

    public boolean playerWins() {
        if (CheckIfPlayerWinsOnRowOne()) return true;
        if (playerWinsOnRowTwo()) return true;
        if (playerWinsOnRowThree()) return true;
        if (playerWinsOnRowFour()) return true;
        if (playerWinsOnRowFive()) return true;
        if (playerWinsOnRowSix()) return true;
        if (playerWinsOnRowSeven()) return true;
        return playerWinsOnRowEight();
    }

    private boolean playerWinsOnRowEight() {
        if(board[0][2] == X && board[1][2] == X && board[2][2] == X) return true;
        return board[0][2] == O && board[1][2] == O && board[2][2] == O;
    }

    private boolean playerWinsOnRowSeven() {
        if(board[0][1] == X && board[1][1] == X && board[2][1] == X) return true;
        if(board[0][1] == O && board[1][1] == O && board[2][1] == O) return true;
        return false;
    }

    private boolean playerWinsOnRowSix() {
        if(board[0][0] == X && board[1][0] == X && board[2][0] == X) return true;
        if(board[0][0] == O && board[1][0] == O && board[2][0] == O) return true;
        return false;
    }

    private boolean playerWinsOnRowFive() {
        if(board[0][2] == X && board[1][1] == X && board[2][0] == X) return true;
        if(board[0][2] == O && board[1][1] == O && board[2][0] == O) return true;
        return false;
    }

    private boolean playerWinsOnRowFour() {
        if(board[0][0] == X && board[1][1] == X && board[2][2] == X) return true;
        if(board[0][0] == O && board[1][1] == O && board[2][2] == O) return true;
        return false;
    }

    private boolean playerWinsOnRowThree() {
        if(board[2][0] == X && board[2][1] == X && board[2][2] == X) return true;
        if(board[2][0] == O && board[2][1] == O && board[2][2] == O) return true;
        return false;
    }

    private boolean playerWinsOnRowTwo() {
        if(board[1][0] == X && board[1][1] == X && board[1][2] == X) return true;
        if(board[1][0] == O && board[1][1] == O && board[1][2] == O) return true;
        return false;
    }

    private boolean CheckIfPlayerWinsOnRowOne() {
        if(board[0][0] == X && board[0][1] == X && board[0][2] == X) return true;
        if (board[0][0] == O && board[0][1] == O && board[0][2] == O) return true;
        return false;
    }

    public boolean playerDraw() {
        if(!checkBoard() && !playerWins()) return true;
        return false;
    }
    private boolean checkBoard(){
        for(int rows = 0; rows < board.length; rows++) {
            for(int cols = 0; cols < board[rows].length; cols++){
               if(board[rows][cols] == E) return true;
            }
        }
        return false;
    }
    public void display(){
        for (int rows = 0; rows < board.length; rows++) {
            System.out.print(" | ");
            for (int columns = 0; columns <board[rows].length; columns++) {
                System.out.print(board[rows][columns]);
                System.out.print(" | ");
            }
            System.out.println();
        }

    }
}
