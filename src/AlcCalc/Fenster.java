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
	
	int countWein, countBier = 0;
	int status = (countWein + countBier);
	JButton btnBier, btnWein;							//initialisierung
	JLabel lblBier, lblWein, lblStatus;
	final boolean DEBUG = true;							//Debug informationen in der Console ausgeben ja/nein
	
	
	public Fenster(){
		super("AlkCalc"); 								//FensterName
		
		setVisible(true); 								//sichtbarkeit
		setSize(500, 500); 								//größe
		setDefaultCloseOperation(EXIT_ON_CLOSE); 		//was passiert beim schließen?
		setLayout(null);								//Layout
		setResizable(false);							//größe nicht veränderbar
		//create Components
			
			//wein
		btnWein = new JButton("Wein");					
		btnWein.setBounds(100, 75, 70, 25);
		
		lblWein = new JLabel();
		lblWein.setBounds(200, 75, 140, 25);
		
		
		
			//bier
		btnBier = new JButton("Bier");					//Inhalt
		btnBier.setBounds(100, 100, 70, 25);			//Position und Größe
		
		lblBier = new JLabel();
		lblBier.setBounds(200, 100, 140, 25);
			
			//Status
		lblStatus = new JLabel();
		lblStatus.setBounds(100, 125, 250, 25);
		
		
		
		//add Components
		
		
		add(btnBier);
		add(btnWein);	
		add(lblBier);
		add(lblWein);
		add(lblStatus);
		
		
		//Listeners
		
		btnBier.addActionListener(new BtnHandler());
		btnWein.addActionListener(new BtnHandler());
		
		
				
		

		

		
	}
	private class BtnHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent btnUse) {
				if (btnUse.getSource() == btnBier) {
					if(DEBUG)System.out.println("Status: " + status);
					countBier++;
					lblBier.setText(countBier + "x" + btnBier.getText());
					status = (countWein + countBier);
					StatusUpdate();
					if(DEBUG)System.out.println("Status: " + status);
					
			}	else if (btnUse.getSource() == btnWein) {
					if(DEBUG)System.out.println("Status: " + status);
					countWein++;
					lblWein.setText(countWein + "x" + btnWein.getText());
					status = (countWein + countBier);
					StatusUpdate();
					if(DEBUG)System.out.println("Status: " + status);
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
	
}
