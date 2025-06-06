import java.time.LocalDate;
import java.time.LocalTime;

public class Horario {
    private int id;
    private LocalDate fecha;
    private LocalTime horaInicio;
    private LocalTime horaFin;
    private boolean disponible;
    private Cancha cancha;

    public Horario(int id, LocalDate fecha, LocalTime horaInicio, LocalTime horaFin, Cancha cancha) {
        this.id = id;
        this.fecha = fecha;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.cancha = cancha;
        this.disponible = true;
    }


	// Getters y setters
    public int getId() { return id; }
    public LocalDate getFecha() { return fecha; }
    public LocalTime getHoraInicio() { return horaInicio; }
    public LocalTime getHoraFin() { return horaFin; }
    public boolean isDisponible() { return disponible; }
    public Cancha getCancha() { return cancha; }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
}
