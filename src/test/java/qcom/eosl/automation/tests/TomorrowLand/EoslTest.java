package qcom.eosl.automation.tests.TomorrowLand;

import static qcom.eosl.automation.utility.AutomationConstants.PASSWORD_A;
import static qcom.eosl.automation.utility.AutomationConstants.USERNAME_A;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pages.EOSLPage;
import pages.LoginPage;
import qcom.eosl.automation.tests.listeners.TestListener;
import qcom.eosl.automation.utility.Driver;

@Listeners({ TestListener.class })
public class EoslTest {
    private WebDriver driver;
    private LoginPage objLoginPage;
    private EOSLPage objEoslPage;

    @BeforeClass
    public void beforeMethod() throws Exception {
        driver = Driver.setUpManagerLogin();
        objLoginPage = new LoginPage(driver);
        objEoslPage = objLoginPage.logIntoTomorrowLand(USERNAME_A, PASSWORD_A);
    }

    @Test
    public void validateSiteLocationOfHost() throws IOException {
        objEoslPage.searchHost("lasher.qualcomm.com");
        Assert.assertEquals(objEoslPage.getDataFromGrid("lasher.qualcomm.com", "site"), "sandiego",
                "Mismatch in site.");
    }

    @AfterClass
    public void afterMethod() {
        driver.quit();
    }
}
