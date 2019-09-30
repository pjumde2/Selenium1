package scripts;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import commonclasses.PropertyRead;
import commonclasses.TakeScreenShot;
import Driver.LaunchApplication;
import Driver.ReadExcel;

public class EditLocation extends LaunchApplication {

	public static String Editlocation(HashMap<String, String>hm)
	{
		try{
			
			System.out.println("values in HashMap: "+hm);
			String ActualResult="";
			String ExpectedResult="";
			String TestCaseId=hm.get("TC_ID").toString();
			String TestCaseDesc=hm.get("TC_Desc").toString();
			String classname=hm.get("ClassName").toString();
			String return_result=null;	
			String screenshot="EditLocation";
			screenshot=screenshot+TestCaseId;
			
			driver.get(PropertyRead.TestURL);
			driver.manage().timeouts().implicitlyWait(05, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			
			driver.findElement(By.id("element_button_3")).click();
			driver.findElement(By.id("grid_column_7_clps_div")).click();
			
			driver.findElement(By.xpath("//p[.='Manage Locations']")).click();
			
			Select market = new Select(driver.findElement(By.id("allMarketsIdLocation")));
			market.selectByVisibleText(hm.get("Markets"));
			
			Select location=new Select(driver.findElement(By.id("allMarketsLocationsId")));
			location.selectByVisibleText(hm.get("Location_Name"));
			
			driver.findElement(By.xpath("//*[@id='grid_column_8_clsp_anchor']")).click();
			
			driver.findElement(By.id("updateLocation__locationName")).clear();
			driver.findElement(By.id("updateLocation__locationName")).sendKeys(hm.get("Edit_Location_Name"));
			driver.findElement(By.id("element_button_2")).click();
			
			ExpectedResult="The Location for the Market Channel has been updated";
			ActualResult=driver.findElement(By.xpath(".//*[@id='grid_column_13_seccol_mdl_div']")).getText();
			System.out.println("Actual Result is: "+ActualResult );
			
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
