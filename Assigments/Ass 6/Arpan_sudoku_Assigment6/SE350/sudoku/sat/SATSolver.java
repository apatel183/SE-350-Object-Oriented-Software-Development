package sat;

import immutable.EmptyImList;
import immutable.ImList;
import sat.env.Environment;
import sat.env.Variable;
import sat.formula.Clause;
import sat.formula.Formula;
import sat.formula.Literal;
import sat.formula.NegLiteral;

import sat.formula.PosLiteral;
import sat.formula.NegLiteral;

/**
 * A simple DPLL SAT solver. See http://en.wikipedia.org/wiki/DPLL_algorithm
 */
public class SATSolver {
    /**
     * Solve the problem using a simple version of DPLL with backtracking and
     * unit propagation. The returned environment binds literals of class
     * bool.Variable rather than the special literals used in clausification of
     * class clausal.Literal, so that clients can more readily use it.
     * 
     * @return an environment for which the problem evaluates to Bool.TRUE, or
     *         null if no such environment exists.
     */
    public static Environment solve(Formula formula) {
        // TODO: implement this.
    	Environment env = new Environment();
    	ImList<Clause> c = formula.getClauses();
    	Environment answer = solve (c,env);
    	return answer;
        //throw new RuntimeException("not yet implemented.");
    }

    /**
     * Takes a partial assignment of variables to values, and recursively
     * searches for a complete satisfying assignment.
     * 
     * @param clauses
     *            formula in conjunctive normal form
     * @param env
     *            assignment of some or all variables in clauses to true or
     *            false values.
     * @return an environment for which all the clauses evaluate to Bool.TRUE,
     *         or null if no such environment exists.
     */
    private static Environment solve(ImList<Clause> clauses, Environment env) {
        // TODO: implement this.
    	if (clauses.size()==0){
    		return env;
    	}
    	int sizeOfmin = Integer.MAX_VALUE;
    	Clause clause_minimum =  null;
    	//find min clause 
    	for (Clause c : clauses){
    		//if(c.isEmpty()) return env; //if empty clause found 
    		if (c.size() < sizeOfmin) {
    			sizeOfmin = c.size();
    			clause_minimum = c;
    		}
    	}
    	//when it is null, back propagate
    	//therefore not solvable
    	if (sizeOfmin == 0){
    		return null;	
    	}
    	// clause has the sizeOfmin ==1
    	//assigned it to the variable v
    	//now the variable will be satisfied
    	//Therefore, we recurse on smaller problem 
    	//subsitute (clasues, literal)
    	else if (sizeOfmin == 1){
    		Literal lit = clause_minimum.chooseLiteral();
    		Variable v = lit.getVariable();
    		Literal newlit = PosLiteral.make(v);
    		if(newlit.negates(lit)){
    			Environment newEnv = env.putFalse(v);
    			ImList<Clause> newClauses = substitute(clauses,lit);
    			return solve(newClauses,newEnv);
    		} 
    	else {
    			Environment newEnv = env.putTrue(v);
    			ImList<Clause> newClauses = substitute(clauses,lit);
    			return solve(newClauses, newEnv);	
    		}
    }
    else 
    { 
    	// Clause has the sizeOfmin > 1
    	//choose an arbitrary literal
    	//Assigned as true 
    	//negate literal
    	//postliteral 
    	//Therefore, we recurse
    	//return the answer 
    	Literal lit = clause_minimum.chooseLiteral();
    	Variable v = lit.getVariable();
    	//assignment of some or all variables in clauses to true values.
    	Environment newEnvironment = env.putTrue(v);
    	Literal postlit = PosLiteral.make(v);
    	//given a clause list and literal, produce a new list resulting from setting that literal to true
    	ImList<Clause> newClauses = substitute(clauses,postlit);
    	// returns an environment for which all the clauses evaluate to Bool.TRUE, or null if no such environment exists.
    	Environment answer = solve(newClauses,newEnvironment);
    	if (answer == null){
    		//answer is not correct
    		//back propagate
    		//a new environment in which l has the value Bool.FALSE if a binding for l already exists, overwrites it
    		newEnvironment = env.putFalse(v);
    		Literal neglit = NegLiteral.make(v);
    		//a new list of clauses resulting from setting l to true
    		newClauses = substitute(clauses,neglit);
    		return solve(newClauses,newEnvironment);
    	}
    	return answer;
    }
    	// throw new RuntimeException("not yet implemented.");
    }

    /**
     * given a clause list and literal, produce a new list resulting from
     * setting that literal to true
     * 
     * @param clauses
     *            , a list of clauses
     * @param l
     *            , a literal to set to true
     * @return a new list of clauses resulting from setting l to true
     */
    private static ImList<Clause> substitute(ImList<Clause> clauses,
            Literal l) {
        // TODO: implement this.
    	ImList<Clause> newClauses =  new EmptyImList<Clause> ();
    	for (Clause c : clauses){
    		//clause obtained by setting literal to true or null if the entire clause becomes true
    		Clause newClause = c.reduce(l);
    		if (newClause != null){
    			newClauses = newClauses.add(newClause);
    		}
    	}
    	return newClauses;
       // throw new RuntimeException("not yet implemented.");
    }

}
