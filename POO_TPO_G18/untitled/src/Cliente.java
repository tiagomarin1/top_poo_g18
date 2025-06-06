import java.util.List;

public class Cliente extends Usuario {
    private Membresia membresia;
    private List<Reserva> reservas;

    public Cliente(int id, String nombre, String apellido, String email) {
        super(id, nombre, apellido, email);
    }

    public void consultarDisponibilidad(Cancha cancha, Horario horario) {
        System.out.println("Consultando disponibilidad de la cancha...");
    }

    public void realizarReserva(Cancha cancha, Horario horario, int formaPago) {
        // Lógica de creación y almacenamiento de reserva
    }

    public void modificarReserva(Reserva reserva, Horario nuevoHorario) {
        reserva.modificarHorario(nuevoHorario);
    }

    public void cancelarReserva(Reserva reserva) {
        reserva.marcarComoCancelada();
    }

    public void activarDescuentoMembresia() {
        if (membresia != null) {
            membresia.aplicarDescuento();
        }
    }

    public void responderEncuesta(Encuesta encuesta, java.util.Map<String, Integer> respuestas) {
        encuesta.responder(this, respuestas);
    }

    public void crearOpinion(String texto) {
        new Opinion(this, texto);
    }

    public Membresia getMembresia() { return membresia; }
    public List<Reserva> getReservas() { return reservas; }

    public void setMembresia(Membresia membresia) { this.membresia = membresia; }
    public void setReservas(List<Reserva> reservas) { this.reservas = reservas; }
}
