package common;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

import static common.Config.PLATFORM_AND_BROWSER;
import static constants.Constants.TimeoutVariable.IMPLICIT_WAIT;

public class CommonActions {
    public static WebDriver createDriver(){
        String currentWorkingDirectory;
        currentWorkingDirectory = System.getProperty("user.dir");
        WebDriver driver = null;

        switch (PLATFORM_AND_BROWSER) {
            case ("mac_chrome"):
                System.setProperty("webdriver.chrome.driver", currentWorkingDirectory + "/src/main/resources/drivers/chromedriver");
                driver = new ChromeDriver();
                break;
            default:
                Assert.fail("Incorrect platform or browser name: " + PLATFORM_AND_BROWSER);
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICIT_WAIT));
        return driver;
    }
}
