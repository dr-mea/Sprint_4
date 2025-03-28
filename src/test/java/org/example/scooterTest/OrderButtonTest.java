package org.example.scooterTest;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.example.scooterTest.CheckList.orderHeader;

public class OrderButtonTest {

    private WebDriver driver;

    @Test
    public void OrderPageOpenAfterHeaderButtonClick() throws InterruptedException {
        // Создание веб-драйвера для Google Chrome
        driver = new ChromeDriver();
        // Открываем домашнюю страницу Яндекс Самокат
        driver.get("https://qa-scooter.praktikum-services.ru");

        // Создание объекта класса с домашней страницей
        HomePageScooter objHomePage = new HomePageScooter(driver);
        Thread.sleep(1000);
        // Клик по кнопкуе Заказать вверхуэкрана
        objHomePage.clickHeaderOrderButton();
        Thread.sleep(1000);

        // Создание объекта класса со страницей заказа
        OrderPageScooter objOrderPage = new OrderPageScooter(driver);
        Thread.sleep(1000);
        // Проверяем, что открылась страница заказа
        objOrderPage.isPageOpen(objOrderPage.getOrderHeader() ,orderHeader);
    }
    @Test
    public void OrderPageOpenAfterPageButtonClick() throws InterruptedException {
        // Создание веб-драйвера для Google Chrome
        driver = new ChromeDriver();
        // Открываем домашнюю страницу Яндекс Самокат
        driver.get("https://qa-scooter.praktikum-services.ru");
        Thread.sleep(1000);

        // Скролл страницы до кнопки Заказать
        WebElement OrderButtonPage = driver.findElement(By.xpath(".//div[contains(@class, 'Home_FinishButton')]/button"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", OrderButtonPage);
        Thread.sleep(1000);

        // Создание объекта класса с домашней страницей
        HomePageScooter objHomePage = new HomePageScooter(driver);
        Thread.sleep(1000);
        // Клик по кнопке Заказать внизу экрана
        objHomePage.clickPageOrderButton();
        Thread.sleep(1000);

        // Создание объекта класса со страницей заказа
        OrderPageScooter objOrderPage = new OrderPageScooter(driver);
        Thread.sleep(1000);
        // Проверяем, что открылась страница заказа
        objOrderPage.isPageOpen(objOrderPage.getOrderHeader() ,orderHeader);
    }
    @After
    public void teardown() {
        driver.quit();
    }
}