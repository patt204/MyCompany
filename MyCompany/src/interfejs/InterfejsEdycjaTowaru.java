package interfejs;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import dane.StanTowarowy;
import obsluga_bazy_danych.ObslugaBazyDanych;
import interfejs.InterfejsStanTowarowy;
import interfejs.ModelTabelaTowar;

public class InterfejsEdycjaTowaru extends JFrame implements ActionListener {

	private JTable tabelaTowarow;
	private JScrollPane scroll;

	private JButton zapiszJB;
	private JButton anulujJB;

	private JLabel idJL;
	private JLabel edycjaJL;
	private JLabel nazwaJL;
	private JLabel iloscJL;
	private JLabel iloscM1JL;
	private JLabel iloscM2JL;
	private JLabel cenaNettoJL;

	private JTextField idJTF;
	private JTextField nazwaJTF;
	private JTextField iloscJTF;
	private JTextField iloscM1JTF;
	private JTextField iloscM2JTF;
	private JTextField cenaNettoJTF;

	public InterfejsEdycjaTowaru() {

		setTitle("Edycja towaru");
		setResizable(true);
		setSize(600, 500);
		setLayout(null);
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);

		ObslugaBazyDanych bd = new ObslugaBazyDanych();
		ArrayList<StanTowarowy> towary = bd.pobierzDane1();

		tabelaTowarow = new JTable(new ModelTabelaTowar(towary));
		scroll = new JScrollPane(tabelaTowarow);
		scroll.setBounds(10, 10, 565, 210);
		add(scroll);

		idJL = new JLabel("WYBIERZ ID:");
		idJL.setBounds(15, 245, 100, 20);
		add(idJL);
		
		edycjaJL = new JLabel("WPISZ ZMIANY:");
		edycjaJL.setBounds(225, 270, 100, 20);
		add(edycjaJL);

		nazwaJL = new JLabel("Nazwa:");
		nazwaJL.setBounds(15, 295, 100, 20);
		add(nazwaJL);
		
		iloscJL = new JLabel("Ilosc:");
		iloscJL.setBounds(335, 295, 100, 20);
		add(iloscJL);
		
		iloscM1JL = new JLabel("Ilosc M1:");
		iloscM1JL.setBounds(15, 345, 100, 20);
		add(iloscM1JL);
		
		iloscM2JL = new JLabel("Ilosc M2:");
		iloscM2JL.setBounds(335, 345, 100, 20);
		add(iloscM2JL);

		cenaNettoJL = new JLabel("Cena netto:");
		cenaNettoJL.setBounds(15, 395, 100, 20);
		add(cenaNettoJL);

		idJTF = new JTextField();
		idJTF.setBounds(105, 245, 100, 20);
		add(idJTF);

		nazwaJTF = new JTextField();
		nazwaJTF.setBounds(105, 295, 100, 20);
		add(nazwaJTF);

		iloscJTF = new JTextField();
		iloscJTF.setBounds(430, 295, 100, 20);
		add(iloscJTF);

		iloscM1JTF = new JTextField();
		iloscM1JTF.setBounds(105, 345, 100, 20);
		add(iloscM1JTF);
		
		iloscM2JTF = new JTextField();
		iloscM2JTF.setBounds(430, 345, 100, 20);
		add(iloscM2JTF);
		
		cenaNettoJTF = new JTextField();
		cenaNettoJTF.setBounds(105, 395, 100, 20);
		add(cenaNettoJTF);

		zapiszJB = new JButton("Zapisz");
		zapiszJB.setBounds(65, 430, 150, 20);
		zapiszJB.addActionListener(this);
		add(zapiszJB);

		anulujJB = new JButton("Anuluj");
		anulujJB.setBounds(385, 430, 150, 20);
		anulujJB.addActionListener(this);
		add(anulujJB);

		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource().equals(zapiszJB)) {

			int id = 0;
			String nazwa = nazwaJTF.getText();
			int ilosc = 0;
			int iloscM1 = 0;
			int iloscM2 = 0;
			double cenaNetto = 0.0;

			try {
				id = Integer.parseInt(idJTF.getText());
			} catch (NumberFormatException xxx) {
				id = 1;
				idJTF.setText("1");
			}

			try {
				ilosc = Integer.parseInt(iloscJTF.getText());
			} catch (NumberFormatException xxx) {
				ilosc = 0;
				iloscJTF.setText("0");
			}

			try {
				iloscM1 = Integer.parseInt(iloscM1JTF.getText());
			} catch (NumberFormatException xxx) {
				iloscM1 = 0;
				iloscM1JTF.setText("0");
			}
			
			try {
				iloscM2 = Integer.parseInt(iloscM2JTF.getText());
			} catch (NumberFormatException xxx) {
				iloscM2 = 0;
				iloscM2JTF.setText("0");
			}
			
			try {
				cenaNetto = Double.parseDouble(cenaNettoJTF.getText());
			} catch (NumberFormatException xxx) {
				cenaNetto = 0.0;
				cenaNettoJTF.setText("0");
			}

			
			ObslugaBazyDanych bd = new ObslugaBazyDanych();

			bd.edytujDane(nazwa, ilosc, iloscM1, iloscM2, cenaNetto, id);

			bd.zamknijPolaczenie();

			setVisible(false);

			InterfejsStanTowarowy ob = new InterfejsStanTowarowy();
			ob.setVisible(true);
		} else {

			setVisible(false);
			InterfejsStanTowarowy ob = new InterfejsStanTowarowy();
			ob.setVisible(true);

		}
	}

}
