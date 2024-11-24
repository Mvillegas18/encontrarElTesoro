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
        String movimiento;
        while (jugador.getMovimientos() > 0) {
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
        }
        System.out.println("Sin movimientos restantes.");
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
        return;
    }
}
