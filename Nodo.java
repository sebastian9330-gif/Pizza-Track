public class Nodo {
    // El nodo es como una "caja" que guarda nuestra pizza
    Pizza pizza;
    // Este es el puntero que nos conecta con el nodo de abajo en la pila
    Nodo siguiente;

    // Constructor del nodo
    public Nodo(Pizza pizza) {
        this.pizza = pizza;
        this.siguiente = null; // Al principio no apunta a nada
    }
}