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

/*public class FakturaPrzyjeciePokazTowary extends JFrame implements ActionListener{

	private JLabel naglowek1bJL;
	private JLabel naglowek2bJL;
	private JLabel pozycja1bJL;
	private JLabel pozycja2bJL;
	private JLabel pozycja3bJL;
	private JLabel pozycja4bJL;
	private JLabel pozycja5bJL;
	private JLabel pozycja6bJL;
	private JLabel pozycja7bJL;
	private JLabel pozycja8bJL;
	private JLabel pozycja9bJL;
	private JLabel pozycja10bJL;

	
	private JButton zapiszJB;
	
	public FakturaPrzyjeciePokazTowary() {
		
		super("Nowa faktura przyjecia");
		setSize(600, 400);
		setResizable(true);
		setLayout(null);

		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);

		pozycja1bJL = new JLabel("Data:");
		pozycja1bJL.setBounds(10, 40, 150, 20);
		add(pozycja1bJL);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		ObslugaBazyDanych bd = new ObslugaBazyDanych();

		if (e.getSource().equals(zapiszJB)) {
			
			//String odbiorca = (String) cb2.getSelectedItem();
			//String platnosc = (String) cb3.getSelectedItem();
			//String lista = (String) cb1.getSelectedItem();
			System.out.println("aaaa" + wystawiajacy + "\t" + a);
			
			String data = dataJTF.getText();
			String nazwaFaktury = nazwaFakturyJTF.getText();
			String idTowarow = idTowarowJTF.getText();
			String sumaTowarow = sumaTowarowJTF.getText();
			
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
			//bd.zamknijPolaczenie();

			/*setVisible(false);
			FakturaPrzyjecieSpis ob = new FakturaPrzyjecieSpis();
			ob.setVisible(true);
			

		}
		
		if (e.getSource().equals(wybierzJB)) {
			FakturaPrzyjecieIleIdTowarow ob = new FakturaPrzyjecieIleIdTowarow();
			ob.setVisible(true);
			setVisible(false);

			}
		}
}


	}*/
