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
        // Jugador posicion aleatoriaa

        int randomXJugador = random.nextInt(TAMANIO);
        int randomYJugador = random.nextInt(TAMANIO);
        jugador.setPositionXJugador(randomXJugador);
        jugador.setPositionYJugador(randomYJugador);

        String jugadorIcono = "\uD83E\uDDCD";
        tablero[jugador.getPositionXJugador()][jugador.getPositionYJugador()] = jugadorIcono;

        // Tesoro posicion aleatoria
        int randomXTesoro = random.nextInt(TAMANIO);
        int randomYTesoro = random.nextInt(TAMANIO);
        jugador.setPositionXTesoro(randomXTesoro);
        jugador.setPositionYTesoro(randomYTesoro);

        String tesoroIcono = "\uD83D\uDC8E";
        tablero[jugador.getPositionXTesoro()][jugador.getPositionYTesoro()] = tesoroIcono;
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
        if (jugador.getPositionYJugador() > 0) {
            tablero[jugador.getPositionXJugador()][jugador.getPositionYJugador()] = ".";
            jugador.setPositionYJugador(jugador.getPositionYJugador() - 1);
            tablero[jugador.getPositionXJugador()][jugador.getPositionYJugador()] = "\uD83E\uDDCD";
            imprimirTablero();
        }else{
            System.out.println("No mas movimientos hacia arriba");
        }

    }
    public void movimientoDOWN(){
        if (jugador.getPositionYJugador() < TAMANIO - 1) {
            tablero[jugador.getPositionXJugador()][jugador.getPositionYJugador()] = ".";
            jugador.setPositionYJugador(jugador.getPositionYJugador() + 1);
            tablero[jugador.getPositionXJugador()][jugador.getPositionYJugador()] = "\uD83E\uDDCD";
            imprimirTablero();
        } else {
            System.out.println("No puedes moverte más abajo.");
        }
    }
    public void movimientoLEFT(){
        if (jugador.getPositionXJugador() > 0) {
            tablero[jugador.getPositionXJugador()][jugador.getPositionYJugador()] = ".";
            jugador.setPositionXJugador(jugador.getPositionXJugador() - 1);
            tablero[jugador.getPositionXJugador()][jugador.getPositionYJugador()] = "\uD83E\uDDCD";
            imprimirTablero();
        }else{
            System.out.println("No mas movimientos hacia izquierda");
        }
    }
    public void movimientoRIGHT(){
        if (jugador.getPositionXJugador() < TAMANIO - 1) {
            tablero[jugador.getPositionXJugador()][jugador.getPositionYJugador()] = ".";
            jugador.setPositionXJugador(jugador.getPositionXJugador() + 1);
            tablero[jugador.getPositionXJugador()][jugador.getPositionYJugador()] = "\uD83E\uDDCD";
            imprimirTablero();
        }else{
            System.out.println("No mas movimientos hacia derecha");
        }
    }
}
