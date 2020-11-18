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

import dane.SpisFakturPrzyjecia;
import dane.SpisKontrahentow;
import obsluga_bazy_danych.ObslugaBazyDanych;
import interfejs.KontrahentSpis;

public class FakturaPrzyjecieDodaj extends JFrame implements ActionListener{

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

	private JButton zapiszJB;
	private JButton wybierzJB;
	
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
	
	public FakturaPrzyjecieDodaj() {
		
		super("Nowa faktura przyjêcia");
		setSize(800, 700);
		setResizable(true);
		setLayout(null);

		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);

		dataJL = new JLabel("Data:");
		dataJL.setBounds(10, 40, 150, 20);
		add(dataJL);
		
		nazwaFakturyJL = new JLabel("Nazwa faktury:");
		nazwaFakturyJL.setBounds(10, 70, 150, 20);
		add(nazwaFakturyJL);
		
		wystawiajacyJL = new JLabel("Kontrahent:");
		wystawiajacyJL.setBounds(10, 100, 150, 20);
		add(wystawiajacyJL);

		odbiorcaJL = new JLabel("Odbiorca:");
		odbiorcaJL.setBounds(10, 130, 150, 20);
		add(odbiorcaJL);

		platnoscJL = new JLabel("P³atnoœæ:");
		platnoscJL.setBounds(10, 160, 150, 20);
		add(platnoscJL);

		towar1JL = new JLabel("Kod towaru 1:");
		towar1JL.setBounds(10, 190, 150, 20);
		add(towar1JL);
		
		towar2JL = new JLabel("Kod towaru 2:");
		towar2JL.setBounds(10, 220, 150, 20);
		add(towar2JL);
		
		towar3JL = new JLabel("Kod towaru 3:");
		towar3JL.setBounds(10, 250, 150, 20);
		add(towar3JL);
		
		towar4JL = new JLabel("Kod towaru 4:");
		towar4JL.setBounds(10, 280, 150, 20);
		add(towar4JL);
		
		towar5JL = new JLabel("Kod towaru 5:");
		towar5JL.setBounds(10, 310, 150, 20);
		add(towar5JL);
		
		towar6JL = new JLabel("Kod towaru 6:");
		towar6JL.setBounds(10, 340, 150, 20);
		add(towar6JL);
		
		towar7JL = new JLabel("Kod towaru 7:");
		towar7JL.setBounds(10, 370, 150, 20);
		add(towar7JL);
		
		towar8JL = new JLabel("Kod towaru 8:");
		towar8JL.setBounds(10, 400, 150, 20);
		add(towar8JL);
		
		towar9JL = new JLabel("Kod towaru 9:");
		towar9JL.setBounds(10, 430, 150, 20);
		add(towar9JL);
		
		towar10JL = new JLabel("Kod towaru 10:");
		towar10JL.setBounds(10, 460, 150, 20);
		add(towar10JL);
		
		ilosc1JL = new JLabel("Iloœæ 1:");
		ilosc1JL.setBounds(410, 190, 150, 20);
		add(ilosc1JL);
		
		ilosc2JL = new JLabel("Iloœæ 2:");
		ilosc2JL.setBounds(410, 220, 150, 20);
		add(ilosc2JL);
		
		ilosc3JL = new JLabel("Iloœæ 3:");
		ilosc3JL.setBounds(410, 250, 150, 20);
		add(ilosc3JL);
		
		ilosc4JL = new JLabel("Iloœæ 4:");
		ilosc4JL.setBounds(410, 280, 150, 20);
		add(ilosc4JL);
		
		ilosc5JL = new JLabel("Iloœæ 5:");
		ilosc5JL.setBounds(410, 310, 150, 20);
		add(ilosc5JL);
		
		ilosc6JL = new JLabel("Iloœæ 6:");
		ilosc6JL.setBounds(410, 340, 150, 20);
		add(ilosc6JL);
		
		ilosc7JL = new JLabel("Iloœæ 7:");
		ilosc7JL.setBounds(410, 370, 150, 20);
		add(ilosc7JL);
		
		ilosc8JL = new JLabel("Iloœæ 8:");
		ilosc8JL.setBounds(410, 400, 150, 20);
		add(ilosc8JL);
		
		ilosc9JL = new JLabel("Iloœæ 9:");
		ilosc9JL.setBounds(410, 430, 150, 20);
		add(ilosc9JL);
		
		ilosc10JL = new JLabel("Iloœæ 10:");
		ilosc10JL.setBounds(410, 460, 150, 20);
		add(ilosc10JL);
		
		//sumaTowarowJL = new JLabel("Suma:");
		//sumaTowarowJL.setBounds(10, 250, 150, 20);
		//add(sumaTowarowJL);

		dataJTF = new JTextField();
		dataJTF.setBounds(150, 40, 150, 20);
		add(dataJTF);
		
		nazwaFakturyJTF = new JTextField();
		nazwaFakturyJTF.setBounds(150, 70, 150, 20);
		add(nazwaFakturyJTF);

		//nrFakturyJTF = new JTextField();
		//nrFakturyJTF.setBounds(150, 130, 150, 20);
		//add(nrFakturyJTF);
		//nrFakturyJTF.setEditable(false);

		//towar1JTF = new JTextField();
		//towar1JTF.setBounds(150, 190, 150, 20);
		//add(towar1JTF);
		
		wybierzJB = new JButton("Wybierz towary");
		//wybierzJB.setBounds(320, 190, 150, 20);
		wybierzJB.setBounds(120, 580, 150, 20);
		wybierzJB.addActionListener(this);
		add(wybierzJB);
		//55, 325, 75, 20
		
		ilosc1JTF = new JTextField();
		ilosc1JTF.setBounds(550, 190, 150, 20);
		add(ilosc1JTF);
		
		ilosc2JTF = new JTextField();
		ilosc2JTF.setBounds(550, 220, 150, 20);
		add(ilosc2JTF);
		
		ilosc3JTF = new JTextField();
		ilosc3JTF.setBounds(550, 250, 150, 20);
		add(ilosc3JTF);
		
		ilosc4JTF = new JTextField();
		ilosc4JTF.setBounds(550, 280, 150, 20);
		add(ilosc4JTF);
		
		ilosc5JTF = new JTextField();
		ilosc5JTF.setBounds(550, 310, 150, 20);
		add(ilosc5JTF);
		
		ilosc6JTF = new JTextField();
		ilosc6JTF.setBounds(550, 340, 150, 20);
		add(ilosc6JTF);
		
		ilosc7JTF = new JTextField();
		ilosc7JTF.setBounds(550, 370, 150, 20);
		add(ilosc7JTF);
		
		ilosc8JTF = new JTextField();
		ilosc8JTF.setBounds(550, 400, 150, 20);
		add(ilosc8JTF);
		
		ilosc9JTF = new JTextField();
		ilosc9JTF.setBounds(550, 430, 150, 20);
		add(ilosc9JTF);
		
		ilosc10JTF = new JTextField();
		ilosc10JTF.setBounds(550, 460, 150, 20);
		add(ilosc10JTF);
		
		//sumaTowarowJTF = new JTextField();
		//sumaTowarowJTF.setBounds(150, 250, 150, 20);
		//add(sumaTowarowJTF);
		
		//sumaTowarowJTF.setEditable(false);
		
		ObslugaBazyDanych bd = new ObslugaBazyDanych ();
		//sumaJTF.setText(bd.sumuj());
		//add(sumaJTF);

		zapiszJB = new JButton("Zapisz");
		zapiszJB.setBounds(330, 580, 200, 20);
		zapiszJB.addActionListener(this);
		add(zapiszJB);
		
		int liczbaWierszyKontrahent = 0;
		KontrahentSpis ob = new KontrahentSpis();
		ob.setVisible(false);
		liczbaWierszyKontrahent = ob.tabelaKontrahentow.getRowCount() + 1;
		String[] wystawiajacy = new String[liczbaWierszyKontrahent];
		
			for(int i = 0; i < liczbaWierszyKontrahent; i++) {
				wystawiajacy [i] = bd.pobierzNazweKontrahent(i);
					};
		wystawiajacyListaJCB = new JComboBox(wystawiajacy);
		wystawiajacyListaJCB.setBounds(150, 100, 150, 20);

		wystawiajacyListaJCB.setSelectedIndex(0);
		wystawiajacyListaJCB.addActionListener(this);
		add(wystawiajacyListaJCB);
		
		String[] odbiorca = {"", "Sklep 1", "Sklep 2", "Magazyn"};
		odbiorcaListaJCB = new JComboBox(odbiorca);
		odbiorcaListaJCB.setBounds(150, 130, 150, 20);

		odbiorcaListaJCB.setSelectedIndex(0);
		odbiorcaListaJCB.addActionListener(this);
		add(odbiorcaListaJCB);
		
		String[] platnosc = {"", "Gotówka", "Przelew"};
		platnoscListaJCB = new JComboBox(platnosc);
		platnoscListaJCB.setBounds(150, 160, 150, 20);

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
		towar1ListaJCB.setBounds(150, 190, 150, 20);

		towar1ListaJCB.setSelectedIndex(0);
		towar1ListaJCB.addActionListener(this);
		add(towar1ListaJCB);
		
		int liczbaWierszyTowar2 = 0;
		InterfejsStanTowarowy ob2 = new InterfejsStanTowarowy();
		ob2.setVisible(true);
		liczbaWierszyTowar2 = ob2.tabelaTowarow.getRowCount() + 1;
		String[] towar2 = new String[liczbaWierszyTowar2];
		
			for(int i = 0; i < liczbaWierszyTowar; i++) {
				towar2 [i] = bd.pobierzNazweTowar(i);
					};
		towar2ListaJCB = new JComboBox(towar2);
		towar2ListaJCB.setBounds(150, 220, 150, 20);

		towar2ListaJCB.setSelectedIndex(0);
		towar2ListaJCB.addActionListener(this);
		add(towar2ListaJCB);
		
		//int liczbaWierszyTowar3 = 0;
		//InterfejsStanTowarowy ob3 = new InterfejsStanTowarowy();
		//ob3.setVisible(false);
		//liczbaWierszyTowar = ob3.tabelaTowarow.getRowCount() + 1;
		String[] towar3 = new String[liczbaWierszyTowar];
		
			for(int i = 0; i < liczbaWierszyTowar; i++) {
				towar3 [i] = bd.pobierzNazweTowar(i);
					};
		towar3ListaJCB = new JComboBox(towar3);
		towar3ListaJCB.setBounds(150, 250, 150, 20);

		towar3ListaJCB.setSelectedIndex(0);
		towar3ListaJCB.addActionListener(this);
		add(towar3ListaJCB);
		
		//int liczbaWierszyTowar4 = 0;
		//InterfejsStanTowarowy ob4 = new InterfejsStanTowarowy();
		//ob4.setVisible(false);
		//liczbaWierszyTowar = ob4.tabelaTowarow.getRowCount() + 1;
		String[] towar4 = new String[liczbaWierszyTowar];
		
			for(int i = 0; i < liczbaWierszyTowar; i++) {
				towar4 [i] = bd.pobierzNazweTowar(i);
					};
		towar4ListaJCB = new JComboBox(towar4);
		towar4ListaJCB.setBounds(150, 280, 150, 20);

		towar4ListaJCB.setSelectedIndex(0);
		towar4ListaJCB.addActionListener(this);
		add(towar4ListaJCB);
		
		//int liczbaWierszyTowar5 = 0;
		//InterfejsStanTowarowy ob5 = new InterfejsStanTowarowy();
		//ob5.setVisible(false);
		//liczbaWierszyTowar = ob5.tabelaTowarow.getRowCount() + 1;
		String[] towar5 = new String[liczbaWierszyTowar];
		
			for(int i = 0; i < liczbaWierszyTowar; i++) {
				towar5 [i] = bd.pobierzNazweTowar(i);
					};
		towar5ListaJCB = new JComboBox(towar5);
		towar5ListaJCB.setBounds(150, 310, 150, 20);

		towar5ListaJCB.setSelectedIndex(0);
		towar5ListaJCB.addActionListener(this);
		add(towar5ListaJCB);
		
		//int liczbaWierszyTowar6 = 0;
		//InterfejsStanTowarowy ob6 = new InterfejsStanTowarowy();
		//ob6.setVisible(false);
		//liczbaWierszyTowar = ob6.tabelaTowarow.getRowCount() + 1;
		String[] towar6 = new String[liczbaWierszyTowar];
		
			for(int i = 0; i < liczbaWierszyTowar; i++) {
				towar6 [i] = bd.pobierzNazweTowar(i);
					};
		towar6ListaJCB = new JComboBox(towar6);
		towar6ListaJCB.setBounds(150, 340, 150, 20);

		towar6ListaJCB.setSelectedIndex(0);
		towar6ListaJCB.addActionListener(this);
		add(towar6ListaJCB);
		
		//int liczbaWierszyTowar7 = 0;
		//InterfejsStanTowarowy ob7 = new InterfejsStanTowarowy();
		//ob7.setVisible(false);
		//liczbaWierszyTowar = ob7.tabelaTowarow.getRowCount() + 1;
		String[] towar7 = new String[liczbaWierszyTowar];
		
			for(int i = 0; i < liczbaWierszyTowar; i++) {
				towar7 [i] = bd.pobierzNazweTowar(i);
					};
		towar7ListaJCB = new JComboBox(towar7);
		towar7ListaJCB.setBounds(150, 370, 150, 20);

		towar7ListaJCB.setSelectedIndex(0);
		towar7ListaJCB.addActionListener(this);
		add(towar7ListaJCB);
		
		//int liczbaWierszyTowar8 = 0;
		//InterfejsStanTowarowy ob8 = new InterfejsStanTowarowy();
		//ob8.setVisible(false);
		//liczbaWierszyTowar = ob8.tabelaTowarow.getRowCount() + 1;
		String[] towar8 = new String[liczbaWierszyTowar];
		
			for(int i = 0; i < liczbaWierszyTowar; i++) {
				towar8 [i] = bd.pobierzNazweTowar(i);
					};
		towar8ListaJCB = new JComboBox(towar8);
		towar8ListaJCB.setBounds(150, 400, 150, 20);

		towar8ListaJCB.setSelectedIndex(0);
		towar8ListaJCB.addActionListener(this);
		add(towar8ListaJCB);
		
		//int liczbaWierszyTowar9 = 0;
		//InterfejsStanTowarowy ob9 = new InterfejsStanTowarowy();
		//ob9.setVisible(false);
		//liczbaWierszyTowar = ob9.tabelaTowarow.getRowCount() + 1;
		String[] towar9 = new String[liczbaWierszyTowar];
		
			for(int i = 0; i < liczbaWierszyTowar; i++) {
				towar9 [i] = bd.pobierzNazweTowar(i);
					};
		towar9ListaJCB = new JComboBox(towar9);
		towar9ListaJCB.setBounds(150, 430, 150, 20);

		towar9ListaJCB.setSelectedIndex(0);
		towar9ListaJCB.addActionListener(this);
		add(towar9ListaJCB);
		
		//int liczbaWierszyTowar10 = 0;
		//InterfejsStanTowarowy ob10 = new InterfejsStanTowarowy();
		//ob10.setVisible(false);
		//liczbaWierszyTowar = ob10.tabelaTowarow.getRowCount() + 1;
		String[] towar10 = new String[liczbaWierszyTowar];
		
			for(int i = 0; i < liczbaWierszyTowar; i++) {
				towar10 [i] = bd.pobierzNazweTowar(i);
					};
		towar10ListaJCB = new JComboBox(towar10);
		towar10ListaJCB.setBounds(150, 460, 150, 20);

		towar10ListaJCB.setSelectedIndex(0);
		towar10ListaJCB.addActionListener(this);
		add(towar10ListaJCB);
		
		//ArrayList<SpisFakturPrzyjecia> faktury = bd.pobierzDane4();

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		ObslugaBazyDanych bd = new ObslugaBazyDanych();
		/*if (e.getSource() == wystawiajacyListaJCB) {
			JComboBox cb1 = (JComboBox) e.getSource();
			String wystawiajacy = (String) cb1.getSelectedItem();
			
		if (e.getSource() == odbiorcaListaJCB) {
			JComboBox cb2 = (JComboBox) e.getSource();
			String odbiorca = (String) cb2.getSelectedItem();	
			}
		if (e.getSource() == platnoscListaJCB) {
			JComboBox cb3 = (JComboBox) e.getSource();
			String platnosc = (String) cb3.getSelectedItem();	
			}*/
		
		
		//if (e.getSource() == wystawiajacyListaJCB) {
		//JComboBox cb = (JComboBox) e.getSource();
		//String lista = (String) cb1.getSelectedItem();

		/*if (lista == "Kontrahent 1") {
			nazwaFakturyJTF.setText(bd.pobierzNazweKontrahent(1));
			System.out.println(bd.pobierzNazweKontrahent(1));
			nazwaFakturyJTF.setEditable(false);
		} else {
//			odbiorcaJTF.setText("Hurtownia A. S.");
//			odbiorcaJTF.setEditable(false);
//			dostawcaJTF.setText("");
//			dostawcaJTF.setEditable(true);*/
		//}

		if (e.getSource().equals(zapiszJB)) {

			//JComboBox cb = new JComboBox<>();
			//JComboBox cb1 = new JComboBox<>();
			//JComboBox cb2 = new JComboBox<>();
			//JComboBox cb3 = new JComboBox<>();
			
			String wystawiajacy = (String) wystawiajacyListaJCB.getSelectedItem();
			int a = wystawiajacyListaJCB.getSelectedIndex();
			
			String odbiorca = (String) odbiorcaListaJCB.getSelectedItem();
			int b = odbiorcaListaJCB.getSelectedIndex();
			
			String platnosc = (String) platnoscListaJCB.getSelectedItem();
			int c = platnoscListaJCB.getSelectedIndex();
			
			String towar1 = (String) towar1ListaJCB.getSelectedItem();
			int d = towar1ListaJCB.getSelectedIndex();
			
			String towar2 = (String) towar2ListaJCB.getSelectedItem();
			int dd = towar2ListaJCB.getSelectedIndex();
			
			String towar3 = (String) towar3ListaJCB.getSelectedItem();
			int f = towar3ListaJCB.getSelectedIndex();
			
			String towar4 = (String) towar4ListaJCB.getSelectedItem();
			int g = towar4ListaJCB.getSelectedIndex();
			
			String towar5 = (String) towar5ListaJCB.getSelectedItem();
			int h = towar1ListaJCB.getSelectedIndex();
			
			String towar6 = (String) towar6ListaJCB.getSelectedItem();
			int i = towar6ListaJCB.getSelectedIndex();
			
			String towar7 = (String) towar7ListaJCB.getSelectedItem();
			int j = towar7ListaJCB.getSelectedIndex();
			
			String towar8 = (String) towar8ListaJCB.getSelectedItem();
			int k = towar8ListaJCB.getSelectedIndex();
			
			String towar9 = (String) towar9ListaJCB.getSelectedItem();
			int l = towar9ListaJCB.getSelectedIndex();
			
			String towar10 = (String) towar10ListaJCB.getSelectedItem();
			int m = towar10ListaJCB.getSelectedIndex();
			
			//String odbiorca = (String) cb2.getSelectedItem();
			//String platnosc = (String) cb3.getSelectedItem();
			//String lista = (String) cb1.getSelectedItem();
			//System.out.println("aaaa" + wystawiajacy + "\t" + a);
			
			String data = dataJTF.getText();
			String nazwaFaktury = nazwaFakturyJTF.getText();
			int ilosc1 = 0;
			int ilosc2 = 0;
			int ilosc3 = 0;
			int ilosc4 = 0;
			int ilosc5 = 0;
			int ilosc6 = 0;
			int ilosc7 = 0;
			int ilosc8 = 0;
			int ilosc9 = 0;
			int ilosc10 = 0;
			double sumaTowarow = 0.0;
			
			try {
				ilosc1 = Integer.parseInt(ilosc1JTF.getText());
			}
			catch(NumberFormatException xxx) {
				ilosc1 = 0;
				ilosc1JTF.setText("0");
			}
			
			try {
				ilosc2 = Integer.parseInt(ilosc2JTF.getText());
			}
			catch(NumberFormatException xxx) {
				ilosc2 = 0;
				ilosc2JTF.setText("0");
			}
			
			try {
				ilosc3 = Integer.parseInt(ilosc3JTF.getText());
			}
			catch(NumberFormatException xxx) {
				ilosc3 = 0;
				ilosc3JTF.setText("0");
			}
			
			try {
				ilosc4 = Integer.parseInt(ilosc4JTF.getText());
			}
			catch(NumberFormatException xxx) {
				ilosc4 = 0;
				ilosc4JTF.setText("0");
			}
			
			try {
				ilosc5 = Integer.parseInt(ilosc5JTF.getText());
			}
			catch(NumberFormatException xxx) {
				ilosc5 = 0;
				ilosc5JTF.setText("0");
			}
			
			try {
				ilosc6 = Integer.parseInt(ilosc6JTF.getText());
			}
			catch(NumberFormatException xxx) {
				ilosc6 = 0;
				ilosc6JTF.setText("0");
			}
			
			try {
				ilosc7 = Integer.parseInt(ilosc7JTF.getText());
			}
			catch(NumberFormatException xxx) {
				ilosc7 = 0;
				ilosc7JTF.setText("0");
			}
			
			try {
				ilosc8 = Integer.parseInt(ilosc8JTF.getText());
			}
			catch(NumberFormatException xxx) {
				ilosc8 = 0;
				ilosc8JTF.setText("0");
			}
			
			try {
				ilosc9 = Integer.parseInt(ilosc9JTF.getText());
			}
			catch(NumberFormatException xxx) {
				ilosc9 = 0;
				ilosc9JTF.setText("0");
			}
			
			try {
				ilosc10 = Integer.parseInt(ilosc10JTF.getText());
			}
			catch(NumberFormatException xxx) {
				ilosc10 = 0;
				ilosc10JTF.setText("0");
			}
			

			//String sumaTowarow = sumaTowarowJTF.getText();
			
			/*String idTowarPomoc = idTowarow;
			String iloscTowarPomoc = iloscTowarow;
			
			int pozycja = idTowarPomoc.indexOf(',');
			int pozycja2 = iloscTowarPomoc.indexOf(',');
			System.out.println("pozycja " + pozycja);
			int indexStart = 0;
			int indexStart2 = 0;
			int x = -1;
			int y = -1;
			double sumaTowarow = 0.0;
			double cenaNetto = 0.0;
			
			
			while((pozycja != -1)&&(pozycja2 != -1)) {
				
				if((pozycja != -1)&&(pozycja2 != -1)) {
				
					x = Integer.parseInt(idTowarPomoc.substring(indexStart, pozycja));
					y = Integer.parseInt(iloscTowarPomoc.substring(indexStart2, pozycja2));
					idTowarPomoc = idTowarPomoc.substring(pozycja+1);
					iloscTowarPomoc = iloscTowarPomoc.substring(pozycja2+1);
					//select cena from tabeli where id=x
					bd.pobierzCeneNetto(x);
					
					sumaTowarow += x * y * cenaNetto * 1.23;	
					
					System.out.println("x, y, cenaNetto" +";"+x + ";" + y + ";"+ cenaNetto);
				
				}
				

				pozycja = idTowarPomoc.indexOf(',');
				pozycja2 = iloscTowarPomoc.indexOf(',');
			}
			
			
			if((pozycja == -1)&&(pozycja2 == -1)) {
				//x = Integer.parseInt(idTowarPomoc);
				//sumaTowarow += (idTowarow * iloscTowarow * cenaNetto * 1.23);
			}
			
			//sumaTowarow = x * y * cenaNetto * 1.23;//3 * 34;
*/
			//ObslugaBazyDanych bd = new ObslugaBazyDanych();

			sumaTowarow = ilosc1 * bd.sumuj(towar1) + ilosc2 * bd.sumuj(towar2) + ilosc3 * bd.sumuj(towar3)
						+ ilosc4 * bd.sumuj(towar4) + ilosc5 * bd.sumuj(towar5) + ilosc6 * bd.sumuj(towar6)
						+ ilosc7 * bd.sumuj(towar7) + ilosc8 * bd.sumuj(towar8) + ilosc9 * bd.sumuj(towar9)
						+ ilosc10 * bd.sumuj(towar10);

			
			bd.dodajDane4(data, nazwaFaktury, wystawiajacy, odbiorca, platnosc, towar1, ilosc1, 
					towar2, ilosc2, towar3, ilosc3, towar4, ilosc4, towar5, ilosc5,
					towar6, ilosc6, towar7, ilosc7, towar8, ilosc8, towar9, ilosc9,
					towar10, ilosc10, sumaTowarow);
			
			ArrayList<SpisFakturPrzyjecia> faktury = bd.pobierzDane4();
			
			bd.zamknijPolaczenie();

			setVisible(false);
			FakturaPrzyjecieSpis ob = new FakturaPrzyjecieSpis();
			ob.setVisible(true);
			

		}
		
		if (e.getSource().equals(wybierzJB)) {
			InterfejsStanTowarowy ob = new InterfejsStanTowarowy();
			ob.setVisible(true);
			//setVisible(false);

			}
		}
}

