import java.util.Scanner;
import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

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

    public void tecladoConfiguracion(){
        JFrame ventana = new JFrame();
        ventana.setTitle("Juego");
        ventana.setSize(500, 500);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                moverJugador(e);
            }
        });

        ventana.setVisible(true);
        ventana.setFocusable(true);
    }

    // Llama a la clase GameBoard para actualizar la posición del jugador según la dirección.
    public void moverJugador(KeyEvent e){
        int keyCode = e.getKeyCode();
        if(jugador.getMovimientos() > 0){
            switch (e.getKeyCode()) {
                case KeyEvent.VK_UP:
                    break;
                case KeyEvent.VK_DOWN:
                    break;
                case KeyEvent.VK_LEFT:
                    break;
                case KeyEvent.VK_RIGHT:
                    break;
            }
            jugador.setMovimientos(jugador.getMovimientos() - 1);
        }else{
            System.out.println("Sin movimientos restantes");
        }

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
