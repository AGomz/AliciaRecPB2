package ar.edu.unlam.recuperatorio;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Personaje {

	private Double alturaInicial;
	private Double peso;
	private String nombre;
	private Integer edad;
	private Double dineroDisponible;
	private List<Alimento> alimentosComprados;
	private final Double TAMAÑO_MAX_CRECER = 0.4; 
	private final Double TAMAÑO_MAX_ENCOGER = 0.5;
	private final Double ALTURA_MAXIMA = 2.8;
	private final Double ALTURA_MINIMA = 0.5;
	private Set<Alimento> alimentosDisponibles;
	private Integer cantidadAlimentos;
	
	public Personaje(Double altura, Double peso, String nombre, Integer edad, Double dinero) {
		this.alturaInicial = altura;
		this.peso = peso;
		this.nombre = nombre;
		this.edad = edad;
		this.dineroDisponible = dinero;
		
		this.alimentosComprados = new LinkedList<>();
		this.alimentosDisponibles = new TreeSet<>();
		this.cantidadAlimentos = 0;
	}

	//Suma los precios de los alimentos
	public Double verificarDineroDisponible() {
		Double importe = 0.0;
		for(Alimento alim : this.alimentosComprados) {
			importe += alim.getPrecio();
		}
		return importe;
	}

	public Boolean comprarAlimentos(Alimento alimento) throws DineroInsuficienteException{
		
		if(this.verificarDineroDisponible()+alimento.getPrecio() > this.getDineroDisponible()) {
			throw new DineroInsuficienteException("Dinero insufciente");
		}else {
			this.alimentosComprados.add(alimento);
			this.alimentosDisponibles.add(alimento);
			this.cantidadAlimentos++;
		 	return Boolean.TRUE;
		}
		
	}

	public void consumirAlimento(Alimento alimento) throws NoPuedoCrecerException, NoPuedoEncogerException {
		
		if(alimento.esCrecible()) {
			if(this.getAlturaInicial() + this.TAMAÑO_MAX_CRECER >= this.ALTURA_MAXIMA) {
				throw new NoPuedoCrecerException("No se puede aumentar mas la altura");
			} 
			this.setAlturaInical(this.alturaInicial + this.TAMAÑO_MAX_CRECER);
			//this.alimentosDisponibles.remove(alimento);
			this.cantidadAlimentos--;
		}
		
		if(alimento.encogible()) {
			if(this.getAlturaInicial() - this.TAMAÑO_MAX_ENCOGER <= this.ALTURA_MINIMA) {
				throw new NoPuedoEncogerException("No se puede reducir mas la altura");
			}
			this.setAlturaInical(this.alturaInicial - this.TAMAÑO_MAX_ENCOGER);
			//this.alimentosDisponibles.remove(alimento);
			this.cantidadAlimentos--;
		}
	
	}
	
	public Integer obtenerCantidadDeAlimentos() {
		return this.alimentosDisponibles.size();
	}
	
	public TreeSet<Alimento>ordenarAlimentos(){
		return (TreeSet<Alimento>)this.alimentosDisponibles;
	}
	
	public TreeSet<Alimento> devolverLista(PorDescripcionComparator criterio){
		TreeSet <Alimento> ordenados = new TreeSet<Alimento>(criterio);
		
	for(Alimento ordenadosEncogibles : this.alimentosDisponibles) {
		if(ordenadosEncogibles.encogible()) {
			ordenados.addAll(alimentosDisponibles);
		}
	}
		return ordenados;
	}
	
	public Double getAlturaInicial() {
		return alturaInicial;
	}


	public void setAlturaInical(Double altura) {
		this.alturaInicial = altura;
	}


	public Double getPeso() {
		return peso;
	}


	public void setPeso(Double peso) {
		this.peso = peso;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public Integer getEdad() {
		return edad;
	}


	public void setEdad(Integer edad) {
		this.edad = edad;
	}


	public Double getDineroDisponible() {
		return dineroDisponible;
	}


	public void setDineroDisponible(Double dinero) {
		this.dineroDisponible = dinero;
	}

	public Integer getCantidadAlimentos() {
		return cantidadAlimentos;
	}

	public void setCantidadAlimentos(Integer cantidadAlimentos) {
		this.cantidadAlimentos = cantidadAlimentos;
	}

	
}
