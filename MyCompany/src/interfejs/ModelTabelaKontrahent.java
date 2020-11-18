package interfejs;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import dane.SpisKontrahentow;

public class ModelTabelaKontrahent extends AbstractTableModel {

	private List<SpisKontrahentow> kontrahenci;
	private final static Object[] nazwyKolumn = { "ID", "Nazwa skrotu", "Pelna nazwa", "NIP", "Adres", "Telefon", "Inne" };
	private final static int ID_IDX = 0;
	private final static int SKROTNAZWAKO_IDX = 1;
	private final static int PELNANAZWAKO_IDX = 2;
	private final static int NIPKO_IDX = 3;
	private final static int ADRESKO_IDX = 4;
	private final static int TELEFONKO_IDX = 5;
	private final static int INNEKONTRAHENT_IDX = 6;

	public ModelTabelaKontrahent(List<SpisKontrahentow> kontrahenci) {
		this.kontrahenci = kontrahenci;
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
		if (kontrahenci.size() == 0) {
			return 0;
		} else {
			return kontrahenci.size();
		}
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		if (kontrahenci == null) {
			return null;
		}

		SpisKontrahentow kontrahent = kontrahenci.get(rowIndex);
		switch (columnIndex) {
		case ID_IDX:
			return kontrahent.getIdKontrahent();
		case SKROTNAZWAKO_IDX:
			return kontrahent.getSkrotNazwaKo();
		case PELNANAZWAKO_IDX:
			return kontrahent.getPelnaNazwaKo();
		case NIPKO_IDX:
			return kontrahent.getNipKo();
		case ADRESKO_IDX:
			return kontrahent.getAdresKo();
		case TELEFONKO_IDX:
			return kontrahent.getTelefonKo();
		case INNEKONTRAHENT_IDX:
			return kontrahent.getInneKontrahent();
		default:
			return kontrahent;
		}
	}
}
