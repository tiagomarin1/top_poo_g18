public class Reporte {
    private int id;
    private String tipo; // financiero o reservas
    private String mes;
    private double ingresos;
    private double gastos;
    private double porcentajeOcupacion;
    private String diaMasActivo;

    public Reporte(int id, String tipo, String mes, double ingresos, double gastos, double porcentajeOcupacion, String diaMasActivo) {
        this.id = id;
        this.tipo = tipo;
        this.mes = mes;
        this.ingresos = ingresos;
        this.gastos = gastos;
        this.porcentajeOcupacion = porcentajeOcupacion;
        this.diaMasActivo = diaMasActivo;
    }

    public String generarResumen() {
        return "Reporte " + tipo + " - Mes: " + mes +
                "\nIngresos: $" + ingresos +
                "\nGastos: $" + gastos +
                "\nOcupación: " + porcentajeOcupacion + "%" +
                "\nDía más activo: " + diaMasActivo;
    }

    public int getId() { return id; }

    public void generarReporteReservas(List<Reserva> reservas, int mes) {
        System.out.println("Reporte de reservas para el mes " + mes + ":");

        for (Reserva reserva : reservas) {
            if (reserva.getHoraInicio().getFechaHora().getMonthValue() == mes) {
                System.out.println("- Cliente: " + reserva.getCliente().getNombre() +
                        ", Cancha: " + reserva.getNombre().getNombre() +
                        ", Fecha: " + reserva.getHoraInicio().getFechaHora() +
                        ", Cancelada: " + (reserva.isCancelada() ? "Sí" : "No"));
            }
        }
    }

    public void generarReporteFinanciero(List<Reserva> reservas, List<Mantenimiento> mantenimientos, int mes) {
        double ingresos = 0;
        double gastos = 0;

        for (Reserva reserva : reservas) {
            if (!reserva.isCancelada() && reserva.getHoraInicio().getFechaHora().getMonthValue() == mes) {
                ingresos += reserva.getPrecioFinal();
            }
        }

        for (Mantenimiento mantenimiento : mantenimientos) {
            if (mantenimiento.getFecha().getMonthValue() == mes) {
                gastos += mantenimiento.getCosto(); // Asumimos que se agregó un costo
            }
        }

        System.out.println("Reporte financiero del mes " + mes + ":");
        System.out.println("Ingresos por reservas: $" + ingresos);
        System.out.println("Gastos por mantenimiento: $" + gastos);
        System.out.println("Balance neto: $" + (ingresos - gastos));
    }

    public void generarReporteReservas(List<Reserva> reservas, int mes) {
        // Filtra y muestra reservas por mes
    }

    public void generarReporteFinanciero(List<Reserva> reservas, List<Mantenimiento> mantenimientos, int mes) {
        double ingresos = 0;
        double gastos = 0;
        for (Reserva r : reservas) {
            if (r.getFecha().getMonthValue() == mes && !r.isCancelada()) {
                ingresos += r.getPrecioFinal();
            }
        }
        for (Mantenimiento m : mantenimientos) {
            if (m.getFecha().getMonthValue() == mes) {
                gastos += m.getCosto();
            }
        }
        System.out.println("Ingresos: $" + ingresos);
        System.out.println("Gastos: $" + gastos);
        System.out.println("Balance: $" + (ingresos - gastos));
    }

}
