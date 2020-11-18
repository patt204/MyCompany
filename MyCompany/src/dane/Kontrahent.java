package dane;

public class Kontrahent {

	private String skrotNazwaKo;
	private String pelnaNazwaKo;
	private String nipKo;
	private String adresKo;
	private String telefonKo;
	private String inneKontrahent;

	public Kontrahent(String skrotNazwaKo, String pelnaNazwaKo, String nipKo, String adresKo, String telefonKo, String inneKontrahent) {
		super();
		this.skrotNazwaKo = skrotNazwaKo;
		this.pelnaNazwaKo = pelnaNazwaKo;
		this.nipKo =  nipKo;
		this.adresKo = adresKo;
		this.telefonKo = telefonKo;
		this.inneKontrahent = inneKontrahent;
	}
	
	public String getSkrotNazwaKo() {
		return skrotNazwaKo;
	}
	public void setSkrotNazwaKo(String skrotNazwaKo) {
		this.skrotNazwaKo = skrotNazwaKo;
	}
	public String getPelnaNazwaKo() {
		return pelnaNazwaKo;
	}
	public void setPelnaNazwaKo(String pelnaNazwaKo) {
		this.pelnaNazwaKo = pelnaNazwaKo;
	}
	public String getNipKo() {
		return nipKo;
	}
	public void setNipKo(String nipKo) {
		this.nipKo = nipKo;
	}
	public String getAdresKo() {
		return adresKo;
	}
	public void setAdresKo(String adresKo) {
		this.adresKo = adresKo;
	}
	public String getTelefonKo() {
		return telefonKo;
	}
	public void setTelefonKo(String telefonKo) {
		this.telefonKo = telefonKo;
	}
	public String getInneKontrahent() {
		return inneKontrahent;
	}
	public void setInneKontrahent(String inneKontrahent) {
		this.inneKontrahent = inneKontrahent;
	}
	@Override
	public String toString() {
		return "Kontrahent [skrotNazwaKo=" + skrotNazwaKo + ", pelnaNazwaKo=" + pelnaNazwaKo + ", nipKo=" + nipKo + ", adresKo=" + adresKo + ", telefonKo=" + telefonKo + ", inneKontrahent=" + inneKontrahent + "]";
	}

}
