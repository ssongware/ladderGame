package ladderGame;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class LadderGame {
	private static final int RIGHT = 1;
	private static final int LEFT = -1;
	private static final int DEFAULT_ROW = 10;
	private static final int RANDOM_NUMERATOR = 1;
	private static final int RANDOM_DENOMINATOR = 3;
	
	public void run(){
		Scanner sc = new Scanner(System.in);
		
		System.out.println("------ Ladder Game Start!! ------");
		System.out.print("How many players? ");
		int player = sc.nextInt();
		Ladder ladder = makeLadder(player);
		
		while (true) {
			System.out.print("Choose your number : ");
			int input = sc.nextInt();
			int result = find(ladder, input - 1);
			
			System.out.println("Result is " + (result + 1) + "!\n");
		}
	}
	
	public Ladder makeLadder(int player){
		Ladder ladder = new Ladder();
		
		for (int i = 0 ; i < DEFAULT_ROW; i++) {
			int[] randomColumn = makeRow(player);
			ladder.put(i, randomColumn);
		}
		
		return ladder;
	}

	public int find(Ladder ladder, int input){
		Position current = new Position();
		current.init(input);
		
		for (int i = 0; i < ladder.size(); i++) {
			showPath(current, ladder);
			current = moveToDirection(current, ladder.get(i));
		}
		
		return current.getColumn();
	}

	private Position moveToDirection(Position current, int[] directions) {
		int currentColumn = current.getColumn();
		int direction = directions[currentColumn];
		
		if(direction != 0) {
			current.setColumn(currentColumn+direction);
		}
		
		current.moveToNextRow();
		
		return current;
	}

	public int[] makeRow(int player) {
		Random rand = new Random();
		int[] column = new int[player];
		
		for (int i = 0; i < (column.length-1); i++) {
			if (rand.nextInt(RANDOM_DENOMINATOR) < RANDOM_NUMERATOR) {
				column[i] = RIGHT;
				column[++i] = LEFT;
			}
		}
		
		if (!isValidColumn(column)) {
			throw new RuntimeException("잘못된 라인 생성");
		}
		
		return column;
	}

	public boolean isValidColumn(int[] randomColumn) {
		int valid = 0;
		for (int i = 0; i < randomColumn.length; i++) {
			valid += randomColumn[i];
		}
		
		if (valid == 0) {
			return true;
		}
		
		return false;
	}
	
	private void showPath(Position current, Ladder ladder) {
		int currentRow = current.getRow();
		int currentColumn = current.getColumn();
		
		System.out.println("----------------------------------");
		for(int i = 0 ; i < ladder.size(); i++) {
			String str = rowToString(ladder.get(i));
			
			if(i == currentRow) {
				str = currentRowToString(ladder.get(i), currentColumn);
			}
			
			System.out.println(str);
		}
		System.out.println("----------------------------------");
	}
	
	private String rowToString(int[] column) {
		String str = "";
		for (int i : column) {
			str += i + "\t";
		}
		
		return str;
	}
	
	private String currentRowToString(int[] column, int currentColumn) {
		String str = "";
		for (int i = 0; i < column.length; i++) {
			if (i == currentColumn) {
				str += column[i] + "*\t";
			}else {
				str += column[i] + "\t";
			}
		}
		
		return str;
	}
}
