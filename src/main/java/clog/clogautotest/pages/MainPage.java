package clog.clogautotest.pages;

import clog.clogautotest.blocks.HeaderMenuBlock;
import clog.clogautotest.blocks.MainPageTableBlock;
import clog.clogautotest.blocks.MainPageTableManagerBlock;
import static clog.clogautotest.pages.BasePage.log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;

/**
 * @author anosv
 */
public class MainPage extends BasePage {

    private HeaderMenuBlock headerMenuBlock = new HeaderMenuBlock();
    private MainPageTableBlock mainPageTableBlock = new MainPageTableBlock();
    private MainPageTableManagerBlock mainPageTableManagerBlock = new MainPageTableManagerBlock();

    public MainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(new HtmlElementDecorator(driver), this);
        log.info("Init main page");
    }

    public boolean isOperBlockEnabled() {
        return mainPageTableBlock.isEnabled();
    }

    public boolean isManagerBlockEnabled() {
        return mainPageTableManagerBlock.isEnabled();
    }

    public String getHeaderText() {
        log.info("getHeaderText");
        return headerMenuBlock.getText();
    }

    public void exit() {
        log.info("exit");
        headerMenuBlock.exit();
    }

    public void gotoInActionsFromTableManagerBlock() {
        log.info("gotoInActionsFromTableManagerBlock");
        mainPageTableManagerBlock.gotoInActions();
    }

    public void gotoOutActionsFromTableManagerBlock() {
        log.info("gotoOutActionsFromTableManagerBlock");
        mainPageTableManagerBlock.gotoOutActions();
    }

    public void gotoMainPage() {
        log.info("gotoMainPage");
        headerMenuBlock.gotoMainPage();
    }

    public void gotoInActionsFromHeaderMenuBlock() {
        log.info("gotoInActionsFromHeaderMenuBlock");
        headerMenuBlock.gotoInAction();
    }

    public void gotoOutActionsFromHeaderMenuBlock() {
        log.info("gotoOutActionsFromHeaderMenuBlock");
        headerMenuBlock.gotoOutAction();
    }

    public void gotoActionsFromHeaderMenuBlock() {
        log.info("gotoActionsFromHeaderMenuBlock");
        headerMenuBlock.gotoActions();
    }
}
