import java.util.Scanner;
import java.util.ArrayList;

public class App {

    public void executar() {

        int opcao;
        ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
        Scanner in = new Scanner(System.in);

        do {
            System.out.println("[0] Sair");
            System.out.println("[1] Cadastrar usuario");
            System.out.println("[2] Listar usuarios");
            System.out.println("[6] Autorizao de usuarios");

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
                case 6:
                    menu_AutorizacaoUsuario(usuarios);
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


    public void menu_AutorizacaoUsuario(ArrayList<Usuario> usuarios){
        Scanner in = new Scanner(System.in);

        System.out.println("Selecione o tipo de consulta:");
        System.out.println("[0] Sair");
        System.out.println("[1] Busca o tipo de autorizacao de um usuario especifico");
        System.out.println("[2] Lista todos os usuarios com o mesmo tipo de autorizacao");

        int opcao = in.nextInt();
        in.nextLine();

        switch (opcao) {
            case 0:
                break;
            case 1:
                buscaAutorizacaoUsuario(usuarios);
                break;
            case 2:
                listaUsuarioByAutorizacao(usuarios);
                break;
            default:
                System.out.println("Entrada invalida");
                break;
        }
    }


    //buscar um usuario atraves de seu numero de id e lista seu tipo de autorizacao se encontrado
    public void buscaAutorizacaoUsuario(ArrayList<Usuario> usuarios){
        Scanner in = new Scanner(System.in);
        
        System.out.println("Digite o id do usuario");
        int id_usuario = in.nextInt();
        
        for(Usuario u: usuarios){
            if(id_usuario == u.getId()){
                System.out.println("O usuario possui autorizacao do tipo: " + u.getTipo());
            }
        }
    }

    //lista todos os usuarios cadastrados a partir de um tipo de usuario selecionado
    public void listaUsuarioByAutorizacao(ArrayList<Usuario> usuarios){
        Scanner in = new Scanner(System.in);
        
        System.out.println("Selecione o tipo de autorizacao");
        System.out.println("[0] Sair");
        System.out.println("[1] Paciente");
        System.out.println("[2] Medico");
        System.out.println("[3] Administrador");
        int opcao = in.nextInt();
        in.nextLine();
        tipoUsuario tipoAutorizacao = null;

        switch(opcao){
            case 0:
                break;
            case 1:
                tipoAutorizacao = tipoUsuario.PACIENTE;
                break;
            case 2:
                tipoAutorizacao = tipoUsuario.MEDICO;
                break;
            case 3:
                tipoAutorizacao = tipoUsuario.ADMINISTRADOR;
                break;
            default:
                System.out.println("Opcao invalida");
                break;
        }
        
        for(Usuario u: usuarios){
            if(tipoAutorizacao == u.getTipo()){
                System.out.println(u.getNome() + ", ID: " + u.getId() + ", tipo: " + u.getTipo());
            }
        }
    
    }


}
