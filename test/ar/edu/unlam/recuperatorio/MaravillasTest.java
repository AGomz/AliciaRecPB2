package ar.edu.unlam.recuperatorio;

import static org.junit.Assert.*;

import java.util.TreeSet;

import org.junit.Test;

public class MaravillasTest {

	@Test
	public void queAlComprarUnAlimentoSeDescuenteDelDineroDisponible() throws Exception {
		Personaje alicia = new Personaje(1.8, 66.0, "Alicia", 18, 1500.0);
		//Supermercado mercado = new Supermercado("coto");
		//TipoTamanio tipo; 
		Integer cantidadAlimentos = 2;
		
		Alimento alfajor = new Alfajor(1, "Pepitos", "15-02-2021","15-02-2022", 200.0);
		Alimento bocadito = new Bocadito(3, "Rocher", "15-02-2021","15-02-2022", 500.0);
		
		/*Golosinas caramelo = new Caramelo();
		Golosinas gomita = new Gomita();
		Alimento masita = new Masita();
		Alimento bagels = new Bagels();*/
		
		alicia.comprarAlimentos(bocadito);
		Boolean valorObtenido = alicia.comprarAlimentos(alfajor);
		
		assertEquals(true, valorObtenido);
		assertEquals(cantidadAlimentos, alicia.obtenerCantidadDeAlimentos());
	}
	
	@Test (expected=DineroInsuficienteException.class)
	public void queAlComprarUnAlimentoDeMayorValorQueElDineroDisponibleHayaUnaExcepcion() throws Exception {
		Personaje alicia = new Personaje(1.8, 66.0, "Alicia", 18, 1500.0);
		
		Alimento alfajor = new Alfajor(1, "Pepitos", "15-02-2021","15-02-2022", 2000.0);
		Alimento bocadito = new Bocadito(3, "Rocher", "15-02-2021","15-02-2022", 500.0);
		
		alicia.comprarAlimentos(bocadito);
		Boolean valorObtenido = alicia.comprarAlimentos(alfajor);
		
		assertEquals(false, valorObtenido);
	}
	
	@Test
	public void queAlConsumirUnAlimentoQueSeAgrande() throws NoPuedoCrecerException, NoPuedoEncogerException, DineroInsuficienteException {
		Personaje alicia = new Personaje(1.8, 66.0, "Alicia", 18, 1500.0);
		Alimento bocadito = new Bocadito(3, "Rocher", "15-02-2021","15-02-2022", 500.0);
		Double valorEsperado = 2.6;
		
		alicia.comprarAlimentos(bocadito);
		alicia.consumirAlimento(bocadito);
		alicia.consumirAlimento(bocadito);
		
		assertEquals(valorEsperado, alicia.getAlturaInicial());
	}

	@Test
	public void queAlConsumirUnAlimentoQueSeEncoja() throws NoPuedoCrecerException, NoPuedoEncogerException, DineroInsuficienteException  {
		Personaje alicia = new Personaje(1.8, 66.0, "Alicia", 18, 1500.0);
		Alimento alfajor = new Alfajor(1, "Pepitos", "15-02-2021","15-02-2022", 200.0);
		Double valorEsperado = 1.3;
		
		alicia.comprarAlimentos(alfajor);
		alicia.consumirAlimento(alfajor);
		
		assertEquals(valorEsperado, alicia.getAlturaInicial());
	}
	
	@Test(expected=NoPuedoCrecerException.class)
	public void queAlConsumirAlimentosQueNoSeAgrandeMasDe280Cm() throws NoPuedoCrecerException, NoPuedoEncogerException, DineroInsuficienteException {
		Personaje alicia = new Personaje(1.8, 66.0, "Alicia", 18, 1500.0);
		Alimento bocadito = new Bocadito(3, "Rocher", "15-02-2021","15-02-2022", 500.0);
		Alimento bocadito2 = new Bocadito(2, "Rocher", "15-02-2021","15-02-2022", 500.0);
		Alimento bocadito3 = new Bocadito(1, "Rocher", "15-02-2021","15-02-2022", 500.0);
		
		alicia.comprarAlimentos(bocadito);
		alicia.comprarAlimentos(bocadito2);
		alicia.comprarAlimentos(bocadito3);
		
		alicia.consumirAlimento(bocadito);
		alicia.consumirAlimento(bocadito2);
		alicia.consumirAlimento(bocadito3);
		
	}
	@Test
	public void queAlConsumirUnAlimentoSeDescuenteDeLaListaDeAlimentosDisponibles() throws DineroInsuficienteException, NoPuedoCrecerException, NoPuedoEncogerException {
		Personaje alicia = new Personaje(1.8, 66.0, "Alicia", 18, 1500.0);
		Alimento bocadito = new Bocadito(3, "Rocher", "15-02-2021","15-02-2022", 100.0);
		Alimento alfajor = new Alfajor(2, "Rocher", "15-02-2021","15-02-2022", 500.0);
		Alimento bocadito3 = new Bocadito(1, "Rocher", "15-02-2021","15-02-2022", 500.0);
		Alimento bocadito4 = new Bocadito(1, "Rocher", "15-02-2021","15-02-2022", 100.0);
		Integer valorEsperado = 2;
		
		alicia.comprarAlimentos(bocadito);
		alicia.comprarAlimentos(alfajor);
		alicia.comprarAlimentos(bocadito3);
		alicia.comprarAlimentos(bocadito4);
		
		alicia.consumirAlimento(bocadito);
		alicia.consumirAlimento(alfajor);
		
		assertEquals(valorEsperado, alicia.getCantidadAlimentos());
	}
	@Test
	public void queLaColeccionDeAlimentosQuedeOrdenadaDeManeraDescendente() throws DineroInsuficienteException {
		Personaje alicia = new Personaje(1.8, 66.0, "Alicia", 18, 1500.0);
	
		Alimento masita = new Masita(2, "Masita", "15-02-2021","15-02-2022", 500.0);
		Alimento bagel = new Bagels(3, "Bagels", "15-02-2021","15-02-2022", 500.0);
		Alimento bocado = new Bocadito(1, "Bocado", "15-02-2021","15-02-2022", 500.0);
		
		alicia.comprarAlimentos(masita);
		alicia.comprarAlimentos(bagel);
		alicia.comprarAlimentos(bocado);

		assertEquals(masita, alicia.ordenarAlimentos().first());
		assertEquals(bagel, alicia.ordenarAlimentos().last());
	}
	
	@Test
	public void queLaColeccionDeAlimentosEncogiblesQuedeOrdenadaDeManeraDescendente() throws DineroInsuficienteException {
		Personaje alicia = new Personaje(1.8, 66.0, "Alicia", 18, 1500.0);
	
		Alimento masita = new Masita(2, "Masita", "15-02-2021","15-02-2022", 100.0);
		Alimento bagel = new Bagels(3, "Bagels", "15-02-2021","15-02-2022", 100.0);
		Alimento bocado = new Bocadito(1, "Bocado", "15-02-2021","15-02-2022", 100.0);
		Alimento gomita = new Gomita(4, "Gomita", "15-02-2021","15-02-2022", 100.0);
		Alimento alfajor = new Alfajor(6, "Alfajor", "15-02-2021","15-02-2022", 100.0);
		Alimento caramelo = new Caramelo(5, "Caramelo", "15-02-2021","15-02-2022", 100.0);
		
		
		alicia.comprarAlimentos(masita);
		alicia.comprarAlimentos(bagel);
		alicia.comprarAlimentos(bocado);
		alicia.comprarAlimentos(gomita);
		alicia.comprarAlimentos(alfajor);
		alicia.comprarAlimentos(caramelo);

		TreeSet <Alimento> ordenados = alicia.devolverLista(new PorDescripcionComparator());
		assertEquals(masita.getDescripcion(), ordenados.first().getDescripcion());
		assertEquals(alfajor.getDescripcion(), ordenados.last().getDescripcion());
	}
}
