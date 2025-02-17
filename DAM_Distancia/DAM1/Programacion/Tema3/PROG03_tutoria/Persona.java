/*
 * Copyright 2023 Módulo Programación
 * https://www.edu.xunta.gal/fpadistancia/
 */
package tutoria;

/**
 *
 * @author xdGHOSTbx
 */
public class Persona {
    //Atributos
    private String nombre;
    private String apellidos;
    private int edad;
    private double peso;
    private double estatura;
    private int codigo;
    
    //Constructor sin parametros
    public Persona(){
        this.nombre = "Sin especificar";
        this.apellidos = "Sin especificar";
        this.edad = 0;
        this.peso = 0;
        this.estatura = 0;
        this. codigo = 0;
    }
    //Constructor con todos los parametros
    public Persona(String nombre, String apellidos, int edad, double peso,
            double altura, int codigo) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
        this.peso = peso;
        this.estatura = altura;
        this.codigo = codigo;
        /** Para definirlo en el programa
         *  Persona nombreDePersona = new Persona ("Dani", "Martinez", edad, peso, estatura, codigo);
         */
    }
    
    //Get y Set
    public String getNombre(){
        return nombre;
    }
    public void setNombre (String nombre){
        this.nombre = nombre;
    }
    public String getApellidos(){
        return apellidos;
    }
    public void setApellidos (String apellidos){
        this.apellidos = apellidos;
    }
    public int getEdad(){
        return edad;
    }
    public void setEdad(int edad){
        this.edad = edad;
    }
    public double getPeso(){
        return peso;
    }
    public void setPeso(double peso){
        this.peso = peso;
    }
    public double getEstatura(){
        return estatura;
    }
    public void setEstatura(double estatura){
        this.estatura = estatura;
    }
    public int getCodigo(){
        return codigo;
    }
    public void setCodigo(int codigo){
        this.codigo = codigo;
    }
    
    
    //Añadiendo metodos
    public double calcularIMC(){
        double estaturaMetros = estatura/100;
        return peso / (estaturaMetros*estaturaMetros);
    }
    public boolean esMayorDeEdad(){
        return edad >= 18;
    }
    
    private boolean esCorrectaEdad (int edad){
        return edad>=0 && edad<=150;
    }
    
    public void imprimirDatos(){
        System.out.println("Los datos del usuario son: ");
        System.out.println("Nombre: " + nombre);
        System.out.println("Apellidos: " + apellidos);
        System.out.println("Edad: " + edad);
        System.out.println("Peso: " + peso);
        System.out.println("Estatura: " + estatura);
        System.out.println("Código: " + codigo);
        System.out.println("IMC: " + calcularIMC());
        System.out.println("Mayor de edad: " + esMayorDeEdad());
    }
}
