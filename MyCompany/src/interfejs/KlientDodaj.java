package interfejs;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import obsluga_bazy_danych.ObslugaBazyDanych;

public class KlientDodaj extends JFrame implements ActionListener {
	 
		private JLabel skrotNazwaJL;
		private JLabel pelnaNazwaJL;
		private JLabel nipJL;
		private JLabel adresJL;
		private JLabel telefonJL;
		private JLabel inneKlientJL;
		
		private JTextField skrotNazwaJTF;
		private JTextField pelnaNazwaJTF;
		private JTextField nipJTF;
		private JTextField adresJTF;
		private JTextField telefonJTF;
		private JTextField inneKlientJTF;
		
		private JButton zapiszJB;
		
		
		public KlientDodaj() {
			
			super("Dodaj klienta");
			setSize(600, 400);
			setResizable(true);
			setLayout(null);
			
			Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
			this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
			
			skrotNazwaJL = new JLabel("Imie:");
			skrotNazwaJL.setBounds(10, 40, 150, 20);
			add(skrotNazwaJL);

			pelnaNazwaJL = new JLabel("Nazwisko/ nazwa:");
			pelnaNazwaJL.setBounds(10, 70, 150, 20);
			add(pelnaNazwaJL);

			nipJL = new JLabel("NIP:");
			nipJL.setBounds(10, 100, 150, 20);
			add(nipJL);

			adresJL = new JLabel("Adres:");
			adresJL.setBounds(10, 130, 150, 20);
			add(adresJL);

			telefonJL = new JLabel("Telefon:");
			telefonJL.setBounds(10, 160, 150, 20);
			add(telefonJL);
			
			inneKlientJL = new JLabel("Inne:");
			inneKlientJL.setBounds(10, 190, 150, 20);
			add(inneKlientJL);
			

			skrotNazwaJTF = new JTextField();
			skrotNazwaJTF.setBounds(150, 40, 150, 20);
			add(skrotNazwaJTF);

			pelnaNazwaJTF = new JTextField();
			pelnaNazwaJTF.setBounds(150, 70, 150, 20);
			add(pelnaNazwaJTF);

			nipJTF = new JTextField();
			nipJTF.setBounds(150, 100, 150, 20);
			add(nipJTF);

			adresJTF = new JTextField();
			adresJTF.setBounds(150, 130, 150, 20);
			add(adresJTF);

			telefonJTF = new JTextField();
			telefonJTF.setBounds(150, 160, 150, 20);
			add(telefonJTF);
			
			inneKlientJTF = new JTextField();
			inneKlientJTF.setBounds(150, 190, 150, 20);
			add(inneKlientJTF);
			
			zapiszJB = new JButton("Zapisz");
			zapiszJB.setBounds(330, 330, 200, 20);
			zapiszJB.addActionListener(this);
			add(zapiszJB);
			
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			setVisible(true);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource().equals(zapiszJB)) {
				
				String skrotNazwa = skrotNazwaJTF.getText();
				String pelnaNazwa = pelnaNazwaJTF.getText();
				String nip = nipJTF.getText();
				String adres = adresJTF.getText();
				String telefon = telefonJTF.getText();
				String inneKlient = inneKlientJTF.getText();
							
				
				ObslugaBazyDanych bd = new ObslugaBazyDanych();
				
				bd.dodajDane2(skrotNazwa, pelnaNazwa, nip, adres, 
						telefon, inneKlient);
				
				bd.zamknijPolaczenie();
				
				setVisible(false);
				
				KlientSpis ob = new KlientSpis();
				ob.setVisible(true);
				
			}
		}
	}

