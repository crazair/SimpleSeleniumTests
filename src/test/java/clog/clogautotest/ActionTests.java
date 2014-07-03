package clog.clogautotest;

import clog.clogautotest.pages.ActionsPage;
import clog.clogautotest.pages.InOutActonPage;
import clog.clogautotest.pages.LoginPage;
import clog.clogautotest.pages.MainPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

/**
 * @author anosv
 */
public class ActionTests extends BaseTest {

    private LoginPage loginPage = new LoginPage(driver);
    private MainPage mainPage = new MainPage(driver);
    private InOutActonPage inOutActonPage = new InOutActonPage(driver);
    private ActionsPage actionsPage = new ActionsPage(driver);

    @Before
    public void auth() {
        String login = properties.getProperty("adminLogin");
        String pass = properties.getProperty("adminPassword");
        loginPage.auth(login, pass);
    }

    @Test
    public void testGotoActionFromMainPage() {
        mainPage.gotoInActionsFromTableManagerBlock();
        assertTrue(inOutActonPage.isInOutActionFormBlockEnabled());
        assertThat(mainPage.getHeaderText(),
                containsString("Принять на терминал"));
        mainPage.gotoMainPage();
        mainPage.gotoOutActionsFromTableManagerBlock();
        assertTrue(inOutActonPage.isInOutActionFormBlockEnabled());
        assertThat(mainPage.getHeaderText(),
                containsString("Отпустить с терминала"));
    }

    @Test
    public void testGotoActionFromMainMenu() {
        mainPage.gotoInActionsFromHeaderMenuBlock();
        assertTrue(inOutActonPage.isInOutActionFormBlockEnabled());
        assertThat(mainPage.getHeaderText(),
                containsString("Принять на терминал"));
        mainPage.gotoMainPage();
        mainPage.gotoOutActionsFromHeaderMenuBlock();
        assertTrue(inOutActonPage.isInOutActionFormBlockEnabled());
        assertThat(mainPage.getHeaderText(),
                containsString("Отпустить с терминала"));
    }

    @Test
    public void testGotoActionFromActionsPage() {
        mainPage.gotoActionsFromHeaderMenuBlock();
        actionsPage.gotoInAction();
        assertTrue(inOutActonPage.isInOutActionFormBlockEnabled());
        assertThat(mainPage.getHeaderText(),
                containsString("Принять на терминал"));
        mainPage.gotoActionsFromHeaderMenuBlock();
        actionsPage.gotoOutAction();
        assertTrue(inOutActonPage.isInOutActionFormBlockEnabled());
        assertThat(mainPage.getHeaderText(),
                containsString("Отпустить с терминала"));
    }

    @After
    public void exit() {
        mainPage.exit();
    }
}
