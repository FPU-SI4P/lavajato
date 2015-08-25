package me.impressione.fpu.lavajato;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.impressione.fpu.lavajato.entidades.ItemNota;
import me.impressione.fpu.lavajato.entidades.Nota;

@WebServlet(urlPatterns = "/geranota")
public class GeradorDeNotas extends HttpServlet {
	private static final long	serialVersionUID	= 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nomeCliente = req.getParameter("nomeCliente");
		String veiculo = req.getParameter("tipoVeiculo");
		String[] servicos = req.getParameterValues("servico");
		PrintWriter writer = resp.getWriter();
		if (nomeCliente != null && veiculo != null && servicos != null && servicos.length >= 1) {
			Nota nota = new Nota(nomeCliente, veiculo, servicos);
			writer.write(montarNota(nota));
		} else {
			writer.write("Erro, falta de parametros");
		}
	}

	private String montarNota(Nota nota) {
		StringBuilder sb = new StringBuilder();
		sb.append("<html>");
		sb.append("<head>");
		sb.append("<link rel='stylesheet' href='resources/bootstrap-3.3.5-dist/css/bootstrap.min.css'>");
		sb.append("<link rel='stylesheet' href='resources/bootstrap-3.3.5-dist/css/bootstrap-theme.min.css'>");
		sb.append("</head>");
		sb.append("<body>");
		sb.append("<div class='container'>");
		sb.append("<div class='panel panel-default'>");
		sb.append("<div class='panel-heading'>");
		sb.append("<h3 class='panel-title'>Nota de Serviço</h3>");
		sb.append("</div>");
		sb.append("<div class='panel-body'>");
		sb.append("Nome: ");
		sb.append(nota.getNome());
		sb.append("");
		sb.append("");
		sb.append("<br>");
		for (ItemNota itemNota : nota.getItensNota()) {
			sb.append(itemNota.getServico());
			sb.append(" = ");
			sb.append(itemNota.getValor());
			sb.append("<br>");
		}
		sb.append("");
		sb.append("<br>");
		sb.append("subtotal");
		sb.append(nota.getSubTotal());
		sb.append("<br>");
		sb.append("desconto");
		sb.append(nota.getDesconto());
		sb.append("<br>");
		sb.append("total");
		sb.append(nota.getTotal());
		sb.append("");
		sb.append("</div>");
		sb.append("<div class='panel-footer'>");
		sb.append("<a class='btn btn-default' href='index.html' role='button'>Voltar</a>");

		sb.append("</div>");
		sb.append("</div>");
		sb.append("</div>");
		sb.append("</div>");
		sb.append("</body>");
		sb.append("</html>");
		return sb.toString();
	}

}
