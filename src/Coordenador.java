public class Coordenador extends Professor{

    //------------------------------------- Atribultos Coordenador -------------------------------------------------//

    String cargoCoordenacao;

    //----------------------------------- Fim Atribultos Coordenador -----------------------------------------------//



    //--------------------------------------- Metodo Construtor ----------------------------------------------------//

    public Coordenador(String titleUser){
        super(titleUser);
        if(!titleUser.equals("Admin")){
            this.setCargoCoordenacao(receberCargoCoordenacao(titleUser));
        }
    }

    //------------------------------------- Fim Metodo Construtor --------------------------------------------------//


    //------------------------------------- Metodos Receber Dados --------------------------------------------------//

    public String receberCargoCoordenacao(String titleUser) {
        Tela tela = new Tela();
        String cargoCoordenacao;
        cargoCoordenacao = tela.inputString_NotReturnNull("Digite o cargo", titleUser, "Cargo Invalido");
        return cargoCoordenacao;
    }

    //----------------------------------- Fim Metodos Receber Dados ------------------------------------------------//


    //----------------------------------------- Metodos Sets -------------------------------------------------------//

    private void setCargoCoordenacao(String cargoCoordenacao){
        this.cargoCoordenacao = cargoCoordenacao;
    }

    //--------------------------------------- Fim Metodos Sets -----------------------------------------------------//

}
