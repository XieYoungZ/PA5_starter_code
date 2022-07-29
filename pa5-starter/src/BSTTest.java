import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
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
	public void putTest2() {
		BST test = new BST<>();
		test.put("C", 3);
		test.put("A", 1);
		test.put("B", 2);
		boolean ans1 = test.put("F", 6);
		boolean ans2 = test.put("X", 24);
		boolean ans3 = test.put("Z", 26);

		assertTrue(ans1);
		assertTrue(ans2);
		assertTrue(ans3);
	}

	@Test
	public void getTest1() {
		BST test = new BST<>();
		test.put("C", 3);
		test.put("A", 1);
		test.put("B", 2);
		test.put("F", 6);
		test.put("X", 24);
		test.put("Z", 26);


		int answer = (int) test.get("A");
		int answer2 = (int) test.get("X");
		int answer3 = (int) test.get("Z");
		assertEquals(1, answer);
		assertEquals(24, answer2);
		assertEquals(26, answer3);
	}

	@Test
	public void getTest2() {
		BST test = new BST<>();
		test.put("C", 3);
		test.put("A", 1);
		test.put("B", 2);
		test.put("F", 6);
		test.put("X", 24);
		test.put("Z", 26);

		assertEquals(null, test.get("D"));
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
	public void replaceTest2() {
		BST test = new BST<>();
		test.put("C", 3);
		test.put("A", 1);
		test.put("B", 2);
		test.put("F", 6);
		test.put("X", 24);
		test.put("Z", 26);


		boolean answer = test.replace("A",2);
		int changedValue = (int) test.get("A");
		boolean answer2 = test.replace("A",0);
		int changedValue2 = (int) test.get("A");
		boolean answer3 = test.replace("F",0);
		boolean answer4 = test.replace("Random",0);
		int changedValue3 = (int) test.get("F");
		assertTrue(answer);
		assertEquals(changedValue, 2);
		assertTrue(answer2);
		assertEquals(changedValue2, 0);
		assertTrue(answer3);
		assertEquals(changedValue3, 0);
		assertFalse(answer4);
	}

	@Test
	public void setTest1() {
		BST test = new BST<>();
		test.put("C", 3);
		test.put("A", 1);
		test.put("B", 2);
		test.put("F", 6);
		test.put("X", 24);
		test.put("Z", 26);

		test.set("G", 10);
		int value = (int) test.get("G");
		assertEquals(value, 10);
		assertEquals(7, test.size());
	}

	@Test
	public void setTest2() {
		BST test = new BST<>();
		test.put("C", 3);
		test.put("A", 1);
		test.put("B", 2);
		test.put("F", 6);
		test.put("X", 24);
		test.put("Z", 26);

		test.set("F", 10);
		int value = (int) test.get("F");
		assertEquals(value, 10);
		assertEquals(6, test.size());
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

	@Test
	public void sizeTest1() {
		BST test = new BST<>();
		test.put("C", 3);
		test.put("A", 1);
		test.put("B", 2);
		test.put("F", 6);
		test.put("X", 24);
		test.put("Z", 26);
		test.put("J", 6);
		test.put("K", 6);
		test.put("L", 6);
		test.put("M", 6);
		test.put("N", 6);

		int size = test.size();
		assertEquals(11, size);
	}

	@Test
	public void sizeTest2() {
		BST test = new BST<>();
	
		int size = test.size();
		assertEquals(0, size);
	}

	@Test
	public void isEmptyTest1() {
		BST test = new BST<>();
		test.put("C", 3);
		test.put("A", 1);
		test.put("B", 2);
		test.put("F", 6);
		test.put("X", 24);
		test.put("Z", 26);
		test.put("J", 6);
		test.put("K", 6);
		test.put("L", 6);
		test.put("M", 6);
		test.put("N", 6);

		boolean isEmpty = test.isEmpty();
		assertFalse(isEmpty);
	}

	@Test
	public void isEmptyTest2() {
		BST test = new BST<>();
	
		boolean isEmpty = test.isEmpty();
		assertTrue(isEmpty);
	}

	@Test
	public void containsKeyTest1() {
		BST test = new BST<>();
		test.put("C", 3);
		test.put("A", 1);
		test.put("B", 2);
		test.put("F", 6);
		test.put("X", 24);
		test.put("Z", 26);
		test.put("J", 6);
		test.put("K", 6);
		test.put("L", 6);
		test.put("M", 6);
		test.put("N", 6);

		boolean contains = test.containsKey("N");
		assertTrue(contains);
	}

	@Test
	public void containsKeyTest2() {
		BST test = new BST<>();
	
		
		boolean contains = test.containsKey("A");
		assertFalse(contains);
	}

	@Test
	public void keysTest1() {
		BST test = new BST<>();
		test.put("C", 3);
		test.put("A", 1);
		test.put("B", 2);
		test.put("F", 6);
		test.put("X", 24);
		test.put("Z", 26);

		
		int size = test.size();
		assertEquals(6, size);
		List<String> ans = test.keys();
		List<String> expected = Arrays.asList("A", "B", "C","F","X","Z");
		assertEquals(expected, ans);
	}

	

	@Test
	public void keysTest2() {
		BST test = new BST<>();
		test.put("F", 3);
		test.put("E", 1);
		test.put("D", 2);
		test.put("C", 6);
		test.put("B", 24);
		test.put("A", 26);

		
		int size = test.size();
		assertEquals(6, size);
		List<String> ans = test.keys();
		List<String> expected = Arrays.asList("A", "B", "C", "D", "E", "F");
		assertEquals(expected, ans);
	}

}
