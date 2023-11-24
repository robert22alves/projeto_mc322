package pdi_tur.view;

import java.util.ArrayList;

import pdi_tur.model.hospedagem.Hospedagem;
import pdi_tur.model.hospedagem.Quarto;
import pdi_tur.model.hospedagem.Servicos;
import pdi_tur.model.pacotes.PacoteViagem;
import pdi_tur.model.passagemAerea.PassagemAerea;

public class PacoteView { 

    public static void printPacotes(ArrayList<PacoteViagem> pacotes) {
        int i = 0;
        for (PacoteViagem pacote : pacotes) {
            System.out.println(i + " - " + pacote.getCategoria());

            Hospedagem hospedagem = pacote.getHospedagem();
            System.out.println(hospedagem.getNome());
            System.out.println(hospedagem.getLocalizacao() + ". A " + hospedagem.getDistanciaCentro() + " do centro");
            System.out.print("Classificação: " + hospedagem.getClassificacao() + " | ");
            for (String servico : hospedagem.getServicos().getServicosDestaque()) {
                System.out.print(servico + " | ");
            }
            System.out.println('\n');

            PassagemAerea passagem = pacote.getPassagemAerea();
            System.out.println("Voo direto de " + passagem.getAeroportoSaidaIda() + " para " + passagem.getAeroportoChegadaIda());
            System.out.println("Ida " + passagem.getDataSaidaIda() + " | Volta " + passagem.getDataSaidaVolta());
            System.out.print(passagem.getBagagens());
            System.out.println();

            System.out.println("Preço: R$" + pacote.getPrecoFinal());
            System.out.println("sem impostos, taxas ou encargos");
            System.out.println("\n");
            i += 1;
        }
    }
    
    public static void printHospedagem(PacoteViagem pacote) {
        Hospedagem hospedagem = pacote.getHospedagem();
        System.out.println(hospedagem.getNome());
        System.out.println("Endereço: " + hospedagem.getEndereco() + ". A " + hospedagem.getDistanciaCentro() + " do centro");
        System.out.print("Classificação: " + hospedagem.getClassificacao());
        System.out.println("horários");
        System.out.println("Horário de Check in: " + hospedagem.getCheckin());
        System.out.println("Horário de Check out: " + hospedagem.getCheckout());
    }

    public static void printServicosH(PacoteViagem pacote) {
        Servicos servicos = pacote.getHospedagem().getServicos();
        
        ArrayList<String> servico = servicos.getLazer();
        if (!servico.isEmpty()) {
            System.out.println("Diversão e Lazer");
            for (String s : servico) {
                System.out.println(s);
            }
            System.out.println();
        }

        servico = servicos.getBemEstar();
        if (!servico.isEmpty()) {
            System.out.println("Bem-Estar");
            for (String s : servico) {
                System.out.println(s);
            }
            System.out.println();
        }

        servico = servicos.getParaCriancas();
        if (!servico.isEmpty()) {
            System.out.println("Para Crianças");
            for (String s : servico) {
                System.out.println(s);
            }
            System.out.println();
        }

        servico = servicos.getArLivre();
        if (!servico.isEmpty()) {
            System.out.println("Ar Livre");
            for (String s : servico) {
                System.out.println(s);
            }
            System.out.println();
        }

        servico = servicos.getRefeicoes();
        if (!servico.isEmpty()) {
            System.out.println("Refeições");
            for (String s : servico) {
                System.out.println(s);
            }
            System.out.println();
        }

        servico = servicos.getEstacionamentoTransporte();
        if (!servico.isEmpty()) {
            System.out.println("Estacionamento e Transporte");
            for (String s : servico) {
                System.out.println(s);
            }
            System.out.println();
        }

        servico = servicos.getAnimaisEstimacao();
        if (!servico.isEmpty()) {
            System.out.println("Animais de Estimação");
            for (String s : servico) {
                System.out.println(s);
            }
            System.out.println();
        }

        servico = servicos.getSeguranca();
        if (!servico.isEmpty()) {
            System.out.println("Segurança");
            for (String s : servico) {
                System.out.println(s);
            }
            System.out.println();
        }

        servico = servicos.getAcessibilidade();
        if (!servico.isEmpty()) {
            System.out.println("Acessibilidade");
            for (String s : servico) {
                System.out.println(s);
            }
            System.out.println();
        }

        servico = servicos.getaTrabalho();
        if (!servico.isEmpty()) {
            System.out.println("Para Quem está a Trabalho");
            for (String s : servico) {
                System.out.println(s);
            }
            System.out.println();
        }

        servico = servicos.getLavanderia();
        if (!servico.isEmpty()) {
            System.out.println("Lavanderia");
            for (String s : servico) {
                System.out.println(s);
            }
            System.out.println();
        }

        servico = servicos.getAreaComum();
        if (!servico.isEmpty()) {
            System.out.println("Serviços em Áreas Comuns");
            for (String s : servico) {
                System.out.println(s);
            }
            System.out.println();
        }

        servico = servicos.getRecepcao();
        if (!servico.isEmpty()) {
            System.out.println("Recepção");
            for (String s : servico) {
                System.out.println(s);
            }
            System.out.println();
        }

        servico = servicos.getHigiene();
        if (!servico.isEmpty()) {
            System.out.println("Higiene");
            for (String s : servico) {
                System.out.println(s);
            }
            System.out.println();
        }

        servico = servicos.getRegras();
        if (!servico.isEmpty()) {
            System.out.println("Regras");
            for (String s : servico) {
                System.out.println(s);
            }
            System.out.println();
        }

        servico = servicos.getLingua();
        if (!servico.isEmpty()) {
            System.out.println("Na hospedagem se fala");
            for (String s : servico) {
                System.out.println(s);
            }
            System.out.println();
        }
    }

    public static void printQuarto(PacoteViagem pacote) {
        Quarto quarto = pacote.getQuarto();
        System.out.println(quarto.getTipo());
        System.out.println("Superfície: " + quarto.getSuperficie() + "m²");
        if (quarto.getCamaCasal() > 0) {
            System.out.println(quarto.getCamaCasal() + " cama(s) de Casal");
        }
        if (quarto.getCamaIndividual() > 0) {
            System.out.println(quarto.getCamaIndividual() + " cama(s) de Solteiro");
        }
        for (String s : quarto.getDetalhes()) {
            System.out.println(s);
        }
    }

    public static void printVoo(PacoteViagem pacote) {
        PassagemAerea passagem = pacote.getPassagemAerea();
        System.out.println("Companhia Aérea: " + passagem.getCompanhiaAerea());
        System.out.println("Ida " + passagem.getDataSaidaIda());
        System.out.println(passagem.getAeroportoSaidaIda() + "(" + passagem.getHorarioSaidaIda()+ ") voo direto " + passagem.getAeroportoChegadaIda() + "(" + passagem.getHorarioChegadaIda()+ ")");
        System.out.println("Duração: " + passagem.getDuracaoIda());
        System.out.println("Volta " + passagem.getDataSaidaVolta());
        System.out.println(passagem.getAeroportoSaidaVolta() + "(" + passagem.getHorarioSaidaVolta()+ ") voo direto " + passagem.getAeroportoChegadaVolta() + "(" + passagem.getHorarioChegadaVolta()+ ")");
        System.out.println("Duração: " + passagem.getDuracaoVolta());
    }

    public static void printBagagens(PacoteViagem pacote) {
        PassagemAerea passagem = pacote.getPassagemAerea();

        if (passagem.isMochila() || passagem.isBagagemMao() || passagem.isBagagemDespachar()) {
            System.out.println("Bagagem:");

            if (passagem.isMochila()) {
                System.out.println("- permite uma mochila ou bolsa\n" + "deve caber embaixo do assento dianteiro.");
            }
            else {
                System.out.println("- não permite mochila ou bolsa");
            }

            if (passagem.isBagagemMao()) {
                System.out.println("- permite bagagem de mão\n" + "deve caber no compartimento superior do avião.");
            }
            else {
                System.out.println("- não permite bagagem de mão");
            }

            if (passagem.isBagagemDespachar()) {
                System.out.println("- inclui bagagem para despachar\n" + "1 peça de 23Kg por adulto. " + "O despache é feito durante o Check-in no aeroporto.");
            }
            else {
                System.out.println("- não inclui bagagem para despachar");
            }

            return;
        }

        System.out.println("Não permite Bagagens"); 
    }
}
