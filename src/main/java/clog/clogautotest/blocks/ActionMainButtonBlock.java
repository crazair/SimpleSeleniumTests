package clog.clogautotest.blocks;

import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Block;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

/**
 * @author anosv
 */
@Block(
        @FindBy(xpath = "//*[@id='actionform']/table[2]"))
public class ActionMainButtonBlock extends HtmlElement {

    @FindBy(id = "actionform:ionsinactLink2")
    public Button gotoInActButton;
    @FindBy(id = "actionform:outactionsLink2")
    public Button gotoOutActButton;

    public void gotoInAction() {
        gotoInActButton.click();
    }

    public void gotoOutAction() {
        gotoOutActButton.click();
    }
}
