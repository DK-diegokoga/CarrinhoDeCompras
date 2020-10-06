package model;

public class Compras {
	//Recolhe o nome do produto e quantidade
	private String nomeProduto;
	private int quantidade;
	public Compras(String nomeProduto, int quantidade) {
		this.nomeProduto = nomeProduto;
		this.quantidade = quantidade;
	}
	
	public String getNomeProduto() {
		return nomeProduto;
	}	
	
	public int getQuantidade() {
		return quantidade;
	}
}
