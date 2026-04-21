package paqueteVO;

public class UserVO {
    private int id_user;
    private String nombre;
    private String apellidos;
    private String email;
    private String contraseña;

    public UserVO(String apellidos, String contraseña, String email, int id_user, String nombre) {
        this.apellidos = apellidos;
        this.contraseña = contraseña;
        this.email = email;
        this.id_user = id_user;
        this.nombre = nombre;
    }

    public int getId_user() {
        return id_user;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getEmail() {
        return email;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    @Override
    public String toString() {
        return "UserVO [id_user=" + id_user + ", nombre=" + nombre + ", apellidos=" + apellidos + ", email=" + email
            + ", contraseña=" + contraseña + "]";
    }
}
