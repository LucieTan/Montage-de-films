package testsoperation;

import static org.junit.Assert.*;

import org.junit.Test;

import exemple.AuRevoirToi;
import exemple.Fusion;
import exemple.LaDiagonaleDuFou;
import exemple.Seul;
import exercices.Exercice;
import film.Film;
import film.Films;
import operation.*;

public class testsmontages {
	Film s = new Seul();
	Film i = new Fusion();
	Film f = new LaDiagonaleDuFou();
	Film b = new AuRevoirToi();
	
	private static String cadre1=
			"***" + System.lineSeparator() +
			"*B*" + System.lineSeparator() +
			"***" + System.lineSeparator() ;

	private static String fou1=
			"          " + System.lineSeparator() +
			" a        " + System.lineSeparator() +
			"          " + System.lineSeparator() +
			"          " + System.lineSeparator() +
			"          " + System.lineSeparator() +
			"          " + System.lineSeparator() +
			"          " + System.lineSeparator() +
			"          " + System.lineSeparator() +
			"          " + System.lineSeparator() +
			"          " + System.lineSeparator()
	;
	
	private static String fou2=
			"          " + System.lineSeparator() +
			"          " + System.lineSeparator() +
			"  a       " + System.lineSeparator() +
			"          " + System.lineSeparator() +
			"          " + System.lineSeparator() +
			"          " + System.lineSeparator() +
			"          " + System.lineSeparator() +
			"          " + System.lineSeparator() +
			"          " + System.lineSeparator() +
			"          " + System.lineSeparator()
	;
	
	private static String fou3=
			"          " + System.lineSeparator() +
			"          " + System.lineSeparator() +
			"          " + System.lineSeparator() +
			"   a      " + System.lineSeparator() +
			"          " + System.lineSeparator() +
			"          " + System.lineSeparator() +
			"          " + System.lineSeparator() +
			"          " + System.lineSeparator() +
			"          " + System.lineSeparator() +
			"          " + System.lineSeparator()
	;

	public static String incrust1 = 
			"aaaa" + System.lineSeparator() +
			"aaBa" + System.lineSeparator() +
			"aaaa" + System.lineSeparator() +
			"aaaa" + System.lineSeparator() ;
	
	public static String col1 =
			"aaaa" + System.lineSeparator() +
			"aaaa" + System.lineSeparator() +
			"aaaa" + System.lineSeparator() +
			"aaaa" + System.lineSeparator() ;
	public static String col2 =
			"hhh " + System.lineSeparator() +
			"hhh " + System.lineSeparator() +
			"hhh " + System.lineSeparator() +
			"hhh " + System.lineSeparator() ;
	
	public static String compo =
			"******" + System.lineSeparator() +
			"*aaaa*" + System.lineSeparator() +
			"*aaBa*" + System.lineSeparator() +
			"*aaaa*" + System.lineSeparator() +
			"*aaaa*" + System.lineSeparator() +
			"******" + System.lineSeparator() ;
	@Test
	public void test() {
		
	}
	
	@Test
	public void TestColler() {
		Film colle = new Coller(i,b);
		assertEquals(4,colle.hauteur());
		assertEquals(4,colle.largeur());
		char[][] �cran = Films.getEcran(colle);
		assertTrue(colle.suivante(�cran));
		char[][] �cran1 = Films.getEcran(colle);
		assertTrue(colle.suivante(�cran1));
		System.out.println(Films.toString(�cran)+""+Films.toString(�cran1));
		System.out.println(col1 + col2);
		assertEquals(col1, Films.toString(�cran));
		colle.rembobiner();
		assertTrue(colle.suivante(�cran));
		assertEquals(col1+col2, Films.toString(�cran) +""+Films.toString(�cran1));
	}
	
	@Test
	public void TestRepeter() {
		Film rep = new Repeter(i,3);
		assertEquals(4,rep.hauteur());
		assertEquals(4,rep.largeur());
		char[][] �cran = Films.getEcran(rep);
		assertTrue(rep.suivante(�cran));
		char[][] �cran1 = Films.getEcran(rep);
		assertTrue(rep.suivante(�cran1));
		char[][] �cran2 = Films.getEcran(rep);
		assertTrue(rep.suivante(�cran2));
		System.out.println(Films.toString(�cran)+""+Films.toString(�cran1));
		System.out.println(col1 + col1 +col1);
		assertEquals(col1, Films.toString(�cran));
		rep.rembobiner();
		assertTrue(rep.suivante(�cran));
		assertEquals(col1+col1+col1, Films.toString(�cran) +""+Films.toString(�cran1)+Films.toString(�cran2));
	}
	
	@Test
	public void TestExtraire() {
		Film ext = new Extraire (f,1,3);
		assertEquals(10,ext.hauteur());
		assertEquals(10,ext.largeur());
		char[][] �cran = Films.getEcran(ext);
		assertTrue(ext.suivante(�cran));
		char[][] �cran1 = Films.getEcran(ext);
		assertTrue(ext.suivante(�cran1));
		System.out.println(Films.toString(�cran)+""+Films.toString(�cran1));
		System.out.println(fou1 + fou2);
		assertEquals(fou1, Films.toString(�cran));
		ext.rembobiner();
		assertTrue(ext.suivante(�cran));
		assertEquals(fou1+fou2, Films.toString(�cran) +""+Films.toString(�cran1));
	}
	
	@Test
	public void TestEncadrer() {
		Film seul = new Encadrer(s);
		assertEquals(3,seul.hauteur());
		assertEquals(3,seul.largeur());
		char[][] �cran = Films.getEcran(seul);
		assertTrue(seul.suivante(�cran));
		System.out.println(Films.toString(�cran));
		System.out.println(cadre1);
		assertEquals(cadre1, Films.toString(�cran));
		seul.rembobiner();
		assertTrue(seul.suivante(�cran));
		assertEquals(cadre1, Films.toString(�cran));	
	}
	
	@Test
	public void TestIncruster() {
		Film incrust= new Incruster(i,s, 1,2);
		assertEquals(4,incrust.hauteur());
		assertEquals(4,incrust.largeur());
		char[][] �cran = Films.getEcran(incrust);
		assertTrue(incrust.suivante(�cran));
		System.out.println(Films.toString(�cran));
		System.out.println(incrust1);
		assertEquals(incrust1, Films.toString(�cran));
		incrust.rembobiner();
		assertTrue(incrust.suivante(�cran));
		assertEquals(incrust1, Films.toString(�cran));
	}
	
	@Test
	public void TestCompo() {
		Film compote= new Encadrer(new Incruster(i,s, 1,2));
		assertEquals(6,compote.hauteur());
		assertEquals(6,compote.largeur());
		char[][] �cran = Films.getEcran(compote);
		assertTrue(compote.suivante(�cran));
		System.out.println(Films.toString(�cran));
		System.out.println(compo);
		assertEquals(compo, Films.toString(�cran));
		compote.rembobiner();
		assertTrue(compote.suivante(�cran));
		assertEquals(compo, Films.toString(�cran));
	}
	

}
