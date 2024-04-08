import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UsuarioController usuarioController = new UsuarioController();
        EventoController eventoController = new EventoController();

        while (true) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1 - Cadastrar novo usuário");
            System.out.println("2 - Cadastrar novo evento");
            System.out.println("3 - Consultar eventos cadastrados e participar");
            System.out.println("4 - Cancelar participação do evento");
            System.out.println("0 - Sair");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

            switch (opcao) {
                case 1:
                    usuarioController.cadastrarNovoUsuario(scanner);
                    break;
                case 2:
                    eventoController.cadastrarNovoEvento(scanner);
                    break;
                case 3:
                    eventoController.consultarEventosEParticipar(scanner, usuarioController);
                    break;
                case 4:
                    usuarioController.cancelarParticipacaoEvento(scanner, eventoController);
                    break;
                case 0:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}

class Usuario {
    private String nome;
    private String cidade;

    public Usuario(String nome, String cidade) {
        this.nome = nome;
        this.cidade = cidade;
    }

    public String getNome() {
        return nome;
    }

    public String getCidade() {
        return cidade;
    }
}

class UsuarioController {
    private List<Usuario> usuarios = new ArrayList<>();

    public void cadastrarNovoUsuario(Scanner scanner) {
        System.out.print("Digite o nome do usuário: ");
        String nome = scanner.nextLine();
        System.out.print("Digite a cidade do usuário: ");
        String cidade = scanner.nextLine();
        usuarios.add(new Usuario(nome, cidade));
        System.out.println("Usuário cadastrado com sucesso!");
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void cancelarParticipacaoEvento(Scanner scanner, EventoController eventoController) {
        System.out.println("Eventos em que você está inscrito:");
        eventoController.mostrarEventosInscritos(scanner);

        System.out.print("Digite o número do evento que deseja cancelar a inscrição (ou 0 para voltar): ");
        int escolha = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer

        if (escolha == 0) {
            return;
        }

        eventoController.cancelarInscricaoEvento(escolha - 1);
    }
}

class Evento {
    private String nome;
    private String endereco;
    private String categoria;
    private String horario;
    private String descricao;

    public Evento(String nome, String endereco, String categoria, String horario, String descricao) {
        this.nome = nome;
        this.endereco = endereco;
        this.categoria = categoria;
        this.horario = horario;
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }
}

class EventoController {
    private List<Evento> eventos = new ArrayList<>();
    private List<Evento> eventosInscritos = new ArrayList<>();

    public void cadastrarNovoEvento(Scanner scanner) {
        System.out.print("Digite o nome do evento: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o endereço do evento: ");
        String endereco = scanner.nextLine();
        System.out.print("Digite a categoria do evento: ");
        String categoria = scanner.nextLine();
        System.out.print("Digite o horário do evento: ");
        String horario = scanner.nextLine();
        System.out.print("Digite a descrição do evento: ");
        String descricao = scanner.nextLine();
        eventos.add(new Evento(nome, endereco, categoria, horario, descricao));
        System.out.println("Evento cadastrado com sucesso!");
    }

    public void consultarEventosEParticipar(Scanner scanner, UsuarioController usuarioController) {
        System.out.println("Eventos cadastrados:");
        for (int i = 0; i < eventos.size(); i++) {
            System.out.println((i + 1) + ". " + eventos.get(i).getNome());
        }

        System.out.print("Digite o número do evento que deseja participar (ou 0 para voltar): ");
        int escolha = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer

        if (escolha == 0) {
            return;
        }

        eventosInscritos.add(eventos.get(escolha - 1));
        System.out.println("Você foi inscrito no evento com sucesso!");
    }

    public void mostrarEventosInscritos(Scanner scanner) {
        for (int i = 0; i < eventosInscritos.size(); i++) {
            System.out.println((i + 1) + ". " + eventosInscritos.get(i).getNome());
        }
    }

    public void cancelarInscricaoEvento(int indice) {
        eventosInscritos.remove(indice);
        System.out.println("Inscrição cancelada com sucesso!");
    }
}
