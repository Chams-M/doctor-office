import java.awt.BorderLayout;
import javax.swing.*;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Main extends JFrame{
	
	JDesktopPane desktop;
	private PatientFrame pf;
	
	public Main()
	
	{
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    
		this.setSize(900, 600);
    	this.setLayout(new BorderLayout());
        pf=new PatientFrame();
    	desktop.add(pf);
    	desktop=new JDesktopPane();
    	this.add(desktop,BorderLayout.CENTER);
    	
    	this.setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main b = new Main();
		b.setVisible(true);
	}

}
