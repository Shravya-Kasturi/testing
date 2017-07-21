package ResourceAllocation;

import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class ResourceAllocation {
	static String str="Y";
	public static void main(String[] args) throws ParseException, BiffException, IOException, RowsExceededException, WriteException{
		// TODO Auto-generated method stub
		QEEE q = QEEE.getInstance();
		Scanner s = new Scanner(System.in);
		String date;
		int i;
		while(str.equals("Y"))
		{
			
			System.out.println("Enter the date to be booked");
			date = s.next();
			System.out.println("Enter the slot to be booked on "+date);
			i = s.nextInt();
			System.out.println("Slot Available: "+q.getMyCal().amAvailable(date, i));
			if(q.getMyCal().amAvailable(date, i))
			{
				System.out.println("Do you want to book? Y or N");
				if(s.next().equals("Y"))
					System.out.println("Slot Booked: "+q.getMyCal().bookSlot(date, i, "BOOKED"));
			}
			else
			{
				System.out.println("Do you want to book another slot? Y or N");				
				if(s.next().equals("Y"))
				{
					str = "Y";
					System.out.println("REDIRECTING....");
				}
				else
					str="N";
			
			}
			
		}
		s.close();
	}

}
