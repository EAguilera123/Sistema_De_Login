import java.util.ArrayList;
import java.io.*;

/**
 * Clase responsable de cargar las credenciales desde un archivo.
 */
public class DatosLogin {
    public ArrayList<String> credenciales = new ArrayList<>();

    /**
     * Constructor que inicializa las credenciales desde el archivo.
     */
    public DatosLogin() {
        cargarUsuarios();
    }

    /**
     * Lee el archivo login.txt y agrega las líneas válidas a la lista de credenciales.
     */
    private void cargarUsuarios() {
        // TODO: Abrir archivo login.txt
        // TODO: Leer línea por línea y agregar solo las que contienen ";"
        // TODO: Ignorar líneas vacías o mal formateadas
        File archivo = new File("src/main/java/datos.txt");
        if (!archivo.exists()) {
            System.err.println("Archivo datos.txt no encontrado.");
            return;
        }

        try (BufferedReader lector = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = lector.readLine()) != null) {
                linea = linea.trim();
                if (linea.isEmpty() || !linea.contains(";")) {
                    continue;
                }

                String[] partes = linea.split(";");
                if (partes.length == 2) {
                    String usuario = partes[0].trim();
                    String contrasena = partes[1].trim();
                    credenciales.add(usuario + ";" + contrasena);
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }

}
