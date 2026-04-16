package domotica;

/**
 * Define el contrato para aquellos dispositivos del sistema domótico que tienen
 * la capacidad de emitir alertas visuales o sonoras.
 */
public interface EmitirAlerta {
	/**
	 * Enciende la alarma del dispositivo y registra el mensaje de alerta
	 * 
	 * @param mensajeAlerta. Texto descriptivo del motivo de la alerta
	 */
	void activarAlerta(String mensajeAlerta);

	/**
	 * Apaga la alarma del dispositivo y borra los mensajes activos
	 */
	void desactivarAlerta();

	/**
	 * Muestra por consola el estado actual de la alerta (Encendida/Apagada)
	 */
	void informarAlertaActiva();
}
