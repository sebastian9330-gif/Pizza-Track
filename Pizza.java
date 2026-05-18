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