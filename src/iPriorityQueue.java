/**
 * @author Sara Paguaga 20634
 * @param <E>
 */

public interface iPriorityQueue<E extends Comparable<E>>
{
    public E getFirst();
    public E remove();
    public void add(E value);
    public boolean isEmpty();
    public int size();
    public void clear();
}