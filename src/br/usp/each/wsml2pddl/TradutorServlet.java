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
    protected void doGet(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
	req.setAttribute("compilacao", "");
	req.setAttribute("documento", "");
	req.getRequestDispatcher("tradutor.jsp").forward(req, resp);
    }

    @Override
    public void doPost(final HttpServletRequest req, final HttpServletResponse resp) {
	String contextoCompilacao = "";
	final String contextoOriginal = req.getParameter("documento");

	if (!contextoOriginal.equals("")) {
	    try {
		final Compilador compilador = new CompiladorWsmlPDDL();
		contextoCompilacao = compilador.compila(contextoOriginal);
	    } catch (final Exception e) {
		contextoCompilacao = e.getCause().getMessage();
	    }

	    if (contextoCompilacao == null) {
		contextoCompilacao = "Não foi possivel realizar a tradução. Verifique se o wsml é válido.";
	    }

	}

	req.setAttribute("compilacao", contextoCompilacao.trim());
	req.setAttribute("documento", contextoOriginal.trim());

	try {
	    req.getRequestDispatcher("tradutor.jsp").forward(req, resp);
	} catch (final ServletException e) {
	    e.printStackTrace();
	} catch (final IOException e) {
	    e.printStackTrace();
	}
    }
}
