import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Schramm
 */
public class TicTacToeTest {
    
    public TicTacToeTest() {
    }

    @Test
    public void test4ArgConstructor() {
        TicTacToe instance = new TicTacToe(4,4, 3, 'O');
        assertEquals('O', instance.getTurn());
        assertEquals(TicTacToeEnum.IN_PROGRESS, instance.getGameState());
        String s = "  |   |   |   | \n"+
                "  |   |   |   | \n"+
                "  |   |   |   | \n"+
                "  |   |   |   | \n";
        assertEquals(s, instance.toString() );
    }
    @Test
    public void testDefaultConstructor() {
        TicTacToe instance = new TicTacToe( 'O');
        assertEquals(TicTacToeEnum.IN_PROGRESS, instance.getGameState());
        assertEquals( 'O', instance.getTurn());
        String s = "  |   |   | \n"+
                "  |   |   | \n"+
                "  |   |   | \n";
        assertEquals(s, instance.toString() );
    }
    
    public void testReset() {
       TicTacToe instance = new TicTacToe( 'O');
       instance.takeTurn(0, 0);
       instance.takeTurn(0, 1);
       instance.reset( 'X');
       assertEquals(TicTacToeEnum.IN_PROGRESS, instance.getGameState());
       assertEquals( 'X', instance.getTurn());
       String s = "  |   |   | \n"+
                "  |   |   | \n"+
                "  |   |   | \n";
       assertEquals(s, instance.toString() );
    }

    @Test
    public void testTakeTurn() {
       TicTacToe instance = new TicTacToe('O');
       instance.takeTurn(0, 0);
       assertEquals(TicTacToeEnum.IN_PROGRESS, instance.getGameState());
       assertEquals( 'X', instance.getTurn());
       String s = "O |   |   | \n"+
                "  |   |   | \n"+
                "  |   |   | \n";
       assertEquals(s, instance.toString() );
    }


}
