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

	@Test
	public void removeTest1() {
		BST test = new BST<>();
		test.put("C", 3);
		test.put("A", 1);
		test.put("B", 2);
		
		boolean answer = test.remove("B");
		int value = (int) test.get("A");
		int size = test.size();
		assertEquals(true, answer);
		assertEquals(1, value);
		assertEquals(2, size);
	}

	@Test
	public void removeTest2() {
		BST test = new BST<>();
		test.put("C", 3);
		test.put("B", 1);
		test.put("A", 2);
		
		test.remove("C");
		test.remove("B");
		boolean answer = test.remove("A");
		int size = test.size();
		assertEquals(true, answer);
		assertEquals(0, size);
	}

	@Test
	public void removeTest3() {
		BST test = new BST<>();
		test.put("A", 3);
		test.put("B", 1);
		test.put("C", 2);
		
		test.remove("A");
		test.remove("B");
		boolean answer = test.remove("C");
		int size = test.size();
		assertEquals(true, answer);
		assertEquals(0, size);
	}

	@Test
	public void removeTest4() {
		BST test = new BST<>();
		test.put("A", 3);
		test.put("B", 1);
		test.put("E", 2);
		test.put("D", 2);
		test.put("G", 2);
		
		boolean answer = test.remove("B");
		int size = test.size();
		assertEquals(true, answer);
		assertEquals(4, size);
	}

	@Test
	public void removeTest5() {
		BST test = new BST<>();
		test.put("E", 3);
		test.put("D", 3);
		test.put("A", 3);
		test.put("C", 1);
		test.put("B", 2);
		
		boolean answer = test.remove("D");
		int size = test.size();
		assertEquals(true, answer);
		assertEquals(4, size);
	}
}
