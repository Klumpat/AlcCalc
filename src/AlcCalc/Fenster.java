package AlcCalc;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Fenster extends JFrame {
	
	
	
	double priceWine = 2.5;
	double priceBeer = 4;
	int countWine, countBeer = 0;
	int status = (int)(countWine + countBeer);
	JButton btnBeer, btnWine, btnBill;							//initialisierung
	JLabel lblBeer, lblWine, lblStatus, lblBill;
	final boolean DEBUG = true;							//Debug informationen in der Console ausgeben ja/nein
	
	
	public Fenster(){
		super("AlkCalc"); 								//FensterName
		
		setVisible(true); 								//sichtbarkeit
		setSize(400, 450); 								//größe
		setDefaultCloseOperation(EXIT_ON_CLOSE); 		//was passiert beim schließen?
		setLayout(null);								//Layout
		setLocationRelativeTo(null);
		setResizable(false);							//größe nicht veränderbar
		//create Components
			
			//Wine
		btnWine = new JButton("Wine");					
		btnWine.setBounds(100, 75, 70, 25);
		
		lblWine = new JLabel();
		lblWine.setBounds(200, 75, 140, 25);
		
				
			//Beer
		btnBeer = new JButton("Beer");					//Inhalt
		btnBeer.setBounds(100, 100, 70, 25);			//Position und Größe
		
		lblBeer = new JLabel();
		lblBeer.setBounds(200, 100, 140, 25);
			
			//Status
		lblStatus = new JLabel();
		lblStatus.setBounds(100, 125, 250, 25);
		
			//Zwischenrechnung
		btnBill = new JButton("Bill");
		btnBill.setBounds(100, 200, 70, 25);
		
		lblBill = new JLabel();
		lblBill.setBounds(200, 200, 250, 25);
		
		
		
		
		//add Components
		
		
		add(btnBeer);
		add(btnWine);	
		add(lblBeer);
		add(lblWine);
		add(lblStatus);
		add(btnBill);
		add(lblBill);
		
		
		//Listeners
		
		btnBeer.addActionListener(new BtnHandler());
		btnWine.addActionListener(new BtnHandler());
		btnBill.addActionListener(new BtnHandler());
		
		
				
		

		

		
	}
	private class BtnHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent btnUse) {
				if (btnUse.getSource() == btnBeer) {
					if(DEBUG)System.out.println("Status: " + status);
					countBeer++;
					lblBeer.setText(countBeer + "x" + btnBeer.getText());
					status = (int)(countWine + countBeer);
					StatusUpdate();
					if(DEBUG)System.out.println("Status: " + status);
					
			}	else if (btnUse.getSource() == btnWine) {
					if(DEBUG)System.out.println("Status: " + status);
					countWine++;
					lblWine.setText(countWine + "x" + btnWine.getText());
					status = (int)(countWine + countBeer);
					StatusUpdate();
					if(DEBUG)System.out.println("Status: " + status);
			}	else if (btnUse.getSource() == btnBill) {
					BillUpdate();
			}
			
		}
		
	}
	
	private void StatusUpdate() {
		switch(status){
		case 1:
			lblStatus.setText("");break;
		case 2:
			lblStatus.setText("");break;
		case 3:
			lblStatus.setText("I think ure a litte bit drunk");break;
		case 4:
			lblStatus.setText("I think ure a litte bit drunk");break;
		case 5:
			lblStatus.setText("I think ure a litte bit drunk");break;
		default:
			lblStatus.setText("Way to drunk Dude!");break;
			
		}
			
	}
	private void BillUpdate() {
		double bill = (countBeer*priceBeer)+(countWine*priceWine);
		lblBill.setText("Bill = aprox.: " + bill);
		
	}
	
}
