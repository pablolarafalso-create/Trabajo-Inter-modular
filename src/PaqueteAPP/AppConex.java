package PaqueteAPP;

import PaqueteDAO.AlumnoDAO;
import PaqueteDAO.Conexion;
import PaqueteVO.AlumnoVO;
import java.sql.Connection;
import java.util.List;


public class AppConex {
    public static void main (String[] args){
        //Creamos el Dao para ejecutar las operaciones disponibles

        try {
            //Establecer la conexión
            Connection conex = Conexion.getConexion();
            System.out.println("Conexion realizada con exito");

            //Consultar los alumnos
            List<AlumnoVO> usuarios = a1DAO.obtenerAlumnos(conex);

            for(AlumnoVO alum: alumnos){
                System.out.println(alum);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}