
public class Aluno extends Usuario{

    //---------------------------------------- Atribultos Aluno ----------------------------------------------------//

    private String codigoMatricula;
    private String cursoMatriculado;

    //-------------------------------------- Fim Atribultos Aluno --------------------------------------------------//



    //--------------------------------------- Metodo Construtor ----------------------------------------------------//

    public Aluno(String nome, String cpf, Integer idade, String codigoMatricula, String cursoMatriculado) {
        super(nome, cpf, idade);
        this.setCodigoMatricula(codigoMatricula);
        this.setCursoMatriculado(cursoMatriculado);
    }

    //------------------------------------- Fim Metodo Construtor --------------------------------------------------//



    //----------------------------------------- Metodos Gets -------------------------------------------------------//

    public String getCodigoMatricula() {
        return codigoMatricula;
    }

    public String getCursoMatriculado() {
        return cursoMatriculado;
    }

    //--------------------------------------- Fim Metodos Gets -----------------------------------------------------//



    //----------------------------------------- Metodos Sets -------------------------------------------------------//

    private void setCodigoMatricula(String codigoMatricula) {
        this.codigoMatricula = codigoMatricula;
    }


    private void setCursoMatriculado(String cursoMatriculado) {
        this.cursoMatriculado = cursoMatriculado;
    }

    //--------------------------------------- Fim Metodos Sets -----------------------------------------------------//



    //-------------------------------------- Metodos Comparação ----------------------------------------------------//

    //------------------------------------ Fim Metodos Comparação --------------------------------------------------//

}
