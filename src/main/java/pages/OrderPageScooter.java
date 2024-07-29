package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class OrderPageScooter {
    //Поле "Имя"
    private static final By INPUT_NAME =
            By.xpath(".//*[@placeholder='* Имя']");
    //Поле "Фамилия"
    private static final By INPUT_SURNAME =
            By.xpath(".//*[@placeholder='* Фамилия']");
    //Поле "Адрес"
    private static final By INPUT_ADDRESS =
            By.xpath(".//*[@placeholder='* Адрес: куда привезти заказ']");
    //Поле "Станция метро"
    private static final By INPUT_STATION =
            By.xpath(".//*[@placeholder='* Станция метро']");
    //Элемент выпадающего списка станций метро
    private static final By STATION_SELECT_BUTTON = By.xpath(".//*[@class='select-search__row']");
    //Поле "Номер телефона"
    private static final By INPUT_PHONE =
            By.xpath(".//*[@placeholder='* Телефон: на него позвонит курьер']");
    //Кнопка "Далее"
    private static final By NEXT_BUTTON =
            By.xpath(".//*[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    //Поле ввода "Когда привезти самокат"
    private static final By INPUT_DATE =
            By.xpath(".//*[@placeholder='* Когда привезти самокат']");
    //Выбранная дата в календаре
    private static final By SELECTED_DAY = By.xpath(".//*[contains(@class,'day--selected')]");
    //Дропдаун "Срок аренды"
    private static final By DROPDOWN_CONTROL_RENT = By.className("Dropdown-control");
    //Элемент выпадающего меню
    private static final By DROPDOWN_OPTION = By.className("Dropdown-option");
    //Чекбокс выбора цвета
    private static final By CHECKBOX_INPUT = By.className("Checkbox_Input__14A2w");
    //Поле ввода комментария для курьера
    private static final By INPUT_COMMENT =
            By.xpath(".//*[@placeholder='Комментарий для курьера']");
    //Кнопка заказа самоката
    private static final By ORDER_BUTTON =
            By.xpath(".//*[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Заказать']");
    //Кнопка подтверждения заказа в модальном окне
    private static final By CONFIRM_BUTTON_MODAL =
            By.xpath(".//*[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Да']");
    //Модальное окно "Заказ оформлен"
    private static final By MODAL_ORDER_PROCESSED =
            By.xpath(".//*[@class='Order_Modal__YZ-d3']");
    //Текст в модальном окне заказа
    private static final By ORDER_MODAL_HEADER = By.className("Order_ModalHeader__3FDaJ");
    private WebDriver driver;

    public OrderPageScooter(WebDriver driver) {
        this.driver = driver;
    }

    public void setName(String name) {
        driver.findElement(INPUT_NAME).sendKeys(name);
    }

    public void setSurname(String surname) {
        driver.findElement(INPUT_SURNAME).sendKeys(surname);
    }

    public void setAddress(String address) {
        driver.findElement(INPUT_ADDRESS).sendKeys(address);
    }

    public void clickStationSelector() {
        driver.findElement(INPUT_STATION).click();
    }

    public void setStation(int indexStation) {
        List<WebElement> elements = driver.findElements(STATION_SELECT_BUTTON);
        WebElement element = elements.get(indexStation);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        element.click();
    }

    public void setPhone(String phone) {
        driver.findElement(INPUT_PHONE).sendKeys(phone);
    }

    public void clickNextButton() {
        WebElement element = driver.findElement(NEXT_BUTTON);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        element.click();
    }

    public void setDate(String date) {
        driver.findElement(INPUT_DATE).sendKeys(date);
        driver.findElement(SELECTED_DAY).click();
    }

    public void clickDropdownControl() {
        driver.findElement(DROPDOWN_CONTROL_RENT).click();
    }

    public void setDropdownOptions(int indexOptions) {
        List<WebElement> elements = driver.findElements(DROPDOWN_OPTION);
        WebElement element = elements.get(indexOptions);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        element.click();
    }

    public void setCheckbox(int indexColor) {
        List<WebElement> elements = driver.findElements(CHECKBOX_INPUT);
        WebElement element = elements.get(indexColor);
        element.click();
    }

    public void setComment(String comment) {
        driver.findElement(INPUT_COMMENT).sendKeys(comment);
    }

    public void clickOrderButton() {
        driver.findElement(ORDER_BUTTON).click();
    }

    public void clickConfirmButtonModal() {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(CONFIRM_BUTTON_MODAL));
        driver.findElement(CONFIRM_BUTTON_MODAL).click();
    }

    public OrderPageScooter isModalProcessed() {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(MODAL_ORDER_PROCESSED));
        boolean isDisplayed = driver.findElement(MODAL_ORDER_PROCESSED).isDisplayed();
        Assert.assertTrue("Ожидается появление модального окна.", isDisplayed);
        return this;
    }

    public void checkOrderModalText() {
        String text = driver.findElement(ORDER_MODAL_HEADER).getText();
        Assert.assertEquals("Ожидается текст об успешном оформлении заказа.", "Заказ оформлен", text);
    }

    public void enterForWhom(String name, String surname, String address, int indexStation, String phone) {
        setName(name);
        setSurname(surname);
        setAddress(address);
        clickStationSelector();
        setStation(indexStation);
        setPhone(phone);
    }

    public void enterRentInfo(String date, int indexOptions, int indexColor, String comment) {
        setDate(date);
        clickDropdownControl();
        setDropdownOptions(indexOptions);
        setCheckbox(indexColor);
        setComment(comment);
    }

}
