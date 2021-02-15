package operation;

import java.util.Arrays;

import film.Film;
import film.Films;

public class Encadrer implements Film {
	private Film film;
	private final int bord;
	private char[][] �cran_tmp;
	private final char cadre = '*'; 

	public Encadrer(Film f) {
		this.film = f;
		this.bord = 1;
		
	}

	@Override
	public int hauteur() {

		return film.hauteur() + this.bord + this.bord;
	}

	@Override
	public int largeur() {

		return film.largeur() + this.bord + this.bord;
	}

	@Override
	public boolean suivante(char[][] �cran) {
		�cran_tmp = new char[film.hauteur()][film.largeur()];
		if (film.suivante(�cran_tmp)) {
			Arrays.fill(�cran[0], cadre);
			Arrays.fill(�cran[this.hauteur()-this.bord], cadre);
			for (int i = bord; i < this.hauteur() - this.bord; i++) {
				�cran[i][0] = cadre;
				�cran[i][film.largeur() + this.bord] = cadre;		
			}
			for(int c= 0; c<film.hauteur();c++) {
				for (int d =0; d<film.largeur(); d++) {
					�cran[c+this.bord][d+this.bord]= �cran_tmp [c][d];			
				}
			}
			
				

			return true;
		}

		return false;

	}

	@Override
	public void rembobiner() {
		film.rembobiner();

	}

}
