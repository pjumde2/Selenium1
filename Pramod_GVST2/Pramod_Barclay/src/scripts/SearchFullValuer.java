package scripts;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import commonclasses.PropertyRead;
import commonclasses.TakeScreenShot;
import Driver.LaunchApplication;
import Driver.ReadExcel;

public class SearchFullValuer extends LaunchApplication {
	
	public static String Searchfullvaluer(HashMap<String, String> hm)
	{
		
    try{
			
			System.out.println("values in HashMap: "+hm);
			String ActualResult="";
			String ExpectedResult="";
			String TestCaseId=hm.get("TC_ID").toString();
			String TestCaseDesc=hm.get("TC_Desc").toString();
			String classname=hm.get("ClassName").toString();
			String return_result=null;	
			String screenshot="SearchFullValuer";
			screenshot=screenshot+TestCaseId;
			
			driver.get(PropertyRead.TestURL);
			driver.manage().timeouts().implicitlyWait(05, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			driver.findElement(By.id("element_button_3")).click();
			driver.findElement(By.id("grid_column_5_clsp_anchor")).click();
			
			driver.findElement(By.xpath("//*[@id='element_label_4']")).click();
			driver.findElement(By.id("element_button_2")).click();
			driver.findElement(By.xpath("//div[@id='page-body_undefined']/div/div[4]/div/div[1]//div[@id='grid_column_6_clps_div']")).click();
			Select property = new Select(driver.findElement(By.id("searchPropertyID")));
			property.selectByVisibleText(hm.get("Property_Type"));
			
			Select market = new Select(driver.findElement(By.id("searchMarketID")));
			market.selectByVisibleText(hm.get("Market"));
			
			Select location = new Select(driver.findElement(By.id("searchLocationID")));
			location.selectByVisibleText(hm.get("Location"));
			
			driver.findElement(By.id("cNameID")).sendKeys(hm.get("Customer_Name"));
			driver.findElement(By.id("addressId")).sendKeys(hm.get("Property_Address"));
			driver.findElement(By.id("valuationAmountId")).sendKeys(hm.get("Val_Amount"));
			driver.findElement(By.id("SubmitID")).click();
			
			driver.findElement(By.xpath("//*[@id='valuationTypeAlertIdOkBtn']")).click();
			
		    
		    ExpectedResult = "Alert: This search must be exported to create and audit trail records on the GVST.";
		    ActualResult= driver.findElement(By.xpath("//*[@id='fgp_container_table_1_table']/thead/tr[1]/th")).getText();
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
