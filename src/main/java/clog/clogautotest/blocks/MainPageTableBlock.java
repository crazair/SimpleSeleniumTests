package clog.clogautotest.blocks;

import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Block;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

/**
 * @author anosv
 */
@Block(
        @FindBy(className = "mainpagetable"))
public class MainPageTableBlock extends HtmlElement {
}
