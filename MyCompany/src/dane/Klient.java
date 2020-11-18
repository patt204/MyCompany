package dane;

public class Klient {

	private String skrotNazwa;
	private String pelnaNazwa;
	private String nip;
	private String adres;
	private String telefon;
	private String inneKlient;

	public Klient(String skrotNazwa, String pelnaNazwa, String nip, String adres, String telefon, String inneKlient) {
		super();
		this.skrotNazwa = skrotNazwa;
		this.pelnaNazwa = pelnaNazwa;
		this.nip =  nip;
		this.adres = adres;
		this.telefon = telefon;
		this.inneKlient = inneKlient;
	}
	
	public String getSkrotNazwa() {
		return skrotNazwa;
	}
	public void setSkrotNazwa(String skrotNazwa) {
		this.skrotNazwa = skrotNazwa;
	}
	public String getPelnaNazwa() {
		return pelnaNazwa;
	}
	public void setPelnaNazwa(String pelnaNazwa) {
		this.pelnaNazwa = pelnaNazwa;
	}
	public String getNip() {
		return nip;
	}
	public void setNip(String nip) {
		this.nip = nip;
	}
	public String getAdres() {
		return adres;
	}
	public void setAdres(String adres) {
		this.adres = adres;
	}
	public String getTelefon() {
		return telefon;
	}
	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}
	public String getInneKlient() {
		return inneKlient;
	}
	public void setInneKlient(String inneKlient) {
		this.inneKlient = inneKlient;
	}
	@Override
	public String toString() {
		return "Klient [skrotNazwa=" + skrotNazwa + ", pelnaNazwa=" + pelnaNazwa + ", nip=" + nip + ", adres=" + adres + ", telefon=" + telefon + ", inneKlient=" + inneKlient + "]";
	}

}
