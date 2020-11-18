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

import dane.SpisKontrahentow;
import obsluga_bazy_danych.ObslugaBazyDanych;

public class KontrahentEdytuj extends JFrame implements ActionListener {

	private JTable tabelaKontrahentow;
	private JScrollPane scroll;

	private JButton zapiszJB;
	private JButton anulujJB;

	private JLabel idKontrahentJL;
	private JLabel edycjaKoJL;
	private JLabel skrotNazwaKoJL;
	private JLabel pelnaNazwaKoJL;
	private JLabel nipKoJL;
	private JLabel adresKoJL;
	private JLabel telefonKoJL;
	private JLabel inneKontrahentJL;

	private JTextField idKontrahentJTF;
	private JTextField skrotNazwaKoJTF;
	private JTextField pelnaNazwaKoJTF;
	private JTextField nipKoJTF;
	private JTextField adresKoJTF;
	private JTextField telefonKoJTF;
	private JTextField inneKontrahentJTF;

	public KontrahentEdytuj() {

		setTitle("Edycja kontrahenta");
		setResizable(true);
		setSize(600, 500);
		setLayout(null);

		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);

		ObslugaBazyDanych bd = new ObslugaBazyDanych();
		ArrayList<SpisKontrahentow> kontrahenci = bd.pobierzDane3();

		tabelaKontrahentow = new JTable(new ModelTabelaKontrahent(kontrahenci));
		scroll = new JScrollPane(tabelaKontrahentow);
		scroll.setBounds(10, 10, 565, 210);
		add(scroll);

		idKontrahentJL = new JLabel("WYBIERZ ID:");
		idKontrahentJL.setBounds(15, 245, 100, 20);
		add(idKontrahentJL);
		//335, 245, 100, 20

		edycjaKoJL = new JLabel("WPISZ ZMIANY:");
		edycjaKoJL.setBounds(225, 270, 100, 20);
		add(edycjaKoJL);
		
		skrotNazwaKoJL = new JLabel("Skrót nazwy:");
		skrotNazwaKoJL.setBounds(15, 295, 100, 20);
		add(skrotNazwaKoJL);

		pelnaNazwaKoJL = new JLabel("Pe³na nazwa:");
		pelnaNazwaKoJL.setBounds(335, 295, 100, 20);
		add(pelnaNazwaKoJL);

		nipKoJL = new JLabel("Nip:");
		nipKoJL.setBounds(15, 345, 100, 20);
		add(nipKoJL);

		adresKoJL = new JLabel("Adres:");
		adresKoJL.setBounds(335, 345, 100, 20);
		add(adresKoJL);
		
		telefonKoJL = new JLabel("Telefon:");
		telefonKoJL.setBounds(15, 395, 100, 20);
		add(telefonKoJL);
		
		inneKontrahentJL = new JLabel("Inne:");
		inneKontrahentJL.setBounds(335, 395, 100, 20);
		add(inneKontrahentJL);
		
		idKontrahentJTF = new JTextField();
		idKontrahentJTF.setBounds(105, 245, 100, 20);
		add(idKontrahentJTF);
		//430

		skrotNazwaKoJTF = new JTextField();
		skrotNazwaKoJTF.setBounds(105, 295, 100, 20);
		add(skrotNazwaKoJTF);

		pelnaNazwaKoJTF = new JTextField();
		pelnaNazwaKoJTF.setBounds(430, 295, 100, 20);
		add(pelnaNazwaKoJTF);

		nipKoJTF = new JTextField();
		nipKoJTF.setBounds(105, 345, 100, 20);
		add(nipKoJTF);
		
		adresKoJTF = new JTextField();
		adresKoJTF.setBounds(430, 345, 100, 20);
		add(adresKoJTF);
		
		telefonKoJTF = new JTextField();
		telefonKoJTF.setBounds(105, 395, 100, 20);
		add(telefonKoJTF);
		
		inneKontrahentJTF = new JTextField();
		inneKontrahentJTF.setBounds(430, 395, 100, 20);
		add(inneKontrahentJTF);

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

			int idKontrahent = 0;
			String skrotNazwaKo = skrotNazwaKoJTF.getText();
			String pelnaNazwaKo = pelnaNazwaKoJTF.getText();
			String nipKo = nipKoJTF.getText();
			String adresKo = adresKoJTF.getText();
			String telefonKo = telefonKoJTF.getText();
			String inneKontrahent = inneKontrahentJTF.getText();

			try {
				idKontrahent = Integer.parseInt(idKontrahentJTF.getText());
			} catch (NumberFormatException xxx) {
				idKontrahent = 1;
				idKontrahentJTF.setText("1");
			}
			
			ObslugaBazyDanych bd = new ObslugaBazyDanych();

			bd.edytujDane3(skrotNazwaKo, pelnaNazwaKo, nipKo, adresKo, telefonKo, inneKontrahent, idKontrahent);

			bd.zamknijPolaczenie();

			setVisible(false);

			KontrahentSpis ob = new KontrahentSpis();
			ob.setVisible(true);
		} else {

			setVisible(false);
			KontrahentSpis ob = new KontrahentSpis();
			ob.setVisible(true);

		}
	}

}

