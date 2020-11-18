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
import obsluga_bazy_danych.ObslugaBazyDanych;

public class FakturaPrzyjecieEdytuj extends JFrame implements ActionListener {

	private JTable tabelaFaktur;
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
	private JLabel towar1JL;
	private JLabel ilosc1JL;
	private JLabel towar2JL;
	private JLabel ilosc2JL;
	private JLabel towar3JL;
	private JLabel ilosc3JL;
	private JLabel towar4JL;
	private JLabel ilosc4JL;
	private JLabel towar5JL;
	private JLabel ilosc5JL;
	private JLabel towar6JL;
	private JLabel ilosc6JL;
	private JLabel towar7JL;
	private JLabel ilosc7JL;
	private JLabel towar8JL;
	private JLabel ilosc8JL;
	private JLabel towar9JL;
	private JLabel ilosc9JL;
	private JLabel towar10JL;
	private JLabel ilosc10JL;
	private JLabel sumaTowarowJL;

	private JTextField idJTF;
	private JTextField dataJTF;
	private JTextField nazwaFakturyJTF;
	private JTextField ilosc1JTF;
	private JTextField ilosc2JTF;
	private JTextField ilosc3JTF;
	private JTextField ilosc4JTF;
	private JTextField ilosc5JTF;
	private JTextField ilosc6JTF;
	private JTextField ilosc7JTF;
	private JTextField ilosc8JTF;
	private JTextField ilosc9JTF;
	private JTextField ilosc10JTF;
	private JTextField sumaTowarowJTF;
	
	private JComboBox wystawiajacyListaJCB;
	private JComboBox odbiorcaListaJCB;
	private JComboBox platnoscListaJCB;
	private JComboBox towar1ListaJCB;
	private JComboBox towar2ListaJCB;
	private JComboBox towar3ListaJCB;
	private JComboBox towar4ListaJCB;
	private JComboBox towar5ListaJCB;
	private JComboBox towar6ListaJCB;
	private JComboBox towar7ListaJCB;
	private JComboBox towar8ListaJCB;
	private JComboBox towar9ListaJCB;
	private JComboBox towar10ListaJCB;

	public FakturaPrzyjecieEdytuj() {

		setTitle("Edycja faktury przyjêcia");
		setResizable(true);
		setSize(1370, 700);
		setLayout(null);

		//lokalizacja okna po srodku ekranu w zaleznosci od rozmiara ekranu uzytkownika
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);

		ObslugaBazyDanych bd = new ObslugaBazyDanych();
		ArrayList<SpisFakturPrzyjecia> fakturyPrzyjecia = bd.pobierzDane4();

		tabelaFaktur = new JTable(new ModelTabelaFaktura(fakturyPrzyjecia));
		scroll = new JScrollPane(tabelaFaktur);
		//scroll.setBounds(10, 10, 565, 210);
		scroll.setBounds(10, 10, 1335, 210);
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
		wystawiajacyJL.setBounds(655, 295, 100, 20);
		add(wystawiajacyJL);
		
		odbiorcaJL = new JLabel("Odbiorca:");
		odbiorcaJL.setBounds(975, 295, 100, 20);
		add(odbiorcaJL);

		platnoscJL = new JLabel("P³atnoœæ:");
		platnoscJL.setBounds(15, 345, 100, 20);
		add(platnoscJL);

		towar1JL = new JLabel("Towar 1:");
		towar1JL.setBounds(335, 345, 100, 20);
		add(towar1JL);
		
		ilosc1JL = new JLabel("Iloœæ 1:");
		ilosc1JL.setBounds(655, 345, 100, 20);
		add(ilosc1JL);
		
		towar2JL = new JLabel("Towar 2:");
		towar2JL.setBounds(15, 395, 100, 20);
		add(towar2JL);
		
		ilosc2JL = new JLabel("Iloœæ 2:");
		ilosc2JL.setBounds(335, 395, 100, 20);
		add(ilosc2JL);
		
		towar3JL = new JLabel("Towar 3:");
		towar3JL.setBounds(655, 395, 100, 20);
		add(towar3JL);
		
		ilosc3JL = new JLabel("Iloœæ 3:");
		ilosc3JL.setBounds(975, 395, 100, 20);
		add(ilosc3JL);
		
		towar4JL = new JLabel("Towar 4:");
		towar4JL.setBounds(15, 445, 100, 20);
		add(towar4JL);
		
		ilosc4JL = new JLabel("Iloœæ 4:");
		ilosc4JL.setBounds(335, 445, 100, 20);
		add(ilosc4JL);
		
		towar5JL = new JLabel("Towar 5:");
		towar5JL.setBounds(655, 445, 100, 20);
		add(towar5JL);
		
		ilosc5JL = new JLabel("Iloœæ 5:");
		ilosc5JL.setBounds(975, 445, 100, 20);
		add(ilosc5JL);
		
		towar6JL = new JLabel("Towar 6:");
		towar6JL.setBounds(15, 495, 100, 20);
		add(towar6JL);
		
		ilosc6JL = new JLabel("Iloœæ 6:");
		ilosc6JL.setBounds(335, 495, 100, 20);
		add(ilosc6JL);
		
		towar7JL = new JLabel("Towar 7:");
		towar7JL.setBounds(655, 495, 100, 20);
		add(towar7JL);
		
		ilosc7JL = new JLabel("Iloœæ 7:");
		ilosc7JL.setBounds(975, 495, 100, 20);
		add(ilosc7JL);
		
		towar8JL = new JLabel("Towar 8:");
		towar8JL.setBounds(15, 545, 100, 20);
		add(towar8JL);
		
		ilosc8JL = new JLabel("Iloœæ 8:");
		ilosc8JL.setBounds(335, 545, 100, 20);
		add(ilosc8JL);
		
		towar9JL = new JLabel("Towar 9:");
		towar9JL.setBounds(655, 545, 100, 20);
		add(towar9JL);
		
		ilosc9JL = new JLabel("Iloœæ 9:");
		ilosc9JL.setBounds(975, 545, 100, 20);
		add(ilosc9JL);
		
		towar10JL = new JLabel("Towar 10:");
		towar10JL.setBounds(15, 595, 100, 20);
		add(towar10JL);
		
		ilosc10JL = new JLabel("Iloœæ 10:");
		ilosc10JL.setBounds(335, 595, 100, 20);
		add(ilosc10JL);
		
		idJTF = new JTextField();
		idJTF.setBounds(105, 245, 100, 20);
		add(idJTF);
		//430

		dataJTF = new JTextField();
		dataJTF.setBounds(105, 295, 100, 20);
		add(dataJTF);

		nazwaFakturyJTF = new JTextField();
		nazwaFakturyJTF.setBounds(425, 295, 100, 20);
		add(nazwaFakturyJTF);
		
		int liczbaWierszyKontrahent = 0;
		KontrahentSpis ob = new KontrahentSpis();
		ob.setVisible(false);
		liczbaWierszyKontrahent =ob.tabelaKontrahentow.getRowCount() + 1;
		String[] wystawiajacy = new String[liczbaWierszyKontrahent];
		
			for(int i = 0; i < liczbaWierszyKontrahent; i++) {
				wystawiajacy [i] = bd.pobierzNazweKontrahent(i+1);
					};
		wystawiajacyListaJCB = new JComboBox(wystawiajacy);
		wystawiajacyListaJCB.setBounds(745, 295, 100, 20);
		
		wystawiajacyListaJCB.setSelectedIndex(0);
		wystawiajacyListaJCB.addActionListener(this);
		add(wystawiajacyListaJCB);
		
		String[] odbiorca = {"", "Sklep 1", "Sklep 2", "Magazyn"};
		odbiorcaListaJCB = new JComboBox(odbiorca);
		odbiorcaListaJCB.setBounds(1065, 295, 100, 20);

		odbiorcaListaJCB.setSelectedIndex(0);
		odbiorcaListaJCB.addActionListener(this);
		add(odbiorcaListaJCB);
		
		String[] platnosc = {"", "Gotówka", "Przelew"};
		platnoscListaJCB = new JComboBox(platnosc);
		platnoscListaJCB.setBounds(105, 345, 100, 20);

		platnoscListaJCB.setSelectedIndex(0);
		platnoscListaJCB.addActionListener(this);
		add(platnoscListaJCB);
		
		int liczbaWierszyTowar = 0;
		InterfejsStanTowarowy ob1 = new InterfejsStanTowarowy();
		ob1.setVisible(false);
		liczbaWierszyTowar = ob1.tabelaTowarow.getRowCount() + 1;
		String[] towar1 = new String[liczbaWierszyTowar];
		
			for(int i = 0; i < liczbaWierszyTowar; i++) {
				towar1 [i] = bd.pobierzNazweTowar(i);
					};
		towar1ListaJCB = new JComboBox(towar1);
		towar1ListaJCB.setBounds(425, 345, 150, 20);

		towar1ListaJCB.setSelectedIndex(0);
		towar1ListaJCB.addActionListener(this);
		add(towar1ListaJCB);
		
		ilosc1JTF = new JTextField();
		ilosc1JTF.setBounds(745, 345, 100, 20);
		add(ilosc1JTF);
		
		int liczbaWierszyTowar2 = 0;
		InterfejsStanTowarowy ob2 = new InterfejsStanTowarowy();
		ob2.setVisible(true);
		liczbaWierszyTowar2 = ob2.tabelaTowarow.getRowCount() + 1;
		String[] towar2 = new String[liczbaWierszyTowar2];
		
			for(int i = 0; i < liczbaWierszyTowar2; i++) {
				towar2 [i] = bd.pobierzNazweTowar(i);
					};
		towar2ListaJCB = new JComboBox(towar2);
		towar2ListaJCB.setBounds(105, 395, 150, 20);

		towar2ListaJCB.setSelectedIndex(0);
		towar2ListaJCB.addActionListener(this);
		add(towar2ListaJCB);
		
		ilosc2JTF = new JTextField();
		ilosc2JTF.setBounds(425, 395, 100, 20);
		add(ilosc2JTF);
		
		int liczbaWierszyTowar3 = 0;
		InterfejsStanTowarowy ob3 = new InterfejsStanTowarowy();
		ob3.setVisible(true);
		liczbaWierszyTowar3 = ob2.tabelaTowarow.getRowCount() + 1;
		String[] towar3 = new String[liczbaWierszyTowar3];
		
			for(int i = 0; i < liczbaWierszyTowar3; i++) {
				towar3 [i] = bd.pobierzNazweTowar(i);
					};
		towar3ListaJCB = new JComboBox(towar3);
		towar3ListaJCB.setBounds(745, 395, 150, 20);

		towar3ListaJCB.setSelectedIndex(0);
		towar3ListaJCB.addActionListener(this);
		add(towar3ListaJCB);
		
		ilosc3JTF = new JTextField();
		ilosc3JTF.setBounds(1065, 395, 100, 20);
		add(ilosc3JTF);
		
		
		int liczbaWierszyTowar4 = 0;
		InterfejsStanTowarowy ob4 = new InterfejsStanTowarowy();
		ob4.setVisible(true);
		liczbaWierszyTowar4 = ob4.tabelaTowarow.getRowCount() + 1;
		String[] towar4 = new String[liczbaWierszyTowar4];
		
			for(int i = 0; i < liczbaWierszyTowar4; i++) {
				towar4 [i] = bd.pobierzNazweTowar(i);
					};
		towar4ListaJCB = new JComboBox(towar4);
		towar4ListaJCB.setBounds(105, 445, 150, 20);

		towar4ListaJCB.setSelectedIndex(0);
		towar4ListaJCB.addActionListener(this);
		add(towar4ListaJCB);
		
		ilosc4JTF = new JTextField();
		ilosc4JTF.setBounds(425, 445, 100, 20);
		add(ilosc4JTF);
		
		int liczbaWierszyTowar5 = 0;
		InterfejsStanTowarowy ob5 = new InterfejsStanTowarowy();
		ob5.setVisible(true);
		liczbaWierszyTowar5 = ob5.tabelaTowarow.getRowCount() + 1;
		String[] towar5 = new String[liczbaWierszyTowar5];
		
			for(int i = 0; i < liczbaWierszyTowar5; i++) {
				towar5 [i] = bd.pobierzNazweTowar(i);
					};
		towar5ListaJCB = new JComboBox(towar5);
		towar5ListaJCB.setBounds(745, 445, 150, 20);

		towar5ListaJCB.setSelectedIndex(0);
		towar5ListaJCB.addActionListener(this);
		add(towar5ListaJCB);
		
		ilosc5JTF = new JTextField();
		ilosc5JTF.setBounds(1065, 445, 100, 20);
		add(ilosc5JTF);
		
		int liczbaWierszyTowar6 = 0;
		InterfejsStanTowarowy ob6 = new InterfejsStanTowarowy();
		ob6.setVisible(true);
		liczbaWierszyTowar6 = ob6.tabelaTowarow.getRowCount() + 1;
		String[] towar6 = new String[liczbaWierszyTowar6];
		
			for(int i = 0; i < liczbaWierszyTowar6; i++) {
				towar6 [i] = bd.pobierzNazweTowar(i);
					};
		towar6ListaJCB = new JComboBox(towar6);
		towar6ListaJCB.setBounds(105, 495, 150, 20);

		towar6ListaJCB.setSelectedIndex(0);
		towar6ListaJCB.addActionListener(this);
		add(towar6ListaJCB);
		
		ilosc6JTF = new JTextField();
		ilosc6JTF.setBounds(425, 495, 100, 20);
		add(ilosc6JTF);
		
		int liczbaWierszyTowar7 = 0;
		InterfejsStanTowarowy ob7 = new InterfejsStanTowarowy();
		ob7.setVisible(true);
		liczbaWierszyTowar5 = ob7.tabelaTowarow.getRowCount() + 1;
		String[] towar7 = new String[liczbaWierszyTowar7];
		
			for(int i = 0; i < liczbaWierszyTowar7; i++) {
				towar7 [i] = bd.pobierzNazweTowar(i);
					};
		towar7ListaJCB = new JComboBox(towar7);
		towar7ListaJCB.setBounds(745, 545, 150, 20);

		towar7ListaJCB.setSelectedIndex(0);
		towar7ListaJCB.addActionListener(this);
		add(towar7ListaJCB);
		
		ilosc7JTF = new JTextField();
		ilosc7JTF.setBounds(1065, 545, 100, 20);
		add(ilosc7JTF);
		
		
		int liczbaWierszyTowar8 = 0;
		InterfejsStanTowarowy ob8 = new InterfejsStanTowarowy();
		ob8.setVisible(true);
		liczbaWierszyTowar8 = ob8.tabelaTowarow.getRowCount() + 1;
		String[] towar8 = new String[liczbaWierszyTowar6];
		
			for(int i = 0; i < liczbaWierszyTowar6; i++) {
				towar8 [i] = bd.pobierzNazweTowar(i);
					};
		towar8ListaJCB = new JComboBox(towar8);
		towar8ListaJCB.setBounds(105, 595, 150, 20);

		towar8ListaJCB.setSelectedIndex(0);
		towar8ListaJCB.addActionListener(this);
		add(towar8ListaJCB);
		
		ilosc8JTF = new JTextField();
		ilosc8JTF.setBounds(425, 595, 100, 20);
		add(ilosc8JTF);
		
		int liczbaWierszyTowar9 = 0;
		InterfejsStanTowarowy ob9 = new InterfejsStanTowarowy();
		ob9.setVisible(true);
		liczbaWierszyTowar9 = ob9.tabelaTowarow.getRowCount() + 1;
		String[] towar9 = new String[liczbaWierszyTowar9];
		
			for(int i = 0; i < liczbaWierszyTowar9; i++) {
				towar9 [i] = bd.pobierzNazweTowar(i);
					};
		towar9ListaJCB = new JComboBox(towar7);
		towar9ListaJCB.setBounds(745, 595, 150, 20);

		towar9ListaJCB.setSelectedIndex(0);
		towar9ListaJCB.addActionListener(this);
		add(towar9ListaJCB);
		
		ilosc9JTF = new JTextField();
		ilosc9JTF.setBounds(1065, 595, 100, 20);
		add(ilosc9JTF);
		
		//idTowarowJTF = new JTextField();
		//idTowarowJTF.setBounds(430, 395, 100, 20);
		//add(idTowarowJTF);
		
		//sumaTowarowJTF = new JTextField();
		//sumaTowarowJTF.setBounds(105, 445, 100, 20);
		//add(sumaTowarowJTF);

		zapiszJB = new JButton("Zapisz");
		zapiszJB.setBounds(400, 630, 175, 20);
		zapiszJB.addActionListener(this);
		add(zapiszJB);

		anulujJB = new JButton("Anuluj");
		anulujJB.setBounds(605, 630, 175, 20);
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
			//String idTowarow = idTowarowJTF.getText();
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

			//bd.edytujDane4(data, nazwaFaktury, wystawiajacy, odbiorca, platnosc, idTowarow, iloscTowarow, sumaTowarow, id);

			bd.zamknijPolaczenie();

			//setVisible(false);

			FakturaPrzyjecieSpis ob = new FakturaPrzyjecieSpis();
			ob.setVisible(true);
			
			setVisible(false);
		} 
		if (e.getSource().equals(anulujJB)) {

			setVisible(false);
			FakturaPrzyjecieSpis ob = new FakturaPrzyjecieSpis();
			ob.setVisible(true);

		}
	}

}


