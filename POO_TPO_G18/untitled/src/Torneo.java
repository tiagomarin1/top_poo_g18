import java.util.ArrayList;
import java.util.List;

public class Torneo {
    private int id;
    private String nombre;
    private List<EquipoTorneo> equipos;
    private List<TorneoPartido> partidos;

    public Torneo(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.equipos = new ArrayList<>();
        this.partidos = new ArrayList<>();
    }

    public Torneo(String nombre, List<EquipoTorneo> listaEquipos) {
        this.nombre = nombre;
        this.equipos = listaEquipos;
        this.partidos = new ArrayList<>();
        generarFixture();
    }

    public void agregarEquipo(EquipoTorneo equipo) {
        if (!equipos.contains(equipo)) {
            equipos.add(equipo);
        }
    }

    public void agregarPartido(TorneoPartido partido) {
        partidos.add(partido);
    }

    public void generarFixtureAutomatico() {
        for (int i = 0; i < equipos.size(); i++) {
            for (int j = i + 1; j < equipos.size(); j++) {
                // Aquí iría la lógica de asignar cancha y horario disponibles
                // Esto lo hará el administrador fuera de esta clase
            }
        }
    }

    public List<TorneoPartido> getPartidos() {
        return partidos;
    }

    public List<EquipoTorneo> getEquipos() {
        return equipos;
    }

    public String getNombre() { return nombre; }
    public int getId() { return id; }

    public void generarFixture() {
        // Lógica para generar partidos entre los equipos
        for (int i = 0; i < equipos.size(); i++) {
            for (int j = i + 1; j < equipos.size(); j++) {
                EquipoTorneo equipo1 = equipos.get(i);
                EquipoTorneo equipo2 = equipos.get(j);
                TorneoPartido partido = new TorneoPartido(equipo1, equipo2, null, null);
                partidos.add(partido);

            }
        }

        System.out.println("Fixture generado para el torneo " + nombre);
    }

}
