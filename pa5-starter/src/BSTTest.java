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
	public void putTest1() {
		BST test = new BST<>();
		test.put("C", 3);
		test.put("A", 1);
		test.put("B", 2);
		
		boolean answer = test.put("A", 1);
		assertFalse(answer);
	}

	@Test
	public void getTest1() {
		BST test = new BST<>();
		test.put("C", 3);
		test.put("A", 1);
		test.put("B", 2);
		
		int answer = (int) test.get("A");
		assertEquals(answer, 1);
	}

	@Test
	public void replaceTest1() {
		BST test = new BST<>();
		test.put("C", 3);
		test.put("A", 1);
		test.put("B", 2);
		
		boolean answer = test.replace("A",2);
		int changedValue = (int) test.get("A");
		assertTrue(answer);
		assertEquals(changedValue, 2);
	}
}
