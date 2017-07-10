package basics.testing;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Comparator;

class LT implements Comparator<Integer> {
	public int compare(Integer i, Integer j){
		 return i.intValue() - j.intValue();
	}
}

class GT implements Comparator<Integer> {
	public int compare(Integer i, Integer j){
		 return j.intValue() - i.intValue();
	}
}

class Funny implements Comparator<Integer> {
	public int compare(Integer i, Integer j){
		int x = i.intValue();
		int y = j.intValue();
		if  ((x>=0) || (y>=0))
			return x-y;
		else 
			return y-x;	
	}
}

public class Arr {
	
	 static int sum(int[] a){
		// sum the array
		// pre: a is  not null
		 assert a!=null : "array is null unexpectdly in sum";
		
		int s = 0;
		for (int x: a)
			// Invariants: s is the sum of the array so far
			s +=x;
		
		// postconditions: s is the sum of the full array
		return s;
	}
     
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> a1 = new ArrayList<Integer>();
		for (int i =5; i >0; i--){ 
			a1.add(i); a1.add(-i);
		}
		Collections.sort(a1);
		System.out.println(a1);
		
		ArrayList<Integer> a2 = new ArrayList<Integer>();
		for (int i =5; i >0; i--){
			a2.add(i);a2.add(-i);
		}
		Collections.sort(a2,new LT());
		System.out.println(a2);
		
		
		ArrayList<Integer> a3 = new ArrayList<Integer>();
		for (int i =5; i >0; i--){
			a3.add(i);a3.add(-i);
		}
		Collections.sort(a3,new GT());
		System.out.println(a3);
		
		ArrayList<Integer> a4 = new ArrayList<Integer>();
		for (int i =5; i >0; i--){
			a4.add(i);
			a4.add(-i);
		}
		Collections.sort(a4,new Funny());
		System.out.println(a4);
	}

}
