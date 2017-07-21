import java.util.*;
import java.io.*;
import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.*;
/*class bgpanel extends JPanel
{
	Image bg=new ImageIcon("plane.png").getImage();
	public void paintComponent(Graphics g)
	{
		g.drawImage(bg,0,0,getWidth(),getHeight(),this);
	}
}*/

class ScanPanel extends JPanel{
	String PNR;
	PNRScan sc;
	JLabel title;
	ScanPanel(String t)
	{
		title=new JLabel("PNR number matched!!");
		title.setFont((new Font("Monotype Corsiva",Font.BOLD,50)));
		add(title);
		sc=new PNRScan();
		PNR=t;
	}
	
	
}
/*class PNRpanel extends JPanel {
PassengerInterface pi=new PassengerInterface();	
JButton submit;
TextField pnr;
JLabel PNR;
Image i;
PNRpanel() throws IOException
{
	setOpaque(false);
	PNR=new JLabel("PNR Num:");
	PNR.setFont(new Font("Serif",Font.BOLD,50));
	PNR.setForeground(Color.white);
	pnr=new TextField(20);
	//pnr.setBounds(50, 50,30, 20);
	ImageIcon img=new ImageIcon(ImageIO.read(new File("C:\\Users\\Sheshu\\Downloads\\jet3.jpg")));
	submit=new JButton("Submit");
	submit.setContentAreaFilled(false);
	submit.setBorderPainted(false);
	submit.setBackground(Color.orange);
	submit.setForeground(Color.WHITE);
	submit.setFont(new Font("Serif",Font.BOLD ,40));
	submit.addActionListener(this);
	add(PNR);
	add(pnr);
	add(submit);
    i=img.getImage();
}
protected void paintComponent(Graphics g)
{
	g.drawImage(i, 0, 0, getWidth(), getHeight(),null);
}

	


}*/

class Receipt extends JPanel{
	//String pnr;
	
	Image i;
	
	Receipt()
	{ 
		try {
			i=new ImageIcon(ImageIO.read(new File("C:\\Users\\Sheshu\\Downloads\\b3.jpg"))).getImage();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	protected void paintComponent(Graphics g)
	{
		g.drawImage(i, 0, 0, getWidth(), getHeight(), null);
		//g.drawString("Kasturi",50,50);
		
	}
	
}
public class FlightUI2 extends JFrame {
 FlightUI2(String s)
 {
	 super(s);
	 
 }
	
	public static void main(String args[])
	{
		SwingUtilities.invokeLater(new Runnable(){
			public void run()
			{
				try {
					final FlightUI2 y=new FlightUI2("Welcome to ticket printing...");
					y.setLayout(new BorderLayout());
					y.setDefaultCloseOperation(EXIT_ON_CLOSE);
				    y.revalidate();
				    class PNRpanel extends JPanel {
				    	PassengerInterface pi=new PassengerInterface();	
				    	JButton submit;
				    	TextField pnr;
				    	JLabel PNR;
				    	Image i;
				    	PNRpanel() throws IOException
				    	{
				    		setOpaque(false);
				    		PNR=new JLabel("PNR Num:");
				    		PNR.setFont(new Font("Serif",Font.BOLD,50));
				    		PNR.setForeground(Color.white);
				    		pnr=new TextField(20);
				    		pnr.setFont(new Font("Serif",Font.BOLD,20));
				    		//pnr.setBounds(50, 50,30, 20);
				    		ImageIcon img=new ImageIcon(ImageIO.read(new File("C:\\Users\\Sheshu\\Downloads\\jet3.jpg")));
				    		submit=new JButton("Submit");
				    		submit.setContentAreaFilled(false);
				    		submit.setBorderPainted(false);
				    		submit.setBackground(Color.orange);
				    		submit.setForeground(Color.WHITE);
				    		submit.setFont(new Font("Serif",Font.BOLD ,40));
				    		submit.addActionListener(new ActionListener(){
				    			public void actionPerformed(ActionEvent e){
				    				if(pi.checkPNR(pnr.getText())){
				    					final String PNR = pnr.getText();
				    				
				    				JLabel title,lugg,g;
				    				JLabel person;
				    				JPanel pers;
				    				final JTextField p;
									final JTextField b;
				    				    pers=new JPanel(){
				    				    	protected void paintComponent(Graphics g){
				    				    	Image i = null;
				    				    	
				    				    		try{
				    				    		i=new ImageIcon(ImageIO.read(new File("C:\\Users\\Sheshu\\Pictures\\jet1.jpg"))).getImage();
				    				    	}
				    				    	catch (IOException e1) {
												// TODO Auto-generated catch block
												e1.printStackTrace();
											}
				    				    		g.drawImage(i, 0, 0, getWidth(), getHeight(), null);
				    				    	
				    				    		
				    				    	}
				    				    };
				    				    pers.setOpaque(false);
				    				    //pers.setBounds(0, 0, 750, 500);
				    				   pers.setLayout(new BorderLayout());
				    					title=new JLabel("PNR number matched!!");
				    					person=new JLabel("number off persons:");
				    					//title.setLocation(0, 0);
				    					//person.setLocation(0,100);
				    				    lugg=new JLabel("Luggage:");
				    				    lugg.setFont((new Font("Serif",Font.BOLD,30)));
				    				    person.setFont((new Font("Serif",Font.BOLD,30)));
				    					title.setFont((new Font("Monotype Corsiva",Font.BOLD,50)));
				    					title.setForeground(Color.WHITE);
				    					lugg.setForeground(Color.black);
				    					person.setForeground(Color.black);
				    					pers.add(title,BorderLayout.NORTH);
				    					p=new JTextField(10);
				    					//p.setSize(20,10);
				    					p.setFont(new Font("Serif",Font.BOLD,20));
				    					b=new JTextField(10);
				    					b.setFont(new Font("Serif",Font.BOLD,20));
				    					//b.setSize(20,10);
				    					//g=new JLabel("    ");
				    					//pers.add(g);
				    					JPanel j=new JPanel();
				    					j.setOpaque(false);
				    					JButton ok=new JButton("OK");
				    					ok.setForeground(Color.WHITE);
				    					ok.setBackground(Color.blue);
				    					ok.setBorderPainted(false);
				    					ok.setFont(new Font("Serif",Font.BOLD,20));
				    					ok.addActionListener(new ActionListener(){
				    						public void actionPerformed(ActionEvent e)
				    						{
				    							PNRScan sc;
				    							String PNR;
				    							sc=new PNRScan();
						    					PNR=pnr.getText();
						    					int ppl=Integer.parseInt(p.getText());
						    					b.setText(Integer.toString(sc.actual_luggage_count(PNR)));
						    					int x=sc.actual_luggage_count(PNR);
						    					if(ppl*15<x){
						    						JPanel jj=new JPanel();
						    						jj.setBounds(0, 0, 500, 500);
						    						jj.setVisible(true);
						    						String message = JOptionPane.showInputDialog(jj,
						    					            "More Than Allowed Luggage.", 
						    					            "My dialog asks....", 
						    					            JOptionPane.ERROR_MESSAGE);
                                                    y.add(jj);
                                                    y.revalidate();
						    						
						    					}
						    					
				    							
				    						}
				    					});
				    					j.add(person);
				    					j.add(p);
				    					j.add(ok);
				    					j.add(lugg);
				    					j.add(b);
				    					//JPanel j1=new JPanel();
				    					JButton rec=new JButton("Print Receipt");
				    					rec.setFont(new Font("Serif",Font.BOLD,40));
				    					rec.setForeground(Color.white);
				    					rec.setBorderPainted(true);
				    					rec.setContentAreaFilled(false);
				    					//j1.setOpaque(false);
				    					//j1.add(rec);
				    					j.add(rec);
				    					rec.addActionListener(new ActionListener(){
				    						public void actionPerformed(ActionEvent e){
				    							Receipt rr=new Receipt();
				    							rr.setLayout(new BorderLayout());
				    							JPanel tt=new JPanel(){
				    								FindingFlight ff;
				    								PNRScan ps;
				    								String k="not found";
				    						    	protected void paintComponent(Graphics g){
				    						    		g.setColor(Color.white);
				    						    		//g.setFont(new Font("SansSerif",Font.PLAIN,30));
				    						    		//g.drawString("Name  :", 10,60 );
				    						    		g.setFont(new Font("Monospaced",Font.BOLD,25));
				    						    		
				    						    		g.drawString(": SpiceJet Airways", 250, 30);
				    						    		g.drawString(": 10th April 2017", 250,70);
				    						    		g.drawString(": "+PNR, 250, 110);
				    						    		
				    						    		g.drawString(": Rahul", 250, 150);
				    						    		g.drawString(": Jammu", 250, 190);
				    						    		g.drawString(": Mumbai", 250, 230);
				    						    		g.drawString(": SJ611362", 250, 270);
				    						    	}
				    						    };
				    						    JLabel  ppno,dat,carrier,tag;
				    						    JLabel name,ppl,from,to,flit;
				    							name   =new JLabel("Name     ");
				    							//flit   =new JLabel("Flight Series " );
				    							from   =new JLabel("From         ");
				    							to     =new JLabel("Dest.        ");
				    							ppno   =new JLabel("PNR No.      ");
				    							dat    =new JLabel("Issued on     ");
				    							carrier=new JLabel("Carrier       ");
				    							tag    =new JLabel("Boarding id   ");
				    							carrier.setFont(new Font("SansSerif",Font.PLAIN,30));
				    							carrier.setForeground(Color.WHITE);
				    							dat.setFont(new Font("SansSerif",Font.PLAIN,30));
				    							dat.setForeground(Color.WHITE);
				    							ppno.setFont(new Font("SansSerif",Font.PLAIN,30));
				    							ppno.setForeground(Color.WHITE);
				    							tag.setFont(new Font("SansSerif",Font.PLAIN,30));
				    							tag.setForeground(Color.WHITE);
				    							name.setFont(new Font("SansSerif",Font.PLAIN,30));
				    							name.setForeground(Color.WHITE);
				    							//flit.setFont(new Font("SansSerif",Font.PLAIN,30));
				    							//flit.setForeground(Color.WHITE);
				    							from.setFont(new Font("SansSerif",Font.PLAIN,30));
				    							from.setForeground(Color.WHITE);
				    							to.setFont(new Font("SansSerif",Font.PLAIN,30));
				    							to.setForeground(Color.WHITE);
				    							//name.setLocation(30, 10);
				    							tt.setLayout(new GridLayout(8,1));
				    						   
				    						    tt.setBounds(0, 0, 800, 400);
				    						    tt.setOpaque(false);
				    						    tt.add(carrier);
				    						    tt.add(dat);
				    						    tt.add(ppno);
				    						    tt.add(name);
				    						   // tt.add(flit);
				    						    tt.add(from);
				    						    tt.add(to);
				    						    tt.add(tag);	    						     
				    						    rr.add(tt,BorderLayout.NORTH);
				    						    rr.revalidate();
				    							y.getContentPane().removeAll();
				    							y.add(rr);
				    							y.revalidate();
				    						}
				    					});
				    					pers.add(j);
				    					pers.revalidate();
				    					//title.setAlignmentX(CENTER_ALIGNMENT);
				    					y.getContentPane().removeAll();
				    					
				    					y.setContentPane(pers);
				    					y.revalidate();
				    					
				    					
				    					
				    				
				    			}
				    				
				    				else{
				    					System.out.println("got into else part");
				    					JOptionPane.showMessageDialog(y, "PNR didnt match..Please Try again!!","Warning String", JOptionPane.ERROR_MESSAGE);
				    					y.revalidate();
				    				}
				    				}
				    		});
				    		add(PNR);
				    		add(pnr);
				    		add(submit);
				    	    i=img.getImage();
				    	}
				    	protected void paintComponent(Graphics g)
				    	{
				    		g.drawImage(i, 0, 0, getWidth(), getHeight(),null);
				    	}

				    		


				    	}
					PNRpanel k=new PNRpanel();
					y.setContentPane(k);
					y.setSize(250, 200);
					y.setVisible(true);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}
}
