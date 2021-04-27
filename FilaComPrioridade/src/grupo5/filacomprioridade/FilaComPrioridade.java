package grupo5.filacomprioridade;

import java.util.NoSuchElementException;

public class FilaComPrioridade {
	private boolean isEmpty;
	private Node inicio;
	private Node fim;
	private int pessoasAtendidas = 0, tam = 0;
	
	private class Node{
		private Node prox = null;
		private String nome = "";
	}
	
	public FilaComPrioridade() {
		 isEmpty = true;
		 inicio = null;
		 fim = null;
	}
	public boolean getIsEmpty() {
		return this.isEmpty;
	}
	
	public int getPessoasAtendidas() {
		return this.pessoasAtendidas;
	}
	
	public int size() {
		return tam;
	}
	
	public void enqueue(String nome) {
		Node elem = new Node();
		elem.nome = nome;
		tam++;
		if(inicio == null) {
			inicio = elem;
			fim = elem;
		}else {
			fim.prox = elem;
			fim = elem;
		}
		isEmpty = false;
		
	}
	
	public String dequeue() throws NoSuchElementException{
		String nome;
		nome = inicio.nome;
		inicio = inicio.prox;
		if(inicio == null) {
			isEmpty = true;
		}
		pessoasAtendidas++;
		return nome;
	}
	
	@Override
	public String toString() {
		StringBuilder nomes = new StringBuilder();
		
		Node aux;
		for(aux = inicio; aux != null; aux = aux.prox) {
			nomes.append(aux.nome + " <-- ");
		}
		
		return nomes.toString();
	}
}
