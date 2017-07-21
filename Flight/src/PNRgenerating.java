import java.util.*;
import java.util.logging.*;
import java.io.*;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
class PassengerInterface {
	public static Logger LOGGER = Logger.getLogger(PassengerInterface.class.getName());
	static boolean checkPNR(String pnr)
	{
		System.out.println("in the CHECKPNR METHOD");
		boolean val=false;
		try{
		String filepath="C:\\Users\\Sheshu\\Documents\\Book125.xls";
		//String filepath="Desktop:\\Food.xls";
		FileInputStream fs = new FileInputStream(filepath);
		Workbook wb=Workbook.getWorkbook(fs);
		Sheet sh = wb.getSheet(0); // this is to get the access to Sheet1. 
		if(sh.findCell(pnr).getContents().equals(pnr)){val=true;}
		
	    }
		
		catch(FileNotFoundException fn)
		{
			LOGGER.log(Level.SEVERE, "Exception occur", fn);
		}
		catch(BiffException exe){
			LOGGER.log(Level.SEVERE, "Exception occur", exe);
		}
		catch(IOException ex){
			LOGGER.log(Level.SEVERE, "Exception occur", ex);
		}
		if(val)
			return val;
		else
			return val;
		
	}
	public static void main(String []args){
	
		 
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the passenger PNR number");
		PNRScan pnrscan=new PNRScan();
		final String pnr;
		int Num_of_tags=0;
		pnr=sc.nextLine();
		try{
			if(checkPNR(pnr)){
			System.out.println("there is a match in pnr ");
			FindingFlight ff=new FindingFlight();
			ff.Flight_checking(pnr);
			int pass=pnrscan.get_passenger_no();
			int lugg=pnrscan.get_luggage_no(pnr);
			System.out.println("luggage from xcel is "+lugg);
			int lugWt=pnrscan.actual_luggage_count(pnr);
			System.out.println("the luggage wt from xls is "+lugWt);
		    if(pass*15>=lugWt)
		    {Num_of_tags=pass+lugg;
		    System.out.println("total number of tags "+Num_of_tags+"\n"+(Num_of_tags-pass)+" for luggage and reamaining for main ticket holder");
		    }
		    else if(pass*15<lugWt)
		    {
		    	throw new MoreLuggageException();
		    }}
		    else
			{
				System.out.println("no pnr match try later");
			}
		    }
		catch(MoreLuggageException ex)
		{
			LOGGER.log(Level.SEVERE, "Exception occur", ex);
		}
		catch(BadWeather bw)
	    {
			LOGGER.log(Level.SEVERE, "Exception occur", bw);
	    }
		
        sc.close();
		}   
		}
		
		
		

		