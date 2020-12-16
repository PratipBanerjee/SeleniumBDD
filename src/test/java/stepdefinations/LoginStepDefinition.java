package stepdefinations;

import base.TestBase;
import dataProvider.PropetiesReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import pageObjects.Homepage;
import pageObjects.Intermediatepage;

public class LoginStepDefinition {

    private TestBase testBase;

    public LoginStepDefinition(TestBase testBase)
    {
        this.testBase=testBase;
    }

    @Given("Login as a User \"(.*)\"$")
    public void LoginAsUser(String username)
    {
        try
        {
            testBase.commonClick(Homepage.initiate(testBase.driver).LoginLink);
            testBase.commonSendTestData(Homepage.initiate(testBase.driver).Username, username);
            testBase.commonSendTestData(Homepage.initiate(testBase.driver).Password,
                    PropetiesReader.ReadEnvironmentParameters("Password"));
            testBase.commonClick(Homepage.initiate(testBase.driver).LoginButton);
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }

    }

    @And("Select the Product \"(.*)\"$")
    public void SelectProduct(String productname)
    {
        try
        {
            testBase.commonWaitForElement(Homepage.initiate(testBase.driver).PhoneTab);
            testBase.pause();
            for(WebElement product : Homepage.initiate(testBase.driver).ProductList)
            {
                if(product.getText().equalsIgnoreCase(productname))
                {
                    product.click();
                    break;
                }
            }
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }

    }

    @And("Add product to cart")
    public void AddToCart()
    {
        try
        {
            testBase.commonClick(Intermediatepage.initiate(testBase.driver).AddToCartButton);
            testBase.pause();
            testBase.AcceptAlert();
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }

    }

    @And("Logout from application")
    public void LogoutFromApplication()
    {
        try
        {
            testBase.commonClick(Homepage.initiate(testBase.driver).LogoutLink);
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }

    }




}
