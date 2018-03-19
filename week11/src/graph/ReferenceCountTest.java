package graph;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ReferenceCountTest {

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
	public void test() throws GraphError {
		ReferenceCount<Integer> test = new ReferenceCount<Integer>();
		//Make a new graph with nodes of value 0-9
		for(int i = 0;i<10;i++)
		{
			test.add(new Integer(i));
		}
		//Add edges as appropriate
		test.add(1, 5);
		test.add(0, 5);
		test.add(1, 7);
		test.add(3, 2);
		test.add(3, 4);
		test.add(3, 8);
		test.add(6, 0);
		test.add(6, 1);
		test.add(6, 2);
		test.add(8, 4);
		test.add(8, 7);
		test.add(9, 4);
		System.out.println(test.getSort().toString());
		//assertEquals(new String("[3, 6, 0, 1, 2, 5, 8, 7, 9, 4]"),test.getSort().toString());
	}

}
