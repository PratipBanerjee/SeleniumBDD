package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class TestBase {

    public WebDriver driver;

    public String scenarioName;

    public void commonWaitForElement(WebElement element)
    {
        try
        {
            WebDriverWait wait = new WebDriverWait(driver, 60);
            wait.until(ExpectedConditions.elementToBeClickable(element));
        }
        catch(org.openqa.selenium.StaleElementReferenceException exception)
        {
            WebDriverWait wait = new WebDriverWait(driver, 60);
            wait.until(ExpectedConditions.elementToBeClickable(element));
        }
    }

    public void commonClick(WebElement element)
    {
        commonWaitForElement(element);
        element.click();
    }

    public void commonSendTestData(WebElement element, String testdata)
    {
        commonWaitForElement(element);
        element.sendKeys(testdata);
    }

    public void pause()
    {
        try
        {
            TimeUnit.MILLISECONDS.sleep(3000);
        }
        catch(InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    public void AcceptAlert()
    {
        driver.switchTo().alert().accept();
    }
}
