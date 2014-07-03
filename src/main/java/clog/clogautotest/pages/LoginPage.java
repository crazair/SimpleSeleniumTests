package clog.clogautotest.pages;

import clog.clogautotest.blocks.LoginBlock;
import static clog.clogautotest.pages.BasePage.log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;

/**
 * @author anosv
 */
public class LoginPage extends BasePage {

    private LoginBlock loginBlock = new LoginBlock();

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(new HtmlElementDecorator(driver), this);
        this.driver = driver;
        log.info("Init login page");
    }

    public void auth(String login, String password) {
        log.info("auth with login: " + login + " and pass: " + password);
        loginBlock.enterLogin(login);
        loginBlock.enterPassword(password);
        loginBlock.enterLoginButton();
    }

    public boolean isLoginBlockEnable() {
        return loginBlock.isEnabled();
    }

    public boolean isDisplayedErrorBlock1() {
        return loginBlock.isDisplayedErrorBlock1();
    }

    public String getTextFromErrorBlock1() {
        log.info("getTextFromErrorBlock1: " + loginBlock.getTextFromErrorBlock1());
        return loginBlock.getTextFromErrorBlock1();
    }

    public boolean isDisplayedErrorBlock2() {
        return loginBlock.isDisplayedErrorBlock2();
    }

    public String getTextFromErrorBlock2() {
        log.info("getTextFromErrorBlock2: " + loginBlock.getTextFromErrorBlock2());
        return loginBlock.getTextFromErrorBlock2();
    }

    public boolean isDisplayedErrorBlock3() {
        return loginBlock.isDisplayedErrorBlock3();
    }

    public String getTextFromErrorBlock3() {
        log.info("getTextFromErrorBlock3: " + loginBlock.getTextFromErrorBlock3());
        return loginBlock.getTextFromErrorBlock3();
    }
}
