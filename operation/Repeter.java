package operation;


import film.*;

public class Repeter implements Film {
	private Film film;
	private int num = 1; // compteur qui nous indique le nombre de répétition effectué
	private int rep;

	/* Constructeur Repeter, il initialise les attributs film et rep
	 * @param [in] f :  film avec lequel on souhaite faire un nombre x de répétition
	 * @parm [in] nbrep : le nbre de répétition
	 */
	public Repeter(Film f, int nbrep) {
		this.film = f;
		this.rep = nbrep;

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
	public boolean suivante(char[][] écran) {

		if (film.suivante(écran) && num <= this.rep) { // ici film.suivante(écran) 
													//==> return true ou false permet aussi de passer chaque frame
			return true;
		} else if (num < this.rep) {
			film.rembobiner();
			num++;
			return film.suivante(écran);
		}

		return false; // On sort de la méthode suivante

	}

	@Override
	public void rembobiner() {
		film.rembobiner();
		num = 1;

	}
}

 
