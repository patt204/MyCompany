package interfejs;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import dane.SpisFakturPrzyjecia;
import dane.SpisFakturWydania;
import dane.StanTowarowy;
import obsluga_bazy_danych.ObslugaBazyDanych;

public class FakturaWydanieSpis extends JFrame implements ActionListener{

	private JTable tabelaFakturWydania;
	private JScrollPane scroll;
	
	private JButton dodajJB;
	private JButton edytujJB;
	private JButton usunJB;

	private JLabel idJL;

	private JTextField idJTF;
	
	public FakturaWydanieSpis() {
		
		setTitle("Spis faktur wydania");
		setResizable(true);
		setSize(600,400);
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		
		ObslugaBazyDanych bd = new ObslugaBazyDanych();
		ArrayList<SpisFakturWydania> fakturyWydania = bd.pobierzDane5();
		
		tabelaFakturWydania = new JTable(new ModelTabelaFakturaWydania(fakturyWydania));
		scroll = new JScrollPane(tabelaFakturWydania);
		scroll.setBounds(10, 10, 565, 300);
		add(scroll);

		bd.zamknijPolaczenie();

		dodajJB = new JButton("Dodaj");
		dodajJB.setBounds(10, 330, 175, 20);
		dodajJB.addActionListener(this);
		add(dodajJB);

		edytujJB = new JButton("Edytuj");
		edytujJB.setBounds(205, 330, 175, 20);
		edytujJB.addActionListener(this);
		add(edytujJB);

		usunJB = new JButton("Usun");
		usunJB.setBounds(400, 330, 175, 20);
		usunJB.addActionListener(this);
		add(usunJB);

		idJL = new JLabel("ID:");
		idJL.setBounds(15, 185, 100, 20);
		add(idJL);
		idJL.setVisible(false);

		idJTF = new JTextField();
		idJTF.setBounds(105, 185, 100, 20);
		add(idJTF);
		idJTF.setVisible(false);

		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
	}

	ObslugaBazyDanych bd = new ObslugaBazyDanych();

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(dodajJB)) {
			FakturaWydanieDodaj ob = new FakturaWydanieDodaj();
			ob.setVisible(true);
			setVisible(false);
		} else if (e.getSource().equals(edytujJB)) {
			FakturaWydanieEdytuj ob = new FakturaWydanieEdytuj();
			ob.setVisible(true);
			setVisible(false);
		} else {
			FakturaWydanieUsun ob = new FakturaWydanieUsun();
			ob.setVisible(true);
			setVisible(false);
		}
		
	}
}


