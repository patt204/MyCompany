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

import dane.SpisFakturPrzyjecia;
import obsluga_bazy_danych.ObslugaBazyDanych;
import interfejs.FakturaPrzyjecieSpis;

public class FakturaPrzyjecieSzukaj extends JFrame implements ActionListener {
	 
	private JLabel polecenieJL;
	private JLabel nazwaFakturJL;

	private JTextField nazwaFakturJTF;
	
	private JButton szukajJB;
		
	public FakturaPrzyjecieSzukaj() {
			
		super("Szukaj faktury przyjêcia");
		setSize(600, 400);
		setResizable(true);
		setLayout(null);
			
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		
		ObslugaBazyDanych bd = new ObslugaBazyDanych();
		
		polecenieJL = new JLabel("Szukaj po wartoœci:");
		polecenieJL.setBounds(150, 10, 150, 20);
		add(polecenieJL);

		nazwaFakturJL = new JLabel("Numer faktury:");
		nazwaFakturJL.setBounds(10, 70, 150, 20);
		add(nazwaFakturJL);

		nazwaFakturJTF = new JTextField();
		nazwaFakturJTF.setBounds(150, 70, 150, 20);
		add(nazwaFakturJTF);
			
		szukajJB = new JButton("Szukaj");
		szukajJB.setBounds(330, 330, 200, 20);
		szukajJB.addActionListener(this);
		add(szukajJB);
			
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(szukajJB)) {
									
				String nazwaFaktur = nazwaFakturJTF.getText();
				
				FakturaPrzyjecieSpis ob = new FakturaPrzyjecieSpis();
				//ob.setVisible(false);
				
			        for(int i = 0; i < ob.tabelaFaktur.getRowCount(); i++) {
			        	for(int j = 0; j < ob.tabelaFaktur.getColumnCount(); j++){
			     
			        			if((nazwaFaktur.length() > 0) &&(ob.tabelaFaktur.getValueAt(i, j).equals(nazwaFaktur))){
			        			ob.tabelaFaktur.addRowSelectionInterval(i, j);
			        			ob.tabelaFaktur.changeSelection(i, j, false, false);
			        			}

			        			//else {
				        			//System.out.println(" ");}
			        		}

			        ob.tabelaFaktur.setCellSelectionEnabled(true);

		//if (ob.tabelaKlientow.getValueAt(i, j).equals(skrotNazwa))  
			//ob.tabelaKlientow.changeSelection(i, j, true, false);
		
		
		ObslugaBazyDanych bd = new ObslugaBazyDanych();
				
			bd.zamknijPolaczenie();
				
			setVisible(false);
	
			ob.setVisible(true);
				
		  }
		}
	}

}


