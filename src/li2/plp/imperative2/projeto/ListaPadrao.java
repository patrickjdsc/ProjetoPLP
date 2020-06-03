package li2.plp.imperative2.projeto;

import li2.plp.expressions2.memory.IdentificadorJaDeclaradoException;
import li2.plp.expressions2.memory.IdentificadorNaoDeclaradoException;
import li2.plp.expressions2.memory.VariavelJaDeclaradaException;
import li2.plp.expressions2.memory.VariavelNaoDeclaradaException;
import li2.plp.imperative1.memory.AmbienteCompilacaoImperativa;
import li2.plp.imperative1.memory.EntradaVaziaException;
import li2.plp.imperative1.util.Lista;

public class ListaPadrao extends Lista<Padrao>{
		
	public ListaPadrao() {
	}
	
	public ListaPadrao(Padrao padrao) {
		super(padrao, null);
	}

	public ListaPadrao(Padrao padrao, ListaPadrao listaPadrao) {
		super(padrao, listaPadrao);
	}

	public boolean checaTipo(AmbienteCompilacaoImperativa ambiente) 
			throws VariavelNaoDeclaradaException, VariavelJaDeclaradaException, 
			IdentificadorJaDeclaradoException, IdentificadorNaoDeclaradoException, 
			EntradaVaziaException {
		boolean resposta;
		if (getHead() != null) {
			if (getTail() != null) {
				resposta = getHead().checaTipo(ambiente)
						&& ((ListaPadrao) getTail())
								.checaTipo(ambiente);
			} else {
				resposta = getHead().checaTipo(ambiente);
			}
		} else {
			resposta = true;
		}
		return resposta;
	}
}
