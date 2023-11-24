package pdi_tur.model.hospedagem;

import java.util.ArrayList;

public class Servicos {
    private ArrayList<String> lazer;
    /*Piscina coberta de temporada, Piscina climatizada, Mesa de sinuca, Salão de jogos
    TV nas áreas comuns, etc */

    private ArrayList<String> bemEstar;
    /*Academia, Sauna, Hidromassagem, etc */

    private ArrayList<String> paraCriancas;
    /*Piscina Infantil, Espaço Kids, etc */

    private ArrayList<String> arLivre;
    /*Jardim, etc */ 

    private ArrayList<String> refeicoes;
    /*Bar, Café da manhã, Cafeteria, Serviço de quarto (alimentação),
    Menu vegetariano, Restaurante, Lanchonete, etc */

    private ArrayList<String> estacionamentoTransporte;
    /*Bicicletas disponíveis grátis, Estacionamento coberto, Estacionamento com custo adicional
    Estacionamento limitado, Serviço de manobrista, etc */

    private ArrayList<String> animaisEstimacao;
    /*Aceita animais de estimação com custo adicional, etc */

    private ArrayList<String> seguranca;
    /*Câmera de segurança em áreas comuns, Segurança 24h, etc */

    private ArrayList<String> acessibilidade;
    /*Unidades e Banheiro adaptado para pessoas com mobilidade reduzida, 
    Elevador, Acessível para pessoas com mobilidade reduzida, etc */

    private ArrayList<String> aTrabalho;
    /*Business center, etc */

    private ArrayList<String> lavanderia;
    /*Serviço de lavanderia com custo adicional, etc */

    private ArrayList<String> areaComum;
    /*Ar-condicionado, Computadores para uso dos hóspedes, Aquecimento
    Wi-Fi grátis, etc */

    private ArrayList<String> recepcao;
    /*Depósito de bagagem grátis, Recepção 24h, Câmbio de moedas
    Serviço de quarto, Serviço de despertador, etc */ 

    private ArrayList<String> higiene; 
    /*Opções de comida embalada, Álcool em gel nas áreas comuns
    Intervalo de desinfecção entre hospedagens, Os funcionários usam máscaras, etc */ 

    private ArrayList<String> regras;
    /*Proibido fumar em todos os ambientes, Animais de estimação não permitidos, etc */

    private ArrayList<String> lingua;
    /*Na hospedagem se fala: Portugues, Ingles, Espanhol, etc */

    private ArrayList<String> servicosDestaque;
    /*Dentre os serviços acima, aqueles que gera mais interesse. no máximo 4 */

    public Servicos(){
        this.lazer = new ArrayList<>();
        this.bemEstar = new ArrayList<>();
        this.paraCriancas = new ArrayList<>();
        this.arLivre = new ArrayList<>();
        this.refeicoes = new ArrayList<>();
        this.estacionamentoTransporte = new ArrayList<>();
        this.animaisEstimacao = new ArrayList<>();
        this.seguranca = new ArrayList<>();
        this.acessibilidade = new ArrayList<>();
        this.aTrabalho = new ArrayList<>();
        this.lavanderia = new ArrayList<>();
        this.areaComum = new ArrayList<>();
        this.recepcao = new ArrayList<>();
        this.higiene = new ArrayList<>();
        this.regras = new ArrayList<>();
        this.lingua = new ArrayList<>();
        this.servicosDestaque = new ArrayList<>();
    }

    public ArrayList<String> getLazer() {
        return lazer;
    }

    public ArrayList<String> getBemEstar() {
        return bemEstar;
    }

    public ArrayList<String> getParaCriancas() {
        return paraCriancas;
    }

    public ArrayList<String> getArLivre() {
        return arLivre;
    }

    public ArrayList<String> getRefeicoes() {
        return refeicoes;
    }

    public ArrayList<String> getEstacionamentoTransporte() {
        return estacionamentoTransporte;
    }

    public ArrayList<String> getAnimaisEstimacao() {
        return animaisEstimacao;
    }

    public ArrayList<String> getSeguranca() {
        return seguranca;
    }

    public ArrayList<String> getAcessibilidade() {
        return acessibilidade;
    }

    public ArrayList<String> getaTrabalho() {
        return aTrabalho;
    }

    public ArrayList<String> getLavanderia() {
        return lavanderia;
    }

    public ArrayList<String> getAreaComum() {
        return areaComum;
    }

    public ArrayList<String> getRecepcao() {
        return recepcao;
    }

    public ArrayList<String> getHigiene() {
        return higiene;
    }

    public ArrayList<String> getRegras() {
        return regras;
    }

    public ArrayList<String> getLingua() {
        return lingua;
    }

    public ArrayList<String> getServicosDestaque() {
        return servicosDestaque;
    }
}
