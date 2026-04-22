package paqueteDAO;

import PaqueteControl.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import paqueteVO.UserVO;

public class UserDAO {

    
    // Método para registrar un usuario
    public boolean registrarUsuario(UserVO user) {
        // La consulta SQL usa signos de interrogación (?) como marcadores de posición
        String sqluser = "INSERT INTO usuarios (nombre, apellidos, email, contraseña) VALUES (?, ?, ?, ?)";
        
        try (Connection con = Conexion.getConnection();
            PreparedStatement ps = con.prepareStatement(sqluser)) {
            
            // Reemplaza cada ? con los valores obtenidos de tu objeto UserVO
            ps.setString(1, user.getNombre());
            ps.setString(2, user.getApellidos());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getContraseña());
            
            // Ejecuta el INSERT y devuelve el número de filas insertadas (ej. 1)
            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;
            
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // Método que busca si un usuario existe con un email y contraseña dados
    public UserVO validarUsuario(String email, String password) {
        // Consulta para filtrar registros que coincidan con email y password
        String sqluser = "SELECT * FROM usuarios WHERE email = ? AND contraseña = ?";
        
        try (Connection con = Conexion.getConnection();
            PreparedStatement ps = con.prepareStatement(sqluser)) {
            
            // Asigna los parámetros de búsqueda a los signos de interrogación
            ps.setString(1, email);
            ps.setString(2, password);
            
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    // Crea un objeto UserVO con los datos que regresó la base de datos
                    return new UserVO(
                        rs.getString("id_user"),
                        rs.getString("nombre"),
                        rs.getString("apellidos"),
                        rs.getInt("email"),
                        rs.getString("contraseña")
                    );
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null; // Retorna null si no encuentra el usuario
    }
}