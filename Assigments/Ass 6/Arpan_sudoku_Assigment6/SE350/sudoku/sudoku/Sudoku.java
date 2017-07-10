/**
 * Author: dnj, Hank Huang
 * Date: March 7, 2009
 * 6.005 Elements of Software Construction
 * (c) 2007-2009, MIT 6.005 Staff
 */
package sudoku;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import sat.env.Bool;
import sat.env.Environment;
import sat.env.Variable;
import sat.formula.Clause;
import sat.formula.Formula;
import sat.formula.Literal;
import sat.formula.NegLiteral;
import sat.formula.PosLiteral;

/**
 * Sudoku is an immutable abstract datatype representing instances of Sudoku.
 * Each object is a partially completed Sudoku puzzle.
 */
public class Sudoku {
    // dimension: standard puzzle has dim 3
    private final int dim;
    // number of rows and columns: standard puzzle has size 9
    private final int size;
    // known values: square[i][j] represents the square in the ith row and jth
    // column,
    // contains -1 if the digit is not present, else i>=0 to represent the digit
    // i+1
    // (digits are indexed from 0 and not 1 so that we can take the number k
    // from square[i][j] and
    // use it to index into occupies[i][j][k])
    private final int[][] square;
    // occupies [i,j,k] means that kth symbol occupies entry in row i, column j
    private final Variable[][][] occupies;

    // Rep invariant
    // TODO: write your rep invariant here
    private void checkRep() {
        // TODO: implement this.
        //throw new RuntimeException("not yet implemented.");
    	assert this.square != null : "Sudoku, Rep invariant: non-null";
    	assert this.occupies != null : "Sudoku, Rep invariant: non-null";
    	for (int i = 0; i<size; ++i){
    		for (int j = 0; j<size; ++j){
    			assert this.square[i][j] >= -1 : "Sudoku, Rep invariant: square value greater than or equal to -1";
    			assert this.square[i][j] < size : "Sudoku, Rep invariant: square value less than size";
    		}
    	}
    }

    /**
     * create an empty Sudoku puzzle of dimension dim.
     * 
     * @param dim
     *            size of one block of the puzzle. For example, new Sudoku(3)
     *            makes a standard Sudoku puzzle with a 9x9 grid.
     */
    public Sudoku(int dim) {
        // TODO: implement this.
        //throw new RuntimeException("not yet implemented.");
    	this.dim = dim;
    	this.size = dim * dim;
    	this.square = new int[size][size];
    	for (int i =0; i<size; i++){
    		for (int j = 0; j<size; j++){
    			this.square[i][j] = -1;
    		}
    	}
    	this.occupies = new Variable[size][size][size];
    	for (int i = 0; i<size; i++){
    		for (int j = 0; j<size; j++){
    			for (int k = 0; k<size; k++){
    				this.occupies[i][j][k] = new Variable(i + "," + j + "," + k);
    			}
    		}
    	}
    	checkRep();
    }

    /**
     * create Sudoku puzzle
     * 
     * @param square
     *            digits or blanks of the Sudoku grid. square[i][j] represents
     *            the square in the ith row and jth column, contains 0 for a
     *            blank, else i to represent the digit i. So { { 0, 0, 0, 1 }, {
     *            2, 3, 0, 4 }, { 0, 0, 0, 3 }, { 4, 1, 0, 2 } } represents the
     *            dimension-2 Sudoku grid: 
     *            
     *            ...1 
     *            23.4 
     *            ...3
     *            41.2
     * 
     * @param dim
     *            dimension of puzzle Requires that dim*dim == square.length ==
     *            square[i].length for 0<=i<dim.
     */
    public Sudoku(int dim, int[][] square) {
        // TODO: implement this.
        //throw new RuntimeException("not yet implemented.");
    	this.dim = dim;
    	this.size = dim * dim;
    	this.square = new int[size][size];
    	
    	for (int i = 0; i<size; i++){
    		for (int j = 0; j<size; j++){
    			this.square[i][j] = square[i][j] - 1;
    		}
    	}
    	this.occupies = new Variable[size][size][size];
    	for (int i = 0; i<size; i++){
    		for (int j = 0; j<size; j++){
    			for (int k = 0; k<size; k++){
    				this.occupies[i][j][k] = new Variable(i + "," + j + "," + k); 
    			}
    		}
    	}
    	checkRep();
    }

    /**
     * Reads in a file containing a Sudoku puzzle.
     * 
     * @param dim
     *            Dimension of puzzle. Requires: at most dim of 3, because
     *            otherwise need different file format
     * @param filename
     *            of file containing puzzle. The file should contain one line
     *            per row, with each square in the row represented by a digit,
     *            if known, and a period otherwise. With dimension dim, the file
     *            should contain dim*dim rows, and each row should contain
     *            dim*dim characters.
     * @return Sudoku object corresponding to file contents
     * @throws IOException
     *             if file reading encounters an error
     * @throws ParseException
     *             if file has error in its format
     */
    public static Sudoku fromFile(int dim, String filename) throws IOException,
            ParseException {
    	
        // TODO: implement this.
        //throw new RuntimeException("not yet implemented.");
    	int size = dim * dim;
    	int[][] newSquare = new int[size][size];
    	FileReader fr;
    	try{
    		fr = new FileReader(filename);
    	}
    	catch (FileNotFoundException e){
    		e.printStackTrace();
    		throw new RuntimeException("File not found");
    	}
    	BufferedReader r = new BufferedReader(fr);
    	String l_text = "";
    	int total_rowc = 0; 
    	try{
    		while ((l_text = r.readLine()) != null){
    			if (total_rowc >= size){
    				throw new ParseException("Too many rows");
    			}
    			int[] nRow = new int[size];
    			char[] arrayCopy = l_text.toCharArray();
    			int l_text_Length = l_text.length();
    			if (l_text_Length != (dim * dim)){
    				throw new ParseException("Too many columns");
    			}
    			for (int i=0; i<size; i++){
    				if (arrayCopy[i] == '.')
    					nRow[i] = 0;
    				else
    					nRow[i] = arrayCopy[i] - 48;
    			}
    			newSquare[total_rowc] = nRow;
    			total_rowc++;
    		}
    		return new Sudoku(dim, newSquare);
    	}
    	finally {
    		fr.close();
    		r.close();
    	}
    	
    }

    /**
     * Exception used for signaling grammatical errors in Sudoku puzzle files
     */
    @SuppressWarnings("serial")
    public static class ParseException extends Exception {
        public ParseException(String msg) {
            super(msg);
        }
    }
    /**
     * Produce readable string representation of this Sukoku grid, e.g. for a 4
     * x 4 sudoku problem: 
     *   12.4 
     *   3412 
     *   2.43 
     *   4321
     * 
     * @return a string corresponding to this grid
     */
    public String toString() {
        // TODO: implement this.
        //throw new RuntimeException("not yet implemented.");
    	StringBuilder str = new StringBuilder();
    	for (int i = 0; i < size; i++ ){
    		String temp = "";
    		for (int j = 0; j < size; j++){
    			if (j==0)
    				temp += (square[i][j] + 1);
    			else
    				temp += (" " + (square[i][j] + 1));
    		}
    		temp += "\n";
    		str.append(temp);
    	}
    	checkRep();
    	return str.toString();
    }
    /**
     * @return a SAT problem corresponding to the puzzle, using variables with
     *         names of the form occupies(i,j,k) to indicate that the kth symbol
     *         occupies the entry in row i, column j
     */
    public Formula getProblem() {

    	Formula f = new Formula();
        // TODO: implement this.
    	// how the board looks at the start
    	//Formula f1 = new Formula();
    	for (int i = 0; i < size; i++){
    		for (int j = 0; j < size; j++){
    			int check = square[i][j];
    			if(check >=0){
    				Variable occu = occupies[i][j][check];
    				Literal lit = PosLiteral.make(occu);
    				Clause c = new Clause(lit);
    				f= f.addClause(c);
    			}
    		}
    	}
    	//one number in each box
    	for(int i=0; i <size; i++){
    		for (int j = 0; j<size; j++){
    			for(int k = 0; k <size; k++){
    				for(int ab = k+1; ab <size; ab++){
    					Variable o1 = occupies[i][j][k];
    					Variable o2 = occupies[i][j][ab];
    					Literal negtionalLiteral1 = NegLiteral.make(o1);
    					Literal negtionalLiteral2 = NegLiteral.make(o2);
    					Clause c = new Clause(negtionalLiteral1);
    					c = c.add(negtionalLiteral2);
    					f = f.addClause(c);
    				}	
    			}
    		}
    	}
    	// check every row
    	for (int i =0; i <size; i++){
    		for(int k =0; k <size; k++){
    			Clause c = new Clause();
    			for (int j = 0; j<size; j++){
    				Variable occu = occupies[i][j][k];
    				Literal lit = PosLiteral.make(occu);
    				c = c.add(lit);	
    			}
    			f = f.addClause(c);
    		}
    	}
    	///row has at most one
    	for (int i =0; i < size; i++){
    		for ( int k = 0; k < size; k++){
    			for (int j = 0; j <size; j++){
    				for (int ab = j+1; ab<size; ab++){
    					Variable o1 = occupies[i][j][k];
        				Variable o2 = occupies[i][ab][k];
        				Literal negtionalLiteral1 = NegLiteral.make(o1);
    					Literal negtionalLiteral2 = NegLiteral.make(o2);
    					Clause c = new Clause(negtionalLiteral1);
    					c = c.add(negtionalLiteral2);
    					f = f.addClause(c);
    				}
    			}
    		}
    	}
    	//check every column
    	for (int j = 0; j <size; j++){
    		for(int k = 0; k<size; k++){
    			Clause c = new Clause();
    			for (int i =0; i <size; i++){
    				Variable occu = occupies[i][j][k];
    				Literal lit = PosLiteral.make(occu);
    				c = c.add(lit);
    			}
    			f = f.addClause(c);
    		}
    	}
    	for (int j = 0; j <size; j++){
    		for (int k = 0; k < size; k++){
    			for (int i = 0; i < size; i++){
    				for ( int ab = i + 1; ab <size; ab++){
    					Variable o1 = occupies[i][j][k];
        				Variable o2 = occupies[ab][j][k];
        				Literal negtionalLiteral1 = NegLiteral.make(o1);
    					Literal negtionalLiteral2 = NegLiteral.make(o2);
    					Clause c = new Clause(negtionalLiteral1);
    					c = c.add(negtionalLiteral2);
    					f = f.addClause(c);		
    				}
    			}
    		}
    	}
    	//check block now
    	for (int block1 = 0; block1 < dim; block1++){
    		for(int block2 = 0; block2 < dim; block2++){
    			for(int k =0; k <size; k++){
    				Clause c = new Clause();
    				for(int i = 0; i < dim; i++){
    					for(int j=0; j <dim; j++){
    						Variable blockO =(occupies[(block1 * dim)+ i][(block2*dim)+ j][k]);
    						Literal lit = PosLiteral.make(blockO);
    						c = c.add(lit);
    					}
    				}
    				f = f.addClause(c);
    			}
    		}
    		
    	}
    	for(int k = 0; k < size; k++){
    		for(int block1= 0; block1 < dim; block1++){
    			for(int block2 = 0; block2 < dim; block2++){
    				for(int i=0; i <dim; i++){
    					for(int j=0; j <dim; j++){
    						for (int ab = i; ab<dim; ab++){
    							for (int bc = j+1; bc<dim; bc++){
    								Variable o1 =(occupies[(block1 * dim)+ i][(block2*dim)+ j][k]);
    								Variable o2 =(occupies[(block1 * dim)+ ab][(block2*dim)+ bc][k]);
    								Literal negtionalLiteral1 = NegLiteral.make(o1);
    		    					Literal negtionalLiteral2 = NegLiteral.make(o2);
    		    					Clause c = new Clause(negtionalLiteral1);
    		    					c = c.add(negtionalLiteral2);
    		    					f = f.addClause(c);
    							}
    						}
    						
    					}
    				}
    			}
    		}
    	}
    	checkRep();
    	return f;
       // throw new RuntimeException("not yet implemented.");
    }

    /**
     * Interpret the solved SAT problem as a filled-in grid.
     * 
     * @param e
     *            Assignment of variables to values that solves this puzzle.
     *            Requires that e came from a solution to this.getProblem().
     * @return a new Sudoku grid containing the solution to the puzzle, with no
     *         blank entries.
     */
    public Sudoku interpretSolution(Environment e) {

        // TODO: implement this.
        //throw new RuntimeException("not yet implemented.");
    	int[][] updatedSquares = new int[size][size];
    	if (e == null){
    		return null;
    	}
    	for (int i=0; i<size; i++){
    		for (int j = 0; j<size; j++){
    			for (int k = 0; k<size; k++){
    				Bool value = e.get(occupies[i][j][k]);
    				if (value.equals(Bool.TRUE)){
    					updatedSquares[i][j] = k + 1;
    				}
    			}
    		}
    	}
    	checkRep();
    	return new Sudoku(dim, updatedSquares);
    }
}