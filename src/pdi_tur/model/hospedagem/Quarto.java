package pdi_tur.model.hospedagem;

import java.util.ArrayList;

public class Quarto {
    private String tipo;
    private int camaCasal;
    private int camaIndividual;
    private int camaBebe;
    private int superficie; //Área
    private ArrayList<String> detalhes;
    /*TV de tela plana, Ar condicionado, Frigobar, Aquecimento, Wi-Fi grátis, 
    Chuveiro, Vaso Sanitário, Telefone, Cozinha, Armario, Cofre, etc*/

    private int quantidadeTotal;
    private int quantidadeRestante;
    
    public Quarto(String tipo, int camaCasal, int camaIndividual, int camaBebe, int superficie,
            ArrayList<String> detalhes, int quantidadeTotal) {
        this.tipo = tipo;
        this.camaCasal = camaCasal;
        this.camaIndividual = camaIndividual;
        this.camaBebe = camaBebe;
        this.superficie = superficie;
        this.detalhes = detalhes;
        this.quantidadeTotal = this.quantidadeRestante = quantidadeTotal;
    }

    public String getTipo() {
        return tipo;
    }

    public int getCamaCasal() {
        return camaCasal;
    }

    public int getCamaIndividual() {
        return camaIndividual;
    }

    public int getCamaBebe() {
        return camaBebe;
    }

    public int getSuperficie() {
        return superficie;
    }

    public ArrayList<String> getDetalhes() {
        return detalhes;
    }

    public int getQuantidadeTotal() {
        return quantidadeTotal;
    }

    public int getQuantidadeRestante() {
        return quantidadeRestante;
    }

    public void setQuantidadeRestante(int quantidadeRestante) {
        this.quantidadeRestante = quantidadeRestante;
    }
}
