package baseDatosAModelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


import baseDatosAModelo.conexion.Conexion;
import baseDatosAModelo.modelo.Alumno;
import baseDatosAModelo.modelo.Asignatura;
import baseDatosAModelo.Escritura.EscribirArchivo;

public class Principal {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        Conexion conexion = new Conexion();
        /*
        Codigo para hacer la consulta a la base de datos y sacar las notas de un alumno que pasen de X valor
         SELECT n.nota, a.nombreAsignatura
        FROM Notas n
        JOIN Asignaturas a
            ON n.codigoAsignatura = a.codigoAsignatura
        WHERE n.dniAlumno = 'DNI001'
            AND n.nota > 5; 
         
         */
        ArrayList<Alumno> alumnos = new ArrayList<>();
        EscribirArchivo escritura = new EscribirArchivo();
        final String ruta ="src/Archivos/alumnos.txt";
        //consultas SQL
        String sqlAlumnos = "SELECT DISTINCT dniAlumno FROM dbo.Notas";
        PreparedStatement psAlumnos = conexion.getConnection().prepareStatement(sqlAlumnos);
        ResultSet rsAlumnos = psAlumnos.executeQuery();

        while(rsAlumnos.next()){
            String dni = rsAlumnos.getString("dniAlumno");
            Alumno alumno = new Alumno(dni);
            
            //consulta SQL para obtener asignaturas y notas
            String sqlAsignaturas = "SELECT n.nota, a.nombreAsignatura FROM Notas n JOIN Asignaturas a ON n.codigoAsignatura = a.codigoAsignatura WHERE n.dniAlumno = ? AND n.nota > 5";
            PreparedStatement psAsignaturas = conexion.getConnection().prepareStatement(sqlAsignaturas);
            psAsignaturas.setString(1, dni);
            ResultSet rsAsignaturas = psAsignaturas.executeQuery();

            //procesado de resultados
            while(rsAsignaturas.next()){
                String nombreAsignatura = rsAsignaturas.getString("nombreAsignatura");
                double nota = rsAsignaturas.getDouble("nota");
                Asignatura asignatura = new Asignatura(nombreAsignatura, nota);
                alumno.addAsignatura(asignatura);
            }
            rsAsignaturas.close();
            psAsignaturas.close();

            alumnos.add(alumno);
        }

        rsAlumnos.close();
        psAlumnos.close();
        conexion.closeConnection();

        for(Alumno alumno : alumnos){
            System.out.println("DNI: " + alumno.getDni());
            for(Asignatura asignatura : alumno.getAsignaturas()){
                System.out.println("Asignatura: " + asignatura.getNombreAsignatura() + " Nota: " + asignatura.getNota());
                
            }
        }
        escritura.escribir(alumnos, ruta);

        
        

        
    }
}
