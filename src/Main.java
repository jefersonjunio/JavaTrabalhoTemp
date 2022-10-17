import javax.swing.*;

public class Main {

    static Tela tela = new Tela();
    static SistemaColtec sistemaColtec = new SistemaColtec();

    public static void main(String[] args){
        Usuario user;
        Integer confirm, retorno;
        boolean MENU_LOGIN_CONTINUE = true, MENU_INICIAL_CONTINUE = true;

        do {

            retorno = sistemaColtec.inicializar();

            if(retorno == JOptionPane.YES_OPTION){

                user = sistemaColtec.efetuarLogin();

                do {
                    sistemaColtec.menu(user);

                    confirm = tela.inputConfirmaca("Manter Logado?");
                    if (confirm == JOptionPane.OK_OPTION) {
                        MENU_LOGIN_CONTINUE = false;
                    } else {
                        tela.output("Retornando a tela inicial", "Sistema Coltec" );
                    }
                }while(MENU_LOGIN_CONTINUE);

            }else if(retorno == JOptionPane.NO_OPTION) {

                do {
                    sistemaColtec.exibirReservas();

                    confirm = tela.inputConfirmaca("Continuar Visualizando? ");
                    if (confirm == JOptionPane.OK_OPTION) {
                        MENU_LOGIN_CONTINUE = false;
                    } else {
                        tela.output("Retornando a tela inicial", "Sistema Coltec" );
                    }
                }while(MENU_LOGIN_CONTINUE);

            }else {
                MENU_INICIAL_CONTINUE = false;
            }

        }while (MENU_INICIAL_CONTINUE);

    }

}
