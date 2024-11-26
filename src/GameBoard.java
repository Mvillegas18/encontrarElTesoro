import java.util.Random;

public class GameBoard {

    private final int TAMANIO = 40;
    private final String[][] tablero;
    int[][] MatrizMinas;

    Player jugador;
    Random random;

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
        random = new Random();
        // Jugador posicion aleatoriaa

        int randomXJugador = random.nextInt(TAMANIO);
        int randomYJugador = random.nextInt(TAMANIO);
        jugador.setPositionXJugador(randomXJugador);
        jugador.setPositionYJugador(randomYJugador);

        tablero[jugador.getPositionXJugador()][jugador.getPositionYJugador()] = "P";

        // Distancia de 10 pasos formando una L
        posicionTesoroJugador();

        mostrarMinas();


        imprimirTablero();
        System.out.println();
    }

    public void posicionTesoroJugador(){
        random = new Random();
        int randomXTesoro, randomYTesoro;
        do {
            int deltaX = random.nextBoolean() ? 8 : 2; // Parte larga o corta en X
            int deltaY = jugador.getMovimientos() - deltaX;   // Complemento para sumar 10

            // Determinar la dirección del desplazamiento (positiva o negativa)
            randomXTesoro = jugador.getPositionXJugador() + (random.nextBoolean() ? deltaX : -deltaX);
            randomYTesoro = jugador.getPositionYJugador() + (random.nextBoolean() ? deltaY : -deltaY);

        } while (!esPosicionValida(randomXTesoro, randomYTesoro));

        jugador.setPositionXTesoro(randomXTesoro);
        jugador.setPositionYTesoro(randomYTesoro);
        /*String tesoroIcono = "\uD83C\uDF81";*/
        tablero[jugador.getPositionXTesoro()][jugador.getPositionYTesoro()] = "$";
    }

    private boolean esPosicionValida(int x, int y) {
        return x >= 0 && x < TAMANIO && y >= 0 && y < TAMANIO && tablero[x][y].equals(".");
    }

    private void mostrarMinas(){

        // Llenar una matriz bidimensional con las coordenadas de las minas
        MatrizMinas = new int[20][2];
        for (int i = 0; i < 20; i++) {
            int randomXMinas, randomYMinas;
            do {
                randomXMinas = random.nextInt(TAMANIO);
                randomYMinas = random.nextInt(TAMANIO);
            } while (!esPosicionValida(randomXMinas, randomYMinas) || estaEnPerimetro(jugador.getPositionXTesoro(), jugador.getPositionYTesoro(), randomXMinas, randomYMinas));

            MatrizMinas[i][0] = randomXMinas;
            MatrizMinas[i][1] = randomYMinas;
            tablero[randomXMinas][randomYMinas] = "X"; // Mina
        }
    }

    private boolean estaEnPerimetro(int xTesoro, int yTesoro, int xMina, int yMina) {
        return Math.abs(xTesoro - xMina) <= 1 && Math.abs(yTesoro - yMina) <= 1;
    }

    private void imprimirTablero(){
        for (int i = 0; i < TAMANIO; i++) {
            for (int j = 0; j < TAMANIO; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println("");
        }
    }

    public boolean  verificarGanador(){
        boolean xJugadorTesoro = jugador.getPositionXJugador() == jugador.getPositionXTesoro();
        boolean yJugadorTesoro = jugador.getPositionYJugador() == jugador.getPositionYTesoro();
        if( xJugadorTesoro && yJugadorTesoro){
            System.out.println("🎉 ¡Felicidades! Has encontrado el tesoro. ¡Ganaste!");
            return true;
        }
        return false;
    }

    private boolean verificarMina() {
        int xJugador = jugador.getPositionXJugador();
        int yJugador = jugador.getPositionYJugador();

        for (int[] mina : MatrizMinas) {
            if (mina[0] == xJugador && mina[1] == yJugador) {
                return true; // El jugador está en una mina
            }
        }
        return false; // No está en una mina
    }

    public boolean verificarEstadoJugador() {
        if (verificarMina()) {
            jugador.vidas--; // Reducir una vida
            System.out.println("💥 ¡Has pisado una mina! Vidas restantes: " + jugador.vidas);

            if (jugador.vidas <= 0) {
                System.out.println("❌ Has perdido todas tus vidas. ¡Juego terminado!");
                return true; // Terminar el programa
            }
        }
        return false;
    }

    public void movimientoLEFT() {
        if (jugador.getPositionYJugador() > 0) { // Validar límite superior
            tablero[jugador.getPositionXJugador()][jugador.getPositionYJugador()] = "*"; // Limpiar posición anterior
            jugador.setPositionYJugador(jugador.getPositionYJugador() - 1); // Mover hacia arriba
            tablero[jugador.getPositionXJugador()][jugador.getPositionYJugador()] = "P"; // Nueva posición
            imprimirTablero();
            verificarEstadoJugador();
            if(verificarGanador()) return;
        } else {
            System.out.println("No más movimientos hacia la izquierda.");
        }
    }

    public void movimientoRIGHT() {
        if (jugador.getPositionYJugador() < TAMANIO - 1) { // Validar límite inferior
            tablero[jugador.getPositionXJugador()][jugador.getPositionYJugador()] = "*";
            jugador.setPositionYJugador(jugador.getPositionYJugador() + 1); // Mover hacia abajo
            tablero[jugador.getPositionXJugador()][jugador.getPositionYJugador()] = "P";
            imprimirTablero();
            verificarEstadoJugador();
            if(verificarGanador()) return;
        } else {
            System.out.println("No puedes moverte hacia la derecha.");
        }
    }

    public void movimientoUP() {
        if (jugador.getPositionXJugador() > 0) { // Validar límite izquierdo
            tablero[jugador.getPositionXJugador()][jugador.getPositionYJugador()] = "*";
            jugador.setPositionXJugador(jugador.getPositionXJugador() - 1); // Mover hacia la izquierda
            tablero[jugador.getPositionXJugador()][jugador.getPositionYJugador()] = "P";
            imprimirTablero();
            verificarEstadoJugador();
            if(verificarGanador()) return;
        } else {
            System.out.println("No más movimientos hacia arriba.");
        }
    }

    public void movimientoDOWN() {
        if (jugador.getPositionXJugador() < TAMANIO - 1) { // Validar límite derecho
            tablero[jugador.getPositionXJugador()][jugador.getPositionYJugador()] = "*";
            jugador.setPositionXJugador(jugador.getPositionXJugador() + 1); // Mover hacia la derecha
            tablero[jugador.getPositionXJugador()][jugador.getPositionYJugador()] = "P";
            imprimirTablero();
            verificarEstadoJugador();
            if(verificarGanador()) return;
        } else {
            System.out.println("No más movimientos hacia abajo.");
        }
    }

}
