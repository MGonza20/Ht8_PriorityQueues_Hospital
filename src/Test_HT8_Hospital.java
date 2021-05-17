/**
 * @author Sara Paguaga 20634
 */

import org.junit.Test;
import java.util.Vector;
import static org.junit.Assert.assertEquals;

public class Test_HT8_Hospital {

    @Test
    public void testAddPaciente() {
        Vector<Paciente> vQueue = new Vector<Paciente>();
        Paciente pPrueba = new Paciente("Martin", "Dolor de estomago", "C");
        vQueue.add(pPrueba);
        VectorHeap<Paciente> pQueue = new VectorHeap<Paciente>(vQueue);

        Paciente pPrueba2 = new Paciente("Ivan", "Mordida de tiburón", "A");
        pQueue.add(pPrueba2);

        Paciente result = pQueue.getFirst();
        assertEquals(pPrueba2, result);
    }

    @Test
    public void testRemovePaciente() {
        VectorHeap<Paciente> pQueue = new VectorHeap<Paciente>();
        Paciente pPrueba = new Paciente("Martin", "Dolor de estomago", "C");
        Paciente pPrueba2 = new Paciente("Ivan", "Mordida de tiburón", "A");
        pQueue.add(pPrueba);
        pQueue.add(pPrueba2);

        // Test: remover un elemento del VectorHeap
        Paciente result = pQueue.remove();
        assertEquals(pPrueba2, result);
    }
}
