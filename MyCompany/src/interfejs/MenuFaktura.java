package interfejs;

import java.awt.GridLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;

import dane.Towar;
import dane.Klient;
import dane.Kontrahent;
import dane.SpisFakturPrzyjecia;
import dane.SpisFakturWydania;
import dane.SpisKlientow;
import dane.SpisKontrahentow;
import dane.StanTowarowy;
import obsluga_bazy_danych.ObslugaBazyDanych;

public class MenuFaktura extends JFrame implements ActionListener {
	
	private JButton przyjecieJB;
	private JButton wydanieJB;
	private JButton powrotMenuJB;
	
	public MenuFaktura() {
		
		super("Wybór Faktury");
		setSize(600, 400);
		setResizable(true);
		setLayout(new GridLayout(3, 1));
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);

		przyjecieJB = new JButton("Faktura przyjêcia");
		przyjecieJB.addActionListener(this);
		add(przyjecieJB);
		
		wydanieJB = new JButton("Faktura wydania");
		wydanieJB.addActionListener(this);
		add(wydanieJB);
		
		powrotMenuJB = new JButton("Powrót do menu g³ównego");
		powrotMenuJB.addActionListener(this);
		add(powrotMenuJB);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}


	ObslugaBazyDanych bd = new ObslugaBazyDanych();
	ArrayList<SpisFakturPrzyjecia> fakturaPrzyjecia = bd.pobierzDane4();
	ArrayList<SpisFakturWydania> fakturaWydania = bd.pobierzDane5();
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource().equals(przyjecieJB)) {
			FakturaPrzyjecieSpis ob = new FakturaPrzyjecieSpis();
			ob.setVisible(true);
			bd.zamknijPolaczenie();
		}	
		
		else if (e.getSource().equals(wydanieJB)) {
			FakturaWydanieSpis ob = new FakturaWydanieSpis();
			ob.setVisible(true);
			bd.zamknijPolaczenie();
		}

		else {
			Menu ob = new Menu();
			ob.setVisible(true);
			bd.zamknijPolaczenie();
		}
		
	}

}

