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
import dane.StanTowarowy;
import obsluga_bazy_danych.ObslugaBazyDanych;
import interfejs.InterfejsStanTowarowy;

public class FakturaPrzyjecieDodajPozycjeTowar extends JFrame implements ActionListener{

	private JLabel naglowek1JL;
	private JLabel naglowek2JL;
	private JLabel pozycja1JL;
	private JLabel pozycja2JL;
	private JLabel pozycja3JL;
	private JLabel pozycja4JL;
	private JLabel pozycja5JL;
	private JLabel pozycja6JL;
	private JLabel pozycja7JL;
	private JLabel pozycja8JL;
	private JLabel pozycja9JL;
	private JLabel pozycja10JL;
	private JTextField iloscSztuk1JTF;
	private JTextField iloscSztuk2JTF;
	private JTextField iloscSztuk3JTF;
	private JTextField iloscSztuk4JTF;
	private JTextField iloscSztuk5JTF;
	private JTextField iloscSztuk6JTF;
	private JTextField iloscSztuk7JTF;
	private JTextField iloscSztuk8JTF;
	private JTextField iloscSztuk9JTF;
	private JTextField iloscSztuk10JTF;
	
	private JButton zapiszJB;
	private JButton wybierzJB;
	
	private JComboBox pozycja1ListaJCB;
	private JComboBox pozycja2ListaJCB;
	private JComboBox pozycja3ListaJCB;
	private JComboBox pozycja4ListaJCB;
	private JComboBox pozycja5ListaJCB;
	private JComboBox pozycja6ListaJCB;
	private JComboBox pozycja7ListaJCB;
	private JComboBox pozycja8ListaJCB;
	private JComboBox pozycja9ListaJCB;
	private JComboBox pozycja10ListaJCB;
	
	public FakturaPrzyjecieDodajPozycjeTowar() {
		
		super("Towary w fakturze przyjêcia");
		setSize(600, 400);
		setResizable(true);
		setLayout(null);

		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);

		ObslugaBazyDanych bd = new ObslugaBazyDanych ();
		
		int liczbaWierszyTowar = 0;
		InterfejsStanTowarowy ob = new InterfejsStanTowarowy();
		ob.setVisible(false);
		liczbaWierszyTowar = ob.tabelaTowarow.getRowCount() + 1;
		String[] kodTowaru = new String[liczbaWierszyTowar];
		
			for(int i = 0; i < liczbaWierszyTowar; i++) {
				kodTowaru [i] = bd.pobierzNazweTowar(i);
			};
		pozycja1ListaJCB = new JComboBox(kodTowaru);
		pozycja1ListaJCB.setBounds(150, 70, 150, 20);

		pozycja1ListaJCB.setSelectedIndex(0);
		pozycja1ListaJCB.addActionListener(this);
		add(pozycja1ListaJCB);
		
		naglowek1JL = new JLabel("Kod towaru");
		naglowek1JL.setBounds(150, 40, 150, 20);
		add(naglowek1JL);
		
		naglowek2JL = new JLabel("Iloœæ sztuk");
		naglowek2JL.setBounds(360, 40, 150, 20);
		add(naglowek2JL);
		
		pozycja1JL = new JLabel("Pozycja 1.:");
		pozycja1JL.setBounds(10, 70, 150, 20);
		add(pozycja1JL);
		
		iloscSztuk1JTF = new JTextField();
		iloscSztuk1JTF.setBounds(360, 70, 150, 20);
		add(iloscSztuk1JTF);
		
		/*wystawiajacyJL = new JLabel("Kontrahent:");
		wystawiajacyJL.setBounds(10, 100, 150, 20);
		add(wystawiajacyJL);

		odbiorcaJL = new JLabel("Odbiorca:");
		odbiorcaJL.setBounds(10, 130, 150, 20);
		add(odbiorcaJL);

		platnoscJL = new JLabel("P³atnoœæ:");
		platnoscJL.setBounds(10, 160, 150, 20);
		add(platnoscJL);

		idTowarowJL = new JLabel("Op³ata za dni:");
		idTowarowJL.setBounds(10, 190, 150, 20);
		add(idTowarowJL);
		
		sumaTowarowJL = new JLabel("Suma:");
		sumaTowarowJL.setBounds(10, 220, 150, 20);
		add(sumaTowarowJL);
		

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

		idTowarowJTF = new JTextField();
		idTowarowJTF.setBounds(150, 190, 150, 20);
		add(idTowarowJTF);
		*/
		
		wybierzJB = new JButton("Tabela towarów");
		wybierzJB.setBounds(100, 330, 200, 20);
		wybierzJB.addActionListener(this);
		add(wybierzJB);
		//55, 325, 75, 20
		//sumaTowarowJTF = new JTextField();
		//sumaTowarowJTF.setBounds(150, 220, 150, 20);
		//add(sumaTowarowJTF);
		
		//sumaTowarowJTF.setEditable(false);
		
		//ObslugaBazyDanych bd = new ObslugaBazyDanych ();
		//sumaJTF.setText(bd.sumuj());
		//add(sumaJTF);

		zapiszJB = new JButton("Zapisz");
		zapiszJB.setBounds(330, 330, 200, 20);
		zapiszJB.addActionListener(this);
		add(zapiszJB);
		
		/*int liczbaWierszyKontrahent = 0;
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
		add(platnoscListaJCB);*/
		
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
			
			String idTowarow = (String) (pozycja1ListaJCB.getSelectedItem()) + "*" + (iloscSztuk1JTF.getText()) + "; ";
			int a = pozycja1ListaJCB.getSelectedIndex();
			/*String wystawiajacy = (String) wystawiajacyListaJCB.getSelectedItem();
			int a = wystawiajacyListaJCB.getSelectedIndex();
			
			String odbiorca = (String) odbiorcaListaJCB.getSelectedItem();
			int b = odbiorcaListaJCB.getSelectedIndex();
			
			String platnosc = (String) platnoscListaJCB.getSelectedItem();
			int c = platnoscListaJCB.getSelectedIndex();
			
			//String odbiorca = (String) cb2.getSelectedItem();
			//String platnosc = (String) cb3.getSelectedItem();
			//String lista = (String) cb1.getSelectedItem();
			System.out.println("aaaa" + wystawiajacy + "\t" + a);
			
			String data = dataJTF.getText();
			String nazwaFaktury = nazwaFakturyJTF.getText();
			String idTowarow = idTowarowJTF.getText();
			String idTowarow = pozycja1JTF.getText();
			
			String idTowarPomoc = idTowarow;
			
			//int pozycja = idTowarPomoc.indexOf(',');
//			System.out.println("pozycja " + pozycja);
			int indexStart = 0;
			int jeden = -1;
			//double sumaTowarow = 0;
			
			
			/*while(pozycja != -1) {
				
				if(pozycja != -1) {
				
					jeden = Integer.parseInt(idTowarPomoc.substring(indexStart, pozycja));
					idTowarPomoc = idTowarPomoc.substring(pozycja+1);
					//select cena from tabeli where id=jeden
					
					sumaTowarow += jeden * 3;	
					
//					System.out.println("jeden " + jeden);
				
				}
				

				pozycja = idTowarPomoc.indexOf(',');

			}
			
			
			if(pozycja == -1) {
				jeden = Integer.parseInt(idTowarPomoc);
				sumaTowarow += jeden * 3;
			}*/
			
//			sumaTowarow = 3 * 34;

			//ObslugaBazyDanych bd = new ObslugaBazyDanych();
			//bd.dodajDane4(data, nazwaFaktury, wystawiajacy, odbiorca, platnosc, idTowarow, sumaTowarow);
			//ArrayList<SpisFakturPrzyjecia> faktury = bd.pobierzDane4();
			bd.zamknijPolaczenie();

			setVisible(false);
			FakturaPrzyjecieSpis ob = new FakturaPrzyjecieSpis();
			ob.setVisible(true);
			

		}
		
		if (e.getSource().equals(wybierzJB)) {
			InterfejsStanTowarowy ob = new InterfejsStanTowarowy();
			ob.setVisible(true);
			setVisible(false);

			}
		}
}

