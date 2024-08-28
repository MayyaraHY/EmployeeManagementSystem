package tn.interfaces;

public interface InterfaceCRUD<T> {
    public void add(T t);
    public void update(T t);
    public void remove(int id);
}
