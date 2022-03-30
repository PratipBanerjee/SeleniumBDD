package stepdefinations;

import framework.controllers.FileReaderController;
import framework.dependencyinjection.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.restassured.RestAssured;

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
            RestAssured.baseURI = fileReaderController.getPropertiesReader().getBaseURL();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

    }
}
