package ladderGame;

import java.util.HashMap;
import java.util.Map;

public class LadderGame {
	private static final int RIGHT = 1;
	private static final int LEFT = -1;
	
	public void run(){
		Map<Integer, int[]> ladder = makeLadder();
		int input = 0;
		int result;
		result = find(ladder, input);
		
		System.out.println("결과는 "+result+"입니다!");
	}
	
	public Map<Integer, int[]> makeLadder(){
		//Ladder ladder = new Ladder();
		Map<Integer, int[]> ladder = new HashMap<Integer, int[]>();

		int[] column0 = {0,0,0,0,0};
		int[] column1 = {RIGHT,LEFT,0,RIGHT,LEFT};
		int[] column2 = {0,RIGHT,LEFT,0,0};
		int[] column3 = {0,0,0,0,0};
		int[] column4 = {RIGHT,LEFT,RIGHT,LEFT,0};
		int[] column5 = {0,0,0,0,0};
		int[] column6 = {0,0,0,RIGHT,LEFT};
		int[] column7 = {0,RIGHT,LEFT,0,0};
		int[] column8 = {RIGHT,LEFT,0,RIGHT,LEFT};
		int[] column9 = {0,0,RIGHT,LEFT,0};
		
		ladder.put(0,column0);
		ladder.put(1,column1);
		ladder.put(2,column2);
		ladder.put(3,column3);
		ladder.put(4,column4);
		ladder.put(5,column5);
		ladder.put(6,column6);
		ladder.put(7,column7);
		ladder.put(8,column8);
		ladder.put(9,column9);
		
		return ladder;
	}

	public int find(Map<Integer, int[]> ladder, int input){
		Position current = new Position();
		current.init(input);
		
		for (int i = 0; i < ladder.size(); i++) {
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
}
