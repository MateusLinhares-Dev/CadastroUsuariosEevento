package UsuariosEvento.src;

import java.util.Scanner;

import javax.xml.crypto.Data;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // inicializar os objetos
        DataHora datahoraobj = new DataHora(0, 0, 0, 0, 0);
        Endereco enderecoobj = new Endereco(null, null, null);
        Evento eventoobj = new Evento(null, null, enderecoobj, datahoraobj, null);


        System.out.println("\n\tBem vindo ao Sistema de Gerenciamento de Usuários e Evento");

        while(true){
            System.out.println("Você deseja cadastrar algum evento ? C = Criar / E = Sair");
            String op = sc.nextLine();
            if(op.equalsIgnoreCase("C")){

                //Gravar os dados em um arquivo TXT
                Scanner scanner  = new Scanner(System.in);
                // Solicitando informações para o novo evento
                System.out.println("Cadastro de Novo Evento:");
                System.out.print("Nome do evento: ");
                String nome = scanner.nextLine();
                
                System.out.print("Categoria do evento - (Desportivo/Cultural/Shows/Educacional/Outros): ");
                String categoria = scanner.nextLine();
                if(categoria.equalsIgnoreCase("Desportivo") || categoria.equalsIgnoreCase("Cultural") || categoria.equalsIgnoreCase("Shows") || categoria.equalsIgnoreCase("Educacional") || categoria.equalsIgnoreCase("Outros")){
                    System.out.print("Logradouro do Evento: ");
                    String logradouro = scanner.nextLine();
                    System.out.print("Cidade do Evento: ");
                    String cidade = scanner.nextLine();
                    System.out.print("Estado do Evento: ");
                    String uc = scanner.nextLine();

                    System.out.print("Data (Dia): ");
                    int dia = scanner.nextInt();
                    System.out.print("Data (Mês): ");
                    int mes = scanner.nextInt();
                    System.out.print("Data (Ano): ");
                    int ano = scanner.nextInt();

                    System.out.print("Hora (hh): ");
                    int hora = scanner.nextInt();
                    System.out.print("Minuto (hh): ");
                    int minuto = scanner.nextInt();
                    scanner.nextLine(); // Consumindo a quebra de linha pendente

                    System.out.print("Descrição do evento: ");
                    String descricao = scanner.nextLine();

                    //Iniciar o objeto
                    datahoraobj = new DataHora(dia, mes, ano, hora, minuto);
                    enderecoobj = new Endereco(logradouro, cidade, uc);
                    eventoobj = new Evento(nome, categoria, enderecoobj, datahoraobj, descricao);
                    
                    
                }else{
                    System.out.println("Categoria Inválida");
                }
            }else if(op.equalsIgnoreCase("E")){
                break;
            }else{
                System.out.println("Opção inválida!");
            }
            String eventoCadastrado = eventoobj.getEventos();

            try {
                eventoobj.register(eventoCadastrado);
            } catch (Exception e) {
                System.out.println("Evento não foi cadastrado!");
                System.out.println("\n" + e);
            }
        }

    }
}
