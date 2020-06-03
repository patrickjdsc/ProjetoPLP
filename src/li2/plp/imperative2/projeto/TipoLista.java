package li2.plp.imperative2.projeto;

import li2.plp.expressions1.util.Tipo;
import li2.plp.expressions1.util.TipoPrimitivo;

public class TipoLista implements Tipo {

	private Tipo subTipo;

	public TipoLista() {
		this.subTipo = TipoPrimitivo.INTEIRO;
	}

	public TipoLista(Tipo subTipo) {
		this.subTipo = subTipo;
	}
	
	public Tipo getSubTipo() {
		return subTipo;
	}

	public boolean eBooleano() {
		return false;
	}

	public boolean eIgual(Tipo tipo) {
		if (tipo instanceof TipoLista) {
			TipoLista lista = (TipoLista) tipo;
			return lista.subTipo.eIgual(this.subTipo);
		}

		return tipo.eIgual(this);
	}

	public boolean eInteiro() {
		return false;
	}

	public boolean eString() {
		return false;
	}

	public boolean eValido() {
		return subTipo.eValido();
	}

	public String getNome() {
		return "[" + subTipo.getNome() + "]";
	}

	public Tipo intersecao(Tipo outroTipo) {
		if (outroTipo instanceof TipoLista) {
			TipoLista outraLista = (TipoLista) outroTipo;
			return this.subTipo.intersecao(outraLista.subTipo);
		}

		return outroTipo.intersecao(this);
	}

	@Override
	public String toString() {
		return "[" + subTipo.getNome() + "]";
	}

}
