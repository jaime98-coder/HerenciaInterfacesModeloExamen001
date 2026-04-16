package domotica;

/**
 * Representa un dispositivo inteligente abstracto
 */
public abstract class DispositivoInteligente implements Comparable<DispositivoInteligente> {
	protected String nombreComercial;
	protected String marca;
	protected boolean encendido = false;
	protected double precio;

	/**
	 * Constructor base para cualquier tipo de dispositivo inteligente Cualquier
	 * dispositivo nace apagado (encendido=false)
	 * 
	 * @param nombreComercial Nombre comercial del dispositivo
	 * @param marca           Marca del fabricante
	 * @param precio          Precio de venta
	 */
	public DispositivoInteligente(String nombreComercial, String marca, double precio) {
		setNombreComercial(nombreComercial);
		setMarca(marca);
		setPrecio(precio);
	}

	public String getNombreComercial() {
		return nombreComercial;
	}

	public void setNombreComercial(String nombreComercial) {
		this.nombreComercial = nombreComercial;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public boolean isEncendido() {
		return encendido;
	}

	/**
	 * Enciende el dispositivo inteligente
	 */
	public abstract void encenderDispositivo();

	/**
	 * Apaga el dispositivo inteligente
	 */
	public abstract void apagarDispositivo();

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	/**
	 * Centraliza la generación de errores cuando se intenta usar un dispositivo que
	 * no está encendido.
	 * 
	 * @throws IllegalStateException Siempre que se invoca este método.
	 */
	public void lanzarErrorApagado() {
		throw new IllegalStateException("\n¡¡ERROR: El dispositivo está apagado!!");
	}

	@Override
	public String toString() {
		return "DispositivoInteligente [ Nombre Comercial: " + nombreComercial + " | Marca: " + marca + " | Encendido: "
				+ encendido + " | precio: " + precio + " ]";
	}

	/**
	 * Compara si dos dispositivos son iguales.
	 * 
	 * Son iguales si tiene el mismo nombre comercial y la misma marca, ignorando
	 * mayusculas y minusculas
	 * 
	 * @param obj EL objeto con el que se va a comparar
	 * @return true --> Son el mismo producto. false --> No son mismo producto
	 */
	@Override
	public boolean equals(Object obj) {
		boolean sonIguales = false;
		if (obj instanceof DispositivoInteligente) {

			// Casteamos el objeto genérico a nuestro tipo
			DispositivoInteligente otroDispositivo = (DispositivoInteligente) obj;
			if (otroDispositivo.nombreComercial.equalsIgnoreCase(this.nombreComercial)
					&& otroDispositivo.marca.equalsIgnoreCase(this.marca)) {
				sonIguales = true;
			}
		}
		return sonIguales;
	}

	/**
	 * Compara este dispositivo con otro para ordenarlos por precio (de menor a
	 * mayor).
	 * 
	 * @param otroDispositivo El dispositivo contra el que vamos a comparar el
	 *                        precio.
	 *
	 * @return 0 --> mismo precio. -1 --> menor precio. 1 --> Mayor precio
	 */
	@Override
	public int compareTo(DispositivoInteligente otroDispositivo) {
		int resultado = 0;
		if (this.precio < otroDispositivo.precio) {
			resultado = -1;
		} else if (this.precio > otroDispositivo.precio) {
			resultado = 1;
		}
		return resultado;
	}

}
