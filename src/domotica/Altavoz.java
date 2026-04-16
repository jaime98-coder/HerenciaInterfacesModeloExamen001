package domotica;

public class Altavoz extends DispositivoInteligente implements ModificarNivel {
	private String nombreAsistente;
	private int nivelVolumen = 30;
	private final int CANTIDAD_VOLUMEN = 5;

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

	public void subirNivel() {
		if (super.encendido) {
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

	public void bajarNivel() {
		if (super.encendido) {
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
		return "Altavoz [ nombreAsistente: " + nombreAsistente + " | nivelVolumen=" + nivelVolumen + " | nombreComercial: "
				+ nombreComercial + " | marca: " + marca + " | encendido: " + encendido + " | precio: " + precio + " ]";
	}

	public void mostrarVolumenActual() {
		System.out.println("Volumen actual: "+getNivelVolumen());
	}

}
