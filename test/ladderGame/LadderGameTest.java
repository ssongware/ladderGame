package ladderGame;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LadderGameTest {
	
	LadderGame lg = null;
	
	@Before
	public void setup() {
		lg = new LadderGame();
	}
	
	@Test
	public void makeLadderTest() throws Exception {
		int player = 6;
		Ladder ladder = lg.makeLadder(player);
		
		assertThat(ladder.size(), is(10));
		for (int i = 0; i < ladder.size(); i++) {
			assertThat(ladder.get(i).length, is(6));
		}
	}
	
	@Test
	public void makeRandomColumnTest() throws Exception {
		int player = 6;
		assertThat(lg.makeColumn(player).length, is(6));
	}
	
	@Test
	public void isValidColumnTest() throws Exception {
		int player = 6;
		assertThat(lg.isValidColumn(lg.makeColumn(player)), is(true));
	}
}
