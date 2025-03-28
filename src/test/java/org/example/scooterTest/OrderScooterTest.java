package org.example.scooterTest;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.example.scooterTest.CheckList.confirmHeader;

@RunWith(Parameterized.class)
public class OrderScooterTest {
    private WebDriver driver;
    private final String name;
    private final String surname;
    private final String address;
    private final String subway;
    private final String phoneNumber;
    private final String date;
    private final String rentalPeriod;
    private final String color;
    private final String comment;

    public OrderScooterTest(String name, String surname, String address, String subway, String phoneNumber, String date, String rentalPeriod, String color, String comment) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.subway = subway;
        this.phoneNumber = phoneNumber;
        this.date = date;
        this.rentalPeriod = rentalPeriod;
        this.color = color;
        this.comment = comment;
    }
    @Parameterized.Parameters
    public static Object[][] getDateSetForOrder() {
        return new Object[][] {
                {"Кузя", "Маковкин", "Ленина, 4", "Речной вокзал", "89121231212", "27.03.2026", "сутки", "чёрный жемчуг", "Для Кузи"},
                {"Цукисиро", "Янаги", "Шестой отдел", "Комсомольская", "+79121231212", "27.03.2027", "двое суток", "серая безысходность", "Быстрее молнии"},
        };
    }
    @Test
    public void OrderPositiveTest() throws InterruptedException {
        // Создать веб-драйвер для Firefox
        driver = new FirefoxDriver();
        // Открыть страницу заказа Яндекс Самокат
        driver.get("https://qa-scooter.praktikum-services.ru");

        // Создать объект класса с домашней страницей
        HomePageScooter objHomePage = new HomePageScooter(driver);
        Thread.sleep(1000);
        // Нажать на кнопку Заказать на чердаке
        objHomePage.clickHeaderOrderButton();
        Thread.sleep(1000);

        // Создать объект класса со страницей заказа
        OrderPageScooter objOrderPage = new OrderPageScooter(driver);
        Thread.sleep(1000);
        // Принять куки
        objOrderPage.acceptCookieButtonClick();

        // Позитивный сценарий оформления заказа
        objOrderPage.setName(name);
        Thread.sleep(1000);
        objOrderPage.setSurname(surname);
        Thread.sleep(1000);
        objOrderPage.setAddress(address);
        Thread.sleep(1000);
        objOrderPage.setSubway(subway);
        Thread.sleep(1000);
        objOrderPage.setPhoneNumber(phoneNumber);
        Thread.sleep(1000);
        objOrderPage.clickOrderNextButton();
        Thread.sleep(1000);
        objOrderPage.setDate(date);
        Thread.sleep(1000);
        objOrderPage.setRentalPeriod(rentalPeriod);
        Thread.sleep(1000);
        objOrderPage.setColor(color);
        Thread.sleep(1000);
        objOrderPage.setComment(comment);
        Thread.sleep(1000);
        objOrderPage.clickOrderCreateButton();
        Thread.sleep(1000);
        objOrderPage.clickOrderConfirmButton();
        Thread.sleep(1000);

        // Проверить, что открылась страница успешного создания заказа
        objOrderPage.isPageOpen(objOrderPage.getConfirmHeader() ,confirmHeader);
    }
    @After
    public void teardown() {
        driver.quit();
    }
}