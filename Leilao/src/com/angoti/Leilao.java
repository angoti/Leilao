package com.angoti;

import java.util.ArrayList;
import java.util.List;

public class Leilao {
	private Lance lanceVencedor;
	private double valorMinimo;
	private String nomeBem;
	private boolean status;
	List<Lance> listaDeLances;

	public Leilao(double valorMinimo, String nomeBem) {
		super();
		this.valorMinimo = valorMinimo;
		this.nomeBem = nomeBem;
		this.status = true;
		this.listaDeLances = new ArrayList<Lance>();
	}

	public void registrarLance(String nome, double valor) {
		if (status) {
			listaDeLances.add(new Lance(nome, valor));
			if (lanceVencedor != null && valor > lanceVencedor.getValor()) {
				lanceVencedor.setNomeArrematante(nome);
				lanceVencedor.setValor(valor);
			} else {
				if (lanceVencedor == null && valor > valorMinimo)
					lanceVencedor = new Lance(nome, valor);
			}
		}
	}

	public void finalizar() {
		status = false;
		if (lanceVencedor != null) {
			System.out.println("Lista de todos os lances");
			for (Lance lance : listaDeLances) {				
				System.out.println("Arrematante: " + lance.getNomeArrematante());
				System.out.println("Valor do arremate: " + lance.getValor());
			}
			System.out.println("Bem leiloado: " + nomeBem);
			System.out.println("Arrematante: " + lanceVencedor.getNomeArrematante());
			System.out.println("Valor do arremate: " + lanceVencedor.getValor());
		} else
			System.out.println("Não teve lance vencedor!");
	}
}
