package li2.plp.imperative2.projeto;

import li2.plp.expressions1.util.Tipo;
import li2.plp.expressions2.expression.ExpBinaria;
import li2.plp.expressions2.expression.Expressao;
import li2.plp.expressions2.expression.Valor;
import li2.plp.expressions2.memory.AmbienteCompilacao;
import li2.plp.expressions2.memory.AmbienteExecucao;
import li2.plp.expressions2.memory.VariavelJaDeclaradaException;
import li2.plp.expressions2.memory.VariavelNaoDeclaradaException;
import li2.plp.imperative2.command.ListaExpressao;

public class ExpCons extends ExpBinaria {

	/**
	 * Cria uma inst�ncia de ExpCons
	 * 
	 * @param esq -
	 *            express�o � esquerda do operador cons
	 * @param dir -
	 *            express�o � direita do operador cons
	 */
	public ExpCons(Expressao esq, Expressao dir) {
		super(esq, dir, "cons");
	}


	@Override
	protected boolean checaTipoElementoTerminal(AmbienteCompilacao amb)
			throws VariavelNaoDeclaradaException, VariavelJaDeclaradaException {
		boolean result = true;

		Tipo tipoDir = getDir().getTipo(amb);

		if (!tipoDir.eIgual(new TipoLista()))
			return false;

		Tipo tipoEsq = this.getEsq().getTipo(amb);
		if (tipoDir instanceof TipoLista) {
			TipoLista tipoListaDir = (TipoLista) tipoDir;
			return tipoEsq.eIgual(tipoListaDir.getSubTipo());
		}

		return result;

	}

	public Valor avaliar(AmbienteExecucao amb)
			throws VariavelNaoDeclaradaException, VariavelJaDeclaradaException {
		return (new ExpLista((Expressao) this.getEsq(), (ExpLista) this.getDir())).avaliar(amb);
	}

	public Tipo getTipo(AmbienteCompilacao amb)
			throws VariavelNaoDeclaradaException, VariavelJaDeclaradaException {

		return this.getDir().getTipo(amb);
	}
	
	public ExpCons clone() {
		return new ExpCons(this.esq.clone(), this.dir.clone());
	}


}
