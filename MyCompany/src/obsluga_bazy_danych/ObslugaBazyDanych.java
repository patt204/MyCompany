package obsluga_bazy_danych;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import dane.SpisFakturPrzyjecia;
import dane.SpisFakturWydania;
import dane.SpisKlientow;
import dane.SpisKontrahentow;

/*import dane.Faktury;*/
import dane.StanTowarowy;

public class ObslugaBazyDanych {

	private Connection polacz;
	private Statement stanPolaczenia;

	public ObslugaBazyDanych() {
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}

		try {
			polacz = DriverManager.getConnection("jdbc:sqlite:baza_danych.db");
			stanPolaczenia = polacz.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		utworzTabeleTowar();
		utworzTabeleKlient();
		utworzTabeleKontrahent();
		utworzTabeleFakturaPrzyjecia();
		utworzTabeleFakturaWydania();
	}
	
	public void utworzTabeleTowar() {
		String zapytanie = "CREATE TABLE IF NOT EXISTS " 
				+ "towar (idTowar INTEGER PRIMARY KEY AUTOINCREMENT, "
				+ "kodKreskowy varchar(255), " + "nazwa varchar(255), " 
				+ "ilosc int, " + "iloscM1 int, " + "iloscM2 int, " + "cenaNetto float,"
				+ "vat float," + "sumaBrutto float)";

		try {
			stanPolaczenia.execute(zapytanie);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
		
	
	public void utworzTabeleKlient() {
		String zapytanie = "CREATE TABLE IF NOT EXISTS " 
				+ "klient (idKlient INTEGER PRIMARY KEY AUTOINCREMENT, "
				+ "skrotNazwa varchar(255), " + "pelnaNazwa varchar(255), " 
				+ "nip varchar(255), " + "adres varchar(255), " + "telefon varchar(255), " 
				+ "inneKlient varchar(255))";

		try {
			stanPolaczenia.execute(zapytanie);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void utworzTabeleKontrahent() {
		String zapytanie = "CREATE TABLE IF NOT EXISTS " 
				+ "kontrahent (idKontrahent INTEGER PRIMARY KEY AUTOINCREMENT, "
				+ "skrotNazwaKo varchar(255), " + "pelnaNazwaKo varchar(255), " 
				+ "nipKo varchar(255), " + "adresKo varchar(255), " 
				+ "telefonKo varchar(255), " + "inneKontrahent varchar(255))";

		try {
			stanPolaczenia.execute(zapytanie);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void utworzTabeleFakturaPrzyjecia() {
		String zapytanie1 = "CREATE TABLE IF NOT EXISTS " 
							+ "fakturaPrzyjecia (nrFaktury INTEGER PRIMARY KEY AUTOINCREMENT, "
							+ "data varchar(255), " + "nazwaFaktury varchar(255), " 
							+ "wystawiajacy varchar(255), " + "odbiorca varchar(255), " 
							+ "platnosc varchar(255), " + "towar1 varchar(255)," + "ilosc1 int," 
							+ "towar2 varchar(255)," + "ilosc2 int,"
							+ "towar3 varchar(255)," + "ilosc3 int,"
							+ "towar4 varchar(255)," + "ilosc4 int,"
							+ "towar5 varchar(255)," + "ilosc5 int,"
							+ "towar6 varchar(255)," + "ilosc6 int,"
							+ "towar7 varchar(255)," + "ilosc7 int,"
							+ "towar8 varchar(255)," + "ilosc8 int,"
							+ "towar9 varchar(255)," + "ilosc9 int,"
							+ "towar10 varchar(255)," + "ilosc10 int,"
							+ "sumaTowarow float)";

		try {
			stanPolaczenia.execute(zapytanie1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void utworzTabeleFakturaWydania() {
		String zapytanie1 = "CREATE TABLE IF NOT EXISTS " 
				+ "fakturaWydania (nrFaktury INTEGER PRIMARY KEY AUTOINCREMENT, "
				+ "data varchar(255), " + "nazwaFaktury varchar(255), " 
				+ "wystawiajacy varchar(255), " + "odbiorca varchar(255), " 
				+ "platnosc varchar(255), " + "towar1 varchar(255)," + "ilosc1 int," 
				+ "towar2 varchar(255)," + "ilosc2 int,"
				+ "towar3 varchar(255)," + "ilosc3 int,"
				+ "towar4 varchar(255)," + "ilosc4 int,"
				+ "towar5 varchar(255)," + "ilosc5 int,"
				+ "towar6 varchar(255)," + "ilosc6 int,"
				+ "towar7 varchar(255)," + "ilosc7 int,"
				+ "towar8 varchar(255)," + "ilosc8 int,"
				+ "towar9 varchar(255)," + "ilosc9 int,"
				+ "towar10 varchar(255)," + "ilosc10 int,"
				+ "sumaTowarow float)";

		try {
			stanPolaczenia.execute(zapytanie1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public boolean zamknijPolaczenie() {
		try {
			polacz.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	//dodanie danych do tabeli towar
	
	public void dodajDane1(String kod, String nazwa, int ilosc, int iloscM1, int iloscM2, double cenaNetto, double vat,
			double sumaBrutto) {
		String zapytanieTekst = "insert into towar values (NULL, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement zapytanie = polacz.prepareStatement(zapytanieTekst);

			zapytanie.setString(1, kod);
			zapytanie.setString(2, nazwa);
			zapytanie.setInt(3, ilosc);
			zapytanie.setInt(4, iloscM1);
			zapytanie.setInt(5, iloscM2);
			zapytanie.setDouble(6, cenaNetto);
			zapytanie.setDouble(7, vat);
			zapytanie.setDouble(8, sumaBrutto);

			zapytanie.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	//dodanie danych do tabeli klient
	
	public void dodajDane2(String skrotNazwa, String pelnaNazwa,  String nip, String adres, 
			String telefon, String inneKlient) {
		String zapytanieTekst = "insert into klient values (NULL, ?, ?, ?, ?, ?,?)";
		try {
			PreparedStatement zapytanie = polacz.prepareStatement(zapytanieTekst);

			zapytanie.setString(1, skrotNazwa);
			zapytanie.setString(2, pelnaNazwa);
			zapytanie.setString(3, nip);
			zapytanie.setString(4, adres);
			zapytanie.setString(5, telefon);
			zapytanie.setString(6, inneKlient);

			zapytanie.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//dodanie danych do tabeli kontrahent
	
		public void dodajDane3(String skrotNazwaKo, String pelnaNazwaKo,  String nipKo, String adresKo, String telefonKo, String inneKontrahent) {
			String zapytanieTekst = "insert into kontrahent values (NULL, ?, ?, ?, ?, ?,?)";
			try {
				PreparedStatement zapytanie = polacz.prepareStatement(zapytanieTekst);

				zapytanie.setString(1, skrotNazwaKo);
				zapytanie.setString(2, pelnaNazwaKo);
				zapytanie.setString(3, nipKo);
				zapytanie.setString(4, adresKo);
				zapytanie.setString(5, telefonKo);
				zapytanie.setString(6, inneKontrahent);

				zapytanie.execute();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	//dodanie danych do tabeli faktury
	
	public void dodajDane4(String data, String nazwaFaktury, String wystawiajacy, 
			String odbiorca, String platnosc, String towar1, int ilosc1, 
			String towar2, int ilosc2, String towar3, int ilosc3,
			String towar4, int ilosc4, String towar5, int ilosc5,
			String towar6, int ilosc6, String towar7, int ilosc7,
			String towar8, int ilosc8, String towar9, int ilosc9,
			String towar10, int ilosc10, double sumaTowarow) {
		String zapytanieTekst1 = "insert into fakturaPrzyjecia values (NULL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement zapytanie1 = polacz.prepareStatement(zapytanieTekst1);

			zapytanie1.setString(1, data);
			zapytanie1.setString(2, nazwaFaktury);
			zapytanie1.setString(3, wystawiajacy);
			zapytanie1.setString(4, odbiorca);
			zapytanie1.setString(5, platnosc);
			zapytanie1.setString(6, towar1);
			zapytanie1.setInt(7, ilosc1);
			zapytanie1.setString(8, towar2);
			zapytanie1.setInt(9, ilosc2);
			zapytanie1.setString(10, towar3);
			zapytanie1.setInt(11, ilosc3);
			zapytanie1.setString(12, towar4);
			zapytanie1.setInt(13, ilosc4);
			zapytanie1.setString(14, towar5);
			zapytanie1.setInt(15, ilosc5);
			zapytanie1.setString(16, towar6);
			zapytanie1.setInt(17, ilosc6);
			zapytanie1.setString(18, towar7);
			zapytanie1.setInt(19, ilosc7);
			zapytanie1.setString(20, towar8);
			zapytanie1.setInt(21, ilosc8);
			zapytanie1.setString(22, towar9);
			zapytanie1.setInt(23, ilosc9);
			zapytanie1.setString(24, towar10);
			zapytanie1.setInt(25, ilosc10);
			zapytanie1.setDouble(26, sumaTowarow);
			
			zapytanie1.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public void dodajDane5(String data, String nazwaFaktury, String wystawiajacy, 
			String odbiorca, String platnosc, String towar1, int ilosc1, 
			String towar2, int ilosc2, String towar3, int ilosc3,
			String towar4, int ilosc4, String towar5, int ilosc5,
			String towar6, int ilosc6, String towar7, int ilosc7,
			String towar8, int ilosc8, String towar9, int ilosc9,
			String towar10, int ilosc10, double sumaTowarow) {
		String zapytanieTekst1 = "insert into fakturaWydania values (NULL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement zapytanie1 = polacz.prepareStatement(zapytanieTekst1);

			zapytanie1.setString(1, data);
			zapytanie1.setString(2, nazwaFaktury);
			zapytanie1.setString(3, wystawiajacy);
			zapytanie1.setString(4, odbiorca);
			zapytanie1.setString(5, platnosc);
			zapytanie1.setString(6, towar1);
			zapytanie1.setInt(7, ilosc1);
			zapytanie1.setString(8, towar2);
			zapytanie1.setInt(9, ilosc2);
			zapytanie1.setString(10, towar3);
			zapytanie1.setInt(11, ilosc3);
			zapytanie1.setString(12, towar4);
			zapytanie1.setInt(13, ilosc4);
			zapytanie1.setString(14, towar5);
			zapytanie1.setInt(15, ilosc5);
			zapytanie1.setString(16, towar6);
			zapytanie1.setInt(17, ilosc6);
			zapytanie1.setString(18, towar7);
			zapytanie1.setInt(19, ilosc7);
			zapytanie1.setString(20, towar8);
			zapytanie1.setInt(21, ilosc8);
			zapytanie1.setString(22, towar9);
			zapytanie1.setInt(23, ilosc9);
			zapytanie1.setString(24, towar10);
			zapytanie1.setInt(25, ilosc10);
			zapytanie1.setDouble(26, sumaTowarow);
			
			zapytanie1.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	//edycja danych w tabeli towar
	
	public void edytujDane(String nazwa, int ilosc, int iloscM1, int iloscM2, double cenaNetto, 
			int idTowar) {
		
		String zapytanieTekst = " ";
		String zapytanieTekst2 = " ";
		String zapytanieTekst3 = " ";
		String zapytanieTekst4 = " ";
		String zapytanieTekst5 = " ";
		String zapytanieTekst6 = " ";
		
		if(nazwa.length() > 0) {
			zapytanieTekst = "update towar set nazwa='" + nazwa + "' where idTowar= '" + idTowar + "'";
		}
		if(ilosc > 0) {
			zapytanieTekst2 = "update towar set ilosc='" + ilosc + "' where idTowar= '" + idTowar + "'";
		}
		if(iloscM1 > 0) {
			zapytanieTekst3 = "update towar set iloscM1='" + iloscM1 + "' where idTowar= '" + idTowar + "'";
		}
		if(iloscM2 > 0) {
			zapytanieTekst4 = "update towar set iloscM2='" + iloscM2 + "' where idTowar= '" + idTowar + "'";
		}
		if(cenaNetto > 0) {
			zapytanieTekst5 = "update towar set cenaNetto='" + cenaNetto + "' where idTowar= '" + idTowar + "'";
		}

		try {

			stanPolaczenia.executeUpdate(zapytanieTekst);
			stanPolaczenia.executeUpdate(zapytanieTekst2);
			stanPolaczenia.executeUpdate(zapytanieTekst3);
			stanPolaczenia.executeUpdate(zapytanieTekst4);
			stanPolaczenia.executeUpdate(zapytanieTekst5);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//edycja danych w tabeli klient
	
	public void edytujDane2(String skrotNazwa, String pelnaNazwa, String nip, String adres, 
			String telefon, String inneKlient,  int idKlient) {
		
		String zapytanieTekst = " ";
		String zapytanieTekst2 = " ";
		String zapytanieTekst3 = " ";
		String zapytanieTekst4 = " ";
		String zapytanieTekst5 = " ";
		String zapytanieTekst6 = " ";
		
		if(skrotNazwa.length() > 0) {
			zapytanieTekst = "update klient set skrotNazwa='" + skrotNazwa 
					+ "' where idKlient= '" + idKlient + "'";
		}
		if(pelnaNazwa.length() > 0) {
			zapytanieTekst2 = "update klient set pelnaNazwa='" + pelnaNazwa 
					+ "' where idKlient= '" + idKlient + "'";
		}
		if(nip.length() > 0) {
			zapytanieTekst3 = "update klient set nip='" + nip + "' where idKlient= '" 
		+ idKlient + "'";
		}
		if(adres.length() > 0) {
			zapytanieTekst4 = "update klient set adres='" + adres + "' where idKlient= '" 
		+ idKlient + "'";
		}
		if(telefon.length() > 0) {
			zapytanieTekst5 = "update klient set telefon='" + telefon + "' where idKlient= '" 
		+ idKlient + "'";
		}
		if(inneKlient.length() > 0) {
			zapytanieTekst6 = "update klient set inneKlient='" + inneKlient + "' where idKlient= '" 
		+ idKlient + "'";
		}

		try {

			stanPolaczenia.executeUpdate(zapytanieTekst);
			stanPolaczenia.executeUpdate(zapytanieTekst2);
			stanPolaczenia.executeUpdate(zapytanieTekst3);
			stanPolaczenia.executeUpdate(zapytanieTekst4);
			stanPolaczenia.executeUpdate(zapytanieTekst5);
			stanPolaczenia.executeUpdate(zapytanieTekst6);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	//edycja danych w tabeli kontrahent
	
	public void edytujDane3(String skrotNazwaKo, String pelnaNazwaKo, String nipKo, String adresKo, 
			String telefonKo, String inneKontrahent,  int idKontrahent) {
		
		String zapytanieTekst = " ";
		String zapytanieTekst2 = " ";
		String zapytanieTekst3 = " ";
		String zapytanieTekst4 = " ";
		String zapytanieTekst5 = " ";
		String zapytanieTekst6 = " ";
		
		if(skrotNazwaKo.length() > 0) {
			zapytanieTekst = "update kontrahent set skrotNazwaKo='" + skrotNazwaKo + "' where idKontrahent= '" + idKontrahent + "'";
		}
		if(pelnaNazwaKo.length() > 0) {
			zapytanieTekst2 = "update kontrahent set pelnaNazwaKo='" + pelnaNazwaKo + "' where idKontrahent= '" + idKontrahent + "'";
		}
		if(nipKo.length() > 0) {
			zapytanieTekst3 = "update kontrahent set nipKo='" + nipKo + "' where idKontrahent= '" + idKontrahent + "'";
		}
		if(adresKo.length() > 0) {
			zapytanieTekst4 = "update kontrahent set adresKo='" + adresKo + "' where idKontrahent= '" + idKontrahent + "'";
		}
		if(telefonKo.length() > 0) {
			zapytanieTekst5 = "update kontrahent set telefonKo='" + telefonKo + "' where idKontrahent= '" + idKontrahent + "'";
		}
		if(inneKontrahent.length() > 0) {
			zapytanieTekst6 = "update kontrahent set inneKontrahent='" + inneKontrahent + "' where idKontrahent= '" + idKontrahent + "'";
		}
		
		try {

			stanPolaczenia.executeUpdate(zapytanieTekst);
			stanPolaczenia.executeUpdate(zapytanieTekst2);
			stanPolaczenia.executeUpdate(zapytanieTekst3);
			stanPolaczenia.executeUpdate(zapytanieTekst4);
			stanPolaczenia.executeUpdate(zapytanieTekst5);
			stanPolaczenia.executeUpdate(zapytanieTekst6);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void edytujDane4(String data, String nazwaFaktury, String wystawiajacy, String odbiorca, 
			String platnosc, String idTowarow, String iloscTowarow, String sumaTowarow, int nrFaktury) {
		
		String zapytanieTekst = " ";
		String zapytanieTekst2 = " ";
		String zapytanieTekst3 = "update fakturaPrzyjecia set wystawiajacy='" + wystawiajacy + "' where nrFaktury= '" + nrFaktury + "'";
		String zapytanieTekst4 = " ";
		String zapytanieTekst5 = " ";
		String zapytanieTekst6 = " ";
		String zapytanieTekst7 = " ";
		String zapytanieTekst8 = " ";
		
		if(data.length() > 0) {
			zapytanieTekst = "update fakturaPrzyjecia set data='" + data + "' where nrFaktury= '" + nrFaktury + "'";
		}
		if(nazwaFaktury.length() > 0) {
			zapytanieTekst2 = "update fakturaPrzyjecia set nazwaFaktury='" + nazwaFaktury + "' where nrFaktury= '" + nrFaktury + "'";
		}
		
		if(odbiorca.length() > 0) {
			zapytanieTekst4 = "update fakturaPrzyjecia set odbiorca='" + odbiorca + "' where nrFaktury= '" + nrFaktury + "'";
		}
		if(platnosc.length() > 0) {
			zapytanieTekst5 = "update fakturaPrzyjecia set platnosc='" + platnosc + "' where nrFaktury= '" + nrFaktury + "'";
		}
		if(idTowarow.length() > 0) {
			zapytanieTekst6 = "update fakturaPrzyjecia set idTowarow='" + idTowarow + "' where nrFaktury= '" + nrFaktury + "'";
		}
		if(idTowarow.length() > 0) {
			zapytanieTekst7 = "update fakturaPrzyjecia set iloscTowarow='" + iloscTowarow + "' where nrFaktury= '" + nrFaktury + "'";
		}
		if(sumaTowarow.length() > 0) {
			zapytanieTekst8 = "update fakturaPrzyjecia set sumaTowarow='" + sumaTowarow + "' where nrFaktury= '" + nrFaktury + "'";
		}

		try {

			stanPolaczenia.executeUpdate(zapytanieTekst);
			stanPolaczenia.executeUpdate(zapytanieTekst2);
			stanPolaczenia.executeUpdate(zapytanieTekst3);
			stanPolaczenia.executeUpdate(zapytanieTekst4);
			stanPolaczenia.executeUpdate(zapytanieTekst5);
			stanPolaczenia.executeUpdate(zapytanieTekst6);
			stanPolaczenia.executeUpdate(zapytanieTekst7);
			stanPolaczenia.executeUpdate(zapytanieTekst8);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void edytujDane5(String data, String nazwaFaktury, String wystawiajacy, String odbiorca, 
			String platnosc, String idTowarow, String iloscTowarow, String sumaTowarow, int nrFaktury) {
		
		String zapytanieTekst = " ";
		String zapytanieTekst2 = " ";
		String zapytanieTekst3 = "update fakturaPrzyjecia set wystawiajacy='" + wystawiajacy + "' where nrFaktury= '" + nrFaktury + "'";
		String zapytanieTekst4 = " ";
		String zapytanieTekst5 = " ";
		String zapytanieTekst6 = " ";
		String zapytanieTekst7 = " ";
		String zapytanieTekst8 = " ";
		
		if(data.length() > 0) {
			zapytanieTekst = "update fakturaPrzyjecia set data='" + data + "' where nrFaktury= '" + nrFaktury + "'";
		}
		if(nazwaFaktury.length() > 0) {
			zapytanieTekst2 = "update fakturaPrzyjecia set nazwaFaktury='" + nazwaFaktury + "' where nrFaktury= '" + nrFaktury + "'";
		}
		
		if(odbiorca.length() > 0) {
			zapytanieTekst4 = "update fakturaPrzyjecia set odbiorca='" + odbiorca + "' where nrFaktury= '" + nrFaktury + "'";
		}
		if(platnosc.length() > 0) {
			zapytanieTekst5 = "update fakturaPrzyjecia set platnosc='" + platnosc + "' where nrFaktury= '" + nrFaktury + "'";
		}
		if(idTowarow.length() > 0) {
			zapytanieTekst6 = "update fakturaPrzyjecia set idTowarow='" + idTowarow + "' where nrFaktury= '" + nrFaktury + "'";
		}
		if(idTowarow.length() > 0) {
			zapytanieTekst7 = "update fakturaPrzyjecia set iloscTowarow='" + iloscTowarow + "' where nrFaktury= '" + nrFaktury + "'";
		}
		if(sumaTowarow.length() > 0) {
			zapytanieTekst8 = "update fakturaPrzyjecia set sumaTowarow='" + sumaTowarow + "' where nrFaktury= '" + nrFaktury + "'";
		}

		try {

			stanPolaczenia.executeUpdate(zapytanieTekst);
			stanPolaczenia.executeUpdate(zapytanieTekst2);
			stanPolaczenia.executeUpdate(zapytanieTekst3);
			stanPolaczenia.executeUpdate(zapytanieTekst4);
			stanPolaczenia.executeUpdate(zapytanieTekst5);
			stanPolaczenia.executeUpdate(zapytanieTekst6);
			stanPolaczenia.executeUpdate(zapytanieTekst7);
			stanPolaczenia.executeUpdate(zapytanieTekst8);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	//pobieranie danych z tabeli towar
	
	public ArrayList<StanTowarowy> pobierzDane1() {

		ArrayList<StanTowarowy> listaTowarow1 = new ArrayList<StanTowarowy>();

		String zapytanieTekst = "select * from towar";

		try {
			ResultSet zestawWynikow = stanPolaczenia.executeQuery(zapytanieTekst);

			int idTowarIN = 0, iloscIN = 0, iloscM1IN = 0, iloscM2IN = 0;;
			double cenaNettoIN = 0.0, sumaBruttoIN = 0.0, vatIN = 0.23;
			String nazwaIN = null, kodKreskowyIN = null;

			while (zestawWynikow.next()) {
				idTowarIN = zestawWynikow.getInt("idTowar");
				kodKreskowyIN = zestawWynikow.getString("kodKreskowy");
				nazwaIN = zestawWynikow.getString("nazwa");
				iloscIN = zestawWynikow.getInt("ilosc");
				iloscM1IN = zestawWynikow.getInt("iloscM1");
				iloscM2IN = zestawWynikow.getInt("iloscM2");
				cenaNettoIN = zestawWynikow.getDouble("cenaNetto");
				vatIN = zestawWynikow.getDouble("vat");
				sumaBruttoIN = zestawWynikow.getDouble("sumaBrutto");

				listaTowarow1.add(new StanTowarowy(idTowarIN, kodKreskowyIN, nazwaIN, iloscIN, iloscM1IN, iloscM2IN, cenaNettoIN, vatIN,
						sumaBruttoIN));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaTowarow1;
	}
 
	//pobieranie danych z tabeli klient
	
	public ArrayList<SpisKlientow> pobierzDane2() {

		ArrayList<SpisKlientow> listaKlientow = new ArrayList<SpisKlientow>();

		String zapytanieTekst = "select * from klient";

		try {
			ResultSet zestawWynikow = stanPolaczenia.executeQuery(zapytanieTekst);

			int idKlientIN = 0;
			String skrotNazwaIN = null, pelnaNazwaIN = null, nipIN = null, 
					adresIN = null, telefonIN = null, inneKlientIN = null;

			while (zestawWynikow.next()) {
				idKlientIN = zestawWynikow.getInt("idKlient");
				skrotNazwaIN = zestawWynikow.getString("skrotNazwa");
				pelnaNazwaIN = zestawWynikow.getString("pelnaNazwa");
				nipIN = zestawWynikow.getString("nip");
				adresIN = zestawWynikow.getString("adres");
				telefonIN = zestawWynikow.getString("telefon");
				inneKlientIN = zestawWynikow.getString("inneKlient");

				listaKlientow.add(new SpisKlientow(idKlientIN, skrotNazwaIN, pelnaNazwaIN, 
						nipIN, adresIN, telefonIN, inneKlientIN));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaKlientow;
	}

	//pobieranie danych z tabeli kontrahent
	
	public ArrayList<SpisKontrahentow> pobierzDane3() {

		ArrayList<SpisKontrahentow> listaKontrahentow = new ArrayList<SpisKontrahentow>();

		String zapytanieTekst = "select * from kontrahent";

		try {
			ResultSet zestawWynikow = stanPolaczenia.executeQuery(zapytanieTekst);

			int idKontrahentIN = 0;
			String skrotNazwaKoIN = null, pelnaNazwaKoIN = null, nipKoIN = null, adresKoIN = null, telefonKoIN = null, inneKontrahentIN = null;

			while (zestawWynikow.next()) {
				idKontrahentIN = zestawWynikow.getInt("idKontrahent");
				skrotNazwaKoIN = zestawWynikow.getString("skrotNazwaKo");
				pelnaNazwaKoIN = zestawWynikow.getString("pelnaNazwaKo");
				nipKoIN = zestawWynikow.getString("nipKo");
				adresKoIN = zestawWynikow.getString("adresKo");
				telefonKoIN = zestawWynikow.getString("telefonKo");
				inneKontrahentIN = zestawWynikow.getString("inneKontrahent");

				listaKontrahentow.add(new SpisKontrahentow(idKontrahentIN, skrotNazwaKoIN, pelnaNazwaKoIN, nipKoIN, adresKoIN, telefonKoIN,
						inneKontrahentIN));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaKontrahentow;
	}	
	
	//pobieranie danych z tabeli faktury przyjecia
	
	public ArrayList<SpisFakturPrzyjecia> pobierzDane4() {

		ArrayList<SpisFakturPrzyjecia> listaFakturPrzyjecia = new ArrayList<SpisFakturPrzyjecia>();

		String zapytanieTekst1 = "select * from fakturaPrzyjecia";

		try {
			ResultSet zestawWynikow1 = stanPolaczenia.executeQuery(zapytanieTekst1);

			int nrFakturyIN = 0;
			int ilosc1IN = 0;
			int ilosc2IN = 0;
			int ilosc3IN = 0;
			int ilosc4IN = 0;
			int ilosc5IN = 0;
			int ilosc6IN = 0;
			int ilosc7IN = 0;
			int ilosc8IN = 0;
			int ilosc9IN = 0;
			int ilosc10IN = 0;
			double sumaTowarowIN = 0.0;
			String dataIN = null,  nazwaFakturyIN = null, wystawiajacyIN = null, odbiorcaIN = null, platnoscIN = null, 
					towar1IN = null, towar2IN = null, towar3IN = null, towar4IN = null, towar5IN = null, towar6IN = null,
							towar7IN = null, towar8IN = null, towar9IN = null, towar10IN = null;
			while (zestawWynikow1.next()) {
				nrFakturyIN = zestawWynikow1.getInt("nrFaktury");
				dataIN = zestawWynikow1.getString("data");
				nazwaFakturyIN = zestawWynikow1.getString("nazwaFaktury");
				wystawiajacyIN = zestawWynikow1.getString("wystawiajacy");
				odbiorcaIN = zestawWynikow1.getString("odbiorca");
				platnoscIN = zestawWynikow1.getString("platnosc");
				towar1IN = zestawWynikow1.getString("towar1");
				ilosc1IN = zestawWynikow1.getInt("ilosc1");
				towar2IN = zestawWynikow1.getString("towar2");
				ilosc2IN = zestawWynikow1.getInt("ilosc2");
				towar3IN = zestawWynikow1.getString("towar3");
				ilosc3IN = zestawWynikow1.getInt("ilosc3");
				towar4IN = zestawWynikow1.getString("towar4");
				ilosc4IN = zestawWynikow1.getInt("ilosc4");
				towar5IN = zestawWynikow1.getString("towar5");
				ilosc5IN = zestawWynikow1.getInt("ilosc5");
				towar6IN = zestawWynikow1.getString("towar6");
				ilosc6IN = zestawWynikow1.getInt("ilosc6");
				towar7IN = zestawWynikow1.getString("towar7");
				ilosc7IN = zestawWynikow1.getInt("ilosc7");
				towar8IN = zestawWynikow1.getString("towar8");
				ilosc8IN = zestawWynikow1.getInt("ilosc8");
				towar9IN = zestawWynikow1.getString("towar9");
				ilosc9IN = zestawWynikow1.getInt("ilosc9");
				towar10IN = zestawWynikow1.getString("towar10");
				ilosc10IN = zestawWynikow1.getInt("ilosc10");
				sumaTowarowIN = zestawWynikow1.getDouble("sumaTowarow");

				listaFakturPrzyjecia.add(new SpisFakturPrzyjecia(nrFakturyIN, dataIN, nazwaFakturyIN, wystawiajacyIN, odbiorcaIN, platnoscIN, towar1IN, ilosc1IN, towar2IN, ilosc2IN, towar3IN, ilosc3IN, 
						towar4IN, ilosc4IN, towar5IN, ilosc5IN, towar6IN, ilosc6IN, towar7IN, ilosc7IN, towar8IN, ilosc8IN, 
						towar9IN, ilosc9IN, towar10IN, ilosc10IN, sumaTowarowIN));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaFakturPrzyjecia;
	}
	
	//pobieranie danych z tabeli faktury wydania
	
		public ArrayList<SpisFakturWydania> pobierzDane5() {

			ArrayList<SpisFakturWydania> listaFakturWydania = new ArrayList<SpisFakturWydania>();

			String zapytanieTekst1 = "select * from fakturaWydania";

			try {
				ResultSet zestawWynikow1 = stanPolaczenia.executeQuery(zapytanieTekst1);

				int nrFakturyIN = 0;
				int ilosc1IN = 0;
				int ilosc2IN = 0;
				int ilosc3IN = 0;
				int ilosc4IN = 0;
				int ilosc5IN = 0;
				int ilosc6IN = 0;
				int ilosc7IN = 0;
				int ilosc8IN = 0;
				int ilosc9IN = 0;
				int ilosc10IN = 0;
				double sumaTowarowIN = 0.0;
				String dataIN = null,  nazwaFakturyIN = null, wystawiajacyIN = null, odbiorcaIN = null, platnoscIN = null, 
						towar1IN = null, towar2IN = null, towar3IN = null, towar4IN = null, towar5IN = null, towar6IN = null,
								towar7IN = null, towar8IN = null, towar9IN = null, towar10IN = null;
				while (zestawWynikow1.next()) {
					nrFakturyIN = zestawWynikow1.getInt("nrFaktury");
					dataIN = zestawWynikow1.getString("data");
					nazwaFakturyIN = zestawWynikow1.getString("nazwaFaktury");
					wystawiajacyIN = zestawWynikow1.getString("wystawiajacy");
					odbiorcaIN = zestawWynikow1.getString("odbiorca");
					platnoscIN = zestawWynikow1.getString("platnosc");
					towar1IN = zestawWynikow1.getString("towar1");
					ilosc1IN = zestawWynikow1.getInt("ilosc1");
					towar2IN = zestawWynikow1.getString("towar2");
					ilosc2IN = zestawWynikow1.getInt("ilosc2");
					towar3IN = zestawWynikow1.getString("towar3");
					ilosc3IN = zestawWynikow1.getInt("ilosc3");
					towar4IN = zestawWynikow1.getString("towar4");
					ilosc4IN = zestawWynikow1.getInt("ilosc4");
					towar5IN = zestawWynikow1.getString("towar5");
					ilosc5IN = zestawWynikow1.getInt("ilosc5");
					towar6IN = zestawWynikow1.getString("towar6");
					ilosc6IN = zestawWynikow1.getInt("ilosc6");
					towar7IN = zestawWynikow1.getString("towar7");
					ilosc7IN = zestawWynikow1.getInt("ilosc7");
					towar8IN = zestawWynikow1.getString("towar8");
					ilosc8IN = zestawWynikow1.getInt("ilosc8");
					towar9IN = zestawWynikow1.getString("towar9");
					ilosc9IN = zestawWynikow1.getInt("ilosc9");
					towar10IN = zestawWynikow1.getString("towar10");
					ilosc10IN = zestawWynikow1.getInt("ilosc10");
					sumaTowarowIN = zestawWynikow1.getDouble("sumaTowarow");

					listaFakturWydania.add(new SpisFakturWydania(nrFakturyIN, dataIN, nazwaFakturyIN, wystawiajacyIN, odbiorcaIN, platnoscIN, towar1IN, ilosc1IN, towar2IN, ilosc2IN, towar3IN, ilosc3IN, 
							towar4IN, ilosc4IN, towar5IN, ilosc5IN, towar6IN, ilosc6IN, towar7IN, ilosc7IN, towar8IN, ilosc8IN, 
							towar9IN, ilosc9IN, towar10IN, ilosc10IN, sumaTowarowIN));
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
			return listaFakturWydania;
		}

	
	//pobranie danych do aktualizacji
	
	public ArrayList<StanTowarowy> pobierzProdukt(String kod, String nazwa, int ilosc, int iloscM1, int iloscM2, double cenaNetto) {

		ArrayList<StanTowarowy> listaTowarow1 = new ArrayList<StanTowarowy>();

		String zapytanieTekst = "select * from towar where kodKreskowy=" + kod + ", nazwa='" + nazwa + "', cenaNetto="
				+ cenaNetto;

		try {
			ResultSet zestawWynikow = stanPolaczenia.executeQuery(zapytanieTekst);

			int idTowarIN = 0, iloscIN = 0, iloscM1IN = 0, iloscM2IN = 0;
			double cenaNettoIN = 0.0, sumaBruttoIN = 0.0, vatIN = 0.23;
			String nazwaIN = null, kodKreskowyIN = null;

			while (zestawWynikow.next()) {
				kodKreskowyIN = zestawWynikow.getString("kodKreskowy");
				nazwaIN = zestawWynikow.getString("nazwa");
				iloscIN = zestawWynikow.getInt("ilosc");
				iloscM1IN = zestawWynikow.getInt("iloscM1");
				iloscM2IN = zestawWynikow.getInt("iloscM2");
				cenaNettoIN = zestawWynikow.getDouble("cenaNetto");

				listaTowarow1.add(new StanTowarowy(idTowarIN, kodKreskowyIN, nazwaIN, iloscIN, iloscM1IN, iloscM2IN, cenaNettoIN, vatIN,
						sumaBruttoIN));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaTowarow1;
	}

	public int pobierzIlosc(String nazwa) {

		int ilosc = 0;

		String zapytanieTekst = "select ilosc from towar where nazwa =" + nazwa;

		try {
			ResultSet zestawWynikow = stanPolaczenia.executeQuery(zapytanieTekst);

			while (zestawWynikow.next()) {
				ilosc = zestawWynikow.getInt("ilosc");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ilosc;
	}

	public int pobierzIloscM1(String nazwa) {

		int iloscM1 = 0;

		String zapytanieTekst = "select iloscM1 from towar where nazwa =" + nazwa;

		try {
			ResultSet zestawWynikow = stanPolaczenia.executeQuery(zapytanieTekst);

			while (zestawWynikow.next()) {
				iloscM1 = zestawWynikow.getInt("iloscM1");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return iloscM1;
	}
	
	public int pobierzIloscM2(String nazwa) {

		int iloscM2 = 0;

		String zapytanieTekst = "select iloscM2 from towar where nazwa =" + nazwa;

		try {
			ResultSet zestawWynikow = stanPolaczenia.executeQuery(zapytanieTekst);

			while (zestawWynikow.next()) {
				iloscM2 = zestawWynikow.getInt("iloscM2");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return iloscM2;
	}
	
	public double pobierzCeneNetto(int idTowar) {

		double cenaNetto = 0.0;

		String zapytanieTekst = "select cenaNetto from towar where idTowar =" + idTowar;

			try {
				ResultSet zestawWynikow = stanPolaczenia.executeQuery(zapytanieTekst);

				while (zestawWynikow.next()) {
					cenaNetto = zestawWynikow.getDouble("cenaNetto");
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
			return cenaNetto;
		}
	
	public double sumuj(String kodKreskowy) {

		double suma = 0.0;

		String zapytanieTekst = "select cenaNetto, vat from towar where kodKreskowy=" + kodKreskowy;
		
		try {
			ResultSet zestawWynikow = stanPolaczenia.executeQuery(zapytanieTekst);

			double vatIN = 0.0;
			double cenaNettoIN = 0.0;
		

			while (zestawWynikow.next()) {
				vatIN = zestawWynikow.getDouble("vat");
				cenaNettoIN = zestawWynikow.getDouble("cenaNetto");

				suma =  (cenaNettoIN * vatIN) + cenaNettoIN;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return suma;

	}


	public ArrayList<SpisKontrahentow> pobierzKontrahent(String skrotNazwaKo, String pelnaNazwaKo, String nipKo, String adresKo, String telefonKo, String inneKontrahent) {

		ArrayList<SpisKontrahentow> listaKontrahentow = new ArrayList<SpisKontrahentow>();

		String zapytanieTekst = "select * from kontrahent where skrotNazwaKo=" + skrotNazwaKo + ", pelnaNazwaKo='" + pelnaNazwaKo + ", nipKo='"
				+ nipKo + ", adresKo= '" + adresKo + ", telefonKo='" + telefonKo + ", inneKontrahent='" + inneKontrahent;

		try {
			ResultSet zestawWynikow = stanPolaczenia.executeQuery(zapytanieTekst);

			int idKontrahentIN = 0;
			String skrotNazwaKoIN = null, pelnaNazwaKoIN = null, nipKoIN = null, adresKoIN = null, telefonKoIN = null, inneKontrahentIN = null;

			while (zestawWynikow.next()) {

				while (zestawWynikow.next()) {
					idKontrahentIN = zestawWynikow.getInt("idKontrahent");
					skrotNazwaKoIN = zestawWynikow.getString("skrotNazwaKo");
					pelnaNazwaKoIN = zestawWynikow.getString("pelnaNazwaKo");
					nipKoIN = zestawWynikow.getString("nipKo");
					adresKoIN = zestawWynikow.getString("adresKo");
					telefonKoIN = zestawWynikow.getString("telefonKo");
					inneKontrahentIN = zestawWynikow.getString("inneKontrahent");

				listaKontrahentow.add(new SpisKontrahentow(idKontrahentIN, skrotNazwaKoIN, pelnaNazwaKoIN, nipKoIN, adresKoIN, telefonKoIN,
							inneKontrahentIN));
				}

			} 
			
		}catch (SQLException e) {
				e.printStackTrace();
			}
			return listaKontrahentow;
		}
	
	public String pobierzNazweKontrahent(int id) {

		ArrayList<SpisKontrahentow> listaKontrahentow = new ArrayList<SpisKontrahentow>();
		String skrotNazwaKoIN = null;
				
		String zapytanieTekst = "select skrotNazwaKo from kontrahent where idKontrahent=" + id;

		try {
			ResultSet zestawWynikow = stanPolaczenia.executeQuery(zapytanieTekst);

			int idKontrahentIN = 0;
			String pelnaNazwaKoIN = null, nipKoIN = null, adresKoIN = null, telefonKoIN = null, inneKontrahentIN = null;


				while (zestawWynikow.next()) {
					skrotNazwaKoIN = zestawWynikow.getString("skrotNazwaKo");
				}

		}catch (SQLException e) {
				e.printStackTrace();
			}
			return skrotNazwaKoIN;
		}
	
	public String pobierzNazweKlient(int id) {

		ArrayList<SpisKlientow> listaKlientow = new ArrayList<SpisKlientow>();
		String pelnaNazwaIN = null;
				
		String zapytanieTekst = "select pelnaNazwa from klient where idKlient=" + id;

		try {
			ResultSet zestawWynikow = stanPolaczenia.executeQuery(zapytanieTekst);

			int idKlientIN = 0;
			String skrotNazwaIN = null, nipKoIN = null, adresKoIN = null, telefonKoIN = null, inneKontrahentIN = null;


				while (zestawWynikow.next()) {
					pelnaNazwaIN = zestawWynikow.getString("pelnaNazwa");
				}
			
		}catch (SQLException e) {
				e.printStackTrace();
			}
			return pelnaNazwaIN;
		}
	
	public String pobierzNazweTowar(int id) {

		ArrayList<StanTowarowy> listaTowarow1 = new ArrayList<StanTowarowy>();
		String kodKreskowyIN = null;
				
		String zapytanieTekst = "select kodKreskowy from towar where idTowar=" + id;

		try {
			ResultSet zestawWynikow = stanPolaczenia.executeQuery(zapytanieTekst);

			int idTowarIN = 0;			

				while (zestawWynikow.next()) {
					kodKreskowyIN = zestawWynikow.getString("kodKreskowy");
				}
			
		}catch (SQLException e) {
				e.printStackTrace();
			}
			return kodKreskowyIN;
		}
	
	public String pobierzNazweTowar2(int id) {

		ArrayList<StanTowarowy> listaTowarow1 = new ArrayList<StanTowarowy>();
		String kodKreskowyIN = null;
				
		String zapytanieTekst = "select kodKreskowy from towar where idTowar=" + id;

		try {
			ResultSet zestawWynikow = stanPolaczenia.executeQuery(zapytanieTekst);

			int idTowarIN = 0;
		
				while (zestawWynikow.next()) {
					kodKreskowyIN = zestawWynikow.getString("kodKreskowy");

				}	
			
		}catch (SQLException e) {
				e.printStackTrace();
			}
			return kodKreskowyIN;
		}
	
	public ArrayList<StanTowarowy> uaktualnijDane(String kod, String nazwa, int ilosc, int iloscM1, int iloscM2, double cenaNetto) {

		ArrayList<StanTowarowy> listaTowarow1 = new ArrayList<StanTowarowy>();

		String zapytanieTekst = "update towar set ilosc=" + ilosc + ", iloscM1=" + iloscM1 + ", iloscM2"
				+ pobierzProdukt(kod, nazwa, ilosc, iloscM1, iloscM2, cenaNetto).get(ilosc + iloscM1 + iloscM2) + "where kod=" + kod + ", nazwa='"
				+ nazwa + "', cenaNetto=" + cenaNetto;

		try {

			stanPolaczenia.executeUpdate(zapytanieTekst);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listaTowarow1;
	}
	
	
	public void usunDane(int idTowar) {
		String zapytanieTekst = "delete from towar where idTowar=" + idTowar;
		try {

			stanPolaczenia.executeUpdate(zapytanieTekst);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void usunDane2(int idKlient) {
		String zapytanieTekst = "delete from klient where idKlient=" + idKlient;
		try {

			stanPolaczenia.executeUpdate(zapytanieTekst);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void usunDane3(int idKontrahent) {
		String zapytanieTekst = "delete from kontrahent where idKontrahent=" + idKontrahent;
		try {

			stanPolaczenia.executeUpdate(zapytanieTekst);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


public void usunDane4(int nrFaktury) {
	String zapytanieTekst = "delete from fakturaPrzyjecia where nrFaktury=" + nrFaktury;
	try {

		stanPolaczenia.executeUpdate(zapytanieTekst);

	} catch (SQLException e) {
		e.printStackTrace();
	}
}


public void usunDane5(int nrFaktury) {
	String zapytanieTekst = "delete from fakturaWydania where nrFaktury=" + nrFaktury;
	try {

		stanPolaczenia.executeUpdate(zapytanieTekst);

	} catch (SQLException e) {
		e.printStackTrace();
	}
}

}
		