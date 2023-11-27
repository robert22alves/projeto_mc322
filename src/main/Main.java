package main;

import java.util.ArrayList;
import java.util.Scanner;

import pdi_tur.controller.*;
import pdi_tur.model.pacotes.Aventura;
import pdi_tur.model.pacotes.Cultura;
import pdi_tur.model.pacotes.PacoteViagem;
import pdi_tur.model.pacotes.Relaxamento;
import pdi_tur.model.pessoas.*;
import pdi_tur.model.passagemAerea.*;
import pdi_tur.model.hospedagem.*;
import pdi_tur.model.destino.CategoriasDestino;
import pdi_tur.model.destino.Destino;
import pdi_tur.model.diversos.*;
import pdi_tur.view.*;

public class Main {
	static UsuarioController usuarioController = new UsuarioControllerImpl();
	static PacoteController pacoteController = new PacoteControllerImpl();
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
				System.out.println("3. Remover Pacote de Viagem");
				System.out.println("4. Cadastrar Adm");
				System.out.println("5. Registrar Cidade");
				System.out.println("6. Fechar Sessão");
				System.out.println("7. Sair");
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
						System.out.println("Cadastrar Adm");
						System.out.print("Usuario: ");
						String login = scanner.nextLine();
						System.out.print("Senha: ");
						String senha = scanner.nextLine();
						System.out.print("Email: ");
						String email = scanner.nextLine();
						System.out.println();

						Usuario temp = new Usuario(login, email, senha, TipoUsuario.ADMINISTRADOR);

						if (usuarioController.cadastrar(temp)) {
							System.out.print("Administrador Cadastrado\n");
							break;
						}

						System.out.print("Não é possível cadastrar com essas informações\n");
						break;

					case 5:
					registrarCidade(scanner);
						break;
					case 6:
						System.out.println();
						logado = false;
						adm = false;
						usuario = null;
						break;
						
					case 7:
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
							break;
						}
						detalhesPacote(scanner, usuario.getReserva());
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

			String login, senha, email;

			switch (opcao) {
				case 1:
					System.out.println();
					System.out.print("Usuario: ");
					login = scanner.nextLine();
					System.out.print("Senha: ");
					senha = scanner.nextLine();
					System.out.println();

					usuario = usuarioController.signup(login, senha);
					if (usuario == null) {
						System.out.print("Usuario ou Senha incorretos\n");
						break;
					}

					logado = true;
					if (usuario.getTipo() == TipoUsuario.ADMINISTRADOR) {
						adm = true;
					}
					return;
						
				case 2:
					System.out.println();
					System.out.print("Usuario: ");
					login = scanner.nextLine();
					System.out.print("Senha: ");
					senha = scanner.nextLine();
					System.out.print("Email: ");
					email = scanner.nextLine();
					System.out.println();

					Usuario temp = new Usuario(login, email, senha, TipoUsuario.CLIENTE);

					if (usuarioController.cadastrar(temp)) {
						System.out.print("Usuário Cadastrado\n");
						usuario = temp;
						return;
					}

					System.out.print("Não é possível cadastrar com essas informações\n");
					break;
						
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
	
	public static PacoteViagem devolverPacote(Scanner scanner, ArrayList<PacoteViagem> pacotes) {
		System.out.println("Lista de pacotes encontrados:");
		System.out.println();
		
		PacoteView.printPacotes(pacotes);
		
		System.out.println();
		System.out.println("Qual pacote deseja escolher? (Digite número 1,2,3...");
		System.out.println("Digite 0 para voltar");

		int numPacote = scanner.nextInt();

		if (numPacote != 0){
			PacoteViagem temp = pacotes.get(numPacote-1);
			return temp;
		}
		return null;
	}

	public static void buscarPacote(Scanner scanner) {
		ArrayList<PacoteViagem> pacotes = listaPacotes(scanner);
		if (pacotes == null) {
			return;
		}
		pacotes = calcularPreco(scanner, pacotes);
		
		PacoteViagem temp = devolverPacote(scanner, pacotes);
		if (temp == null) {
			return;
		}

		detalhesPacote(scanner, temp);
		
		System.out.println("Deseja reservar o Pacote? ('Sim' ou 'Não'");
		System.out.println();
		
		String opcaoS = scanner.nextLine();
		
		switch(opcaoS) {
		case "Sim":
			if(logado) {
				usuario.setReserva(temp);
				temp.setReservado(true);
				System.out.println("Pacote Reservado");
				System.out.println();
				return;
				
			}

			System.out.println("Faça login primeiro");
			iniciarSessao(scanner);
			System.out.println();
			
			if(logado) {
				usuario.setReserva(temp);
				temp.setReservado(true);
				System.out.println("Pacote Reservado");
				System.out.println();
				return;
				
			}
			return;
			
		case "Não":
			return;
			
		default:
			System.out.println("Opção inválida. Por favor, escolha novamente.");
			break;
		}

	}

	public static void detalhesPacote(Scanner scanner, PacoteViagem temp) {
		while(true) {
		System.out.println("Pacote escolhido");
		System.out.println();
		System.out.println("1. Visualizar Hospedagem do Pacote");
		System.out.println("2. Visualizar Serviços do Pacote");
		System.out.println("3. Visualizar Quarto do Pacote");
		System.out.println("4. Visualizar informações do Voo do Pacote");
		System.out.println("5. Visualizar informações de Bagagem do Pacote");
		System.out.println("6. Sair");
		System.out.println();
		System.out.println();
		System.out.print("Escolha uma opção: ");
		
		opcao = scanner.nextInt();
		scanner.nextLine();
		
		switch(opcao) {
		case 1:
			PacoteView.printHospedagem(temp);
			break;
			
		case 2:
			PacoteView.printServicosH(temp);
			break;
			
		case 3:
			PacoteView.printQuarto(temp);
			break;
			
		case 4:
			PacoteView.printVoo(temp);
			break;
			
		case 5:
			PacoteView.printBagagens(temp);
			break;
			
		case 6:
			return;
			
		default:
			System.out.println("Opção inválida. Por favor, escolha novamente.");
			break;
			
		}
		}
	}

	public static ArrayList<PacoteViagem> listaPacotes(Scanner scanner){
		System.out.println("---- Encontre o Melhor Pacote para Você ----");
        System.out.print("Origem: ");
		String origem = scanner.nextLine();
		if (pacoteController.buscarCidade(origem) == null) {
			System.out.println("Cidade não Cadastrada");
			return null;
		}
		origem = pacoteController.buscarCidade(origem).getAeroporto();

		System.out.print("Destino: ");
		String destino = scanner.nextLine();
		if (pacoteController.buscarCidade(destino) == null) {
			System.out.println("Cidade não Cadastrada");
			return null;
		}
		destino = pacoteController.buscarCidade(destino).getAeroporto();

		System.out.println("Datas (dd/mm/aaaa)");
		System.out.print("Ida: ");
		Data ida = Data.newData(scanner.nextLine());

		System.out.print("Volta: ");
		Data volta = Data.newData(scanner.nextLine());

		return pacoteController.buscar(origem, destino, ida, volta);
	}

	public static ArrayList<PacoteViagem> calcularPreco(Scanner scanner, ArrayList<PacoteViagem> pacotes) {
		System.out.print("Quantidade de Adultos: ");
		int adultos = scanner.nextInt();
		scanner.nextLine();

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

		for (PacoteViagem pacote : pacotes) {
			pacote.calcularPreco(adultos, criancas, idades);
		}

		return pacotes;
	}

	public static void adicionarPacote(Scanner scanner) {
		System.out.println("Adicionar Pacote");
		System.out.println();
		
		System.out.print("Passagem Aérea = ");
		System.out.println();
		
		System.out.print("Companhia Aérea - ");
		System.out.println();
		System.out.print("Qual seria a Companhia Aérea? (Digite o Nome)");
		String companhiaAerea = scanner.nextLine();
		
		System.out.print("Opçoes de Bagagem - ");
		System.out.println();
		
		System.out.println("Mochila? ('Sim' ou 'Não')");
		System.out.println();
		
		String opcaoS = scanner.nextLine();
		boolean op1 = false, op2 = false, op3 = false;
		
		if(opcaoS == "Sim") {
			op1 = true;
		}
		
		System.out.println("Bagagem à mão? ('Sim' ou 'Não')");
		System.out.println();
		
		opcaoS = scanner.nextLine();
		
		if(opcaoS == "Sim") {
			op2 = true;
		}
		
		System.out.println("Bagagem para despachar? ('Sim' ou 'Não')");
		System.out.println();
		
		opcaoS = scanner.nextLine();
		
		if(opcaoS == "Sim") {
			op3 = true;
		}
		
		Bagagens bagagem = new Bagagens(op1, op2, op3);
		
		System.out.println("Voo Ida - ");
		System.out.println();
		
		System.out.println("Qual seria dia, mês e ano de saída de Ida? (DD/MM/AA)");
		System.out.println();
		
		String saidaDate = scanner.nextLine();
		
		Data saida= Data.newData(saidaDate);
		
		System.out.println("Qual seria dia, mês e ano de chegada de Ida? (DD/MM/AA)");
		System.out.println();
		
		String chegadaDate = scanner.nextLine();
		
		Data chegada = Data.newData(chegadaDate);
		
		System.out.println("Qual seria horário de saída de Ida? (HH:MM)");
		System.out.println();
		
		String saidaHor = scanner.nextLine();
		
		Horario horaSaida= Horario.newHorario(saidaHor);
		
		System.out.println("Qual seria horário de chegada de Ida? (HH:MM)");
		System.out.println();
		
		String chegadaHor = scanner.nextLine();
		
		Horario horaChegada = Horario.newHorario(chegadaHor);
		
		System.out.println("Qual seria duração do voo? (HH:MM)");
		System.out.println();
		
		String duracaoVooHor = scanner.nextLine();
		
		Horario DuracaoVoo = Horario.newHorario(duracaoVooHor);
		
		System.out.println("Qual ID do Voo?");
		System.out.println();
		
		String idVoo = scanner.nextLine();
		
		System.out.println("Qual seria cidade de saída?");
		System.out.println();
		
		String cidadeSaida = scanner.nextLine();
		
		System.out.println("Qual seria aeroporto de saída?");
		System.out.println();
		
		String aeroportoSaida = scanner.nextLine();
		
		Aeroporto aeroportoS = new Aeroporto(cidadeSaida, aeroportoSaida);
		
		System.out.println("Qual seria cidade de chegada?");
		System.out.println();
		
		String cidadeChegada = scanner.nextLine();
		
		System.out.println("Qual seria aeroporto de chegada?");
		System.out.println();
		
		String aeroportoChegada = scanner.nextLine();
		
		Aeroporto aeroportoC = new Aeroporto(cidadeChegada, aeroportoChegada);
		
		Voo vooIda = new Voo(saida, chegada, horaSaida, horaChegada, DuracaoVoo, idVoo, aeroportoS, aeroportoC);
		
		System.out.println("Voo Volta - ");
		System.out.println();
		
		System.out.println("Qual seria dia, mês e ano de saída de Ida? (DD/MM/AA)");
		System.out.println();
		
		saidaDate = scanner.nextLine();
		
		saida= Data.newData(saidaDate);
		
		System.out.println("Qual seria dia, mês e ano de chegada de Ida? (DD/MM/AA)");
		System.out.println();
		
		chegadaDate = scanner.nextLine();
		
		chegada = Data.newData(chegadaDate);
		
		System.out.println("Qual seria horário de saída de Ida? (HH:MM)");
		System.out.println();
		
		saidaHor = scanner.nextLine();
		
		horaSaida = Horario.newHorario(saidaHor);
		
		System.out.println("Qual seria horário de chegada de Ida? (HH:MM)");
		System.out.println();
		
		chegadaHor = scanner.nextLine();
		
		horaChegada = Horario.newHorario(chegadaHor);
	
		System.out.println("Qual seria duração do voo? (HH:MM)");
		System.out.println();
		
		duracaoVooHor = scanner.nextLine();
		
		DuracaoVoo = Horario.newHorario(duracaoVooHor);
		
		System.out.println("Qual ID do Voo?");
		System.out.println();
		
		idVoo = scanner.nextLine();
		
		System.out.println("Qual seria cidade de saída?");
		System.out.println();
		
		cidadeSaida = scanner.nextLine();
		
		System.out.println("Qual seria aeroporto de saída?");
		System.out.println();
		
		aeroportoSaida = scanner.nextLine();
		
		aeroportoS = new Aeroporto(cidadeSaida, aeroportoSaida);
		
		System.out.println("Qual seria cidade de chegada?");
		System.out.println();
		
		cidadeChegada = scanner.nextLine();
		
		System.out.println("Qual seria aeroporto de chegada?");
		System.out.println();
		
		aeroportoChegada = scanner.nextLine();
		
		aeroportoC = new Aeroporto(cidadeChegada, aeroportoChegada);
		
		Voo vooVolta = new Voo(saida, chegada, horaSaida, horaChegada, DuracaoVoo, idVoo, aeroportoS, aeroportoC);
		
		PassagemAerea passagemAerea = null;
		
		while(true) {
			System.out.println("Classe de Voo:");
			System.out.println();
			System.out.println("1. Economica");
			System.out.println("2. Executiva");
			System.out.println("3. Primeira Classe");
			System.out.println();
			System.out.println();
			System.out.print("Escolha uma opção: ");

			opcao = scanner.nextInt();
			scanner.nextLine();
			
			if (opcao == 1) {
				passagemAerea = new PassagemAerea(companhiaAerea, ClasseVoo.ECONOMICA, vooIda, vooVolta, bagagem);
				break;
			} else if (opcao == 2) {
				passagemAerea = new PassagemAerea(companhiaAerea, ClasseVoo.EXECUTIVA, vooIda, vooVolta, bagagem);
				break;
			} else if (opcao == 3){
				passagemAerea = new PassagemAerea(companhiaAerea, ClasseVoo.PRIMEIRACLASSE, vooIda, vooVolta, bagagem);
				break;
			} else {
				System.out.println("Opção inválida. Por favor, escolha novamente.");
				break;	
			}
		}
		
		System.out.print("Hospedagem = ");
		System.out.println();
		
		System.out.print("Nome:");
		System.out.println();
		
		String nomeHospedagem = scanner.nextLine();
		
		System.out.print("Endereço:");
		System.out.println();
		
		String enderecoHospedagem = scanner.nextLine();
		
		System.out.print("Localização:");
		System.out.println();
		
		String localizacaoHospedagem = scanner.nextLine();
		
		System.out.print("Distância do Centro:");
		System.out.println();
		
		String distanciaCentroHospedagem = scanner.nextLine();
		
		System.out.print("Classificação:");
		System.out.println();
		
		int classificacaoHospedagem = scanner.nextInt();
		scanner.nextLine();
		
		System.out.println("Qual seria horário de check-in? (HH:MM)");
		System.out.println();
		
		String checkinHor = scanner.nextLine();
		
		Horario horaCheckin = Horario.newHorario(checkinHor);
		
		System.out.println("Qual seria horário de check-out? (HH:MM)");
		System.out.println();
		
		String checkoutHor = scanner.nextLine();
		
		Horario horaCheckout = Horario.newHorario(checkoutHor);
		
		Servicos servicos = listaServicos(scanner);
		
		Hospedagem hospedagem = new Hospedagem (nomeHospedagem, enderecoHospedagem, localizacaoHospedagem, distanciaCentroHospedagem, classificacaoHospedagem, horaCheckin, horaCheckout, servicos);
		
		System.out.print("Quarto = ");
		System.out.println();
		
		System.out.print("Tipo:");
		System.out.println();
		
		String tipoQuarto = scanner.nextLine();
		
		System.out.print("Quantidade cama casal:");
		System.out.println();
		
		int camaCasal = scanner.nextInt();
		scanner.nextLine();
		
		System.out.print("Quantidade cama individual:");
		System.out.println();
		
		int camaIndividual = scanner.nextInt();
		scanner.nextLine();
		
		System.out.print("Quantidade cama para bebês:");
		System.out.println();
		
		int camaBebe = scanner.nextInt();
		scanner.nextLine();
		
		System.out.print("Área do quarto:");
		System.out.println();
		
		int superficie = scanner.nextInt();
		scanner.nextLine();
		
		ArrayList<String> detalhes = new ArrayList<>();
		
		System.out.print("O quarto possui detalhes? TV de tela plana, Ar condicionado, Frigobar, Aquecimento, Wi-Fi grátis...('Sim' ou 'Não'):");
		System.out.println();
		
		opcaoS = scanner.nextLine();
		
		String detalhe;
		
		Quarto quarto = null;
		
		if(opcaoS == "Não") {
			quarto = new Quarto (tipoQuarto, camaCasal, camaIndividual, camaBebe, superficie, new ArrayList<>());
		}else if(opcaoS == "Sim") {
			System.out.print("Qual detalhe?");
			System.out.println();
			
			detalhe = scanner.nextLine();
			
			detalhes.add(detalhe);
			
			while(true) {
				System.out.print("Possui mais detalhes? ('Sim' ou 'Não')");
				System.out.println();
				
				opcaoS = scanner.nextLine();
				
				if(opcaoS == "Sim") {
					System.out.print("Qual detalhe?");
					System.out.println();
					
					detalhe = scanner.nextLine();
					
					detalhes.add(detalhe);
					
				}else if(opcaoS == "Não") {
					quarto = new Quarto (tipoQuarto, camaCasal, camaIndividual, camaBebe, superficie, detalhes);
					break;
					
				}
			}
		}
		
		System.out.print("Destino = ");
		System.out.println();
		
		System.out.print("Qual o destino?");
		System.out.println();
		
		String destinoNome = scanner.nextLine();
		
		Destino destino;
		
		while(true) {
			System.out.println("Categorias destino:");
			System.out.println();
			System.out.println("1. Praia");
			System.out.println("2. Montanha");
			System.out.println("3. Cidade");
			System.out.println("4. Savana");
			System.out.println("5. Resort");
			System.out.println();
			System.out.println();
			System.out.print("Escolha uma opção: ");
			
			opcao = scanner.nextInt();
			scanner.nextLine();
			
			if (opcao == 1) {
				destino = new Destino(destinoNome, CategoriasDestino.PRAIA);
				break;
			} else if (opcao == 2) {
				destino = new Destino(destinoNome, CategoriasDestino.MONTANHA);
				break;
			} else if (opcao == 3) {
				destino = new Destino(destinoNome, CategoriasDestino.CIDADE);
				break;
			} else if (opcao == 4) {
				destino = new Destino(destinoNome, CategoriasDestino.SAVANA);
				break;
			} else if (opcao == 5) {
				destino = new Destino(destinoNome, CategoriasDestino.RESORT);
				break;
			} else {
				System.out.println("Opção inválida. Por favor, escolha novamente.");
			}	
		}
		
		System.out.print("Qual o preço por pessoa? ");
		System.out.println();
		
		Double precopp = scanner.nextDouble();
		
		while(true) {
			System.out.println("Categorias Pacote de Viagem:");
			System.out.println();
			System.out.println("1. Aventura");
			System.out.println("2. Relaxamento");
			System.out.println("3. Cultura");
			System.out.println();
			System.out.println();
			System.out.print("Escolha uma opção: ");
			
			opcao = scanner.nextInt();
			scanner.nextLine();
			
			ArrayList<String> coisas = new ArrayList<>();
			
			if (opcao == 1) {
				System.out.print("Digite uma atividade do pacote:");
				System.out.println();
				
				opcaoS = scanner.nextLine();
				
				coisas.add(opcaoS);
				
				while(true) {
					System.out.print("Mais atividades? ('Sim' ou 'Não')");
					System.out.println();
					
					opcaoS = scanner.nextLine();
					
					if(opcaoS == "Sim") {
						System.out.print("Digite a atividade:");
						System.out.println();
						
						opcaoS = scanner.nextLine();
						
						coisas.add(opcaoS);
					}else if(opcaoS == "Não") {
						break;
					}
				}
				
				Aventura pacoteAventura = new Aventura(passagemAerea, hospedagem, quarto, destino, precopp, coisas);		
				pacoteController.adicionar(pacoteAventura);
				
				break;
			} else if (opcao == 2) {
				Relaxamento pacoteRelaxamento = new Relaxamento(passagemAerea, hospedagem, quarto, destino, precopp);
				pacoteController.adicionar(pacoteRelaxamento);
				
				break;
			} else if (opcao == 3) {
				System.out.print("Possui guia turístico? ('Sim' ou 'Não')");
				System.out.println();
				
				opcaoS = scanner.nextLine();
				
				boolean guia = false;
				
				if(opcaoS == "Sim") {
					guia = true;
				}
				
				System.out.print("Digite um Ponto Turístico do pacote:");
				System.out.println();
				
				opcaoS = scanner.nextLine();
				
				coisas.add(opcaoS);
				
				while(true) {
					System.out.print("Mais pontos turísticos? ('Sim' ou 'Não')");
					System.out.println();
					
					opcaoS = scanner.nextLine();
					
					if(opcaoS == "Sim") {
						System.out.print("Digite o Ponto Turístico:");
						System.out.println();
						
						opcaoS = scanner.nextLine();
						
						coisas.add(opcaoS);
					}else if(opcaoS == "Não") {
						break;
					}
				}
				
				Cultura pacoteCultura = new Cultura(passagemAerea, hospedagem, quarto, destino, precopp, guia, coisas);
				pacoteController.adicionar(pacoteCultura);
				
				break;
			} else {
				System.out.println("Opção inválida. Por favor, escolha novamente.");
			}
		}
	}
	
	public static Servicos listaServicos(Scanner scanner){
		System.out.println("-- Criação de lista de Serviços do Hotel--");
		System.out.println();
		
		Servicos servicos = new Servicos();
		String opcaoS;
		String servico;

		System.out.println("Lazer ou Diversão? Piscina climatizada, Mesa de sinuca, Salão de jogos, TV nas áreas comuns...");
		System.out.print("'Sim' ou 'Não':");
		opcaoS = scanner.nextLine();
		System.out.println();
		
		if(opcaoS == "Sim") {
			System.out.println("Qual serviço? (Digite 1)");
			servico = scanner.nextLine();
			System.out.println();
			
			servicos.getLazer().add(servico);
			
			while(true) {
				System.out.println("Possui mais serviços? ('Sim' ou 'Não')");
				opcaoS = scanner.nextLine();
				System.out.println();
				
				if(opcaoS == "Sim") {
					System.out.println("Qual serviço?");
					servico = scanner.nextLine();
					System.out.println();
					
					servicos.getLazer().add(servico);
					
				}else if(opcaoS == "Não") {
					break;
				}
			}
		}

		System.out.println("Bem-Estar? Academia, Sauna, Hidromassagem...");
		System.out.print("'Sim' ou 'Não':");
		opcaoS = scanner.nextLine();
		System.out.println();
		
		if(opcaoS == "Sim") {
			System.out.println("Qual serviço? (Digite 1)");
			servico = scanner.nextLine();
			System.out.println();
			
			servicos.getBemEstar().add(servico);
			
			while(true) {
				System.out.println("Possui mais serviços? ('Sim' ou 'Não')");
				opcaoS = scanner.nextLine();
				System.out.println();
				
				if(opcaoS == "Sim") {
					System.out.println("Qual serviço?");
					servico = scanner.nextLine();
					System.out.println();
					
					servicos.getBemEstar().add(servico);
					
				}else if(opcaoS == "Não") {
					break;
				}
			}
		}

		System.out.println("Para Crianças? Piscina Infantil, Espaço Kids...");
		System.out.print("'Sim' ou 'Não':");
		opcaoS = scanner.nextLine();
		System.out.println();
		
		if(opcaoS == "Sim") {
			System.out.println("Qual serviço? (Digite 1)");
			servico = scanner.nextLine();
			System.out.println();
			
			servicos.getParaCriancas().add(servico);
			
			while(true) {
				System.out.println("Possui mais serviços? ('Sim' ou 'Não')");
				opcaoS = scanner.nextLine();
				System.out.println();
				
				if(opcaoS == "Sim") {
					System.out.println("Qual serviço?");
					servico = scanner.nextLine();
					System.out.println();
					
					servicos.getParaCriancas().add(servico);
					
				}else if(opcaoS == "Não") {
					break;
				}
			}
		}

		System.out.println("Ao Ar Livre? Jardim...");
		System.out.print("'Sim' ou 'Não':");
		opcaoS = scanner.nextLine();
		System.out.println();
		
		if(opcaoS == "Sim") {
			System.out.println("Qual serviço? (Digite 1)");
			servico = scanner.nextLine();
			System.out.println();
			
			servicos.getArLivre().add(servico);
			
			while(true) {
				System.out.println("Possui mais serviços? ('Sim' ou 'Não')");
				opcaoS = scanner.nextLine();
				System.out.println();
				
				if(opcaoS == "Sim") {
					System.out.println("Qual serviço?");
					servico = scanner.nextLine();
					System.out.println();
					
					servicos.getArLivre().add(servico);
					
				}else if(opcaoS == "Não") {
					break;
				}
			}
		}

		System.out.println("Refeições? Bar, Café da manhã, Cafeteria, Restaurante...");
		System.out.print("'Sim' ou 'Não':");
		opcaoS = scanner.nextLine();
		System.out.println();
		
		if(opcaoS == "Sim") {
			System.out.println("Qual serviço? (Digite 1)");
			servico = scanner.nextLine();
			System.out.println();
			
			servicos.getRefeicoes().add(servico);
			
			while(true) {
				System.out.println("Possui mais serviços? ('Sim' ou 'Não')");
				opcaoS = scanner.nextLine();
				System.out.println();
				
				if(opcaoS == "Sim") {
					System.out.println("Qual serviço?");
					servico = scanner.nextLine();
					System.out.println();
					
					servicos.getRefeicoes().add(servico);
					
				}else if(opcaoS == "Não") {
					break;
				}
			}
		}

		System.out.println("Estacionamento e Transporte? Bicicletas disponíveis grátis, Estacionamento coberto, Estacionamento com custo adicional...");
		System.out.print("'Sim' ou 'Não':");
		opcaoS = scanner.nextLine();
		System.out.println();
		
		if(opcaoS == "Sim") {
			System.out.println("Qual serviço? (Digite 1)");
			servico = scanner.nextLine();
			System.out.println();
			
			servicos.getEstacionamentoTransporte().add(servico);
			
			while(true) {
				System.out.println("Possui mais serviços? ('Sim' ou 'Não')");
				opcaoS = scanner.nextLine();
				System.out.println();
				
				if(opcaoS == "Sim") {
					System.out.println("Qual serviço?");
					servico = scanner.nextLine();
					System.out.println();
					
					servicos.getEstacionamentoTransporte().add(servico);
					
				}else if(opcaoS == "Não") {
					break;
				}
			}
		}

		System.out.println("Animais de Estimação? Aceita animais de estimação com custo adicional...");
		System.out.print("'Sim' ou 'Não':");
		opcaoS = scanner.nextLine();
		System.out.println();
		
		if(opcaoS == "Sim") {
			System.out.println("Qual serviço? (Digite 1)");
			servico = scanner.nextLine();
			System.out.println();
			
			servicos.getAnimaisEstimacao().add(servico);
			
			while(true) {
				System.out.println("Possui mais serviços? ('Sim' ou 'Não')");
				opcaoS = scanner.nextLine();
				System.out.println();
				
				if(opcaoS == "Sim") {
					System.out.println("Qual serviço?");
					servico = scanner.nextLine();
					System.out.println();
					
					servicos.getAnimaisEstimacao().add(servico);
					
				}else if(opcaoS == "Não") {
					break;
				}
			}
		}

		System.out.println("Seguranca? Câmera de segurança em áreas comuns, Segurança 24h...");
		System.out.print("'Sim' ou 'Não':");
		opcaoS = scanner.nextLine();
		System.out.println();
		
		if(opcaoS == "Sim") {
			System.out.println("Qual serviço? (Digite 1)");
			servico = scanner.nextLine();
			System.out.println();
			
			servicos.getSeguranca().add(servico);
			
			while(true) {
				System.out.println("Possui mais serviços? ('Sim' ou 'Não')");
				opcaoS = scanner.nextLine();
				System.out.println();
				
				if(opcaoS == "Sim") {
					System.out.println("Qual serviço?");
					servico = scanner.nextLine();
					System.out.println();
					
					servicos.getSeguranca().add(servico);
					
				}else if(opcaoS == "Não") {
					break;
				}
			}
		}

		System.out.println("Acessibilidade? Unidades e Banheiro adaptado para pessoas com mobilidade reduzida, Elevador...");
		System.out.print("'Sim' ou 'Não':");
		opcaoS = scanner.nextLine();
		System.out.println();
		
		if(opcaoS == "Sim") {
			System.out.println("Qual serviço? (Digite 1)");
			servico = scanner.nextLine();
			System.out.println();
			
			servicos.getAcessibilidade().add(servico);
			
			while(true) {
				System.out.println("Possui mais serviços? ('Sim' ou 'Não')");
				opcaoS = scanner.nextLine();
				System.out.println();
				
				if(opcaoS == "Sim") {
					System.out.println("Qual serviço?");
					servico = scanner.nextLine();
					System.out.println();
					
					servicos.getAcessibilidade().add(servico);
					
				}else if(opcaoS == "Não") {
					break;
				}
			}
		}

		System.out.println("Está a Trabalho? Business center...");
		System.out.print("'Sim' ou 'Não':");
		opcaoS = scanner.nextLine();
		System.out.println();
		
		if(opcaoS == "Sim") {
			System.out.println("Qual serviço? (Digite 1)");
			servico = scanner.nextLine();
			System.out.println();
			
			servicos.getaTrabalho().add(servico);
			
			while(true) {
				System.out.println("Possui mais serviços? ('Sim' ou 'Não')");
				opcaoS = scanner.nextLine();
				System.out.println();
				
				if(opcaoS == "Sim") {
					System.out.println("Qual serviço?");
					servico = scanner.nextLine();
					System.out.println();
					
					servicos.getaTrabalho().add(servico);
					
				}else if(opcaoS == "Não") {
					break;
				}
			}
		}

		System.out.println("Lavanderia? Serviço de lavanderia com custo adicional...");
		System.out.print("'Sim' ou 'Não':");
		opcaoS = scanner.nextLine();
		System.out.println();
		
		if(opcaoS == "Sim") {
			System.out.println("Qual serviço? (Digite 1)");
			servico = scanner.nextLine();
			System.out.println();
			
			servicos.getLavanderia().add(servico);
			
			while(true) {
				System.out.println("Possui mais serviços? ('Sim' ou 'Não')");
				opcaoS = scanner.nextLine();
				System.out.println();
				
				if(opcaoS == "Sim") {
					System.out.println("Qual serviço?");
					servico = scanner.nextLine();
					System.out.println();
					
					servicos.getLavanderia().add(servico);
					
				}else if(opcaoS == "Não") {
					break;
				}
			}
		}

		System.out.println("Em Áreas Comuns? Ar-condicionado, Computadores para uso dos hóspedes, Aquecimento, Wi-Fi grátis...");
		System.out.print("'Sim' ou 'Não':");
		opcaoS = scanner.nextLine();
		System.out.println();
		
		if(opcaoS == "Sim") {
			System.out.println("Qual serviço? (Digite 1)");
			servico = scanner.nextLine();
			System.out.println();
			
			servicos.getAreaComum().add(servico);
			
			while(true) {
				System.out.println("Possui mais serviços? ('Sim' ou 'Não')");
				opcaoS = scanner.nextLine();
				System.out.println();
				
				if(opcaoS == "Sim") {
					System.out.println("Qual serviço?");
					servico = scanner.nextLine();
					System.out.println();
					
					servicos.getAreaComum().add(servico);
					
				}else if(opcaoS == "Não") {
					break;
				}
			}
		}

		System.out.println("Recepção? Depósito de bagagem grátis, Recepção 24h, Câmbio de moedas, Serviço de quarto...");
		System.out.print("'Sim' ou 'Não':");
		opcaoS = scanner.nextLine();
		System.out.println();
		
		if(opcaoS == "Sim") {
			System.out.println("Qual serviço? (Digite 1)");
			servico = scanner.nextLine();
			System.out.println();
			
			servicos.getRecepcao().add(servico);
			
			while(true) {
				System.out.println("Possui mais serviços? ('Sim' ou 'Não')");
				opcaoS = scanner.nextLine();
				System.out.println();
				
				if(opcaoS == "Sim") {
					System.out.println("Qual serviço?");
					servico = scanner.nextLine();
					System.out.println();
					
					servicos.getRecepcao().add(servico);
					
				}else if(opcaoS == "Não") {
					break;
				}
			}
		}

		System.out.println("Higiene? Opções de comida embalada, Álcool em gel nas áreas comuns, Intervalo de desinfecção entre hospedagens...");
		System.out.print("'Sim' ou 'Não':");
		opcaoS = scanner.nextLine();
		System.out.println();
		
		if(opcaoS == "Sim") {
			System.out.println("Qual serviço? (Digite 1)");
			servico = scanner.nextLine();
			System.out.println();
			
			servicos.getHigiene().add(servico);
			
			while(true) {
				System.out.println("Possui mais serviços? ('Sim' ou 'Não')");
				opcaoS = scanner.nextLine();
				System.out.println();
				
				if(opcaoS == "Sim") {
					System.out.println("Qual serviço?");
					servico = scanner.nextLine();
					System.out.println();
					
					servicos.getHigiene().add(servico);
					
				}else if(opcaoS == "Não") {
					break;
				}
			}
		}

		System.out.println("Regras? Proibido fumar em todos os ambientes, Animais de estimação não permitidos...");
		System.out.print("'Sim' ou 'Não':");
		opcaoS = scanner.nextLine();
		System.out.println();
		
		if(opcaoS == "Sim") {
			System.out.println("Qual serviço? (Digite 1)");
			servico = scanner.nextLine();
			System.out.println();
			
			servicos.getRegras().add(servico);
			
			while(true) {
				System.out.println("Possui mais serviços? ('Sim' ou 'Não')");
				opcaoS = scanner.nextLine();
				System.out.println();
				
				if(opcaoS == "Sim") {
					System.out.println("Qual serviço?");
					servico = scanner.nextLine();
					System.out.println();
					
					servicos.getRegras().add(servico);
					
				}else if(opcaoS == "Não") {
					break;
				}
			}
		}

		System.out.println("Na hospedagem se fala: Portugues, Ingles, Espanhol...");
		System.out.print("'Sim' ou 'Não':");
		opcaoS = scanner.nextLine();
		System.out.println();
		
		if(opcaoS == "Sim") {
			System.out.println("Qual lingua? (Digite 1)");
			servico = scanner.nextLine();
			System.out.println();
			
			servicos.getLingua().add(servico);
			
			while(true) {
				System.out.println("Possui mais idiomas? ('Sim' ou 'Não')");
				opcaoS = scanner.nextLine();
				System.out.println();
				
				if(opcaoS == "Sim") {
					System.out.println("Qual lingua?");
					servico = scanner.nextLine();
					System.out.println();
					
					servicos.getLingua().add(servico);
					
				}else if(opcaoS == "Não") {
					break;
				}
			}
		}

		System.out.println("Dentre os serviços acima, quais gera mais interesse. no máximo 4");
		servico = scanner.nextLine();
		System.out.println();
		servicos.getServicosDestaque().add(servico);
			
		for (int i = 1; i < 4; i++) {
			System.out.println("Possui mais serviços? ('Sim' ou 'Não')");
			opcaoS = scanner.nextLine();
			System.out.println();
				
			if(opcaoS == "Sim") {
				System.out.println("Qual serviço?");
				servico = scanner.nextLine();
				System.out.println();
					
				servicos.getServicosDestaque().add(servico);
					
			}else if(opcaoS == "Não") {
				break;
			}
		}

		return servicos;
	}

	public static void editarPacote(Scanner scanner) {
		ArrayList<PacoteViagem> pacotes = listaPacotes(scanner);
		if (pacotes == null) {
			System.out.println("Não existe Pacotes");
			System.out.println();
			return;
		}

		PacoteViagem temp = devolverPacote(scanner, pacotes);
		if (temp == null) {
			return;
		}
	}

	public static void removerPacote(Scanner scanner) {
		ArrayList<PacoteViagem> pacotes = listaPacotes(scanner);
		if (pacotes == null) {
			System.out.println("Não existe Pacotes");
			System.out.println();
			return;
		}

		PacoteViagem temp = devolverPacote(scanner, pacotes);
		if (temp == null) {
			return;
		}

		if(pacoteController.remover(temp)) {
			System.out.println("Pacote removido");
			System.out.println();
			return;
			
		}
		System.out.println("Não existe Pacote");
		System.out.println();
		return;
	}

	public static void registrarCidade(Scanner scanner) {
		System.out.println("---- Registrar Cidade ----");
		System.out.println();
		System.out.print("Cidade: ");
		String cidade = scanner.nextLine();
		System.out.println();
		System.out.print("Aeroporto mais próximo: ");
		String aeroporto = scanner.nextLine();
		Aeroporto local = new Aeroporto(cidade, aeroporto);

		if (pacoteController.novaCidade(local)) {
			System.out.println("Cidade Registrada");
		} else {
			System.out.println("Registro de Cidade existente");
		}
	}
} 