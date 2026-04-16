package domotica;

public abstract class DispositivoInteligente implements Comparable<DispositivoInteligente> {
	protected String nombreComercial;
	protected String marca;
	protected boolean encendido = false;
	protected double precio;

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

	public void encenderDispositivo() {
		if (!this.encendido) {
			this.encendido = true;
		} else {
			System.out.println("El dispositivo ya estaba encendido");
		}
	}

	public void apagarDispositivo() {
		if (this.encendido) {
			this.encendido = false;
		} else {
			System.out.println("El dispositivo ya estaba apagado");
		}
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public void lanzarErrorApagado() {
		throw new IllegalStateException("\n¡¡ERROR: El dispositivo está apagado!!");
	}

	@Override
	public String toString() {
		return "DispositivoInteligente [ Nombre Comercial: " + nombreComercial + " | Marca: " + marca + " | Encendido: "
				+ encendido + " | precio: " + precio + " ]";
	}

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
