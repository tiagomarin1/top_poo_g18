import java.util.List;

public class Empleado extends Usuario {
    private List<Mantenimiento> mantenimientosRegistrados;

    public Empleado(int id, String nombre, String apellido, String email) {
        super(id, nombre, apellido, email);
    }

    public void registrarMantenimiento(String tipo, String descripcion, java.time.LocalDate fecha, Cancha cancha) {
        Mantenimiento m = new Mantenimiento(tipo, descripcion, fecha, cancha);
        m.registrar();
        mantenimientosRegistrados.add(m);
    }

    public void verEncuesta(Encuesta encuesta) {
        encuesta.listarPreguntas();
    }

    public void verOpinion(Opinion opinion) {
        System.out.println("Comentario: " + opinion.getComentario());
    }

    public List<Mantenimiento> getMantenimientosRegistrados() {
        return mantenimientosRegistrados;
    }

    public void verOpiniones(List<Opinion> opiniones) {
        for (Opinion op : opiniones) {
            op.mostrarOpinion();
        }
    }

    public void verEncuestas(List<Encuesta> encuestas) {
        for (Encuesta encuesta : encuestas) {
            encuesta.mostrarPreguntas();
            System.out.println("Respuestas: " + Arrays.toString(encuesta.getRespuestas()));
        }
    }

}
