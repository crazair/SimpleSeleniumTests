package clog.clogautotest.pages;

import clog.clogautotest.blocks.ActionMainButtonBlock;
import clog.clogautotest.blocks.ActionScrollerBlock;
import clog.clogautotest.blocks.HeaderMenuBlock;
import static clog.clogautotest.pages.BasePage.log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;

/**
 * @author anosv
 */
public class ActionsPage extends BasePage {

    private HeaderMenuBlock headerMenuBlock = new HeaderMenuBlock();
    private ActionScrollerBlock actionScrollerBlock = new ActionScrollerBlock();
    private ActionMainButtonBlock actionMainButtonBlock = new ActionMainButtonBlock();

    public ActionsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(new HtmlElementDecorator(driver), this);
        this.driver = driver;
        log.info("Init inoutaction page");
    }

    public void gotoInAction() {
        log.info("gotoInAction");
        actionMainButtonBlock.gotoInAction();
    }

    public void gotoOutAction() {
        log.info("gotoOutAction");
        actionMainButtonBlock.gotoOutAction();
    }
}
