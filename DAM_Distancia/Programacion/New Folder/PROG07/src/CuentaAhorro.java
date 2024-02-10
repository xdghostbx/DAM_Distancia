
// Definimos la clase cuenta corriente que es heredada de CuentaBancaria
 
public class CuentaAhorro extends CuentaBancaria {
    
    // Declaramos una variable privada para almacenar el tipo de interés anual
    private double tipoInteresAnual;
    
    // Constructor de la clase CuentaAhorro que recibe como parámetros el tipo de interés anual, el titular, el saldo y el IBAN
    public CuentaAhorro(double tipoInteresAnual, Persona titular, double Saldo, String IBAN) {
        super(titular, Saldo, IBAN);
        this.tipoInteresAnual = tipoInteresAnual;
    }

    // Setter y Getter
    public double getTipoInteresAnual() {
        return tipoInteresAnual;
    }
    public void setTipoInteresAnual(double tipoInteresAnual) {
        this.tipoInteresAnual = tipoInteresAnual;
    }
    /*  Sobreescribimos el método devolverInfoString() para incluir el tipo de interés
     *  anual en la representación en forma de cadena
     */
    @Override
    public String devolverInfoString(){
        return super.devolverInfoString() + ", tipoInteresAnual=" + tipoInteresAnual;
    }
    
}
