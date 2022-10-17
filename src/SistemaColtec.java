import javax.swing.*;
import java.util.ArrayList;

public class SistemaColtec implements IRetornarVetores{

    private Tela tela;
    private SistemaDeCadastros cadastros;
    private SistemaDeReservas reservas;

    public SistemaColtec(){
        this.tela = new Tela();
        this.cadastros = new SistemaDeCadastros();
        this.reservas = new SistemaDeReservas();
    }

    public int inicializar(){
        Object[] opcSystem = {"Efetuar Login", "Visualizar Reservas"};
        int opc = tela.inputBotton("Selecione uma opção","Sistema Coltec", "Opção Invalida", opcSystem);
        return opc;
    }

    public Usuario efetuarLogin(){
        boolean ERRO = true;

        String login = tela.inputString_NotReturnNull("Digite Nome","Login","Login Invalido - Tente Novamente");
        String senha = tela.inputString_NotReturnNull("Digite Senha", "Password","Senha Invalida - Tente Novamente");

        Usuario usuario = cadastros.buscarUsuario(login);
        ERRO = (usuario == null || !usuario.validarSenha(senha));

        while (ERRO){
            if(usuario == null){

                tela.outputErro("USER INVALIDO","USER INVALIDO");
                login = tela.inputString_NotReturnNull("Digite Nome","Login","Login Invalido - Tente Novamente");

            }else{
                tela.outputErro("SENHA INVALIDA","SENHA INVALIDA");
            }
            senha = tela.inputString_NotReturnNull("Digite Senha", "Password","Senha Invalida - Tente Novamente");

            usuario = cadastros.buscarUsuario(login);
            ERRO = (usuario == null || !usuario.validarSenha(senha));
        }

        return usuario;
    }

    public void menu(Usuario user){
        Integer opcao;
        Object[] opcoesAdmin = {"Sistema de Cadastros", "Sistema de Reservas", "Sair"};

        if(user instanceof Coordenador){
            opcao = tela.inputBotton("Selecione uma opção", "Sistema Coltec", "Saindo", opcoesAdmin);

            if(opcao == JOptionPane.YES_OPTION){
                cadastros.funcionalidadesSistema();
            } else if (opcao == JOptionPane.NO_OPTION) {
                reservas.funcionalidadesSistema(user, cadastros.getSalasCadastradas());
            }

        }else if(user instanceof  Professor){
            reservas.funcionalidadesSistema(user, cadastros.getSalasCadastradas());
        }

    }

    public void exibirReservas(){
        //reservas.visualizarReservas();
    }

    public ArrayList<Sala> getSalasCadastradas(){
        return cadastros.getSalasCadastradas();
    }

    public ArrayList<Professor> getProfessoresCadastrados(){
        return cadastros.getProfessoresCadastrados();
    }

    public ArrayList<Aluno> getAlunosCadastrados(){
        return cadastros.getAlunosCadastrados();
    }

}
