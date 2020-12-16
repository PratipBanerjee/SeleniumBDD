package stepdefinations;

import base.TestBase;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pageObjects.Homepage;
import pageObjects.Intermediatepage;

public class OrderProductStepDefinition {

    private TestBase testBase;

    public OrderProductStepDefinition(TestBase testBase)
    {
        this.testBase=testBase;
    }

    @Then("Verify Product is added to Cart")
    public void VerifyCart()
    {
        try
        {
            testBase.commonClick(Homepage.initiate(testBase.driver).CartLink);
            testBase.commonWaitForElement(Intermediatepage.initiate(testBase.driver).DeleteLink);
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }

    }

    @And("Place the Order")
    public void PlaceOrder()
    {
        try
        {
            testBase.commonClick(Intermediatepage.initiate(testBase.driver).PlaceOrderButton);
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Then("Enter the Order Details and Confirm the Order")
    public void EnterOrderDetails()
    {
        try
        {
            testBase.commonSendTestData(Intermediatepage.initiate(testBase.driver).Name, "TestName");
            testBase.commonSendTestData(Intermediatepage.initiate(testBase.driver).Country, "TestCountry");
            testBase.commonSendTestData(Intermediatepage.initiate(testBase.driver).City, "TestCity");
            testBase.commonSendTestData(Intermediatepage.initiate(testBase.driver).CreditCard, "4111111111111");
            testBase.commonSendTestData(Intermediatepage.initiate(testBase.driver).Month, "12");
            testBase.commonSendTestData(Intermediatepage.initiate(testBase.driver).Year, "2020");
            testBase.commonClick(Intermediatepage.initiate(testBase.driver).PurchaseButton);
            testBase.pause();
            testBase.commonClick(Intermediatepage.initiate(testBase.driver).OKButton);
            testBase.commonWaitForElement(Homepage.initiate(testBase.driver).PhoneTab);
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }
}
