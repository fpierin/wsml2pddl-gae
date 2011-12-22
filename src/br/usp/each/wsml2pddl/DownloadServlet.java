package br.usp.each.wsml2pddl;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.abdera.Abdera;
import org.apache.abdera.model.Document;
import org.apache.abdera.model.Entry;
import org.apache.abdera.model.Feed;
import org.apache.abdera.parser.Parser;

public class DownloadServlet extends HttpServlet {

    private static final long serialVersionUID = 2574007231015879632L;

    @Override
    protected void doGet(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
	req.setAttribute("atualizacoesWsml2Pddl", obterAtualizacaoesDoProjeto("https://github.com/fpierin/wsml2pddl/commits/master.atom"));
	req.setAttribute("atualizacoesWsml2Pddl-Gae", obterAtualizacaoesDoProjeto("https://github.com/fpierin/wsml2pddl-Gae/commits/master.atom"));
	req.getRequestDispatcher("download.jsp").forward(req, resp);
    }

    private InputStream getRemoteStream(final String urlDeCommitsDoProjeto) throws IOException {
	final URL url = new URL(urlDeCommitsDoProjeto);
	final HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
	return httpURLConnection.getInputStream();
    }

    private String obterAtualizacaoesDoProjeto(final String urlDeCommitsDoProjeto) {
	final Parser parser = new Abdera().getParser();
	final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

	try {
	    final Document<Feed> doc = parser.parse(getRemoteStream(urlDeCommitsDoProjeto));
	    final Feed feed = doc.getRoot();
	    final StringBuffer stringBuffer = new StringBuffer();
	    for (final Entry entry : feed.getEntries()) {
		stringBuffer.append("<div>");
		stringBuffer.append("<a href=\"" + entry.getLinks().get(0).getHref() + "\">");
		stringBuffer.append(simpleDateFormat.format(entry.getUpdated()) + ": " + entry.getTitle());
		stringBuffer.append("</a>");
		stringBuffer.append("</div>");
	    }
	    return stringBuffer.toString();
	} catch (final Exception ex) {
	    System.out.println("Error: " + ex.getMessage());
	}

	return "Não foi possível obter as atualizações do projeto.";
    }
}
