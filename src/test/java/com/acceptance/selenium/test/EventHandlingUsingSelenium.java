package com.acceptance.selenium.test;

import com.acceptance.json.test.DomManupulation;
import com.acceptance.json.test.JsonManupulator;
import com.acceptance.test.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * @author Abhijeet Gulve
 */
public class EventHandlingUsingSelenium extends BaseTest {
    static JsonManupulator jr;
    DomManupulation domManupulation;

    @BeforeEach
    public void setUp() {
    }

    @Test
    public void testSelenium() {
        //System.setProperty("webdriver.chrome.driver", "/home/gulve/acceptance_test/acceptance-test/acceptance-testing/drivers/chromedriver");
        ChromeDriver driver = new ChromeDriver();
        driver.get("http://www.github.com/login");
        WebElement login_field = driver.findElement(By.id("login_field"));
        login_field.sendKeys("chsjfhsdfk");

    }


}
