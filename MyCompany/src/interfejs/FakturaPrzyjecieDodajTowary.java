package interfejs;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import obsluga_bazy_danych.ObslugaBazyDanych;

public class FakturaPrzyjecieDodajTowary extends JFrame implements ActionListener{

	private JLabel towarJL;

	private JButton zapiszJB;
	private JButton dodajOkienkoJB;
	
	private JComboBox towary2ListaJCB;
	
public FakturaPrzyjecieDodajTowary() {
		
		super("Towary faktury przyjecia");
		setSize(600, 400);
		setResizable(true);
		setLayout(null);

		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
		
		towarJL = new JLabel("Towar:");
		towarJL.setBounds(10, 40, 150, 20);
		add(towarJL);
		
		ObslugaBazyDanych bd = new ObslugaBazyDanych ();
		
		dodajOkienkoJB = new JButton("Wpisz kolejne");
		dodajOkienkoJB.setBounds(330, 40, 150, 20);
		dodajOkienkoJB.addActionListener(this);
		add(dodajOkienkoJB);
		
		zapiszJB = new JButton("Zapisz");
		zapiszJB.setBounds(330, 330, 200, 20);
		zapiszJB.addActionListener(this);
		add(zapiszJB);
		
		int liczbaWierszyTowary = 0;
		InterfejsStanTowarowy ob = new InterfejsStanTowarowy();
		//ob.setVisible(false);
		liczbaWierszyTowary = ob.tabelaTowarow.getRowCount();
		String[] towary2 = new String[liczbaWierszyTowary];
		
			for(int i = 0; i < liczbaWierszyTowary; i++) {
				//towary2 [i] = bd.pobierzNazweTowar(i+1);
		
			};

			
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
		}

@Override
public void actionPerformed(ActionEvent e) {
	ObslugaBazyDanych bd = new ObslugaBazyDanych();
		
	if (e.getSource().equals(zapiszJB)) {

		int id = 0;
		int liczbaSztuk = 0;
		double sumaTowarow = 0.0;
		
		//String wystawiajacy = (String) wystawiajacyListaJCB.getSelectedItem();
		//int a = wystawiajacyListaJCB.getSelectedIndex();
		
		//bd.dodajDane4(data, nazwaFaktury, wystawiajacy, odbiorca, platnosc, idTowarow, sumaTowarow);
		bd.zamknijPolaczenie();

		setVisible(false);
		FakturaPrzyjecieSpis ob = new FakturaPrzyjecieSpis();
		ob.setVisible(true);
}
	if (e.getSource().equals(dodajOkienkoJB)) {
		towary2ListaJCB = new JComboBox();
		towary2ListaJCB.setBounds(190, 40, 150, 20);
		
		towary2ListaJCB.setSelectedIndex(0);
		towary2ListaJCB.addActionListener(this);
		add(towary2ListaJCB);
			
	}
}
}
