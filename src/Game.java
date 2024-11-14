public class Game {
    static int vidas, movimientos, resultados, tiempo;

    GameBoard tablero;
    Player jugador;

    // Inicializa el tablero y el jugador en una posición aleatoria.
    public void empezarNuevoJuego(){
        System.out.println("Empezando nuevo Juego");
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
