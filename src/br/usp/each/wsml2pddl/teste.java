package br.usp.each.wsml2pddl;

import br.usp.each.wsml2pddl.modelo.sistema.Compilador;
import br.usp.each.wsml2pddl.sistema.CompiladorWsmlPDDL;

public class teste {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final String parameter = "concept x";
		Compilador compilador = new CompiladorWsmlPDDL();
		System.out.println(compilador.compila(parameter));

	}

}
