package stepDefinition;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Test2 {
	
	
	
	@Before
    public void beforeScenario(){
		System.out.println("Launch FF");
        System.out.println("This will run before the Scenario");
    }	
	
	public static void disableWarning() {
	    System.err.close();
	    System.setErr(System.out);
	}
	
	@After
    public void afterScenario(){
        System.out.println("This will run after the Scenario");
    }

	
	@Given("^this is the first step$")
	public void This_Is_The_First_Step() throws InterruptedException,Throwable{
		System.out.println("This is the first step");
		Thread.sleep(4000);
	}
	
	@When("^this is the second step$")
	public void This_Is_The_Second_Step() throws InterruptedException,Throwable{
		System.out.println("This is the second step");
		Thread.sleep(4000);
	}
	
	@Then("^this is the third step$")
	public void This_Is_The_Third_Step() throws InterruptedException,Throwable{
		System.out.println("This is the third step");
		Thread.sleep(4000);
	}
	

}