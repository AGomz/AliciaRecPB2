package ar.edu.unlam.recuperatorio;

public class Masita extends Alimento {

	public Masita(Integer id, String descripcion, String fechaElaboracion, String fechaVencimiento, Double precio) {
		super(id, descripcion, fechaElaboracion, fechaVencimiento, precio);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Boolean encogible() {
		return Boolean.TRUE;
	}

	@Override
	public Boolean esCrecible() {
		return Boolean.FALSE;
	}

	

}
