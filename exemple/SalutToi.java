package exemple;

import java.io.FileNotFoundException;

import film.Film;
import film.Films;

/**
 * Un exemple basique d'implémentation de l'interface Film.
 */
public class SalutToi implements Film {
	private int num = 0;
	private static final int NB_IMAGES = 3;


	@Override
	public int hauteur() {
		return 10;
	}

	@Override
	public int largeur() {
		return hauteur(); // ce sera un carré
	}

	@Override
	public boolean suivante(char[][] écran) {
		if (num == NB_IMAGES)
			return false;
		for (int i = 0; i<this.hauteur(); i++) {
			for (int j =0; j<this.largeur(); j++) {
				écran[i][j] = 'a'; // l'écran est rempli de "a"
			}
		}

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
		Film film = new SalutToi();
		Films.projeter(film);
		film.rembobiner();
		try {
			Films.sauvegarder(film, "test.txt");
		} catch (FileNotFoundException e) {
			System.err.println("Le fichier 'fou.txt' n'a pas pu être créé.");
		}
	}
}
