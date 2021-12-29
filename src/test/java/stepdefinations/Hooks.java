package stepdefinations;

import framework.controllers.FileReaderController;
import framework.dependencyinjection.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    private TestContext testContext;

    private FileReaderController fileReaderController;
    
    public Hooks(TestContext testContext)
    {
        this.testContext=testContext;
        fileReaderController = testContext.getFileReaderController();
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
