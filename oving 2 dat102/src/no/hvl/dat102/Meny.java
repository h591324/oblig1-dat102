package no.hvl.dat102;

import java.util.Scanner;
import no.hvl.dat102.adt.FilmarkivADT;


public class Meny {
    private Tekstgrensesnitt tekstgr;
    private FilmarkivADT filma;

public Meny() {
    tekstgr = new Tekstgrensesnitt();
    this.filma = filma;
    }

public void start() {
    Scanner tastatur = new Scanner(System.in);
    System.out.println("Vil du laste inn lagret arkiv(0) eller opprette nytt arkiv(1)");
    int input = tastatur.nextInt();

    if (input == 0) {
        System.out.println("Skriv inn navnet på arkivet du vil åpne: ");
        filma = Fil.lesFraFil(tastatur.nextLine());
        input = 1;
    }

    else if (input == 1) {
        filma = new Filmarkiv();
    }

    tekstgr.printOptions();
    while (input != 0) {
        input = tastatur.nextInt();
        tastatur.nextLine();

        switch (input) {
        case 1:
            filma.leggTilFilm(tekstgr.lesFilm());
            break;
        case 2:
            System.out.println("Skriv inn filnummeret du vil fjerne");
            int nummer = tastatur.nextInt();
            filma.slettFilm(nummer);
            break;
        case 3:
            System.out.println("Skriv inn delstrengen på en tittel du vil søke etter");
            String delstreng = tastatur.nextLine();
            tekstgr.skrivUtFilmDelstrengITittel(filma, delstreng);
            break;
        case 4:
            System.out.println("Skriv inn produsenten du vil søke etter");
            tekstgr.skrivUtProdusent(filma, tastatur.nextLine());
            break;
        case 5:
            System.out.println("Skriv ut statestikk");
            tekstgr.skrivUtStatistikk(filma);
        case 0:
        	
            break;
        }
        tekstgr.printOptions();
        
    }
    }

}
