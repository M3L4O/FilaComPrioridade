package grupo5.filacomprioridade;

import java.util.Scanner;


public class AppProjeto {
	public static void main(String[] args) {
			int escolha = -1;
			String nome = "";
			Scanner scan = new Scanner(System.in);
			FilaComPrioridade prioritario = new FilaComPrioridade();
			FilaComPrioridade normal = new FilaComPrioridade();
			int somador = 0;
			float mediaNormal, mediaPrioritaria;
			
			do {
				System.out.print("1- Inserir pessoa na fila normal;\n2- Inserir pessoa na fila prioritaria;\n3- Atender pessoa ;\n4- Mostrar pessoas na fila;\n5- Gerar estátisticas sobre atendimento;\n0- Sair\n");
				escolha = Integer.parseInt(scan.nextLine());
				
				switch(escolha) {
				case 1:
					System.out.println("Nome?");
					nome = scan.nextLine();
					normal.enqueue(nome);
					break;
					
				case 2:
					System.out.println("Nome?");
					nome = scan.nextLine();
					prioritario.enqueue(nome);
					break;
				
				case 3:
					if(prioritario.getIsEmpty() && !normal.getIsEmpty()) {
						System.out.println(normal.dequeue() + " foi atendido(a).");
					}else if(!prioritario.getIsEmpty()){
						System.out.println(prioritario.dequeue() + " foi atendido(a).");
					}else {
						System.out.println("As filas estão vazias.");
					}
					break;
					
				case 4:
					if(!prioritario.getIsEmpty()) {
						System.out.println("Fila prioritária:\n" + prioritario);
					}else {
						System.out.println("Ninguem está na fila prioritária.");
					}
					System.out.print("\n");
					if(!normal.getIsEmpty()) {
						System.out.println("Fila normal:\n" + normal);
					}else {
						System.out.println("Ninguem está na fila normal.");
					}
					System.out.print("\n");
					break;
				case 5:
					somador = normal.getPessoasAtendidas() + prioritario.getPessoasAtendidas();
					mediaNormal = (float)normal.getPessoasAtendidas()/somador * 100;
					mediaPrioritaria = (float)prioritario.getPessoasAtendidas()/somador * 100;
					System.out.printf("De um total de %d pessoas atendidas, %.2f%% foi na fila normal e %.2f%% foi na fila prioritaria.\n", somador, mediaNormal, mediaPrioritaria);
				case 0:
					if(prioritario.getIsEmpty() && normal.getIsEmpty()) {
						somador = normal.getPessoasAtendidas() + prioritario.getPessoasAtendidas();
						break;
					}else {
						System.out.println("Ainda tem gente na fila.");
						escolha = -1;
						break;
					}
				}
		}while(escolha != 0);
			System.out.println("Foram atendiadas " + somador + " pessoas");
			System.out.println("Programa executado.");
		scan.close();
		
	}
}
		
		
	

