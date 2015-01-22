package com.uitest.ss.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;
import com.uitest.ss.location.Login;

public class LoginTest {
    WebDriver driver = new FirefoxDriver();
    public final static String URL = "http://localhost:8080/login";
    @Test
    public void loginTest(){
            driver.get(URL);

            Assert.assertEquals(driver.getTitle(), "SS - Login");

            driver.findElement(By.xpath(Login.username)).sendKeys("test");

            driver.findElement(By.xpath(Login.password)).sendKeys("test1111");

            driver.findElement(By.xpath(Login.singInButton)).click();

            driver.manage().timeouts().pageLoadTimeout(10000, TimeUnit.SECONDS);

            driver.findElement(By.xpath("//*[contains(@href, '#project-manager')]")).click();
            driver.findElement(By.xpath("//*[contains(@href, '#projects')]")).click();

            driver.findElement(By.xpath("//*[contains(@href, '#projects/new')]")).isDisplayed();

    }
    @Test
    public void checkCreateNewProject(){

        driver.get(URL);


        driver.findElement(By.xpath("//*[contains(@name, '_username')]")).sendKeys("test");

        driver.findElement(By.xpath("//*[contains(@name, '_password')]")).sendKeys("test1111");

        driver.findElement(By.xpath("//*[contains(@value, 'Sign in')]")).click();

        driver.manage().timeouts().pageLoadTimeout(10000, TimeUnit.SECONDS);

        driver.findElement(By.xpath("//*[contains(@href, '#project-manager')]")).click();
        driver.findElement(By.xpath("//*[contains(@href, '#projects')]")).click();
        driver.findElement(By.xpath("//*[contains(@href, '#projects/new')]")).click();

        //Name
        driver.findElement(By.xpath("//*[contains(@name, 'name')]")).sendKeys("TestName");
        //Domain
        driver.findElement(By.xpath("//*[contains(@name, 'domain')]")).sendKeys("TestDomain");
        //Description
        driver.findElement(By.xpath("//*[contains(@name, 'description')]")).sendKeys("TestDescription");
        //Folder
        driver.findElement(By.id("s2id_autogen3_search")).click();
        //Sape account
        driver.findElement(By.xpath("//*[contains(@name, 'name')]")).sendKeys();

        driver.quit();
    }
}
