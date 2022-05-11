package com.crm.practise;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CalenderpPopUpAnyDate {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.makemytrip.com");
		Thread.sleep(2000);
		Actions act=new Actions(driver);
		act.moveByOffset(10,10).click().perform();
	    driver.findElement(By.xpath("//p[@data-cy='departureDate']")).click();
	    driver.findElement(By.xpath("//div[@aria-label='Sun Apr 24 2022']")).click();
	    Thread.sleep(2000);
	    driver.quit();
	   
	   
	}

}
