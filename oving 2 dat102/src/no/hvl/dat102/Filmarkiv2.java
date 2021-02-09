package no.hvl.dat102;

import org.w3c.dom.Node;

import no.hvl.dat102.adt.FilmarkivADT;
import no.hvl.dat102.LinearNode;



public class Filmarkiv2 implements FilmarkivADT {
	// konstant
		final static int STDK = 100;
		// instansvariable
		//private Film[] filmTabell;
		private int antall = 0;
		
		
		private LinearNode<Film> start;
		
		public Filmarkiv2(){
			start = null;
			antall = 0;
			
		}
		
		

		@Override
		public Film[] hentFilmTabell() {
			Film[] film = new Film[antall()];
			
			LinearNode<Film> last = this.head;
			
			for(int i = 0; i<film.length;i++) {
				film[i] = last.data;
				last = last.next;
				
			}
			return film;
		}

		@Override
		public void leggTilFilm(Film nyFilm) {
			
				LinearNode<Film> node = new LinearNode<Film>(nyFilm);
				node.setNeste(start);
				start = node;
				antall++;
			
			
		}

		@Override
		public boolean slettFilm(int filmnr) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public Film[] soekTittel(String delstreng) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Film[] soekProdusent(String delstreng) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public int antall(Sjanger sjanger) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public int antall() {
			// TODO Auto-generated method stub
			return 0;
		}
		

}
