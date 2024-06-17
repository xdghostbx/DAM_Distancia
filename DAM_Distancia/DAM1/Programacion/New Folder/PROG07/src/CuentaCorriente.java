
// Definimos la clase cuenta corriente que es heredada de CuentaBancaria

public class CuentaCorriente extends CuentaBancaria {
    //definimos la variable privada 
    private String listaEntidades;

    //Constructor de la clase cuenta corriente que hereda atributos de la clase cuenta bancaria
    public CuentaCorriente(String listaEntidades, Persona titular, double Saldo, String IBAN) {
        super(titular, Saldo, IBAN);
        this.listaEntidades = listaEntidades;
    }

    // Getter y Setter
    public String getListaEntidades() {
        return listaEntidades;
    }

    public void setListaEntidades(String listaEntidades) {
        this.listaEntidades = listaEntidades;
    }
    /*  Sobreescribimos el método devolverInfoString() para devolver una 
     *  representación en forma de cadena
     */
    @Override
    public String devolverInfoString(){
        return super.devolverInfoString() + ", listaEntidades=" + listaEntidades;
    }
    
}
