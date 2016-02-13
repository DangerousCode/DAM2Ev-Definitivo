package bici;

import java.io.Serializable;

public class Bici implements Serializable {
	int numero;
	boolean reservada;
	
	public Bici(){
		
	}
	
	public Bici(int numero, boolean reservada){
		this.numero=numero;
		this.reservada=reservada;
	}

	public boolean isReservada() {
		return reservada;
	}

	public void setReservada(boolean reservada) {
		this.reservada = reservada;
	}

	public int getNumero() {
		return numero;
	}

	public void setCantidad(int numero) {
		this.numero = numero;
	}
}