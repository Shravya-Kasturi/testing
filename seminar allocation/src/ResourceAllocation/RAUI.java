package ResourceAllocation;
import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.text.ParseException;

import javax.swing.*;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class RAUI extends Applet implements ActionListener{
	QEEE q ;
	
    String s="Welcome";
	Button ok, isAvailable, book;
	TextField fac,date,slot,sub;
	Label Fac,Date,Slot,Sub;
	public void init(){
		Fac=new Label("Faculty");
		Date=new Label("Date");
		Slot=new Label("Slot");
		Sub=new Label("Subject");
		ok=new Button("ok");
		//isAvailable=new Button("Is Available");
		book=new Button("Book Slot");
		fac=new TextField(10);
		date=new TextField(10);
		slot=new TextField(10);
		sub=new TextField(10);
		add(Fac);
		add(fac);
		add(Date);
		add(date);
		add(Slot);
		add(slot);
		add(Sub);
		add(sub);
		add(ok);
		//add(isAvailable);
		add(book);
		ok.addActionListener(this);
		//isAvailable.addActionListener(this);
		book.addActionListener(this);
		try{q=QEEE.getInstance();}
		catch(Exception e)
	{System.out.println("caught exception in init()");
	}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==ok)
		{
			fac.setEditable(false);
			date.setEditable(false);
			slot.setEditable(false);
			sub.setEditable(false);
		}
		
		
		else if(e.getSource()==book){
			{
				Faculty ff;
				try {
					ff = new Faculty(fac.getText(),sub.getText());
				 
				q.getMyCal().addObserver(ff);
				String s1=date.getText();
				int sl=Integer.parseInt(slot.getText());
				String subb=sub.getText();
			 
				if(ff.organizeLecture(s1, sl, subb)){
					 s="Slot is booked";
					 repaint();}
					 else{
						 s="slot not booked";
						 repaint();
					 }}
			 catch(BiffException | WriteException| ParseException | IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			 }
			
		}}
	public void paint(Graphics g){
		g.setFont(new Font("SansSerif",Font.BOLD,35));
		g.drawString(s, 50, 100);
	}
	
	
	


}