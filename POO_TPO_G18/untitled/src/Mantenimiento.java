import java.time.LocalDate;

public class Mantenimiento {
    private int id;
    private String tipo; // preventivo o correctivo
    private String descripcion;
    private LocalDate fecha;
    private Cancha cancha;
	private Horario horario;

    public Mantenimiento(int id, String tipo, String descripcion, LocalDate fecha, Cancha cancha, Horario horario) {
        this.id = id;
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.cancha = cancha;
        this.horario = horario;
    }

	public int getId() { return id; }
    public String getTipo() { return tipo; }
    public String getDescripcion() { return descripcion; }
    public LocalDate getFecha() { return fecha; }
    public Cancha getCancha() { return cancha; }

    public void registrar() {
        this.getCancha().bloquearHorario(this.horario); // solo si necesitás bloquear la cancha
        System.out.println("Mantenimiento registrado: " + this.descripcion);
    }

    
}
