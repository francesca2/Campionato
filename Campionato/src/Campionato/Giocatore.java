package Campionato;

public class Giocatore {

	private String nome;
	private String cognome;
	private String ruolo;
	private int età;
	private String codiceFiscale;
	private double stipendio;
	private int ammonizioni;
	private int reti;
	private int assist;
	private int espulsioni;
	
	//Costruttori
	public Giocatore() {

	}
	
	public Giocatore(String nome, String cognome,String codiceFiscale) {

		this.nome = nome;
		this.cognome = cognome;
		this.codiceFiscale = codiceFiscale;
	}

	//Getters e Setters
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getRuolo() {
		return ruolo;
	}

	public void setRuolo(String ruolo) {
		this.ruolo = ruolo;
	}

	public int getEtà() {
		return età;
	}

	public void setEtà(int età) {
		this.età = età;
	}

	public String getCodiceFiscale() {
		return codiceFiscale;
	}

	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}

	public int getAmmonizioni() {
		return ammonizioni;
	}

	public void setAmmonizioni(int ammonizioni) {
		this.ammonizioni = ammonizioni;
	}

	public int getReti() {
		return reti;
	}

	public void setReti(int reti) {
		this.reti = reti;
	}

	public int getAssist() {
		return assist;
	}

	public void setAssist(int assist) {
		this.assist = assist;
	}

	public int getEspulsioni() {
		return espulsioni;
	}

	public void setEspulsioni(int espulsioni) {
		this.espulsioni = espulsioni;
	}

}
