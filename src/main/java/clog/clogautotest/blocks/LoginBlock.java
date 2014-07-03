package clog.clogautotest.blocks;

import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Block;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.TextInput;

/**
 * @author anosv
 */
@Name("Auth Block")
@Block(
        @FindBy(id = "signin"))
public class LoginBlock extends HtmlElement {

    @Name("Login TextInput")
    @FindBy(id = "Login")
    public TextInput login;
    @Name("Password TextInput")
    @FindBy(id = "Pass")
    public TextInput password;
    @Name("Login Button")
    @FindBy(className = "loginButton")
    public Button loginButton;
    @FindBy(id = "error1")
    public HtmlElement error1;
    @FindBy(id = "error2")
    public HtmlElement error2;
    @FindBy(id = "error3")
    public HtmlElement error3;

    public void enterLogin(String sLogin) {
        login.clear();
        login.sendKeys(sLogin);
    }

    public void enterPassword(String sPassword) {
        password.clear();
        password.sendKeys(sPassword);
    }

    public void enterLoginButton() {
        loginButton.click();
    }

    public boolean isDisplayedErrorBlock1() {
        return error1.isDisplayed();
    }

    public String getTextFromErrorBlock1() {
        return error1.getText();
    }

    public boolean isDisplayedErrorBlock2() {
        return error2.isDisplayed();
    }

    public String getTextFromErrorBlock2() {
        return error2.getText();
    }

    public boolean isDisplayedErrorBlock3() {
        return error3.isDisplayed();
    }

    public String getTextFromErrorBlock3() {
        return error3.getText();
    }
}
