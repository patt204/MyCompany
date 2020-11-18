package interfejs;

import java.util.List;

import javax.swing.table.AbstractTableModel;
import dane.StanTowarowy;

public class ModelTabelaTowar extends AbstractTableModel {

	private List<StanTowarowy> towary;
	private final static Object[] nazwyKolumn = { "ID", "Kod", "Nazwa", "Ilosc", 
			"Ilosc M1", "Ilosc M2", "Cena netto", "Vat", "Suma" };
	private final static int ID_IDX = 0;
	private final static int KOD_IDX = 1;
	private final static int NAZWA_IDX = 2;
	private final static int ILOSC_IDX = 3;
	private final static int ILOSCM1_IDX = 4;
	private final static int ILOSCM2_IDX = 5;
	private final static int NETTO_IDX = 6;
	private final static int VAT_IDX = 7;
	private final static int SUMA_IDX = 8;

	public ModelTabelaTowar(List<StanTowarowy> towary) {
		this.towary = towary;
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
		if (towary.size() == 0) {
			return 0;
		} else {
			return towary.size();
		}
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		if (towary == null) {
			return null;
		}

		StanTowarowy towar1 = towary.get(rowIndex);
		switch (columnIndex) {
		case ID_IDX:
			return towar1.getIdTowar();
		case KOD_IDX:
			return towar1.getKod();
		case NAZWA_IDX:
			return towar1.getNazwa();
		case ILOSC_IDX:
			return towar1.getIlosc();
		case ILOSCM1_IDX:
			return towar1.getIloscM1();
		case ILOSCM2_IDX:
			return towar1.getIloscM2();
		case NETTO_IDX:
			return towar1.getCenaNetto();
		case VAT_IDX:
			return towar1.getVat();
		case SUMA_IDX:
			return ((towar1.getIlosc() + towar1.getIloscM1() + towar1.getIloscM2()) * (towar1.getCenaNetto() * towar1.getVat() + towar1.getCenaNetto()));
		default:
			return towar1;
		}
	}
}
