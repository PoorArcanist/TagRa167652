package br.univel.minhaarvore;

import java.util.ArrayList;
import java.util.List;

import br.univel.meustestes.Conta;

public class UniArvoreImpl<T> implements UniArvore<T> {

	
	private UniNode<T> raiz;
	
	public UniArvoreImpl(UniNode<T> noRaiz) {
		this.raiz = noRaiz;
	}

	@Override
	public void mostrarTodosConsole() {
		System.out.println(raiz.getConteudo().toString());
		for(int i =0; i<raiz.getFilhos().size();i++){
			System.out.println("\t" + raiz.getFilhos().get(i).getConteudo().toString());
			for(int j=0;j<raiz.getFilhos().get(i).getFilhos().size();j++){
				System.out.println("\t\t"+raiz.getFilhos().get(i).getFilhos().get(j).getConteudo().toString());
			}
		}
	}

	@Override
	public UniNode<T> getRaiz() {
		return raiz;
	}
	
}
