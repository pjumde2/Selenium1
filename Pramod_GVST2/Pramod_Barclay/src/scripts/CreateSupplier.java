package scripts;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;




import commonclasses.PropertyRead;
import commonclasses.TakeScreenShot;
import Driver.LaunchApplication;
import Driver.ReadExcel;

public class CreateSupplier extends LaunchApplication {
	
	public static String Createsupplier(HashMap<String, String> hm)
	{
		
		try{
			
			System.out.println("You are in Create Supplier");
			System.out.println("values in HashMap: "+hm);
			String ActualResult="";
			String ExpectedResult="";
			String TestCaseId=hm.get("TC_ID").toString();
			String TestCaseDesc=hm.get("TC_Desc").toString();
			String classname=hm.get("ClassName").toString();
			String return_result=null;	
			String screenshot="CreateSupplier";
			screenshot=screenshot+TestCaseId;
			
			driver.get(PropertyRead.TestURL);
			driver.manage().timeouts().implicitlyWait(05, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			
			driver.findElement(By.id("element_button_3")).click();
			driver.findElement(By.id("grid_column_7_clps_div")).click();
			
						
			driver.findElement(By.xpath("//p[.='Manage Suppliers']")).click();
			
			driver.findElement(By.xpath("//div[@id='page-body_undefined']/div/div[3]//div[@id='grid_column_6_clps_div']")).click();
			
			driver.findElement(By.id("supplierNameID")).sendKeys(hm.get("Supplier_Name"));
			driver.findElement(By.id("tradingNameID")).sendKeys(hm.get("Trading_Name"));
			driver.findElement(By.id("sortCodeID")).sendKeys(hm.get("Sort_Code"));
			driver.findElement(By.id("accNoID")).sendKeys(hm.get("Account_Number"));
			driver.findElement(By.id("emailID")).sendKeys(hm.get("Email"));
			driver.findElement(By.id("createSuppAttestID")).click();
			driver.findElement(By.id("element_button_2")).click();
		
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
			
			
			//List<WebElement> listOfLiElements = driver.findElements(By.xpath("//*[@id='ContentDivId_col_div']"));
			
		/*	
			List<WebElement> listOfLiElements = driver.findElements(By.xpath("//*[@id='fgp_container_list_3_row_0']"));
				//	findElement();
			
		//	element.click();
			for(int i=0; i< listOfLiElements.size(); i++){
				//listOfLiElements.get(i).click();
				if(listOfLiElements.get(i).getText().equalsIgnoreCase("Manage Suppliers")){
					listOfLiElements.get(i).findElement(By.xpath("//p[.='Manage Suppliers']")).click();;
				//	listOfLiElements.get(i).click();	
					break;
				}
				http://localhost:8080/Gvst/
				*/
		/*	for(int i=0; i< listOfLiElements.size(); i++){
				//listOfLiElements.get(i).click();
				if(listOfLiElements.get(i).getText().equalsIgnoreCase("Manage Markets")){
					listOfLiElements.get(i).findElement(By.id("element_label_18"));
					listOfLiElements.get(i).click();	
					break;
				}*/
				
			/*	
				if(listOfLiElements.get(i).findElement(By.id("element_label_17")).getText() == "Manage Suppliers")
				     {
				      WebElement correctElement = listOfLiElements.get(i).findElement(By.id("element_label_17"));
				      //i =listOfLiElements.;
				      correctElement.click();
				      System.out.println("done");
				     }*/
			//	 }
			
			//*[@id="element_label_17"]// id("fgp_container_list_3_row_0"))/By.className("alist")
			
			
			
			
		}catch(Exception e)
		
		{
			System.out.println(e.getMessage());
		}
		
				return null;
		
		
	}

}
