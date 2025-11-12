package BDD;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="src\\test\\resources\\Feature Files\\DemoBlaze.feature",
		glue= {"BDD"},
		plugin= {"json:target/Cucumber.json",
		         "html:target/Cucumber-report.html",
		         "junit:target/Cucumber-report2/Cucumber.xml"})


public class DemoBlaze_Runner 
{
	

}
