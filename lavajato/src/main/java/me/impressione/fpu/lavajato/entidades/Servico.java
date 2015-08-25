package me.impressione.fpu.lavajato.entidades;

import me.impressione.fpu.lavajato.exceptions.VeiculoNaoSuportadoException;

public enum Servico {
	LAVAR {
		@Override
		public Double qualValorPara(Veiculo veiculo) throws VeiculoNaoSuportadoException {
			switch (veiculo) {
				case CARRO:
					return 20.0;
				case MOTO:
					return 15.0;
				case CAMINHONETE:
					return 25.0;
				default:
					throw new VeiculoNaoSuportadoException();
			}
		}
	},
	ASPIRAR {
		@Override
		public Double qualValorPara(Veiculo veiculo) throws VeiculoNaoSuportadoException {
			switch (veiculo) {
				case CARRO:
					return 5.0;
				case CAMINHONETE:
					return 7.0;
				default:
					throw new VeiculoNaoSuportadoException();
			}
		}
	},
	ENCERAR {
		@Override
		public Double qualValorPara(Veiculo veiculo) throws VeiculoNaoSuportadoException {
			switch (veiculo) {
				case CARRO:
					return 15.0;
				case MOTO:
					return 10.0;
				case CAMINHONETE:
					return 20.0;
				default:
					throw new VeiculoNaoSuportadoException();
			}
		}
	};
	
	public abstract Double qualValorPara(Veiculo veiculo) throws VeiculoNaoSuportadoException;
}
