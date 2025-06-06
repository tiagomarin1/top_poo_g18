public class Membresia {
    private int id;
    private double descuento;
    private boolean activa;

    public Membresia(int id, double descuento) {
        this.id = id;
        this.descuento = descuento;
        this.activa = false;
    }

    public void activar() { activa = true; }
    public void desactivar() { activa = false; }

    public boolean estaActiva() { return activa; }
    public double getDescuento() { return descuento; }
    public int getId() { return id; }
}
