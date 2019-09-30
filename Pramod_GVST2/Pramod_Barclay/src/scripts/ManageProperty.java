package scripts;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import commonclasses.PropertyRead;
import commonclasses.TakeScreenShot;
import Driver.LaunchApplication;
import Driver.ReadExcel;

public class ManageProperty extends LaunchApplication{
	
	public static String Manageproperty(HashMap<String, String> hm)
	{
		
     try{			
			
			System.out.println("values in HashMap: "+hm);
			String ActualResult="";
			String ExpectedResult="";
			String TestCaseId=hm.get("TC_ID").toString();
			String TestCaseDesc=hm.get("TC_Desc").toString();
			String classname=hm.get("ClassName").toString();
			String return_result=null;	
			String screenshot="ManageProperty";
			screenshot=screenshot+TestCaseId;
			
			driver.get(PropertyRead.TestURL);
			driver.manage().timeouts().implicitlyWait(05, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			
			driver.findElement(By.id("element_button_3")).click();
			driver.findElement(By.id("grid_column_7_clps_div")).click();
			
				driver.findElement(By.xpath("//*[@id='element_label_21']")).click();		
			//driver.findElement(By.xpath("//p[.='Manage Suppliers']")).click();
			
				Select market = new Select(driver.findElement(By.id("ptMarketID")));
				market.selectByVisibleText(hm.get("Markets"));
				
				Select property = new Select(driver.findElement(By.id("ptPropertyID")));
				property.selectByVisibleText(hm.get("Property_Type"));
			    
		        driver.findElement(By.id("piiMultiplier__piiMultiplier")).sendKeys(hm.get("PI_Multiplier"));
		        driver.findElement(By.id("piiMultiplier__tradeRelatedEligibility")).click();
		        driver.findElement(By.id("element_button_1")).click();
		               
						        
		        
		        
			ExpectedResult="A new Supplier has been created";
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
