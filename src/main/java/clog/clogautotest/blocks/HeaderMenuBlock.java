package clog.clogautotest.blocks;

import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Block;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.Link;

/**
 * @author anosv
 */
@Block(
        @FindBy(className = "header_content"))
public class HeaderMenuBlock extends HtmlElement {

    @FindBy(id = "header:logoLink")
    public Link logoLink;
    @FindBy(id = "header:exitLink")
    public Link exitLink;
    @FindBy(xpath = "//*[@id='header:menubar:mc']/a")
    public Button actionsBar;
    @FindBy(id = "header:menubar:mc:actions:link")
    public Button actions;
    @FindBy(id = "header:menubar:mc:incontainer:link")
    public Button incontainer;
    @FindBy(id = "header:menubar:mc:outcontainer:link")
    public Button outcontainer;
    @FindBy(id = "header:menubar:mc:containers:link")
    public Button containers;
    @FindBy(xpath = "//*[@id='header:menubar:mrq']/a")
    public Button requestBar;
    @FindBy(xpath = "//*[@id='header:menubar:md']/a")
    public Button dirBar;
    @FindBy(xpath = "//*[@id='header:menubar:mr']/a")
    public Button reportBar;
    @FindBy(xpath = "//*[@id='header:menubar:ms']/a")
    public Button serviceBar;

    public void gotoMainPage() {
        logoLink.click();
    }

    public void exit() {
        exitLink.click();
    }

    public void gotoInAction() {
        actionsBar.click();
        incontainer.click();
    }

    public void gotoOutAction() {
        actionsBar.click();
        outcontainer.click();
    }

    public void gotoActions() {
        actionsBar.click();
        actions.click();
    }
}
