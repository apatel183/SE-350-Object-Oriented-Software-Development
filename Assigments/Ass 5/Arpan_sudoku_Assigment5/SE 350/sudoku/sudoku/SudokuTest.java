package sudoku;

import static org.junit.Assert.*;
//mport junit.framework.TestCase;
import sudoku.Sudoku.ParseException;
import java.io.*;


import org.junit.Test;
import sudoku.Sudoku.ParseException;
import java.io.IOException;


import java.io.IOException;
public class SudokuTest {
    // make sure assertions are turned on!  
    // we don't want to run test cases without assertions too.
    // see the handout to find out how to turn them on.
    @Test(expected=AssertionError.class)
    public void testAssertionsEnabled() {
        assert false;
    }

    @Test 
    public void Sudoku(){
    	int[][] s = new int[9][9];
    	s [7][1] = 2;
    	s [0][0] = 0;
    	Sudoku s1 = new Sudoku(3); 
    	Sudoku s2 = new Sudoku(3,s);
    }
    @Test
    public void testTwoDimSudoku() {
    	Sudoku s = new Sudoku(2, new int[][] {
    			new int[] { 0, 0, 0, 1 },
    			new int[] { 2, 3, 0, 4 },
    			new int[] { 0, 0, 0, 3 },
    			new int[] { 4, 1, 0, 2 },
    	});
    	String testTwoDim = "...1\n" +
    					  "23.4\n" +
    					  "...3\n" +
    					  "41.2\n";
    	assertEquals(testTwoDim.toString());
    }
   
	@Test
    public void testThreeDimEmptySudoku() {
    	Sudoku s = new Sudoku(3);
    	String testEmpty = ".........\n" +
    					  ".........\n" +
    					  ".........\n" +
    					  ".........\n";
    	assertEquals(testEmpty.toString());
    }
    @Test
    public void testThreeDimNonEmptySudoku() {
    	Sudoku s = new Sudoku(3);
    	String testNonEmpty = "..1......\n" +
    					  "..0.......\n" +
    					  ".9........\n" +
    					  "....5....\n";
    	assertEquals(testNonEmpty.toString());
    }
    @Test
    public void testThreeDimSudoku() {
    	Sudoku s = new Sudoku(3, new int [][]{
    			new int[] { 8, 3, 2, 9, 7, 1, 4, 5, 6},
    			new int[] { 0, 8, 0, 0, 0, 7, 5, 4, 1 },
    			new int[] { 1, 7, 0, 0, 6, 8, 0, 5, 3 },
    			new int[] { 0, 5, 0, 6, 1, 2, 4, 9, 7 },
    			new int[] { 0, 0, 0, 4, 7, 9, 8, 0, 0 },
    			new int[] { 0, 1, 0, 0, 4, 3, 8, 5, 9},
    			new int[] { 0, 0, 0, 7, 2, 0, 1, 8, 6 },
    			new int[] { 9, 1, 0, 0, 4, 0, 6, 0, 5},
    			new int[] { 7, 1, 8, 5, 2, 6, 0, 4, 9 },
    	});
    	String testThreeDim = "832971456\n" +
    					  ".8...7541\n" +
    					  "17..68.53\n" +
    					  ".5.612497\n" +
    					  "...4798..\n" +
    					  ".1..43859\n" +
    					  "...72.186\n" +
    					  "91..4.6.5\n" +
    					  "718526.49\n";
    	assertEquals(testThreeDim.toString());
    }
    /*
    @Test
    public void testreadFile() throws IOException, ParseException{
    	Sudoku testSudoku = Sudoku.fromFile(3, "samples/sudoku_easy.txt");
    	System.out.println(testSudoku);	
    }
    */
    private void assertEquals(String string) {
		// TODO Auto-generated method stub
	}

}
  
    
