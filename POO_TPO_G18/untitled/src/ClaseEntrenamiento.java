public class ClaseEntrenamiento {
    private int id;
    private EntrenadorClub entrenador;
    private Cancha cancha;
    private Horario horario;

    public ClaseEntrenamiento(int id, EntrenadorClub entrenador, Cancha cancha, Horario horario) {
        this.id = id;
        this.entrenador = entrenador;
        this.cancha = cancha;
        this.horario = horario;
        this.horario.setDisponible(false);
    }

    public int getId() { return id; }
    public EntrenadorClub getEntrenador() { return entrenador; }
    public Cancha getCancha() { return cancha; }
    public Horario getHorario() { return horario; }
}

