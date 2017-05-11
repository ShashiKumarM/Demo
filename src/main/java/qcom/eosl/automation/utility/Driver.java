package qcom.eosl.automation.utility;

import static qcom.eosl.automation.utility.AutomationConstants.DRIVER_URL_NAME;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;

public class Driver {
    private static WebDriver driver;

    /**
     * Sets Up Browser Instance and launches it
     * 
     * @throws Exception
     */
    public static synchronized WebDriver setUpManagerLogin() throws Exception {
        String urlName = DRIVER_URL_NAME;
        // ReadObjects object = new ReadObjects();
        // driver = object.getDriver();
        WebDriver driver = new FirefoxDriver();
        // String appURL = object.getPropertyValues();
        try {
            // driver = BrowserConfiguration.getBrowser();
            driver.get(urlName);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        } catch (Exception e) {
            Reporter.log("Exception occurred in setUpManagerLogin" + e);
        }
        return driver;
    }

    /**
     * Closes Browser
     */
    public static void tearDown() {
        driver.quit();
    }

    public static WebDriver getDriverInstance() {
        return driver;
    }
}
