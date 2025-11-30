package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://automationexercise.com/");
driver.findElement(By.linkText("Signup / Login")).click();
driver.findElement(By.xpath("//input[@data-qa='login-email']")).sendKeys("NERVAN@II.com");
        driver.findElement(By.xpath("//input[@data-qa='login-password']")).sendKeys("123456");
        driver.findElement(By.xpath("//button[@data-qa='login-button']")).click();
    }
}