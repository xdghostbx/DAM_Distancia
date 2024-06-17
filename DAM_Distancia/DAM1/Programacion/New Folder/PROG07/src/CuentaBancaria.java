//definimos la clase abstracta que imprementa Imprimible. Al ser abstracta solo puede usarse como base para otras clases
public abstract class CuentaBancaria implements Imprimible {
    // Declaramos variables privadas
    private Persona titular;
    private double Saldo;
    private String IBAN;

    // Constructor de la clase CuentaBancaria
    public CuentaBancaria(Persona titular, double Saldo, String IBAN) {
        this.titular = titular;
        this.Saldo = Saldo;
        this.IBAN = IBAN;
    }

    //Distintos getter  y setter para las variables
    public Persona getTitular() {
        return titular;
    }

    public void setTitular(Persona titular) {
        this.titular = titular;
    }

    public double getSaldo() {
        return Saldo;
    }

    public void setSaldo(double Saldo) {
        this.Saldo = Saldo;
    }

    public String getIBAN() {
        return IBAN;
    }

    public void setIBAN(String IBAN) {
        this.IBAN = IBAN;
    }
    
    /*  Sobreescribimos el método devolverInfoString() para devolver una 
     *  representación en forma de cadena
     */
    @Override
    public String devolverInfoString(){
        return "titular=" + titular.devolverInfoString() + ", Saldo=" + Saldo + ", IBAN=" + IBAN;
    }
  
}
