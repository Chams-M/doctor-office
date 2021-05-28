import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.*;

public class PatientFrame extends JFrame {
    
	
    JPanel panel1,panel2,panel3,panel4;
    JTextField search;
    JButton btn_search;
    JButton ajout , modif , ajout_pat;
	private JPanel p3;
	private JPanel p4;

	public PatientFrame()
	{
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(900, 600);
		this.setTitle("Cabinet chams");
		this.setLayout(null);
	
	
	
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		
		JLabel nom = new JLabel("Nom:");
		nom.setSize(50, 50);
		nom.setLocation(0,10);
		
		JTextField txt_nom=new JTextField();
		txt_nom.setSize(180, 30);
		txt_nom.setLocation(80,20);
		
		JLabel prenom = new JLabel("Prénom:");
		prenom.setSize(80, 50);
		prenom.setLocation(0,10);
		JTextField txt_prenom=new JTextField();
		txt_prenom.setSize(180, 30);
		txt_prenom.setLocation(80,20);
		
		
		JLabel adress = new JLabel("Adresse:");
		adress.setSize(80, 50);
		adress.setLocation(0,10);
		
		JTextField txt_adress=new JTextField();
		txt_adress.setSize(180, 30);
		txt_adress.setLocation(80,20);
		
		JLabel tel = new JLabel("Téléphone:");
		tel.setSize(82, 50);
		tel.setLocation(0,10);
		
		JTextField txt_tel=new JTextField();
		txt_tel.setSize(180, 30);
		txt_tel.setLocation(80,20);
		
		JLabel titre=new JLabel("Gestion des Patients");
		titre.setSize(150, 50);
		titre.setLocation(500, 25);
		
	    
	 
		
		JList<Patient> list_patients= new JList<Patient>();
		list_patients.setSize(290,400);
		list_patients.setLocation(10,90);
		
		JTextField search=new JTextField();
		search.setSize(185, 30);
		search.setLocation(10, 30);
		
		ajout=new JButton("Ajouter Consultation");
		ajout.setSize(290, 50);
		ajout.setLocation(10, 500);
		
		
		 btn_search=new JButton("Chercher");
		 btn_search.setSize(100, 30);
		 btn_search.setLocation(200, 30);
		 
		 modif=new JButton("Modifier les informations");
		 modif.setSize(100, 50);
		
		 
		 ajout_pat=new JButton("Ajouter Patient");
		 ajout_pat.setSize(100, 50);
		
		p1.setLayout(null);
	    p1.setBounds(0, 0, 320, 600);
	   
	    
	    p1.add(ajout);
	    p1.add(list_patients);
	    p1.add(search);
	    p1.add(btn_search);
	    
	    
	     p2.setLayout(null);
		 p2.setBounds(320, 90, 560, 400);
		 p2.setBackground(Color.white);
		
		 
		 p3=new JPanel();
		 p3.setLayout(new BorderLayout());
		 p3.setSize(500, 60);
		 p3.setLocation(30, 320);
		 p3.add(modif,BorderLayout.EAST);
		 p3.add(ajout_pat,BorderLayout.WEST);
		 p3.setBackground(Color.white);
		 
		 
		 p4=new JPanel(new GridLayout(2,2,0,30)); 
	
		 p4.setSize(600, 150);
		 p4.setLocation(0, 30);
		 	JPanel gridPanel1 = new JPanel(null);
		 	JPanel gridPanel2 = new JPanel(null);
		 	JPanel gridPanel3 = new JPanel(null);
		 	JPanel gridPanel4 = new JPanel(null);
		 	
		    p4.add(gridPanel1);
		    p4.add(gridPanel2);
		    p4.add(gridPanel3);
		    p4.add(gridPanel4);
		    p4.setBackground(Color.white);
		   
		    gridPanel1.add(nom);
		    gridPanel1.add(txt_nom);
		    gridPanel1.setBackground(Color.white);
		    
		    gridPanel2.add(prenom);
		    gridPanel2.add(txt_prenom);
		    gridPanel2.setSize(300,150);
		    gridPanel2.setBackground(Color.white);
		    
		    
		    gridPanel3.add(adress);
		    gridPanel3.add(txt_adress);
		    gridPanel3.setBackground(Color.white);
		    
		    gridPanel4.add(tel);
		    gridPanel4.add(txt_tel);
		    gridPanel4.setBackground(Color.white);
		    
		    
	
		 p2.add(p3);
		 p2.add(p4);
	
	   this.add(titre);
	
	   this.add(p1);
	   this.add(p2);
	   this.setResizable(false);
	   this.setBackground(Color.PINK);
		
		this.setVisible(true);
	}

}
