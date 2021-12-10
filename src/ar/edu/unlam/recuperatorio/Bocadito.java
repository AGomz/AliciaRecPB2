package ar.edu.unlam.recuperatorio;

public class Bocadito extends Alimento {

	public Bocadito(Integer id, String descripcion, String fechaElaboracion, String fechaVencimiento, Double precio) {
		super(id, descripcion, fechaElaboracion, fechaVencimiento, precio);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Boolean esCrecible() {
		return Boolean.TRUE;
	}

	@Override
	public Boolean encogible() {
		return Boolean.FALSE;
	}

	

	
}
