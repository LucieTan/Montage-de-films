package exemple;

import java.io.FileNotFoundException;

import film.Film;
import film.Films;

/**
 * Un exemple basique d'implémentation de l'interface Film.
 */
public class Seul implements Film {
	private int num = 0;
	private static final int NB_IMAGES = 1;

	@Override
	public int hauteur() {
		return 1;
	}

	@Override
	public int largeur() {
		return hauteur(); // ce sera un carré
	}

	@Override
	public boolean suivante(char[][] écran) {
		if (num == NB_IMAGES)
			return false;
		écran[0][0] = 'B'; // un 'a' se balade sur
														// la diagonale
		++num;
		return true;
	}

	@Override
	public void rembobiner() {
		num = 0;
	}

	/**
	 * La projection (puis la sauvegarde) d'un tel film.
	 */
	public static void main(String[] args) {
		Film film = new Seul();
		Films.projeter(film);
		film.rembobiner(); 
		try {
			Films.sauvegarder(film, "test.txt");
		} catch (FileNotFoundException e) {
			System.err.println("Le fichier 'fou.txt' n'a pas pu être créé.");
		}
	}
}
