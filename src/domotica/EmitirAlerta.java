package domotica;

public interface EmitirAlerta {
	void activarAlerta(String mensajeAlerta);
	void desactivarAlerta();
	void informarAlertaActiva();
}
