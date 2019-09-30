package BJet;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class launchApp {
	
	//public static WebDriver driver;
	
	
	
	@Test
	public static void Launch (){
	

	try{

		System.out.println("In Launch Application");
		
		System.setProperty("webdriver.gecko.driver", "C:\\Selenium Jars\\Selenium 3.4\\geckodriver-v0.16.0-win64\\geckodriver.exe");
		WebDriver	driver = new FirefoxDriver();
			
	}catch(Exception e)
	{
		System.out.println(e.getMessage());
	}
		
	}
	

}
