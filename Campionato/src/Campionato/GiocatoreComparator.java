package Campionato;

import java.util.Comparator;

public class GiocatoreComparator implements Comparator<Giocatore> {

	@Override
	public int compare(Giocatore o1, Giocatore o2) {

		int valReti=o2.getReti()-o1.getReti();
		if(valReti==0)
		{
			int valEspulsioni=o1.getEspulsioni()-o2.getEspulsioni();
					if(valEspulsioni==0)
					{
						int valAmmonizioni =o1.getAmmonizioni()-o2.getAmmonizioni();
						return valAmmonizioni;
					}
					return valEspulsioni;
		}
		
		return valReti;
	}

}
