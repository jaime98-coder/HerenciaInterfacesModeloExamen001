package domotica;

/**
 * Representa un termostato inteligente dentro del sistema de domótica. Permite
 * cambiar la temperaturaObjetivo, el modo de funcionamiento (calor o frio), y
 * almacena el mensaje de alerta
 */
public class Termostato extends DispositivoInteligente implements EmitirAlerta {
	private int temperaturaObjetivo;
	private String modoFuncionamiento = "Calor";
	private boolean alertaActiva = false;
	private String mensajeAlerta;

	/**
	 * Crea un nuevo termostato inteligente. Por defecto nace apagado y en modo
	 * calor
	 * 
	 * @param nombreComercial. Nombre comercial del termostato.
	 * @param marca.           Marca del fabricante.
	 * @param precio.          Precio de venta
	 */
	public Termostato(String nombreComercial, String marca, double precio) {
		super(nombreComercial, marca, precio);
	}

	public int getTemperaturaObjetivo() {
		return temperaturaObjetivo;
	}

	public void modificarTemperatura(int temperaturaObjetivo) {
		if (temperaturaObjetivo > 14 && temperaturaObjetivo <= 30) {
			this.temperaturaObjetivo = temperaturaObjetivo;
		}
	}

	public String getModoFuncionamiento() {
		return modoFuncionamiento;
	}

	/**
	 * Cambiar el modo de funcionamiento de calor a frio según el que esté activado
	 */
	public void cambiarModoFuncionamiento() {
		if (this.encendido) {
			if (modoFuncionamiento.equalsIgnoreCase("Calor")) {
				this.modoFuncionamiento = "Frio";
				System.out.println("Modo Frio activado");
			} else {
				this.modoFuncionamiento = "Calor";
				System.out.println("Modo Calor activado");
			}
		} else {
			super.lanzarErrorApagado();
		}
	}

	public boolean isAlertaActiva() {
		return alertaActiva;
	}

	public String getMensajeAlerta() {
		return mensajeAlerta;
	}

	/**
	 * Enciende el termostato encendido pasa a true
	 */
	@Override
	public void encenderDispositivo() {
		if (!this.encendido) {
			this.encendido = true;
			System.out.println("Tinoni! Termostato encendido");
		} else {
			System.out.println("El termostato ya estaba encendido");
		}
	}

	/**
	 * Apaga el termostato encendido pasa a false
	 */
	@Override
	public void apagarDispositivo() {
		if (this.encendido) {
			this.encendido = false;
		} else {
			System.out.println("El termostato ya estaba apagado");
		}
	}

	/**
	 * Activa la alerta
	 * 
	 * @param mensajeAlerta. Mensaje que reproducirá el termostato
	 * @throws IllegalStateException Si se intenta activar la alerta estando apagado
	 *                               lanza una excepción
	 */
	@Override
	public void activarAlerta(String mensajeAlerta) {
		if (this.encendido) {
			if (!this.alertaActiva) {
				this.mensajeAlerta = mensajeAlerta;
				this.alertaActiva = true;
			} else {
				System.out.println("La alerta ya estaba activada");
			}
		} else {
			super.lanzarErrorApagado();
		}
	}

	/**
	 * Desactiva la alerta
	 * 
	 * @param mensajeAlerta. Mensaje que reproducirá el termostato
	 * @throws IllegalStateException Si se intenta activar la alerta estando apagado
	 *                               lanza una excepción
	 */
	@Override
	public void desactivarAlerta() {
		if (this.encendido) {
			if (this.alertaActiva) {
				mensajeAlerta = "*Sin mensaje*";
				this.alertaActiva = false;

			} else {
				System.out.println("La alerta ya estaba desactivada");
			}
		} else {
			super.lanzarErrorApagado();
		}
	}

	/**
	 * Informa del estado de la alerta
	 */
	@Override
	public void informarAlertaActiva() {
		if (this.alertaActiva) {
			System.out.println("La alerta se encuentra en estado: ENCENDIDA");
		} else {
			System.out.println("La alerta se encuentra en estado: APAGADA");
		}
	}

	@Override
	public String toString() {
		return "Termostato [ temperaturaObjetivo: " + temperaturaObjetivo + " | modoFuncionamiento: "
				+ modoFuncionamiento + " | mensajeAlerta: " + mensajeAlerta + " | nombreComercial: " + nombreComercial
				+ " | marca: " + marca + "| encendido: " + encendido + " | precio: " + precio + " ]";
	}

	// PDte revisar lo del mensaje alerta, no entiendo enunciado

}
