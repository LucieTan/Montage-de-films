package operation;

import film.Film;
import film.Films;

public class Extraire implements Film {
	private int premier;
	private int dernier;
	private Film film;
	private int img;

	/*
	 * Constructeur Extraire, il initialise ses attributs � l'aide des param entr�es
	 * 
	 * @param [in] f : film dont on souhaite extraire des images
	 * 
	 * @param [in] p : premi�re image qu'on souhaite extraire
	 * 
	 * @param [in] d : derni�re image qu'on souhaite extraire du film (d>p)
	 */

	public Extraire(Film f, int p, int d) {
		this.premier = p;
		this.dernier = d;
		this.film = f; // adresse du film
		this.img = 0;
	}

	@Override
	public int hauteur() {

		return film.hauteur();
	}

	@Override
	public int largeur() {

		return film.largeur();
	}

	@Override
	public boolean suivante(char[][] �cran) {

		while (img < this.premier) { // affiche dans le vide tant qu'il trouve pas la premiere frame
			film.suivante(�cran);
			Films.effacer(�cran);
			img++;
		}

		while (img <= this.dernier) {
			img++;
			return film.suivante(�cran);
		}
		return false; // passe ttes les frames
	}



	@Override
	public void rembobiner() {
		film.rembobiner();
		img = 0;

	}

}
