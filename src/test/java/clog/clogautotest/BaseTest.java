package clog.clogautotest;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.yandex.qatools.allure.annotations.Attach;
import ru.yandex.qatools.allure.model.AttachmentType;

/**
 *
 * @author anosv
 */
public class BaseTest {

    public static WebDriver driver;
    public static Properties properties = new Properties();
    static final Logger log = Logger.getRootLogger();

    @BeforeClass
    public static void setUp() throws IOException {
        //driver = new HtmlUnitDriver(true);
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        properties.load(new FileReader("clog.properties"));
        System.out.println("URL: " + properties.getProperty("url"));
        driver.get(properties.getProperty("url"));
    }

    @AfterClass
    public static void killWebDriver() {
        driver.quit();
    }
    @Rule
    public TestRule screenshotRule = new TestWatcher() {
        @Override
        protected void failed(Throwable e, Description description) {
            log.info("FAIL TEST: " + description);
            captureScreenshot();
            makeScreenshot();
        }

        @Override
        protected void starting(Description description) {
            log.info("Starting test " + description);
        }
        
        
    };

    private void captureScreenshot() {
        try {
            File screenshot = ((TakesScreenshot) driver)
                    .getScreenshotAs(OutputType.FILE);
            File f = new File("screenshots/" + screenshot.getName());

            FileUtils.copyFile(screenshot, f);
            log.info("Screenshot: " + f.getAbsolutePath());
        } catch (IOException e) {
            log.error("BaseTest captureScreenshot IOException: ", e);
        }
    }

    @Attach(type = AttachmentType.PNG)
    public File makeScreenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
    }
}
