package exemple;

import java.io.FileNotFoundException;

import film.Film;
import film.Films;

import operation.*;

public class Test {

	public static void main(String[] args) {

		// Déclaration des films
		Film film = new LaDiagonaleDuFou();
		Film film1 = new SalutToi();
		Film film2 = new AuRevoirToi();
		//
		// Film col= new Coller(film, film2);
		// Film extrait= new Extraire(film, 1, 3);
		// Film rep = new Repeter(film2, 0);
		Film cadrer = new Encadrer(film1);
		Film cadrerV2 = new Encadrer(cadrer);
		Film incrust = new Incruster(film1, film2, 3, -1);
		//Film test = new Coller(film1, new Coller(film,film2));
		Film potdecolle = new Coller(film,film);
		Films.projeter(potdecolle);
		potdecolle.rembobiner();
		//Films.projeter(incrust);
		//incrust.rembobiner();
		//Films.projeter(cadrerV2);
		//cadrerV2.rembobiner();
		//Films.projeter(cadrer);
		//cadrer.rembobiner();
		// Films.projeter(rep);
		// rep.rembobiner();
		// Films.projeter(col);
		// col.rembobiner();
		//test.rembobiner();
		//Films.projeter(test);
		/*
		 * Films.projeter(extrait); extrait.rembobiner();
		 */
		try {
			Films.sauvegarder(incrust, "ghkg.txt");
		} catch (FileNotFoundException e) {
			System.err.println("Le fichier 'fou.txt' n'a pas pu être créé.");
		}

	}
}
