package pdi_tur.model.diversos;

public class Data {
    private int dia;
    private int mes;
    private int ano;
    
    private Data(int dia, int mes, int ano) {
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }

    private static int maxDias(int mes, int ano) {
        if (mes == 2) 
            return 28 + Boolean.compare(false, (ano % 4 == 0));
        
        return 30 + mes % 2;
    }

    public static Data newData(String data) {
        //verificando se data esta no formato "DD/MM/AAAA"
        String[] s = data.split("/");
        if (s.length != 3)
            return null;
        
        if (s[0].length() != 2 || !s[0].matches("[0-9]+"))
            return null;
            
        if (s[1].length() != 2 || !s[1].matches("[0-9]+"))
            return null;
        
        if (s[2].length() != 4 || !s[2].matches("[0-9]+"))
            return null;
        
        int d = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        int a = Integer.parseInt(s[2]);

        if (m < 1 || m > 12)
            return null;
        
        int max = maxDias(m, a);
        if (d < 1 || d > max)
            return null;

        return new Data(d, m, a);
    }

    @Override
    public String toString() {
        return (dia < 10 ? "0" : "") + dia + "/" + (mes < 10 ? "0" : "") + mes + "/" + ano;
    }
}
