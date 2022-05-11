package com.crm.practise;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateAccountGroupName {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("http://localhost:8888/index.php?action=Login&module=Users");
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@id='submitButton']")).click();
		driver.findElement(By.xpath("//a[@href='index.php?module=Contacts&action=index']")).click();
		driver.findElement(By.xpath("//img[@ src='themes/softed/images/btnL3Add.gif']")).click();
		
		driver.findElement(By.xpath("//input[@ name='lastname']")).sendKeys("sachin.21");
		driver.findElement(By.xpath("//input[@value='T']")).click();
		WebElement ele = driver.findElement(By.xpath("//select[@name='assigned_group_id']"));
		Select s=new Select(ele);
		s.selectByValue("4");
		driver.findElement(By.xpath("//input[@ title='Save [Alt+S]']")).click();
		
		WebElement ele1 = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
        Thread.sleep(2000);
        Actions act=new Actions(driver);
        act.moveToElement(ele1).perform();
        driver.findElement(By.xpath("//a[.='Sign Out']")).click();
        Thread.sleep(1000);
        driver.quit();
        

	}

}
