package ResourceAllocation;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.*;
import jxl.Workbook;
import jxl.Sheet;
import jxl.read.biff.BiffException;
import jxl.write.*;

import jxl.write.biff.RowsExceededException;

public class Faculty implements Runnable, Observer{

	String Name, Course, Date;
    static int count=1;
	int slot;
	Thread t;
	Scanner scan;
	QEEE q;
	Workbook wrb;
    Sheet ww;
    WritableWorkbook w2;
	static LinkedHashMap<Faculty, Date> whobookedtheresource;
	File tempFile=new File("C:\\Users\\Sheshu\\Template.xls");
	Faculty(String Name, String Course) throws IOException, BiffException
	{
		
		this.Name = Name;
		this.Course = Course;
		scan = new Scanner(System.in);
		t = new Thread(this,Name);
		whobookedtheresource = new LinkedHashMap<Faculty, Date>();
		Workbook w1 = Workbook.getWorkbook(new File("ExistingDocument.xls"));

		 w2 = Workbook.createWorkbook(new File(Name+".xls"));
		
		w1.close();
		t.start();    
	}

	public void run()
	{			
		//System.out.println("Are your willing to book QEEE?.... Y or N");
		try {
			q = QEEE.getInstance();	
			
		} catch (BiffException | ParseException | IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
	
	boolean organizeLecture(String Date,int slot,String topic) throws RowsExceededException, BiffException, WriteException, ParseException, IOException
	{
		
		/*System.out.println("Enter the Lecture you want to organize");
		String topic = scan.nextLine();
		System.out.println("Enter the Date you want to organize the lecture on....");
		String Date = scan.nextLine();
		System.out.println("Enter the slot you want to book the lecture on....");
		int slot = scan.nextInt();*/
		
		if(q.getMyCal().bookSlot(Date, slot, topic)){
		
			WritableSheet wbs=w2.getSheet(0);
			int r=wbs.findCell(Date).getRow();
			int c=slot-1;
			Label l1 = new Label(c, r, "QEEE"+topic);
			WritableCell wc=(WritableCell)l1;
		    wbs.addCell(wc);
		    w2.write();
		    w2.close();
			return true;
		}
			else
			return false;
	}
	
	void inviteGuest(String topic, String Date, int slot)
	{
		
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		System.out.println("entered update method of faculty..");
		MyCalendar m = (MyCalendar)o;		
		if(!whobookedtheresource.containsKey(m.SlotDate))
		whobookedtheresource.put(this, m.SlotDate);
		else
			System.out.println("Slot is already booked by "+(whobookedtheresource.get(m.SlotDate)));
	}
}
