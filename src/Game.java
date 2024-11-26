import java.util.Scanner;
import java.time.Duration;
import java.time.Instant;

public class Game {
    final Scanner entrada = new Scanner(System.in);

    GameBoard tablero;
    Player jugador;
    Result resultado;
    GameBoard gameBoard;

    // Inicializa el tablero y el jugador en una posición aleatoria.
    public boolean empezarNuevoJuego(){
        jugador = new Player();
        System.out.print("Ingresa tu nombre para comenzar: ");
        String nombre = entrada.nextLine();
        jugador.setNombre(nombre);

        System.out.println();
        System.out.println("Nombre: " + jugador.getNombre() + "\t Vidas: " + jugador.vidas );
        System.out.println("Haz sido lanzado aleatoriamente en el laberinto");

        Instant tiempoInicio = Instant.now();

        tablero = new GameBoard();
        tablero.inicializarTablero();
        tecladoConfiguracion();

        // Registrar el tiempo de fin y calcular el tiempo total
        Instant tiempoFin = Instant.now();
        Duration duracion = Duration.between(tiempoInicio, tiempoFin);
        long segundosTotales = duracion.getSeconds();
        long minutos = segundosTotales / 60;
        long segundos = segundosTotales % 60;

        String tiempoFormato = minutos > 0
                ? minutos + " min " + segundos + " seg"
                : segundos + " seg";
        jugador.setTiempoJugador(tiempoFormato);

        if (resultado == null) {
            resultado = new Result();
        }

        // Determinar si el jugador ganó
        boolean gano = tablero.verificarGanador();
        String resultadoTabla = gano ? "Gano" : "Perdio";
        jugador.setResultados(resultadoTabla);
        resultado.resultado(jugador);

        return gano; // Devuelve true si ganó
    }

    // Configuración del teclado, leyendo las teclas W, A, S, D para el movimiento

    public void tecladoConfiguracion() {
        String movimiento;
        boolean juegoTerminado = false;
        while (jugador.getMovimientos() > 0 && !juegoTerminado) {
            System.out.println("Usa las teclas 'w', 'a', 's', 'd' para moverte:");
            System.out.print("w - Arriba, a - Izquierda, s - Abajo, d - Derecha, x - Salir: ");
            movimiento = entrada.nextLine();

            switch (movimiento) {
                case "w":
                    tablero.movimientoUP();
                    break;
                case "s":
                    tablero.movimientoDOWN();
                    break;
                case "a":
                    tablero.movimientoLEFT();
                    break;
                case "d":
                    tablero.movimientoRIGHT();
                    break;
                case "x":
                    salir();
                    return; // Terminar el juego
                default:
                    System.out.println("Movimiento no válido. Usa 'w', 'a', 's', 'd'.");
                    continue;
            }

            jugador.setMovimientos(jugador.getMovimientos() - 1); // Reducir movimientos restantes

            if (tablero.verificarGanador()) {
                juegoTerminado = true; // Detener el bucle
            }

            // Verificar si el jugador perdió todas sus vidas
            if (jugador.getVidas() <= 0) {
                System.out.println("❌ Has perdido todas tus vidas.");
                juegoTerminado = true;
            }
        }

        if (!juegoTerminado) {
            System.out.println("Sin movimientos restantes. ¡Perdiste!");
        }
    }




    // Muestra los resultados almacenados
    public void mostrarResultados() {
        if (resultado != null) {
            resultado.mostrarTabla();
        } else {
            System.out.println("No hay resultados disponibles.");
        }
    }

    // Finaliza el juego
    public void salir(){
        System.out.println("Saliendo del juego.");
        return;
    }
}
