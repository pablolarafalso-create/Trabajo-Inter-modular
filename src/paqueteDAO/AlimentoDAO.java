package paqueteDAO;

import paqueteVO.AlimentoVO;
import PaqueteControl.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AlimentoDAO {

    public List<AlimentoVO> obtenerAlimentos() {
        String consulta = "SELECT id_alimento, nombre, kcal, proteinas, carbohidratos, grasas FROM alimento";
        List<AlimentoVO> listaAlimentos = new ArrayList<>();

        // Usamos try-with-resources para cerrar la conexión automáticamente al terminar
        try (Connection con = Conexion.getConnection();
            PreparedStatement ps = con.prepareStatement(consulta);
            ResultSet resultado = ps.executeQuery()) {

            while (resultado.next()) {
                // Creamos el objeto VO con los datos obtenidos
                AlimentoVO alim = new AlimentoVO(
                    resultado.getDouble("id_alimento"), 
                    resultado.getDouble("nombre"), 
                    resultado.getInt("Kcal"),  
                    resultado.getInt("proteinas"), 
                    resultado.getString("carbohidratos"), 
                    resultado.getDouble("grasas") 
                );
                
                listaAlimentos.add(alim);
            }

        } catch (Exception e) {
            e.printStackTrace();
            // Dependiendo de tu arquitectura, podrías querer lanzar una RuntimeException aquí
        }
        
        return listaAlimentos;
    }
}