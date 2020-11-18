package interfejs;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import obsluga_bazy_danych.ObslugaBazyDanych;

public class InterfejsTowar extends JFrame implements ActionListener {
	 
	private JLabel kodJL;
	private JLabel nazwaJL;
	private JLabel iloscJL;
	private JLabel iloscM1JL;
	private JLabel iloscM2JL;
	private JLabel nettoJL;
		
	private JTextField kodJTF;
	private JTextField nazwaJTF;
	private JTextField iloscJTF;
	private JTextField iloscM1JTF;
	private JTextField iloscM2JTF;
	private JTextField nettoJTF;
		
	private JButton zapiszJB;
		
		
	public InterfejsTowar() {
			
		super("Dodaj Towar");
		setSize(600, 400);
		setResizable(true);
		setLayout(null);
			
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
			
		kodJL = new JLabel("Kod kreskowy:");
		kodJL.setBounds(10, 40, 150, 20);
		add(kodJL);

		nazwaJL = new JLabel("Nazwa:");
		nazwaJL.setBounds(10, 70, 150, 20);
		add(nazwaJL);

		iloscJL = new JLabel("Ilosc:");
		iloscJL.setBounds(10, 100, 150, 20);
		add(iloscJL);

		iloscM1JL = new JLabel("Ilosc M1:");
		iloscM1JL.setBounds(10, 130, 150, 20);
		add(iloscM1JL);
		
		iloscM2JL = new JLabel("Ilosc M2:");
		iloscM2JL.setBounds(10, 160, 150, 20);
		add(iloscM2JL);
		
		nettoJL = new JLabel("Cena netto:");
		nettoJL.setBounds(10, 190, 150, 20);
		add(nettoJL);


		kodJTF = new JTextField();
		kodJTF.setBounds(150, 40, 150, 20);
		add(kodJTF);

		nazwaJTF = new JTextField();
		nazwaJTF.setBounds(150, 70, 150, 20);
		add(nazwaJTF);

		iloscJTF = new JTextField();
		iloscJTF.setBounds(150, 100, 150, 20);
		add(iloscJTF);
		
		iloscM1JTF = new JTextField();
		iloscM1JTF.setBounds(150, 130, 150, 20);
		add(iloscM1JTF);
		
		iloscM2JTF = new JTextField();
		iloscM2JTF.setBounds(150, 160, 150, 20);
		add(iloscM2JTF);

		nettoJTF = new JTextField();
		nettoJTF.setBounds(150, 190, 150, 20);
		add(nettoJTF);
				
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
				
			String kod = kodJTF.getText();
			String nazwa = nazwaJTF.getText();
			int ilosc = 0;
			int iloscM1 = 0;
			int iloscM2 = 0;
			double netto = 0.0;
			double vat = 0.23;
			double suma = ((ilosc + iloscM1 + iloscM2) * (netto * vat + netto));
					
			try {
				ilosc = Integer.parseInt(iloscJTF.getText());
			}
			catch(NumberFormatException xxx) {
				ilosc = 0;
				iloscJTF.setText("0");
			}
				
			try {
				iloscM1 = Integer.parseInt(iloscM1JTF.getText());
			}
			catch(NumberFormatException xxx) {
				iloscM1 = 0;
				iloscM1JTF.setText("0");
			}
			
			try {
				iloscM2 = Integer.parseInt(iloscM2JTF.getText());
			}
			catch(NumberFormatException xxx) {
				iloscM2 = 0;
				iloscM2JTF.setText("0");
			}
			
			
			try {
				netto = Double.parseDouble(nettoJTF.getText()); 
					 
			}
			catch(NumberFormatException xxx) {
				netto = 0.0;
				nettoJTF.setText("0");
			}
				
			ObslugaBazyDanych bd = new ObslugaBazyDanych();
				
			bd.dodajDane1(kod, nazwa, ilosc, iloscM1, iloscM2, netto, vat, suma);
				
			bd.zamknijPolaczenie();
				
			setVisible(false);
				
			InterfejsStanTowarowy ob = new InterfejsStanTowarowy();
			ob.setVisible(true);
				
		}
	}
}
