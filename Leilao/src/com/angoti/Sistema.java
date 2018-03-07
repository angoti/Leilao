package com.angoti;

public class Sistema {
	public static void main(String[] args) {
		Leilao l1 = new Leilao(10, "bicicleta");
		l1.registrarLance("a", 5);
		l1.registrarLance("b", 10);
		l1.registrarLance("c", 20);
		l1.registrarLance("d", 15);
		l1.registrarLance("e", 100);
		l1.finalizar();
	}
}
