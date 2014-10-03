package ladderGame;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static org.junit.Assert .*;

import org.junit.Test;

public class PositionTest {

	@Test
	public void test() {
		Position current = new Position();
		
		current.init(0);
		
		assertThat(current.getRow(), is(0));
		
		current.moveToNextRow();
		
		assertThat(current.getRow(), is(1));
	}
	
	@Test
	public void initTest() throws Exception {
		Position position = new Position();
		position.init(4);
		
		assertThat(position.getRow(), is(0));
		assertThat(position.getColumn(), is(4));
	}

}
