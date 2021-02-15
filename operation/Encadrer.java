package operation;

import java.util.Arrays;

import film.Film;
import film.Films;

public class Encadrer implements Film {
	private Film film;
	private final int bord;
	private char[][] écran_tmp;
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
	public boolean suivante(char[][] écran) {
		écran_tmp = new char[film.hauteur()][film.largeur()];
		if (film.suivante(écran_tmp)) {
			Arrays.fill(écran[0], cadre);
			Arrays.fill(écran[this.hauteur()-this.bord], cadre);
			for (int i = bord; i < this.hauteur() - this.bord; i++) {
				écran[i][0] = cadre;
				écran[i][film.largeur() + this.bord] = cadre;		
			}
			for(int c= 0; c<film.hauteur();c++) {
				for (int d =0; d<film.largeur(); d++) {
					écran[c+this.bord][d+this.bord]= écran_tmp [c][d];			
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
