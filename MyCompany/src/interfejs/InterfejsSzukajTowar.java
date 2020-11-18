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

public class InterfejsSzukajTowar extends JFrame implements ActionListener {
	 
	private JLabel polecenieJL;
	private JLabel kodKreskowyJL;

	private JTextField kodKreskowyJTF;
	
	private JButton szukajJB;
		
	public InterfejsSzukajTowar() {
			
		super("Szukaj towaru");
		setSize(600, 400);
		setResizable(true);
		setLayout(null);
			
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		
		ObslugaBazyDanych bd = new ObslugaBazyDanych();
		
		polecenieJL = new JLabel("Szukaj po wartoœci:");
		polecenieJL.setBounds(150, 10, 150, 20);
		add(polecenieJL);

		kodKreskowyJL = new JLabel("Kod towaru:");
		kodKreskowyJL.setBounds(10, 70, 150, 20);
		add(kodKreskowyJL);

		kodKreskowyJTF = new JTextField();
		kodKreskowyJTF.setBounds(150, 70, 150, 20);
		add(kodKreskowyJTF);
			
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
									
				String kodKreskowy = kodKreskowyJTF.getText();
				
				
				InterfejsStanTowarowy ob = new InterfejsStanTowarowy();
				
			        for(int i = 0; i < ob.tabelaTowarow.getRowCount(); i++) {
			        	for(int j = 0; j < ob.tabelaTowarow.getColumnCount(); j++){
			     
			        			if((kodKreskowy.length() > 0) &&(ob.tabelaTowarow.getValueAt(i, j).equals(kodKreskowy))){
			        			ob.tabelaTowarow.addRowSelectionInterval(i, j);
			        			ob.tabelaTowarow.changeSelection(i, j, false, false);
			        			}

			        		}
			      
			        ob.tabelaTowarow.setCellSelectionEnabled(true);		
		
		ObslugaBazyDanych bd = new ObslugaBazyDanych();
				
			bd.zamknijPolaczenie();
				
			setVisible(false);
	
			ob.setVisible(true);
				
		  }
		}
	}

}

