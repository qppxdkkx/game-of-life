package test.game.of.life;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CellTest {
	private static Cell cell=new Cell();
	@Before
	public void setUp() throws Exception {
		;
	}

	@Test
	public void testUpdateStatus() {
		cell.setLivingNum(0);
		cell.UpdateStatus();
		assertEquals(0,cell.getStatus() );
		cell.setLivingNum(5);
		cell.UpdateStatus();
		assertEquals(0,cell.getStatus() );
		cell.setLivingNum(3);
		cell.UpdateStatus();
		assertEquals(1,cell.getStatus() );
		cell.setStatus(1);
		cell.setLivingNum(2);
		cell.UpdateStatus();
		assertEquals(1,cell.getStatus() );
	}
}