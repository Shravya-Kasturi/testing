import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.*;

import jxl.Cell;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;


class FindingFlight {
	public static Logger LOGGER = Logger.getLogger(FindingFlight.class.getName());
	String filepath1;
	String filepath2;
	Workbook wb;
	FileInputStream fs1;
	FileInputStream fs2;
	Sheet sh;
	Scanner sc;
	FindingFlight()
	{
		filepath1="C:\\Users\\Sheshu\\Documents\\Book125.xls";
		filepath2="C:\\Users\\Sheshu\\Documents\\Flightseries1.xls";
		 try{
				sc=new Scanner(System.in);
			    fs1 = new FileInputStream(filepath1);
			    fs2=new FileInputStream(filepath2);
				wb = Workbook.getWorkbook(fs2);
			    sh = wb.getSheet(0);
			    
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
	}
	
	
     String Flight_checking(String pnr) throws BadWeather
	{
		String fligt=pnr.substring(0,2);
		//System.out.println("from pnr d clue about flight is "+fligt);
		
		Cell c=sh.findCell(fligt);
		int r=0;
		if(c!=null)
	   {r=c.getRow();
	    System.out.println(r);
	   }
		System.out.println("your flight is from "+sh.getCell(1,r).getContents()+" and goes to "+sh.getCell(2,r).getContents());
		try{controlStation();}
		finally{
			System.out.println("contact control station");
		}
		return fligt;
	}
	
	void controlStation() throws BadWeather{
	    try{
	    Random rand=new Random();
	    int weather_stability=rand.nextInt(3);
	    if(weather_stability==3)
	    throw new BadWeather();
	    }
	    finally{
	    System.out.println("Check the Weather condition");
	    }
	    
}
}
