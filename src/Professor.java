public class Professor extends Usuario{

    //-------------------------------------- Atribultos Professor --------------------------------------------------//

    private String matriculaProfessor;
    private String materiaMinistrada;
    private String departamento;
    private String senhaAcesso;

    //------------------------------------ Fim Atribultos Professor ------------------------------------------------//



    //--------------------------------------- Metodo Construtor ----------------------------------------------------//

    public Professor(String nome, String cpf, Integer idade, String matriculaProfessor,
                     String materiaMinistrada, String departamento, String senhaAcesso) {

        super(nome, cpf, idade);
        this.setMatriculaProfessor(matriculaProfessor);
        this.setMateriaMinistrada(materiaMinistrada);
        this.setDepartamento(departamento);
        this.setSenhaAcesso(senhaAcesso);
    }

    //------------------------------------- Fim Metodo Construtor --------------------------------------------------//



    //----------------------------------------- Metodos Gets -------------------------------------------------------//

    public String getMatriculaProfessor() {
        return matriculaProfessor;
    }

    public String getMateriaMinistrada() {
        return materiaMinistrada;
    }

    public String getDepartamento() {
        return departamento;
    }

    private String getSenhaAcesso() {
        return senhaAcesso;
    }


    //--------------------------------------- Fim Metodos Gets -----------------------------------------------------//



    //----------------------------------------- Metodos Sets -------------------------------------------------------//

    private void setMatriculaProfessor(String matriculaProfessor){
        this.matriculaProfessor = matriculaProfessor;
    }

    private void setMateriaMinistrada(String materiaMinistrada) {
        this.materiaMinistrada = materiaMinistrada;
    }

    private void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    private void setSenhaAcesso(String senhaAcesso){
        this.senhaAcesso = senhaAcesso;
    }

    //--------------------------------------- Fim Metodos Sets -----------------------------------------------------//



    //-------------------------------------- Metodos Comparação ----------------------------------------------------//

    public boolean validarUser(String usuarioverificado){
        return usuarioverificado.equals(this.getCodigoUsuario());
    }

    public boolean validarSenha(String senha){
        return senha.equals(this.getSenhaAcesso());
    }

    //------------------------------------ Fim Metodos Comparação --------------------------------------------------//


}
