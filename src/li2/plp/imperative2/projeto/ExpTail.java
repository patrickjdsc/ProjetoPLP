package li2.plp.imperative2.projeto;

import li2.plp.expressions1.util.Tipo;
import li2.plp.expressions2.expression.ExpUnaria;
import li2.plp.expressions2.expression.Expressao;
import li2.plp.expressions2.expression.Valor;
import li2.plp.expressions2.memory.AmbienteCompilacao;
import li2.plp.expressions2.memory.AmbienteExecucao;
import li2.plp.expressions2.memory.VariavelJaDeclaradaException;
import li2.plp.expressions2.memory.VariavelNaoDeclaradaException;

public class ExpTail extends ExpUnaria {

	public ExpTail(Expressao exp) {
		super(exp, "tail");
	}

	protected boolean checaTipoElementoTerminal(AmbienteCompilacao amb)
			throws VariavelNaoDeclaradaException, VariavelJaDeclaradaException {		
		return getExp().checaTipo(amb);			
	}

	public Valor avaliar(AmbienteExecucao amb)
			throws VariavelNaoDeclaradaException, VariavelJaDeclaradaException {
		
		ValorLista lista = (ValorLista) this.getExp().avaliar(amb);
		
		return new ValorLista(lista.valor().getTail());
		
	}


	public Tipo getTipo(AmbienteCompilacao amb)
			throws VariavelNaoDeclaradaException, VariavelJaDeclaradaException {		
		return this.getExp().getTipo(amb);
	}

	@Override
	public ExpTail clone() {
		return new ExpTail(this.exp.clone());
	}

}
