package TESTCASES;

import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class lOGIN2 {
	WebDriver driver;
	@BeforeMethod
	public void start() {
		 driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
			driver.get("https://stagingapp.enalo.in/dashboard");
			driver.findElement(By.xpath("//button[@id='login-with-email-and-password']")).click();
	}
@Test
public void loginwithvalid() {
	

	
	driver.findElement(By.xpath("//input[@id='email']")).sendKeys("anilkumar5.marolix@gmail.com");
	driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Anilkumar@5");
	driver.findElement(By.xpath("//button[@id='submit-btn']")).click();
	Boolean name =driver.findElement(By.xpath("//div[text()='Lawforce']")).isDisplayed();
	System.out.println(name);
	Assert.assertTrue(name);
	
	}
@Test
public void loginwithinvalid() {
	

	driver.findElement(By.xpath("//input[@id='email']")).sendKeys("anilkumar5.marolix"+timestamp()+"@gmail.com");
	driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Anilkumar@51");
	driver.findElement(By.xpath("//button[@id='submit-btn']")).click();
String error=	driver.findElement(By.xpath("//span[contains(@class, 'ant-typography invalid-password-text text-danger')]")).getText();
	Assert.assertTrue(true, error);
	
	}
public String timestamp() {
	Date date = new Date();
	return date.toString().replace(" ","_").replace(":", "-").replace("-", "-");
	
}
@AfterMethod
public void teardown() {
	driver.quit();
}
}
