package principal;

import java.util.Arrays;

import domotica.*;

public class Main {

	public static void main(String[] args) {

		DispositivoInteligente tablaDispositivos[] = new DispositivoInteligente[4];
		Altavoz altavoz = new Altavoz("Wonderboom", "Ultimate Ears", 90, "Wonderwoman");
		Luz luz = new Luz("Light me!", "Lightroom", 10);
		Termostato termostato = new Termostato("Ay que freskito", "Taurus", 120);
		CamaraSeguridad camara = new CamaraSeguridad("Camara 12S", "SPC", 50, "1080P");
		tablaDispositivos[0] = altavoz;
		tablaDispositivos[1] = luz;
		tablaDispositivos[2] = termostato;
		tablaDispositivos[3] = camara;
		System.out.println("-----Tabla Sin Ordenar-----");
		imprimirTabla(tablaDispositivos);

		System.out.println("\n-----Tabla Ordenada por PRECIO-----");
		Arrays.sort(tablaDispositivos);
		imprimirTabla(tablaDispositivos);
		// Primero enciendo todos dispositivos
		for (DispositivoInteligente dispositivo : tablaDispositivos) {
			// 1. Encendemos el dispositivo
			dispositivo.encenderDispositivo();

			if (dispositivo instanceof Altavoz) {

				Altavoz altavoz1 = (Altavoz) dispositivo;
				System.out.println("\n-------------ALTAVOZ INTELIGENTE-------------");
				System.out.println("Antes de subir volumen:");
				altavoz1.mostrarNivelActual();
				System.out.println("Tras una subida de volumen:");
				altavoz1.subirNivel();
				System.out.println("Tras dos subidas de volumen:");
				altavoz1.subirNivel();
				System.out.println("Asistente: " + altavoz1.getNombreAsistente());
				

			} else if (dispositivo instanceof Luz) {

				Luz luz1 = (Luz) dispositivo;
				System.out.println("\n---------------LUZ INTELIGENTE---------------");
				System.out.println("Antes de subir brillo:");
				luz1.mostrarNivelActual();
				System.out.println("Tras subida de brillo:");
				luz1.subirNivel();
				luz1.cambiarColor("Rojo");
				

			} else if (dispositivo instanceof Termostato) {

				Termostato termostato1 = (Termostato) dispositivo;
				System.out.println("\n------------TERMOSTATO INTELIGENTE------------");
				termostato1.cambiarModoFuncionamiento();
				termostato1.activarAlerta("Temperatura extrema");
				
			} else if (dispositivo instanceof CamaraSeguridad) {

				CamaraSeguridad camara1 = (CamaraSeguridad) dispositivo;
				System.out.println("\n-------CÁMARA DE SEGURIDAD INTELIGENTE-------");
				camara1.iniciarGrabacion();
				camara1.activarAlerta("Alerta de movimiento: se ha detectado movimiento en la zona vigilada");
				

			}
			System.out.println(dispositivo.toString());
			System.out.println("---------------------------------------------");
		}

		

		altavoz.apagarDispositivo();
		try {
			altavoz.subirNivel();
		} catch (IllegalStateException e) {
			System.out.println("ERROR ATRAPADO: " + e.getMessage());
		}

	}

	public static void imprimirTabla(DispositivoInteligente tablaDispositivos[]) {
		for (DispositivoInteligente dispositivo : tablaDispositivos) {
			System.out.println(dispositivo);
		}
	}

}
