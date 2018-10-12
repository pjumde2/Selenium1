package Common;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyRead {
	
	public static String Browsername="";
	public static String TestURL="";
	
	

	public static   String ReadProperty() {
		// TODO Auto-generated method stub
		
		Properties prop=new Properties();
		InputStream input=null;
		String arr[];
		
		try {

			input = new FileInputStream("Config.Properties");
			//String arr[];

			// load a properties file
			prop.load(input);

			// get the property value and print it out
			Browsername =prop.getProperty("browser");
			TestURL=prop.getProperty("URL");
			System.out.println("Browsername : "+Browsername);
			System.out.println("Test URL is: " +TestURL);
		 // arr[]= new String[] {Browsername,TestURL};
		//  System.out.println("Values in Array: "+ arr[1]);

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		return Browsername;
	}
	

}
