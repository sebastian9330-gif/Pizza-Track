##Proyecto Pizza-Track
___
#__Clase Pizza__

    public class Pizza {
    // Atributos básicos de nuestra pizza
    String nombre;
    String[] ingredientes;

    // Constructor para inicializar la pizza cuando la creamos
    public Pizza(String nombre, String[] ingredientes) {
        this.nombre = nombre;
        this.ingredientes = ingredientes;
    }

    // Método sencillo para mostrar la información en consola
    public void imprimirDatos() {
        System.out.println("Pizza: " + nombre);
        // Imprimimos las 3 posiciones del arreglo fijo
        System.out.println("Ingredientes: " + ingredientes[0] + ", " + ingredientes[1] + ", " + ingredientes[2]);
    }
}
___

#__Clase Nodo__

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

___

#__Clase PilaManual__

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

___

#__Clase GestionPedidos__

    import java.util.Scanner;

    public class GestionPedidos {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        
        // Creamos nuestras dos pilas para manejar el historial
        PilaManual pilaPrincipal = new PilaManual(); // Guarda los pedidos normales
        PilaManual pilaSecundaria = new PilaManual(); // Guarda los pedidos deshechos
        
        int opcion;

        // Usamos un do-while para que el menú se repita hasta elegir 0
        do {
            System.out.println("\n--- MENU PIZZA-TRACK ---");
            System.out.println("1. Registrar Pedido");
            System.out.println("2. Deshacer (Undo)");
            System.out.println("3. Rehacer (Redo)");
            System.out.println("4. Mostrar Pedido Actual");
            System.out.println("0. Salir");
            System.out.print("Elija una opcion: ");
            
            opcion = leer.nextInt();
            leer.nextLine(); // Limpiamos el 'enter' que sobra para que no se salte los textos

            switch (opcion) {
                case 1:
                    // Pedimos los datos al usuario
                    System.out.print("Nombre de la pizza: ");
                    String nombre = leer.nextLine();
                    
                    String[] ingredientes = new String[3];
                    System.out.println("Escriba los 3 ingredientes:");
                    
                    // Llenamos el arreglo con un for
                    for (int i = 0; i < 3; i++) {
                        System.out.print("Ingrediente " + (i + 1) + ": ");
                        ingredientes[i] = leer.nextLine();
                    }
                    
                    // Creamos el objeto y lo metemos a la pila principal
                    Pizza p = new Pizza(nombre, ingredientes);
                    pilaPrincipal.push(p);
                    System.out.println("Pizza registrada.");
                    break;

                case 2:
                    // Deshacer: Sacar de la principal y meter en la secundaria
                    if (pilaPrincipal.isEmpty()) {
                        System.out.println("No hay pedidos para deshacer.");
                    } else {
                        Pizza quitada = pilaPrincipal.pop(); // La sacamos
                        pilaSecundaria.push(quitada);        // La guardamos en el historial
                        System.out.println("Se deshizo el pedido de la pizza: " + quitada.nombre);
                    }
                    break;

                case 3:
                    // Rehacer: Sacar de la secundaria y regresar a la principal
                    if (pilaSecundaria.isEmpty()) {
                        System.out.println("No hay pedidos para rehacer.");
                    } else {
                        Pizza recuperada = pilaSecundaria.pop(); // La sacamos del historial
                        pilaPrincipal.push(recuperada);          // La regresamos a la lista activa
                        System.out.println("Se recupero el pedido de la pizza: " + recuperada.nombre);
                    }
                    break;

                case 4:
                    // Solo ver el tope sin modificar la pila
                    if (pilaPrincipal.isEmpty()) {
                        System.out.println("No hay pedidos en la pila principal.");
                    } else {
                        System.out.println("Pedido en el tope:");
                        Pizza actual = pilaPrincipal.peek();
                        actual.imprimirDatos(); // Usamos el método de la clase Pizza
                    }
                    break;

                case 0:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opcion incorrecta.");
                    break;
            }
        } while (opcion != 0);

        leer.close(); // Cerramos el scanner por buena práctica
    }
}

