package test;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class HighestValue {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {

		String coulumnName = "Values";
		int maxNum=0;

		FileInputStream input=new FileInputStream("C://Value.xls");

		HSSFWorkbook wb = new HSSFWorkbook(input);
		HSSFSheet sheet = wb.getSheetAt(0);

		maxNum = findRow(sheet, coulumnName);
		System.out.println("max number:" +maxNum);

	}

	private static int findRow(HSSFSheet sheet, String cellContent){

		int maxValue = 0; 

		for(Row row : sheet) {
			for(Cell cell : row) {

				while(cell.getCellType() == Cell.CELL_TYPE_STRING){
					if(cell.getStringCellValue().equalsIgnoreCase(cellContent)){

						maxValue= maxValueCalculate(sheet, cell.getColumnIndex());
						break;
					}
				}
			}
		}               
		return maxValue;
	}

	private static int maxValueCalculate(HSSFSheet sheet, int columnIndex) {
		int maxValuve =0;
		int array[] = new int[sheet.getLastRowNum()];
		for (int i =1; i<= sheet.getLastRowNum();i++)
		{
			HSSFRow row=sheet.getRow(i);
			HSSFCell cell = row.getCell(columnIndex);													

			array[i-1]= (int) cell.getNumericCellValue();
		}
		maxValuve = sortDesecding(array,sheet.getLastRowNum());
		return maxValuve;
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
