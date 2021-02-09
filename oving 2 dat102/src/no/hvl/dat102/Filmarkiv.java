package no.hvl.dat102;

import java.util.Arrays;

import no.hvl.dat102.Film;
import no.hvl.dat102.adt.FilmarkivADT;

/**
 * 
 * @author Sander Braastad
 *
 */



public class Filmarkiv implements FilmarkivADT {
	// konstant
	final static int STDK = 100;
	// instansvariable
	private Film[] filmTabell;
	private int antall = 0;

	public Filmarkiv() {
		this(STDK);
	}

	public Filmarkiv(int stor) {
		filmTabell = new Film[stor];
		antall = 0;
	}

	// Returnere en tabell av Filmer
	public Film[] hentFilmTabell() {
		return filmTabell;
	}

	// Legger til en ny Film
	public void leggTilFilm(Film nyFilm) {
		for (int i = 0; i < filmTabell.length; i++) {
			if (filmTabell[i] == null) {
				filmTabell[i] = nyFilm;
				antall++;
				break;
			}
		}
	}

	// Sletter en Film hvis den fins
	public boolean slettFilm(int filmnr) {
		for (int i = 0; i < filmTabell.length; i++) {
			if (filmTabell[i].getFilmnr() == filmnr) {
				filmTabell[i] = null;
				antall--;
				return true;
			}
		}
		return false;
	}

	// Søker og henter Filmer med en gitt delstreng
	public Film[] soekTittel(String delstreng) {
		Film[] filmListe = new Film[100];
		int teller = 0;
		for (int i = 0; i < filmTabell.length; i++) {
			if (filmTabell[i] != null) {
				String tittel = filmTabell[i].getTittel();
				if (tittel.contains(delstreng)) {
					filmListe[teller] = filmTabell[i];
					teller++;
				}
			}
		}
		Film[] kopi = Arrays.copyOf(filmListe, teller);
		return kopi;
	}

	// Søker og henter produsenter med en gitt delstreng
	public Film[] soekProdusent(String delstreng) {
		Film[] filmListe = new Film[100];
		int teller = 0;
		for (int i = 0; i < filmTabell.length; i++) {
			if (filmTabell[i] != null) {
				String produsent = filmTabell[i].getProdusent();
				if (produsent.equals(delstreng)) {
					filmListe[teller] = filmTabell[i];
					teller++;
				}
			}
			
		}
		Film[] kopi = Arrays.copyOf(filmListe, teller);

		return kopi;
	}

	// Henter antall Filmer for en gitt sjanger
	public int antall(Sjanger sjanger) {
		int teller = 0;
		for (int i = 0; i < filmTabell.length; i++) {
			if (filmTabell[i] != null) {
				if (filmTabell[i].getSjanger() == sjanger) {
					teller++;
				}
			}
		}
		return teller;
	}

	// Returnerer antall Filmer
	public int antall() {
		return antall;
	}
	
	public void leggTil(Film element) {
        if (antall == filmTabell.length) {
            utvidKapasitet();
        }
        filmTabell[antall] = element;
        antall++;
    }

    private void utvidKapasitet() {// eks. utvide 10%
        Film[] hjelpetabell = new Film[(int) Math.ceil(1.1 * filmTabell.length)];
        for (int i = 0; i < filmTabell.length; i++) {
            hjelpetabell[i] = filmTabell[i];
        }
        filmTabell = hjelpetabell;
    }

}
