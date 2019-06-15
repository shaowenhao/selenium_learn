 package demo;

import org.testng.annotations.Test;

public class TestNGRetryFailedDemo {
	@Test
	public void test1() {
		System.out.println("I am inside Test1");
	}
	
	@Test(retryAnalyzer =  listeners.RetryAnalyzer.class)
	public void test2() {
		System.out.println("I am inside Test2");
		int i = 1 / 0;
	}
	
	
	@Test
	public void test3() {
		System.out.println("I am inside Test3");
	}
}
