package hw2;
//import stdlib.*;
//import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class MyLinkedTest {

	@Test
	public void testMyLinked() {
		//fail("Not yet implemented");
	    MyLinked b = new MyLinked ();
        b.add (1);
        Assert.assertEquals(1,b.size());
        b.delete (0);
        Assert.assertEquals(0,b.size());;
        for (double i = 1; i < 13; i++) {
            b.add (i);
        }
        Assert.assertEquals(12,b.size());
        b.delete (0);
        Assert.assertEquals(11,b.size());
        b.delete (10);
        Assert.assertEquals(10,b.size());
        b.delete (4);
        Assert.assertEquals(9,b.size());
	}

	@Test
	public void testIsEmpty() {
		//fail("Not yet implemented");
		MyLinked b = new MyLinked();
		b.add(1);
		Assert.assertEquals(1,b.size());
		b.add(2);
		Assert.assertEquals(2,b.size());
		b.delete(1);
		Assert.assertEquals(1,b.size());
		
		
		
	}

	@Test
	public void testSize() {
		//fail("Not yet implemented");
		MyLinked b = new MyLinked();
		b.add(1);
		Assert.assertEquals(1,b.size());
		b.add(2);
		Assert.assertEquals(2,b.size());
		b.add(3);
		Assert.assertEquals(3,b.size());
		b.add(4);
		Assert.assertEquals(4,b.size());
		b.add(5);
		Assert.assertEquals(5,b.size());
		
		
		
	}

	@Test
	public void testAdd() {
		//fail("Not yet implemented");
		MyLinked b = new MyLinked ();
        b.add (1);
        Assert.assertEquals(1,b.size());
        b.add(2);
        Assert.assertEquals(2,b.size());
        b.add(3);
        Assert.assertEquals(3,b.size());
        b.add(4);
        Assert.assertEquals(4,b.size());
        
        
	}

	@Test
	public void testDelete() {
		//fail("Not yet implemented");
		MyLinked b = new MyLinked ();
		
		try {b.delete(0); }
		catch (IllegalArgumentException e ) {};
        b.add (1);
        b.delete (0);
        Assert.assertEquals(0,b.size());
        for (double i = 1; i < 13; i++) {
            b.add (i);
        }
        b.delete (0);
        Assert.assertEquals(11,b.size());
        b.delete (10);
        Assert.assertEquals(10,b.size());
        b.delete (4);
        Assert.assertEquals(9,b.size());
       	}

	
	
	
	
	@Test
	public void testReverse() {
		//fail("Not yet implemented");
		 MyLinked b = new MyLinked ();
		 try {b.reverse(); }
		 catch (IllegalArgumentException e ) {};
	        b.add (1);
	        Assert.assertEquals(1, b.size());
	        b.reverse ();
	        Assert.assertEquals(1,b.size());
	        b.add (2);
	        Assert.assertEquals(2, b.size());
	        b.reverse ();
	        Assert.assertEquals(2, b.size());
	        b.reverse ();
	        Assert.assertEquals(2, b.size());
	        for (double i = 3; i < 7; i++) {
	            b.add (i);
	            b.add (i);  
	        }
	        Assert.assertEquals(10, b.size());
	        b.reverse ();
	        Assert.assertEquals(10, b.size());
	}


	@Test
	public void testRemove() {
		//fail("Not yet implemented");
		MyLinked b = new MyLinked ();
		try {b.remove(4);}
		catch (IllegalArgumentException e) {};
        b.add (1);
        b.remove (4);
        Assert.assertEquals(1, b.size());
        b.remove (1);
        Assert.assertEquals(0, b.size());
        for (double i = 1; i < 5; i++) {
            b.add (i);
            b.add (i);
        }
        for (double i = 1; i < 5; i++) {
            b.add (i);
            b.add (i);
            b.add (i);
            b.add (i);
            b.add (i);
        }
        Assert.assertEquals(28, b.size());
        b.remove (9);
        Assert.assertEquals(28, b.size());
        b.remove (3);
        Assert.assertEquals(21, b.size());
        b.remove (1);
        Assert.assertEquals(14, b.size());
        b.remove (4);
        Assert.assertEquals(7, b.size());
        b.remove (2);
        Assert.assertEquals(0, b.size());
	}

}
