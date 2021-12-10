package ar.edu.unlam.recuperatorio;

public abstract class Alimento implements Comparable <Alimento>, Crecible, Encogible{

	private Integer id;
	private String descripcion;
	private String fechaElaboracion;
	private String fechaVencimiento;
	private Double precio;
	
	public Alimento(Integer id, String descripcion, String fechaElaboracion, String fechaVencimiento,
			Double precio) {
		this.id = id;
		this.descripcion = descripcion;
		this.fechaElaboracion = fechaElaboracion;
		this.fechaVencimiento = fechaVencimiento;
		this.precio = precio;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getFechaElaboracion() {
		return fechaElaboracion;
	}

	public void setFechaElaboracion(String fechaElaboracion) {
		this.fechaElaboracion = fechaElaboracion;
	}

	public String getFechaVencimiento() {
		return fechaVencimiento;
	}

	public void setFechaVencimiento(String fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	@Override
	public int compareTo(Alimento o) {
		return o.descripcion.compareTo(this.descripcion);
	}

	@Override
	public abstract Boolean encogible();

	@Override
	public abstract Boolean esCrecible();
	
	
}
