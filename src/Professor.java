public class Professor extends Usuario{

    //-------------------------------------- Atribultos Professor --------------------------------------------------//

    private String materiaMinistrada;
    private String departamento;
    private String senhaAcesso;

    //------------------------------------ Fim Atribultos Professor ------------------------------------------------//



    //--------------------------------------- Metodo Construtor ----------------------------------------------------//

    public Professor(String titleUser) {
        super(titleUser);

        if(titleUser.equals("Admin")){
            this.setSenhaAcesso("admin");
        }else {
            this.setMateriaMinistrada(recebermateriaMinistrada(titleUser));
            this.setDepartamento(receberdepartamento(titleUser));
            this.setSenhaAcesso(recebersenhaAcesso(titleUser));
        }
    }

    //------------------------------------- Fim Metodo Construtor --------------------------------------------------//



    //----------------------------------------- Metodos Gets -------------------------------------------------------//

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



    //------------------------------------- Metodos Receber Dados --------------------------------------------------//

    public String recebermateriaMinistrada(String titleUser){
        Tela tela = new Tela();
        String materiaMinistrada;
        materiaMinistrada = tela.inputString_NotReturnNull("Digite Materia Ministrada",titleUser,"Materia Invalida");
        return materiaMinistrada;
    }

    public String receberdepartamento(String titleUser){
        Tela tela = new Tela();
        String departamento;
        departamento = tela.inputString_NotReturnNull("Digite Departamento",titleUser,"Departamento Invalido");
        return departamento;
    }

    public String recebersenhaAcesso(String titleUser) {
        Tela tela = new Tela();
        String senhaAcesso;
        senhaAcesso = tela.inputString_NotReturnNull("Digite Uma Senha", titleUser, "Senha Invalida");
        return senhaAcesso;
    }

    //----------------------------------- Fim Metodos Receber Dados ------------------------------------------------//



    //-------------------------------------- Metodos Comparação ----------------------------------------------------//

    public boolean validarUser(String usuarioverificado){
        return usuarioverificado.equals(this.getCodigoUsuario());
    }

    public boolean validarSenha(String senha){
        return senha.equals(this.getSenhaAcesso());
    }

    //------------------------------------ Fim Metodos Comparação --------------------------------------------------//


}
