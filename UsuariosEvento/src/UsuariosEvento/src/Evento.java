package UsuariosEvento.src;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.xml.crypto.Data;

public class Evento {
    // Criar um cadastro de eventos
    //      Nome do evento, categoria, endereço, data e hora, descrição
    //          delimitar as categorias de eventos (festas, eventos esportivos, shows, entre outros...)
    private String nomeDoEvento;
    private String categoriaDoEvento;
    private Endereco enderecoDoEvento;
    private DataHora dataEhoraDoEvento;
    private  String descricaoDoEvento;

    public Evento(String n, String c, Endereco e, DataHora dh, String des) {
        this.nomeDoEvento = n;
        this.categoriaDoEvento = c;
        this.enderecoDoEvento = e;
        this.dataEhoraDoEvento = dh;
        this.descricaoDoEvento = des;
    }
    
    /* Métodos getters
    ---------------*/
    public String getEventos() {
        String formatEventos =  "Evento: " + nomeDoEvento + " | " + "Categoria: " + categoriaDoEvento + "\n" + "Endereço: " + enderecoDoEvento.getFormatedLocal() + "\nData/Hora: " + dataEhoraDoEvento.getDataHoraFormatada() + "\nDescrição do Evento: " + descricaoDoEvento + "\n";
        return formatEventos; 
    }

    public void register(String evento){
        try (FileWriter arq = new FileWriter("events.txt", true)) {
            PrintWriter gravarArquivo = new PrintWriter(arq);
            
            gravarArquivo.printf("%s%n",evento);
            
        } catch (IOException e) {
            System.out.println("Arquivo não encontrado");
        }
       
    }

}
