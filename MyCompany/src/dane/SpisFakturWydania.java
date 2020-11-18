package dane;

public class SpisFakturWydania {

	private int nrFaktury;
	private String data;
	private String nazwaFaktury;
	private String wystawiajacy;
	private String odbiorca;
	private String platnosc;
	private String oplataDo;
	private String sumaTowarow;
	
	public SpisFakturWydania( int nrFaktury, String data, String nazwaFaktury, String wystawiajacy, String odbiorca, String platnosc, String oplataDo, String sumaTowarow) {
		super();
		this.nrFaktury = nrFaktury;
		this.data = data;
		this.nazwaFaktury = nazwaFaktury;
		this.wystawiajacy = wystawiajacy;
		this.odbiorca = odbiorca;
		this.platnosc = platnosc;
		this.oplataDo = oplataDo;
		this.sumaTowarow = sumaTowarow;
}

	public int getNrFaktury() {
		return nrFaktury;
	}
	public void setNrFaktury(int nrFaktury) {
		this.nrFaktury = nrFaktury;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getNazwaFaktury() {
		return nazwaFaktury;
	}
	public void setNazwaFaktury(String nazwaFaktury) {
		this.nazwaFaktury = nazwaFaktury;
	}
	public String getWystawiajacy() {
		return wystawiajacy;
	}
	public void setWystawiajacy(String wystawiajacy) {
		this.wystawiajacy = wystawiajacy;
	}
	public String getOdbiorca() {
		return odbiorca;
	}
	public void setOdbiorca(String odbiorca) {
		this.odbiorca = odbiorca;
	}
	public String getPlatnosc() {
		return platnosc;
	}
	public void setPlatnosc(String platnosc) {
		this.platnosc = platnosc;
	}
	public String getOplataDo() {
		return oplataDo;
	}
	public void setOplataDo(String oplataDo) {
		this.oplataDo = oplataDo;
	}
	public String getSumaTowarow() {
		return sumaTowarow;
	}
	public void setSumaTowarow(String sumaTowarow) {
		this.sumaTowarow = sumaTowarow;
	}
	@Override
	public String toString() {
		return "FakturaPrzyjecie [nrFaktury " + nrFaktury + ", data=" + data + ", nazwaFaktury=" + nazwaFaktury + ", wystawiajacy=" + wystawiajacy + ", odbiorca=" + odbiorca + ", platnosc=" + platnosc + ", oplataDo=" + oplataDo + ", sumaTowarow=" + sumaTowarow + "]";
	}

}
