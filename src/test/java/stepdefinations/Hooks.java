package stepdefinations;

import framework.controllers.FileReaderController;
import framework.dataprovider.PropertiesReader;
import framework.dependencyinjection.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Hooks {

    private TestContext testContext;

    private FileReaderController fileReaderController;

    private List<HashMap<String, String>> TestData;
    
    public Hooks(TestContext testContext)
    {
        this.testContext=testContext;
        fileReaderController = testContext.getFileReaderController();
        TestData = testContext.getFileReaderController().getExcelReader().GetTestData("TestData");
    }

    @Before
    public void createSession()
    {
        try
        {
            testContext.getWebDriverController().getDriver().get(fileReaderController.getPropertiesReader().getApplicationURL());
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

    }

    @After
    public void endSession()
    {
        testContext.getWebDriverController().quitDriver();
    }
}
