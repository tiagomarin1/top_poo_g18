public class Opinion {
    private int id;
    private String texto;

    public Opinion(int id, String texto) {
        this.id = id;
        this.texto = texto;
    }

    public int getId() { return id; }
    public String getTexto() { return texto; }

    public void mostrarOpinion() {
        System.out.println("Opinión: " + texto);
    }

}
