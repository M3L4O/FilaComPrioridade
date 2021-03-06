
package grupo5.filacomprioridade;

import java.util.NoSuchElementException;
import java.util.Scanner;

import javax.swing.JOptionPane;


public class AppFila {
	public static void main(String[] args) {
			int escolha = -1;
			String nome = "";
			Scanner scan = new Scanner(System.in);
			FilaComPrioridade prioritario = new FilaComPrioridade();
			FilaComPrioridade normal = new FilaComPrioridade();
			int somador = 0;
			float mediaNormal, mediaPrioritaria;
			
			do {
				
				try {
					
					escolha = Integer.parseInt(JOptionPane.showInputDialog(null, "1- Inserir pessoa na fila normal;\n2- Inserir pessoa na fila priorit?ria;\n3- Atender pessoa ;\n4- Mostrar pessoas na fila;\n5- Gerar estat?sticas sobre atendimento;\n0- Sair\n"));
				
				}catch(NumberFormatException exception) {
					
					JOptionPane.showMessageDialog(null, "Digite uma escolha v?lida.", ":(", JOptionPane.ERROR_MESSAGE);
					continue;
				}
				
				
				switch(escolha) {
				case 1:
					
					nome = JOptionPane.showInputDialog(null, "Nome?");
					normal.enqueue(nome);
					break;
					
				case 2:
					nome = JOptionPane.showInputDialog(null, "Nome?");
					prioritario.enqueue(nome);
					break;
				
				case 3:
					
					if(prioritario.isEmpty() && !normal.isEmpty()) {
						
						JOptionPane.showMessageDialog(null, normal.dequeue() + " foi atendido(a).");
						
					}else {
						try {
							
							JOptionPane.showMessageDialog(null,prioritario.dequeue() + " foi atendido(a).");
							
						}catch(NoSuchElementException exception) {
							
							JOptionPane.showMessageDialog(null, "As filas est?o vazias.", ":(", JOptionPane.ERROR_MESSAGE);
							
						}
					}	
					 
					break;
					
				case 4:
					if(!prioritario.isEmpty()) {
						JOptionPane.showMessageDialog(null, "Fila priorit?oria:\n" + prioritario);
					}else {
						JOptionPane.showMessageDialog(null, "Ninguem est?o na fila priorit?ria.");
					}
					System.out.print("\n");
					if(!normal.isEmpty()) {
						JOptionPane.showMessageDialog(null, "Fila normal:\n" + normal);
					}else {
						JOptionPane.showMessageDialog(null, "Ninguem est? na fila normal.");
					}
					System.out.print("\n");
					break;
				case 5:
					somador = normal.getPessoasAtendidas() + prioritario.getPessoasAtendidas();
					mediaNormal = (float)normal.getPessoasAtendidas()/somador * 100;
					mediaPrioritaria = (float)prioritario.getPessoasAtendidas()/somador * 100;
					
					if(somador>0) {
						JOptionPane.showMessageDialog(null,String.format("De um total de %d pessoas atendidas, %.2f%% foi na fila normal e %.2f%% foi na fila priorit?ria.\n", somador, mediaNormal, mediaPrioritaria));
					}else {
						JOptionPane.showMessageDialog(null, "Ningu?m foi atendido ainda.");
					}		
						
					break;
				case 0:
					if(prioritario.isEmpty() && normal.isEmpty()) {
						somador = normal.getPessoasAtendidas() + prioritario.getPessoasAtendidas();
						break;
					}else {
						JOptionPane.showMessageDialog(null,"Ainda tem gente na fila." , ":(", JOptionPane.ERROR_MESSAGE);
						escolha = -1;
						break;
					}
				}
		}while(escolha != 0);
			JOptionPane.showMessageDialog(null,"Foram atendiadas " + somador + " pessoas");
			System.out.println("Programa executado.");
		scan.close();
		
	}
}
		
		
	

