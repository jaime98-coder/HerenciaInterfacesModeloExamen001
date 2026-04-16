package domotica;

/**
 * Representa una camara de seguridad dentro del sistema de domótica. Permite
 * iniciar y detener la grabación. Imp
 */
public class CamaraSeguridad extends DispositivoInteligente implements EmitirAlerta {
	private String resolucion;
	private boolean grabando = false;
	private boolean alertaActiva = false;
	private String mensajeAlerta;

	public CamaraSeguridad(String nombreComercial, String marca, double precio, String resolucion) {
		super(nombreComercial, marca, precio);
		setResolucion(resolucion);
	}

	public String getResolucion() {
		return resolucion;
	}

	public void setResolucion(String resolucion) {
		this.resolucion = resolucion;
	}

	public boolean isGrabando() {
		return grabando;
	}

	/**
	 * Enciende la cámara encendido pasa a true
	 */
	public void encenderDispositivo() {
		if (!this.encendido) {
			this.encendido = true;
			System.out.println("Beep! Camara encendida");
		} else {
			System.out.println("La cámara ya estaba encendido");
		}
	}

	/**
	 * Apaga la cámara encendido pasa a false
	 */
	public void apagarDispositivo() {
		if (this.encendido) {
			this.encendido = false;
		} else {
			System.out.println("La cámara ya estaba apagada");
		}
	}

	/**
	 * Comienza a grabar si no está grabando
	 * 
	 * @throws IllegalStateException lanza una excepcion si el dispositivo está
	 *                               apagado
	 */
	public void iniciarGrabacion() {
		if (this.encendido) {
			if (this.encendido && !this.grabando) {
				this.grabando = true;
				System.out.println("Comenzando grabación...");
			}
		} else {
			super.lanzarErrorApagado();
		}
	}

	/**
	 * Detiene la grabacíón si está grabando
	 * 
	 * @throws IllegalStateException lanza una excepcion si el dispositivo está
	 *                               apagado
	 */
	
	public void detenerGrabacion() {
		if (this.encendido) {
			if (this.encendido && this.grabando) {
				this.grabando = false;
				System.out.println("Deteniendo grabación...");
			}
		} else {
			super.lanzarErrorApagado();
		}
	}

	/**
	 * Activa la alerta
	 * 
	 * @param mensajeAlerta. Mensaje que reproducirá el termostato
	 * @throws IllegalStateException Si se intenta activar la alerta estando apagado
	 *                               lanza una excepción
	 */
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
	public void desactivarAlerta() {
		if (this.encendido) {
			if (this.alertaActiva) {
				mensajeAlerta = "";
				this.alertaActiva = false;

			} else {
				System.out.println("La alerta ya estaba desactivada");
			}
		} else {
			super.lanzarErrorApagado();
		}
	}

	/**
	 * Informa del estado actual de la alerta
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
		return "CamaraSeguridad: [ resolucion: " + resolucion + " | grabando: " + grabando + " | mensajeAlerta: "
				+ mensajeAlerta + " | nombreComercial: " + nombreComercial + " | marca: " + marca + " | encendido: "
				+ encendido + " | precio: " + precio + " ]";
	}

}
