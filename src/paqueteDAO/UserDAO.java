package paqueteDAO;

import PaqueteControl.Conexion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import paqueteVO.UserVO;

public class UserDAO {

    // Método para registrar un usuario
    public boolean registrarUsuario(UserVO user) {
        // SQL sin id_user porque la base de datos lo genera automáticamente (AUTO_INCREMENT)
        String sqluser = "INSERT INTO usuarios (apellidos, contraseña, email, nombre, fecha_nacimiento, altura, peso, fechaCreacion, racha) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        try (Connection con = Conexion.getConnection();
            PreparedStatement ps = con.prepareStatement(sqluser)) {
            
            // Mapeamos los datos del objeto al SQL
            ps.setString(1, user.getApellidos());
            ps.setString(2, user.getContraseña());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getNombre());
            ps.setDate(5, Date.valueOf(user.getFecha_nacimiento()));
            ps.setDouble(6, user.getAltura());
            ps.setDouble(7, user.getPeso());
            ps.setDate(8, Date.valueOf(user.getFechaCreacion()));
            ps.setInt(9, user.getRacha());
            
            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;
            
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // Método que busca si un usuario existe
    public UserVO validarUsuario(String email, String password) {
        String sqluser = "SELECT * FROM usuarios WHERE email = ? AND contraseña = ?";
        
        try (Connection con = Conexion.getConnection();
            PreparedStatement ps = con.prepareStatement(sqluser)) {
            
            ps.setString(1, email);
            ps.setString(2, password);
            
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    // AQUÍ USAMOS EL ORDEN EXACTO DE TU CONSTRUCTOR DE UserVO:
                    // (apellidos, contraseña, email, id_user, nombre, fecha_nacimiento, altura, peso, fechaCreacion, racha)
                    return new UserVO(
                        rs.getString("apellidos"),
                        rs.getString("contraseña"),
                        rs.getString("email"),
                        rs.getInt("id_user"),
                        rs.getString("nombre"),
                        rs.getDate("fecha_nacimiento").toLocalDate(),
                        rs.getDouble("altura"),
                        rs.getDouble("peso"),
                        rs.getDate("fechaCreacion").toLocalDate(),
                        rs.getInt("racha")
                    );
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean  actualizarUsuario(UserVO user){
        // La sentencia UPDATE modifica los campos específicos donde coincida el id_user
        String sqluser = "UPDATE usuarios SET nombre = ?, apellidos = ?, email = ?, contraseña = ?, " +
                    "fecha_nacimiento = ?, altura = ?, peso = ?, fechaCreacion = ?, racha = ? " +
                    "WHERE id_user = ?";

        try (Connection con = Conexion.getConnection();
        PreparedStatement ps = con.prepareStatement(sqluser)){
            // Asignamos los nuevos valores a los parámetros
            ps.setString(1, user.getNombre());
            ps.setString(2, user.getApellidos());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getContraseña());
            ps.setDate(5, Date.valueOf(user.getFecha_nacimiento()));
            ps.setDouble(6, user.getAltura());
            ps.setDouble(7, user.getPeso());
            ps.setDate(8, Date.valueOf(user.getFechaCreacion()));
            ps.setInt(9, user.getRacha());

            // El id_user va en el parámetro 10, correspondiente al WHERE
            ps.setInt(10,user.getId_user());



            int filasAfectadas  = ps.executeUpdate();

            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}