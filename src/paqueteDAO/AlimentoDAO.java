package PaqueteDAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Statement;

public class AlimentoDAO {
    public List<AlimentoDAO> obtenerAlimentos(String alimentos)throws SQLException{
        String consulta = "Select  from alimento";


        List<AlimentoDAO> alimento = new ArrayList<>();

        try (Statement stmt = alimentos.createStatement();
            ResultSet resultado = stmt.executeQuery(consulta)){

            AlimentoDAO alim = new AlimentoDAO(id_alimento);
            alimento.add(alim);


        } catch (Exception e) {
            e.printStackTrace();
        }
        return alimento;
    }
}