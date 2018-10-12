import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class GmailSignUp {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.gecko.driver", "C:\\Sel_Training\\geckodriver-v0.18.0-win64\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		
		driver.get("https://accounts.google.com/signin/v2/identifier?service=mail&passive=true&rm=false&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&ss=1&scc=1&ltmpl=default&ltmplcache=2&emr=1&osid=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin");
		driver.findElement(By.xpath("//*[@id='view_container']/form/div[2]/div/div[2]/div[2]/div")).click();
		Thread.sleep(500);
		driver.findElement(By.className("AIu8h")).click();
		Thread.sleep(3000);
		driver.findElement(By.name("FirstName")).sendKeys("Ajay");
		driver.findElement(By.name("LastName")).sendKeys("Puri");
		driver.findElement(By.name("GmailAddress")).sendKeys("Wakad345");
		driver.findElement(By.name("Passwd")).sendKeys("wakadby987");
		driver.findElement(By.name("PasswdAgain")).sendKeys("wakadby987");
		//Thread.sleep(2000);
		driver.findElement(By.id("BirthMonth")).click();
		driver.findElement(By.id(":3")).click();

		driver.findElement(By.id("BirthDay")).sendKeys("5");
		driver.findElement(By.id("BirthYear")).sendKeys("1990");
		
		driver.findElement(By.id("Gender")).click();
		driver.findElement(By.id(":f")).click();
		driver.findElement(By.name("RecoveryPhoneNumber")).clear();
	//	driver.findElement(By.id("RecoveryPhoneNumberLabel")).clear();
		driver.findElement(By.id("RecoveryPhoneNumberLabel")).sendKeys("3456784321");
		driver.findElement(By.name("RecoveryEmailAddress")).sendKeys("abc@gmail.com");
		driver.findElement(By.id("CountryCode")).click();
		driver.findElement(By.id(":l")).click();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
