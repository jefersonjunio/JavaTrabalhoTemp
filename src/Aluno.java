public class Aluno extends Usuario{

    //---------------------------------------- Atribultos Aluno ----------------------------------------------------//

    private String cursoMatriculado;

    //-------------------------------------- Fim Atribultos Aluno --------------------------------------------------//



    //--------------------------------------- Metodo Construtor ----------------------------------------------------//

    public Aluno(String titleUser) {
        super(titleUser);
        this.setCursoMatriculado(recebercursoMatriculado(titleUser));
    }

    //------------------------------------- Fim Metodo Construtor --------------------------------------------------//



    //----------------------------------------- Metodos Gets -------------------------------------------------------//

    public String getCursoMatriculado() {
        return cursoMatriculado;
    }

    //--------------------------------------- Fim Metodos Gets -----------------------------------------------------//



    //----------------------------------------- Metodos Sets -------------------------------------------------------//

    private void setCursoMatriculado(String cursoMatriculado) {
        this.cursoMatriculado = cursoMatriculado;
    }

    //--------------------------------------- Fim Metodos Sets -----------------------------------------------------//



    //------------------------------------- Metodos Receber Dados --------------------------------------------------//

    public String recebercursoMatriculado(String titleUser){
        Tela tela = new Tela();
        String cursoMatriculado;
        cursoMatriculado = tela.inputString_NotReturnNull("Digite Curso", titleUser,"Curso Invalido");
        return cursoMatriculado;
    }

    //----------------------------------- Fim Metodos Receber Dados ------------------------------------------------//


    //-------------------------------------- Metodos Comparação ----------------------------------------------------//

    //------------------------------------ Fim Metodos Comparação --------------------------------------------------//

}
