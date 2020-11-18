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

public class InterfejsUsunTowar extends JFrame implements ActionListener {

	private JTable tabelaTowarow;
	private JScrollPane scroll;
	private JLabel idJL;
	private JTextField idJTF;
	private JButton usunJB;
	private JButton anulujJB;

	public InterfejsUsunTowar() {

		setTitle("Usuwanie towaru");
		setResizable(true);
		setSize(600, 400);
		setLayout(null);

		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);

		ObslugaBazyDanych bd = new ObslugaBazyDanych();
		ArrayList<StanTowarowy> towary = bd.pobierzDane1();

		tabelaTowarow = new JTable(new ModelTabelaTowar(towary));
		scroll = new JScrollPane(tabelaTowarow);
		scroll.setBounds(10, 10, 565, 285);
		add(scroll);

		idJL = new JLabel("ID:");
		idJL.setBounds(240, 305, 20, 20);
		add(idJL);

		idJTF = new JTextField();
		idJTF.setBounds(270, 305, 100, 20);
		add(idJTF);

		usunJB = new JButton("Usun");
		usunJB.setBounds(65, 330, 150, 20);
		usunJB.addActionListener(this);
		add(usunJB);

		anulujJB = new JButton("Anuluj");
		anulujJB.setBounds(385, 330, 150, 20);
		anulujJB.addActionListener(this);
		add(anulujJB);

		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(usunJB)) {

			int id = 0;

			try {
				id = Integer.parseInt(idJTF.getText());
			} catch (NumberFormatException xxx) {
				id = 1;
				idJTF.setText("1");
			}

			ObslugaBazyDanych bd = new ObslugaBazyDanych();
			bd.usunDane(id);
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
