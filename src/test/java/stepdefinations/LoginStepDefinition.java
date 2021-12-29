package stepdefinations;

import framework.controllers.PageFactoryController;
import framework.dataprovider.PropertiesReader;
import framework.dependencyinjection.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pagefactory.Homepage;
import java.util.HashMap;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

public class LoginStepDefinition {

    private TestContext testContext;

    private PageFactoryController pageFactory;

    private List<HashMap<String, String>> TestData;


    public LoginStepDefinition(TestContext testContext)
    {
        this.testContext=testContext;
        pageFactory = testContext.getPageFactoryController();
        TestData = testContext.getFileReaderController().getExcelReader().GetTestData("TestData");
    }

    @Given("Login as a User \"(.*)\"$")
    public void LoginAsUser(String testData)
    {
        try
        {
            int index = Integer.parseInt(testData) - 1;
            
            testContext.getWebElementUtil().commonClick(pageFactory.getHomepage().SignInLink);
            testContext.getWebElementUtil().commonWaitForElement(pageFactory.getHomepage().UsernameField);
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getHomepage().UsernameField, TestData.get(index).get("Username"));
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getHomepage().PasswordField, TestData.get(index).get("Password"));
            testContext.getWebElementUtil().commonClick(pageFactory.getHomepage().LoginButton);
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }

    }

    @Then("Validate the presence of Login Successfull Message")
    public void LogoutFromApplication()
    {
        try
        {
            testContext.getWebElementUtil().commonWaitForElement(pageFactory.getHomepage().LoginSuccessfullMessage);
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }

    }




}
