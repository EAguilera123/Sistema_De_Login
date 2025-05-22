import java.util.Scanner;

/**
 * Clase responsable de interactuar con el usuario por consola.
 * Controla el menú principal y el flujo de login.
 */
public class ConsolaLogin {
    Scanner scanner = new Scanner(System.in);
    DatosLogin datos = new DatosLogin();
    Login login = new Login();

    /**
     * Controla el ciclo principal del menú del sistema.
     */
    public void menu() {
        // TODO: Implementar ciclo del menú principal
        int opcion;
        do {
            mostrarOpciones();
            opcion = obtenerOpcion(0);
            if (opcion != -1) {
                ejecutarOpcion(opcion);
            }
        } while (opcion != 2);
    }

    /**
     * Muestra las opciones disponibles para el usuario.
     */
    private void mostrarOpciones() {
        // TODO: Mostrar "1. Iniciar sesión", "2. Salir"
        System.out.println("1. Iniciar sesión");
        System.out.println("2. Salir");
    }

    /**
     * Ejecuta la opción seleccionada por el usuario.
     *
     * @param opcion opción ingresada por el usuario
     */
    private void ejecutarOpcion(int opcion) {
        // TODO: Si es "1" llamar a manejarLogin, si es "2" salir
        switch (opcion) {
            case 1: manejarLogin();
            case 2: System.out.println("Saliendo...");
            default: System.out.println("opcion invalida");
        }

    }

    /**
     * Solicita usuario y contraseña, y muestra el resultado.
     */
    private void manejarLogin() {
        // TODO: Pedir usuario y contraseña por consola
        // TODO: Llamar a login.autenticar() y mostrar mensaje según resultado
        String usuario = "";
        String clave = "";

        System.out.println("ingrese su usuario");
        usuario = scanner.nextLine();

        System.out.println("ingrese su contraseña");
        clave = scanner.nextLine();

        if (login.autenticar(usuario, clave, datos)) {
            System.out.println("su cuenta ha sido autenticada");
        } else {
            System.out.println("usted no es usuario");
        }

    }
    public int obtenerOpcion(int opcion) {
        try {
            opcion = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Ingrese un numero valido");
            return -1; // Devolver un valor inválido para que no ejecute ninguna opción
        }
        return opcion;
    }
}