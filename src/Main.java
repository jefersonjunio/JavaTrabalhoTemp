import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Main {

    static SistemaDeCadastros cadastros = new SistemaDeCadastros("Admin","Admin");

    public static void main(String[] args){
        boolean ERRO = true;

        do{
            String usuario = JOptionPane.showInputDialog(null,"Digite Seu Nome", "Login", JOptionPane.PLAIN_MESSAGE);
            if(cadastros.buscarUsuario(usuario)) {
                do {
                    String senha = JOptionPane.showInputDialog(null,"Senha");
                    if(cadastros.validarSenha(senha)){
                        do {
                            abrirOpcoes(cadastros.obterTipoUser(usuario));
                            ERRO = (JOptionPane.showConfirmDialog(null,"Continue") == 0);
                        }while (ERRO);
                    }else{
                        JOptionPane.showMessageDialog(null, "Senha Invalida - Tente Novamente", "SENHA INCORRETA", JOptionPane.ERROR_MESSAGE);
                    }
                }while (ERRO);
            } else{
                JOptionPane.showMessageDialog(null, "User Invalido - Tente Novamente", "USUARIO NÃO ENCONTRADO", JOptionPane.ERROR_MESSAGE);
            }
        }while (ERRO);
    }

    public  static void abrirOpcoes(String opcao){

        switch (opcao){
            case "Admin":
                funcoesAdministrativas();
                break;
            case "Professor":

                break;
            case "Coordenador":

                break;
            default:
        }

    }

    public static void funcoesAdministrativas(){
        String opcao;

        Object[] funcoesSistema = {"Cadastrar Usuarios", "Cadastrar Salas", "Sair"};
        opcao = (String) JOptionPane.showInputDialog(null, "Escolha uma Opção",
                "Cadastro de Dados", JOptionPane.PLAIN_MESSAGE, null, funcoesSistema, "Cadastrar Usuario");

        switch (opcao){

            case "Cadastrar Usuarios":
                Object[] tiposUsuarios = {"Aluno", "Professor", "Coordenador", "Sair"};
                opcao = (String) JOptionPane.showInputDialog(null, "Escolha uma Opção",
                        "Cadastro de Usuario", JOptionPane.PLAIN_MESSAGE, null, tiposUsuarios, "Coordenador");

                switch (opcao){

                    case "Aluno":
                        cadastros.cadastrarAluno(JOptionPane.showInputDialog("Nome Aluno"),
                                JOptionPane.showInputDialog("CPF"),
                                Integer.parseInt(JOptionPane.showInputDialog("Idade")),
                                JOptionPane.showInputDialog("Matricula"),
                                JOptionPane.showInputDialog("Curso"));
                        break;
                    case "Professor":
                        cadastros.cadastrarProfessor(JOptionPane.showInputDialog("Nome Aluno"),
                                JOptionPane.showInputDialog("CPF"),
                                Integer.parseInt(JOptionPane.showInputDialog("Idade")),
                                JOptionPane.showInputDialog("Matricula"),
                                JOptionPane.showInputDialog("Materia Ministrada"),
                                JOptionPane.showInputDialog("Departamento"),
                                JOptionPane.showInputDialog("Crie Uma Senha"));
                        break;
                    case "Coordenador":
                        cadastros.cadastrarCoordenador(JOptionPane.showInputDialog("Nome Coordenador"),
                                JOptionPane.showInputDialog("CPF"),
                                Integer.parseInt(JOptionPane.showInputDialog("Idade")),
                                JOptionPane.showInputDialog("Matricula"),
                                JOptionPane.showInputDialog("Materia Ministrada"),
                                JOptionPane.showInputDialog("Departamento"),
                                JOptionPane.showInputDialog("Cargo Coordenacão"),
                                JOptionPane.showInputDialog("Crie Uma Senha"));
                        break;
                    default:
                }
                break;

            case "Cadastrar Salas":

                Object[] tiposSala = {"Sala Convencional", "Sala Laboratorio", "Sair"};
                opcao = (String) JOptionPane.showInputDialog(null, "Escolha uma Opção",
                        "Cadastro de Salas", JOptionPane.PLAIN_MESSAGE, null, tiposSala, "Sala Convencional");

                switch (opcao){
                    case "Sala Convencional":
                        cadastros.cadastrarSalaConvencional(Integer.parseInt(JOptionPane.showInputDialog("Capacidade Sala")),
                                Integer.parseInt(JOptionPane.showInputDialog("Numero da Sala")));
                        break;
                    case "Sala Laboratorio":
                        cadastros.cadastrarSalaLaboratorio(Integer.parseInt(JOptionPane.showInputDialog("Capacidade Sala")),
                                Integer.parseInt(JOptionPane.showInputDialog("Numero da Sala")));
                        break;
                    default:
                }
                break;
            default:

        }
    }
}
