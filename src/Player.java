public class Player {
    final int movimientos = 10;
    final int vidas = 3;
    String nombre;
    int positionX;
    int positionY;


    // Nombre
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    //Posicion
    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    // Vidas
    public int getVidas() {
        return vidas;
    }

    // Movimientos
    public int getMovimientos() {
        return movimientos;
    }
}
