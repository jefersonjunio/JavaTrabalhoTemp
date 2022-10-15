
import java.util.ArrayList;
import java.util.Calendar;

public abstract class Sala {

    //---------------------------------------- Atribultos Sala -----------------------------------------------------//

    public static Integer numMaxReservas = 20;

    private  char tipoSala;
    private  Integer numSala = 0;
    private  Integer capacidade;
    private  Integer numReservasRealizadas = 0;
    private  ArrayList<Reserva> reservas = new ArrayList<>(numMaxReservas);

    //-------------------------------------- Fim Atribultos Sala ---------------------------------------------------//



    //--------------------------------------- Metodo Construtor ----------------------------------------------------//

    Sala(char tipoSala, Integer capacidade, Integer numSala){
        this.setTipoSala(tipoSala);
        this.setCapacidade(capacidade);
        this.setNumSala(numSala);
    }

    //------------------------------------- Fim Metodo Construtor --------------------------------------------------//



    //----------------------------------------- Metodos Gets -------------------------------------------------------//

    public char getTipoSala() {
        return tipoSala;
    }

    public Integer getNumSala() {
        return numSala;
    }

    public Integer getCapacidade() {
        return capacidade;
    }

    public Integer getNumReservasRealizadas(){
        return numReservasRealizadas;
    }

    //--------------------------------------- Fim Metodos Gets -----------------------------------------------------//



    //----------------------------------------- Metodos Sets -------------------------------------------------------//

    public void setTipoSala(char tipoSala) {
        this.tipoSala = tipoSala;
    }

    public void setNumSala(Integer numSala) {
        this.numSala = numSala;
    }

    public void setCapacidade(Integer capacidade) {
        this.capacidade = capacidade;
    }

    public void setNumReservasRealizadas(int numReservasRealizadas) {
        this.numReservasRealizadas = numReservasRealizadas;
    }

    //--------------------------------------- Fim Metodos Sets -----------------------------------------------------//



    //--------------------------------------- Adicionar Reserva ----------------------------------------------------//

    public boolean adicionarReserva(Usuario solicitante, Calendar dataInicio){
        boolean retorno = false;
        int numReservas = this.getNumReservasRealizadas();

        if(numReservas < numMaxReservas){
            Reserva nova = new Reserva(solicitante,dataInicio,50);
            reservas.add(nova);
            setNumReservasRealizadas(reservas.size());
            retorno = true;
        }

        return retorno;
    }

    public boolean removerReserva(Usuario solicitante, Calendar dataInicio){
        boolean retorno = false;
        Reserva reservaRemover = new Reserva(solicitante, dataInicio,50);

        for(Reserva res : reservas){
            if(res.equals(reservaRemover)){
                reservas.remove(reservaRemover);
                setNumReservasRealizadas(reservas.size());
                retorno = true;
            }
        }

        return retorno;
    }

    //------------------------------------- Fim Adicionar Reserva --------------------------------------------------//



    //-------------------------------------- Metodos Comparação ----------------------------------------------------//

    @Override
    public boolean equals(Object obj) {
        Sala salaComparada = (Sala) obj;

        return this.numSala.equals(salaComparada.numSala)
                    && this.tipoSala == salaComparada.tipoSala
                    && this.capacidade.equals(salaComparada.capacidade);
    }

    //------------------------------------ Fim Metodos Comparação --------------------------------------------------//

}
