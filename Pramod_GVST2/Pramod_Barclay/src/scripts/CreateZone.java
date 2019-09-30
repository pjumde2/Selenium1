package scripts;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import commonclasses.PropertyRead;
import commonclasses.TakeScreenShot;
import Driver.LaunchApplication;
import Driver.ReadExcel;

public class CreateZone extends LaunchApplication {
	
	public static String Createzone(HashMap<String, String> hm)
	{
		
	
     try{
			
			
			System.out.println("values in HashMap: "+hm);
			String ActualResult="";
			String ExpectedResult="";
			String TestCaseId=hm.get("TC_ID").toString();
			String TestCaseDesc=hm.get("TC_Desc").toString();
			String classname=hm.get("ClassName").toString();
			String return_result=null;	
			String screenshot="CreateZone";
			screenshot=screenshot+TestCaseId;
			
			driver.get(PropertyRead.TestURL);
			driver.manage().timeouts().implicitlyWait(05, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			
			driver.findElement(By.id("element_button_3")).click();
			driver.findElement(By.id("grid_column_7_clps_div")).click();
			
				driver.findElement(By.xpath("//*[@id='element_label_20']")).click();		
			//driver.findElement(By.xpath("//p[.='Manage Suppliers']")).click();
			
			Select market = new Select(driver.findElement(By.id("allMarketsZoneId")));
			market.selectByVisibleText(hm.get("Markets"));
			
			driver.findElement(By.xpath("//*[@id='grid_column_4_clsp_anchor']")).click();
			
			driver.findElement(By.id("insertZone__zoneName")).sendKeys(hm.get("Zone_Name"));		
			
			driver.findElement(By.id("element_button_2")).click();
			
		
			ExpectedResult="A new Zone has been created";
			ActualResult=driver.findElement(By.xpath("//*[@id='grid_column_10_seccol_mdl_div']")).getText();
			
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

	
