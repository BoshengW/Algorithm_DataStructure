package Data_Structure.set;

public interface MySet<T> {

    void add(T element);
    void remove(T element);
    int getSize();
    boolean isEmpty();
    boolean contains(T element);

}
