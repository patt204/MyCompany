package interfejs;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/*import java.util.ArrayList;*/
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;

import dane.Towar;
import dane.Klient;
import dane.Kontrahent;
/*import dane.Magazyn;*/
import dane.SpisKlientow;
import dane.SpisKontrahentow;
import dane.StanTowarowy;
import obsluga_bazy_danych.ObslugaBazyDanych;

public class Menu extends JFrame implements ActionListener {
	
	private JButton towaryJB;
	private JButton klientJB;
	private JButton kontrahentJB;
	private JButton fakturaJB;
	
	public Menu() {
		
		super("Menu");
		setSize(600, 400);
		setResizable(true);
		setLayout(new GridLayout(2, 2));
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);

		towaryJB = new JButton("Towar");
		towaryJB.addActionListener(this);
		add(towaryJB);
		
		klientJB = new JButton("Klient");
		klientJB.addActionListener(this);
		add(klientJB);
		
		kontrahentJB = new JButton("Kontrahent");
		kontrahentJB.addActionListener(this);
		add(kontrahentJB);
		
		fakturaJB = new JButton("Faktura");
		fakturaJB.addActionListener(this);
		add(fakturaJB);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	ObslugaBazyDanych bd = new ObslugaBazyDanych();
	ArrayList<StanTowarowy> towary = bd.pobierzDane1();
	ArrayList<SpisKlientow> klient = bd.pobierzDane2();
	ArrayList<SpisKontrahentow> kontrahent = bd.pobierzDane3();
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource().equals(towaryJB)) {
			InterfejsStanTowarowy ob = new InterfejsStanTowarowy();
			ob.setVisible(true);
			bd.zamknijPolaczenie();
		}	
		
		else if (e.getSource().equals(klientJB)) {
			KlientSpis ob = new KlientSpis();
			ob.setVisible(true);
			bd.zamknijPolaczenie();
		}
		else if (e.getSource().equals(kontrahentJB)) {
			KontrahentSpis ob = new KontrahentSpis();
			ob.setVisible(true);
			bd.zamknijPolaczenie();
		}
		else {
			MenuFaktura ob = new MenuFaktura();
			ob.setVisible(true);
			bd.zamknijPolaczenie();
		}
		
	}

}

