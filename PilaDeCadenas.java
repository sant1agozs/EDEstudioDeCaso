// Clase que implementa la pila con operaciones básicas LIFO.
public class PilaDeCadenas {
    private NodoCadena tope;

    // Inserta un nuevo nodo en la pila.
    public void apilar(NodoCadena nuevoNodo) {
        nuevoNodo.siguiente = tope;
        tope = nuevoNodo;
    }

    // Elimina el nodo superior de la pila.
    public NodoCadena desapilar() {
        if (tope == null) return null;
        NodoCadena eliminado = tope;
        tope = tope.siguiente;
        return eliminado;
    }

    // Concatena los valores almacenados en la pila.
    public String concatenarCadenas() {
        if (tope == null) return "(la pila está vacía)";
        StringBuilder resultado = new StringBuilder();
        NodoCadena actual = tope;

        while (actual != null) {
            String v = actual.valor;
            switch (v) {
                case "+": break;                      // Ignora el operador
                case "\\n": resultado.insert(0, "\n"); break;
                case "\\t": resultado.insert(0, "\t"); break;
                case "%s": resultado.insert(0, "[variable]"); break;
                default: resultado.insert(0, v);       // Inserta texto o variable
            }
            actual = actual.siguiente;
        }
        return resultado.toString();
    }

    // Muestra los elementos actuales de la pila.
    public void mostrarContenido() {
        if (tope == null) {
            System.out.println("\nLa pila está vacía.");
            return;
        }
        System.out.println("\nTokens actualmente en la pila (de arriba hacia abajo):");
        NodoCadena actual = tope;
        while (actual != null) {
            System.out.println(" -> " + actual);
            actual = actual.siguiente;
        }
    }
}