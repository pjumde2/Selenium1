package scripts;

import java.util.HashMap;

import Driver.LaunchApplication;

public class Facebook extends LaunchApplication {
	
	public static String facebook()
	{
		try {
			
			System.out.println("Hello Pramod");
			driver.get("https://www.facebook.com/");
			
			
			
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		
		
		return null;
		
	}

}
