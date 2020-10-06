package controller;

import model.Coisinhas;
import model.Compras;

public class Comprinhas {
	
	private Coisinhas inicio;
	
	public Comprinhas() {
		this.inicio = null;
		
	} 
	public void adicionaInicio(Compras produtos) {
		Coisinhas nos = new Coisinhas(produtos);
		nos.setDepois(this.inicio);
		if(this.inicio != null) {
			this.inicio.setAntes(nos);
		}
		this.inicio = nos;
	}
		
	public void adicionaFinal(Compras produtos) {
		Coisinhas nos = new Coisinhas(produtos);
		if(this.inicio == null) {
			this.inicio = nos;
		}else {
			Coisinhas aux = this.inicio;
			while(aux.getDepois()!=null) {
				aux = aux.getDepois();
			}
			aux.setDepois(nos);
			nos.setAntes(aux);
		}
	}
	public void adicionaMeio(Compras produtos , int posicao) {
		if (posicao == 1) {
			adicionaInicio(produtos);
		}else if(posicao == size()+1) {
			adicionaFinal(produtos);
		}else if(posicao <= size() && posicao > 0) {
			Coisinhas nos = new Coisinhas(produtos);
			Coisinhas aux = Posicao(posicao-1);
			Coisinhas aux2 = aux.getAntes();
			aux2.setDepois(nos);
			aux.setAntes(nos);
			nos.setDepois(aux);
			nos.setAntes(aux2);
		}else {
			System.out.println("Posição inválida");
		}
	}
	
	public void removeInicio() {
		if (this.inicio == null) {
			System.out.println("A lista está vazio");
		}else {
			this.inicio = this.inicio.getDepois();
			if (this.inicio != null) {
				this.inicio.setAntes(null);
			}
		}
	}
	
	public void removeFinal() {
		if (this.inicio == null) {
			System.out.println("A lista está vazia");
		}else {
			Coisinhas aux = this.inicio;
			while (aux.getDepois()!=null);{
				aux = aux.getDepois();
			}
			aux = aux.getAntes();
			if(aux!=null) {
				aux.setDepois(null);
			}
		}	
	}
	
	public void removeMeio(int posicao) {
		if (this.inicio == null) {
			System.out.println("Lista está vazia :/");
		}else if(posicao == 1) {
			removeInicio();
		}else if(posicao == size()) {
			removeFinal();
		}else if(posicao <= size() && posicao > 0) {
			Coisinhas aux = Posicao(posicao-1);
			Coisinhas aux2 = aux.getDepois();
			aux = aux.getAntes();
			aux.setDepois(aux2);
			aux2.setAntes(aux);
		}else {
			System.out.println("Posição inválida :/");
		}
	}
	
	public	String apresenta() {
			String mostra ;
			if(this.inicio == null) {
				mostra = ("Lista vazia :/");
			}else {
				StringBuffer x = new StringBuffer("Coisas dentro do carrinho de compras : \n");
				Coisinhas aux = this.inicio;
				while(aux != null) {
					x.append("Produto: " + aux.getProdutos().getNomeProduto() + " | Quantidade: " + aux.getProdutos().getQuantidade() + "\n" );
					aux = aux.getDepois();
				}
				mostra = x.toString();
			}
	return mostra;
	}
		
	private Coisinhas Posicao(int x) {
		Coisinhas aux = this.inicio;
		for (int i = 0; i < x; i++) {
			aux = aux.getDepois();
		}
		return aux;
	}
	
	private int size() {
		int x = 0;
		Coisinhas aux = this.inicio;
		while(aux != null) {
			aux = aux.getDepois();
			x++;
		}
		return x;
	}
}