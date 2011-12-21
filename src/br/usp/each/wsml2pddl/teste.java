package br.usp.each.wsml2pddl;

import java.net.URL;

import org.apache.abdera.Abdera;
import org.apache.abdera.model.Category;
import org.apache.abdera.model.Document;
import org.apache.abdera.model.Entry;
import org.apache.abdera.model.Feed;
import org.apache.abdera.model.Link;
import org.apache.abdera.parser.Parser;

public class teste {

    private static Abdera abdera = null;

    public static synchronized Abdera getInstance() {
	if (abdera == null) {
	    abdera = new Abdera();
	}
	return abdera;
    }

    public static void main(final String[] args) {
	final Parser parser = getInstance().getParser();

	try {
	    final URL url = new URL(
		    "https://github.com/fpierin/wsml2pddl-web/commits/master.atom");
	    final Document<Feed> doc = parser.parse(url.openStream(),
		    url.toString());
	    final Feed feed = doc.getRoot();
	    // Get the feed title
	    System.out.println("Feed Title: " + feed.getTitle());

	    // Get the entry items...
	    for (final Entry entry : feed.getEntries()) {
		System.out.println("Title: " + entry.getTitle());
		System.out.println("Unique Identifier: "
			+ entry.getId().toString());
		System.out.println("Updated Date: "
			+ entry.getUpdated().toString());
		System.out.println("Published Date: " + entry.getPublished());
		System.out.println("Content: " + entry.getContent());

		// Get the links
		for (final Link link : entry.getLinks()) {
		    System.out.println("Link: " + link.getHref());
		}

		// Get the categories
		for (final Category category : entry.getCategories()) {
		    System.out.println("Category: " + category.getTerm());
		}
	    }
	} catch (final Exception ex) {
	    System.out.println("Error: " + ex.getMessage());
	}
    }

}
