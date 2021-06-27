package test.game.of.life;

public class Cell {
	private int Status;  // ϸ��״̬
	private int LivingNum;  // ���ϸ����Ŀ
	private int x;  // ������
	private int y;  // ������
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
			// ��Χ��ϸ����Ŀ����3����С��2����ϸ������
			this.setStatus(0);   
		}
		else if(this.getLivingNum() == 3){  
			// ϸ�����
			this.setStatus(1);
		}
		else{
			// ϸ��״̬����
			this.setStatus(this.Status);
		}
	}
}