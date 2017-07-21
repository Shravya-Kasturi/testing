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
		Workbook existingWorkbook = Workbook.getWorkbook(new File(file));
		WritableWorkbook workbookCopy = Workbook.createWorkbook(new File(file), existingWorkbook);
		WritableSheet sheetToEdit = workbookCopy.getSheet(0);
		WritableCell cell;
		Label l = new Label(col, row, args);
		cell = (WritableCell) l;
		sheetToEdit.addCell(cell);
		 workbookCopy.write();
		 workbookCopy.close();
		 existingWorkbook.close();
	}

}
