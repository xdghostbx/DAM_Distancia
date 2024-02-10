
//Definimos la clase cuenta corriente que es heredada de Cuenta Corriente

public class CuentaCorrienteEmpresa extends CuentaCorriente {
    
    //declaramos atributos de la clase
    private double maximoDescubierto;
    private double tipoInteresDescubierto;
    
    //contructor, getter y setter (automaticamente el programa añade los atributos de la clase padre)
    public CuentaCorrienteEmpresa(double maximoDescubierto, double tipoInteresDescubierto, String listaEntidades, Persona titular, double Saldo, String IBAN) {
        super(listaEntidades, titular, Saldo, IBAN);
        this.maximoDescubierto = maximoDescubierto;
        this.tipoInteresDescubierto = tipoInteresDescubierto;
    }

    public double getMaximoDescubierto() {
        return maximoDescubierto;
    }

    public void setMaximoDescubierto(double maximoDescubierto) {
        this.maximoDescubierto = maximoDescubierto;
    }

    public double getTipoInteresDescubierto() {
        return tipoInteresDescubierto;
    }

    public void setTipoInteresDescubierto(double tipoInteresDescubierto) {
        this.tipoInteresDescubierto = tipoInteresDescubierto;
    }
    /*  Sobreescribimos el método devolverInfoString() para devolver una 
     *  representación en forma de cadena
     */
    @Override
    public String devolverInfoString(){
        return super.devolverInfoString() + ", maximoDescubierto=" + maximoDescubierto + ", tipoInteresDescubierto=" + tipoInteresDescubierto;
    }

}
