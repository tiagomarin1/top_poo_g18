import java.util.ArrayList;
import java.util.List;

public class EntrenadorClub extends Empleado {
    private List<ClaseEntrenamiento> clasesAgendadas;

    public EntrenadorClub(int id, String nombre, String cargo) {
        super(id, nombre, cargo);
        this.clasesAgendadas = new ArrayList<>();
    }

    public void agendarClase(ClaseEntrenamiento clase) {
        clasesAgendadas.add(clase);
    }

    public List<ClaseEntrenamiento> getClasesAgendadas() {
        return clasesAgendadas;
    }
}
