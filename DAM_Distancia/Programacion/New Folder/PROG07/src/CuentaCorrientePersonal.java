
// Definimos la clase cuenta corriente personal que es heredada de Cuenta Corriente

public class CuentaCorrientePersonal extends CuentaCorriente {
    //declaramos atributos de la clase
    private double comisionMantenimiento;

    //constructor, getter y setter. tambien se añaden los atributos de la clase padre
    public CuentaCorrientePersonal(double comisionMantenimiento, String listaEntidades, Persona titular, double Saldo, String IBAN) {
        super(listaEntidades, titular, Saldo, IBAN);
        this.comisionMantenimiento = comisionMantenimiento;
    }

    public double getComisionMantenimiento() {
        return comisionMantenimiento;
    }

    public void setComisionMantenimiento(double comisionMantenimiento) {
        this.comisionMantenimiento = comisionMantenimiento;
    }

    /*  Sobreescribimos el método devolverInfoString() para devolver una 
     *  representación en forma de cadena
     */
    @Override
    public String devolverInfoString(){
        return super.devolverInfoString() + ", comisionMantenimiento=" + comisionMantenimiento;
    }
  
}
