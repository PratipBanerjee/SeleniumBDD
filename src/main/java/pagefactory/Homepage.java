package pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class Homepage {

    @FindBy(xpath = "//a[contains(text(), 'Sign in')]")
    public WebElement SignInLink;

    @FindBy(id = "email")
    public WebElement UsernameField;

    @FindBy(id = "passwd")
    public WebElement PasswordField;

    @FindBy(id = "SubmitLogin")
    public WebElement LoginButton;

    @FindBy(xpath = "//h1[contains(text(), 'My account')]")
    public WebElement LoginSuccessfullMessage;

}
