import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class FacebookSignUp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.gecko.driver", "C:\\Sel_Training\\geckodriver-v0.18.0-win64\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		
		driver.get("https://www.facebook.com/");
		
		driver.findElement(By.id("u_0_i")).sendKeys("Amarish");
		driver.findElement(By.id("u_0_h")).sendKeys("Pawar");
		driver.findElement(By.id("u_0_k")).sendKeys("2345678901");
		driver.findElement(By.id("u_0_r")).sendKeys("Sachin");
		
		Select dropdown1=new Select(driver.findElement(By.id("day")));
		dropdown1.selectByIndex(1);
		Select dropdown2=new Select(driver.findElement(By.id("month")));
		dropdown2.selectByValue("2");
		
		Select dropdown3=new Select(driver.findElement(By.id("year")));
		dropdown3.selectByVisibleText("1990");
		
		driver.findElements(By.name("sex")).get(1).click();
		
		//driver.findElement(By.id("u_0_4")).click();
		
		
		
		
		
		
		
		
				
				
		
		

	}

}
