import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;

// Clase principal que contiene el metodo main() y gestiona el menú del programa.
public class Main {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream out = System.out;
    static PilaDeCadenas pila = new PilaDeCadenas(); // Instancia principal de la pila

    public static void main(String[] args) throws Exception {
        int opcion;
        do {
            // Menú principal de opciones
            out.println("\n===========================================");
            out.println("       PILA DE CADENAS DE IMPRESIÓN");
            out.println("===========================================");
            out.println("1. Agregar nuevo token");
            out.println("2. Mostrar pila actual");
            out.println("3. Generar e imprimir cadena final");
            out.println("0. Salir");
            out.println("-------------------------------------------");
            out.print("Seleccione una opción: ");
            opcion = Integer.parseInt(in.readLine());
            out.println();

            // Control de flujo mediante estructura switch-case
            switch (opcion) {
                case 1:
                    agregarToken(); // Permite crear y apilar un nuevo token
                    break;

                case 2:
                    pila.mostrarContenido(); // Muestra el estado actual de la pila
                    break;

                case 3:
                    out.println("Resultado final de concatenación:\n");
                    out.println(pila.concatenarCadenas()); // Imprime la cadena resultante
                    break;

                case 0:
                    out.println("Programa finalizado.");
                    break;

                default:
                    out.println("Opción inválida. Intente de nuevo.");
            }
        } while (opcion != 0); // El menú se repite hasta que el usuario elija salir
    }

    // Metodo que permite agregar nuevos tokens (elementos) a la pila
    private static void agregarToken() throws Exception {
        out.println("Seleccione el tipo de token que desea agregar:");
        out.println("1. Constante literal (texto fijo)");
        out.println("2. Variable de tipo String");
        out.println("3. Operador de concatenación (+)");
        out.println("4. Especificador de formato (salto de línea, tabulación o variable)");
        out.print("Opción: ");
        int tipo = Integer.parseInt(in.readLine());

        String tipoTexto;
        String valor;

        // Asigna valores según el tipo de token seleccionado
        switch (tipo) {
            case 1:
                tipoTexto = "Constante literal";
                out.print("Ingrese el texto: ");
                valor = in.readLine();
                break;

            case 2:
                tipoTexto = "Variable";
                out.print("Ingrese el nombre de la variable: ");
                valor = in.readLine();
                break;

            case 3:
                tipoTexto = "Operador";
                valor = "+";
                break;

            case 4:
                tipoTexto = "Formato";
                out.println("Seleccione el tipo de formato:");
                out.println("1. Salto de línea");
                out.println("2. Tabulación");
                out.println("3. Variable en formato");
                out.print("Opción: ");
                int formato = Integer.parseInt(in.readLine());
                switch (formato) {
                    case 1:
                        valor = "\\n"; // Representa salto de línea
                        break;
                    case 2:
                        valor = "\\t"; // Representa tabulación
                        break;
                    case 3:
                        valor = "%s"; // Representa variable formateada
                        break;
                    default:
                        out.println("Formato no válido. No se agregó el token.");
                        return;
                }
                break;

            default:
                out.println("Tipo no válido. No se agregó ningún token.");
                return;
        }

        // Inserta el nuevo token en la pila
        pila.apilar(new NodoCadena(tipoTexto, valor));
        out.println("Token agregado con éxito: " + tipoTexto + " → \"" + valor + "\"");
    }
}