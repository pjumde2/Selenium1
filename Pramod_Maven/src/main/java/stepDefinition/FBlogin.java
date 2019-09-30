package stepDefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class FBlogin {
	
	public static WebDriver driver=null;
	 
	@Given("^I open facebook website$")
	public void i_open_website() {
		System.setProperty("webdriver.gecko.driver", "C:\\Sel_Training\\geckodriver-v0.18.0-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
	    driver.get("http://thedemosite.co.uk/login.php");
	}

	@When("^I enter valid \"([^\"]*)\" and valid \"([^\"]*)\"$")
	public void i_enter_valid_and_valid(String username, String password) {
	    
		Timeouts timeouts = driver.manage().timeouts();
		 //Here we look at pageloadTimeout. By default pageload is infinite
		 timeouts.pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.findElement(By.name("username")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
	}
	
	@And("^I click on TestLogin button$")
	public void i_click_on_TestLogin_button() throws Throwable {
	   driver.findElement(By.name("FormsButton2")).click();
	}
	
	
	@Then("^I see facebook page$")
	public void user_enters_facebook_page() {
	    
		Timeouts timeouts = driver.manage().timeouts();
		 //Here we look at pageloadTimeout. By default pageload is infinite
		 timeouts.pageLoadTimeout(30, TimeUnit.SECONDS);
		
	}

}
