package Campionato;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Squadra {
	//nome,punti,reti subite, reti segnate, differenza reti
	
	private String nomeSquadra;
	private int punti;
	private int retiSubite;
	private int retiSegnate;
	private int differenzaReti;
	private Map<String,Giocatore> listaGiocatoriSquadra= new TreeMap<String,Giocatore>();
	private List<Partita> listaPartiteSquadra =new ArrayList<Partita>();
	
	public Squadra() {
		super();
	}

	public Squadra(String nomeSquadra) {
		super();
		this.nomeSquadra = nomeSquadra;
	}

	public String getNomeSquadra() {
		return nomeSquadra;
	}

	public void setNomeSquadra(String nomeSquadra) {
		this.nomeSquadra = nomeSquadra;
	}

	public int getPunti() {
		return punti;
	}

	public void setPunti(int punti) {
		this.punti = punti;
	}

	public int getRetiSubite() {
		return retiSubite;
	}

	public void setRetiSubite(int retiSubite) {
		this.retiSubite = retiSubite;
	}

	public int getRetiSegnate() {
		return retiSegnate;
	}

	public void setRetiSegnate(int retiSegnate) {
		this.retiSegnate = retiSegnate;
	}

	public int getDifferenzaReti() {
		return differenzaReti;
	}

	public void setDifferenzaReti(int differenzaReti) {
		this.differenzaReti = differenzaReti;
	}

	public Map<String, Giocatore> getListaGiocatoriSquadra() {
		return listaGiocatoriSquadra;
	}

	public void setListaGiocatoriSquadra(
			Map<String, Giocatore> listaGiocatoriSquadra) {
		this.listaGiocatoriSquadra = listaGiocatoriSquadra;
	}
	
	public List<Partita> getListaPartiteSquadra() {
		return listaPartiteSquadra;
	}

	public void setListaPartiteSquadra(List<Partita> listaPartiteSquadra) {
		this.listaPartiteSquadra = listaPartiteSquadra;
	}

	//Metodo per aggiungere giocatore a squadra
	public void aggiungiGiocatoreSquadra(Giocatore g)
	{
		listaGiocatoriSquadra.put(g.getCodiceFiscale(), g);
	}
	//Metodo per aggiungere partita a squadra
	public void aggiungiPartitaSquadra(Partita p)
	{
		listaPartiteSquadra.add(p);
	}
	//Metodo per trovare la partita giocata contro un'altra squadra
	public Partita trovaPartita(Squadra s1, Squadra s2)
	{
	Partita pp= new Partita();	
		for(Partita p: listaPartiteSquadra)
		{
			if(p.getSquadraDiCasa().equals(s1)&&p.getSquadraOspite().equals(s2))
			{
				pp=p;
				break;
			}
		}
		return pp;
	}
	
}
