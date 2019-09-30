package test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class LargestValue {

	

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		FileInputStream input=new FileInputStream("C://Largest.xls");
		int rownr=0, colnr = 0;
		int maxValuve =0;
		HSSFWorkbook wb = new HSSFWorkbook(input);
		HSSFSheet sheet = wb.getSheetAt(0);
		
		int array[] = new int[sheet.getLastRowNum()];
		for (int i =1; i<= sheet.getLastRowNum();i++)
		{
			HSSFRow row=sheet.getRow(i);
			HSSFCell cell=row.getCell(colnr);
			array[i-1]=  (int) cell.getNumericCellValue();
			

		}
		
		maxValuve = sortDesecding(array,sheet.getLastRowNum());
		
		System.out.println("Max value is: " +maxValuve);
		
	}
	
	
	private static int sortDesecding(int[] array, int n) {
		int c, d, swap;
		for (c = 0; c < ( n - 1 ); c++) {
			for (d = 0; d < n - c - 1; d++) {
				if (array[d] < array[d+1]) /* For ascending order use > */
				{
					swap       = array[d];
					array[d]   = array[d+1];
					array[d+1] = swap;
				}
			}
		}
		return array[0];
	}

}
