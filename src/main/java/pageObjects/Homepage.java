package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


public class Homepage {

    @FindBy(id = "login2")
    public WebElement LoginLink;

    @FindBy(id = "logout2")
    public WebElement LogoutLink;

    @FindBy(id = "loginusername")
    public WebElement Username;

    @FindBy(id = "loginpassword")
    public WebElement Password;

    @FindBy(xpath = "//button[contains(text(), 'Log in')]")
    public WebElement LoginButton;

    @FindBy(id = "cartur")
    public WebElement CartLink;

    @FindBy(xpath = "//a[@class='hrefch']")
    public List<WebElement> ProductList;

    @FindBy(xpath = "//a[contains(text(), 'Phones')]")
    public WebElement PhoneTab;

    public static Homepage initiate(WebDriver driver)
    {
        return PageFactory.initElements(driver, Homepage.class);
    }

}
