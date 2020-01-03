package com.froyo.selenium;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GoogleSearchTest {

    private WebDriver webDriver;

    @BeforeEach
    public void setUp() {

        System.setProperty("webdriver.chrome.driver","./src/test/resources/chromedriver/chromedriver79.exe");
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.get(("https://www.google.com"));

    }

    @Test
    public void testGooglePage(){

        WebElement searchBox = webDriver.findElement(By.name("q"));
        searchBox.clear();
        searchBox.sendKeys("Club Tijuana");
        searchBox.submit();

        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        assertEquals("Club Tijuana - Buscar con Google",webDriver.getTitle());

    }

    @AfterEach
    public void testDown(){
        webDriver.quit();
    }

}
