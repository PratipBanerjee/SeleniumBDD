package stepdefinations;

import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import cucumber.runtime.PendingException;
import org.openqa.selenium.By;
import utilities.ReadData;

import java.io.IOException;

public class HomePage extends BaseClass {

    @When("^User enetered username and password clicked on Login$")
    public void User_enetered_username_and_password_clicked_on_Login() throws Throwable {
        // Express the Regexp above with the code you wish you had

        try
        {
            BaseClass.WaitForElement(ReadData.ReadObjectRepository("Email"));
            driver.findElement(By.xpath(ReadData.ReadObjectRepository("Email"))).sendKeys();
            driver.findElement(By.xpath(ReadData.ReadObjectRepository("Password"))).sendKeys();
            driver.findElement(By.xpath(ReadData.ReadObjectRepository("LoginButton"))).click();

        }
        catch(IOException e)
        {
            e.printStackTrace();
        }



        throw new PendingException();
    }

    @Then("^user's home page displayed$")
    public void user_s_home_page_displayed() throws Throwable {
        // Express the Regexp above with the code you wish you had
        BaseClass.WaitForElement(ReadData.ReadObjectRepository("LoginValidation"));
        throw new PendingException();
    }




}
