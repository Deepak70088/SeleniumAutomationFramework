package javatest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstTestSelenium {

	public static void main(String[] args) throws InterruptedException {
	
		WebDriver driver = new ChromeDriver();

        driver.get("https://selenium.dev");
        driver.manage().window().maximize();
        Thread.sleep(1000);
        driver.quit();
	}
	
} 
