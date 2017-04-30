package br.univel.meustestes;

import java.math.BigDecimal;

import br.univel.minhaarvore.UniArvore;
import br.univel.minhaarvore.UniArvoreImpl;
import br.univel.minhaarvore.UniNode;
import br.univel.minhaarvore.UniNodeImpl;

public class Principal {

	public Principal() {
		
		Conta contaAgua = new Conta(1, "�gua", new BigDecimal("196.54"));
		UniNode<Conta> noAgua = new UniNodeImpl<>(contaAgua);
		
		Conta contaAluguel = new Conta(2, "Aluguel", new BigDecimal("652.12"));
		UniNode<Conta> noAlu = new UniNodeImpl<>(contaAluguel);
		
		Conta contaIntTel = new Conta(3, "Internet e Telefone", new BigDecimal("174.95"));
		UniNode<Conta> noIntTel = new UniNodeImpl<>(contaIntTel);
		
		Conta contaEnElet = new Conta(4, "Energia El�trica", new BigDecimal("135.73"));
		UniNode<Conta> noEnElet = new UniNodeImpl<>(contaEnElet);
		
		Conta despesasAdm = new Conta(1, "Despesas Administrativas", new BigDecimal(0));
		UniNode<Conta> noDeAdm = new UniNodeImpl<>(despesasAdm);
		
		noDeAdm.addFilho(noAgua);
		noDeAdm.addFilho(noAlu);
		noDeAdm.addFilho(noIntTel);
		noDeAdm.addFilho(noEnElet);
		
		Conta beneficios = new Conta(1,"Beneficios",new BigDecimal("299.78"));
		UniNode<Conta> noBenef = new UniNodeImpl<>(beneficios);
		
		Conta encargos = new Conta(2,"Encargos",new BigDecimal("274.75"));
		UniNode<Conta> noEncar = new UniNodeImpl<>(encargos);
		
		Conta salarios = new Conta(3,"Salarios",new BigDecimal("197.23"));
		UniNode<Conta> noSal = new UniNodeImpl<>(salarios);
		
		Conta GastosPessoal = new Conta(2,"Gastos com Pessoal", new BigDecimal(0));
		UniNode<Conta> gasPes = new UniNodeImpl<>(GastosPessoal);
		
		gasPes.addFilho(noBenef);
		gasPes.addFilho(noEncar);
		gasPes.addFilho(noSal);
		
		
		Conta servicosLimp = new Conta(1,"Servicos de limpeza",new BigDecimal("134.74"));
		UniNodeImpl<Conta> noLimp = new UniNodeImpl<Conta>(servicosLimp);
		
		Conta servicosManu = new Conta(2,"Servicos de manutencao", new BigDecimal("121.23"));
		UniNodeImpl<Conta> noManu = new UniNodeImpl<Conta>(servicosManu);
		
		Conta ManunELimp = new Conta(3,"Manuntencao e Limpeza", new BigDecimal(0));
		UniNodeImpl<Conta> ManunLimp = new UniNodeImpl<Conta>(ManunELimp);
		
		ManunLimp.addFilho(noLimp);
		ManunLimp.addFilho(noManu);
		
		Conta matEsc = new Conta(1,"Materiais de Escrit�rio",new BigDecimal("170.90"));
		UniNodeImpl<Conta> noMatEsc = new UniNodeImpl<Conta>(matEsc);
		
		Conta matLimp = new Conta(2,"Materiais de Limpeza",new BigDecimal("239.04"));
		UniNodeImpl<Conta> noMatLimp = new UniNodeImpl<Conta>(matLimp);
		
		Conta materiais = new Conta(4,"Materiais",new BigDecimal(0));
		UniNodeImpl<Conta> noMat = new UniNodeImpl<Conta>(materiais);
		
		noMat.addFilho(noMatEsc);
		noMat.addFilho(noMatLimp);
		
		Conta despesasOper = new Conta(1, "Despesas Operacionais", new BigDecimal(0));
		UniNode<Conta> noDeOpr = new UniNodeImpl<>(despesasOper);
		
		noDeOpr.addFilho(noDeAdm);
		noDeOpr.addFilho(gasPes);
		noDeOpr.addFilho(ManunLimp);
		noDeOpr.addFilho(noMat);
		
		UniArvore<Conta> planoContas = new UniArvoreImpl<Conta>(noDeOpr);
		
		//Chamando o m�todo somarFilhos pra atribuir todos os valores aos seus respectivos 'galhos'
		System.out.println("Total do Plano de Contas: R$" + somarFilhos(planoContas.getRaiz()) + "\n\n");
		
		//Printando o Plano de Contas j� com os valores atribuidos
		planoContas.mostrarTodosConsole();
		
		
		// O exerc�cio consiste em identificar a necessidade de
		// novos m�todos para finalizar a tarefa, sempre lembrando
		// de coes�o, acoplamento e encapsulamento.
		// Entrega link do reposit�rio para fernandod@univel.br com assunto:
		// TrabalhoComplementar 3o Sem

		
		
	}
	
	/**
	 * Percorre toda a arvore, recursivamente, encontra
	 * todas as contas anal�ticas (isLeaf() == true), soma
	 * seus valores e atribui o total na conta pai.
	 * 
	 * Depois pega todos os pais e somam no av�.
	 * 
	 * @param planoContas
	 */
	private BigDecimal somarFilhos(UniNode<Conta> noAtual) {
		BigDecimal soma = noAtual.getConteudo().getValor();
		if(!noAtual.isLeaf()){
			for(int i =0;i<noAtual.getFilhos().size();i++){
				 soma = soma.add(somarFilhos(noAtual.getFilhos().get(i)));
				 if(!noAtual.isLeaf())
					 noAtual.getConteudo().setValor(soma);
			}
		}
			return soma;
	}
	

	public static void main(String[] args) {
		
		new Principal();
		
	}
	
}
