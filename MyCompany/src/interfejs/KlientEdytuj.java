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
import dane.StanTowarowy;
import obsluga_bazy_danych.ObslugaBazyDanych;

public class KlientEdytuj extends JFrame implements ActionListener {

	private JTable tabelaKlientow;
	private JScrollPane scroll;

	private JButton zapiszJB;
	private JButton anulujJB;

	private JLabel idJL;
	private JLabel edycjaJL;
	private JLabel skrotNazwaJL;
	private JLabel pelnaNazwaJL;
	private JLabel nipJL;
	private JLabel adresJL;
	private JLabel telefonJL;
	private JLabel inneKlientJL;

	private JTextField idJTF;
	private JTextField skrotNazwaJTF;
	private JTextField pelnaNazwaJTF;
	private JTextField nipJTF;
	private JTextField adresJTF;
	private JTextField telefonJTF;
	private JTextField inneKlientJTF;

	public KlientEdytuj() {

		setTitle("Edycja klienta");
		setResizable(true);
		setSize(600, 500);
		setLayout(null);
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);

		ObslugaBazyDanych bd = new ObslugaBazyDanych();
		ArrayList<SpisKlientow> klienci = bd.pobierzDane2();

		tabelaKlientow = new JTable(new ModelTabelaKlient(klienci));
		scroll = new JScrollPane(tabelaKlientow);
		scroll.setBounds(10, 10, 565, 210);
		add(scroll);

		idJL = new JLabel("WYBIERZ ID:");
		idJL.setBounds(15, 245, 100, 20);
		add(idJL);

		edycjaJL = new JLabel("WPISZ ZMIANY:");
		edycjaJL.setBounds(225, 270, 100, 20);
		add(edycjaJL);
		
		skrotNazwaJL = new JLabel("Imie:");
		skrotNazwaJL.setBounds(15, 295, 100, 20);
		add(skrotNazwaJL);

		pelnaNazwaJL = new JLabel("Nazwisko/nazwa:");
		pelnaNazwaJL.setBounds(335, 295, 100, 20);
		add(pelnaNazwaJL);

		nipJL = new JLabel("Nip:");
		nipJL.setBounds(15, 345, 100, 20);
		add(nipJL);

		adresJL = new JLabel("Adres:");
		adresJL.setBounds(335, 345, 100, 20);
		add(adresJL);
		
		telefonJL = new JLabel("Telefon:");
		telefonJL.setBounds(15, 395, 100, 20);
		add(telefonJL);
		
		inneKlientJL = new JLabel("Inne:");
		inneKlientJL.setBounds(335, 395, 100, 20);
		add(inneKlientJL);
		
		idJTF = new JTextField();
		idJTF.setBounds(105, 245, 100, 20);
		add(idJTF);
		//430

		skrotNazwaJTF = new JTextField();
		skrotNazwaJTF.setBounds(105, 295, 100, 20);
		add(skrotNazwaJTF);

		pelnaNazwaJTF = new JTextField();
		pelnaNazwaJTF.setBounds(430, 295, 100, 20);
		add(pelnaNazwaJTF);

		nipJTF = new JTextField();
		nipJTF.setBounds(105, 345, 100, 20);
		add(nipJTF);
		
		adresJTF = new JTextField();
		adresJTF.setBounds(430, 345, 100, 20);
		add(adresJTF);
		
		telefonJTF = new JTextField();
		telefonJTF.setBounds(105, 395, 100, 20);
		add(telefonJTF);
		
		inneKlientJTF = new JTextField();
		inneKlientJTF.setBounds(430, 395, 100, 20);
		add(inneKlientJTF);

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
			String skrotNazwa = skrotNazwaJTF.getText();
			String pelnaNazwa = pelnaNazwaJTF.getText();
			String nip = nipJTF.getText();
			String adres = adresJTF.getText();
			String telefon = telefonJTF.getText();
			String inneKlient = inneKlientJTF.getText();
			
			try {
				id = Integer.parseInt(idJTF.getText());
			} catch (NumberFormatException xxx) {
				id = 1;
				idJTF.setText("1");
			}
			
			ObslugaBazyDanych bd = new ObslugaBazyDanych();

			bd.edytujDane2(skrotNazwa, pelnaNazwa, nip, adres, telefon, inneKlient, id);

			bd.zamknijPolaczenie();

			setVisible(false);

			KlientSpis ob = new KlientSpis();
			ob.setVisible(true);
		} else {

			setVisible(false);
			KlientSpis ob = new KlientSpis();
			ob.setVisible(true);

		}
	}

}

