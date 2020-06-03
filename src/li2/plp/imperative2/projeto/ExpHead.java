package li2.plp.imperative2.projeto;

import li2.plp.expressions1.util.Tipo;
import li2.plp.expressions2.expression.ExpUnaria;
import li2.plp.expressions2.expression.Expressao;
import li2.plp.expressions2.expression.Valor;
import li2.plp.expressions2.memory.AmbienteCompilacao;
import li2.plp.expressions2.memory.AmbienteExecucao;
import li2.plp.expressions2.memory.VariavelJaDeclaradaException;
import li2.plp.expressions2.memory.VariavelNaoDeclaradaException;

public class ExpHead extends ExpUnaria {

	public ExpHead(Expressao retorno) {
		super(retorno, "head");
	}

	@Override
	public Valor avaliar(AmbienteExecucao amb) throws VariavelNaoDeclaradaException, VariavelJaDeclaradaException {
		return ((Valor)((ValorLista) getExp().avaliar(amb)).valor().getHead());
	}

	@Override
	public Tipo getTipo(AmbienteCompilacao amb) throws VariavelNaoDeclaradaException, VariavelJaDeclaradaException {
		Tipo tipoExp = getExp().getTipo(amb);
		if(tipoExp instanceof TipoLista) {
			tipoExp = ((TipoLista) tipoExp).getSubTipo();
		}
		return tipoExp;
	}

	@Override
	protected boolean checaTipoElementoTerminal(AmbienteCompilacao amb)
			throws VariavelNaoDeclaradaException, VariavelJaDeclaradaException {
		/*Tipo tipoExp = getExp().(amb);
		return tipoExp.eIgual(new TipoLista());*/
		return getExp().checaTipo(amb);
	}

	@Override
	public ExpUnaria clone() {
		return new ExpHead(this.exp.clone());
	}


}
