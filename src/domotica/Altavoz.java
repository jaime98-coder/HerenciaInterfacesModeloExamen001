package domotica;

/**
 * Representa un altavoz inteligente dentro del sistema de domótica. Permite
 * controlar el nivel de volumen, y el asistente.
 */
public class Altavoz extends DispositivoInteligente implements ModificarNivel {
	private String nombreAsistente;
	private int nivelVolumen = 30;
	private final int CANTIDAD_VOLUMEN = 5;

	/**
	 * Crea un nuevo Altavoz inteligente con sus propiedades básicas. Por defecto,
	 * el dispositivo nacerá apagado y con volumen al 30
	 * 
	 * @param nombreComercial El nombre comercial del dispositivo
	 * @param marca           La marca del fabricante.
	 * @param precio          Precio venta
	 * @param nombreAsistente Nombre del asistente
	 */
	public Altavoz(String nombreComercial, String marca, double precio, String nombreAsistente) {
		super(nombreComercial, marca, precio);
		setNombreAsistente(nombreAsistente);
	}

	public String getNombreAsistente() {
		return nombreAsistente;
	}

	public void setNombreAsistente(String nombreAsistente) {
		this.nombreAsistente = nombreAsistente;
	}

	public int getNivelVolumen() {
		return nivelVolumen;
	}

	/**
	 * Enciende el altavoz
	 * encendido pasa a true
	 */
	public void encenderDispositivo() {
		if (!this.encendido) {
			this.encendido = true;
			System.out.println("Connected! Altavoz encendido");
		} else {
			System.out.println("El altavoz ya estaba encendido");
		}
	}

	/**
	 * Apaga el altavoz
	 * encendido pasa a false
	 */
	public void apagarDispositivo() {
		if (this.encendido) {
			this.encendido = false;
		} else {
			System.out.println("El altavoz ya estaba apagado");
		}
	}
	
	/**
	 * Subir el nivel de volumen del altavoz
	 * 
	 * Volumen aumenta de 5 en 5 y está limitado a 100
	 * 
	 * @throws IllegalStateException Si se intenta subir el volumen estando apagado
	 *                               lanza una excepción
	 */
	public void subirNivel() {
		if (this.encendido) {
			if (nivelVolumen >= 0 && nivelVolumen < 100 && nivelVolumen + CANTIDAD_VOLUMEN <= 100) {
				nivelVolumen += CANTIDAD_VOLUMEN;
				System.out.println("Volumen actual: " + nivelVolumen);
			} else {
				System.out.println("Volumen al máximo, no es posible subirlo más");
			}
		} else {
			super.lanzarErrorApagado();
		}
	}

	/**
	 * Bajar el nivel de volumen del altavoz * Volumen se reduce de 5 en 5 y baja
	 * hasta 0
	 * 
	 * @throws IllegalStateException Si se intenta subir el volumen estando apagado
	 *                               lanza una excepción
	 */
	public void bajarNivel() {
		if (this.encendido) {
			if (nivelVolumen > 0 && nivelVolumen <= 100 && nivelVolumen - CANTIDAD_VOLUMEN >= 0) {
				nivelVolumen -= CANTIDAD_VOLUMEN;
				System.out.println("Volumen actual: " + nivelVolumen);
			} else {
				System.out.println("Volumen al mínimo, no es posible bajar más");
			}
		} else {
			super.lanzarErrorApagado();
		}
	}

	@Override
	public String toString() {
		return "Altavoz [ nombreAsistente: " + nombreAsistente + " | nivelVolumen=" + nivelVolumen
				+ " | nombreComercial: " + nombreComercial + " | marca: " + marca + " | encendido: " + encendido
				+ " | precio: " + precio + " ]";
	}

	/**
	 * Muestra el volumen actual del altavoz
	 */
	public void mostrarVolumenActual() {
		System.out.println("Volumen actual: " + getNivelVolumen());
	}

}
