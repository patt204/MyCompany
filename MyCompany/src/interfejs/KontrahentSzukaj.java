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
import obsluga_bazy_danych.ObslugaBazyDanych;
import interfejs.KlientSpis;

public class KontrahentSzukaj extends JFrame implements ActionListener {
	 
	private JLabel polecenieJL;
	private JLabel skrotNazwaKoJL;
	private JLabel nipKoJL;
	private JLabel telefonKoJL;
		
	private JTextField skrotNazwaKoJTF;
	private JTextField nipKoJTF;
	private JTextField telefonKoJTF;
		
	private JButton szukajJB;
		
	public KontrahentSzukaj() {
			
		super("Szukaj kontrahenta");
		setSize(600, 400);
		setResizable(true);
		setLayout(null);
			
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		
		ObslugaBazyDanych bd = new ObslugaBazyDanych();
		
		polecenieJL = new JLabel("Szukaj po jednej wartoœci:");
		polecenieJL.setBounds(150, 10, 150, 20);
		add(polecenieJL);
		
		skrotNazwaKoJL = new JLabel("Nazwa skrótu:");
		skrotNazwaKoJL.setBounds(10, 40, 150, 20);
		add(skrotNazwaKoJL);

		nipKoJL = new JLabel("NIP:");
		nipKoJL.setBounds(10, 70, 150, 20);
		add(nipKoJL);

		telefonKoJL = new JLabel("Telefon:");
		telefonKoJL.setBounds(10, 100, 150, 20);
		add(telefonKoJL);

		skrotNazwaKoJTF = new JTextField();
		skrotNazwaKoJTF.setBounds(150, 40, 150, 20);
		add(skrotNazwaKoJTF);

		nipKoJTF = new JTextField();
		nipKoJTF.setBounds(150, 70, 150, 20);
		add(nipKoJTF);

		telefonKoJTF = new JTextField();
		telefonKoJTF.setBounds(150, 100, 150, 20);
		add(telefonKoJTF);

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
									
				String skrotNazwaKo = skrotNazwaKoJTF.getText();
				String nipKo = nipKoJTF.getText();
				String telefonKo = telefonKoJTF.getText();
				
				KontrahentSpis ob = new KontrahentSpis();
				
			        for(int i = 0; i < ob.tabelaKontrahentow.getRowCount(); i++) {
			        	for(int j = 0; j < ob.tabelaKontrahentow.getColumnCount(); j++){
			     
			        			if ((skrotNazwaKo.length() > 0) && (ob.tabelaKontrahentow.getValueAt(i, j).equals(skrotNazwaKo))){
			        			ob.tabelaKontrahentow.addRowSelectionInterval(i, j);
			        			ob.tabelaKontrahentow.changeSelection(i, j, false, false);
			        			}

			        			else if((nipKo.length() > 0) &&(ob.tabelaKontrahentow.getValueAt(i, j).equals(nipKo))){
			        			ob.tabelaKontrahentow.addRowSelectionInterval(i, j);
			        			ob.tabelaKontrahentow.changeSelection(i, j, false, false);
			        			}

			        			else if((telefonKo.length() > 0) &&(ob.tabelaKontrahentow.getValueAt(i, j).equals(telefonKo))){
			        			ob.tabelaKontrahentow.addRowSelectionInterval(i, j);
			        			ob.tabelaKontrahentow.changeSelection(i, j, false, false);
			        			}
			        		}
			        
			        ob.tabelaKontrahentow.setCellSelectionEnabled(true);
		
		ObslugaBazyDanych bd = new ObslugaBazyDanych();
				
			bd.zamknijPolaczenie();
				
			setVisible(false);
				
			ob.setVisible(true);
				
			        }
		}
	}

}
