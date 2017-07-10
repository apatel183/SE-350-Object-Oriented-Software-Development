package sat;

import static org.junit.Assert.*;

import org.junit.Test;

import sat.env.Environment;
import sat.formula.Clause;
import sat.formula.Formula;
import sat.formula.Literal;
import sat.formula.PosLiteral;
import sudoku.Sudoku;

import sudoku.Sudoku.ParseException;
import java.io.*;
import org.junit.Test;
//import sudoku.Sudoku.ParseException;
import java.io.IOException;


import java.io.IOException;

public class SATSolverTest {
    Literal a = PosLiteral.make("a");
    Literal b = PosLiteral.make("b");
    Literal c = PosLiteral.make("c");
    Literal na = a.getNegation();
    Literal nb = b.getNegation();
    Literal nc = c.getNegation();

    // make sure assertions are turned on!  
    // we don't want to run test cases without assertions too.
    // see the handout to find out how to turn them on.
    @Test(expected=AssertionError.class)
    public void testAssertionsEnabled() {
        assert false;
    }
        
        @Test
        public void testeasy() {
           // assert false;
        	System.out.println("Testing sudoku_east.txt ");
        	Sudoku testingitout = null;
        	try {
        		testingitout= Sudoku.fromFile(3,"./samples/sudoku_easy.txt");
        		
        	}
        	catch (IOException | ParseException o){
        		o.printStackTrace();
        	}
        	Formula test = testingitout.getProblem();
        	Environment  environment = SATSolver.solve(test);
        	Sudoku answer = testingitout.interpretSolution(environment);
        	System.out.println(answer.toString());		
        	
    }
        @Test
        public void testhard() {
           // assert false;
        	System.out.println("Testing sudoku_hard.txt ");
        	Sudoku testingitout = null;
        	try {
        		testingitout= Sudoku.fromFile(3,"./samples/sudoku_hard.txt");
        		
        	}
        	catch (IOException | ParseException o){
        		o.printStackTrace();
        	}
        	Formula test = testingitout.getProblem();
        	Environment  environment = SATSolver.solve(test);
        	Sudoku answer = testingitout.interpretSolution(environment);
        	System.out.println(answer.toString());		
        	
    }
      @Test
      public void testnegation() {
    	System.out.println("Testing negation ");
    	Clause c1 = new Clause(na);
      	c1 = c1.add(nb);
      	Formula f = new Formula(c1);
      	System.out.println(f);
      	System.out.println(SATSolver.solve(f));
      }  
}
      
        
        
        
        
        
        

    