package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Intermediatepage {

    @FindBy(xpath = "//a[contains(text(), 'Add to cart')]")
    public WebElement AddToCartButton;

    @FindBy(xpath = "//button[contains(text(), 'Place Order')]")
    public WebElement PlaceOrderButton;

    @FindBy(xpath = "//a[contains(text(), 'Delete')]")
    public WebElement DeleteLink;

    @FindBy(id = "name")
    public WebElement Name;

    @FindBy(id = "country")
    public WebElement Country;

    @FindBy(id = "city")
    public WebElement City;

    @FindBy(id = "card")
    public WebElement CreditCard;

    @FindBy(id = "month")
    public WebElement Month;

    @FindBy(id = "year")
    public WebElement Year;

    @FindBy(xpath = "//button[contains(text(), 'Purchase')]")
    public WebElement PurchaseButton;

    @FindBy(xpath = "//button[contains(text(), 'OK')]")
    public WebElement OKButton;

    public static Intermediatepage initiate(WebDriver driver)
    {
        return PageFactory.initElements(driver, Intermediatepage.class);
    }
}
