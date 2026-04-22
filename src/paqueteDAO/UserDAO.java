package paqueteDAO;

import paqueteVO.UserVO;
import PaqueteControl.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO {

    // Método para registrar un usuario
    public boolean registrarUsuario(UserVO user) {
        String sql = "INSERT INTO usuarios (nombre, apellidos, email, contraseña) VALUES (?, ?, ?, ?)";
        
        try (Connection con = Conexion.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setString(1, user.getNombre());
            ps.setString(2, user.getApellidos());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getContraseña()); // ¡OJO: Ver nota de seguridad abajo!
            
            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;
            
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // Método para validar el login
    public UserVO validarUsuario(String email, String password) {
        String sql = "SELECT * FROM usuarios WHERE email = ? AND contraseña = ?";
        
        try (Connection con = Conexion.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setString(1, email);
            ps.setString(2, password);
            
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new UserVO(
                        rs.getString("apellidos"),
                        rs.getString("contraseña"),
                        rs.getString("email"),
                        rs.getInt("id_user"),
                        rs.getString("nombre")
                    );
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null; // Retorna null si no encuentra el usuario
    }
}
