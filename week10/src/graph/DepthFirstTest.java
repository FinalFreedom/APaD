package graph;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class DepthFirstTest {

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
		DepthFirst<Integer> test = new DepthFirst<Integer>();
		for(int i=0;i<5;i++)
		{
			test.add(i);
		}
		test.add(0,1);
		test.add(1,2);
		test.add(3,2);
		test.add(3,0);
		test.add(4,3);
		System.out.println(test.getNodes().size());
		System.out.println(test.traverse());
	}

}
