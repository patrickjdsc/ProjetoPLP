package li2.plp.imperative2.projeto;

import li2.plp.expressions2.expression.Expressao;
import li2.plp.expressions2.expression.Valor;
import li2.plp.expressions2.memory.IdentificadorJaDeclaradoException;
import li2.plp.expressions2.memory.IdentificadorNaoDeclaradoException;
import li2.plp.imperative1.command.Comando;
import li2.plp.imperative1.memory.AmbienteCompilacaoImperativa;
import li2.plp.imperative1.memory.AmbienteExecucaoImperativa;
import li2.plp.imperative1.memory.EntradaVaziaException;
import li2.plp.imperative1.memory.ErroTipoEntradaException;
import li2.plp.imperative1.util.Lista;
import li2.plp.imperative2.command.ListaExpressao;

public class Match implements Comando {
	
	private ListaExpressao listaExpressao;
	private MatchBody matchBody;

	public Match(ListaExpressao listaExpressao, MatchBody matchBody) {
		this.listaExpressao = listaExpressao;
		this.matchBody = matchBody;
	}
	
	public boolean casarPadrao(Padrao padrao, AmbienteExecucaoImperativa ambiente) {
		
		boolean casouPadrao = true;
		Lista<Expressao> le = this.listaExpressao;
		Lista<Expressao> ple = padrao.getListaExpressao();
		
		if(ple.getHead().toString().contentEquals("_") && ple.length() == 1) {
			casouPadrao = true;
		}else {
			if(this.listaExpressao.length() == padrao.getListaExpressao().length()) {
				while(le.length() > 0) {
					boolean any = ple.getHead().toString().contentEquals("_");
					casouPadrao &= any || (le.getHead().avaliar(ambiente)).equals(ple.getHead().avaliar(ambiente));
					ple = ple.getTail();
					le = le.getTail();
				}
			}else {
				casouPadrao = false;
			}
		}
		
		
		return casouPadrao;
	}
	
	private Lista<Padrao> inverter(Lista<Padrao> lp){
		Lista<Padrao> listaAuxiliar = null;
		while(lp != null) {
			listaAuxiliar = new Lista<Padrao>(lp.getHead(), listaAuxiliar);
			lp = lp.getTail();
		}
		return listaAuxiliar;
	}
	
	@Override
	public AmbienteExecucaoImperativa executar(AmbienteExecucaoImperativa ambiente)
			throws IdentificadorJaDeclaradoException, IdentificadorNaoDeclaradoException, EntradaVaziaException,
			ErroTipoEntradaException {
		Lista<Padrao> lp = matchBody.getListaPadrao();		
		lp = inverter(lp);
		while(lp != null) {
			Padrao padrao = lp.getHead();
			if(casarPadrao(padrao, ambiente)) {
				return padrao.getComando().executar(ambiente);
			}		
			lp = lp.getTail();
		}
		
		return ambiente;
	}

	@Override
	public boolean checaTipo(AmbienteCompilacaoImperativa ambiente)
			throws IdentificadorJaDeclaradoException, IdentificadorNaoDeclaradoException, EntradaVaziaException {
		return matchBody.checaTipo(ambiente);
		//return listaExpressao.checaTipo(ambiente) && matchBody.checaTipo(ambiente);
	}

}
