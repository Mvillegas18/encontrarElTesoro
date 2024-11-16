import java.util.Random;

public class GameBoard {

    private final int TAMANIO = 40;
    private final String[][] tablero;

    Player jugador;

    public GameBoard() {
        tablero = new String[TAMANIO][TAMANIO];
    }

    public void inicializarTablero (){
        for (int i = 0; i < TAMANIO; i++) {
            for (int j = 0; j < TAMANIO; j++) {
                tablero[i][j] = ".";
            }
        }

        jugador = new Player();
        Random random = new Random();

        int randomX = random.nextInt(TAMANIO);
        int randomY = random.nextInt(TAMANIO);
        jugador.setPositionX(randomX);
        jugador.setPositionY(randomY);

        String jugadorIcono = "\uD83E\uDDCD";
        tablero[jugador.getPositionX()][jugador.getPositionY()] = jugadorIcono;

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

    public void movimientoUP(){
        if (jugador.getPositionY() > 0) {
            tablero[jugador.getPositionX()][jugador.getPositionY()] = ".";
            jugador.setPositionY(jugador.getPositionY() - 1);
            tablero[jugador.getPositionX()][jugador.getPositionY()] = "\uD83E\uDDCD";
            imprimirTablero();
        }else{
            System.out.println("No mas movimientos hacia arriba");
        }

    }
    public void movimientoDOWN(){
        if (jugador.getPositionY() < TAMANIO - 1) {
            tablero[jugador.getPositionX()][jugador.getPositionY()] = ".";
            jugador.setPositionY(jugador.getPositionY() + 1);
            tablero[jugador.getPositionX()][jugador.getPositionY()] = "\uD83E\uDDCD";
            imprimirTablero();
        } else {
            System.out.println("No puedes moverte más abajo.");
        }
    }
    public void movimientoLEFT(){
        if (jugador.getPositionX() > 0) {
            tablero[jugador.getPositionX()][jugador.getPositionY()] = ".";
            jugador.setPositionX(jugador.getPositionX() - 1);
            tablero[jugador.getPositionX()][jugador.getPositionY()] = "\uD83E\uDDCD";
            imprimirTablero();
        }else{
            System.out.println("No mas movimientos hacia izquierda");
        }
    }
    public void movimientoRIGHT(){
        if (jugador.getPositionX() < TAMANIO - 1) {
            tablero[jugador.getPositionX()][jugador.getPositionY()] = ".";
            jugador.setPositionX(jugador.getPositionX() + 1);
            tablero[jugador.getPositionX()][jugador.getPositionY()] = "\uD83E\uDDCD";
            imprimirTablero();
        }else{
            System.out.println("No mas movimientos hacia derecha");
        }
    }
}
