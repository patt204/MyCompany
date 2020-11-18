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

import dane.SpisKlientow;
import dane.SpisKontrahentow;
import dane.StanTowarowy;
import obsluga_bazy_danych.ObslugaBazyDanych;

public class KontrahentSpis extends JFrame implements ActionListener {

	protected JTable tabelaKontrahentow;
	private JScrollPane scroll;

	private JButton dodajJB;
	private JButton edytujJB;
	private JButton usunJB;
	private JButton szukajJB;

	private JLabel idKoJL;

	private JTextField idKoJTF;

	public KontrahentSpis() {

		setTitle("Spis kontrahentow");
		setResizable(true);
		setSize(600, 500);
		setLayout(null);

		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);

		ObslugaBazyDanych bd = new ObslugaBazyDanych();
		ArrayList<SpisKontrahentow> kontrahenci = bd.pobierzDane3();

		tabelaKontrahentow = new JTable(new ModelTabelaKontrahent(kontrahenci));
		scroll = new JScrollPane(tabelaKontrahentow);
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
		
		szukajJB = new JButton("Szukaj");
		szukajJB.setBounds(10, 380, 175, 20);
		szukajJB.addActionListener(this);
		add(szukajJB);

		idKoJL = new JLabel("ID:");
		idKoJL.setBounds(15, 185, 100, 20);
		add(idKoJL);
		idKoJL.setVisible(false);

		idKoJTF = new JTextField();
		idKoJTF.setBounds(105, 185, 100, 20);
		add(idKoJTF);
		idKoJTF.setVisible(false);

		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
	}

	ObslugaBazyDanych bd = new ObslugaBazyDanych();

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(dodajJB)) {
			KontrahentDodaj ob = new KontrahentDodaj();
			ob.setVisible(true);
			setVisible(false);
		} else if (e.getSource().equals(edytujJB)) {
			KontrahentEdytuj ob = new KontrahentEdytuj();
			ob.setVisible(true);
			setVisible(false);
		} else if (e.getSource().equals(usunJB)) {
			KontrahentUsun ob = new KontrahentUsun();
			ob.setVisible(true);
			setVisible(false);
		} else {
			KontrahentSzukaj ob = new KontrahentSzukaj();
			ob.setVisible(true);
			setVisible(false);
		}
	}
}

