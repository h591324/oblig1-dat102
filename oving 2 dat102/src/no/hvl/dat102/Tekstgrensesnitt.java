package no.hvl.dat102;

import java.util.Scanner;
import no.hvl.dat102.adt.FilmarkivADT;

public class Tekstgrensesnitt {
	private static final int VIS_ANTALL = 20;
	private Scanner tastatur = new Scanner(System.in);
	private FilmarkivADT filma;
	
	

	public FilmarkivADT getFilma() {
		return filma;
	}

	public void setFilma(FilmarkivADT filma) {
		this.filma = filma;
	}
	
	public static void visoverskrift() {
		System.out.println();
		System.out.printf("%-10s %-20s %-20s %-20s %-20s %-20s", "Filmnr", "Produsent", "Tittel", "Selskap", "Lanseringsaar", "Sjanger");
	}

	public Tekstgrensesnitt() {

	}

	public void skrivUtFilmDelstrengITittel(FilmarkivADT filma, String delstreng) {
		Film[] filmListe = filma.soekTittel(delstreng);
		for (int i = 0; i < filmListe.length; i++) {
			visFilm(filmListe[i]);
		}
	}

	public void skrivUtProdusent(FilmarkivADT filma, String delstreng) {
		Film[] filmListe = filma.soekProdusent(delstreng);
		for (int i = 0; i < filmListe.length; i++) {
			System.out.println(filmListe[i].getTittel());
		}
	}

	public void skrivUtStatistikk(FilmarkivADT filma) {
		System.out.println("Antall filmer totalt: " + filma.antall());
		//Her må du få tak i de forskjellige sjangerne og kalle metoden under like mange ganger som antall sjangre:

		String sjangernavn = "";
		for (int i = 0; i < 4; i++) {
			if (i == 0) {
				sjangernavn = "Action";
			}
			else if (i == 1) {
				sjangernavn = "Komedie";
			}
			else if (i == 2) {
				sjangernavn = "Dokumentar";
			}
			else {
				sjangernavn = "Drama";
			}

			Sjanger sj = Sjanger.finnSjanger(sjangernavn);
			int antall = filma.antall(sj);
			System.out.println("Antall" + sj.toString() + ":" + antall);


		}

		
	}

	public Film lesFilm() {
		Scanner tastatur = new Scanner(System.in);
		System.out.println("Film nr: ");
		int filmnr = tastatur.nextInt();
		tastatur.nextLine();
		System.out.println("Produsent: ");
		String produsent = tastatur.nextLine();
		System.out.println("Tittel: ");
		String tittel = tastatur.nextLine();
		System.out.println("Filmselskap: ");
		String filmselskap = tastatur.nextLine();
		System.out.println("Lanseringsaar: ");
		int aar = tastatur.nextInt();
		tastatur.nextLine();
		System.out.println("Sjanger: (Action, Komedie, Dokumentar, Drama)");
		String sjStr = tastatur.nextLine();
		Sjanger sj = Sjanger.finnSjanger(sjStr);
		
		return (new Film(filmnr, produsent, tittel, aar, sj, filmselskap));

	}

	public void visFilm(Film film) {
		System.out.println("Filmnr: " + film.getFilmnr());
		System.out.println("Produsent: " + film.getProdusent());
		System.out.println("Tittel: " + film.getTittel());
		System.out.println("Lanseringsaar: " + film.getAar());
		System.out.println("Filmselskap: " + film.getSelskap());
		System.out.println("Sjanger: " + film.getSjanger().toString());
		
	}
	
	public void printOptions() {
		System.out.println("Legg til film(1)");
		System.out.println("Slett film(2)");
		System.out.println("Skriv ut Film(3)");
		System.out.println("Skriv ut produsent(4)");
		System.out.println("Skriv ut statestikk(5)");
		System.out.println("Avslutt(0)");
		
	}
	
	

}
