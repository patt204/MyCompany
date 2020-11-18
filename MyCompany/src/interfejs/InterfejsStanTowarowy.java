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
import interfejs.InterfejsEdycjaTowaru;
import interfejs.InterfejsTowar;
import interfejs.InterfejsUsunTowar;
import interfejs.ModelTabelaTowar;

public class InterfejsStanTowarowy extends JFrame implements ActionListener {

	public JTable tabelaTowarow;
	private JScrollPane scroll;

	private JButton dodajJB;
	private JButton edytujJB;
	private JButton usunJB;
	private JButton szukajJB;

	private JLabel idJL;

	private JTextField idJTF;

	public InterfejsStanTowarowy() {

		setTitle("Stan towarowy");
		setResizable(true);
		setSize(600, 500);
		setLayout(null);

		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);

		ObslugaBazyDanych bd = new ObslugaBazyDanych();
		ArrayList<StanTowarowy> towary = bd.pobierzDane1(); 

		tabelaTowarow = new JTable(new ModelTabelaTowar(towary));
		scroll = new JScrollPane(tabelaTowarow);
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
			InterfejsTowar ob = new InterfejsTowar();
			ob.setVisible(true);
			setVisible(false);
		} else if (e.getSource().equals(edytujJB)) {
			InterfejsEdycjaTowaru ob = new InterfejsEdycjaTowaru();
			ob.setVisible(true);
			setVisible(false);
		} else if (e.getSource().equals(usunJB)) {
			InterfejsUsunTowar ob = new InterfejsUsunTowar();
			ob.setVisible(true);
			setVisible(false);
		} else {
			InterfejsSzukajTowar ob = new InterfejsSzukajTowar();
			ob.setVisible(true);
			setVisible(false);
		}
	}
}
