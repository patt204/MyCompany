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

public class KontrahentDodaj extends JFrame implements ActionListener {
	 
		private JLabel skrotNazwaKoJL;
		private JLabel pelnaNazwaKoJL;
		private JLabel nipKoJL;
		private JLabel adresKoJL;
		private JLabel telefonKoJL;
		private JLabel inneKontrahentJL;
		
		private JTextField skrotNazwaKoJTF;
		private JTextField pelnaNazwaKoJTF;
		private JTextField nipKoJTF;
		private JTextField adresKoJTF;
		private JTextField telefonKoJTF;
		private JTextField inneKontrahentJTF;
		
		private JButton zapiszJB;
		
		
		public KontrahentDodaj() {
			
			super("Kontrahent");
			setSize(600, 400);
			setResizable(true);
			setLayout(null);
			
			Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
			this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
			
			skrotNazwaKoJL = new JLabel("Nazwa skrotu:");
			skrotNazwaKoJL.setBounds(10, 40, 150, 20);
			add(skrotNazwaKoJL);

			pelnaNazwaKoJL = new JLabel("Pe³na nazwa:");
			pelnaNazwaKoJL.setBounds(10, 70, 150, 20);
			add(pelnaNazwaKoJL);

			nipKoJL = new JLabel("NIP:");
			nipKoJL.setBounds(10, 100, 150, 20);
			add(nipKoJL);

			adresKoJL = new JLabel("Adres:");
			adresKoJL.setBounds(10, 130, 150, 20);
			add(adresKoJL);

			telefonKoJL = new JLabel("Telefon:");
			telefonKoJL.setBounds(10, 160, 150, 20);
			add(telefonKoJL);
			
			inneKontrahentJL = new JLabel("Inne:");
			inneKontrahentJL.setBounds(10, 190, 150, 20);
			add(inneKontrahentJL);
			

			skrotNazwaKoJTF = new JTextField();
			skrotNazwaKoJTF.setBounds(150, 40, 150, 20);
			add(skrotNazwaKoJTF);

			pelnaNazwaKoJTF = new JTextField();
			pelnaNazwaKoJTF.setBounds(150, 70, 150, 20);
			add(pelnaNazwaKoJTF);

			nipKoJTF = new JTextField();
			nipKoJTF.setBounds(150, 100, 150, 20);
			add(nipKoJTF);

			adresKoJTF = new JTextField();
			adresKoJTF.setBounds(150, 130, 150, 20);
			add(adresKoJTF);

			telefonKoJTF = new JTextField();
			telefonKoJTF.setBounds(150, 160, 150, 20);
			add(telefonKoJTF);
			
			inneKontrahentJTF = new JTextField();
			inneKontrahentJTF.setBounds(150, 190, 150, 20);
			add(inneKontrahentJTF);
			
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
				
				String skrotNazwaKo = skrotNazwaKoJTF.getText();
				String pelnaNazwaKo = pelnaNazwaKoJTF.getText();
				String nipKo = nipKoJTF.getText();
				String adresKo = adresKoJTF.getText();
				String telefonKo = telefonKoJTF.getText();
				String inneKontrahent = inneKontrahentJTF.getText();
							
				
				ObslugaBazyDanych bd = new ObslugaBazyDanych();
				
				bd.dodajDane3(skrotNazwaKo, pelnaNazwaKo, nipKo, adresKo, telefonKo, inneKontrahent);
				
				bd.zamknijPolaczenie();
				
				setVisible(false);
				
				KontrahentSpis ob = new KontrahentSpis();
				ob.setVisible(true);
				
			}
		}
	}

