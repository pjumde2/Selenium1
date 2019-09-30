package scripts;


import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import commonclasses.PropertyRead;
import commonclasses.TakeScreenShot;
import Driver.LaunchApplication;
import Driver.ReadExcel;

public class Login extends LaunchApplication  {
	
	
	public static String login(HashMap<String, String> hm)
	{
		try{
			System.out.println("In the Login Script");
			
			System.out.println("values in HashMap: "+hm);
			String ActualResult="";
			String ExpectedResult="";
			String TestCaseId=hm.get("TC_ID").toString();
			String TestCaseDesc=hm.get("TC_Desc").toString();
			String classname=hm.get("ClassName").toString();
			String return_result=null;	
			String screenshot="Login";
			screenshot=screenshot+TestCaseId;
		
			driver.get(PropertyRead.TestURL);
			driver.manage().window().maximize();
			driver.findElement(By.className("sign-in")).click();
			String myWindowHandle=driver.getWindowHandle();
			driver.switchTo().window(myWindowHandle);
			driver.findElement(By.id(locators.Login.username)).sendKeys(hm.get("Username"));
			driver.findElement(By.id(locators.Login.password)).sendKeys(hm.get("Password"));
			driver.findElement(By.name(locators.Login.button)).click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			/*driver.get("Facebook.com");
			driver.findElement(By.id(locators.Login.username)).sendKeys(hm.get("Username").toString());
			driver.findElement(locators.Login.password).sendKeys(hm.get("Password").toString());
			driver.findElement(By.id("u_0_m")).click();*/
			ExpectedResult="Quikr";
			ActualResult=driver.getPageSource();
			System.out.println("Actual Result is: "+ActualResult);
			
			if(ActualResult.contains(ExpectedResult))
			{
				return_result="Pass"+","+TestCaseId+","+TestCaseDesc;
				
				System.out.println("Return Result is: "+return_result);
				TakeScreenShot.TakecreenShotMethod(screenshot);
				ReadExcel.Excel_Report_Generation(classname, return_result);
			}
			
			else
			{
				return_result="Fail"+","+TestCaseId+","+TestCaseDesc;
				System.out.println("Return Result is: "+return_result);
				TakeScreenShot.TakecreenShotMethod(screenshot);
				ReadExcel.Excel_Report_Generation(classname, return_result);
			}
			
			//driver.close();
			
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return null;
		
	}

}
