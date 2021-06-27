package test.game.of.life;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MapTest {
	private static Map map=new Map();
	private static Cell [][]cell=new Cell[16][16];
	@Before
	public void setUp() throws Exception {
		cell=map.initial();
	}

	@Test
	public void testGetliving() {
		for(int i=0;i<16;i++) {
			for(int j=0;j<16;j++) {
				cell[i][j].setStatus(1);
			}
		}
		map.getliving(cell);
		for(int i=0;i<16;i++) {
			for(int j=0;j<16;j++) {
				if(i>0&&i<15&&j>0&&j<15) 
					assertEquals(8,cell[i][j].getLivingNum());//细胞在中间，周围有8个活细胞
				else if((i==0||i==15)&&(j>0&&j<15)||(j==0||j==15)&&(i>0&&i<15)) 
					assertEquals(5,cell[i][j].getLivingNum());//细胞在边上，周围有5个活细胞
				else 
					assertEquals(3,cell[i][j].getLivingNum());//细胞在角上，周围有3个活细胞
			}
		}
		for(int i=0;i<16;i++) {
			for(int j=0;j<16;j++) {
				cell[i][j].setStatus(0);
			}
		}
		map.getliving(cell);
		for(int i=0;i<16;i++) {
			for(int j=0;j<16;j++) {
				assertEquals(0,cell[i][j].getLivingNum());//没有活细胞
			}
		}
	}

	@Test
	public void testUpdateMap() {
		for(int i=0;i<16;i++) {
			for(int j=0;j<16;j++) {
				cell[i][j].setStatus(1);
			}
		}
		map.getliving(cell);
		assertEquals(4,map.UpdateMap(cell));//仅四角细胞存活，即状态不发生变化
		for(int i=0;i<16;i++) {
			for(int j=0;j<16;j++) {
				cell[i][j].setStatus(0);
			}
		}
		map.getliving(cell);
		assertEquals(256,map.UpdateMap(cell));//所有细胞都不存活，均不发生变化
	}
}
