package test.game.of.life;

import java.util.Random;

public class Map {
	final static public int x = 16;
	final static public int y = 16;
	public static Cell [][]initial(){
		Cell [][]map = new Cell[x][y];
		for(int i = 0; i<x; i++) {
			for(int j=0; j<y; j++) {
				map[i][j] = new Cell();
				Random random = new Random();
				map[i][j].setStatus(random.nextInt(2));
			}
		}
		return map;
	}
	public static void getliving(Cell [][]map) {
		// 获得活细胞的数目
		for(int i = 0; i < x; i++) {
			for(int j=0; j < y; j++) {
				int living = 0;
				// 获得周围活细胞的数目
				if(i > 0 && j > 0) {
					living += map[i - 1][j - 1].getStatus();
				}
				if(i > 0) {
					living += map[i - 1][j].getStatus();
				}
				if(j > 0) {
					living += map[i][j - 1].getStatus();
				}
				if(i < x - 1 && j < x - 1) {
					living += map[i + 1][j + 1].getStatus();
				}
				if(i < x - 1) {
					living += map[i + 1][j].getStatus();
				}
				if(j < x - 1) {
					living += map[i][j + 1].getStatus();
				}
				if(i < x - 1 && j > 0) {
					living += map[i + 1][j - 1].getStatus();
				}
				if(i > 0 && j < x - 1) {
					living += map[i - 1][j + 1].getStatus();
				}
				map[i][j].setLivingNum(living);
			}
		}
	}
	public static int UpdateMap(Cell [][]map) {
		// 
		int count = 0;
		for(int i = 0; i < x; i++) {
			for(int j = 0; j < y; j++) {
				int status = map[i][j].getStatus();
				map[i][j].UpdateStatus();  // 改变当前细胞状态
				if(status == map[i][j].getStatus()) {
					// 若没有变化，则+1
					count ++;
				}
			}
		}
		return count;
	}
	public static void PrintMap(Cell [][]map) {
		for(int i = 0; i < x; i++) {
			for(int j = 0; j < y; j++) {
				System.out.print(map[i][j].getStatus()+" ");
			}
			System.out.println();
		}
	}
}