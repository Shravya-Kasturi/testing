package ResourceAllocation;
import java.io.File;

import java.io.IOException;

import jxl.*;
import jxl.read.biff.BiffException;
import jxl.write.*;
import jxl.write.biff.RowsExceededException;
public class JavaExcelWrite {

	public static void writeExcel(int col, int row, String args, String file) throws BiffException, IOException, RowsExceededException, WriteException {
		// TODO Auto-generated method stub
		System.out.println("entered write excel");
		Workbook existingWorkbook = Workbook.getWorkbook(new File(file));
		System.out.println("after getting existing wrkbook");
		WritableWorkbook workbookCopy = Workbook.createWorkbook(new File(file), existingWorkbook);
		
		existingWorkbook.close();
		
		WritableSheet sheetToEdit = workbookCopy.getSheet(0);
		WritableCell cell;
		Label l = new Label(col, row, args);
		cell = (WritableCell) l;
		sheetToEdit.addCell(cell);
		System.out.println(cell.getContents());
		 workbookCopy.write();
		 workbookCopy.close();
		 existingWorkbook.close();
	}

}
