package Campionato;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Partita {
	//orario,squadra casa, squadra ospite, reti casa, reti ospite, char risultato(1 vince casa,x pareggio, 2 vince trasferta)
	
	private Date data;
	private Squadra squadraOspite;
	private Squadra squadraDiCasa;
	private int retiSquadraDiCasa;
	private int retiSquadraOspite;
	private char risultato;
	private String key;
	
	//Costruttori
	public Partita() {
	}
	
	public Partita(Squadra squadraOspite, Squadra squadraDiCasa) {
		super();
		this.data = data;
		this.squadraOspite = squadraOspite;
		this.squadraDiCasa = squadraDiCasa;
	}

	//Getters e setter
	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Squadra getSquadraOspite() {
		return squadraOspite;
	}

	public void setSquadraOspite(Squadra squadraOspite) {
		this.squadraOspite = squadraOspite;
	}

	public Squadra getSquadraDiCasa() {
		return squadraDiCasa;
	}

	public void setSquadraDiCasa(Squadra squadraDiCasa) {
		this.squadraDiCasa = squadraDiCasa;
	}

	public int getRetiSquadraDiCasa() {
		return retiSquadraDiCasa;
	}

	public void setRetiSquadraDiCasa(int retiSquadraDiCasa) {
		this.retiSquadraDiCasa = retiSquadraDiCasa;
	}

	public int getRetiSquadraOspite() {
		return retiSquadraOspite;
	}

	public void setRetiSquadraOspite(int retiSquadraOspite) {
		this.retiSquadraOspite = retiSquadraOspite;
	}

	public char getRisultato() {
		return risultato;
	}

	public void setRisultato(char risultato) {
		this.risultato = risultato;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}
	
	public String creaKey(Partita p)
	{
		String str = p.getSquadraDiCasa().getNomeSquadra() + p.getSquadraOspite().getNomeSquadra();
		return str;
	}
	

}
