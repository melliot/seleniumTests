package com.uitest.ss.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class HomeWork {
    WebDriver driver = new FirefoxDriver();

    @Test
    public void countFriends() throws InterruptedException {

        driver.get("http://vk.com");
        driver.findElement(By.xpath("//*[@id='quick_email']")).sendKeys("alex.bezkorovainy@gmail.com");
        driver.findElement(By.xpath("//*[@id='quick_pass']")).sendKeys("xxxxx");
        driver.findElement(By.xpath("//*[@id='quick_login_button']")).click();
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);

        driver.findElement(By.xpath(".//*[@id='l_fr']/a/span[2]")).click();
        Thread.sleep(1000);
        JavascriptExecutor jsx = (JavascriptExecutor) driver;
        jsx.executeScript("window.scrollToY(20000)");
        Thread.sleep(1000);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        Set<String> setUsers = new HashSet<String>();
        Set<String> setFriends = new HashSet<String>();
        String url;
        Object[] arr;
        int counter = 0;

        int count = driver.findElements(By.xpath("//a[@class='friends_act' and contains(text(), 'Browse friends')]")).size();

        for (int i = 0; i < count; i++) {
            url = driver.findElements(By.xpath("//a[@class='friends_act' and contains(text(), 'Browse friends')]")).get(i).getAttribute("href");
            setUsers.add(url);
//            System.out.println(url);
        }


        arr = setUsers.toArray();
        while (counter < arr.length) {


            driver.get((String) arr[counter]);

            jsx.executeScript("window.scrollToY(20000000)");
            Thread.sleep(1000);

            count = driver.findElements(By.xpath("//a[@class='friends_act' and contains(text(), 'Browse friends')]")).size();

            if (driver.findElement(By.xpath("//*[@id='msg_back_button']")).isDisplayed()) {
                continue;
            } else {
                for (int i = 0; i < count; i++) {

                    url = driver.findElements(By.xpath("//a[@class='friends_act' and contains(text(), 'Browse friends')]")).get(i).getAttribute("href");

                    setFriends.add(url);

//                    System.out.println(url);
                }

                System.out.println(setFriends.size());
            }
            counter++;
        }
            System.out.println(setFriends.size());

            System.out.println("########################");

            driver.quit();

    }

}