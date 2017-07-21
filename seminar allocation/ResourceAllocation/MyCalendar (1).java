package ResourceAllocation;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Observable;
import java.util.Observer;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class MyCalendar extends Observable implements Schedule{

	Workbook wrk1;
	Sheet sheet1;	
	DateFormat sdf;
	int DateRow;
	String fileloc;
	Date SlotDate;
	
	MyCalendar(String file) throws BiffException, IOException
	{
		sdf = new SimpleDateFormat("MM/dd/yy");
		fileloc = file;
		wrk1 =  Workbook.getWorkbook(new File(fileloc));		
		//Obtain the reference to the first sheet in the workbook
		sheet1 = wrk1.getSheet(0);
	}
	
	boolean amAvailable(String DateRequired, int slot) throws ParseException, BiffException, IOException
	{	
		boolean available = false;		
		SlotDate = sdf.parse(DateRequired);

		//Obtain reference to the Cell using getCell(int col, int row) method of sheet
		//Retrieve contents of a cell using getContents()
		for(int rows=1;rows<sheet1.getRows(); rows++)//Loops through the number of rows
		{			
			Date SheetDate = sdf.parse(sheet1.getCell(0,rows).getContents());
			if(SlotDate.equals(SheetDate) && sheet1.getCell(slot,rows).getContents()=="")
			{
				DateRow = rows;
				available = true;
			}
		}
		return available;
	}
	
	
	@Override
	public boolean availableSlots() throws ParseException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean reservedSlots() throws ParseException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean bookSlot(String DateRequired, int slot, String topic)
			throws ParseException, BiffException, IOException,
			RowsExceededException, WriteException {
		// TODO Auto-generated method stub
		if (amAvailable(DateRequired, slot))
		{			
			JavaExcelWrite.writeExcel(slot,DateRow,topic,fileloc);
			setChanged();
			notifyObservers();
			return true;
		}
		else 
		{
			return false;
		}	
	}
}
