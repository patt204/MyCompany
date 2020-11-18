package dane;

public class Towar {
	
	private String kod;
	private String nazwa;
	private int ilosc;
	private int iloscM1;
	private int iloscM2;
	private double cenaNetto;
	private double vat;
	private double sumaBrutto;

	public Towar(String kod, String nazwa, int ilosc, int iloscM1, 
			int iloscM2, double cenaNetto, double vat, double sumaBrutto) {
		super();
		this.kod = kod;
		this.nazwa = nazwa;
		this.ilosc = ilosc;
		this.iloscM1 = iloscM1;
		this.iloscM2 = iloscM2;
		this.cenaNetto = cenaNetto;
		this.vat = vat;
		this.sumaBrutto = sumaBrutto;
	}

	public String getKod() {
		return kod;
	}
	public void setKod(String kod) {
		this.kod = kod;
	}
	public String getNazwa() {
		return nazwa;
	}
	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}
	public int getIloscM1() {
		return iloscM1;
	}
	public void setIloscM1(int iloscM1) {
		this.iloscM1 = iloscM1;
	}
	public int getIloscM2() {
		return iloscM2;
	}
	public void setIloscM2(int iloscM2) {
		this.iloscM2 = iloscM2;
	}
	public int getIlosc() {
		return ilosc;
	}
	public void setIlosc(int ilosc) {
		this.ilosc = ilosc;
	}
	public double getCenaNetto() {
		return cenaNetto;
	}
	public void setCenaNetto(double cenaNetto) {
		this.cenaNetto = cenaNetto;
	}
	public double getVat() {
		return vat;
	}
	public void setVat(double vat) {
		this.vat = vat;
	}
	public double getSumaBrutto() {
		//return (Math.round((ilosc + iloscM1 + iloscM2) * (cenaNetto*vat + cenaNetto)*100))/100;
		return ((ilosc + iloscM1 + iloscM2) * (Math.round(cenaNetto * vat + cenaNetto)*100)/100);
	}
	public void setSumaBrutto(double sumaBrutto) {
		this.sumaBrutto = sumaBrutto;
	}
	@Override
	public String toString() {
		return "Towar [kod=" + kod + ", nazwa=" + nazwa + ", ilosc=" + ilosc + ", iloscM1=" + iloscM1 + ", iloscM2=" + iloscM2 + ", cenaNetto=" + cenaNetto + ", vat=" + vat + ", sumaBrutto=" + sumaBrutto + "]";
	}

}
