import java.util.Calendar;
import java.util.GregorianCalendar;

public class Reserva {

    //-------------------------------------- Atribultos Reserva ----------------------------------------------------//

    public static int numReserva;

    private Usuario requisitante;
    private Calendar inicioReserva;
    private Calendar fimReserva;
    private Integer numReservaAtual;

    //------------------------------------ Fim Atribultos Reserva --------------------------------------------------//



    //--------------------------------------- Metodo Construtor ----------------------------------------------------//

    public Reserva(Usuario requisitante, Calendar inicio, int minutosNecessarios){
        this.setRequisitante(requisitante);
        this.setInicioReserva(inicio);
        this.setFimReserva(inicio, minutosNecessarios);
        this.setNumReserva();
        this.setNumReservaAtual(getNumReserva());
    }

    //------------------------------------- Fim Metodo Construtor --------------------------------------------------//



    //----------------------------------------- Metodos Gets -------------------------------------------------------//

    public Usuario getRequisitante() {
        return requisitante;
    }

    public Calendar getInicioReserva() {
        return inicioReserva;
    }

    public Calendar getFimReserva() {
        return fimReserva;
    }

    public int getNumReserva(){
        return numReserva;
    }

    public Integer getNumReservaAtual() {
        return numReservaAtual;
    }

    //--------------------------------------- Fim Metodos Gets -----------------------------------------------------//



    //----------------------------------------- Metodos Sets -------------------------------------------------------//

    public void setRequisitante(Usuario requisitante) {
        this.requisitante = requisitante;
    }

    public void setInicioReserva(Calendar inicioReserva) {
        this.inicioReserva = inicioReserva;
    }

    public void setFimReserva(Calendar inicioReserva, int tempoAula) {
        this.fimReserva = new GregorianCalendar(inicioReserva.get(Calendar.YEAR),
                inicioReserva.get(Calendar.MONTH),
                inicioReserva.get(Calendar.DAY_OF_MONTH),
                inicioReserva.get(Calendar.HOUR_OF_DAY),
                inicioReserva.get(Calendar.MINUTE) + tempoAula);
    }

    public void setNumReserva(){
        numReserva++;
    }

    public void setNumReservaAtual(Integer numReservaAtual) {
        this.numReservaAtual = numReservaAtual;
    }

    //--------------------------------------- Fim Metodos Sets -----------------------------------------------------//



    //-------------------------------------- Metodos Comparação ----------------------------------------------------//

    @Override
    public boolean equals(Object obj) {
        Reserva reservaComparada = (Reserva) obj;

        return this.requisitante.equals(reservaComparada.requisitante)
                        && this.inicioReserva.equals(reservaComparada.inicioReserva)
                                && this.fimReserva.equals(reservaComparada.fimReserva)
                                        && this.numReservaAtual.equals(reservaComparada.numReservaAtual);
    }

    //------------------------------------ Fim Metodos Comparação --------------------------------------------------//



}
