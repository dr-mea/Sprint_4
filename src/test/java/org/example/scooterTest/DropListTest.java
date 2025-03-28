package org.example.scooterTest;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.example.scooterTest.CheckList.*;

// Класс с автотестами
public class DropListTest {
    private WebDriver driver;

    @Test
    public void FAQCorrectAnswerText() throws InterruptedException {
        // Создание веб-драйвера для Google Chrome
        driver = new ChromeDriver();

        // Открываем домашнюю страницу Яндекс Самокат
        driver.get("https://qa-scooter.praktikum-services.ru");

        // Скролл страницы до выпадающего списка с вопросами
        WebElement DropList = driver.findElement(By.xpath(".//div[@class='accordion']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", DropList);

        // Создание объекта класса с домашней страницей
        HomePageScooter objHomePage = new HomePageScooter(driver);

        // Принимаем куки
        objHomePage.acceptCookieButtonClick();
        Thread.sleep(1000);

        // Проверяем ОР и ФР текста ответа на вопрос из выпадающего списка
        objHomePage.clickQuestion1();
        objHomePage.isCorrectText(objHomePage.getAnswer1(), answer1Text);
        Thread.sleep(1000);
        objHomePage.clickQuestion2();
        objHomePage.isCorrectText(objHomePage.getAnswer2(), answer2Text);
        Thread.sleep(1000);
        objHomePage.clickQuestion3();
        objHomePage.isCorrectText(objHomePage.getAnswer3(), answer3Text);
        Thread.sleep(1000);
        objHomePage.clickQuestion4();
        objHomePage.isCorrectText(objHomePage.getAnswer4(), answer4Text);
        Thread.sleep(1000);
        objHomePage.clickQuestion5();
        objHomePage.isCorrectText(objHomePage.getAnswer5(), answer5Text);
        Thread.sleep(1000);
        objHomePage.clickQuestion6();
        objHomePage.isCorrectText(objHomePage.getAnswer6(), answer6Text);
        Thread.sleep(1000);
        objHomePage.clickQuestion7();
        objHomePage.isCorrectText(objHomePage.getAnswer7(), answer7Text);
        Thread.sleep(1000);
        objHomePage.clickQuestion8();
        objHomePage.isCorrectText(objHomePage.getAnswer8(), answer8Text);
        Thread.sleep(1000);
    }

    @After
    public void teardown() {
        driver.quit();
    }
}