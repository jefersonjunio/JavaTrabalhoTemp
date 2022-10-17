import javax.swing.*;
import java.util.ArrayList;
import java.util.Objects;

public class SistemaDeCadastros implements IRetornarVetores{

    //-------------------------------------- Atribultos Sistema ----------------------------------------------------//

    private Coordenador usuarioPadrao;

    private ArrayList<Professor> professoresCadastrados = new ArrayList<>();
    private ArrayList<Aluno> alunosCadastrados = new ArrayList<>();
    private ArrayList<Sala> salasCadastradas = new ArrayList<>();

    //------------------------------------ Fim Atribultos Sistema --------------------------------------------------//



    //--------------------------------------- Metodo Construtor ----------------------------------------------------//

    public SistemaDeCadastros(){
        this.usuarioPadrao = new Coordenador("Admin");
    }

    //------------------------------------- Fim Metodo Construtor --------------------------------------------------//



    //----------------------------------------- Metodos Gets -------------------------------------------------------//

    public ArrayList<Sala> getSalasCadastradas() {
        return salasCadastradas;
    }

    public ArrayList<Professor> getProfessoresCadastrados(){
        return professoresCadastrados;
    }

    public ArrayList<Aluno> getAlunosCadastrados(){return alunosCadastrados;}

    //--------------------------------------- Fim Metodos Gets -----------------------------------------------------//



    //---------------------------------------- Funcionalidade ------------------------------------------------------//

    public void funcionalidadesSistema(){
        Integer opcao;

        Tela tela = new Tela();

        Object[] funcoesSistema = {"Cadastrar Usuarios", "Cadastrar Salas", "Sair"};
        Object[] tiposUsuarios = {"Aluno", "Professor", "Coordenador", "Sair"};
        Object[] tiposSala = {"Sala Convencional", "Sala Laboratorio", "Sair"};

        opcao = tela.inputBotton("Selecione uma opção", "Cadastros Dados", "Opção Invalida", funcoesSistema);

        switch (opcao){

            case JOptionPane.YES_OPTION:

                opcao = tela.inputBotton("Selecione uma opção", "Cadastros Usuarios", "Opção Invalida", tiposUsuarios);

                switch (opcao){

                    case JOptionPane.YES_OPTION:
                        cadastrarAluno();
                        break;
                    case JOptionPane.NO_OPTION:
                        cadastrarProfessor();
                        break;
                    case JOptionPane.CANCEL_OPTION:
                        cadastrarCoordenador();
                        break;
                    default:

                }
                break;

            case JOptionPane.NO_OPTION:

                opcao = tela.inputBotton("Selecione o tipo de sala", "Cadastro de Salas", "Seleção Invalida", tiposSala);

                switch (opcao){
                    case JOptionPane.YES_OPTION:
                        cadastrarSalaConvencional();
                        break;
                    case JOptionPane.NO_OPTION:
                        cadastrarSalaLaboratorio();
                        break;
                    default:
                }
                break;

            default:

        }
    }

    //-------------------------------------- Fim Funcionalidade ----------------------------------------------------//



    //--------------------------------------- Metodos Cadastros ----------------------------------------------------//

    public void cadastrarAluno(){
        Aluno novo = new Aluno("Novo Aluno");
        alunosCadastrados.add(novo);
    }

    public void cadastrarProfessor(){
        Professor novo = new Professor("Novo Professor");
        professoresCadastrados.add(novo);
    }

    public void cadastrarCoordenador(){
        Coordenador novo = new Coordenador("Novo Coordenador");
        professoresCadastrados.add(novo);
    }

    public void cadastrarSalaConvencional(){
        Sala nova = new SalaConvencional("Nova Sala Convencional");
        salasCadastradas.add(nova);
    }

    public void cadastrarSalaLaboratorio(){
        Sala nova = new SalaLaboratorio("Nova Sala Laboratorio");
        salasCadastradas.add(nova);
    }

    //------------------------------------- Fim Metodos Cadastros --------------------------------------------------//



    //----------------------------------------- Metodos Buscas ----------------------------------------------------//

    public Usuario buscarUsuario(String usuario){
        Usuario retorno = null;

        if(usuarioPadrao.getNome().equals(usuario)){
            retorno = usuarioPadrao;
        }else{
            for(Professor user : professoresCadastrados){
                if(user.validarUser(usuario)){
                    retorno = user;
                }
            }
        }

        return retorno;
    }

    //--------------------------------------- Fim Metodos Buscas --------------------------------------------------//

}
