import Campionato.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

public class MainCampionato {

	public static void main(String[] args) {

		ServizioCampionato sc= new ServizioCampionato();
		Campionato c= new Campionato("Europei");
		
		Giocatore g1=sc.registraGiocatore(c, "Mario", "Rossi", "MRORSS48C843T");
		Giocatore g2=sc.registraGiocatore(c, "Paolo", "Bianchi", "PALBNC55H876G");
		Giocatore g3=sc.registraGiocatore(c, "Nome3", "Cognome3", "LTRDBC83C863H");
		Giocatore g4=sc.registraGiocatore(c, "Nome4", "Cognome4", "BSCTRN85S579P");
		Giocatore g5=sc.registraGiocatore(c, "Nome5", "Cognome5", "JNTFLK84M321N");
		Giocatore g6=sc.registraGiocatore(c, "Nome6", "Cognome6", "LRYMCD82T254S");
		
		Squadra s1=sc.registraSquadra(c, "Italia");
		Squadra s2=sc.registraSquadra(c, "Inghilterra");
		Squadra s3= sc.registraSquadra(c, "Belgio");
		
		sc.assegnaGiocatoriASquadra(c, g1, s1);
		sc.assegnaGiocatoriASquadra(c, g2, s1);
		sc.assegnaGiocatoriASquadra(c, g3, s2);
		sc.assegnaGiocatoriASquadra(c, g4, s2);
		sc.assegnaGiocatoriASquadra(c, g5, s3);
		sc.assegnaGiocatoriASquadra(c, g6, s3);
		
//		for(Map.Entry m : c.getListaGiocatoriCampionato().entrySet())
//		{			
//			System.out.println(m.getKey() + " " + g1.getRuolo() + " " + g2.getRuolo());
//		}
		
		
//		for(Map.Entry m : c.getListaSquadre().entrySet())
//		{			
//			System.out.println(m.getKey());
//		}
		
		GregorianCalendar gc= new GregorianCalendar();
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String str1 = "10/01/2016";
		try {
			gc.setTime(sdf.parse(str1));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		Date data1=gc.getTime();
		
		String str2= "12/01/2016";
		try {
			gc.setTime(sdf.parse(str2));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		Date data2= gc.getTime();
		
		String str3= "14/01/2016";
		try {
			gc.setTime(sdf.parse(str3));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		Date data3=gc.getTime();
		
		String str4= "15/01/2016";
		try {
			gc.setTime(sdf.parse(str4));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		Date data4=gc.getTime();
		
//		//Metodo per giocare la partita
//		Random rdm = new Random();
//		Int j= rdm.nextInt(1);
//		if(j==0)
//		{
//			
//		}
		
		
		//Partita 1
		List<Giocatore> listaReti1 = new ArrayList<Giocatore>();
		listaReti1.add(g1);
		listaReti1.add(g3);
		listaReti1.add(g1);
		listaReti1.add(g2);
		
		List<Giocatore> listaEspulsioni1 = new ArrayList<Giocatore>();

		List<Giocatore> listaAmmonizioni1 = new ArrayList<Giocatore>();
//		listaAmmonizioni1.add(g2);
		
		//Partita 2
		List<Giocatore> listaReti2 = new ArrayList<Giocatore>();
		listaReti1.add(g5);
		listaReti1.add(g3);
		
		List<Giocatore> listaEspulsioni2 = new ArrayList<Giocatore>();

		List<Giocatore> listaAmmonizioni2 = new ArrayList<Giocatore>();
		
		//Partita 3
		List<Giocatore> listaReti3 = new ArrayList<Giocatore>();
		listaReti1.add(g4);
		
		List<Giocatore> listaEspulsioni3 = new ArrayList<Giocatore>();

		List<Giocatore> listaAmmonizioni3 = new ArrayList<Giocatore>();
		listaAmmonizioni1.add(g1);

		//Partita 4
		List<Giocatore> listaReti4 = new ArrayList<Giocatore>();
		listaReti1.add(g2);
		
		List<Giocatore> listaEspulsioni4 = new ArrayList<Giocatore>();
		listaEspulsioni4.add(g3);
		
		List<Giocatore> listaAmmonizioni4 = new ArrayList<Giocatore>();
		
		sc.registraPartita(c, s1, s2, 3, 1, '1', data1, listaReti1, listaEspulsioni1, listaAmmonizioni1);
		sc.registraPartita(c, s2 , s3, 3, 1, '1', data2, listaReti2, listaEspulsioni2, listaAmmonizioni2);		
		sc.registraPartita(c, s2, s1, 1, 0, '1', data3, listaReti3, listaEspulsioni3, listaAmmonizioni3);
		sc.registraPartita(c, s1, s3, 1, 0, '1', data4, listaReti4, listaEspulsioni4, listaAmmonizioni4);
		
		System.out.println(sc.getCapoCannoniere(c).getNome() + " " + sc.getCapoCannoniere(c).getReti());
		System.out.println(sc.getCampione(c).getNomeSquadra() + " " + sc.getCampione(c).getPunti());
//		System.out.println(s2.getNomeSquadra() + " " + s2.getPunti());
	}

}
