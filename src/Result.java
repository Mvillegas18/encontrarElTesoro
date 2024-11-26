import java.util.ArrayList;
import java.util.List;

public class Result {
    private final List<String[]> resultados = new ArrayList<>();

    public void resultado(Player jugador) {
        // Añade los datos del jugador al historial de resultados
        resultados.add(new String[]{
                jugador.getNombre(),
                jugador.getTiempoJugador() != null ? jugador.getTiempoJugador() : "N/A",
                jugador.getResultados() != null ? jugador.getResultados() : "N/A"
        });
    }

    public void mostrarTabla() {
        // Imprimir encabezado
        System.out.println("+-----------------+----------------+-----------+");
        System.out.printf("| %-15s | %-14s | %-9s |\n", "Jugador", "Tiempo", "Resultado");
        System.out.println("+-----------------+----------------+-----------+");

        // Imprimir filas
        for (String[] resultado : resultados) {
            System.out.printf("| %-15s | %-14s | %-9s |\n", resultado[0], resultado[1], resultado[2]);
        }

        System.out.println("+-----------------+----------------+-----------+");
    }
}
