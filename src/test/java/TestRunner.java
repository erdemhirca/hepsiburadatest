
import com.gargoylesoftware.htmlunit.BrowserVersion;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.util.concurrent.TimeUnit;

import com.thoughtworks.gauge.AfterScenario;
import com.thoughtworks.gauge.BeforeScenario;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.testng.ITestResult;
import org.openqa.selenium.OutputType;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
public class TestRunner {
    String url = "https://www.hepsiburada.com/";
    static WebDriver driver;

    @BeforeScenario
    @Parameters("browser")
       public void beforeTest(String browser) {
            if(browser.equalsIgnoreCase("chrome"))
            {
                System.out.println("chrome");
                System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
                driver=new ChromeDriver();
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                driver.manage().window().maximize();
            }
            else if (browser.equalsIgnoreCase("firefox"))
            {
                System.out.println("firefox");
                System.setProperty("webdriver.gecko.driver", "/usr/local/bin/geckodriver");
                driver=new FirefoxDriver();
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                driver.manage().window().maximize();
            }
            else {
                System.out.println ("HTMLUNIT");
                driver=new HtmlUnitDriver(BrowserVersion.FIREFOX_2);
            }
    }
    @AfterScenario
    public void screenShot(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            try {

                TakesScreenshot screenshot = (TakesScreenshot) driver;
                File src = screenshot.getScreenshotAs(OutputType.FILE);
                FileUtils.copyFile(src, new File("/Users/erdemhirca/IdeaProjects/hepsiburada/reports" + result.getName() + ".png"));
                System.out.println("Successfully captured a screenshot");
            } catch (Exception e) {
                System.out.println("Exception while taking screenshot " + e.getMessage());
            }
            driver.quit();
        }

        System.out.println("============ Senaryo sonu ============");
    }
}