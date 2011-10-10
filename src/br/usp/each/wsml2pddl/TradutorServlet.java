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

	public void doPost(final HttpServletRequest request, final HttpServletResponse response) {
		try {
			final String contextoOriginal = request.getParameter("documento");
			final Compilador compilador = new CompiladorWsmlPDDL();
			final String contextoCompilacao = compilador.compila(contextoOriginal);
			final String contextoHTML = contextoCompilacao.replaceAll(" ", "&nbsp").replaceAll("(\r\n|\n)", "<br />");
			request.setAttribute("compilacao", contextoHTML);
			request.setAttribute("documento", contextoOriginal);			
			request.getRequestDispatcher("traducao.jsp").forward(request, response);
		} catch (final IOException e) {
			e.printStackTrace();
		} catch (final ServletException e) {
			e.printStackTrace();
		}
	}
	
}
