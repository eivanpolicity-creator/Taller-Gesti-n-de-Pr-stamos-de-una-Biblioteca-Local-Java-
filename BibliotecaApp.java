import java.util.ArrayList;
import java.util.Scanner;

public class BibliotecaApp{
    // Mi clase Main


    
    // prestamo = [idPrestamo, nombreUsuario, tituloLibro, diasPrestamo, multaPorDia]
    static ArrayList<ArrayList<Object>> prestamos = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        do {
            mostrarMenu();
            opcion = leerEntero("Seleccione una opción: ");

            switch (opcion) {
                //Primero
                case 1 -> registrarPrestamo();
                case 2 -> mostrarPrestamos();
               
                //Segundo
                case 3 -> buscarPrestamoPorId();
                case 4 -> actualizarPrestamo();
                
                //Tercero
                case 5 -> eliminarPrestamo();
                case 6 -> calcularTotalMultas();

                case 7 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción inválida.");
            }
            System.out.println();
        } while (opcion != 7);

        sc.close();
    }

    static void mostrarMenu() {
        System.out.println("=== Biblioteca: Gestión de Préstamos ===");
        System.out.println("1. Registrar nuevo préstamo");
        System.out.println("2. Mostrar todos los préstamos");
        System.out.println("3. Buscar préstamo por ID");
        System.out.println("4. Actualizar un préstamo");
        System.out.println("5. Eliminar un préstamo");
        System.out.println("6. Calcular total de multas");
        System.out.println("7. Salir");
    }

    // ====== CRUD (por implementar) ======
    static void registrarPrestamo() {
        int id = leerEntero("ID del préstamo: ");
        String usuario = leerTexto("Nombre del usuario: ");
        String libro = leerTexto("Título del libro: ");
        int dias = leerEntero("Días de préstamo: ");
        double multa = leerEntero("Multa por día: ");
        
        ArrayList<Object> prestamo = new ArrayList<>();
        prestamo.add(id);
        prestamo.add(usuario);
        prestamo.add(libro);
        prestamo.add(dias);
        prestamo.add(multa);
        prestamos.add(prestamo);
        System.out.println("Préstamo registrado.");
    }

    static void mostrarPrestamos() {
        if (prestamos.isEmpty()) {
            System.out.println("No hay préstamos registrados.");
            return;
        }
        for (ArrayList<Object> p : prestamos) {
            System.out.println(p);
        }
    }

    static void buscarPrestamoPorId() {
        int id = leerEntero("ID a buscar: ");
        for (ArrayList<Object> p : prestamos) {
            if ((int) p.get(0) == id) {
                System.out.println(p);
                return;
            }
        }
        System.out.println("Préstamo no encontrado.");
    }

    static void actualizarPrestamo() {
        int id = leerEntero("ID a actualizar: ");
        for (ArrayList<Object> p : prestamos) {
            if ((int) p.get(0) == id) {
                p.set(1, leerTexto("Nuevo usuario: "));
                System.out.println("Préstamo actualizado.");
                return;
            }
        }
        System.out.println("Préstamo no encontrado.");
    }

    static void eliminarPrestamo() {
        int id = leerEntero("ID a eliminar: ");
        for (int i = 0; i < prestamos.size(); i++) {
            if ((int) prestamos.get(i).get(0) == id) {
                prestamos.remove(i);
                System.out.println("Préstamo eliminado.");
                return;
            }
        }
        System.out.println("Préstamo no encontrado.");
    }

    // ====== Cálculo (por implementar) ======
    static void calcularTotalMultas() {
        double total = 0;
        for (ArrayList<Object> p : prestamos) {
            total += (int) p.get(3) * (double) p.get(4);
        }
        System.out.println("Total de multas: $" + total);
    }

    // ====== Utilidades mínimas ======
    static int leerEntero(String msg) {
        while (true) {
            System.out.print(msg);
            try {
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Ingrese un entero válido.");
            }
        }
    }

    static String leerTexto(String msg) {
        System.out.print(msg);
        return sc.nextLine().trim();
    }
}