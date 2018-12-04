package CucumberTest;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = ("/Users/ethirajp/eclipse-workspace1/NewProject/Feature/Login_TestFeature")
		,glue={"stepDefinition"}
		,monochrome = true
		,format= {"pretty"}
		)

public class TestRunner {

}