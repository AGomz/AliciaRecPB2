package ar.edu.unlam.recuperatorio;

import java.util.Comparator;

public class PorDescripcionComparator implements Comparator<Alimento> {

	@Override
	public int compare(Alimento o1, Alimento o2) {
		
		return o2.getDescripcion().compareTo(o1.getDescripcion());
	}

}
