package hooks;

import factory.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.Properties;

public class Hooks {

    WebDriver driver;
    Properties p;

    @Before
    public void setup() throws IOException {

        driver = BaseClass.initializeBrowser();
        assert driver != null;

        p = BaseClass.getProperties();
        driver.get(p.getProperty("appURL"));
        driver.manage().window().maximize();

    }

    @After
    public void closeBrowser(Scenario scenario){

        driver.quit();
    }



}
