/**
 * @author Sara Paguaga 20634
 */

public class Paciente implements Comparable<Paciente> {
    //Atributos
    private String nombre;
    private String enfermedad;
    private String prioridad;

    /**
     * Constructor de clase paciente
     * @param nombre nombre del paciente
     * @param enfermedad enfermedad del paciente
     * @param prioridad prioridad del paciente
     */
    public Paciente(String nombre, String enfermedad, String prioridad) {
        this.nombre = nombre;
        this.enfermedad = enfermedad;
        this.prioridad = prioridad;
    }


    public String getNombre() {
        return this.nombre;
    }


    public String getEnfermedad() {
        return this.enfermedad;
    }


    public String getPrioridad() {
        return this.prioridad;
    }


    public boolean equals(Paciente otro) {
        return this.getPrioridad().equals(otro.getPrioridad());
    }


    /**
     * Compara prioridad de pacientes
     * @param otro
     * @return
     */
    public int compareTo(Paciente otro) {
        return this.getPrioridad().compareTo(otro.getPrioridad());
    }


    public String toString() {
        return this.getNombre() + ", " + this.getEnfermedad() + ", " + this.getPrioridad();
    }
}
