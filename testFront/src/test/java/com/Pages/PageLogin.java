package com.Pages;

import com.Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PageLogin extends BasePage {


    //login

    By inputUsername =By.xpath("//*[@id=\'loginPanel\']/form/div[1]/input");
    By passwordLogin =By.xpath("//*[@id='loginPanel']/form/div[2]/input");
    By loginButton = By.xpath("//*[@id='loginPanel']/form/div[3]/input");

    //accountsOverview
    By  balanceIncludes= By.xpath("//*[@id=\'accountTable\']/tfoot/tr/td");

    //transferFounds

    By tranferLink = By.xpath("//*[@id=\'leftPanel\']/ul/li[3]/a");
    By tranferTitle = By.xpath("//div[@id='rightPanel']//h1[@class='title']");
    By amount = By.id("amount");
    By fromAccount = By.id("fromAccountId");
    By toAccount = By.id("toAccountId");
    By buttonTransfer= By.xpath("//div[@id='rightPanel']//input[contains(@class, 'button')]");
    By transferComplete= By.xpath("//div[@id='rightPanel']//h1[contains(@class, 'title')]");

    //accountActivity

    By numberAccount = By.xpath("//*[@id=\"accountTable\"]/tbody/tr[1]/td[1]/a");
    By accountdetails = By.xpath("//*[@id=\"rightPanel\"]/div/div[1]/h1");
    By selectMonth =By.id("month");
    By selecTransactionType= By.id("transactionType");
    By goButton = By.xpath("//*[@id=\"rightPanel\"]//table[contains(@class, 'form_activity')]//input[contains(@class, 'button')]");

    // openAccount

    By openNewAccount = By.xpath("//*[@id=\"leftPanel\"]/ul/li[1]/a");
    By selectType=By.id("type");

    By getOpenNewAccountButton = By.xpath("//*[@id=\'rightPanel\']/div/div/form/div/input");
    By getOpenMessage = By.xpath("//*[@id=\'rightPanel\']/div/div/p[1]");





    public PageLogin() {
    }

    public void login() throws InterruptedException{
        String user="username_7";
        String password="123";
        driver.findElement(inputUsername).sendKeys(user);
        driver.findElement(passwordLogin).sendKeys(password);
        driver.findElement(loginButton).click();

    }

    public void accountsOverview() throws InterruptedException{
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(balanceIncludes));
        driver.findElement(balanceIncludes);

        String text="Balance includes deposits that may be subject to holds";
        assertTrue(driver.findElement(balanceIncludes).getText().contains(text));       //wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//*[@id='rightPanel']/div/div/h1"),"Transfer Funds"));


    }

    public void transferFounds () throws InterruptedException{

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.findElement(tranferLink).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(tranferTitle));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(tranferTitle,"Transfer Funds"));
        //driver.findElement(amount).click();

        Thread.sleep(1000);
        driver.findElement(amount).sendKeys("12");


        Select select = new Select(driver.findElement(fromAccount));
        driver.findElement(fromAccount).click();
        select.selectByVisibleText(select.getOptions().get(0).getText());

        Select select1 = new Select(driver.findElement(fromAccount));
        driver.findElement(toAccount).click();
        select1.selectByVisibleText(select.getOptions().get(0).getText());


        driver.findElement(buttonTransfer).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(transferComplete));
        assertTrue(driver.findElement(transferComplete).getText().contains("Transfer Funds"));

    }

    public void accountActivity () throws InterruptedException{

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(numberAccount));
        driver.findElement(numberAccount).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(accountdetails));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(accountdetails,"Account Details"));

        Select selectMonth_ = new Select(driver.findElement(selectMonth));
        driver.findElement(selectMonth).click();
        selectMonth_.selectByVisibleText(selectMonth_.getOptions().get(0).getText());

        Select selecTransactionType_ = new Select(driver.findElement(selecTransactionType));
        driver.findElement(selecTransactionType).click();
        selecTransactionType_.selectByVisibleText(selecTransactionType_.getOptions().get(0).getText());

        driver.findElement(goButton).click();


    }

    public void openAccount() {

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(openNewAccount));
        driver.findElement(openNewAccount).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(selectType));

        Select selectType_=new Select(driver.findElement(selectType));
        driver.findElement(selectType).click();
        selectType_.selectByVisibleText(selectType_.getOptions().get(1).getText());

        driver.findElement(getOpenNewAccountButton).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(getOpenMessage));
        System.out.println(driver.findElement(getOpenMessage).getText());
        assertTrue(driver.findElement(getOpenMessage).getText().contains("Congratulations, your account is now open"));





    }
}
