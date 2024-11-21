import java.util.Scanner;

public class Game {
    final Scanner entrada = new Scanner(System.in);

    GameBoard tablero;
    Player jugador;
    Result resultado;

    // Inicializa el tablero y el jugador en una posición aleatoria.
    public void empezarNuevoJuego(){
        jugador = new Player();
        System.out.print("Ingresa tu nombre para comenzar: ");
        String nombre = entrada.nextLine();
        jugador.setNombre(nombre);

        System.out.println();
        System.out.println("Nombre: " + jugador.getNombre() + "\t Vidas: " + jugador.vidas );
        System.out.println("Haz sido lanzado aleatoriamente en el laberinto");

        tablero = new GameBoard();
        tablero.inicializarTablero();
        tecladoConfiguracion();
    }

    // Configuración del teclado, leyendo las teclas W, A, S, D para el movimiento
    public void tecladoConfiguracion() {
        while (true) {
            System.out.println("Usa las teclas 'W', 'A', 'S', 'D' para moverte:");
            System.out.print("W - Arriba, A - Izquierda, S - Abajo, D - Derecha, X - Salir: ");
            String movimiento = entrada.nextLine().toUpperCase(); // Leer movimiento en mayúsculas

            if (movimiento.equals("X")) {
                salir();
                break; // Salir del bucle y terminar el juego
            }
            if(jugador.getMovimientos() > 0) {
                switch (movimiento) {
                    case "W":
                        tablero.movimientoUP();
                        break;
                    case "S":
                        tablero.movimientoDOWN();
                        break;
                    case "A":
                        tablero.movimientoLEFT();
                        break;
                    case "D":
                        tablero.movimientoRIGHT();
                        break;
                    default:
                        System.out.println("Movimiento no válido. Usa 'W', 'A', 'S' o 'D'.");
                }
                jugador.setMovimientos(jugador.getMovimientos() - 1);
            }else{
                System.out.println("Sin movimientos restantes");
            }
            // Resto de la lógica del juego (como verificar estado, etc.)
            verificarEstadoTablero();
        }
    }

    public void verificarEstadoTablero(){
        System.out.println("Verificando estado del tablero...");
        // Agregar lógica de verificación del estado del tablero si es necesario
    }

    // Muestra los resultados almacenados
    public void mostrarResultados(){
        System.out.println("Resultados del tablero: ");
        resultado = new Result();

        resultado.resultado();
    }

    // Finaliza el juego
    public void salir(){
        System.out.println("Saliendo del juego.");
    }
}
