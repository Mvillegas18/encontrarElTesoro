import java.util.Scanner;

public class Game {


    final Scanner entrada = new Scanner(System.in);

    GameBoard tablero;
    Player jugador;

    // Inicializa el tablero y el jugador en una posición aleatoria.
    public void empezarNuevoJuego(){
        int resultados, tiempo;

        jugador = new Player();
        System.out.print("Ingresa tu nombre para comenzar: ");
        String nombre = entrada.nextLine();
        jugador.setNombre(nombre);

        System.out.println();
        System.out.println("Nombre: " + jugador.getNombre() + "\t Vidas: " + jugador.vidas );
        System.out.println("Haz sido lanzado aleatoriamente en el laberinto");

        tablero = new GameBoard();
        tablero.inicializarTablero();
    }

    // Llama a la clase GameBoard para actualizar la posición del jugador según la dirección.
    public void moverJugador(){
        System.out.println("Moviendome a una posicion aleatoria");
    }

    public void verificarEstadoTablero(){
        System.out.println("Verificando estado del tablero");
    }

    // Muestra los resultados almacenados
    public void mostrarResultados(){
        System.out.println("Mostrando resultados del tablero");
    }

    //Finaliza el juego
    public void salir(){
        System.out.println("Saliendo del juego");
    }
}
