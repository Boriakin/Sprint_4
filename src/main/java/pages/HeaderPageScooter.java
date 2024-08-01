package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HeaderPageScooter {
    //Кнопка "Заказать" в хедере
    private static final By ORDER_BUTTON_HEADER = By.className("Button_Button__ra12g");
    //Кнопка поиска заказа
    private WebDriver driver;

    public HeaderPageScooter(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOrderButton() {
        driver.findElement(ORDER_BUTTON_HEADER).click();
    }
}
