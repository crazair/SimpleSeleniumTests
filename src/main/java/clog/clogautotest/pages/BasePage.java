package clog.clogautotest.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

/**
 * @author anosv
 */
public class BasePage {

    public static final Logger log = Logger.getRootLogger();
    public WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver getDriver() {
        return this.driver;
    }
}
