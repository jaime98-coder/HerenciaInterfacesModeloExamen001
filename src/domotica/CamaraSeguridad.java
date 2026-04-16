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
	 * Enciende la cámara
	 * encendido pasa a true
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
	 * Apaga la cámara
	 *  encendido pasa a false
	 */
	public void apagarDispositivo() {
		if (this.encendido) {
			this.encendido = false;
		} else {
			System.out.println("La cámara ya estaba apagada");
		}
	}

	public void iniciarGrabacion() {
		if (this.encendido && !this.grabando) {
			this.grabando = true;
			System.out.println("Comenzando grabación...");
		}
	}

	public void detenerGrabacion() {
		if (this.encendido && this.grabando) {
			this.grabando = false;
			System.out.println("Deteniendo grabación...");
		}
	}

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
