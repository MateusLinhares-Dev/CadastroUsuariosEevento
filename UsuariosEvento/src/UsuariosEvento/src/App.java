package UsuariosEvento.src;

import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // inicializar os objetos
        DataHora datahoraobj = new DataHora(0, 0, 0, 0, 0);
        Endereco enderecoobj = new Endereco(null, null, null);
        Evento eventoobj = new Evento(null, null, enderecoobj, datahoraobj, null);

        System.out.println("\n\tBem vindo ao Sistema de Gerenciamento de Usuários e Evento");

        while (true) {
            System.out.println("Escolha uma opção:");
            System.out.println("C - Cadastrar um novo evento");
            System.out.println("P - Consultar eventos cadastrados e participar");
            System.out.println("E - Sair");

            String op = sc.nextLine();

            if (op.equalsIgnoreCase("C")) {
                // Cadastro de Novo Evento
                System.out.println("Cadastro de Novo Evento:");
                System.out.print("Nome do evento: ");
                String nome = sc.nextLine();

                System.out.print("Categoria do evento - (Desportivo/Cultural/Shows/Educacional/Outros): ");
                String categoria = sc.nextLine();

                if (categoria.equalsIgnoreCase("Desportivo") || categoria.equalsIgnoreCase("Cultural") || categoria.equalsIgnoreCase("Shows") || categoria.equalsIgnoreCase("Educacional") || categoria.equalsIgnoreCase("Outros")) {
                    System.out.print("Logradouro do Evento: ");
                    String logradouro = sc.nextLine();
                    System.out.print("Cidade do Evento: ");
                    String cidade = sc.nextLine();
                    System.out.print("Estado do Evento: ");
                    String uc = sc.nextLine();

                    System.out.print("Data (Dia): ");
                    int dia = sc.nextInt();
                    System.out.print("Data (Mês): ");
                    int mes = sc.nextInt();
                    System.out.print("Data (Ano): ");
                    int ano = sc.nextInt();

                    System.out.print("Hora (hh): ");
                    int hora = sc.nextInt();
                    System.out.print("Minuto (mm): ");
                    int minuto = sc.nextInt();
                    sc.nextLine(); // Consumindo a quebra de linha pendente

                    System.out.print("Descrição do evento: ");
                    String descricao = sc.nextLine();

                    // Iniciar o objeto
                    datahoraobj = new DataHora(dia, mes, ano, hora, minuto);
                    enderecoobj = new Endereco(logradouro, cidade, uc);
                    eventoobj = new Evento(nome, categoria, enderecoobj, datahoraobj, descricao);

                    // Obter o evento cadastrado formatado
                    String eventoCadastrado = eventoobj.getEventos();

                    // Registrar o evento no arquivo
                    try (FileWriter arq = new FileWriter("events.txt", true)) {
                        PrintWriter gravarArquivo = new PrintWriter(arq);
                        gravarArquivo.printf("%s%n", eventoCadastrado);
                    } catch (IOException e) {
                        System.out.println("Erro ao registrar o evento no arquivo.");
                        System.out.println(e.getMessage());
                    }

                } else {
                    System.out.println("Categoria Inválida");
                }
            } else if (op.equalsIgnoreCase("P")) {
                // Consultar eventos cadastrados e participar
                List<String> eventos = lerEventos();
                exibirEventos(eventos);

                // Permitir ao usuário escolher um evento para participar
                System.out.print("Digite o número do evento que deseja participar (ou 0 para voltar): ");
                int escolha = sc.nextInt();
                sc.nextLine(); // Limpar o buffer

                if (escolha == 0) {
                    continue;
                }

                if (escolha > 0 && escolha <= eventos.size()) {
                    // Adicionar o usuário ao evento escolhido
                    String eventoEscolhido = eventos.get(escolha - 1);
                    System.out.println("Você escolheu participar do evento:");
                    System.out.println(eventoEscolhido);

                    // Implemente a lógica para adicionar o usuário ao evento escolhido
                    // Aqui você pode chamar um método da classe Evento para adicionar o usuário ao evento
                } else {
                    System.out.println("Escolha inválida.");
                }
            } else if (op.equalsIgnoreCase("E")) {
                break;
            } else {
                System.out.println("Opção inválida!");
            }
        }
    }

    // Método para ler os eventos cadastrados no arquivo TXT
    private static List<String> lerEventos() {
        List<String> eventos = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("events.txt"))) {
            String linha;
            StringBuilder eventoAtual = new StringBuilder();
            while ((linha = br.readLine()) != null) {
                if (linha.isEmpty()) {
                    eventos.add(eventoAtual.toString());
                    eventoAtual = new StringBuilder();
                } else {
                    eventoAtual.append(linha).append("\n");
                }
            }
            // Adicionar o último evento
            if (eventoAtual.length() > 0) {
                eventos.add(eventoAtual.toString());
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler arquivo de eventos: " + e.getMessage());
        }
        return eventos;
    }

    // Método para exibir os eventos cadastrados
    private static void exibirEventos(List<String> eventos) {
        System.out.println("Eventos cadastrados:");
        for (int i = 0; i < eventos.size(); i++) {
            System.out.println((i + 1) + ". " + eventos.get(i));
        }
    }
}
