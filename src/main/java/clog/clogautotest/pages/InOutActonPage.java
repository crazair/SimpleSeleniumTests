package clog.clogautotest.pages;

import clog.clogautotest.blocks.HeaderMenuBlock;
import clog.clogautotest.blocks.InOutActionFormBlock;
import static clog.clogautotest.pages.BasePage.log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;

/**
 * @author anosv
 */
public class InOutActonPage extends BasePage {

    private HeaderMenuBlock headerMenuBlock = new HeaderMenuBlock();
    private InOutActionFormBlock inOutActionFormBlock = new InOutActionFormBlock();

    public InOutActonPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(new HtmlElementDecorator(driver), this);
        this.driver = driver;
        log.info("Init inoutaction page");
    }

    public boolean isInOutActionFormBlockEnabled() {
        log.info("isInOutActionFormBlockEnabled: " + inOutActionFormBlock.isEnabled());
        return inOutActionFormBlock.isEnabled();
    }
}
