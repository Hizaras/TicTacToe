package ticTacToe.Application.Test.ticTacToeTest;

 import org.junit.Test;
 import org.junit.jupiter.api.BeforeEach;
 import ticTacToe.Application.Board;
 import ticTacToe.Application.Human;
 import ticTacToe.Application.TicTacToeExeption;

 import static org.junit.Assert.*;
 import static ticTacToe.Application.Mark.O;
import static ticTacToe.Application.Mark.X;


public class TicTacToeTest {

    Human player1 = new Human("lakes", X);
    Human player2 = new Human("Kelechi", O);
    Board board = new Board();

    @BeforeEach
    @Test
    public void testThatOurPlayerMarks(){
         Assert.assertEquals(X, player1.getPlayerMarks());
         Assert.assertEquals(O, player2.getPlayerMarks());
    }
    @Test
    public void testThatIfPlayerPlaysTheBoardGetsToBeMarked(){
        player1.marking(board,1);
        var board1 = board.getBoardSurface();
        Assert.assertEquals(X, board1[0][0]);
        player2.marking(board,5);
        Assert.assertEquals(O, board1[1][1]);
    }
    @Test
    public void testThatIfPlayerPlaysOnAnAlreadyMarkedPositionItThrowsException(){
        player1.marking(board, 1);
        var board1 = board.getBoardSurface();
        Assert.assertEquals(X, board1[0][0]);
        Assert.assertThrows(TicTacToeExeption.class, ()-> player2.marking(board,1));
    }

    @Test
    public void testThatIfPlayerPlaysOutsideTheRangeOfPositionsItThrowsException(){
         Assert.assertThrows(TicTacToeExeption.class,()->player1.marking(board, 10));
    }

    @Test
    public void testThatWeCanTellWhenAPlayer1OnRowOneWinsTheGame(){
        player1.marking(board,1);
        player1.marking(board,2);
        player1.marking(board,3);
        Assert.assertTrue(board.playerWins());
    }

    @Test
    public void testThatWeCanTellWhenAPlayer2RowOneWinsTheGame(){
        player2.marking(board,1);
        player2.marking(board,2);
        player2.marking(board,3);
        Assert.assertTrue(board.playerWins());
    }

    @Test
    public void testThatWeCanTellWhenAPlayer1RowTwoWinsTheGame(){
        player1.marking(board,4);
        player1.marking(board,5);
        player1.marking(board,6);
        Assert.assertTrue(board.playerWins());
    }

    @Test
    public void testThatWeCanTellWhenAPlayer2RowTwoWinsTheGame(){
        player2.marking(board,4);
        player2.marking(board,5);
        player2.marking(board,6);
        Assert.assertTrue(board.playerWins());
    }

    @Test
    public void testThatWeCanTellWhenAPlayer1RowThreeWinsTheGame(){
        player1.marking(board,7);
        player1.marking(board,8);
        player1.marking(board,9);
        Assert.assertTrue(board.playerWins());
    }

    @Test
    public void testThatWeCanTellWhenAPlayer2RowThreeWinsTheGame(){
        player2.marking(board,7);
        player2.marking(board,8);
        player2.marking(board,9);
        Assert.assertTrue(board.playerWins());
    }
    @Test
    public void testThatWeCanTellWhenAPlayer1RowFourWinsTheGame(){
        player1.marking(board,1);
        player1.marking(board,5);
        player1.marking(board,9);
        Assert.assertTrue(board.playerWins());
    }

    @Test
    public void testThatWeCanTellWhenAPlayer2RowFourWinsTheGame(){
        player2.marking(board,1);
        player2.marking(board,5);
        player2.marking(board,9);
        Assert.assertTrue(board.playerWins());
    }

    @Test
    public void testThatWeCanTellWhenAPlayer1RowFiveWinsTheGame(){
        player1.marking(board,3);
        player1.marking(board,5);
        player1.marking(board,7);
        Assert.assertTrue(board.playerWins());
    }

    @Test
    public void testThatWeCanTellWhenAPlayer2RowFiveWinsTheGame(){
        player2.marking(board,3);
        player2.marking(board,5);
        player2.marking(board,7);
        Assert.assertTrue(board.playerWins());
    }

    @Test
    public void testThatWeCanTellWhenAPlayer1RowSixWinsTheGame(){
        var board1 = board.getBoardSurface();
         player1.marking(board,1);
         player1.marking(board,4);
         player1.marking(board,7);
         Assert.assertTrue(board.playerWins());
    }

    @Test
    public void testThatWeCanTellWhenAPlayer2RowSixWinsTheGame(){
        player2.marking(board,1);
        player2.marking(board,4);
        player2.marking(board,7);
        Assert.assertTrue(board.playerWins());
    }

    @Test
    public void testThatWeCanTellWhenAPlayer1RowSevenWinsTheGame(){
        var board1 = board.getBoardSurface();
        player1.marking(board,2);
        player1.marking(board,5);
        player1.marking(board,8);
        Assert.assertTrue(board.playerWins());
    }

    @Test
    public void testThatWeCanTellWhenAPlayer2RowSevenWinsTheGame(){
        player2.marking(board,2);
        player2.marking(board,5);
        player2.marking(board,8);
        Assert.assertTrue(board.playerWins());
    }

    @Test
    public void testThatWeCanTellWhenAPlayer1RowEightWinsTheGame(){
        var board1 = board.getBoardSurface();
        player1.marking(board,3);
        player1.marking(board,6);
        player1.marking(board,9);
        Assert.assertTrue(board.playerWins());
    }

    @Test
    public void testThatWeCanTellWhenAPlayer2RowEightWinsTheGame(){
        player2.marking(board,3);
        player2.marking(board,6);
        player2.marking(board,9);
        Assert.assertFalse(board.playerDraw());
        Assert.assertTrue(board.playerWins());
    }

    @Test
    public void testThatThereWillBeDraw(){
        player1.marking(board, 3);
        player2.marking(board,1);
        player1.marking(board, 4);
        player2.marking(board,2);
        player1.marking(board, 5);
        player2.marking(board,6);
        player1.marking(board, 8);
        player2.marking(board,7);
        player1.marking(board,9);
        Assert.assertTrue(board.playerDraw());
     }
}
