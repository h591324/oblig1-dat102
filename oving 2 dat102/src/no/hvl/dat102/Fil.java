package no.hvl.dat102;

import no.hvl.dat102.adt.*;
import java.io.*;
import java.util.Scanner;


public class Fil {
	private static final String SKILLE = "#";
	// parameter filnavn
	final String filnavn = "filmer.txt";
	// return referansen til filmarkivet
	// throws java.io.IOExeption

	public static Filmarkiv lesFraFil(String filnavn) {
		Filmarkiv filmarkiv = null;

		try {
			// // 1 - FileReader
			FileReader ansFil = new FileReader(filnavn);
			BufferedReader innfil = new BufferedReader(ansFil);
			//Scanner leseTest = new Scanner(ansFil);

			// 3 - leser den første posten som er antall info-poster
			String linje = innfil.readLine();
			//String linje = leseTest.nextLine();
			int n = Integer.parseInt(linje);
			filmarkiv = new Filmarkiv(n);

			// 4 - les postene, en hel post om gangen
			for (int i = 0; i < n; i++) {
				String post = innfil.readLine();
				String[] felt = post.split(SKILLE);
				int filmnr = Integer.parseInt(felt[0]);
				String produsent = felt[1];
				String tittel = felt[2];
				int aar = Integer.parseInt(felt[3]);
				String sjStr = felt[4];
				Sjanger sj = Sjanger.finnSjanger(sjStr);
				String selskap = felt[5];

				Film film = new Film(filmnr, produsent, tittel, aar, sj, selskap);

				filmarkiv.leggTilFilm(film);
			}

			// 4 - lukk filen
			innfil.close();
		} catch (FileNotFoundException unntak) {
			System.out.println("Finner ikke filen " + filnavn);
			unntak.printStackTrace();

		} catch (IOException e) {
			System.out.println("Feil ved lesing av fil: " + e);

		}

		return filmarkiv;

	} // metode

	public static void skrivTilFil(FilmarkivADT filma, String filnavn) {
		try {
			FileWriter ansFil = new FileWriter(filnavn, false);
			PrintWriter utfil = new PrintWriter(ansFil);
			int antall = filma.antall();
			// skriver først ut antall ansatt-info-er på første linje
			utfil.println(antall);
			Film[] tabell = filma.hentFilmTabell();
			for (int i = 0; i < antall; i++) {
				// skriver post felt for felt
				utfil.print(tabell[i].getFilmnr());
				utfil.print(SKILLE);
				utfil.print(tabell[i].getProdusent());
				utfil.print(SKILLE);
				utfil.print(tabell[i].getTittel());
				utfil.print(SKILLE);
				utfil.print(tabell[i].getAar());
				utfil.print(SKILLE);
				utfil.print(tabell[i].getSjanger());
				utfil.print(SKILLE);
				utfil.print(tabell[i].getSelskap());
			}

			utfil.close();
		} catch (IOException e) {
			System.out.println("Feil på skriving til fil: " + e);
		}
	}
}
