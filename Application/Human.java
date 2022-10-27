package ticTacToe.Application;

import static ticTacToe.Application.Mark.E;
 public class Human {
private final String name;
private final Mark mark;


public Human(String name, Mark mark){
    this.name = name;
    this.mark = mark;
}
public void marking(Board play, int markPosition){
    if (markPosition < 1 || markPosition > 9) throw new TicTacToeExeption("Sorry you are out of position");
    int position = markPosition - 1;
   int row = position / 3;
   int column = position % 3;
   var boardSurface = play.getBoardSurface();
   if (boardSurface[row][column] == E) boardSurface[row][column] = mark;
   else throw new TicTacToeExeption("You cannot play on already marked position");
}
    public Mark getPlayerMarks() {
        return mark;
    }
    public String getName(){
        return name;
    }

}
