/*package interfejs;

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
import dane.StanTowarowy;
import obsluga_bazy_danych.ObslugaBazyDanych;

public class FakturaPrzyjecieWybierzTowar extends JFrame implements ActionListener {

	private JTable tabelaTowarow;
	private JScrollPane scroll;

	private JButton wybierzJB;
	private JButton zapiszJB;
	private JButton anulujJB;

	private JLabel idJL;
	private JLabel towarJL;
	private JLabel liczbaSztukJL;
	private JLabel sumaTowarowJL;

	private JTextField idJTF;
	private JTextField liczbaSztukJTF;
	private JTextField idTowarowJTF;
	private JTextField sumaTowarowJTF;
	
	private JComboBox towarListaJCB;

	public FakturaPrzyjecieWybierzTowar() {

		setTitle("Edycja faktury przyj�cia");
		setResizable(true);
		setSize(600, 500);
		setLayout(null);

		//lokalizacja okna po srodku ekranu w zaleznosci od rozmiara ekranu uzytkownika
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);

		ObslugaBazyDanych bd = new ObslugaBazyDanych();
		ArrayList<StanTowarowy> towary = bd.pobierzDane1();

		tabelaTowarow = new JTable(new ModelTabelaTowar(towary));
		scroll = new JScrollPane(tabelaTowarow);
		scroll.setBounds(10, 10, 565, 210);
		add(scroll);

		idJL = new JLabel("WYBIERZ ID:");
		idJL.setBounds(15, 245, 100, 20);
		add(idJL);
		
		towarJL = new JLabel("Data:");
		towarJL.setBounds(15, 295, 100, 20);
		add(towarJL);

		nazwaFakturyJL = new JLabel("Nazwa faktury:");
		nazwaFakturyJL.setBounds(335, 295, 100, 20);
		add(nazwaFakturyJL);

		wystawiajacyJL = new JLabel("Kontrahent:");
		wystawiajacyJL.setBounds(15, 345, 100, 20);
		add(wystawiajacyJL);

		odbiorcaJL = new JLabel("Odbiorca:");
		odbiorcaJL.setBounds(335, 345, 100, 20);
		add(odbiorcaJL);
		
		platnoscJL = new JLabel("P�atno��:");
		platnoscJL.setBounds(15, 395, 100, 20);
		add(platnoscJL);
		
		idTowarowJL = new JLabel("Id towar�w:");
		idTowarowJL.setBounds(335, 395, 100, 20);
		add(idTowarowJL);
		
		sumaTowarowJL = new JLabel("Suma towar�w:");
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
		
		int liczbaWierszyKontrahent = 0;
		KontrahentSpis ob = new KontrahentSpis();
		ob.setVisible(false);
		liczbaWierszyKontrahent =ob.tabelaKontrahentow.getRowCount() + 1;
		String[] wystawiajacy = new String[liczbaWierszyKontrahent];
		
			for(int i = 0; i < liczbaWierszyKontrahent; i++) {
				wystawiajacy [i] = bd.pobierzNazweKontrahent(i+1);
					};
		wystawiajacyListaJCB = new JComboBox(wystawiajacy);
		wystawiajacyListaJCB.setBounds(105, 345, 100, 20);
		
		wystawiajacyListaJCB.setSelectedIndex(0);
		wystawiajacyListaJCB.addActionListener(this);
		add(wystawiajacyListaJCB);
		
		String[] odbiorca = {"", "Sklep 1", "Sklep 2", "Magazyn"};
		odbiorcaListaJCB = new JComboBox(odbiorca);
		odbiorcaListaJCB.setBounds(430, 345, 100, 20);

		odbiorcaListaJCB.setSelectedIndex(0);
		odbiorcaListaJCB.addActionListener(this);
		add(odbiorcaListaJCB);
		
		String[] platnosc = {"", "Got�wka", "Przelew"};
		platnoscListaJCB = new JComboBox(platnosc);
		platnoscListaJCB.setBounds(105, 395, 100, 20);

		platnoscListaJCB.setSelectedIndex(0);
		platnoscListaJCB.addActionListener(this);
		add(platnoscListaJCB);
		
		idTowarowJTF = new JTextField();
		idTowarowJTF.setBounds(430, 395, 100, 20);
		add(idTowarowJTF);
		
		sumaTowarowJTF = new JTextField();
		sumaTowarowJTF.setBounds(105, 445, 100, 20);
		add(sumaTowarowJTF);

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
			String data = dataJTF.getText();
			String nazwaFaktury = nazwaFakturyJTF.getText();
			String idTowarow = idTowarowJTF.getText();
			double sumaTowarow = 0.0;
			
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

			bd.edytujDane4(data, nazwaFaktury, wystawiajacy, odbiorca, platnosc, idTowarow, sumaTowarow, id);

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

}*/
