import org.example.VectorHeap;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class VectorHeapTest {

    @Test
    public void testAdd() {
        VectorHeap<Integer> heap = new VectorHeap<>();
        assertTrue(heap.isEmpty(), "El heap debería estar vacío inicialmente");

        heap.add(10);
        assertEquals(1, heap.size(), "El tamaño del heap debería ser 1 después de agregar un elemento");
        assertEquals(10, heap.getFirst(), "El primer elemento debería ser 10");

        heap.add(5);
        assertEquals(2, heap.size(), "El tamaño del heap debería ser 2 después de agregar otro elemento");
        assertEquals(5, heap.getFirst(), "El primer elemento debería ser 5, ya que tiene mayor prioridad");

        heap.add(20);
        assertEquals(3, heap.size(), "El tamaño del heap debería ser 3 después de agregar un tercer elemento");
        assertEquals(5, heap.getFirst(), "El primer elemento debería seguir siendo 5");
    }

    @Test
    public void testRemove() {
        VectorHeap<Integer> heap = new VectorHeap<>();
        heap.add(10);
        heap.add(5);
        heap.add(20);

        assertEquals(5, heap.remove(), "El elemento eliminado debería ser 5, ya que tiene mayor prioridad");
        assertEquals(2, heap.size(), "El tamaño del heap debería ser 2 después de eliminar un elemento");

        assertEquals(10, heap.remove(), "El siguiente elemento eliminado debería ser 10");
        assertEquals(1, heap.size(), "El tamaño del heap debería ser 1 después de eliminar otro elemento");

        assertEquals(20, heap.remove(), "El último elemento eliminado debería ser 20");
        assertTrue(heap.isEmpty(), "El heap debería estar vacío después de eliminar todos los elementos");
    }
}