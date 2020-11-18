package interfejs;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import dane.SpisKlientow;

public class ModelTabelaKlient extends AbstractTableModel {

	private List<SpisKlientow> klienci;
	private final static Object[] nazwyKolumn = { "ID", "Data urodzin", "Imiê Nazwisko/ nazwa", "NIP", "Adres", "Telefon", "Inne" };
	private final static int ID_IDX = 0;
	private final static int SKROTNAZWA_IDX = 1;
	private final static int PELNANAZWA_IDX = 2;
	private final static int NIP_IDX = 3;
	private final static int ADRES_IDX = 4;
	private final static int TELEFON_IDX = 5;
	private final static int INNEKLIENT_IDX = 6;

	public ModelTabelaKlient(List<SpisKlientow> klienci) {
		this.klienci = klienci;
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
		if (klienci.size() == 0) {
			return 0;
		} else {
			return klienci.size();
		}
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		if (klienci == null) {
			return null;
		}

		SpisKlientow klient = klienci.get(rowIndex);
		switch (columnIndex) {
		case ID_IDX:
			return klient.getIdKlient();
		case SKROTNAZWA_IDX:
			return klient.getSkrotNazwa();
		case PELNANAZWA_IDX:
			return klient.getPelnaNazwa();
		case NIP_IDX:
			return klient.getNip();
		case ADRES_IDX:
			return klient.getAdres();
		case TELEFON_IDX:
			return klient.getTelefon();
		case INNEKLIENT_IDX:
			return klient.getInneKlient();
		default:
			return klient;
		}
	}
}
