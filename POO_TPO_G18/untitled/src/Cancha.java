import java.util.ArrayList;
import java.util.List;

public class Cancha {
    private int id;
    private String nombre;
    private String tipo; // ej: "fútbol", "tenis"
    private boolean disponible;
    private List<Horario> horarios;

    public Cancha(int id, String nombre, String tipo) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.disponible = true;
        this.horarios = new ArrayList<>();
    }

    public void bloquearHorario(Horario horario) {
        horario.setDisponible(false);
        horarios.add(horario);
    }

    public boolean estaDisponible(Horario horario) {
        return horario.isDisponible();
    }

    // Getters y setters
    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public String getTipo() { return tipo; }
    public boolean isDisponible() { return disponible; }
    public List<Horario> getHorarios() { return horarios; }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public void bloquearPorMantenimiento(LocalDate fecha) {
        horariosDisponibles.removeIf(h -> h.getFechaHora().toLocalDate().equals(fecha));
    }

}
