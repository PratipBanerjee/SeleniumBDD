package runner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src\\test\\resources\\Features",
        glue = "stepdefinations",
        plugin = {"listener.ReportListener"},
        monochrome = true
        
)


public class TestRunner extends AbstractTestNGCucumberTests {
}
