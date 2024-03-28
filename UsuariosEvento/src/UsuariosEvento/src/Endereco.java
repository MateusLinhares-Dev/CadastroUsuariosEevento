package UsuariosEvento.src;

public class Endereco {
    private String logradouro = "";
    private String cidade = "";
    private String estado = "";

    public Endereco(String l, String c, String e){
        this.logradouro = l;
        this.cidade = c;
        this.estado =  e;
    }
    public String getFormatedLocal(){
        return  "Logradouro: "+ logradouro + "\nCidade: "+  cidade +"\nEstado: "+ estado;
    }
}
