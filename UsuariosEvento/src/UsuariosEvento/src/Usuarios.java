package UsuariosEvento.src;

import java.util.ArrayList;
import java.util.List;

public class Usuarios {
    private String name;
    private Integer year;
    private String cidade;
    private List<Usuarios> usuariosList;
    
    public Usuarios(String n, Integer y, String cidade){
        setName(n);
        this.year = y;
        this.cidade = cidade;
        this.usuariosList = new ArrayList<>();
    }
    
    public void setName(String name){
        if (name == null || name.isEmpty()){
            this.name = "Nome inválido";
        }else{
            this.name = name;
        }
    }
    
    public void addUsuario(Usuarios usuario) {
        usuariosList.add(usuario);
    } 

    public List<Usuarios> getUser(){
        return  usuariosList;
    }
}
