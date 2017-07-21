package ResourceAllocation;

import java.io.File;
import java.io.IOException;
import java.text.*;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.*;
import jxl.write.biff.RowsExceededException;


public class QEEE implements Facilities
{
	private static QEEE qeee;
	String myFileLoc = "C:\\Users\\Sheshu\\test.xls";
	private static MyCalendar mycal;
	private QEEE() throws BiffException, IOException 
	{
		System.out.println("entered private constructor... sending file loc to my calendar");
		mycal = new MyCalendar(myFileLoc);
	}

	public static QEEE getInstance() throws ParseException, BiffException, IOException
	{
		if(qeee==null)
		{
			System.out.println("QEEE is null...giving new qeee");
			qeee = new QEEE();
		}			
		return qeee;
	}
	
	String fileName()
	{
		return myFileLoc;
	}
	public MyCalendar getMyCal()
	{
		return mycal;
	}

	@Override
	public String[] audioSystem() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean podiumAvailability() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String projectorType() {
		// TODO Auto-generated method stub
		return null;
	}
}














/*public class QEEE extends Almanac implements Schedule{

	private static QEEE qeee;
	Workbook wrk1;
	Sheet sheet1;
	int row;
	DateFormat sdf;

	private QEEE() throws ParseException, BiffException, IOException
	{
		sdf = new SimpleDateFormat("MM/dd/yy");
		wrk1 =  Workbook.getWorkbook(new File("E:/test.xls"));		
		//Obtain the reference to the first sheet in the workbook
		sheet1 = wrk1.getSheet(0);
	}

	public static QEEE getInstance() throws ParseException, BiffException, IOException
	{
		if(qeee==null)
		{
			qeee = new QEEE();
		}			
		return qeee;
	}

	boolean isAvailable(String DateRequired, int slot) throws ParseException, BiffException, IOException
	{	
		boolean available = false;		
		Date SlotDate = sdf.parse(DateRequired);

		//Obtain reference to the Cell using getCell(int col, int row) method of sheet
		//Retrieve contents of a cell using getContents()
		for(int rows=1;rows<sheet1.getRows(); rows++)//Loops through the number of rows
		{			
			Date SheetDate = sdf.parse(sheet1.getCell(0,rows).getContents());
			if(SlotDate.equals(SheetDate) && sheet1.getCell(slot,rows).getContents()=="")
			{
				row = rows;
				available = true;
			}
		}
		return available;
	}

	@Override
	public boolean availableSlots() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean reservedSlots() {
		// TODO Auto-generated method stub
		return false;
	}

	/*private int dateDiff(String StartDate, String EndDate) throws ParseException
	{		
		Date SemStartDate = sdf.parse(StartDate);
		Date SemEndDate = sdf.parse(EndDate);

		long diff_time = SemEndDate.getTime() - SemStartDate.getTime();

		int diffDays = (int) diff_time / (24 * 60 * 60 * 1000);

		return diffDays;
	}*/


/*	public boolean bookSlot(String DateRequired, int slot, String topic) throws ParseException, BiffException, IOException, RowsExceededException, WriteException{	
		// TODO Auto-generated method stub
		
		//int slotIndex = dateDiff(SemStart, DateRequired);
		if (isAvailable(DateRequired, slot))
		{			
			JavaExcelWrite.writeExcel(slot,row,topic);
			return true;
		}
		else 
		{
			return false;
		}
	}
}*/
