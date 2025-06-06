import java.time.LocalDate;
import java.time.LocalTime;

public class Reserva {
    private int id;
    private Cliente cliente;
    private Cancha cancha;
    private Horario horario;
    private int formaPago; // 1=efectivo, 2=transferencia
    private boolean cancelada;
    private boolean tieneDescuento;
    
    private double precio;
    private LocalTime horaInicio;
    private LocalTime horaFin;
    private LocalDate fecha; // necesario para construir el Horario


    public Reserva(int id, Cliente cliente, Cancha cancha, Horario horario, int formaPago, boolean tieneDescuento) {
        this.id = id;
        this.cliente = cliente;
        this.cancha = cancha;
        this.horario = horario;
        this.formaPago = formaPago;
        this.cancelada = false;
        this.tieneDescuento = tieneDescuento;

        bloquearHorario(); // Se bloquea automáticamente al crear
    }

    private void bloquearHorario() {
        cancha.bloquearHorario(horario);
    }

    public void marcarComoCancelada() {
        this.cancelada = true;
        System.out.println("Reserva cancelada.");
    }

    public void aplicarDescuento() {
        this.tieneDescuento = true;
    }

    public void modificarHorario(Horario nuevoHorario) {
        if (!this.cancelada) {
            this.cancha = nuevoHorario.getCancha();
            this.horario = nuevoHorario;
            bloquearHorario();
        }
    }
    
    public boolean isCancelada() {
        return cancelada;
    }

    public double getPrecio() {
        return precio;
    }

    public Horario getHorario() {
        return new Horario(horaInicio, horaFin, fecha); // Suponiendo que también tenés `fecha`
    }


    // Getters
    public int getId() { return id; }
    public Cliente getCliente() { return cliente; }
    public Cancha getNombre() { return cancha; }
    public Horario getHoraInicio() { return horario; }
    public Horario getHoraFin() { return horario; }
    }
