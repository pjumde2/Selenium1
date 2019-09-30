package Driver;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class LaunchApplication {

	public static String Sheetname;
	public static WebDriver driver;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		commonclasses.Create_Report_Excel createExl = new commonclasses.Create_Report_Excel();
		createExl.Excel_Report_Generation();
		ReadExcel read=new ReadExcel();
		read.Readxls("TestSuite", "C://Pramod_IBM//DataSheet.xls");
	}
	
	

	public void initialise(String browsername) {
		// TODO Auto-generated method stub
		if(browsername.equalsIgnoreCase("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", 
					"C://chromedriver.exe");
			driver=new ChromeDriver();
		}
		else
			if(browsername.equalsIgnoreCase("InternetExplorer"))
			{
				System.setProperty("webdriver.ie.driver", 
						"C://IEDriverServer64.exe");
				driver=new InternetExplorerDriver();
			}

	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void callclass(String classname,String Methodname, HashMap<String, String> hm) throws NoSuchMethodException, SecurityException {
		// TODO Auto-generated method stub

		//String parameter
		Class[] paramHashMap = new Class[1];
		//Class[] paramString = new Class[1];
		paramHashMap[0] = HashMap.class;
	//	paramHashMap[1] = String.class;


		try {
			System.out.println("In callclass");
			Class cls = java.lang.Class.forName("scripts."+classname);
			System.out.println("Methodname: "+Methodname);
			//Class Class=Class.forName("scripts."+classname);
			try {
				Object obj=cls.newInstance();
				//			Class[] Types=new Class[] {HashMap.class, String.class, String.class };
				Method method=cls.getDeclaredMethod(Methodname, paramHashMap);

				//call the printItInt method, pass a int param
				try {
					System.out.println("About to invoke method");
					method.invoke(obj, hm);

					//	Object status=method.invoke(o,hm);
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
