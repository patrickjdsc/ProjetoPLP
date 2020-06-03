package li2.plp.imperative2.projeto;

import li2.plp.expressions2.expression.Expressao;
import li2.plp.expressions2.memory.IdentificadorJaDeclaradoException;
import li2.plp.expressions2.memory.IdentificadorNaoDeclaradoException;
import li2.plp.expressions2.memory.VariavelJaDeclaradaException;
import li2.plp.expressions2.memory.VariavelNaoDeclaradaException;
import li2.plp.imperative1.command.Comando;
import li2.plp.imperative1.memory.AmbienteCompilacaoImperativa;
import li2.plp.imperative1.memory.EntradaVaziaException;
import li2.plp.imperative2.command.ListaExpressao;

public class Padrao {
	
	private ListaExpressao listaExpressao;
	private Comando comando;

	public ListaExpressao getListaExpressao() {
		return listaExpressao;
	}

	public Comando getComando() {
		return comando;
	}
	
	public Padrao(ListaExpressao listaExpressao, Comando comando) {
		this.listaExpressao = listaExpressao;
		this.comando = comando;
	}
	
	public boolean checaTipo(AmbienteCompilacaoImperativa ambiente) 
			throws VariavelNaoDeclaradaException, VariavelJaDeclaradaException, 
			IdentificadorJaDeclaradoException, IdentificadorNaoDeclaradoException, 
			EntradaVaziaException {
		return comando.checaTipo(ambiente);
		//return listaExpressao.checaTipo(ambiente) && comando.checaTipo(ambiente);
	}

}
