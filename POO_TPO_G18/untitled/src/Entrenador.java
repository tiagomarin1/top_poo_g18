import java.util.List;

public class Entrenador extends Usuario {
    private List<claseEntrenadores> clasesAsignadas;

    public Entrenador(int id, String nombre, String apellido, String email) {
        super(id, nombre, apellido, email);
    }

    public void reservarClase(Cancha cancha, Horario horario, String descripcion) {
        claseEntrenadores clase = new claseEntrenadores(this, cancha, horario, descripcion);
        clasesAsignadas.add(clase);
    }

    public void verClasesAgendadas() {
        for (claseEntrenadores clase : clasesAsignadas) {
            System.out.println(clase);
        }
    }

    public List<claseEntrenadores> getClasesAsignadas() {
        return clasesAsignadas;
    }

    public void verClasesAgendadas() {
        System.out.println("Clases agendadas para el entrenador " + nombre + ":");
        for (Clase clase : clasesAgendadas) {
            System.out.println("Fecha: " + clase.getHorario().getFechaHora() + ", Cancha: " + clase.getCancha().getNombre());
        }
    }

}
