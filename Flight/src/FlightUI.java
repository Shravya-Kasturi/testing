import java.applet.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public  class FlightUI extends Applet implements ActionListener {
Button b1,b2,b3,b4;
	TextField per,PNR;
	PNRScan pp=new PNRScan();
	PassengerInterface oi=new PassengerInterface();
	public void init()
	{
		Panel p1=new Panel();
		p1.setBackground(Color.cyan);
		setLayout(new BorderLayout());
		add(p1,BorderLayout.NORTH);
		Label l1=new Label("Welcome to online ticket printing");
		l1.setFont(new Font("Serif", Font.PLAIN, 30));
		p1.add(l1);
		b2=new Button("Prepare Receipts");
		b2.setFont(new Font("Serif", Font.BOLD,30));
		b3=new Button("Report");
		b3.setFont(new Font("Serif", Font.BOLD,30));
		b4=new Button("Reset");
		b4.setFont(new Font("Serif", Font.BOLD,30));
		b1=new Button("Submit");
		b1.setFont(new Font("Serif", Font.BOLD,30));
		Label pnr=new Label("PNR");
		pnr.setFont(new Font("Serif", Font.PLAIN, 30));
		Label persons=new Label("Persons Count");
		persons.setFont(new Font("Serif", Font.PLAIN, 30));
		per=new TextField();
		PNR=new TextField();
		Panel p2=new Panel();
		p2.setLayout(new GridLayout(5,2));
		TextField txt=new TextField();
	    p2.add(pnr);
	    p2.add(PNR);
	    p2.add(persons);
	    p2.add(per);
	    p2.add(b1);
	    p2.add(b2);
	    p2.add(b3);
	    p2.add(b4);
		add(p2,BorderLayout.CENTER);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==b1)
		{
			String x=PNR.getText();
			if(oi.checkPNR(x))
			{
				int passCount=Integer.parseInt(per.getText());
				int luggWt=pp.actual_luggage_count(x);
				if(15*passCount>luggWt)
				{
					
				}
				
			}
			
		}
		
	}

}
