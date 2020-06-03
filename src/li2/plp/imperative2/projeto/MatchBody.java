package li2.plp.imperative2.projeto;

import li2.plp.expressions2.memory.IdentificadorJaDeclaradoException;
import li2.plp.expressions2.memory.IdentificadorNaoDeclaradoException;
import li2.plp.expressions2.memory.VariavelJaDeclaradaException;
import li2.plp.expressions2.memory.VariavelNaoDeclaradaException;
import li2.plp.imperative1.memory.AmbienteCompilacaoImperativa;
import li2.plp.imperative1.memory.EntradaVaziaException;

public class MatchBody {
	
	private ListaPadrao listaPadrao;

	public ListaPadrao getListaPadrao() {
		return listaPadrao;
	}

	public MatchBody(ListaPadrao listaPadrao) {
		this.listaPadrao = listaPadrao;
	}
	
	public boolean checaTipo(AmbienteCompilacaoImperativa ambiente) 
			throws VariavelNaoDeclaradaException, VariavelJaDeclaradaException, 
			IdentificadorJaDeclaradoException, IdentificadorNaoDeclaradoException, 
			EntradaVaziaException {		
		return listaPadrao.checaTipo(ambiente);
	}

}
