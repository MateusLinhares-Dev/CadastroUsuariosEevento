package UsuariosEvento.src;

public class DataHora {
    private int dia, mes, ano, hora, minuto;
    
    public DataHora(int d, int m, int a, int hora, int minuto){
        this.dia = d;
        this.mes = m;
        this.ano = a;
        this.hora = hora;
        this.minuto = minuto;
    }
    
    public String getDataHoraFormatada(){
        return String.format("%02d/%02d/%d - %02d:%02d", dia, mes, ano, hora, minuto);
    }
}
