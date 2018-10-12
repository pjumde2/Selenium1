import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Practise1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Java");
		
		System.setProperty("webdriver.gecko.driver", "C:\\Sel_Training\\geckodriver-v0.18.0-win64\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		
		driver.get("https://www.facebook.com/");
		
		driver.findElement(By.id("email")).sendKeys("jumde.pramod82@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("19820816");
		driver.findElement(By.id("loginbutton")).click();
			

	}
	

}
