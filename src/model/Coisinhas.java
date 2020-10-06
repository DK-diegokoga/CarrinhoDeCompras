package model;

public class Coisinhas {
	
	private Compras produtos;
	private Coisinhas depois;
	private Coisinhas antes;
	
	public Coisinhas(Compras produtos) {
		this.produtos = produtos;
		this.depois = null;
		this.antes = null;
	}
	
	public Compras getProdutos() {
		return produtos;
	}

	public void setProdutos(Compras produtos) {
		this.produtos = produtos;
	}
	
	public Coisinhas getDepois() {
		return depois;
	}
	
	public void setDepois(Coisinhas depois) {
		this.depois = depois;
	}
	
	public Coisinhas getAntes() {
		return antes;
	}
	
	public void setAntes(Coisinhas antes) {
		this.antes = antes;
	}
}
