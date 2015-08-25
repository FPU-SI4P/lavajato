package me.impressione.fpu.lavajato.entidades;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import me.impressione.fpu.lavajato.exceptions.VeiculoNaoSuportadoException;

public class Nota {
	private String			nome;
	private Veiculo			veiculo;
	private List<ItemNota>	itensNota;
	private Double			porcentagemDesconto	= 0.0;
	private Double			subtotal			= 0.0;

	public Nota(String nome, String veiculo, String[] servicos) {
		this.nome = nome;
		this.veiculo = Veiculo.valueOf(veiculo.toUpperCase());
		geraItensNota(servicos);
		calculaPorcentagemDesconto();
	}

	private void geraItensNota(String[] servicos) {
		itensNota = new ArrayList<>();
		for (String servico : servicos) {
			Servico servicoEnum = Servico.valueOf(servico.toUpperCase());
			ItemNota itemNota;
			try {
				itemNota = new ItemNota(servicoEnum, servicoEnum.qualValorPara(veiculo));
				itensNota.add(itemNota);
				subtotal += itemNota.getValor();
			} catch (VeiculoNaoSuportadoException e) {
				e.printStackTrace();
			}
		}
	}

	private void calculaPorcentagemDesconto() {
		if (this.itensNota.size() > 2) {
			this.porcentagemDesconto = 0.15;
		} else if (this.itensNota.size() == 2) {
			this.porcentagemDesconto = 0.10;
		}
	}

	public List<ItemNota> getItensNota() {
		return Collections.unmodifiableList(itensNota);
	}

	public Double getSubTotal() {
		return subtotal;
	}

	public Double getDesconto() {
		return getSubTotal() * porcentagemDesconto;
	}

	public Double getTotal() {
		return getSubTotal() - getDesconto();
	}

	public String getNome() {
		return nome;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}
}
