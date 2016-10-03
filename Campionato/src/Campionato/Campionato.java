package Campionato;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Campionato {
	
	private String nomeCampionato;
	private Map<String, Squadra> listaSquadre = new TreeMap<String,Squadra>();
	private Map<String,Giocatore> listaGiocatoriCampionato = new TreeMap<String,Giocatore>();
	private Map<String,Partita> listaPartiteCampionato = new TreeMap<String,Partita>();
	private List<Giocatore> miglioriGiocatori = new ArrayList<Giocatore>();
	
	//Costruttori
	public Campionato() {
	}

	public Campionato(String nomeCampionato) {
		super();
		this.nomeCampionato = nomeCampionato;
	}

	//Getters e Setters
	public String getNomeCampionato() {
		return nomeCampionato;
	}

	public void setNomeCampionato(String nomeCampionato) {
		this.nomeCampionato = nomeCampionato;
	}

	public Map<String, Squadra> getListaSquadre() {
		return listaSquadre;
	}

	public void setListaSquadre(Map<String, Squadra> listaSquadre) {
		this.listaSquadre = listaSquadre;
	}

	public Map<String, Giocatore> getListaGiocatoriCampionato() {
		return listaGiocatoriCampionato;
	}

	public void setListaGiocatoriCampionato(
			Map<String, Giocatore> listaGiocatoriCampionato) {
		this.listaGiocatoriCampionato = listaGiocatoriCampionato;
	}
	
	public Map<String, Partita> getListaPartiteCampionato() {
		return listaPartiteCampionato;
	}

	public void setListaPartiteCampionato(Map<String, Partita> listaPartiteCampionato) {
		this.listaPartiteCampionato = listaPartiteCampionato;
	}
	
	public List<Giocatore> getMiglioriGiocatori() {
		return miglioriGiocatori;
	}

	public void setMiglioriGiocatori(List<Giocatore> miglioriGiocatori) {
		this.miglioriGiocatori = miglioriGiocatori;
	}

	//Metodo per aggiungere Giocatore a campionato
	public void aggiungiGiocatoreCamnpionato(Giocatore g)
	{
		listaGiocatoriCampionato.put(g.getCodiceFiscale(), g);
	}
	
	//Metodo per aggiungere Squadra a campionato
	public void aggiungiSquadre(Squadra s)
	{
		listaSquadre.put(s.getNomeSquadra(),s);
	}

	//Metodo per aggiungere Partita a campionato
	public void aggiungiPartita(Partita p)
	{
		listaPartiteCampionato.put(p.getKey(), p);
	}
	
	//Metodo per aggiungere giocatore alla lista migliori giocatori
public void aggiungiMiglioreGiocatore(Giocatore g)
{
	miglioriGiocatori.add(g);
}

}