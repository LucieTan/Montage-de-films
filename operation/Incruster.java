package operation;

import film.Film;

public class Incruster implements Film {
	private Film film1, film2;
	private int row, col;
	private char[][] �cran_tmp;

	/*
	 * Constructeur Incruster, initialisation des attributs film1, film2, row et col
	 * 
	 * @param [int] a : est le film qui va incorporer les images � incrust�s
	 * provenant du film b
	 * @param [int] b : est le film qui va �tre incrust� dans le film a
	 * @param [int] li : est la ligne o� l'on souhaite incruster le film b
	 * @param [int] co : est la colonne o� l'on souhaite incruster le film b
	 */
	public Incruster(Film a, Film b, int li, int co) {
		this.film1 = a;
		this.film2 = b;
		this.row = li;
		this.col = co;

	}

	@Override
	public int hauteur() {

		return film1.hauteur();
	}

	@Override
	public int largeur() {
		return film1.largeur();
	}

	@Override
	public boolean suivante(char[][] �cran) {
		�cran_tmp = new char[film2.hauteur()][film2.largeur()];
		if (film1.suivante(�cran)) {
			if (film2.suivante(�cran_tmp)) {
				for (int i = 0; (i < film2.hauteur() && i + this.row < film1.hauteur()); i++) {
					for (int j = 0; (j < film2.largeur() && j + this.col < film1.largeur()); j++) {
							if (j + this.col < 0)
								this.col = 0;
							if (i + this.row < 0)
								this.row = 0;
							�cran[i + this.row][j + this.col] = �cran_tmp[i][j];
					}
				}
				return true;
			}
			return true;
		}
		return false;
	}

	@Override
	public void rembobiner() {
		film1.rembobiner();
		film2.rembobiner();

	}

}
