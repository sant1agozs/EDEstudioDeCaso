// Clase que representa un elemento (nodo) dentro de la pila.
public class NodoCadena {
    String tipo;             // Tipo de token: literal, variable, operador o formato
    String valor;            // Valor almacenado (ej. "Hola", "%s", "+")
    NodoCadena siguiente;    // Referencia al siguiente nodo en la pila

    public NodoCadena(String tipo, String valor) {
        this.tipo = tipo;
        this.valor = valor;
        this.siguiente = null;
    }

    public String toString() {
        return tipo + ": \"" + valor + "\"";
    }
}