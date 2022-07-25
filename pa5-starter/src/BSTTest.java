import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.junit.*;

public class BSTTest {
	
	/* TODO: Add your own tests */
	@Test
	public void dummyTest() {
		
	}

	@Test
	public void dummyTest2() {
		BST test = new BST<>();
		test.put("C", 3);
		test.put("A", 1);
		test.put("B", 2);
		
		boolean answer = test.put("A", 1);
		assertFalse(answer);
	}
}
