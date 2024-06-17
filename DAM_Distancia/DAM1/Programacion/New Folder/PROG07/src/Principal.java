//importamos Scanner y la excepcion para cuando usamos el scanner y el usuario introduce un dato incorrecto
import java.util.InputMismatchException;
import java.util.Scanner;


//Definimos la clase principal
public class Principal {

    public static void main(String[] args) {
        
        Scanner entrada = new Scanner (System.in);
        int opcion = 0, claseCuenta;
        String nombreTitular, apellidosTitular, dniTitular, IBAN, listaEntidades,informacionCuenta;
        double saldo, tipoInteres, comisionManteniemiento, maximoDescubierto = 0, tipoInteresDescubierto = 0, cantidad;
        String[] listaCuentas;
        Persona titular;
        Banco banco = new Banco();
        CuentaBancaria cuenta = null;
        //Bucle para permanecer en el menu hasta que seleccionemos 7 (salir)
        while (opcion != 7) {
            try {
                System.out.println("Selecciona una de las opciones siguentes: ");
                System.out.println("1.- Abrir una nueva cuenta.");
                System.out.println("2.- Ver un listado de las cuentas disponibles (código de cuenta, titular y saldo actual).");
                System.out.println("3.- Obtener los datos de una cuenta concreta.");
                System.out.println("4.- Realizar un ingreso en una cuenta.");
                System.out.println("5.- Retirar efectivo de una cuenta.");
                System.out.println("6.- Consultar el saldo actual de una cuenta.");
                System.out.println("7.- Salir de la aplicación.");
                opcion = entrada.nextInt();

                switch (opcion){
                    case 1://abrir nueva cuenta
                    //Pedimos los datos al usuario. Mediante expresiones regulares validamos el DNI
                        System.out.println("Introduce el nombre del titular");
                        nombreTitular = entrada.next();

                        System.out.println("Introduce los apellidos del titular");
                        apellidosTitular = entrada.next();

                        System.out.println("Introduce el DNI del titular");
                        dniTitular = entrada.next();
                        if (!dniTitular.matches("^[0-9]{8}[T|R|W|A|G|M|Y|F|P|D|X|B|N|J|Z|S|Q|V|H|L|C|K|E]$")){
                            //lanzamos una excepcion si el dni no es valido
                            throw new Exception("El DNI no tiene el formato correcto");
                        }
                        
                        //creamos un nuevo objeto de la clase persona  y lo asignamos a la variable titular
                        titular = new Persona (nombreTitular, apellidosTitular, dniTitular);

                        //pedimos y validamos IBAN mediante expresiones regulares
                        System.out.println("Introduce el IBAN");
                        IBAN = entrada.next();
                        if (!IBAN.matches("^ES[0-9]{20}$")){
                            //lanzamos una excepcion si el dni no es valido
                            throw new Exception ("El IBAN no tiene formato correcto");
                        }
                        /*
                         * A partir de aqui predimos saldo inicial, preguntamos el tipo de cuenta y nos lleva
                         * a un submenu donde pedimos el tipo de comision y de cuanto sería
                         * Tambien pedimos el tipo de interes y la lista de entidades autorizadas
                         * 
                         * A mayores, despues de pedir los datos, creamos un nuevo objeto de la clase
                         * Cuenta (ahorro, CorrientePersonal, CorrienteEmpresa) del tipo que sea con el
                         * nombre cuenta y lo asignamos a la variable cuenta
                         */
                        System.out.println("Introduce el saldo inicial");
                        saldo = entrada.nextDouble();

                        System.out.println("Escoge tu tpo de cuenta:");
                        System.out.println("1.- Cuenta ahorro");
                        System.out.println("2.- Cuenta corriente personal");
                        System.out.println("3.- Cuenta corriente empresa");
                        claseCuenta = entrada.nextInt();
                        switch(claseCuenta){
                            case 1:
                                System.out.println("Introduce el tipo de interes");
                                tipoInteres = entrada.nextDouble();
                                cuenta = new CuentaAhorro(tipoInteres, titular, saldo, IBAN);
                                break;
                            case 2:
                                System.out.println("Introduce la lista de entidades autorizadas");
                                listaEntidades = entrada.next();
                                System.out.println("Introduce la comision de mantenimiento");
                                comisionManteniemiento = entrada.nextDouble();
                                cuenta = new CuentaCorrientePersonal(comisionManteniemiento, listaEntidades, titular, saldo, IBAN);
                                break;
                            case 3:
                                System.out.println("Introduce la lista de entidades autorizadas");
                                listaEntidades = entrada.next();
                                cuenta = new CuentaCorrienteEmpresa(maximoDescubierto, tipoInteresDescubierto,listaEntidades, titular, saldo, IBAN);
                                break;
                            default:
                                throw new Exception ("Debes escoger un tipo de cuenta");
                            }
                        
                            if (banco.abrirCuenta(cuenta)) {
                                System.out.println("Se ha abierto la cuenta con exito");
                            } else {
                                System.out.println("Ha habido un error al abrir la cuenta");
                            }

                        break;

                    case 2: //ver listado de cuentas
                        //llamamos al metodo listadoCuentas()de la clase banco y mediante un bucle for recorremos todas las cuentas guardadas
                             listaCuentas = banco.listadoCuentas();
                             for (int i = 0; i < listaCuentas.length; i++) {
                                 System.out.println(listaCuentas[i]);
                             }
                        break;

                    case 3: //obtener los datos de una cuenta en concreto

                    //pedimos el IBAN de la cuenta a buscar. Los buscamos en el metodo informacionCuenta() de la clase banco
                    //mediante el parametro IBAN, si existe, nos saca los datos que le pusimos en el metodo
                        System.out.println("Introduce el IBAN");
                        IBAN = entrada.next();

                        informacionCuenta = banco.informacionCuenta(IBAN);
                        if (informacionCuenta != null) {
                            System.out.println(informacionCuenta);
                        } else {
                            System.out.println("La cuenta no existe");
                        }

                        break;

                    case 4: //realizar un ingreso en la cuenta

                    //al igual que antes, buscamos el IBAN en la clase banco y pedimos una cantidad a ingresar para sumarla a la que hay guardada
                        System.out.println("Introduce el IBAN");
                        IBAN = entrada.next();

                        System.out.println("Introduce una cantidad");
                        cantidad = entrada.nextDouble();

                        if (banco.ingresoCuenta(IBAN, cantidad)) {
                            System.out.println("El ingreso se hizo correctamente");
                        } else {
                            System.out.println("El ingreso no se hizo correctamente");
                        }
                        break;

                        case 5: //retirar dinero de una cuenta
                            //al igual que antes, buscamos el IBAN de la clase banco y pedimos una cantidad a returar. Si es correcta, la resta
                            System.out.println("Introduce el IBAN");
                            IBAN = entrada.next();

                            System.out.println("Introduce una cantidad");
                            cantidad = entrada.nextDouble();

                            if (banco.retiradaCuenta(IBAN, cantidad)) {
                                System.out.println("Se ha retirado correctamente");
                            } else {
                                System.out.println("La retirada no se ha realizado");
                            }
                            break;

                        case 6: //consultar el saldo actual de la cuenta
                        //repetimso buscar el IBAN en la clase banco. Si todo está bien, nos muestra el saldo por pantalla
                            System.out.println("Introduce el IBAN");
                            IBAN = entrada.next();

                            saldo = banco.obtenerSaldo(IBAN);
                            if (saldo != -1) {
                                System.out.println("El saldo es: " + saldo);
                            } else {
                                System.out.println("La cuenta no existe");
                            }
                            break;
                        case 7:
                            System.out.println("Saliendo...");;
                            break;
                }
                //recogemos la excepcion "error" al introducir un dato incorrecto con una limpieza de buffer para que no persista en el priograma
            } catch (InputMismatchException error) {
                entrada.next();
                // recogemos otra excepcion para manejar cualquier otro tipo de error que pyueda saltar duarante el programa que nos devuelve el mensaje para saber cual ha sido el error
            } catch (Exception error) {
                System.out.println(error.getMessage());
            }
        }
    }
        
}
    