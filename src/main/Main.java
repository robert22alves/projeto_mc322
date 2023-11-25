package main;

import java.util.ArrayList;
import java.util.Scanner;

import pdi_tur.model.pacotes.PacoteViagem;
import pdi_tur.model.pessoas.*;

public class Main {
	static Usuario usuario = null;
	static boolean logado = false;
	static boolean adm = false;
	static int opcao = 0;

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		while (true) {
			if (adm) {
				System.out.println("---- Menu Administrador ----");
				System.out.println();
				System.out.println("1. Adicionar Pacote de Viagem");
				System.out.println("2. Editar Pacote de Viagem");
				System.out.println("2. Remover Pacote de Viagem");
				System.out.println("4. Fechar Sessão");
				System.out.println("5. Sair");
				System.out.println();
				System.out.println();
				System.out.print("Escolha uma opção: ");
				
				opcao = scanner.nextInt();
				scanner.nextLine();

				switch (opcao) {
					case 1:
						adicionarPacote(scanner);
						break;
						
					case 2:
						editarPacote(scanner);
						break;

					case 3:
						removerPacote(scanner);
						return;
					
					case 4:
						System.out.println();
						logado = false;
						adm = false;
						usuario = null;
						break;
						
					case 5:
						scanner.close();
						return;

					default:
						System.out.println("Opção inválida. Por favor, escolha novamente.");
						break;
				}
			}
			else if (logado) {
				System.out.println("---- Turismo e Viagem ----");
				System.out.println();
				System.out.println("1. Buscar Pacote de Viagem");
				System.out.println("2. Ver Reserva");
				System.out.println("3. Editar Informações");
				System.out.println("4. Fechar Sessão");
				System.out.println("5. Sair");
				System.out.println();
				System.out.println();
				System.out.print("Escolha uma opção: ");
				
				opcao = scanner.nextInt();
				scanner.nextLine();

				switch (opcao) {
					case 1:
						buscarPacote(scanner);
						break;
					
					case 2:
						if (usuario.getReserva() == null) {
							System.out.println("Não há Reservas");
						}
						break;
					
					case 3:
						editarUsuario(scanner);
						break;
						
					case 4:
						System.out.println();
						logado = false;
						adm = false;
						usuario = null;
						break;
						
					case 5:
						scanner.close();
						return;
					
					default:
						System.out.println("Opção inválida. Por favor, escolha novamente.");
						break;
				}
			}
			else {
				System.out.println("---- Turismo e Viagem ----");
				System.out.println();
				System.out.println("1. Buscar Pacote de Viagem");
				System.out.println("2. Iniciar Sessão");
				System.out.println("3. Sair");
				System.out.println();
				System.out.println();
				System.out.print("Escolha uma opção: ");
				
				opcao = scanner.nextInt();
				scanner.nextLine();

				switch (opcao) {
					case 1:
						buscarPacote(scanner);
						break;
						
					case 2:
						iniciarSessao(scanner);
						break;
						
					case 3:
						scanner.close();
						return;
					
					default:
						System.out.println("Opção inválida. Por favor, escolha novamente.");
						break;
				}
			}
		}
	}

	public static void iniciarSessao(Scanner scanner) {
		while (true) {
			System.out.println("---- Iniciar Sessão ----");
			System.out.println();
			System.out.println("1. Entrar");
			System.out.println("2. Cadastrar");
			System.out.println("3. Voltar");
			System.out.println();
			System.out.println();
			System.out.print("Escolha uma opção: ");

			opcao = scanner.nextInt();
			scanner.nextLine();

			switch (opcao) {
				case 1:
					//TODO fazer login
					return;
						
				case 2:
					//TODO fazer cadastro
					return;
						
				case 3:
					return;
					
				default:
					System.out.println("Opção inválida. Por favor, escolha novamente.");
					break;
			}
		}
	}

	public static void editarUsuario(Scanner scanner) {
		while (true) {	
			System.out.println("---- Editar Usuario ----");
			System.out.println();
			System.out.println("1. Nome");
			System.out.println("2. Email");
			System.out.println("3. Senha");
			System.out.println("4. Voltar");
			System.out.println();
			System.out.println();
			System.out.print("Escolha uma opção: ");
		
			opcao = scanner.nextInt();
			scanner.nextLine();

			switch (opcao) {
				case 1:
					System.out.print("Novo Nome: ");
					usuario.setNome(scanner.nextLine());
					System.out.println("Nome Alterado");
					break;
						
				case 2:
					System.out.print("Novo Email: ");
					usuario.setEmail(scanner.nextLine());
					System.out.println("Email Alterado");
					break;
						
				case 3:
					System.out.print("Nova Senha: ");
					usuario.setSenha(scanner.nextLine());
					System.out.println("Senha Alterada");
					break;
				
				case 4:
					return;
					
				default:
					System.out.println("Opção inválida. Por favor, escolha novamente.");
					break;
			}
		}
	}

	public static void buscarPacote(Scanner scanner) {
		ArrayList<PacoteViagem> pacotes = listaPacotes(scanner);
		
	}

	public static ArrayList<PacoteViagem> listaPacotes(Scanner scanner){
		System.out.println("---- Encontre o Melhor Pacote para Você ----");
        System.out.print("Origem: ");
		String origem = scanner.nextLine();
		//TODO verificar se existe cidade de origem

		System.out.print("Destino: ");
		String destino = scanner.nextLine();
		//TODO verificar se existe destino

		System.out.println("Datas (dd/mm/aaaa)");
		System.out.print("Ida: ");
		String ida = scanner.nextLine();
		//TODO verificar formatação correta

		System.out.print("Volta: ");
		String volta = scanner.nextLine();
		//TODO verificar formatação correta

		System.out.print("Quantidade de Adultos: ");
		int adultos = scanner.nextInt();
		scanner.nextLine();
		//TODO verificar se é maior que zero

		System.out.print("Quantidade de Crianças: ");
		int criancas = scanner.nextInt();
		scanner.nextLine();

		ArrayList<Integer> idades = null;
		if (criancas != 0) {
			idades = new ArrayList<>();

			for (int i = 0; i < criancas; i++) {
				System.out.print("Idade da Criança: ");
				idades.add(scanner.nextInt());
			}
		}
	
		//TODO gerar uma lista de pacotes de acordo com as informações de busca
		return null;
	}

	public static void adicionarPacote(Scanner scanner) {
		
	}

	public static void editarPacote(Scanner scanner) {
		
	}

	public static void removerPacote(Scanner scanner) {
		
	}
} 