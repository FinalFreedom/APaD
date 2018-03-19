package binaryTree;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class BinaryTreeTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSize() {
		BinaryTree<Integer> testTree = new BinaryTree<>();
		testTree.insert(0);
		testTree.insert(1);
		testTree.insert(2);
		testTree.insert(3);
		testTree.insert(-1);
		testTree.insert(-2);
		testTree.insert(-3);
		testTree.insert(-4);
		assertEquals(8, testTree.getSize());
	}
	
	@Test
	public void testLeftNode() {
		BinaryTree<Integer> testTree = new BinaryTree<>();
		testTree.insert(0);
		testTree.insert(1);
		testTree.insert(2);
		testTree.insert(3);
		testTree.insert(-1);
		testTree.insert(-2);
		testTree.insert(-3);
		testTree.insert(-4);
		assertEquals(new Integer(-1), testTree.left().getValue());
	}
	
	@Test
	public void test2ndRightNode() {
		BinaryTree<Integer> testTree = new BinaryTree<>();
		testTree.insert(0);
		testTree.insert(1);
		testTree.insert(2);
		testTree.insert(3);
		testTree.insert(-1);
		testTree.insert(-2);
		testTree.insert(-3);
		testTree.insert(-4);
		assertEquals(new Integer(2), testTree.right().right().getValue());
	}

}
