package qcom.eosl.automation.tests.TomorrowLand;

import java.io.IOException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class GridTest {

    @Test
    public void validateSiteLocationOfHost() throws IOException {
        String nodeUrl = "http://tmlselenium.na.qualcomm.com:4444/wd/hub";
        FirefoxProfile profile = new FirefoxProfile();
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        capabilities.setBrowserName("firefox");
        capabilities.setPlatform(Platform.ANY);
        capabilities.setCapability(FirefoxDriver.PROFILE, profile);
        WebDriver driver = new RemoteWebDriver(new URL(nodeUrl), capabilities);
        driver.get("https://www.google.co.in");
    }
}
