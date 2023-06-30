package com.Pages;

import com.Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PageRegister extends BasePage {



    By liknRegister = By.xpath("//a[text() = 'Register']");
    By firstName= By.id("customer.firstName");
    By lastName= By.id("customer.lastName");
    By address=By.id("customer.address.street");
    By city= By.id("customer.address.city");
    By state = By.id("customer.address.state");
    By zipCode= By.id("customer.address.zipCode");
    By snn= By.id("customer.ssn");
    By username= By.id("customer.username");
    By password = By.id("customer.password");
    By repeatedPassword= By.id("repeatedPassword");
    By registerButton= By.xpath("//input[@type='submit' and @class='button' and @value='Register']");

    By wecolemeUser=By.xpath("//*[@id=\'rightPanel\']/h1");



    public PageRegister() {
    }



    public void registerUser() throws InterruptedException {
        String usernameString="username_7";

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(liknRegister));
        driver.findElement(liknRegister).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstName));

        driver.findElement(firstName).sendKeys("nombre");
        driver.findElement(lastName).sendKeys("apellido");
        driver.findElement(address).sendKeys("calle falsa 123");
        driver.findElement(city).sendKeys("Springfield");
        driver.findElement(state).sendKeys("state");
        driver.findElement(zipCode).sendKeys("123");
        driver.findElement(snn).sendKeys("snn");
        driver.findElement(username).sendKeys(usernameString);
        driver.findElement(password).sendKeys("123");
        driver.findElement(repeatedPassword).sendKeys("123");
        driver.findElement(registerButton).click();
        String textoRespuesta= "Welcome " + usernameString ;

        assertTrue(driver.findElement(wecolemeUser).getText().equals(textoRespuesta));


    }


}
