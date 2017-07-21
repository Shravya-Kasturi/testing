package ResourceAllocation;

import java.io.IOException;
import jxl.read.biff.BiffException;


public class Guest {

	String name, expertise[], company, designation;
	String Date;
	int time;
	MyCalendar calendar;
	final String myFile = "E:/guestfile.xls";
	Guest(String name, String expertise[], String company, String designation) throws BiffException, IOException
	{
		this.name = name;
		this.expertise = expertise;
		this.company = company;
		this.designation = designation;		
	}		
}
