public class Coordenador extends Professor{

    //------------------------------------- Atribultos Coordenador -------------------------------------------------//

    String cargoCoordenacao;

    //----------------------------------- Fim Atribultos Coordenador -----------------------------------------------//



    //--------------------------------------- Metodo Construtor ----------------------------------------------------//

    public Coordenador(String nome, String cpf, Integer idade, String codigoProfessor,
                       String materiaMinistrada, String departamento, String cargoCoordenacao, String senhaAcesso){

        super(nome, cpf, idade,codigoProfessor, materiaMinistrada, departamento, senhaAcesso);
        this.setCargoCoordenacao(cargoCoordenacao);
    }

    //------------------------------------- Fim Metodo Construtor --------------------------------------------------//



    //----------------------------------------- Metodos Sets -------------------------------------------------------//

    private void setCargoCoordenacao(String cargoCoordenacao){
        this.cargoCoordenacao = cargoCoordenacao;
    }

    //--------------------------------------- Fim Metodos Sets -----------------------------------------------------//

}
