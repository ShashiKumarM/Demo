package qcom.eosl.automation.utility;

import static qcom.eosl.automation.utility.AutomationConstants.DRIVER_URL_NAME;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Driver {
    private static WebDriver driver;

    /**
     * Sets Up Browser Instance and launches it
     * 
     * @throws Exception
     */
    public static synchronized WebDriver setUpManagerLogin() throws Exception {
        String urlName = DRIVER_URL_NAME;
        DesiredCapabilities cap = DesiredCapabilities.firefox();
        cap.setPlatform(Platform.ANY);
        URL url = new URL("http://tomorrowland-jenkins.qualcomm.com:4444/wd/hub");
        WebDriver driver = new RemoteWebDriver(url, cap);
        driver.get(urlName);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
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
