package Campionato;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class ServizioCampionato {
/*
 * 1. public Giocatore registraGiocatore(Campionato c, String nome, String cognome, String codiceFiscale)
 * 2. public Squadra registraSquadra(Campionato c, String nome)
 * 3. public boolean assegnaGiocatoreASquadra(Campionato c, Giocatore G, Squadra s)
 * 4. public boolean registraPartita(Campionato c, Squadra casa, Squadra ospite, reti casa, reti ospite, risultato, Date data, Lista Giocatori reti fatte, Lista Giocatori espulsi, Lista Giocatori ammoniti) 
 * 5. public Giocatore capoCannoniere(Campionato c)
 * 6. public Squadra getCampione(Campionato c){punti, differenza reti, scontri diretti(chi ha vinto quando hanno giocato assieme) 
 */
	public Giocatore registraGiocatore(Campionato c, String nome, String cognome, String codiceFiscale)
	{
	Giocatore g = new Giocatore(nome, cognome, codiceFiscale);
	
		if(!c.getListaGiocatoriCampionato().containsKey(codiceFiscale) && !nome.isEmpty() && nome !=null && !cognome.isEmpty() && cognome !=null)
			{
				c.aggiungiGiocatoreCamnpionato(g);
				Random rnd= new Random();
				int i= rnd.nextInt(22)+18;
				g.setEtà(i);
				Random rnd2 = new Random();
				int j=rnd2.nextInt(3);
				switch(j)
						{
							case(0) : g.setRuolo("Portiere");
							break;
							case(1) : g.setRuolo("Difensore");
							break;
							case(2) : g.setRuolo("Centrocampista");
							break;
							case(3) : g.setRuolo("Attacante");
							break;
						}
		
	}
		else
			{
				g=null;
			}
	return g;
	}
	
	public Squadra registraSquadra(Campionato c, String nome)
	{
		Squadra s= new Squadra(nome);
		if(!c.getListaSquadre().containsKey(nome) && !nome.isEmpty() && nome !=null)
		{
			c.aggiungiSquadre(s);
		}
		else
		{
			s=null;
		}
		
		return s;
	}
	
	public boolean assegnaGiocatoriASquadra(Campionato c, Giocatore g, Squadra s)
	{
		boolean result=false;
		
		if(c.getListaGiocatoriCampionato().containsKey(g.getCodiceFiscale()) && c.getListaSquadre().containsKey(s.getNomeSquadra()))
		{
		s.aggiungiGiocatoreSquadra(g);
		result=true;
		}
		
		return result;
	}
	
	public Partita registraPartita(Campionato c,Squadra squadraCasa, Squadra squadraOspite, int retiSquadraCasa, int retiSquadraOspite, char risultato, Date data, List<Giocatore> listaReti, List<Giocatore> listaEspulsioni, List<Giocatore> listaAmmonizioni)
	{
		Partita p=new Partita(squadraCasa, squadraOspite);
		String key= p.creaKey(p);
		p.setKey(key);
		
		//Scorro la lista e controllo che tutti i giocatori iscritti alla partita siano anche iscritti al campionato
		for(Map.Entry m : squadraCasa.getListaGiocatoriSquadra().entrySet())
		{
			if(!c.getListaGiocatoriCampionato().containsKey(m.getKey()))
					{
						p=null;
						break;					
					}
		}
		
		for(Map.Entry m : squadraOspite.getListaGiocatoriSquadra().entrySet())
		{
			if(!c.getListaGiocatoriCampionato().containsKey(m.getKey()))
					{
						p=null;
						break;					
					}
		}
		
		//Verifico che la partita non sia già registrata
		if(!c.getListaPartiteCampionato().containsKey(p.getKey()) && p!=null)
		{
			c.aggiungiPartita(p);
			squadraCasa.aggiungiPartitaSquadra(p);
			squadraOspite.aggiungiPartitaSquadra(p);
			p.setRisultato(risultato);
			
		//Aggiorno il totale di reti segnate dalle squadre
		squadraCasa.setRetiSegnate(squadraCasa.getRetiSegnate()+retiSquadraCasa);
		squadraOspite.setRetiSegnate(squadraOspite.getRetiSegnate()+retiSquadraOspite);
		
		//Aggiorno il totale di reti subite
		squadraCasa.setRetiSubite(squadraCasa.getRetiSubite()+ retiSquadraOspite);
		squadraOspite.setRetiSubite(squadraOspite.getRetiSubite() + retiSquadraCasa);
		
		//Aggiorno la differenza reti
		squadraCasa.setDifferenzaReti(squadraCasa.getRetiSegnate()-squadraCasa.getRetiSubite());
		squadraOspite.setDifferenzaReti(squadraOspite.getRetiSegnate()-squadraOspite.getRetiSubite());
		
		//Aggiorno i punti perdo 0 pareggio 1 vinco 3
		if(risultato=='x')
		{
			squadraCasa.setPunti(squadraCasa.getPunti()+1);
			squadraOspite.setPunti(squadraOspite.getPunti()+1);
		}
		else if(risultato=='1')
		{
			squadraCasa.setPunti(squadraCasa.getPunti()+3);
		}
		else if(risultato=='2')
		{
			squadraOspite.setPunti(squadraOspite.getPunti()+3);
		}
		
		//Sono sicura che il giocatore sia iscritto al campionato e aggiorno le reti, le espulsioni e le ammonizioni
		
		if(listaReti!=null)
		{
		for(Giocatore g: listaReti)
		{
			g.setReti(g.getReti()+1);
			if(!c.getMiglioriGiocatori().contains(g))
			{
				c.aggiungiMiglioreGiocatore(g);
			}
		}
		}
		
		if(listaEspulsioni!=null)
		{
		for(Giocatore g: listaEspulsioni)
		{
			g.setEspulsioni(g.getEspulsioni()+1);
		}
		}
		
		if(listaAmmonizioni!=null)
		{
		for(Giocatore g : listaAmmonizioni)
		{
			g.setAmmonizioni(g.getAmmonizioni()+1);
		}
		}
		
		}
		
		return p;
	
	}
	
	
	public Giocatore getCapoCannoniere(Campionato c)
	{
		Collections.sort(c.getMiglioriGiocatori(),new GiocatoreComparator());
		
		Giocatore g= c.getMiglioriGiocatori().get(0);
		
		return g;
	}
	
	public Squadra getCampione(Campionato c)
	{
		List<Squadra> listaSquadreDaMappa = new ArrayList(c.getListaSquadre().values());
		
		Collections.sort(listaSquadreDaMappa,new SquadraComparator());
		
		Squadra s= listaSquadreDaMappa.get(0);
		return s;
	}
	
	//Metodo per creare il calendario
		public List<String> creaCalendario(Campionato c)
		{
			List<Squadra> squadre = new ArrayList<Squadra>(c.getListaSquadre().values());
			List<String> Temp = new ArrayList<String>();
			List<String> Calendario = new ArrayList<String>();
			
			//riempie una lista con tutte le coppie squadra casa vs squadra ospite
			for(Squadra s : squadre)
			{
				String str1 = new String(s.getNomeSquadra());

				for(Squadra t : squadre)
				{
						String str2 = new String(t.getNomeSquadra());
						if(!s.getNomeSquadra().equals(t.getNomeSquadra()))
						{
						String str = new String(str1 + " vs." + str2);
						Temp.add(str);
						}
				}
			}
			
			int numeroSquadre=c.getListaSquadre().size();
	
			int end=(int) Temp.size()/numeroSquadre;
			int i=0;

			while(Calendario.size()<end)
			{
				String s= "";

				for(int j=i; j<Temp.size(); j++)
				{
					s=s+Temp.get(j)+ "\n";
					j=j+numeroSquadre*2-1;
				}
				i++;
				Calendario.add(s);
				
			}
			return Calendario;
		}

}
