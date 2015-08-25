package me.impressione.fpu.lavajato.entidades;

public class ItemNota {
	private Servico	servico;
	private Double	valor;

	public ItemNota(Servico servico, Double valor) {
		this.servico = servico;
		this.valor = valor;
	}

	public Servico getServico() {
		return servico;
	}

	public void setServico(Servico servico) {
		this.servico = servico;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}
}
