package org.example;

import java.util.Vector;

public class VectorHeap<E extends Comparable<E>> implements PriorityQueue<E> {
    protected Vector<E> data; // El vector que almacena los elementos del heap

    public VectorHeap() {
        data = new Vector<E>();
    }

    public VectorHeap(Vector<E> v) {
        data = new Vector<E>(v.size()); // Construir un vector del mismo tamaño
        for (E e : v) {
            add(e);
        }
    }

    /**
     * Devuelve la posición del padre del elemento en la posición i.
     */
    protected int parent(int i) {
        return (i - 1) / 2;
    }

    /**
     * Devuelve la posición del hijo izquierdo del elemento en la posición i.
     */
    protected int left(int i) {
        return 2 * i + 1;
    }

    /**
     * Devuelve la posición del hijo derecho del elemento en la posición i.
     */
    protected int right(int i) {
        return 2 * (i + 1);
    }

    /**
     * Mueve el elemento en la posición leaf hacia arriba para mantener la propiedad del heap.
     */
    protected void percolateUp(int leaf) {
        int parent = parent(leaf);
        E value = data.get(leaf);

        while (leaf > 0 && value.compareTo(data.get(parent)) < 0) {
            data.set(leaf, data.get(parent));
            leaf = parent;
            parent = parent(leaf);
        }
        data.set(leaf, value);
    }

    @Override
    public void add(E value) {
        data.add(value);
        percolateUp(data.size() - 1);
    }

    /**
     * Mueve el elemento en la posición root hacia abajo para mantener la propiedad del heap.
     */
    protected void pushDownRoot(int root) {
        int minChild;
        int heapSize = data.size();
        E value = data.get(root);

        while (left(root) < heapSize) {
            int leftChild = left(root);
            int rightChild = right(root);

            // Encuentra el menor de los hijos
            if (rightChild < heapSize &&
                    data.get(leftChild).compareTo(data.get(rightChild)) > 0) {
                minChild = rightChild;
            } else {
                minChild = leftChild;
            }

            // Si el valor actual es menor o igual que el menor hijo, terminamos
            if (value.compareTo(data.get(minChild)) <= 0) break;

            // Movemos el menor hijo hacia arriba
            data.set(root, data.get(minChild));
            root = minChild;
        }

        data.set(root, value);
    }

    @Override
    public E remove() {
        if (isEmpty()) {
            return null;
        }

        E minValue = data.get(0);
        data.set(0, data.get(data.size() - 1));
        data.setSize(data.size() - 1);

        if (data.size() > 0) {
            pushDownRoot(0);
        }

        return minValue;
    }

    @Override
    public E getFirst() {
        if (isEmpty()) {
            return null;
        }
        return data.get(0);
    }

    @Override
    public boolean isEmpty() {
        return data.size() == 0;
    }

    @Override
    public int size() {
        return data.size();
    }

    @Override
    public void clear() {
        data.clear();
    }
}
