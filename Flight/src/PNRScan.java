import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import java.util.*;

class PNRScan {
String filepath;
Workbook wb;
FileInputStream fs;
Sheet sh;
Scanner sc;
PNRScan()
{
 filepath="C:\\Users\\Sheshu\\Documents\\Book125.xls";
 try{
		sc=new Scanner(System.in);
	    fs = new FileInputStream(filepath);
		wb = Workbook.getWorkbook(fs);
	    sh = wb.getSheet(0);
    }
 
	catch(FileNotFoundException fn)
	{
		System.out.println(fn);
	}
	catch(BiffException exe){
		System.out.println(exe);
	}
	catch(IOException ex){
		System.out.println(ex);
	}
}

int get_passenger_no()
{
	try{System.out.println("enter the number of passengers travelling");
	int a = sc.nextInt();
	if(a>0)
	return a;
	else
		{
		throw new NegativeValue();
		}}
	catch(NegativeValue e){System.out.println(e);}
	return -1;
}

int get_luggage_no(String pnr)
{
	Cell c=sh.findCell(pnr);
	System.out.println(c.getContents()+" "+c.getRow());
	int r=1;
	if(c!=null)
     r=c.getRow();
	System.out.println(c.getContents()+" "+c.getRow());
	int last_row=sh.getRows();
	System.out.println("the last row value is "+sh.getRows());
	System.out.print(sh.getCell(0,r+1).getContents()+".");
	System.out.println("entering for loop");
	while(sh.getCell(0,r+1).getContents()==""&&r<last_row){
		r++;
	}
	System.out.println("came out of for loop and ending r is "+r);
	int count=0;
	for(int i=c.getRow();i<=r;i++)
		if(sh.getCell(2,r).getContents()!="")
			count++;//count+Integer.parseInt(sh.getCell(3,i).getContents());
	//try{System.out.println("enter the number of luggages with u");
	//int a = sc.nextInt();
	//if(a>=0)
	//return a;
	//else
		//{
		//throw new NegativeValue();
		//}}
	//catch(NegativeValue e){System.out.println(e);}
	//return -1;
	return count;
}

int actual_luggage_count(String pnr){

	System.out.println("entered actual luggage count method");
	Cell c=sh.findCell(pnr);
	System.out.println(c.getContents()+" "+c.getRow());
	int last_row=sh.getRows();
	int r=1;
	if(c!=null)
     r=c.getRow();
	System.out.println(c.getContents()+" "+c.getRow());
	System.out.print(sh.getCell(0,r+1).getContents()+".");
	System.out.println("entering for loop");
	while(sh.getCell(0,r+1).getContents()==""&&sh.getCell(3,r+1).getContents()!=""&&r<last_row){
		r++;
	}
	System.out.println("came out of for loop and ending r is "+r);
	int count=0;
	for(int i=c.getRow();i<=r;i++)
		count=count+Integer.parseInt(sh.getCell(3,i).getContents());
	return count;
}
String naming(String pnr){
Cell c=sh.findCell(pnr);
int r=c.getRow();
System.out.println(sh.getCell(1,r).getContents());
return sh.getCell(1,r).getContents();
}
}

