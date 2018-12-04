package stepDefinition;

import com.learning.base.TestBase;

import cucumber.api.java.en.Given;

public class Test4 extends TestBase {
	
	@Given("^This is a blank test1$")
	public void This_is_on_Blank_Page1() throws Throwable {
		System.out.println("This is a blank test1");
	}
	
	@Given("^This is a blank test2$")
	public void This_is_on_Blank_Page2() throws Throwable {
		System.out.println("This is a blank test1");
	}
	
	
}
