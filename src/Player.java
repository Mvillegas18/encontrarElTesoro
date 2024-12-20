public class Player {
    final int movimientos = 10;
    int vidas = 3;
    final int minas = 35;
    String nombre;

    int positionXJugador;
    int positionYJugador;

    int positionXTesoro;
    int positionYTesoro;

    String resultados;
    String tiempoJugador;

    int movimientosRestantes = movimientos;

    // Nombre
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Posicion Jugador (x, y)
    public int getPositionXJugador() {
        return positionXJugador;
    }

    public void setPositionXJugador(int positionXJugador) {
        this.positionXJugador = positionXJugador;
    }

    public int getPositionYJugador() {
        return positionYJugador;
    }

    public void setPositionYJugador(int positionYJugador) {
        this.positionYJugador = positionYJugador;
    }

    // Vidas
    public int getVidas() {
        return vidas;
    }

    // Movimientos
    public int getMovimientos() {
        return movimientosRestantes;
    }

    public void setMovimientos(int movimientosRestantes) {
        this.movimientosRestantes = movimientosRestantes;
    }

    // Posicion tesoro (x , y)
    public void setPositionXTesoro(int positionXTesoro) {
        this.positionXTesoro = positionXTesoro;
    }

    public int getPositionXTesoro() {
        return positionXTesoro;
    }

    public void setPositionYTesoro(int positionYTesoro) {
        this.positionYTesoro = positionYTesoro;
    }

    public int getPositionYTesoro() {
        return positionYTesoro;
    }

    // Resultados jugador
    public void setResultados(String resultados) {
        this.resultados = resultados;
    }

    public String getResultados() {
        return resultados;
    }

    // Tiempo Jugador
    public void setTiempoJugador(String tiempoJugador) {
        this.tiempoJugador = tiempoJugador;
    }

    public String getTiempoJugador() {
        return tiempoJugador;
    }

    // Minas
    public int getMinas() {
        return this.minas;
    }


}
