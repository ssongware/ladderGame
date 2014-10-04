package ladderGame;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PositionTest {

	Position position = null;
	
	@Before
	public void setup() {
		position = new Position();
	}
	
	@Test
	public void moveToNextRowtest() {
		position.init(0);
		assertThat(position.getRow(), is(0));
		
		position.moveToNextRow();
		assertThat(position.getRow(), is(1));
	}
	
	@Test
	public void initTest() throws Exception {
		position.init(4);
		assertThat(position.getRow(), is(0));
		assertThat(position.getColumn(), is(4));
	}

}
