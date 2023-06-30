package com.Tests;

import com.Pages.PageRegister;
import com.Tests.utils.UtilsReports;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;

public class TestResgister {
    private static WebDriver driver;
    private static ExtentSparkReporter spark = UtilsReports.getSpark();
    private static ExtentReports extent =UtilsReports.getExtent();
    private ExtentTest test;
    static PageRegister pageRegister;


    @BeforeEach
    public void setUp() throws Exception {
        pageRegister = new PageRegister();
        driver = pageRegister.chromeDriverConnection();
        pageRegister.link("https://parabank.parasoft.com/parabank/index.htm");
    }

    @BeforeAll
    public static void beforeAll() {
        extent.attachReporter(spark);
    }


    @Test
    @Tag("Regresion")
    public void testRegister() throws InterruptedException {
        test = extent.createTest("Registro de Cliente Positivo");
        test.log(Status.INFO, "Inicia la ejecución del test ...");
        pageRegister.registerUser();
        test.log(Status.PASS, "Se crea el usuario y se visualiza el letrero de bienvenida");
    }


    @AfterAll
    public static void afterAll() throws InterruptedException {
        Thread.sleep(2000);
        extent.flush();
    }
}