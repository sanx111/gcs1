import java.util.Scanner;
import java.time.LocalDate;
import java.util.ArrayList;

public class App {

    public void executar() {

        int opcao;
        ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
        Scanner in = new Scanner(System.in);
        CatalogoAutorizacoes cat = new CatalogoAutorizacoes();

        do {
            System.out.println("[0] Sair");
            System.out.println("[1] Cadastrar usuario");
            System.out.println("[2] Listar usuarios");
            System.out.println("[3] marcar Exame como realizado");
            System.out.println("[4] listar exames do paciente");
            opcao = in.nextInt();
            switch (opcao) {
                case 0:
                    break;
                case 1:
                    cadastraUsuario(usuarios);
                    break;
                case 2:
                    listarUsuarios(usuarios);
                    break;
                case 3:
                    listarExamesPaciente(cat, in);
                    break;

                case 4:
                    marcarExame(cat, in);
                    break;
                default:
                    System.out.println("opcao invalida");
                    break;
            }
        } while (opcao != 0);

    }

    public void cadastraUsuario(ArrayList<Usuario> usuarios) {
        Scanner in = new Scanner(System.in);

        System.out.println("Digite o id do usuario");
        int id = in.nextInt();
        in.nextLine();
        System.out.println("Digite o nome do usuario");
        String nome = in.nextLine();
        System.out.println("Selecione o tipo de usuario a ser adicionado:");
        System.out.println("[0] Sair");
        System.out.println("[1] Paciente");
        System.out.println("[2] Medico");
        System.out.println("[3] Administrador");
        int opcao = in.nextInt();
        in.nextLine();

        switch (opcao) {
            case 0:
                break;
            case 1:
                System.out.println("Digite o cpf do paciente:");
                String cpf = in.nextLine();
                Usuario p = new Paciente(tipoUsuario.PACIENTE, id, nome, cpf);
                usuarios.add(p);
                break;
            case 2:
                System.out.println("Digite o crm do medico:");
                String crm = in.nextLine();
                Usuario m = new Medico(tipoUsuario.MEDICO, id, nome, crm);
                usuarios.add(m);
                break;
            case 3:
                System.out.println("Digite o cracha do administrador:");
                String cracha = in.nextLine();
                Usuario a = new Administrador(tipoUsuario.ADMINISTRADOR, id, nome, cracha);
                usuarios.add(a);
                break;
            default:
                System.out.println("tipo inexistente");
                break;
        }
    }

    public void listarUsuarios(ArrayList<Usuario> usuarios) {
        for (Usuario u : usuarios) {
            if (u.getTipo() == tipoUsuario.PACIENTE) {
                System.out.println("Tipo: " + u.getTipo());
                System.out.println("Nome: " + u.getNome());
                System.out.println("id: " + u.getId());
                Paciente p = (Paciente) u;
                System.out.println("CPF: " + p.getCpf());
            } else if (u.getTipo() == tipoUsuario.MEDICO) {
                System.out.println("Tipo: " + u.getTipo());
                System.out.println("Nome: " + u.getNome());
                System.out.println("id: " + u.getId());
                Medico m = (Medico) u;
                System.out.println("crm: " + m.getCrm());
            } else if (u.getTipo() == tipoUsuario.ADMINISTRADOR) {
                System.out.println("Tipo: " + u.getTipo());
                System.out.println("Nome: " + u.getNome());
                System.out.println("id: " + u.getId());
                Administrador a = (Administrador) u;
                System.out.println("Cracha: " + a.getCracha());
            }
        }
    }

    public void marcarExame(CatalogoAutorizacoes cat, Scanner in) {

        System.out.println("Codigo do exame:");
        int codigo = in.nextInt();

        System.out.println("Data (yyyy-mm-dd):");
        String data = in.next();

        cat.marcarExame(codigo, LocalDate.parse(data));

    }

    public void listarExamesPaciente(CatalogoAutorizacoes cat, Scanner in) {

        in.nextLine();
        System.out.println("Nome do paciente:");
        String nome = in.nextLine();

        for (AutorizacaoExame a : cat.getListaAutorizacoes()) {
            if (a.getPaciente().getNome().equalsIgnoreCase(nome)) {
                System.out.println(a);
            }
        }
    }

}
