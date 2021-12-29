package framework.dependencyinjection;

import framework.controllers.FileReaderController;
import framework.controllers.PageFactoryController;
import framework.controllers.WebDriverController;
import framework.webelementutility.WebElementUtil;

public class TestContext {

    private WebDriverController webDriverController;

    private FileReaderController fileReaderController;

    private PageFactoryController pageFactoryController;

    private WebElementUtil webElementUtil;

    public TestContext() {

        webDriverController = new WebDriverController();
        fileReaderController = new FileReaderController();
        pageFactoryController = new PageFactoryController(webDriverController.getDriver());
        webElementUtil = new WebElementUtil(webDriverController.getDriver());
    }

    public WebDriverController getWebDriverController() {

        return webDriverController;
    }

    public FileReaderController getFileReaderController() {

        return fileReaderController;
    }

    public PageFactoryController getPageFactoryController() {

        return pageFactoryController;
    }

    public WebElementUtil getWebElementUtil() {

        return webElementUtil;
    }
    
}
