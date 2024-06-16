package factory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;
//import java.util.logging.LogManager;
//import java.util.logging.Logger;

public class BaseClass {

    private static WebDriver driver;
    public static Properties p;
    public static Logger logger;


// Reusable components and Driver Initialization

    public static WebDriver initializeBrowser() throws IOException {

        p = getProperties();
        getLogger();

        String execution_env = p.getProperty("execution_env").toLowerCase();
        String os = p.getProperty("os").toLowerCase();
        String browser = p.getProperty("browser").toLowerCase();

        if(execution_env.equalsIgnoreCase("remote")){

            DesiredCapabilities capabilities = new DesiredCapabilities();

            if(os.equals("windows")){

                capabilities.setPlatform(Platform.WINDOWS);
            }
            else if(os.equals("mac")){

                capabilities.setPlatform(Platform.MAC);
            }
            else if(os.equals("linux")){

                capabilities.setPlatform(Platform.LINUX);
            }
            else{

                System.out.println("No matching OS");
                return driver=null;
            }

            switch(browser){

                case "chrome":
                    capabilities.setBrowserName("chrome");
                    break;

                case "edge":
                    capabilities.setBrowserName("MicrosoftEdge");
                    break;

                case "firefox":
                    capabilities.setBrowserName("firefox");
                    break;

                default:
                    System.out.println("No matching browser");
                    return null;
            }

            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);

        }

        else if(execution_env.equals("local")){

            switch (browser) {
                case "chrome" -> driver = new ChromeDriver();
                case "edge" -> driver = new EdgeDriver();
                case "firefox" -> driver = new FirefoxDriver();
                default -> {
                    System.out.println("No matching browser");
                    return null;
                }
            }

        }

        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        return driver;

    }

    public static WebDriver getDriver(){

        return driver;
    }

    public static Properties getProperties() throws IOException {

        FileReader file = new FileReader(".\\src\\test\\resources\\config.properties");
        p = new Properties();
        p.load(file);
        return p;
    }

    public static Logger getLogger(){

        logger = LogManager.getLogger();
        return logger;

    }


}
