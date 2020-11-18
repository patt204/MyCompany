package interfejs;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import dane.SpisFakturPrzyjecia;
import dane.SpisFakturWydania;

public class ModelTabelaFakturaWydania extends AbstractTableModel {
	
	private List<SpisFakturWydania> fakturyWydania;
	private final static Object[] nazwyKolumn = { "Numer faktury", "Data", "Nazwa faktury", "Kontrahent", "Odbiorca", "P³atnoœæ", "Op³ata za dni", "Suma towarów" };
	private final static int NRFAKTURY_IDX = 0;
	private final static int DATA_IDX = 1;
	private final static int NAZWAFAKTURY_IDX = 2;
	private final static int KONTRAHENT_IDX = 3;
	private final static int ODBIORCA_IDX = 4;
	private final static int PLATNOSC_IDX = 5;
	private final static int OPLATADO_IDX = 6;
	private final static int SUMATOWAROW_IDX = 7;
	
	public ModelTabelaFakturaWydania(List<SpisFakturWydania> fakturyWydania) {
		this.fakturyWydania = fakturyWydania;
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
		if (fakturyWydania.size() == 0) {
			return 0;
		} else {
			return fakturyWydania.size();
		}
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		if (fakturyWydania == null) {
			return null;
		}
		
		SpisFakturWydania faktura = fakturyWydania.get(rowIndex);
		switch (columnIndex) {
		case NRFAKTURY_IDX:
			return faktura.getNrFaktury();
		case DATA_IDX:
			return faktura.getData();
		case NAZWAFAKTURY_IDX:
			return faktura.getNazwaFaktury();
		case KONTRAHENT_IDX:
			return faktura.getWystawiajacy();
		case ODBIORCA_IDX:
			return faktura.getOdbiorca();
		case PLATNOSC_IDX:
			return faktura.getPlatnosc();
		case OPLATADO_IDX:
			return faktura.getOplataDo();
		case SUMATOWAROW_IDX:
			return faktura.getSumaTowarow();
		default:
			return faktura;
		}
	}
}

