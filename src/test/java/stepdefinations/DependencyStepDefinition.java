package stepdefinations;

import base.TestBase;
import dataProvider.PropetiesReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class DependencyStepDefinition {


    TestBase testBase;

    public DependencyStepDefinition(TestBase testBase)
    {
        this.testBase=testBase;
    }

    @Before
    public void createSession()
    {
        try
        {
            String projectdirectory = System.getProperty("user.dir");
            String baseurl = PropetiesReader.ReadEnvironmentParameters("URL");
            String headlesscheck = PropetiesReader.ReadEnvironmentParameters("HEADLESS");
            if(headlesscheck.equalsIgnoreCase("yes"))
            {
                System.setProperty("webdriver.chrome.driver", projectdirectory + "\\browserdependencies\\chromedriver.exe");
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--ignore-certificate-errors");
                options.addArguments("headless");
                options.addArguments("--diasbale-gpu");
                options.addArguments("--window-size=1920,1000");
                testBase.driver = new ChromeDriver(options);
                testBase.driver.manage().window().maximize();
                testBase.driver.get(baseurl);
                testBase.driver.manage().deleteAllCookies();
                testBase.driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
            }
            else
            {
                System.setProperty("webdriver.chrome.driver", projectdirectory + "\\browserdependencies\\chromedriver.exe");
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--ignore-certificate-errors");
                options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                testBase.driver = new ChromeDriver(options);
                testBase.driver.manage().window().maximize();
                testBase.driver.get(baseurl);
                testBase.driver.manage().deleteAllCookies();
                testBase.driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

    }

    @After
    public void endSession()
    {
        testBase.driver.quit();
    }

    @Before
    public String scenarioName(Scenario scenario)
    {
        testBase.scenarioName = scenario.getName();
        return testBase.scenarioName;
    }
}
