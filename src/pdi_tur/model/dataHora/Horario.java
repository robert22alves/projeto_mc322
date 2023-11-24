package pdi_tur.model.dataHora;

public class Horario {
    private int horas;
    private int minutos;

    
    private Horario(int horas, int minutos) {
        this.horas = horas;
        this.minutos = minutos;
    }

    public static Horario newHorario(String horario) {
        //verificando se horario esta no formato "HH:MM"
        String[] s = horario.split(":");
        if (s.length != 2)
            return null;
        
        if (s[0].length() != 2 || !s[0].matches("[0-9]+"))
            return null;
            
        if (s[1].length() != 2 || !s[1].matches("[0-9]+"))
            return null;
        
        int h = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);

        if (m < 0 || m > 59)
            return null;

        if (h < 0 || h > 23)
            return null;

        return new Horario(h, m);
    }

    @Override
    public String toString() {
        return (horas < 10 ? "0" : "") + horas + ":" + (minutos < 10 ? "0" : "") + minutos;
    }
}
