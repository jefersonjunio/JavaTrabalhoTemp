import javax.swing.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class SistemaDeReservas {

    //-------------------------------------- Atribultos Sistema ----------------------------------------------------//

    private Tela tela;

    //------------------------------------ Fim Atribultos Sistema --------------------------------------------------//



    //--------------------------------------- Metodo Construtor ----------------------------------------------------//

    public SistemaDeReservas(){
        this.tela = new Tela();
    }

    //------------------------------------- Fim Metodo Construtor --------------------------------------------------//


    //---------------------------------------- Funcionalidade ------------------------------------------------------//

    public void funcionalidadesSistema(Usuario user, ArrayList<Sala> salas){
        Integer opcao;

        Tela tela = new Tela();

        Object[] funcoesSistema = {"Cadastrar Nova Reserva", "Visualizar Reservas"};
        opcao = tela.inputBotton("Selecione uma opção", "Cadastros Dados", "Opção Invalida", funcoesSistema);

        if(opcao == JOptionPane.YES_OPTION){
            cadastrarReserva(user, salas);
        } else if (opcao == JOptionPane.NO_OPTION) {
            //visulizarReservas();
        }
    }

    public Integer selecionarSala(ArrayList<Sala> salas){
        Integer opc;
        Integer sala;
        Object[] salasDisponiveis = {"Laboratorio", "Convencional"};

        opc = tela.inputBotton("Tipo de Sala", "Reservas de Salas", "Tipo Incorreto", salasDisponiveis);

        if(opc == JOptionPane.YES_OPTION){
            salasDisponiveis = laboratorios(salas, 'D');

        }else if(opc == JOptionPane.NO_OPTION){
            salasDisponiveis = salasConvencionais(salas, 'D');

        }else {
            salasDisponiveis = salas(salas, 'D');
        }

        sala = tela.inputRadial_Select("Selecione uma sala", "Reserva de Salas", "Sala invalida", salasDisponiveis);

        return sala;
    }

    //-------------------------------------- Fim Funcionalidade ----------------------------------------------------//



    //--------------------------------------- Metodos Cadastros ----------------------------------------------------//

    public void cadastrarReserva(Usuario user, ArrayList<Sala> salas){
        Sala salaASerReservada = buscarSala(selecionarSala(salas), salas);
        Calendar data = receberData();

        salaASerReservada.adicionarReserva(user, data);
    }

    //------------------------------------- Fim Metodos Cadastros --------------------------------------------------//



    //------------------------------------- Metodos Receber Dados --------------------------------------------------//

    public Calendar receberData() {
        Tela tela = new Tela();
        Calendar data;

        int dia = tela.inputInt_NotReturnNull("Digite o dia","Dia Reserva","Dia Invalido");
        int hora = tela.inputInt_NotReturnNull("Digite a Hora (sem minutos)","Hora Reserva", "Hora Invalida");

        data = new GregorianCalendar(2022,Calendar.OCTOBER, dia, hora, 0);

        return data;
    }

    //----------------------------------- Fim Metodos Receber Dados ------------------------------------------------//



    //----------------------------------------- Metodos Buscas ----------------------------------------------------//

    public Object[] salasConvencionais(ArrayList<Sala> salas, char disponibilidade){
        Object[] salasObj = new Object[salas.size()];

        if(disponibilidade == 'D'){
            for(int i = 0; i < salas.size(); i++){
                if(salas.get(i) instanceof  SalaConvencional && salas.get(i).isSalaDisponivel())
                    salasObj[i] = salas.get(i).getNumSala();
            }
        }else if(disponibilidade == 'O'){
            for(int i = 0; i < salas.size(); i++){
                if(salas.get(i) instanceof  SalaConvencional && !salas.get(i).isSalaDisponivel())
                    salasObj[i] = salas.get(i).getNumSala();
            }
        }else {
            for(int i = 0; i < salas.size(); i++){
                if(salas.get(i) instanceof  SalaConvencional)
                    salasObj[i] = salas.get(i).getNumSala();
            }
        }

        return salasObj;
    }

    public Object[] laboratorios(ArrayList<Sala> salas, char disponibilidade){
        Object[] salasObj = new Object[salas.size()];

        if(disponibilidade == 'D'){
            for(int i = 0; i < salas.size(); i++){
                if(salas.get(i) instanceof  SalaLaboratorio && salas.get(i).isSalaDisponivel())
                    salasObj[i] = salas.get(i).getNumSala();
            }
        }else if(disponibilidade == 'O'){
            for(int i = 0; i < salas.size(); i++){
                if(salas.get(i) instanceof  SalaLaboratorio && !salas.get(i).isSalaDisponivel())
                    salasObj[i] = salas.get(i).getNumSala();
            }
        }else {
            for(int i = 0; i < salas.size(); i++){
                if(salas.get(i) instanceof  SalaConvencional)
                    salasObj[i] = salas.get(i).getNumSala();
            }
        }

        return salasObj;
    }

    public Object[] salas(ArrayList<Sala> salas, char disponibilidade){
        Object[] salasObj = new Object[salas.size()];

        if(disponibilidade == 'D'){
            for(int i = 0; i < salas.size(); i++){
                if(salas.get(i).isSalaDisponivel())
                    salasObj[i] = salas.get(i).getNumSala();
            }
        }else if (disponibilidade == 'O'){
            for(int i = 0; i < salas.size(); i++){
                if(!salas.get(i).isSalaDisponivel())
                    salasObj[i] = salas.get(i).getNumSala();
            }
        }else
            for(int i = 0; i < salas.size(); i++){
                salasObj[i] = salas.get(i).getNumSala();
            }

        return salasObj;
    }

    public Sala buscarSala(Integer numero, ArrayList<Sala> salas){
        Sala retorno = null;
        for (Sala atual : salas){
            if(numero.equals(atual.getNumSala())){
                retorno = atual;
            }
        }
        return retorno;
    }

    //--------------------------------------- Fim Metodos Buscas --------------------------------------------------//
}
