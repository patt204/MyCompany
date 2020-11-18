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

import dane.FakturaPrzyjecie;
import dane.SpisFakturPrzyjecia;
import dane.SpisFakturWydania;
import obsluga_bazy_danych.ObslugaBazyDanych;

public class FakturaWydanieEdytuj extends JFrame implements ActionListener {

	private JTable tabelaFakturWydania;
	private JScrollPane scroll;

	private JButton wybierzJB;
	private JButton zapiszJB;
	private JButton anulujJB;

	private JLabel idJL;
	private JLabel edycjaJL;
	private JLabel dataJL;
	private JLabel nazwaFakturyJL;
	private JLabel wystawiajacyJL;
	private JLabel odbiorcaJL;
	private JLabel platnoscJL;
	private JLabel oplataDoJL;
	private JLabel sumaTowarowJL;

	private JTextField idJTF;
	private JTextField dataJTF;
	private JTextField nazwaFakturyJTF;
	private JTextField oplataDoJTF;
	private JTextField sumaTowarowJTF;
	
	private JComboBox wystawiajacyListaJCB;
	private JComboBox odbiorcaListaJCB;
	private JComboBox platnoscListaJCB;

	public FakturaWydanieEdytuj() {

		setTitle("Edycja faktury wydania");
		setResizable(true);
		setSize(600, 600);
		setLayout(null);

		//lokalizacja okna po srodku ekranu w zaleznosci od rozmiara ekranu uzytkownika
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);

		ObslugaBazyDanych bd = new ObslugaBazyDanych();
		ArrayList<SpisFakturWydania> fakturyWydania = bd.pobierzDane5();

		tabelaFakturWydania = new JTable(new ModelTabelaFakturaWydania(fakturyWydania));
		scroll = new JScrollPane(tabelaFakturWydania);
		scroll.setBounds(10, 10, 565, 210);
		add(scroll);

		idJL = new JLabel("WYBIERZ ID:");
		idJL.setBounds(15, 245, 100, 20);
		add(idJL);

		edycjaJL = new JLabel("WPISZ ZMIANY:");
		edycjaJL.setBounds(225, 270, 100, 20);
		add(edycjaJL);
		
		dataJL = new JLabel("Data:");
		dataJL.setBounds(15, 295, 100, 20);
		add(dataJL);

		nazwaFakturyJL = new JLabel("Nazwa faktury:");
		nazwaFakturyJL.setBounds(335, 295, 100, 20);
		add(nazwaFakturyJL);

		wystawiajacyJL = new JLabel("Kontrahent:");
		wystawiajacyJL.setBounds(15, 345, 100, 20);
		add(wystawiajacyJL);

		odbiorcaJL = new JLabel("Odbiorca:");
		odbiorcaJL.setBounds(335, 345, 100, 20);
		add(odbiorcaJL);
		
		platnoscJL = new JLabel("P³atnoœæ:");
		platnoscJL.setBounds(15, 395, 100, 20);
		add(platnoscJL);
		
		oplataDoJL = new JLabel("Op³ata za dni:");
		oplataDoJL.setBounds(335, 395, 100, 20);
		add(oplataDoJL);
		
		sumaTowarowJL = new JLabel("Suma towarów:");
		sumaTowarowJL.setBounds(15, 445, 100, 20);
		add(sumaTowarowJL);
		
		idJTF = new JTextField();
		idJTF.setBounds(105, 245, 100, 20);
		add(idJTF);
		//430

		dataJTF = new JTextField();
		dataJTF.setBounds(105, 295, 100, 20);
		add(dataJTF);

		nazwaFakturyJTF = new JTextField();
		nazwaFakturyJTF.setBounds(430, 295, 100, 20);
		add(nazwaFakturyJTF);
		
		int liczbaWierszyKlient = 0;
		KlientSpis ob = new KlientSpis();
		ob.setVisible(false);
		liczbaWierszyKlient = ob.tabelaKlientow.getRowCount() + 1;
		String[] odbiorca = new String[liczbaWierszyKlient];
		
			for(int i = 0; i < liczbaWierszyKlient; i++) {
				odbiorca [i] = bd.pobierzNazweKlient(i);
					};
					
		odbiorcaListaJCB = new JComboBox(odbiorca);
		odbiorcaListaJCB.setBounds(105, 345, 100, 20);
		
		odbiorcaListaJCB.setSelectedIndex(0);
		odbiorcaListaJCB.addActionListener(this);
		add(odbiorcaListaJCB);
		
		String[] wystawiajacy = {"", "Sklep 1", "Sklep 2", "Magazyn"};
		wystawiajacyListaJCB = new JComboBox(odbiorca);
		wystawiajacyListaJCB.setBounds(430, 345, 100, 20);

		wystawiajacyListaJCB.setSelectedIndex(0);
		wystawiajacyListaJCB.addActionListener(this);
		add(wystawiajacyListaJCB);
		
		String[] platnosc = {"", "Gotówka", "Przelew"};
		platnoscListaJCB = new JComboBox(platnosc);
		platnoscListaJCB.setBounds(105, 395, 100, 20);

		platnoscListaJCB.setSelectedIndex(0);
		platnoscListaJCB.addActionListener(this);
		add(platnoscListaJCB);
		
		oplataDoJTF = new JTextField();
		oplataDoJTF.setBounds(430, 395, 100, 20);
		add(oplataDoJTF);
		
		sumaTowarowJTF = new JTextField();
		sumaTowarowJTF.setBounds(105, 445, 100, 20);
		add(sumaTowarowJTF);

		zapiszJB = new JButton("Zapisz");
		zapiszJB.setBounds(65, 495, 150, 20);
		zapiszJB.addActionListener(this);
		add(zapiszJB);

		anulujJB = new JButton("Anuluj");
		anulujJB.setBounds(385, 490, 150, 20);
		anulujJB.addActionListener(this);
		add(anulujJB);

		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource().equals(zapiszJB)) {

			int id = 0;
			String data = dataJTF.getText();
			String nazwaFaktury = nazwaFakturyJTF.getText();
			String oplataDo = oplataDoJTF.getText();
			String sumaTowarow = sumaTowarowJTF.getText();
			//double sumaTowarow = Double.parseDouble(sumaTowarowJTF.getText());
			
			//JComboBox cb1 = new JComboBox<>();
			//JComboBox cb2 = new JComboBox<>();
			//JComboBox cb3 = new JComboBox<>();
			
			String wystawiajacy = (String) wystawiajacyListaJCB.getSelectedItem();
			int a = wystawiajacyListaJCB.getSelectedIndex();
			
			String odbiorca = (String) odbiorcaListaJCB.getSelectedItem();
			int b = odbiorcaListaJCB.getSelectedIndex();
			
			String platnosc = (String) platnoscListaJCB.getSelectedItem();
			int c = platnoscListaJCB.getSelectedIndex();
			//String odbiorca = (String) cb2.getSelectedItem();
			//String platnosc = (String) cb3.getSelectedItem();
			//String lista = (String) cb1.getSelectedItem();
			//System.out.println("aaaa" + wystawiajacy + "\t" + a);

			
			try {
				id = Integer.parseInt(idJTF.getText());
			} catch (NumberFormatException xxx) {
				id = 1;
				idJTF.setText("1");
			}
			
			ObslugaBazyDanych bd = new ObslugaBazyDanych();

			bd.edytujDane5(data, nazwaFaktury, wystawiajacy, odbiorca, platnosc, oplataDo, sumaTowarow, id);

			bd.zamknijPolaczenie();

			//setVisible(false);

			FakturaWydanieSpis ob = new FakturaWydanieSpis();
			ob.setVisible(true);
			
			setVisible(false);
		} 
		if (e.getSource().equals(anulujJB)) {

			setVisible(false);
			FakturaWydanieSpis ob = new FakturaWydanieSpis();
			ob.setVisible(true);

		}
	}

}



