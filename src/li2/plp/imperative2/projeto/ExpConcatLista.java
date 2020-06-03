package li2.plp.imperative2.projeto;

import li2.plp.expressions1.util.Tipo;
import li2.plp.expressions2.expression.ExpBinaria;
import li2.plp.expressions2.expression.Expressao;
import li2.plp.expressions2.expression.Valor;
import li2.plp.expressions2.memory.AmbienteCompilacao;
import li2.plp.expressions2.memory.AmbienteExecucao;
import li2.plp.expressions2.memory.VariavelJaDeclaradaException;
import li2.plp.expressions2.memory.VariavelNaoDeclaradaException;

public class ExpConcatLista extends ExpBinaria {

	public ExpConcatLista(Expressao esq, Expressao dir) {
		super(esq, dir, "concat");
	}

	@Override
	protected boolean checaTipoElementoTerminal(AmbienteCompilacao amb)
			throws VariavelNaoDeclaradaException, VariavelJaDeclaradaException {
		Tipo tipoEsq = getEsq().getTipo(amb);
		Tipo tipoDir = getDir().getTipo(amb);

		return tipoEsq.eIgual(tipoDir);

	}

	public Valor avaliar(AmbienteExecucao amb)
			throws VariavelNaoDeclaradaException, VariavelJaDeclaradaException {
		return (new ExpLista((Expressao) this.getEsq(), (ExpLista) this.getDir())).avaliar(amb);
	}

	
	public Tipo getTipo(AmbienteCompilacao amb)
			throws VariavelNaoDeclaradaException, VariavelJaDeclaradaException {
		return this.getDir().getTipo(amb);
	}
	
	public ExpConcatLista clone() {
		return new ExpConcatLista(this.esq.clone(), this.dir.clone());
	}
}
