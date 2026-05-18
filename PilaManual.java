public class PilaManual {
    // El tope es el elemento que está más arriba en nuestra pila
    Nodo tope;

    // Constructor de la pila vacía
    public PilaManual() {
        this.tope = null;
    }

    // Método para insertar una pizza en la pila (Push)
    public void push(Pizza pizza) {
        Nodo nuevo = new Nodo(pizza); // Creamos el nuevo nodo con la pizza
        nuevo.siguiente = tope;       // Hacemos que apunte al que antes era el tope
        tope = nuevo;                 // Ahora el tope oficial es este nuevo nodo
    }

    // Método para sacar y devolver la pizza de más arriba (Pop)
    public Pizza pop() {
        // Primero validamos para que no nos dé error si está vacía
        if (isEmpty()) {
            return null;
        }
        Pizza p = tope.pizza;         // Guardamos la pizza temporalmente
        tope = tope.siguiente;        // Bajamos el tope al siguiente nodo
        return p;                     // Devolvemos la pizza que sacamos
    }

    // Método para ver la pizza de arriba sin sacarla de la pila (Peek)
    public Pizza peek() {
        if (isEmpty()) {
            return null;
        }
        return tope.pizza; // Solo la mostramos, el tope no cambia
    }

    // Método para saber si la pila no tiene elementos
    public boolean isEmpty() {
        if (tope == null) {
            return true;
        } else {
            return false;
        }
    }
}
