package test.game.of.life;

public class Cell {
	private int Status;  // 细胞状态
	private int LivingNum;  // 存活细胞数目
	private int x;  // 横坐标
	private int y;  // 纵坐标
	Cell(){
		Status = 0;
		LivingNum = 0;
	}
	Cell(int status, int livingnum){
		Status = status;
		LivingNum = livingnum;
	}
	public int getStatus() {
		return Status;
	}
	public void setStatus(int status) {
		Status = status;
	}
	public int getLivingNum() {
		return LivingNum;
	}
	public void setLivingNum(int livingNum) {
		LivingNum = livingNum;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public void UpdateStatus() {
		if(this.getLivingNum() > 3 || this.getLivingNum() < 2){  
			// 周围活细胞数目大于3或者小于2，则细胞死亡
			this.setStatus(0);   
		}
		else if(this.getLivingNum() == 3){  
			// 细胞存活
			this.setStatus(1);
		}
		else{
			// 细胞状态不变
			this.setStatus(this.Status);
		}
	}
}