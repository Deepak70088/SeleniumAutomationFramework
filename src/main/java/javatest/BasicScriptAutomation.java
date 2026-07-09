package javatest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicScriptAutomation {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("https://admin-demo.nopcommerce.com/login");
		driver.manage().window().maximize();
		String title = driver.getTitle();
		System.out.println(title);
		driver.findElement(By.xpath(".//input[@type='email']")).clear();
		driver.findElement(By.xpath(".//input[@type='email']")).sendKeys("deepak.kumar@e2open.com");
		driver.findElement(By.xpath(".//*[@id='Password']")).clear();
		driver.findElement(By.xpath(".//*[@id='Password']")).sendKeys("Pass@123");
		driver.findElement(By.xpath(".//*[text()='Log in']")).click();
		//driver.close();
	}

}
