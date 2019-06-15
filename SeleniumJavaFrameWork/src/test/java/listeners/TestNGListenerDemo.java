package listeners;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

//@Listeners(listeners.TestNGListeners.class)  use testng1.xml to manage for multiple class
public class TestNGListenerDemo {

	@Test
	public void test1() {
		System.out.println("test case 1");
	}
}
