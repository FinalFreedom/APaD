package counter;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CountTest {
	
	private ThreadSet<Counter> countSet;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		double random = Math.random();
		Counter.traceOn();
		Counter.setDelay(random);
		System.out.println(random);		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		countSet = new ThreadHashSet<Counter>();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test_5_10_and_5_0() throws InterruptedException {
		countSet.add(new Counter(5,10));
		countSet.add(new Counter(5,0));
		countSet.runSet();
	}
	
	@Test
	public void test0_10_and_0_10() throws InterruptedException
	{
		countSet.add(new Counter(0,10));
		countSet.add(new Counter(10,0));
		countSet.runSet();
	}

}
