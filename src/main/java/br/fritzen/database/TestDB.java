package br.fritzen.database;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class TestDB {

	public static void main(String[] args) throws IOException, SQLException {
	
		Scanner in = new Scanner(System.in);
		boolean continuar = true;
		
		PersonDao dao = new PersonDao();
		
		while (continuar) {
			
			System.out.println("\n\nBem vindo!!! Selecione a opção desejada");
			System.out.println("1. Inserir dado no banco");
			System.out.println("2. Ver cadastros");
			System.out.println("3. Buscar 1 cadastro");
			System.out.println("4. Remover cadastro");
			System.out.println("5. SAIR");
			System.out.print("\tOpção: ");
			int opcao = in.nextInt();
			
			switch (opcao) {
			
			case 1:
				System.out.print("Digite o ID: ");
				int id = in.nextInt();
				in.nextLine();
				System.out.print("Digite o nome: ");
				String name = in.nextLine();
				Person p = new Person();
				p.setId(id);
				p.setName(name);
				dao.insert(p);
				break;
				
			case 2:
				System.out.println("\nEssa é a atual lista de cadastros:");
				List<Person> pessoas = dao.getAll();
				for (Person pe : pessoas) {
					System.out.println("\t" + pe);
				}
				break;
				
			case 3: 
				System.out.println("Informe o ID: ");
				int idBusca = in.nextInt();
				Person pBusca = dao.getById(idBusca);
				in.nextLine();
				if (pBusca == null) {
					System.out.println("Dado não encontrado!");
				} else {
					System.out.print("Dado encontrado:\n\t" + pBusca + "\nDeseja atualizar (s/n)? ");
					
					if (in.nextLine().toLowerCase().charAt(0) == 's') {
						System.out.print("Digite o novo ID: ");
						int novoId = in.nextInt();
						in.nextLine();
						System.out.print("Digite o novo nome: ");
						String novoName = in.nextLine();
						pBusca.setName(novoName);
						pBusca.setId(novoId);
						dao.update(pBusca, idBusca);
					}
				}
				break;
				
			case 4:
				System.out.println("Informe o ID: ");
				int idRemocao = in.nextInt();
				dao.delete(idRemocao);
				break;
			
			case 5:
				continuar = false;
				break;
				
			default:
				System.out.println("Opção inválida");
			}
			
		}
		
		System.out.println("Obrigado por utilizar este sistema!");
	}

}