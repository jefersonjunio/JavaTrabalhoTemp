public abstract class Usuario {

    //--------------------------------------- Atribultos Usuario ---------------------------------------------------//

    private static int numUsuarios;

    private String nome;
    private String cpf;
    private Integer idade;
    private String codigoUsuario;

    //------------------------------------- Fim Atribultos Usuario -------------------------------------------------//



    //--------------------------------------- Metodo Construtor ----------------------------------------------------//

    public Usuario(String nome, String cpf, Integer idade){
        this.nome = nome;
        this.cpf = cpf;
        this.setIdade(idade);
        setNumUsuarios(getNumUsuarios() + 1);
        this.setCodigoUsuario(numUsuarios);
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


    //--------------------------------------- Fim Metodos Gets -----------------------------------------------------//



    //-------------------------------------- Metodos Comparação ----------------------------------------------------//

    @Override
    public boolean equals(Object obj) {
        Usuario usuarioComparado = (Usuario) obj;

        return this.nome.equals(usuarioComparado.nome)
                && this.cpf.equals(usuarioComparado.cpf)
                && this.idade.equals(usuarioComparado.idade);
    }


    //------------------------------------ Fim Metodos Comparação --------------------------------------------------//

}
