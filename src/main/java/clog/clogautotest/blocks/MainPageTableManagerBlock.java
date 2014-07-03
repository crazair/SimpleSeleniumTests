package clog.clogautotest.blocks;

import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Block;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.Link;

/**
 * @author anosv
 */
@Block(
        @FindBy(className = "mainpagetableManager"))
public class MainPageTableManagerBlock extends HtmlElement {

    @FindBy(id = "mainpage:inactions")
    public Link inactionsLink;
    @FindBy(id = "mainpage:outactions")
    public Link outactionsLink;

    public void gotoInActions() {
        inactionsLink.click();
    }

    public void gotoOutActions() {
        outactionsLink.click();
    }
}
