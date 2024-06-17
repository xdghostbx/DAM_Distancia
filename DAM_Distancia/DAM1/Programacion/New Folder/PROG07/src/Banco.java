
public class Banco {
    //Definimos el objeto array cuenta bancaria con tamaño maximo de 100
    private CuentaBancaria[] cuentas;
    private final int Max_Cuentas = 100;
    private int numeroCuentas;

    // Constructor para la clase banco que inicializa el array cuentas e inicializa numeroCuentas a 0                    
    public Banco(){
        this.cuentas = new CuentaBancaria [this.Max_Cuentas];
        this.numeroCuentas = 0;
    }
    
    // Metodo para abrir una nueva cuentaBancaria. Comprueba que no se alcanzara el numero maximo de cuentas permitido
    public boolean abrirCuenta(CuentaBancaria c){
        if(this.numeroCuentas >= this.Max_Cuentas){
            System.out.println("Numero maximo de cuentas alcanzado");
            return false;
        }
        
        CuentaBancaria existe = this.buscarCuenta(c.getIBAN());
        if (existe != null){
            System.out.println("Esta cuenta ya exsite");
            return false;
        }
        
        this.cuentas[this.numeroCuentas] = c;
        this.numeroCuentas++;
        return true;
    }

    //Metodo que nos devuelve un Array String con la informacion de todas las cuentas del banco
    public String[] listadoCuentas(){
        String[] infoCuentas = new String[this.numeroCuentas];
        for(int i = 0; i<this.numeroCuentas;i++){
            infoCuentas[i] = this.cuentas[i].devolverInfoString();
        }
        return infoCuentas;
    }

    // Metodo  que devuelve la informacion de una cuenta bancaria en base al su IBAN
    public String informacionCuenta(String IBAN){
        CuentaBancaria c = this.buscarCuenta(IBAN);
        if(c!= null){
            return c.devolverInfoString();
        }
        return null;
    }

    // Metodo para realizar un depósito de una cantidad determinada de dinero en una cuenta ban
    public boolean ingresoCuenta(String IBAN, double cantidad){
        CuentaBancaria c = this.buscarCuenta(IBAN);
        if (c != null && cantidad > 0){ //verificamos que no ingrese cantidad negativa
            c.setSaldo(c.getSaldo()+cantidad);
            return true;
        }
        return false;
    }
    
    // Metodo para realizar un retiro de una cantidad determinada de dinero de una cuenta ban
    public boolean retiradaCuenta(String IBAN, double cantidad){
        CuentaBancaria c = this.buscarCuenta(IBAN);
        if (c != null && cantidad > 0){//verificamos que no retire cantidad negativa
            if (c.getSaldo()-cantidad >= 0){
                c.setSaldo(c.getSaldo()-cantidad);
                return true;
            }
            return false;
        }
        return false;
    }
    
    // Metodo para obtener el saldo de una cuente mediante su IBAN
    public double obtenerSaldo (String IBAN){
        CuentaBancaria c = this.buscarCuenta(IBAN);
        if (c != null){
            return c.getSaldo();
        }
        return -1;
    }
    
    // Metodo privado para buscar una cuenta bancaria por medio del IBAN
    private CuentaBancaria buscarCuenta (String IBAN){
        for (int i = 0; i<this.numeroCuentas; i++){
            if(this.cuentas[i].getIBAN().equals(IBAN)){
                return this.cuentas[i];
            }    
        }
        return null;
    }
}
