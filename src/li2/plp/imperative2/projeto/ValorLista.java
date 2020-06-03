package li2.plp.imperative2.projeto;

import li2.plp.expressions1.util.Tipo;
import li2.plp.expressions1.util.TipoPrimitivo;
import li2.plp.expressions2.expression.Expressao;
import li2.plp.expressions2.expression.Valor;
import li2.plp.expressions2.expression.ValorConcreto;
import li2.plp.expressions2.memory.AmbienteCompilacao;
import li2.plp.imperative1.util.Lista;

/**
 * Este valor primitivo encapsula um String.
 */
public class ValorLista extends ValorConcreto<Lista> {

	/**
	 * cria um objeto encapsulando o String fornecido
	 */
	
	public ValorLista(Lista valor) {
		super(valor);
	}

	/**
	 * Retorna os tipos possiveis desta expressao.
	 * 
	 * @param amb
	 *            o ambiente de compila��o.
	 * @return os tipos possiveis desta expressao.
	 */
	public Tipo getTipo(AmbienteCompilacao amb) {
	//	if(this.valor().getHead() == null) {
	//		return new TipoLista();
	//	}
	//	return new TipoLista((Tipo) this.valor().getHead());
		return new TipoLista();
	}

	@Override
	public String toString() {
		String listaFinal = "[ " ;
		ValorLista copiaValor = this.clone();
		while(copiaValor.valor().getHead() != null) {
			listaFinal += copiaValor.valor().getHead().toString();
			
			if(copiaValor.valor().getTail() != null) {
				copiaValor = new ValorLista(copiaValor.valor().getTail());
				listaFinal += ", ";
			}else {
				copiaValor = new ValorLista(new Lista<Expressao>());
			}
		}
		
		listaFinal += " ]";
		return String.format("\"%s\"", listaFinal);
	}
	
	public ValorLista clone() {
		return new ValorLista(this.valor());
	}
	
	@Override
	public boolean equals(Object o) {
		ValorLista lista1 = (ValorLista) o; 
		ValorLista lista2 = this;
		boolean eIgual;
		
		if(lista1.valor().length() == lista2.valor().length()) {
			eIgual = true;
		}else {
			eIgual = false;
		}
		 
		while(eIgual && lista1.valor() != null  ) {
			eIgual = eIgual && lista1.valor().getHead().equals(lista2.valor().getHead());
			lista1 = new ValorLista(lista1.valor().getTail());
			lista2 = new ValorLista(lista2.valor().getTail());
		}
		
		return eIgual;		
	}

}
















