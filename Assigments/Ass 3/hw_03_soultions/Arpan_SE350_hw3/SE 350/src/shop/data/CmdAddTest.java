package shop.data;

import static org.junit.Assert.*;

import org.junit.Test;

public class CmdAddTest {
	private Inventory inventory = Data.newInventory();
	private void execpt (Video v, String s){
		assertEquals(s,inventory.get(v).toString());
	}

	@Test
	public void testCmdAdd() {
		Video v1 = Data.newVideo("Software Devloper", 2017, "Arpan Patel");
		assertEquals(0,inventory.size());
		//System.out.println(inventory.get(v1));
		assertTrue(Data.newAddCmd(inventory, v1, 5).run());
		expect(v1,"Software Devloper (2017): Arpan Patel [5,0,0]");
		assertEquals(1,inventory.size());
		assertTrue(Data.newAddCmd(inventory, v1, 10).run());
		expect(v1,"Software Devloper (2017): Arpan Patel [15,0,0]");
		assert(true);
	}

	private void expect(Video v1, String string) {
		// TODO Auto-generated method stub
		
	}

	@Test
	public void testRun() {
		assert(true);
	}

}
