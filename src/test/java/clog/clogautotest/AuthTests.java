package clog.clogautotest;

import clog.clogautotest.pages.LoginPage;
import clog.clogautotest.pages.MainPage;
import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class AuthTests extends BaseTest {

    private LoginPage loginPage = new LoginPage(driver);
    private MainPage mainPage = new MainPage(driver);

    @Test
    public void testAuthWithEmptyPass() {
        loginPage.auth("XXXXXXXXX", "");
        assertTrue(loginPage.isDisplayedErrorBlock2());
        assertThat(loginPage.getTextFromErrorBlock2(),
                containsString("Пожалуйста, заполните пароль."));
    }

    @Test
    public void testAuthWithIncorrectLoginPass() {
        loginPage.auth("XXXXXXXXX", "XXXXXXXXX");
        assertThat(driver.getCurrentUrl(),
                containsString("act=error"));
        assertTrue(loginPage.isDisplayedErrorBlock3());
        assertThat(loginPage.getTextFromErrorBlock3(),
                containsString("Логин или пароль введены неверно."));
    }

    @Test
    public void testAuthWithIncorrectPassAndCorrectLogin() {
        loginPage.auth(properties.getProperty("demoLogin"), "XXXXXXXXX");
        assertThat(driver.getCurrentUrl(),
                containsString("act=error"));
        assertTrue(loginPage.isDisplayedErrorBlock3());
        assertThat(loginPage.getTextFromErrorBlock3(),
                containsString("Логин или пароль введены неверно."));
    }

    @Test
    public void testAuthWithIncorrectLoginAndCorrectPass() {
        loginPage.auth("XXXXXXXXX", properties.getProperty("demoPassword"));
        assertThat(driver.getCurrentUrl(),
                containsString("act=error"));
        assertTrue(loginPage.isDisplayedErrorBlock3());
        assertThat(loginPage.getTextFromErrorBlock3(),
                containsString("Логин или пароль введены неверно."));
    }

    @Test
    public void testCorecctAuthOper() {
        String login = properties.getProperty("demoLogin");
        loginPage.auth(login, properties.getProperty("demoPassword"));
        assertThat(mainPage.getHeaderText(),
                containsString(login));
        assertTrue(mainPage.isOperBlockEnabled());
        mainPage.exit();
        assertTrue(loginPage.isLoginBlockEnable());
    }

    @Test
    public void testCorecctAuthManager() {
        String login = properties.getProperty("adminLogin");
        loginPage.auth(login, properties.getProperty("adminPassword"));
        assertThat(mainPage.getHeaderText(), containsString(login));
        assertTrue(mainPage.isManagerBlockEnabled());
        mainPage.exit();
        assertTrue(loginPage.isLoginBlockEnable());
    }
}
