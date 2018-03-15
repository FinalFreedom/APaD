package graph;

import static org.junit.Assert.*;

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
		ReferenceCount test = new ReferenceCount();
		for(int i = 0;i<10;i++)
		{
			test.add(i);
		}
		test.add(0, 7);
		test.add(1, 5);
		test.add(2, 7);
		test.add(3, 6);
		test.add(4, 5);
		test.add(5, 4);
		test.add(6, 3);
		test.add(7, 2);
		test.add(8, 1);
		test.add(8, 0);
		//System.out.println(test.getNoOfEdges());
		//System.out.println(test.getNoOfNodes());
		//System.out.println(test.getSort());
	}

}
