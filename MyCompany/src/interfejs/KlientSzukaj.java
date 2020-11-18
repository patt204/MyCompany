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

public class KlientSzukaj extends JFrame implements ActionListener {
	 
	private JLabel polecenieJL;
	private JLabel nipJL;
	private JLabel telefonJL;

	private JTextField nipJTF;
	private JTextField telefonJTF;
	
	private JButton szukajJB;
		
	public KlientSzukaj() {
			
		super("Szukaj klienta");
		setSize(600, 400);
		setResizable(true);
		setLayout(null);
			
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		
		ObslugaBazyDanych bd = new ObslugaBazyDanych();
		
		polecenieJL = new JLabel("Szukaj po jednej wartoœci:");
		polecenieJL.setBounds(150, 10, 150, 20);
		add(polecenieJL);

		nipJL = new JLabel("NIP:");
		nipJL.setBounds(10, 70, 150, 20);
		add(nipJL);

		telefonJL = new JLabel("Telefon:");
		telefonJL.setBounds(10, 100, 150, 20);
		add(telefonJL);

		nipJTF = new JTextField();
		nipJTF.setBounds(150, 70, 150, 20);
		add(nipJTF);

		telefonJTF = new JTextField();
		telefonJTF.setBounds(150, 100, 150, 20);
		add(telefonJTF);
			
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
									
				String nip = nipJTF.getText();
				String telefon = telefonJTF.getText();
				
				KlientSpis ob = new KlientSpis();
				
			        for(int i = 0; i < ob.tabelaKlientow.getRowCount(); i++) {
			        	for(int j = 0; j < ob.tabelaKlientow.getColumnCount(); j++){
			     
			        			if((nip.length() > 0) 
			        					&&(ob.tabelaKlientow.getValueAt(i, j).equals(nip))){
			        			ob.tabelaKlientow.addRowSelectionInterval(i, j);
			        			ob.tabelaKlientow.changeSelection(i, j, false, false);
			        			}

			        			else if((telefon.length() > 0) 
			        					&&(ob.tabelaKlientow.getValueAt(i, j).equals(telefon))){
			        			ob.tabelaKlientow.addRowSelectionInterval(i, j);
			        			ob.tabelaKlientow.changeSelection(i, j, false, false);
			        			}

			        		
			        		}
			        		}
			        
			      
			        ob.tabelaKlientow.setCellSelectionEnabled(true);
		
		ObslugaBazyDanych bd = new ObslugaBazyDanych();
				
			bd.zamknijPolaczenie();
				
			setVisible(false);
	
			ob.setVisible(true);
				
		  }
		}
	}


