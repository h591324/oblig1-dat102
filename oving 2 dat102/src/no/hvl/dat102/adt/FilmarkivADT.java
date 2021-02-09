package no.hvl.dat102.adt;
import no.hvl.dat102.Film;
import no.hvl.dat102.Sjanger;


public interface FilmarkivADT {
	
	/**
	 * 
	 * @return tabell av filmer
	 */
	
	Film[] hentFilmTabell();
	
	/**
	 * 
	 * @param nyFilm
	 */
	
	void leggTilFilm(Film nyFilm);
	
	/**
	 * 
	 * @param nyFilm
	 * @return
	 */
	
	boolean slettFilm(int filmnr);
	
	/**
	 * @param delstreng
	 * @return
	 * 
	 */
	Film[] soekTittel(String delstreng);
	
	/**
	 * 
	 * @param delstreng
	 * @return
	 */
	
	Film[] soekProdusent(String delstreng);
	
	/**
	 * 
	 * @param sjanger
	 * @return
	 */
	
	int antall(Sjanger sjanger);
	
	/**
	 * 
	 * @return
	 */
	
	int antall();
}
