import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pages.HeaderPageScooter;
import pages.HomePageScooter;
import pages.OrderPageScooter;
import tests.base.BaseTest;

@RunWith(Parameterized.class)
public class OrderTest extends BaseTest {
    private final String name;
    private final String surname;
    private final String address;
    private final int indexStation;
    private final String phone;
    private final String date;
    private final int indexOptions;
    private final int indexColor;
    private final String comment;

    public OrderTest(String name, String surname, String address, int indexStation,
                     String phone, String date, int indexOptions, int indexColor, String comment) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.indexStation = indexStation;
        this.phone = phone;
        this.date = date;
        this.indexOptions = indexOptions;
        this.indexColor = indexColor;
        this.comment = comment;
    }

    @Parameterized.Parameters
    public static Object[][] getOrderDetail() {
        return new Object[][]{
                {"Иван", "Иванов", "ул. Ивановская", 3, "89619092121", "27.07.2024",
                        2, 0, "Жду черненький самокатик!"},
                {"Петр", "Петров", "ул. Петрова", 12, "89693423434", "28.08.2024",
                        5, 1, "Жду!"},
        };
    }

    @Test
    public void orderInHeader() {
        driver.get("https://qa-scooter.praktikum-services.ru/");

        HomePageScooter objHomePage = new HomePageScooter(driver);
        HeaderPageScooter objHeaderPage = new HeaderPageScooter(driver);
        OrderPageScooter objOrderPage = new OrderPageScooter(driver);
        objHomePage.clickCookieButton();
        objHeaderPage.clickOrderButton();
        objOrderPage.enterForWhom(name, surname, address, indexStation, phone);
        objOrderPage.clickNextButton();
        objOrderPage.enterRentInfo(date, indexOptions, indexColor, comment);
        objOrderPage.clickOrderButton();
        objOrderPage.clickConfirmButtonModal();
        objOrderPage.isModalProcessed()
                .checkOrderModalText();
    }

    @Test
    public void orderHome() {
        driver.get("https://qa-scooter.praktikum-services.ru/");

        HomePageScooter objHomePage = new HomePageScooter(driver);
        OrderPageScooter objOrderPage = new OrderPageScooter(driver);
        objHomePage.clickCookieButton();
        objHomePage.clickOrderButton();
        objOrderPage.enterForWhom(name, surname, address, indexStation, phone);
        objOrderPage.clickNextButton();
        objOrderPage.enterRentInfo(date, indexOptions, indexColor, comment);
        objOrderPage.clickOrderButton();
        objOrderPage.clickConfirmButtonModal();
        objOrderPage.isModalProcessed()
                .checkOrderModalText();
    }

}
