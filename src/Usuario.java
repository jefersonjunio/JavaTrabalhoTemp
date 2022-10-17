public abstract class Usuario {

    //--------------------------------------- Atribultos Usuario ---------------------------------------------------//

    private static int numUsuarios;

    private String nome;
    private String cpf;
    private Integer idade;
    private String codigoUsuario;
    private String matricula;

    //------------------------------------- Fim Atribultos Usuario -------------------------------------------------//



    //--------------------------------------- Metodo Construtor ----------------------------------------------------//

    public Usuario(String titleUser){
        if(titleUser.equals("Admin")){
            this.setNome("Admin");
        }else{
            this.setNome(receberNome(titleUser));
            this.setCpf(receberCpf(titleUser));
            this.setIdade(receberIdade(titleUser));
            this.setMatricula(receberMatricula(titleUser));
            setNumUsuarios(getNumUsuarios() + 1);
            this.setCodigoUsuario(numUsuarios);
        }
    }

    //------------------------------------- Fim Metodo Construtor --------------------------------------------------//



    //----------------------------------------- Metodos Gets -------------------------------------------------------//


    public void setCodigoUsuario(int codigoUsuario) {
        this.codigoUsuario = String.valueOf((1000 + codigoUsuario));
    }

    public static void setNumUsuarios(Integer numUsuarios) {
        Usuario.numUsuarios = numUsuarios;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    //--------------------------------------- Fim Metodos Gets -----------------------------------------------------//



    //----------------------------------------- Metodos Gets -------------------------------------------------------//

    public String getCodigoUsuario() {
        return codigoUsuario;
    }

    public static Integer getNumUsuarios() {
        return numUsuarios;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public Integer getIdade() {
        return idade;
    }

    public String getMatricula() {
        return matricula;
    }

    //--------------------------------------- Fim Metodos Gets -----------------------------------------------------//



    //------------------------------------- Metodos Receber Dados --------------------------------------------------//

    public String receberNome(String titleUser){
        Tela tela = new Tela();
        String nome;
        nome = tela.inputString_NotReturnNull("Digite Nome",titleUser,"Nome Invalido");
        return nome;
    }

    public String receberCpf(String titleUser){
        Tela tela = new Tela();
        String cpf;
        cpf = tela.inputString_NotReturnNull("Digite CPF",titleUser,"CPF Invalido");
        return cpf;
    }

    public int receberIdade(String titleUser){
        Tela tela = new Tela();
        int idade;
        boolean ERRO = false;

        idade = tela.inputInt_NotReturnNull("Digite Idade", titleUser, "Idade Invalido");
        ERRO = idade < 15;

        while (ERRO){
            tela.outputErro("Idade Invalida - Tente Novamente","Idade Invalida");
            idade = tela.inputInt_NotReturnNull("Digite Nome",titleUser,"Idade Invalido");
        }

        return idade;
    }

    public String receberMatricula(String titleUser){
        Tela tela = new Tela();
        String matricula;
        matricula = tela.inputString_NotReturnNull("Digite Matricula",titleUser,"Matricula Incorreta");
        return matricula;
    }

    //----------------------------------- Fim Metodos Receber Dados ------------------------------------------------//



    //-------------------------------------- Metodos Comparação ----------------------------------------------------//

    @Override
    public boolean equals(Object obj) {
        Usuario usuarioComparado = (Usuario) obj;

        return this.nome.equals(usuarioComparado.nome)
                && this.cpf.equals(usuarioComparado.cpf)
                && this.idade.equals(usuarioComparado.idade);
    }

    public boolean validarSenha(String senha){
        return false;
    }


    //------------------------------------ Fim Metodos Comparação --------------------------------------------------//

}
