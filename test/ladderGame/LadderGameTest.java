package ladderGame;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static org.junit.Assert .*;

import org.junit.Before;
import org.junit.Test;

public class LadderGameTest {

	@Test
	public void findTest() {
		LadderGame lg = new LadderGame();

		assertThat(lg.find(lg.makeLadder(), 0), is(2));
		assertThat(lg.find(lg.makeLadder(), 1), is(3));
		assertThat(lg.find(lg.makeLadder(), 2), is(1));
		assertThat(lg.find(lg.makeLadder(), 3), is(4));
		assertThat(lg.find(lg.makeLadder(), 4), is(0));
	}

}
