package org.example;

public interface PriorityQueue<E extends Comparable<E>> {
    /**
     * Agrega un elemento a la cola con prioridad.
     * @param value El elemento a agregar.
     */
    void add(E value);

    /**
     * Obtiene y remueve el elemento con mayor prioridad de la cola.
     * @return El elemento con mayor prioridad.
     */
    E remove();

    /**
     * Obtiene pero no remueve el elemento con mayor prioridad de la cola.
     * @return El elemento con mayor prioridad.
     */
    E getFirst();

    /**
     * Verifica si la cola está vacía.
     * @return true si la cola está vacía, false en caso contrario.
     */
    boolean isEmpty();

    /**
     * Obtiene el tamaño de la cola.
     * @return El número de elementos en la cola.
     */
    int size();

    /**
     * Limpia la cola, eliminando todos sus elementos.
     */
    void clear();
}
