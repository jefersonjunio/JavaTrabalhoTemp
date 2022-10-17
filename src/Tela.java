import javax.swing.*;

public class Tela {

    public String inputString_NotReturnNull(String comando, String title, String mensagemErro) {
        String retorno;

        retorno = JOptionPane.showInputDialog(null,comando,title, JOptionPane.PLAIN_MESSAGE);

        while (null == retorno){
            outputErro(mensagemErro,"ERRO " + title);
            retorno = JOptionPane.showInputDialog(null,comando,title, JOptionPane.PLAIN_MESSAGE);
        }

        return retorno;
    }

    public int inputInt_NotReturnNull(String comando, String title, String mensagemErro){
        int retorno;

        retorno = Integer.parseInt(JOptionPane.showInputDialog(null,comando,title, JOptionPane.PLAIN_MESSAGE));

        while (retorno == 0){
            outputErro(mensagemErro,"ERRO " + title);
            retorno = Integer.parseInt(JOptionPane.showInputDialog(comando));
        }

        return retorno;
    }

    public Integer inputRadial_Select(String comando, String title, String mensagemErro, Object[] list){
        Integer retorno;

        JPanel panel = new JPanel();
        panel.add(new JLabel(comando));

        retorno = JOptionPane.showOptionDialog(null,panel,title,
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,null, list, list[0]);

        while (retorno == null){
            outputErro(title,mensagemErro);

            retorno = JOptionPane.showOptionDialog(null,panel,title,
                    JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,null, list, list[0]);
        }

        return retorno;
    }

    public int inputConfirmaca(String mensagem){
        int retorno;
        retorno = JOptionPane.showConfirmDialog(null, mensagem);
        return retorno;
    }

    public Integer inputBotton(String comando, String title, String mensagemErro, Object[] listaopcs){
        Integer retorno;

        JPanel panel = new JPanel();
        panel.add(new JLabel(comando));

        retorno = JOptionPane.showOptionDialog(null, panel,title, JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.PLAIN_MESSAGE, null, listaopcs, null);

        return retorno;
    }

    public void outputErro(String title, String mensagemErro){
        JOptionPane.showMessageDialog(null, title, mensagemErro, JOptionPane.ERROR_MESSAGE);
    }

    public void output(String title, String mensagem){
        JOptionPane.showMessageDialog(null, title, mensagem, JOptionPane.PLAIN_MESSAGE);
    }

    public void exitOption(){
        JOptionPane.getRootFrame().dispose();
    }

}
