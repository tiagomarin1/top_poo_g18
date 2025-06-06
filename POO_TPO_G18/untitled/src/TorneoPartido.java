public class TorneoPartido {
    private int id;
    private EquipoTorneo equipo1;
    private EquipoTorneo equipo2;
    private int golesEquipo1;
    private int golesEquipo2;
    private Cancha cancha;
    private Horario horario;

    public TorneoPartido(EquipoTorneo equipo1, EquipoTorneo equipo2, Cancha cancha, Horario horario) {
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
        this.cancha = cancha;
        this.horario = horario;
        this.golesEquipo1 = 0;
        this.golesEquipo2 = 0;
        this.horario.setDisponible(false); // Se bloquea horario
    }

    public void registrarResultado(int goles1, int goles2) {
        this.golesEquipo1 = goles1;
        this.golesEquipo2 = goles2;
    }

    public String obtenerResultado() {
        return equipo1.getNombre() + " " + golesEquipo1 + " - " + golesEquipo2 + " " + equipo2.getNombre();
    }

    // Getters
    public int getId() { return id; }
    public EquipoTorneo getEquipo1() { return equipo1; }
    public EquipoTorneo getEquipo2() { return equipo2; }
    public int getGolesEquipo1() { return golesEquipo1; }
    public int getGolesEquipo2() { return golesEquipo2; }
    public Cancha getCancha() { return cancha; }
    public Horario getHorario() { return horario; }
}
