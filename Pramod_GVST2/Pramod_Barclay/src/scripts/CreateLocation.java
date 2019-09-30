package scripts;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import commonclasses.PropertyRead;
import commonclasses.TakeScreenShot;
import Driver.LaunchApplication;
import Driver.ReadExcel;

public class CreateLocation extends LaunchApplication {
	
	public static String Createlocation(HashMap<String, String>hm)
	{
		
		try{
			
			System.out.println("You are in Create Location");
			
			System.out.println("values in HashMap: "+hm);
			String ActualResult="";
			String ExpectedResult="";
			String TestCaseId=hm.get("TC_ID").toString();
			String TestCaseDesc=hm.get("TC_Desc").toString();
			String classname=hm.get("ClassName").toString();
			String return_result=null;	
			String screenshot="CreateLocation";
			screenshot=screenshot+TestCaseId;
			
			
			driver.get(PropertyRead.TestURL);
			driver.manage().timeouts().implicitlyWait(05, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			driver.findElement(By.id("element_button_3")).click();
			driver.findElement(By.id("grid_column_7_clps_div")).click();
			
			driver.findElement(By.xpath("//p[.='Manage Zones']")).click();
			
			Select dropdown = new Select(driver.findElement(By.id("allMarketsIdLocation")));
			dropdown.selectByVisibleText(hm.get("Markets"));
			
			driver.findElement(By.xpath("//div[@id='page-body_undefined']/div/div[3]//div[@id='grid_column_5_clps_div']")).click();
			
			
			driver.findElement(By.id("insertLocation__locationName")).sendKeys(hm.get("Location_Name"));
			
			
			driver.findElement(By.id("element_button_1")).click();
			
			System.out.println("Open Alert");
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			
			ExpectedResult = "A new Location for the Market Channel has been created";
			
		    ActualResult=driver.findElement(By.xpath("//div[@id='grid_column_13_seccol_mdl_div']")).getText();
			System.out.println("Message is:"+ActualResult);
			
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
			
						
			
			
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return null;
		
	}

}
