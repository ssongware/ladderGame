package ladderGame;

public class Position {
	private int row;
	private int column;
	
	
	
	public Position() {
	}
	
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	public int getColumn() {
		return column;
	}
	public void setColumn(int column) {
		this.column = column;
	}
	
	public void init(int column) {
		this.row = 0;
		this.column = column;
	}
	
	public void moveToNextRow(){
		this.row++;
	}
}
