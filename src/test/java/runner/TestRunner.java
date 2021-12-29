package runner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src\\test\\Resources\\Features",
        glue = "stepdefinations"
)


public class TestRunner extends AbstractTestNGCucumberTests {
}
