package interfejs;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import dane.SpisFakturPrzyjecia;
import dane.SpisKontrahentow;
import obsluga_bazy_danych.ObslugaBazyDanych;
import interfejs.KontrahentSpis;

public class FakturaPrzyjecieIleIdTowarow extends JFrame implements ActionListener{

	private JLabel iloscPozycjiJL;
	private JLabel maksJL;
	private JTextField iloscPozycjiJTF;

	private JButton okJB;
	
	public FakturaPrzyjecieIleIdTowarow() {
		
		super("Iloœæ pozycji w fakturze");
		setSize(600, 400);
		setResizable(true);
		setLayout(null);

		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);

		maksJL = new JLabel("WPISZ LICZBÊ od 1 do 10");
		maksJL.setBounds(150, 40, 150, 20);
		add(maksJL);
		
		iloscPozycjiJL = new JLabel("Iloœæ pozycji towarów:");
		iloscPozycjiJL.setBounds(10, 70, 150, 20);
		add(iloscPozycjiJL);

		/*dataJTF = new JTextField();
		dataJTF.setBounds(150, 40, 150, 20);
		add(dataJTF);*/
		
		iloscPozycjiJTF = new JTextField();
		iloscPozycjiJTF.setBounds(150, 70, 150, 20);
		add(iloscPozycjiJTF);
		
		ObslugaBazyDanych bd = new ObslugaBazyDanych ();

		okJB = new JButton("OK");
		okJB.setBounds(330, 330, 200, 20);
		okJB.addActionListener(this);
		add(okJB);

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		ObslugaBazyDanych bd = new ObslugaBazyDanych();

		if (e.getSource().equals(okJB)) {
			
			String iloscPozycji = iloscPozycjiJTF.getText();

			//bd.dodajDane4(data, nazwaFaktury, wystawiajacy, odbiorca, platnosc, idTowarow, sumaTowarow);
			//ArrayList<SpisFakturPrzyjecia> faktury = bd.pobierzDane4();
			bd.zamknijPolaczenie();

			//setVisible(false);
			//FakturaPrzyjecieSpis ob = new FakturaPrzyjecieSpis();
			//ob.setVisible(true);
		}

		}
}


