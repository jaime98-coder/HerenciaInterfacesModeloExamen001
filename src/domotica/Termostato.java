package domotica;

public class Termostato extends DispositivoInteligente implements EmitirAlerta {
	private int temperaturaObjetivo;
	private String modoFuncionamiento = "Calor";
	private boolean alertaActiva=false;
	private String mensajeAlerta;

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

	public void cambiarModoFuncionamiento() {
		if (modoFuncionamiento.equalsIgnoreCase("Calor")) {
			this.modoFuncionamiento="Frio";
			System.out.println("Modo Frio activado");
		} else {
			this.modoFuncionamiento="Calor";
			System.out.println("Modo Calor activado");
		}
	}

	public boolean isAlertaActiva() {
		return alertaActiva;
	}

	public String getMensajeAlerta() {
		return mensajeAlerta;
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
				mensajeAlerta = "BEEP! Alerta apagada";
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
		return "Termostato [ temperaturaObjetivo: " + temperaturaObjetivo + " | modoFuncionamiento: " + modoFuncionamiento
				+ " | mensajeAlerta: " + mensajeAlerta + " | nombreComercial: " + nombreComercial + " | marca: " + marca
				+ "| encendido: " + encendido + " | precio: " + precio + " ]";
	}

	// PDte revisar lo del mensaje alerta, no entiendo enunciado

}
