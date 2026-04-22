package PaqueteAPP;

import paqueteDAO.UserDAO;
import paqueteDAO.ComidaDAO;
import paqueteVO.UserVO;
import paqueteVO.ComidaVO;

import java.util.List;
import java.util.Scanner;

import PaqueteControl.Conexion;

import java.sql.Connection;

public class AppController {

    private Scanner sc = new Scanner(System.in);
    private UserDAO userDAO = new UserDAO();
    private ComidaDAO comidaDAO = new ComidaDAO();

    public void iniciar() {
        int opcion;

        do {
            mostrarMenu();
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    listarUsuarios();
                    break;
                case 2:
                    registrarDieta();
                    break;
                case 3:
                    registrarComida();
                    break;
                case 4:
                    registrarAlimento();
                    break;
                case 5:
                    verMacros();
                    break;
                case 6:
                    objetivoDiario();
                    break;
                case 7:
                    registroDiario();
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida");
            }

        } while (opcion != 0);
    }

    private void mostrarMenu() {
        System.out.println("\n=== FOOD TRACKER ===");
        System.out.println("1. Ver usuarios");
        System.out.println("2. Registrar dieta");
        System.out.println("3. Registrar comida");
        System.out.println("4. Registrar alimento");
        System.out.println("5. Ver macros");
        System.out.println("6. Objetivo diario");
        System.out.println("7. Registro");
        System.out.println("0. Salir");
    }

    private void listarUsuarios() {
        try {
            Connection con = Conexion.getConexion();
            List<UserVO> usuarios = userDAO.obtenerUsuarios(con);

            for (UserVO u : usuarios) {
                System.out.println(u);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void registrarComida() {
        try {
            System.out.println("Nombre comida:");
            String nombre = sc.next();

            System.out.println("Calorías:");
            int calorias = sc.nextInt();

            ComidaVO comida = new ComidaVO(nombre, calorias);

            Connection con = Conexion.getConexion();
            comidaDAO.insertarComida(con, comida);

            System.out.println("Comida registrada!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void verMacros() {
        try {
            Connection con = Conexion.getConexion();
            List<ComidaVO> comidas = comidaDAO.obtenerComidas(con);

            int totalCalorias = 0;

            for (ComidaVO c : comidas) {
                totalCalorias += c.getCalorias();
            }

            System.out.println("Calorías totales: " + totalCalorias);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}