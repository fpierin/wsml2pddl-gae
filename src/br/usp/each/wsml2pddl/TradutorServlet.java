package br.usp.each.wsml2pddl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.usp.each.wsml2pddl.modelo.sistema.Compilador;
import br.usp.each.wsml2pddl.sistema.CompiladorWsmlPDDL;

public class TradutorServlet extends HttpServlet {

	private static final long serialVersionUID = 736071737077995516L;

	@Override
	public void doPost(final HttpServletRequest request, final HttpServletResponse response) {
		final String contextoOriginal = request.getParameter("documento");
		String contextoCompilacao = "";

		try {
			final Compilador compilador = new CompiladorWsmlPDDL();
			contextoCompilacao = compilador.compila(contextoOriginal);
		} catch (final Exception e) {
			contextoCompilacao = e.getMessage();
		}

		final String contextoHTML = (contextoCompilacao != null)? contextoCompilacao.replaceAll(" ", "&nbsp").replaceAll("(\r\n|\n)", "<br />"): "";

		request.setAttribute("compilacao", contextoHTML);
		request.setAttribute("documento", contextoOriginal);

		try {
			request.getRequestDispatcher("traducao.jsp").forward(request, response);
		} catch (final ServletException e) {
			e.printStackTrace();
		} catch (final IOException e) {
			e.printStackTrace();
		}
	}

}
