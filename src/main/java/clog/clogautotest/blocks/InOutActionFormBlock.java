package clog.clogautotest.blocks;

import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Block;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

/**
 * @author anosv
 */
@Block(
        @FindBy(className = "inoutformdiv"))
public class InOutActionFormBlock extends HtmlElement {

    @FindBy(id = "inoutform:acceptcancel")
    public Button canselButton;
}
