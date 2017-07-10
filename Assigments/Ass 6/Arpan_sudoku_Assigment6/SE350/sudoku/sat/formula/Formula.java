/**
 * Author: dnj, Hank Huang
 * Date: March 7, 2009
 * 6.005 Elements of Software Construction
 * (c) 2007-2009, MIT 6.005 Staff
 */
package sat.formula;


import immutable.ImList;
import immutable.NonEmptyImList;
import immutable.ImListIterator;
import immutable.EmptyImList;

import java.util.Iterator;

import sat.env.Variable;

/**
 * Formula represents an immutable boolean formula in
 * conjunctive normal form, intended to be solved by a
 * SAT solver.
 */
public class Formula {
    private final ImList<Clause> clauses;
    // Rep invariant:
    //      clauses != null
    //      clauses contains no null elements (ensured by spec of ImList)
    //
    // Note: although a formula is intended to be a set,  
    // the list may include duplicate clauses without any problems. 
    // The cost of ensuring that the list has no duplicates is not worth paying.
    //
    //    
    //    Abstraction function:
    //        The list of clauses c1,c2,...,cn represents 
    //        the boolean formula (c1 and c2 and ... and cn)
    //        
    //        For example, if the list contains the two clauses (a,b) and (!c,d), then the
    //        corresponding formula is (a or b) and (!c or d).

    void checkRep() {
        assert this.clauses != null : "SATProblem, Rep invariant: clauses non-null";
    }

    /**
     * Create a new problem for solving that contains no clauses (that is the
     * vacuously true problem)
     * 
     * @return the true problem
     */
    public Formula() {

        // TODO: implement this.
    	this.clauses = new EmptyImList<Clause>();
    	checkRep() ;
        //throw new RuntimeException("not yet implemented.");
    }

    /**
     * Create a new problem for solving that contains a single clause with a
     * single literal
     * 
     * @return the problem with a single clause containing the literal l
     */
    public Formula(Variable l) {
        // TODO: implement this.
    	Literal lit = PosLiteral.make(l);
    	Clause c = new Clause(lit);
        this.clauses = new NonEmptyImList<Clause> (c);
        checkRep() ;
        //throw new RuntimeException("not yet implemented.");
    }
    public Formula(ImList<Clause> clauses) { this.clauses = clauses;}
    /**
     * Create a new problem for solving that contains a single clause
     * 
     * @return the problem with a single clause c
     */
    public Formula(Clause c) {
        // TODO: implement this.
    	//create list of one clause
    	//set claues above list 
    	//ImList<Clasue> l = new Empty
    	this.clauses =  new NonEmptyImList<Clause>(c);
    	checkRep();
       // throw new RuntimeException("not yet implemented.");
    }

    /**
     * Add a clause to this problem
     * 
     * @return a new problem with the clauses of this, but c added
     */
    public Formula addClause(Clause c) {
        // TODO: implement this.
    	ImList<Clause> add_Clauses = this.getClauses();
    	ImList<Clause> latest_Clasues = add_Clauses.add(c);
    	checkRep() ;
    	return new Formula(latest_Clasues);
    	
        //throw new RuntimeException("not yet implemented.");
    }

    /**
     * Get the clauses of the formula.
     * 
     * @return list of clauses
     */
    public ImList<Clause> getClauses() {
        // TODO: implement this.
    	checkRep() ;
    	return clauses;
    	//checkRep() ;
        //throw new RuntimeException("not yet implemented.");
    }

    /**
     * Iterator over clauses
     * 
     * @return an iterator that yields each clause of this in some arbitrary
     *         order
     */
    public Iterator<Clause> iterator() {
        // TODO: implement this.
    	return new ImListIterator<Clause>(this.clauses);
        //throw new RuntimeException("not yet implemented.");
    }

    /**
     * @return a new problem corresponding to the conjunction of this and p
     */
    public Formula and(Formula p) {
        // TODO: implement this.
       // throw new RuntimeException("not yet implemented.");
    	ImList<Clause> latest_Clasues = this.getClauses();
    	Iterator <Clause> p_formula_iter = p.iterator();
    	//Iterator i = p.iterator();
    	for (Iterator<Clause> i = p_formula_iter; i.hasNext();){
    		Clause adjacent_Clause = p_formula_iter.next();
    		latest_Clasues = latest_Clasues.add(adjacent_Clause);
    	}
    	return new Formula(latest_Clasues);
    }

    /**
     * @return a new problem corresponding to the disjunction of this and p
     */
    public Formula or(Formula p) {
        // TODO: implement this.
        // Hint: you'll need to use the distributive law to preserve conjunctive normal form, i.e.:
        //   to do (a & b) .or (c & d),
        //   you'll need to make (a | b) & (a | c) & (b | c) & (b | d)  
        if (this.clauses.isEmpty()) return new Formula(p.clauses);
    	if (p.clauses.isEmpty()) return new Formula(this.clauses);
    	ImList<Clause> clauses = new EmptyImList<Clause>();
    	for (Clause cal : this.clauses){
   		for (Clause cal_second: p.clauses){
//    			System.out.println(clause1.merge(clause2));
    			clauses = (ImList<Clause>) clauses.add(cal.merge(cal_second  ));
    		}
    	}
//    	return new Formula(clauses);
    	return new Formula(clauses);
     
    }
    

    /**
     * @return a new problem corresponding to the negation of this
     */
    public Formula not() {
        // TODO: implement this.
        // Hint: you'll need to apply DeMorgan's Laws (http://en.wikipedia.org/wiki/De_Morgan's_laws)
        // to move the negation down to the literals, and the distributive law to preserve 
        // conjunctive normal form, i.e.:
        //   if you start with (a | b) & c,
        //   you'll need to make !((a | b) & c) 
        //                       => (!a & !b) | !c            (moving negation down to the literals)
        //                       => (!a | !c) & (!b | !c)    (conjunctive normal form)
    	
    	Formula formulae = new Formula();
    	for(Clause clause: this.clauses){
    		Formula negations = new Formula();
    		for(Literal lit: clause){
    			Literal l = lit.getNegation();
    			Clause negtionalLiteral = new Clause(l);
    			negations = negations.addClause(negtionalLiteral);
    		}
    		formulae = formulae.or(negations);
    	}
    	ImList<Clause> result = new EmptyImList<Clause>();
    	for(Clause c: formulae.clauses){
    		Clause  cal = new Clause();
    		for(Literal l : c){
    			cal = cal.add(l);
    		}
    		result = (ImList<Clause>)result.add(cal);
    	}
    	return new Formula(result);
    	
       // throw new RuntimeException("not yet implemented.");
    }

    /**
     * 
     * @return number of clauses in this
     */
    public int getSize() {
        // TODO: implement this.
    	return clauses.size();
        //throw new RuntimeException("not yet implemented.");
    }

    /**
     * @return string representation of this formula
     */
    public String toString() {
        String result = "Problem[";
        for (Clause c : clauses)
            result += "\n" + c;
        return result + "]";
    }
}
