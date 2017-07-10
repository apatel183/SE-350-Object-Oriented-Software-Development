package hw2;

import static org.junit.Assert.*;
import java.util.Arrays;

import org.junit.Test;

public class AssertExp1Test {
	

	@Test
	public void testMinValue() {
		//fail("Not yet implemented");
		assertEquals(AssertExp1.minValue(new double[]{-7}),-7,0);
		assertEquals(AssertExp1.minValue(new double[]{1, 2, 3, 4, 5, 6, 7 }),1.0,0);
		assertEquals(AssertExp1.minValue(new double[]{-12, -1, -7, 3, 0, 10 }),-12,0);
		assertEquals(AssertExp1.minValue(new double[]{1, -4, -7, 7, 8, 11, -9 }),-9.0,0);
		assertEquals(AssertExp1.minValue(new double[]{1, -4, -7, 7, 8,11}),-7,0);
		assertEquals(AssertExp1.minValue(new double[]{-1, -1, -2, -0, 12, -50 }),-50,0);
		assertEquals(AssertExp1.minValue(new double[]{1, -2, -0, -7, -1, -11, -1 }),-11.0,0);
		assertEquals(AssertExp1.minValue(new double[]{-13, -4, -7, 7, 8, 11 }),-13,0);
		assertEquals(AssertExp1.minValue(new double[]{1, 2, 3, 4, 5, 6, 7 }),1.0,0);
		
		
		
	}

	@Test
	public void testMinPosition() {
		//fail("Not yet implemented");
		assertEquals(AssertExp1.minPosition(new double[] { -7 }),0);
		assertEquals(AssertExp1.minPosition(new double[] { 1, -4, -7, 7, -8, 11, 9}),4);
		assertEquals(AssertExp1.minPosition(new double[] { -13, -4, -7, 7, 8, 11}),0);
		assertEquals(AssertExp1.minPosition(new double[] { 1, -4, -7, 7, 8, 11, -9}),6);
		assertEquals(AssertExp1.minPosition(new double[] { 1, -3, -6, 9, 12, 0}),5);
		assertEquals(AssertExp1.minPosition(new double[] { 1, -4, 0, 1, -7, 8, -0, -9}),7);
		assertEquals(AssertExp1.minPosition(new double[] { 1, -2, 3, 7, -8, 0, 9}),5);

		
	}

	@Test
	public void testNumUnique() {
		//fail("Not yet implemented");
		assertEquals(AssertExp1.numUnique(new double[] { }),0);
		assertEquals(AssertExp1.numUnique(new double[] {1,1,2,3,4,5,6 }),6);
		assertEquals(AssertExp1.numUnique(new double[] { 7 }),1);
		assertEquals(AssertExp1.numUnique(new double[] {111,2, 3, 444, 555, }),5);
		assertEquals(AssertExp1.numUnique(new double[] { 11, 11 }),1);
		assertEquals(AssertExp1.numUnique(new double[] { 11, 11, 11, 11, 22, 33, 44, 44, 44, 44, 55, 55, 88,99 }),7);
		assertEquals(AssertExp1.numUnique(new double[] {51, 51, 52, 53, 54,  }),4);
		assertEquals(AssertExp1.numUnique(new double[] { 11, 11, 11, 11, 22, 33, 44, 44, 44, 44, 44, 55, 55, 66, 77, 88, 88 }),8);
		assertEquals(AssertExp1.numUnique(new double[] { 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 7, 8,11,23 }),10);
		assertEquals(AssertExp1.numUnique(new double[] { 11, 11, 11, 11, 22, 33, 44, 44, 44, 44, 44, 55, 55, 66, 77, 88, 88,99,99 }),9);
		
	}

	@Test
	public void testRemoveDuplicates() {
		//fail("Not yet implemented");
		
		assertTrue(Arrays.equals(AssertExp1.removeDuplicates(new double []{}), new double [] {}));
		assertTrue(Arrays.equals(AssertExp1.removeDuplicates(new double []{11}), new double [] {11}));
		assertTrue(Arrays.equals(AssertExp1.removeDuplicates(new double []{11, 11, 11, 11}), new double [] {11}));
		assertTrue(Arrays.equals(AssertExp1.removeDuplicates(new double []{1, 1, 1, 1, 1, 2, 2, 3, 3,}), new double [] {1, 2, 3}));
		assertTrue(Arrays.equals(AssertExp1.removeDuplicates(new double []{22,22,11}), new double [] {22,11}));
		assertTrue(Arrays.equals(AssertExp1.removeDuplicates(new double []{100, 200, 300, 400, 500 }), new double [] {100, 200,300, 400, 500}));
		assertTrue(Arrays.equals(AssertExp1.removeDuplicates(new double []{22,22,11,12,12,14,15}), new double [] {22,11,12,14,15}));
		assertTrue(Arrays.equals(AssertExp1.removeDuplicates(new double []{11, 11, 11, 11, 22, 33, 44, 44, 44, 44, 44, 55, 55, 66, 77, 88, 88}), new double [] {11,22,33,44,55,66,77,88}));
		assertTrue(Arrays.equals(AssertExp1.removeDuplicates(new double[] { 11, 11, 11, 22, 33, 44, 44, 44, 44, 55, 55, 66, 77, 88, 88 }), new double [] {11, 22, 33,44,55,66,77,88}));
		
		
		
	}
	

}
