import java.util.List;
import java.util.ArrayList;


public class Administrador extends Usuario {
    private List<Torneo> torneos;
    private List<Reporte> reportesGenerados;

    public Administrador(int id, String nombre, String apellido, String email) {
        super(id, nombre, apellido, email);
    }

    public void gestionarEmpleado(String accion, Empleado empleado) {
        System.out.println("Empleado gestionado con acción: " + accion);
    }

    public void gestionarEntrenador(String accion, Entrenador entrenador) {
        System.out.println("Entrenador gestionado con acción: " + accion);
    }

    public void verEstadisticasOcupacion() {
        System.out.println("Estadísticas de ocupación generadas.");
    }

    public void verEstadisticasDiasActivos() {
        System.out.println("Día más activo consultado.");
    }

    public void verReportesMensuales() {
        System.out.println("Visualización de reportes mensuales.");
    }

    public List<Torneo> verTorneosActivos() {
        return torneos;
    }

    public void crearTorneo(String nombre, List<EquipoTorneo> listaEquipos) {
        Torneo torneo = new Torneo(nombre, listaEquipos);
        torneos.add(torneo);
    }

    public void asignarPartido(Torneo torneo, EquipoTorneo eq1, EquipoTorneo eq2, Cancha cancha, Horario horario) {
        torneo.agregarPartido(new TorneoPartido(eq1, eq2, cancha, horario));
    }

    public void registrarResultado(TorneoPartido partido, int goles1, int goles2) {
        partido.registrarResultado(goles1, goles2);
    }

    public void programarMantenimiento(int id, String tipo, String descripcion, java.time.LocalDate fecha, Cancha cancha, Horario horario) {
        Mantenimiento m = new Mantenimiento(id, tipo, descripcion, fecha, cancha, horario);
        m.registrar();
    }

    public List<Reporte> getReportesGenerados() { return reportesGenerados; }

    public void verEstadisticas(Club club) {
        System.out.println("Estadísticas del club:");
        System.out.println("Ocupación de canchas:");
        club.mostrarOcupacion();

        System.out.println("Ingresos mensuales:");
        club.mostrarIngresosMensuales();

        System.out.println("Torneos activos:");
        for (Torneo torneo : club.getTorneos()) {
            System.out.println("- " + torneo.getNombre());
        }
    }

}
