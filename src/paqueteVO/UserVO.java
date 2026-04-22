package paqueteVO;

import java.time.LocalDate;

public class UserVO {
    private int id_user;
    private String nombre;
    private String apellidos;
    private String email;
    private String contraseña;
    private LocalDate fecha_nacimiento;
    private double altura;
    private double peso;
    private LocalDate fechaCreacion;
    private int racha;

    public UserVO(String apellidos, String contraseña, String email, int id_user, String nombre, LocalDate fecha_nacimiento, double altura, double peso, LocalDate fechaCreacion, int racha) {
        this.apellidos = apellidos;
        this.contraseña = contraseña;
        this.email = email;
        this.id_user = id_user;
        this.nombre = nombre;
        this.fecha_nacimiento = fecha_nacimiento;
        this.altura = altura;
        this.peso = peso;
        this.fechaCreacion = fechaCreacion;
        this.racha = racha;
    }

    // Setters

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



    public void setFecha_nacimiento(LocalDate fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }



    public void setAltura(double altura) {
        this.altura = altura;
    }



    public void setPeso(double peso) {
        this.peso = peso;
    }



    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }



    public void setRacha(int racha) {
        this.racha = racha;
    }

    // Getters

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

    public LocalDate getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public double getAltura() {
        return altura;
    }

    public double getPeso() {
        return peso;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public int getRacha() {
        return racha;
    }

    @Override
    public String toString() {
        return "UserVO [id_user=" + id_user + ", nombre=" + nombre + ", apellidos=" + apellidos + ", email=" + email
                + ", contraseña=" + contraseña + ", fecha_nacimiento=" + fecha_nacimiento + ", altura=" + altura
                + ", peso=" + peso + ", fechaCreacion=" + fechaCreacion + ", racha=" + racha + "]";
    }
    
}
