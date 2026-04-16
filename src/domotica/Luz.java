package domotica;

public class Luz extends DispositivoInteligente implements ModificarNivel {
	private String color = "blanco";
	private int nivelBrillo = 50;
	private final int CANTIDAD_BRILLO = 10;

	public Luz(String nombreComercial, String marca, double precio, String color) {
		super(nombreComercial, marca, precio);
		this.color = color;
	}

	public String getColor() {
		return color;
	}

	public void cambiarColor(String color) {
		this.color = color;
	}

	public int getNivelBrillo() {
		return nivelBrillo;
	}

	public int getCANTIDAD_BRILLO() {
		return CANTIDAD_BRILLO;
	}

	public void subirNivel() {
		if (super.encendido) {
			if (nivelBrillo >= 0 && nivelBrillo < 100 && nivelBrillo + CANTIDAD_BRILLO <= 100) {
				nivelBrillo += CANTIDAD_BRILLO;
				System.out.println("Brillo actual: " + nivelBrillo);
			} else {
				System.out.println("Brillo al máximo, no es posible subirlo más");
			}
		} else {
			super.lanzarErrorApagado();
		}
	}

	public void bajarNivel() {
		if (super.encendido) {
			if (nivelBrillo > 0 && nivelBrillo <= 100 && nivelBrillo - CANTIDAD_BRILLO >= 0) {
				nivelBrillo -= CANTIDAD_BRILLO;
				System.out.println("Brillo actual: " + nivelBrillo);
			} else {
				System.out.println("Brillo al mínimo, no es posible bajar más");
			}
		} else {
			super.lanzarErrorApagado();
		}
	}

	@Override
	public String toString() {
		return "Luz [ color: " + color + " | nivelBrillo: " + nivelBrillo + ",| nombreComercial: " + nombreComercial
				+ " | marca: " + marca + " | encendido: " + encendido + " | precio: " + precio + "]";
	}

	public void mostrarBrilloActual() {
		System.out.println("Brillo actual: " + getNivelBrillo());
	}

}
