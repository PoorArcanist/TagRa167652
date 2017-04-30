package br.univel.minhaarvore;

import java.util.ArrayList;
import java.util.List;

public class UniNodeImpl<T> implements UniNode<T> {

	private List<UniNode<T>> filhos;
	private T conteudo;
	
	public UniNodeImpl(T t) {
		this.conteudo = t;
	}
	
	@Override
	public T getConteudo() {
		return this.conteudo;
	}

	@Override
	public List<UniNode<T>> getFilhos() {
		return filhos;
	}

	@Override
	public void addFilho(UniNode<T> filho) {
		if (this.filhos == null) {
			this.filhos = new ArrayList<>();
		}
		this.filhos.add(filho);

		
	}

	@Override
	public boolean isLeaf() {
		return this.filhos == null;
	}






}
