package interfejs;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import dane.SpisFakturPrzyjecia;

public class ModelTabelaFaktura extends AbstractTableModel {
	
	private List<SpisFakturPrzyjecia> faktury;
	private final static Object[] nazwyKolumn = { "Numer faktury", "Data", "Nazwa faktury", 
			"Kontrahent", "Odbiorca", "P³atnoœæ", "Towar 1", "Iloœæ 1", "Towar 2", "Iloœæ 2",
			"Towar 3", "Iloœæ 3", "Towar 4", "Iloœæ 4", "Towar 5", "Iloœæ 5", 
			"Towar 6", "Iloœæ 6", "Towar 7", "Iloœæ 7", "Towar 8", "Iloœæ 8",
			"Towar 9", "Iloœæ 9", "Towar 10", "Iloœæ 10", "Suma towarów" };
	private final static int NRFAKTURY_IDX = 0;
	private final static int DATA_IDX = 1;
	private final static int NAZWAFAKTURY_IDX = 2;
	private final static int KONTRAHENT_IDX = 3;
	private final static int ODBIORCA_IDX = 4;
	private final static int PLATNOSC_IDX = 5;
	private final static int TOWAR1_IDX = 6;
	private final static int ILOSC1_IDX = 7;
	private final static int TOWAR2_IDX = 8;
	private final static int ILOSC2_IDX = 9;
	private final static int TOWAR3_IDX = 10;
	private final static int ILOSC3_IDX = 11;
	private final static int TOWAR4_IDX = 12;
	private final static int ILOSC4_IDX = 13;
	private final static int TOWAR5_IDX = 14;
	private final static int ILOSC5_IDX = 15;
	private final static int TOWAR6_IDX = 16;
	private final static int ILOSC6_IDX = 17;
	private final static int TOWAR7_IDX = 18;
	private final static int ILOSC7_IDX = 19;
	private final static int TOWAR8_IDX = 20;
	private final static int ILOSC8_IDX = 21;
	private final static int TOWAR9_IDX = 22;
	private final static int ILOSC9_IDX = 23;
	private final static int TOWAR10_IDX = 24;
	private final static int ILOSC10_IDX = 25;
	private final static int SUMATOWAROW_IDX = 26;
	
	public ModelTabelaFaktura(List<SpisFakturPrzyjecia> faktury) {
		this.faktury = faktury;
	}
	
	@Override
	public int getColumnCount() {
		return nazwyKolumn.length;
	}

	@Override
	public String getColumnName(int column) {
		return nazwyKolumn[column].toString();
	}

	@Override
	public int getRowCount() {
		if (faktury.size() == 0) {
			return 0;
		} else {
			return faktury.size();
		}
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		if (faktury == null) {
			return null;
		}
		
		SpisFakturPrzyjecia fakturaPrzyjecia2 = faktury.get(rowIndex);
		switch (columnIndex) {
		case NRFAKTURY_IDX:
			return fakturaPrzyjecia2.getNrFaktury();
		case DATA_IDX:
			return fakturaPrzyjecia2.getData();
		case NAZWAFAKTURY_IDX:
			return fakturaPrzyjecia2.getNazwaFaktury();
		case KONTRAHENT_IDX:
			return fakturaPrzyjecia2.getWystawiajacy();
		case ODBIORCA_IDX:
			return fakturaPrzyjecia2.getOdbiorca();
		case PLATNOSC_IDX:
			return fakturaPrzyjecia2.getPlatnosc();
		case TOWAR1_IDX:
			return fakturaPrzyjecia2.getTowar1();
		case ILOSC1_IDX:
			return fakturaPrzyjecia2.getIlosc1();
		case TOWAR2_IDX:
			return fakturaPrzyjecia2.getTowar2();
		case ILOSC2_IDX:
			return fakturaPrzyjecia2.getIlosc2();
		case TOWAR3_IDX:
			return fakturaPrzyjecia2.getTowar3();
		case ILOSC3_IDX:
			return fakturaPrzyjecia2.getIlosc3();
		case TOWAR4_IDX:
			return fakturaPrzyjecia2.getTowar4();
		case ILOSC4_IDX:
			return fakturaPrzyjecia2.getIlosc4();
		case TOWAR5_IDX:
			return fakturaPrzyjecia2.getTowar5();
		case ILOSC5_IDX:
			return fakturaPrzyjecia2.getIlosc5();
		case TOWAR6_IDX:
			return fakturaPrzyjecia2.getTowar6();
		case ILOSC6_IDX:
			return fakturaPrzyjecia2.getIlosc6();
		case TOWAR7_IDX:
			return fakturaPrzyjecia2.getTowar7();
		case ILOSC7_IDX:
			return fakturaPrzyjecia2.getIlosc7();
		case TOWAR8_IDX:
			return fakturaPrzyjecia2.getTowar8();
		case ILOSC8_IDX:
			return fakturaPrzyjecia2.getIlosc8();
		case TOWAR9_IDX:
			return fakturaPrzyjecia2.getTowar9();
		case ILOSC9_IDX:
			return fakturaPrzyjecia2.getIlosc9();
		case TOWAR10_IDX:
			return fakturaPrzyjecia2.getTowar10();
		case ILOSC10_IDX:
			return fakturaPrzyjecia2.getIlosc10();
		case SUMATOWAROW_IDX:
			return fakturaPrzyjecia2.getSumaTowarow();
		default:
			return fakturaPrzyjecia2;
		}
	}
}
