package demo;

import org.testng.annotations.Test;

public class TestNGGroupsDemo {
	
	@Test(groups= {"sanity"})
	public void test1() {
		System.out.println("this is test 1");
	}
	
	@Test(groups= {"sanity","smoke"})
	public void test2() {
		System.out.println("this is test 2");
	}
	
	@Test(groups= {"regression"})
	public void test3() {
		System.out.println("this is test 3");
	}
	
	
}
