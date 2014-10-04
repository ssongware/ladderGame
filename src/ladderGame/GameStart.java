package ladderGame;

public class GameStart {

	public static void main(String[] args) {
		LadderGame lg = new LadderGame();
		
		try {
			lg.run();
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("입력이 정확하지 않습니다.");
			lg.run();
		}
	}

}
