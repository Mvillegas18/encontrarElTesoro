import java.util.Random;

public class GameBoard {

    private final int TAMANIO = 40;
    private final char[][] tablero;

    Player jugador;

    public GameBoard() {
        tablero = new char[TAMANIO][TAMANIO];
    }

    public void inicializarTablero (){
        for (int i = 0; i < TAMANIO; i++) {
            for (int j = 0; j < TAMANIO; j++) {
                tablero[i][j] = '.';
            }
        }

        jugador = new Player();
        Random random = new Random();

        int randomX = random.nextInt(TAMANIO);
        int randomY = random.nextInt(TAMANIO);
        jugador.setPositionX(randomX);
        jugador.setPositionY(randomY);

        tablero[jugador.getPositionX()][jugador.getPositionY()] = 'J';

        imprimirTablero();
    }

    private void imprimirTablero(){
        for (int i = 0; i < TAMANIO; i++) {
            for (int j = 0; j < TAMANIO; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println("");
        }
    }
}
