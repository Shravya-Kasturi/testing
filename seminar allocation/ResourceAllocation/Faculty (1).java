package ResourceAllocation;

import java.io.IOException;
import java.text.ParseException;
import java.util.*;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class Faculty implements Runnable, Observer{

	String Name, Course, Date;

	int slot;
	Thread t;
	Scanner scan;
	QEEE q;
	static LinkedHashMap<Faculty, Date> whobookedtheresource;
	
	Faculty(String Name, String Course)
	{
		this.Name = Name;
		this.Course = Course;
		scan = new Scanner(System.in);
		t = new Thread(this,Name);
		whobookedtheresource = new LinkedHashMap<Faculty, Date>();
	}

	public void run()
	{			
		System.out.println("Are your willing to book QEEE?.... Y or N");
		try {
			q = QEEE.getInstance();			
		} catch (BiffException | ParseException | IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
	
	void organizeLecture() throws RowsExceededException, BiffException, WriteException, ParseException, IOException
	{
		t.start();
		System.out.println("Enter the Lecture you want to organize");
		String topic = scan.nextLine();
		System.out.println("Enter the Date you want to organize the lecture on....");
		String Date = scan.nextLine();
		System.out.println("Enter the slot you want to book the lecture on....");
		int slot = scan.nextInt();
		
		q.getMyCal().bookSlot(Date, slot, topic);
	}
	
	void inviteGuest(String topic, String Date, int slot)
	{
		
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		MyCalendar m = (MyCalendar)o;		
		if(!whobookedtheresource.containsKey(m.SlotDate))
		whobookedtheresource.put(this, m.SlotDate);
		else
			System.out.println("Slot is already booked by "+(whobookedtheresource.get(m.SlotDate)));
	}
}
