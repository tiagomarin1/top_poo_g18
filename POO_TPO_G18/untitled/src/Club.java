import java.time.YearMonth;
import java.util.*;

public class Club {
    private List<Reserva> reservas;
    private List<Mantenimiento> mantenimientos;
    private List<Empleado> empleados;
    private List<Entrenador> entrenadores;
    private List<Torneo> torneos;
    private List<Reporte> reportes;
    private List<Encuesta> encuestas;
    private List<Opinion> opiniones;

    public Club() {
        reservas = new ArrayList<>();
        mantenimientos = new ArrayList<>();
        empleados = new ArrayList<>();
        entrenadores = new ArrayList<>();
        torneos = new ArrayList<>();
        reportes = new ArrayList<>();
        encuestas = new ArrayList<>();
        opiniones = new ArrayList<>();
    }

    public void consultarDisponibilidad() {
        System.out.println("Mostrando disponibilidad de canchas...");
        // Lógica para mostrar disponibilidad
    }

    public void realizarReserva() {
        System.out.println("Reserva realizada exitosamente.");
        // Lógica para registrar una reserva
    }

    public void cancelarReserva() {
        System.out.println("Reserva cancelada exitosamente.");
        // Lógica para marcar una reserva como cancelada
    }

    public void modificarReserva() {
        System.out.println("Modificación de reserva: solo se permite cambiar el horario.");
        // Lógica para modificar el horario de una reserva existente
    }

    public void realizarEncuesta() {
        System.out.println("Encuesta completada.");
        // Lógica para registrar encuesta anónima
    }

    public void gestionarEmpleados() {
        System.out.println("Gestionando empleados...");
        // Lógica para alta/baja/modificación de empleados
    }

    public void gestionarEntrenadores() {
        System.out.println("Gestionando entrenadores...");
        // Lógica para gestionar entrenadores
    }

    public void verEstadisticas() {
        System.out.println("Estadísticas: porcentaje de uso y días más activos.");
        // Lógica para calcular estadísticas de ocupación
    }

    public void crearTorneo() {
        System.out.println("Torneo creado con fixture automático.");
        // Lógica para registrar torneo y generar fixture
    }

    public void programarMantenimiento() {
        System.out.println("Mantenimiento programado y cancha bloqueada automáticamente.");
        // Lógica para registrar mantenimiento y bloquear cancha
    }

    public void verReportes() {
        System.out.println("Reportes mensuales: ingresos por reservas y gastos por mantenimiento.");
        // Lógica para mostrar reportes financieros y de reservas
    }

    public void registrarMantenimiento() {
        System.out.println("Mantenimiento registrado correctamente.");
        // Lógica de registro de mantenimiento por empleado
    }

    public void verTareasOperativas() {
        System.out.println("Mostrando tareas operativas...");
        // Lógica para mostrar tareas operativas
    }

    public void realizarReserva(Cliente cliente, Cancha cancha, Horario horario, int metodoPago) {
        // Verificar disponibilidad
        if (!cancha.getHorariosDisponibles().contains(horario)) {
            System.out.println("La cancha que queres seleccionar no está disponible en este horario.");
            return;
        }

        // Calcular costo (descuento si tiene membresía)
        double costoBase = cancha.getPrecio();
        double descuento = (cliente.tieneMembresia()) ? 0.2 : 0.0; // 20% de descuento
        double costoFinal = costoBase * (1 - descuento);

        // Crear y guardar reserva
        Reserva nuevaReserva = new Reserva(cliente, cancha, horario, metodoPago, costoFinal);
        reservas.add(nuevaReserva);

        // Bloquear horario
        cancha.getHorariosDisponibles().remove(horario);

        System.out.println("Reserva realizada con éxito. Total: $" + costoFinal);
    }

    public void modificarReserva(Cliente cliente, Reserva reserva, Horario nuevoHorario) {
        // Validar que la reserva pertenezca al cliente
        if (!reserva.getCliente().equals(cliente)) {
            System.out.println("No puedes modificar una reserva que no te pertenece.");
            return;
        }

        Cancha cancha = reserva.getNombre();

        // Verificar que el nuevo horario esté disponible
        if (!cancha.getHorariosDisponibles().contains(nuevoHorario)) {
            System.out.println("La cancha no está disponible en el nuevo horario seleccionado.");
            return;
        }

        // Liberar horario anterior y asignar el nuevo
        cancha.getHorariosDisponibles().add(reserva.getHoraInicio()); // Liberar anterior
        cancha.getHorariosDisponibles().remove(nuevoHorario);      // Bloquear nuevo

        // Modificar la reserva
        reserva.setHorario(nuevoHorario);

        System.out.println("Reserva modificada correctamente.");
    }

    public void cancelarReserva(Cliente cliente, Reserva reserva) {
        // Validar que la reserva pertenezca al cliente
        if (!reserva.getCliente().equals(cliente)) {
            System.out.println("No puedes cancelar una reserva que no te pertenece.");
            return;
        }

        // Marcar la reserva como cancelada
        reserva.setCancelada(true);

        // Liberar el horario en la cancha
        reserva.getNombre().getHorariosDisponibles().add(reserva.getHoraInicio());

        System.out.println("La reserva fue cancelada correctamente.");
    }

    public void programarMantenimiento(Cancha cancha, String tipo, String descripcion, LocalDate fecha, Tecnico tecnico) {
        Mantenimiento mantenimiento = new Mantenimiento(tipo, descripcion, fecha, cancha, tecnico);

        // Registrar mantenimiento
        mantenimientos.add(mantenimiento);

        // Bloquear el horario de la cancha en esa fecha
        cancha.bloquearPorMantenimiento(fecha);

        System.out.println("Mantenimiento programado para la cancha " + cancha.getNombre() + " en fecha " + fecha);
    }

    public void mostrarOcupacion() {
        Map<LocalDate, Integer> ocupacion = new HashMap<>();
        for (Reserva r : reservas) {
            if (!r.isCancelada()) {
                ocupacion.put(r.getFecha(), ocupacion.getOrDefault(r.getFecha(), 0) + 1);
            }
        }
        for (Map.Entry<LocalDate, Integer> entry : ocupacion.entrySet()) {
            System.out.println("Fecha: " + entry.getKey() + ", Reservas: " + entry.getValue());
        }
    }

    public void diaMasActivo() {
        Map<DayOfWeek, Integer> conteo = new HashMap<>();
        for (Reserva r : reservas) {
            DayOfWeek dia = r.getFecha().getDayOfWeek();
            conteo.put(dia, conteo.getOrDefault(dia, 0) + 1);
        }
        DayOfWeek maxDia = Collections.max(conteo.entrySet(), Map.Entry.comparingByValue()).getKey();
        System.out.println("Día más activo: " + maxDia);
    }

    // Generar fixture automáticamente (cuando hay equipos cargados)
    public void generarFixture(Scanner scanner) {
        if (equipos.size() < 2) {
            System.out.println("Debe haber al menos 2 equipos para generar un fixture.");
            return;
        }
        System.out.print("Ingrese el ID del torneo: ");
        int idTorneo = scanner.nextInt();
        Torneo torneo = buscarTorneoPorId(idTorneo);
        if (torneo == null) {
            System.out.println("Torneo no encontrado.");
            return;
        }
        torneo.generarFixture(equipos);
        System.out.println("Fixture generado correctamente.");
    }

    // Método auxiliar para buscar torneo por ID
    private Torneo buscarTorneoPorId(int id) {
        for (Torneo torneo : torneos) {
            if (torneo.getId() == id) {
                return torneo;
            }
        }
        return null;
    }

    public void mostrarIngresosMensuales() {
        Map<YearMonth, Double> ingresos = new HashMap<>();

        for (Reserva reserva : reservas) {
            if (!reserva.isCancelada()) {
                YearMonth mes = YearMonth.from(reserva.getHorario().getFecha());
                double monto = reserva.getPrecio();
                ingresos.put(mes, ingresos.getOrDefault(mes, 0.0) + monto);
            }
        }

        for (Map.Entry<YearMonth, Double> entry : ingresos.entrySet()) {
            System.out.println(entry.getKey() + ": $" + entry.getValue());
        }
    }


}

