//Referencia: D. Bailey (Java Structures)

/**
 * Se importó java.util.Vector para poder usarlo
 * @author Sara Paguaga 20634
 */
import java.util.Vector;

/**
 * Clase VectorHeap
 * @param <E> Cualquier objeto
 */
public class VectorHeap<E extends Comparable<E>> implements iPriorityQueue<E>
{
    /**
     * Es la data, nantenida en orden
     */
    protected Vector<E> data;

    /**
     * Contructor de una nueva priority queue
     */
    public VectorHeap()
    {
        data = new Vector<E>();
    }

    /**
     * Es el constructor de de una nueva priority queue de un vector desordenado
     * @param v, vector de tipo E
     */
    public VectorHeap(Vector<E> v)
    {
        int i;
        data = new Vector<E>(v.size());
        for (i = 0; i < v.size(); i++)
        {
            add(v.get(i));
        }
    }

    /**
     * @param i es la posición
     * @return devuelve el nodo padre de la posición i
     */
    protected static int parent(int i)
    {
        return (i-1)/2;
    }

    /**
     * @param i es la posición
     * @return delvuelve el indice del nodo hijo izquierdo de la posición i
     */
    protected static int left(int i)
    {
        return 2*i+1;
    }

    /**
     * @param i es la posición
     * @return delvuelve el indice del nodo hijo derecho de la posición i
     */
    protected static int right(int i)
    {
        return (2*i+1) + 1;
    }

    /**
     * mueve el nodo a la hoja del indice hacia arriba para apropiar la posición
     * @param leaf hoja
     */
    protected void moveUp(int leaf)
    {
        int parent = parent(leaf);
        E value = data.get(leaf);
        while (leaf > 0 &&
                (value.compareTo(data.get(parent)) < 0))
        {
            data.set(leaf,data.get(parent));
            leaf = parent;
            parent = parent(leaf);
        }
        data.set(leaf,value);
    }

    /**
     * el valor es añadido a la priority queue
     * @param value es un comparable no nulo
     */
    public void add(E value)
    {
        data.add(value);
        moveUp(data.size()-1);
    }

    /**
     * mueve el nodo hacia la raíz indice hacia abajo a una posición apropiada en el sub-árbol
     * @param root
     */
    protected void pushHaciaLaRaiz(int root)
    {
        int heapSize = data.size();
        E value = data.get(root);
        while (root < heapSize) {
            int childpos = left(root);
            if (childpos < heapSize)
            {
                if ((right(root) < heapSize) &&
                        ((data.get(childpos+1)).compareTo
                                (data.get(childpos)) < 0))
                {
                    childpos++;
                }

                if ((data.get(childpos)).compareTo
                        (value) < 0)
                {
                    data.set(root,data.get(childpos));
                    root = childpos;
                } else {
                    data.set(root,value);
                    return;
                }
            } else {
                data.set(root,value);
                return;
            }
        }
    }

    /**
     * Cuando no está vacio !isEmpty()
     * @return devuelve y remueve el menor valor de queue
     */
    public E remove()
    {
        E minVal = getFirst();
        data.set(0,data.get(data.size()-1));
        data.setSize(data.size()-1);
        if (data.size() > 1) pushHaciaLaRaiz(0);
        return minVal;
    }

    /**
     * @return el primer valor
     */
    public E getFirst() {
        E first = null;

        if((data.size()) > 0){
            first = data.get(0);
            return first;
        }

        return first;
    }

    /**
     * @return devuelve true o false dependiendo de si está vacio o no
     */
    public boolean isEmpty() {
        return data.isEmpty();
    }

    public int size() {
        return data.size();
    }

    public void clear() {
    }

}