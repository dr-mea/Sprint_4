package org.example.scooterTest;

import org.hamcrest.MatcherAssert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.hamcrest.CoreMatchers.is;

public class OrderPageScooter {

    private WebDriver driver;

    // Локатор для заголовка окна Для кого самокат
    private By orderHeader = By.xpath(".//div[text()='Для кого самокат']");

    // Локатор для заголовка окна про аренду
    private By aboutOrderHeader = By.xpath(".//div[text()='Про аренду']");

    // Локатор для кнопки принятия куки
    private By acceptCookieButton = By.xpath(".//button[text()='да все привыкли']");

    // Локатор для поля Имя
    private By nameField = By.xpath(".//input[@placeholder='* Имя']");
    // Локатор для поляФамилия
    private By surnameField = By.xpath(".//input[@placeholder='* Фамилия']");
    // Локатор для поля Адрес: куда привезти заказ
    private By addressField = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    // Локатор для поля Станция метро
    private By subwayField = By.xpath(".//input[@placeholder='* Станция метро']");
    // Локатор для поля Телефон: на него позвонит курьер
    private By phoneNumberField = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    // Локатор для кнопки Далее
    private By orderNextButton = By.xpath(".//button[text()='Далее']");
    // Локатор для поля Когда привезти самокат
    private By dateField = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    // Локатор для поля Срок аренды
    private By rentalPeriodField = By.xpath(".//div[@class='Dropdown-placeholder']");
    // Локатор для поля Комментарий для курьера
    private By commentField = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    // Локатор для кнопки Заказать
    private By orderCreateButton = By.xpath("//div[contains(@class,'Order_Buttons')]/button[text()='Заказать']");
    // Локатор для кнопки подтверждения заказа
    private By orderConfirmButton = By.xpath(".//button[text()='Да']");
    // Локатор для кнопки посмотреть статус
    private By confirmHeader = By.xpath(".//button[text()='Посмотреть статус']");
    public OrderPageScooter(WebDriver driver){
        this.driver = driver;
    }
    // Геттер для получения текста заголовка страницы заказа
    public String getOrderHeader() {
        return driver.findElement(orderHeader).getText();
    }
    // Геттер для получения текста на кнопке для просмотра статуса заказа
    public String getConfirmHeader() {
        return driver.findElement(confirmHeader).getText();
    }
    // Метод для проверки открытия страницы
    public void isPageOpen(String headerText, String text) {
        MatcherAssert.assertThat(headerText, is(text));
    }
    // Метод для принятия куки
    public void acceptCookieButtonClick() {
        driver.findElement(acceptCookieButton).click();
    }
    // Метод для заполнения поля Имя
    public void setName(String name) {
        driver.findElement(nameField).sendKeys(name);
    }
    // Метод для заполнения поля Фамилия
    public void setSurname(String surname) {
        driver.findElement(surnameField).sendKeys(surname);
    }
    // Метод для заполнения поля Адрес: куда привезти заказ
    public void setAddress(String address) {
        driver.findElement(addressField).sendKeys(address);
    }
    // Метод для заполнения поля Станция метро
    public void setSubway(String subway) {
        driver.findElement(subwayField).click();
        driver.findElement(By.xpath(".//div[text()='"+subway+"']")).click();
    }
    // Метод для заполнения поля Телефон: на него позвонит курьер
    public void setPhoneNumber(String phoneNumber) {
        driver.findElement(phoneNumberField).sendKeys(phoneNumber);
    }
    // Метод для перехода к странице Про аренду
    public void clickOrderNextButton() {
        driver.findElement(orderNextButton).click();
    }
    // Метод для заполнения поля Когда привезти самокат
    public void setDate(String date) {
        driver.findElement(dateField).sendKeys(date);
    }
    // Метод для заполнения поля Срок аренды
    public void setRentalPeriod(String rentalPeriod) {
        driver.findElement(aboutOrderHeader).click();
        driver.findElement(rentalPeriodField).click();
        driver.findElement(By.xpath(".//div[text()='"+rentalPeriod+"']")).click();
    }
    // Метод для заполнения поля Цвет самоката
    public void setColor(String color) {
        driver.findElement(By.xpath(".//label[text()='"+color+"']")).click();
    }
    // Метод для заполнения поля Комментарий для курьера
    public void setComment(String comment) {
        driver.findElement(commentField).sendKeys(comment);
    }
    // Метод для перехода к подтверждению заказа
    public void clickOrderCreateButton() {
        driver.findElement(orderCreateButton).click();
    }
    // Метод для подтверждения заказа
    public void clickOrderConfirmButton() {
        driver.findElement(orderConfirmButton).click();
    }
}