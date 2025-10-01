package application;
import framework.Before;
import framework.Inject;
import framework.Test;
import framework.TestClass;
//import static org.junit.Assert.assertEquals;
import framework.Asserts;

@TestClass
public class MyTest {
	
	@Inject
	Calculator calculator;

	@Before
	public void init() {
		System.out.println("perform initialization");
	}

	@Test
	public void testMethod1() {
		System.out.println("perform testMethod1");
		framework.Asserts.assertEquals(calculator.add(3), 3);
		framework.Asserts.assertEquals(calculator.add(6), 9);
	}

	@Test
	public void testMethod2() {
		System.out.println("perform testMethod2");
		framework.Asserts.assertEquals(calculator.add(3), 3);
		framework.Asserts.assertEquals(calculator.subtract(6), -1);
	}
}
