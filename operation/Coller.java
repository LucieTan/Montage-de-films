package operation;
//import film.Films;
import film.Film;

public class Coller implements Film{
	private Film film1;
	private Film film2;
	
	public Coller (Film a, Film b) {
		this.film1 = a;
		this.film2 = b;
	}

	@Override
	public int hauteur() {
		if(film1.hauteur() >= film2.hauteur()) 
			return film1.hauteur();
		else return film2.hauteur();
		
			
	}

	@Override
	public int largeur() {
		if(film1.largeur() >= film2.largeur()) 
			return film1.largeur();
		else return film2.largeur();
	}

	@Override
	public boolean suivante(char[][] écran) {
		if (film1.suivante(écran))
			return true;
		return film2.suivante(écran);		
	}

	@Override
	public void rembobiner() {
		film1.rembobiner();
		film2.rembobiner();
		
		
	}

}
