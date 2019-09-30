package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GVST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		//System.setProperty("webdriver.chrome.driver", 
		//		"C://chromedriver.exe");
		//WebDriver driver=new ChromeDriver();
		WebDriver driver=new FirefoxDriver();
		driver.get("file:///C:/Users/IBM_ADMIN/Desktop/app/app/screens/appzillonfirstpage.html");
		driver.findElement(By.id("element_inputbox_1")).sendKeys("ASD");
		driver.findElement(By.id("element_inputbox_2")).sendKeys("123");
		driver.findElement(By.id("element_button_1")).click();
		
			}

}
