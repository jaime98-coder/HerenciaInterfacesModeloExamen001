package domotica;

/**
 * Define el contrato para aquellos dispositivos del sistema domotica que tienen
 * la capacidad de modificar niveles (ya sea volumen o brillo)
 */
public interface ModificarNivel {
	/**
	 * Sube el nivel del dispositivo
	 */
	void subirNivel();

	/**
	 * Baja el nivel del dispositivo
	 */
	void bajarNivel();
	
	/**
	 * Muestra el nivel actual del dispositivo (ya sea brillo o volumen en este caso)
	 */
	void mostrarNivelActual();
}
