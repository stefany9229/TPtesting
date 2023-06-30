package com.Tests;

import com.Pages.PageLogin;
import com.Tests.utils.UtilsReports;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;

public class TestLogin {

    static PageLogin pageLogin;
    private static WebDriver driver;
    private static ExtentSparkReporter spark = UtilsReports.getSpark();
    private static ExtentReports extent = UtilsReports.getExtent();
    private ExtentTest test;

    @BeforeEach
    public void setUp() throws Exception {
        pageLogin = new PageLogin();
        driver = pageLogin.chromeDriverConnection();
        pageLogin.link("https://parabank.parasoft.com/parabank/index.htm");
    }

    @BeforeAll
    public static void beforeAll() {
        extent.attachReporter(spark);
    }

    @Test
    @Tag("Regresion")
    public void accountsOverviewTest() throws InterruptedException {
        test = extent.createTest("Resumen de Cuentas Positivo");
        test.log(Status.INFO, "Inicia la ejecución del test ...");
        pageLogin.login();
        test.log(Status.PASS, "Se loguea el usuario correctamente");
        pageLogin.accountsOverview();
        test.log(Status.PASS, "Valida que 'El saldo incluye depósitos que pueden estar sujetos a retenciones' este visible en la pantalla");
    }

    @Test
    @Tag("Regresion")
    public void transferFoundsTest() throws InterruptedException {
        test = extent.createTest("Transferencia de fondos positivo");
        test.log(Status.INFO, "Inicia la ejecución del test ...");
        pageLogin.login();
        test.log(Status.PASS, "Se loguea el usuario correctamente");
        pageLogin.transferFounds();
        test.log(Status.PASS, "Se realiza la transferencia de fondos exitosamente");
        Thread.sleep(1000);
    }

    @Test
    @Tag("Regresion")
    public void accountActivityTest() throws InterruptedException {
        test = extent.createTest("Actividad de la cuenta positivo");
        test.log(Status.INFO, "Inicia la ejecución del test ...");
        pageLogin.login();
        test.log(Status.PASS, "Se loguea el usuario correctamente");
        pageLogin.accountsOverview();
        test.log(Status.PASS, "Valida que 'El saldo incluye depósitos que pueden estar sujetos a retenciones' este visible en la pantalla");
        pageLogin.accountActivity();
        test.log(Status.PASS, "Se puede observar todo el registro de la actividad de la cuenta");
        Thread.sleep(1000);
    }

    @Test
    @Tag("Regresion")
    public void openAccount() throws InterruptedException {
        test = extent.createTest("Apertura de cuenta");
        test.log(Status.INFO, "Inicia la ejecución del test ...");
        pageLogin.login();
        test.log(Status.PASS, "Se loguea el usuario correctamente");
        pageLogin.openAccount();
        test.log(Status.PASS, "La cuenta se crea efectivamente y aparece el mensaje 'Congratulations, your account is now open'.");
        Thread.sleep(1000);
    }

    @AfterAll
    public static void tearDownn() throws InterruptedException {
        Thread.sleep(2000);
        extent.flush();
        driver.quit();
    }
}
