package Campionato;

import java.util.Comparator;

public class SquadraComparator implements Comparator<Squadra> {

	@Override
	public int compare(Squadra o1, Squadra o2) {

		int valPunti =o2.getPunti()-o1.getPunti();
		if(valPunti==0)
		{
			int valReti = (o2.getRetiSegnate()-o2.getRetiSubite())-(o1.getRetiSegnate()-o1.getRetiSubite());		
			
			if(valReti==0)
			{
			Partita p1= o1.trovaPartita(o1, o2);
			Partita p2= o1.trovaPartita(o2, o1);
			int retio1=p1.getRetiSquadraDiCasa()+p2.getRetiSquadraOspite();
			int retio2=p1.getRetiSquadraOspite()+p2.getRetiSquadraDiCasa();
			int result=retio1-retio2;;
 
			return result;

			}
			return valReti;
		}
		return valPunti;
	}
}
