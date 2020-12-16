package runner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src\\test\\Resources\\Features\\OrderViaoLaptop.feature",
        glue = "stepdefinations"
)


public class TestRunnerViaoLaptop extends AbstractTestNGCucumberTests {
}
