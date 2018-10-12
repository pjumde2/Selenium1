package Driver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.NullPointerException;
import java.lang.reflect.Method;
import java.lang.reflect.Method;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import Common.PropertyRead;

public class ReadExcel {

	public void readxls(String Filepath) {
		// TODO Auto-generated method stub
		try {
			
		
		FileInputStream File= new FileInputStream(Filepath);
		HSSFWorkbook wb=new HSSFWorkbook(File);
		HSSFSheet sheet=wb.getSheet("Sheet1");
		HSSFRow Row=sheet.getRow(0);
		int rows=sheet.getPhysicalNumberOfRows();
		System.out.println("Rows are: "+rows);
		int columns=Row.getPhysicalNumberOfCells();
		System.out.println("Columns are: "+columns);
		
		for(int i=0;i<=rows;i++)
		{
			for(int j=0;j<columns;j++)
			{
				HSSFRow Row1=sheet.getRow(i);
				System.out.println(Row1.getCell(j));
				
				
			}
			break;
		}
		
		String Browsername1="";
		Browsername1=PropertyRead.ReadProperty();
		
		LaunchApplication LA=new LaunchApplication();
		LA.initialise(Browsername1);
		LA.reflection();
		
				

		
		
	}
		catch(Exception e)
		{
			System.out.println(e);
		}

				
}
	
	
}
