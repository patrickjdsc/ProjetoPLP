package li2.plp.imperative2.projeto;

import li2.plp.expressions1.util.Tipo;
import li2.plp.expressions2.expression.Expressao;
import li2.plp.expressions2.expression.Valor;
import li2.plp.expressions2.memory.AmbienteCompilacao;
import li2.plp.expressions2.memory.AmbienteExecucao;
import li2.plp.expressions2.memory.VariavelJaDeclaradaException;
import li2.plp.expressions2.memory.VariavelNaoDeclaradaException;
import li2.plp.imperative1.util.Lista;

public class ExpLista implements Expressao {

	private Expressao head;
	private ExpLista tail;
	
	public Expressao getHead() {
		return head;
	}

	public ExpLista getTail() {
		return tail;
	}
	
	public ExpLista() {
		this.head = null;
		this.tail = null;
	}
	
	public ExpLista(Expressao head) {
		
		this.head = head;
		this.tail = null;
	}
	
	public ExpLista(Expressao head, ExpLista tail) {
		
		this.head = head;
		this.tail = tail;
	}
	
/*	

	public Expressao inverter() {
		// TODO Auto-generated method stub
		return null;
	}
*/
	public ExpLista cons(Expressao v) {
		return new ExpLista(v, this);
	}

	@Override
	public Valor avaliar(AmbienteExecucao amb) throws VariavelNaoDeclaradaException, VariavelJaDeclaradaException {
		ExpLista tailCopia = this.tail;
		Lista<Expressao> lista = new Lista<Expressao>(getHead(), null);
		while(tailCopia != null) {
			lista = new Lista<Expressao>(tailCopia.getHead().avaliar(amb), lista);
			tailCopia = tailCopia.getTail();			
		}
		
		return new ValorLista(lista);
	}

	@Override
	public boolean checaTipo(AmbienteCompilacao amb)
			throws VariavelNaoDeclaradaException, VariavelJaDeclaradaException {
		boolean bemTipado = true;
		if(getHead() != null) {
			bemTipado = getHead().checaTipo(amb);
			if(getTail() != null) {
				bemTipado = getTail().checaTipo(amb) && (getHead().getTipo(amb).eIgual(getTail().getHead().getTipo(amb))) ;
			}
		}
		
		return bemTipado;
	}

	@Override
	public Tipo getTipo(AmbienteCompilacao amb) throws VariavelNaoDeclaradaException, VariavelJaDeclaradaException {		
		if(this.getHead() == null) {
			return new TipoLista();
		}
		return new TipoLista(this.getHead().getTipo(amb));
	}

	@Override
	public Expressao reduzir(AmbienteExecucao ambiente) {
		this.head.reduzir(ambiente);
		this.tail.reduzir(ambiente);
		return this;
	}

	@Override
	public Expressao clone() {
		return new ExpLista(getHead(), getTail());
	}

}
