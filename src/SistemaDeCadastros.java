import java.util.ArrayList;
import java.util.Objects;

public class SistemaDeCadastros {

    //-------------------------------------- Atribultos Reserva ----------------------------------------------------//

    private String usuarioPadrao;
    private String chavePadrao;

    private ArrayList<Professor> professoresCadastrados = new ArrayList<>();
    private ArrayList<Aluno> alunosCadastrados = new ArrayList<>();
    private ArrayList<Sala> salasCadastradas = new ArrayList<>();

    //-------------------------------------- Atribultos Reserva ----------------------------------------------------//



    //--------------------------------------- Metodo Construtor ----------------------------------------------------//

    SistemaDeCadastros(String userPadrao, String passwordPadrao){
        this.usuarioPadrao = userPadrao;
        this.chavePadrao = passwordPadrao;
    }

    //------------------------------------- Fim Metodo Construtor --------------------------------------------------//


    //--------------------------------------- Metodos Cadastros ----------------------------------------------------//

    public void cadastrarAluno(String nome, String cpf, Integer idade, String matricula, String curso){
        Aluno novo = new Aluno(nome,cpf,idade,matricula,curso);
        alunosCadastrados.add(novo);
    }

    public void cadastrarProfessor(String nome, String cpf, Integer idade, String matricula,
                                   String materiaMinistrada, String departamento, String senhaAcesso){

        Professor novo = new Professor(nome,cpf,idade,matricula,materiaMinistrada,departamento,senhaAcesso);
        professoresCadastrados.add(novo);

    }

    public void cadastrarCoordenador(String nome, String cpf, Integer idade, String matricula,
                                     String materiaMinistrada, String departamento, String cargoCoordenacao, String senhaAcesso){

        Coordenador novo = new Coordenador(nome, cpf, idade, matricula, materiaMinistrada, departamento, cargoCoordenacao, senhaAcesso);
        professoresCadastrados.add(novo);
    }

    public void cadastrarSalaConvencional(Integer capacidade, Integer numeroSala){
        Sala nova = new SalaConvencional(capacidade, numeroSala);
        salasCadastradas.add(nova);
    }

    public void cadastrarSalaLaboratorio(Integer capacidade, Integer numeroSala){
        Sala nova = new SalaLaboratorio(capacidade, numeroSala);
        salasCadastradas.add(nova);
    }

    //------------------------------------- Fim Metodos Cadastros --------------------------------------------------//



    //--------------------------------------- Metodo Verificador ----------------------------------------------------//

    public boolean buscarUsuario(String usuario){
        boolean retorno = false;

        if(Objects.equals(usuario, this.usuarioPadrao)){

            retorno = true;

        }else{

            for(Professor user : professoresCadastrados){
                if(user.validarUser(usuario)){
                    retorno = true;
                }
            }

        }

        return retorno;
    }

    public boolean validarSenha(String senha){
        boolean retorno = false;

        if(Objects.equals(senha, this.chavePadrao)){

            retorno = true;

        }else{
            for(Professor user : professoresCadastrados){
                if(user.validarSenha(senha)){
                    retorno = true;
                }
            }
        }

        return retorno;
    }

    public String obterTipoUser(String usuario){
         String instancia = "null";

         if(usuario.equals(this.usuarioPadrao)){
             instancia = "Admin";
         }else{
             for(Professor user : professoresCadastrados){
                 if(user.validarUser(usuario)){
                     instancia = String.valueOf(user.getClass());
                 }
             }
         }
         return instancia;
    }



    //------------------------------------- Fim Metodo Verificador -------------------------------------------------//


}
