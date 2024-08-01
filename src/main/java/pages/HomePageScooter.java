package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePageScooter {
    //Кнопка "Заказать" на главной
    private static final By ORDER_BUTTON_HOME = By.xpath(".//*[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    //Кнопка выпадающего списка "Вопросы о важном"
    private static final By ACCORDION_BUTTON = By.className("accordion__button");
    //Видимый элемент выпадающего списка
    private static final By ACCORDION_PANEL = By.xpath(".//*[@class='accordion__panel' and not(@hidden)]");
    //Кнопка принятия куки
    private static final By COOKIE_BUTTON = By.id("rcc-confirm-button");
    private WebDriver driver;


    public HomePageScooter(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOrderButton() {
        WebElement element = driver.findElement(ORDER_BUTTON_HOME);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        element.click();
    }

    public void clickAccordionButton(int index) {
        List<WebElement> elements = driver.findElements(ACCORDION_BUTTON);
        WebElement element = elements.get(index);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        element.click();
    }

    public String getTextAccordionPanel() {
        return driver.findElement(ACCORDION_PANEL).getText();
    }

    public void clickCookieButton() {
        driver.findElement(COOKIE_BUTTON).click();
    }

}
