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
					assertEquals(8,cell[i][j].getLivingNum());//ϸ�����м䣬��Χ��8����ϸ��
				else if((i==0||i==15)&&(j>0&&j<15)||(j==0||j==15)&&(i>0&&i<15)) 
					assertEquals(5,cell[i][j].getLivingNum());//ϸ���ڱ��ϣ���Χ��5����ϸ��
				else 
					assertEquals(3,cell[i][j].getLivingNum());//ϸ���ڽ��ϣ���Χ��3����ϸ��
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
				assertEquals(0,cell[i][j].getLivingNum());//û�л�ϸ��
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
		assertEquals(4,map.UpdateMap(cell));//���Ľ�ϸ������״̬�������仯
		for(int i=0;i<16;i++) {
			for(int j=0;j<16;j++) {
				cell[i][j].setStatus(0);
			}
		}
		map.getliving(cell);
		assertEquals(256,map.UpdateMap(cell));//����ϸ�����������������仯
	}
}
