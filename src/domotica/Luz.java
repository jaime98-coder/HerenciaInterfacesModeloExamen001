package domotica;

/**
 * Representa una luz inteligente dentro del sistema de domotica. Permite
 * controlar el nivel de brilo y el color de la luz
 */
public class Luz extends DispositivoInteligente implements ModificarNivel {
	private String color = "blanco";
	private int nivelBrillo = 50;
	private final int CANTIDAD_BRILLO = 10;

	/**
	 * Crea una nueva Luz inteligente
	 * 
	 * @param nombreComercial. El nombre comercial de la luz.
	 * @param marca.           Marca del fabricante
	 * @param precio.          Precio de venta.
	 */
	public Luz(String nombreComercial, String marca, double precio) {
		super(nombreComercial, marca, precio);

	}

	public String getColor() {
		return color;
	}

	/**
	 * Método para cambiar a un color personalizado
	 * 
	 * @param color. Entrada del color que uno quiera
	 */
	public void cambiarColor(String color) {
		this.color = color;
	}

	public int getNivelBrillo() {
		return nivelBrillo;
	}

	public int getCANTIDAD_BRILLO() {
		return CANTIDAD_BRILLO;
	}

	/**
	 * Enciende la luz. encendido pasa a true
	 */
	public void encenderDispositivo() {
		if (!this.encendido) {
			this.encendido = true;
			System.out.println("Bip! Luz encendida");
		} else {
			System.out.println("La luz ya estaba encendido");
		}
	}

	/**
	 * Apaga la luz. encendido pasa a false
	 */
	public void apagarDispositivo() {
		if (this.encendido) {
			this.encendido = false;
		} else {
			System.out.println("La luz ya estaba apagada");
		}
	}

	/**
	 * Sube el nivel de brillo de la luz
	 * 
	 * Sube el brillo de 10 en 10.
	 * 
	 * @throws IllegalStateException lanza una excepcion si el dispositivo está
	 *                               apagado
	 */
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

	/**
	 * Baja el nivel de brillo de la luz
	 * 
	 * Baja el brillo de 10 en 10.
	 * 
	 * @throws IllegalStateException lanza una excepcion si el dispositivo está
	 *                               apagado
	 */
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

	/**
	 * Muestro el brillo actual llamando al getNivelBrillo
	 */
	@Override
	public void mostrarNivelActual() {
		System.out.println("Brillo actual: " + getNivelBrillo());
	}

}
