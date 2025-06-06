import java.util.ArrayList;
import java.util.List;

public class EquipoTorneo {
    private int id;
    private String nombre;
    private List<Jugador> jugadores;

    public EquipoTorneo(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.jugadores = new ArrayList<>();
    }

    public void agregarJugador(Jugador jugador) {
        if (!jugadores.contains(jugador)) {
            jugadores.add(jugador);
        }
    }

    public int cantidadJugadores() {
        return jugadores.size();
    }

    // Getters
    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public List<Jugador> getJugadores() { return jugadores; }
}
