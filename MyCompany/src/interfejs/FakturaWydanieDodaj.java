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

public class FakturaWydanieDodaj extends JFrame implements ActionListener{

	private JLabel dataJL;
	private JLabel nazwaFakturyJL;
	private JLabel wystawiajacyJL;
	private JLabel odbiorcaJL;
	private JLabel platnoscJL;
	private JLabel oplataDoJL;
	private JLabel sumaTowarowJL;

	private JTextField dataJTF;
	private JTextField nazwaFakturyJTF;
	private JTextField oplataDoJTF;
	private JTextField sumaTowarowJTF;

	private JButton zapiszJB;
	private JButton wybierzJB;
	
	private JComboBox wystawiajacyListaJCB;
	private JComboBox odbiorcaListaJCB;
	private JComboBox platnoscListaJCB;
	
	public FakturaWydanieDodaj() {
		
		super("Nowa faktura wydania");
		setSize(600, 400);
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

		oplataDoJL = new JLabel("Op³ata za dni:");
		oplataDoJL.setBounds(10, 190, 150, 20);
		add(oplataDoJL);
		
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

		oplataDoJTF = new JTextField();
		oplataDoJTF.setBounds(150, 190, 150, 20);
		add(oplataDoJTF);
		
		/*wybierzJB = new JButton("Poka¿ towary");
		wybierzJB.setBounds(320, 190, 150, 20);
		wybierzJB.addActionListener(this);
		add(wybierzJB);*/
		//55, 325, 75, 20
		sumaTowarowJTF = new JTextField();
		sumaTowarowJTF.setBounds(150, 220, 150, 20);
		add(sumaTowarowJTF);
		
		//sumaTowarowJTF.setEditable(false);
		
		ObslugaBazyDanych bd = new ObslugaBazyDanych ();
		//sumaJTF.setText(bd.sumuj());
		//add(sumaJTF);

		zapiszJB = new JButton("Zapisz");
		zapiszJB.setBounds(330, 330, 200, 20);
		zapiszJB.addActionListener(this);
		add(zapiszJB);
		
		int liczbaWierszyKlient = 0;
		KlientSpis ob = new KlientSpis();
		ob.setVisible(false);
		liczbaWierszyKlient = ob.tabelaKlientow.getRowCount() + 1;
		String[] odbiorca = new String[liczbaWierszyKlient];
		
			for(int i = 0; i < liczbaWierszyKlient; i++) {
				odbiorca [i] = bd.pobierzNazweKlient(i);
					};
		odbiorcaListaJCB = new JComboBox(odbiorca);
		odbiorcaListaJCB.setBounds(150, 130, 400, 20);

		odbiorcaListaJCB.setSelectedIndex(0);
		odbiorcaListaJCB.addActionListener(this);
		add(odbiorcaListaJCB);
		
		String[] wystawiajacy = {"", "Sklep 1", "Sklep 2", "Magazyn"};
		wystawiajacyListaJCB = new JComboBox(wystawiajacy);
		wystawiajacyListaJCB.setBounds(150, 100, 150, 20);

		wystawiajacyListaJCB.setSelectedIndex(0);
		wystawiajacyListaJCB.addActionListener(this);
		add(wystawiajacyListaJCB);
		
		String[] platnosc = {"", "Gotówka", "Przelew"};
		platnoscListaJCB = new JComboBox(platnosc);
		platnoscListaJCB.setBounds(150, 160, 150, 20);

		platnoscListaJCB.setSelectedIndex(0);
		platnoscListaJCB.addActionListener(this);
		add(platnoscListaJCB);
		
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
			
			//String odbiorca = (String) cb2.getSelectedItem();
			//String platnosc = (String) cb3.getSelectedItem();
			//String lista = (String) cb1.getSelectedItem();
			//System.out.println("aaaa" + wystawiajacy + "\t" + a);
			
			String data = dataJTF.getText();
			String nazwaFaktury = nazwaFakturyJTF.getText();
			String oplataDo = oplataDoJTF.getText();
			String sumaTowarow = sumaTowarowJTF.getText();
			
			//String idTowarPomoc = oplataDo;
			
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
			bd.dodajDane5(data, nazwaFaktury, wystawiajacy, odbiorca, platnosc, oplataDo, sumaTowarow);
			//ArrayList<SpisFakturPrzyjecia> faktury = bd.pobierzDane4();
			bd.zamknijPolaczenie();

			setVisible(false);
			FakturaWydanieSpis ob = new FakturaWydanieSpis();
			ob.setVisible(true);
			

		}
		
		if (e.getSource().equals(wybierzJB)) {
			InterfejsStanTowarowy ob = new InterfejsStanTowarowy();
			ob.setVisible(true);
			setVisible(false);

			}
		}
}

