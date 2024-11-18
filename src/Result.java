import java.util.ArrayList;
import java.util.List;

public class Result {
    Player jugador;

    public void resultado() {
        List<String[]> resultados = new ArrayList <String[]> ();

        jugador = new Player();
        resultados.add(new String[] {jugador.getNombre(), jugador.getTiempoJugador(), jugador.getResultados()});

        mostrarTabla(resultados);
    }

    public void mostrarTabla(List<String[]> resultados) {
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
