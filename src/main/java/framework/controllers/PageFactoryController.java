package framework.controllers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pagefactory.Homepage;

public class PageFactoryController {

    private WebDriver driver;

    public PageFactoryController(WebDriver driver) {

        this.driver=driver;
    }

    public Homepage getHomepage() {

        return PageFactory.initElements(driver, Homepage.class);
    }
    
}
