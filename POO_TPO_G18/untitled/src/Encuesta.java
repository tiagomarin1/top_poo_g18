public class Encuesta {
    private int id;
    private String[] preguntas;
    private List<String[]> respuestas;

    public Encuesta(int id, String[] preguntas) {
        this.id = id;
        this.preguntas = preguntas;
        this.respuestas = new ArrayList<>();
    }

    public void responder(String[] respuestasCliente) {
        if (respuestasCliente.length == preguntas.length) {
            respuestas.add(respuestasCliente);
        }
    }

    public int getId() { return id; }
    public String[] getPreguntas() { return preguntas; }
    public List<String[]> getRespuestas() { return respuestas; }

    public void mostrarPreguntas() {
        System.out.println("Encuesta:");
        for (int i = 0; i < preguntas.size(); i++) {
            System.out.println((i + 1) + ". " + preguntas.get(i));
        }
    }

    public void responderEncuesta(List<String> respuestas) {
        if (respuestas.size() != preguntas.size()) {
            System.out.println("La cantidad de respuestas no coincide con la cantidad de preguntas.");
            return;
        }

        respuestasClientes.add(respuestas);
        System.out.println("Gracias por responder la encuesta.");
    }

    public void responderEncuesta(String[] respuestas) {
        this.respuestas = respuestas;
    }

    public void mostrarPreguntas() {
        for (String pregunta : preguntas) {
            System.out.println(pregunta);
        }
    }

}
