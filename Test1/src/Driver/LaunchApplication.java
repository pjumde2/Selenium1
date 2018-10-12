package Driver;


import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class LaunchApplication {
	public static WebDriver driver;

	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		
		ReadExcel Read=new ReadExcel();
		Read.readxls("C:\\Sel_Training\\Data.xls");
		
		

	}

	public void initialise(String Browsername) {
		// TODO Auto-generated method stub
		
		System.out.println("Browser is: "+Browsername);
		if(Browsername.equalsIgnoreCase("InternetExplorer"))
		{
			System.setProperty("webdriver.ie.driver", 
					"C://IEDriverServer64.exe");
			driver=new InternetExplorerDriver();
		}
		else
			if(Browsername.equals("Firefox"))
			{
				System.setProperty("webdriver.gecko.driver", "C:\\Sel_Training\\geckodriver-v0.18.0-win64\\geckodriver.exe");
				driver = new FirefoxDriver();
				
			}
		
		
	}

	public void reflection()  {
		// TODO Auto-generated method stub
		String classname = "Facebook";
		String Methodname = "facebook";
		try {
						
			Class cls = java.lang.Class.forName("scripts."+classname);
			Object obj=cls.newInstance();
			Method method=cls.getDeclaredMethod(Methodname);
			method.invoke(obj);
			
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		

		
		
	}

	
}
