import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Club club = new Club();

        int opcionRol;

        do {
            System.out.println("\n=== SISTEMA DE GESTIÓN DE RESERVAS DE CANCHAS ===");
            System.out.println("Seleccione su rol:");
            System.out.println("1. Cliente");
            System.out.println("2. Administrador");
            System.out.println("3. Empleado");
            System.out.println("0. Salir");
            System.out.print("Opción: ");
            opcionRol = scanner.nextInt();

            switch (opcionRol) {
                case 1:
                    menuCliente(scanner, club);
                    break;
                case 2:
                    menuAdministrador(scanner, club);
                    break;
                case 3:
                    menuEmpleado(scanner, club);
                    break;
                case 0:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcionRol != 0);

        scanner.close();
    }

    public static void menuCliente(Scanner scanner, Club club, Cliente cliente) {
        int opcion;
        do {
            System.out.println("\n--- MENÚ CLIENTE ---");
            System.out.println("1. Consultar disponibilidad");
            System.out.println("2. Realizar reserva");
            System.out.println("3. Cancelar reserva");
            System.out.println("4. Modificar horario de reserva");
            System.out.println("5. Activar membresía");
            System.out.println("6. Realizar encuesta");
            System.out.println("7. Dejar opinión");
            System.out.println("0. Volver");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    club.consultarDisponibilidad(scanner);
                    break;
                case 2:
                    club.realizarReserva(scanner, cliente);
                    break;
                case 3:
                    club.cancelarReserva(scanner, cliente);
                    break;
                case 4:
                    club.modificarReserva(scanner, cliente);
                    break;
                case 5:
                    cliente.activarMembresia();
                    break;
                case 6:
                    club.realizarEncuesta(scanner);
                    break;
                case 7:
                    System.out.print("Ingrese su opinión: ");
                    String opinion = scanner.nextLine();
                    club.agregarOpinion(opinion);
                    break;
                case 0:
                    System.out.println("Saliendo del menú cliente...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 0);
    }


    public static void menuAdministrador(Scanner scanner, Club club) {
        int opcion;
        do {
            System.out.println("\n--- MENÚ ADMINISTRADOR ---");
            System.out.println("1. Ver estadísticas");
            System.out.println("2. Ver mantenimiento");
            System.out.println("3. Programar mantenimiento");
            System.out.println("4. Crear torneo");
            System.out.println("5. Ver fixture");
            System.out.println("6. Ver reportes mensuales");
            System.out.println("7. Gestionar empleados/entrenadores");
            System.out.println("0. Volver");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    club.mostrarEstadisticas();
                    break;
                case 2:
                    club.verMantenimientos();
                    break;
                case 3:
                    club.programarMantenimiento(scanner);
                    break;
                case 4:
                    club.crearTorneo(scanner);
                    break;
                case 5:
                    club.verFixture();
                    break;
                case 6:
                    club.generarReportesMensuales(scanner);
                    break;
                case 7:
                    club.gestionarPersonal(scanner);
                    break;
                case 0:
                    System.out.println("Saliendo del menú administrador...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 0);
    }


    public static void menuEmpleado(Scanner scanner, Club club, Empleado empleado) {
        int opcion;
        do {
            System.out.println("\n--- MENÚ EMPLEADO ---");
            System.out.println("1. Registrar mantenimiento");
            System.out.println("2. Ver opiniones (una por una)");
            System.out.println("3. Ver encuestas");
            System.out.println("0. Volver");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    club.registrarMantenimiento(scanner, empleado);
                    break;
                case 2:
                    club.verOpinionesUnaPorUna(scanner);
                    break;
                case 3:
                    club.verRespuestasEncuestas();
                    break;
                case 0:
                    System.out.println("Saliendo del menú empleado...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 0);
    }

}
