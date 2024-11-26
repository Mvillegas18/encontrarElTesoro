import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        mensajeBienvenida();
        menu();


    }

    public static void mensajeBienvenida() {
        System.out.println("*****************************************************");
        System.out.println("*                                                   *");
        System.out.println("*       🏆 Bienvenido a 'En Busca del Tesoro' 🏆   *");
        System.out.println("*                                                   *");
        System.out.println("*                                                   *");
        System.out.println("*           Encuentra el tesoro perdido en          *");
        System.out.println("*           un laberinto lleno de desafíos.         *");
        System.out.println("*                                                   *");
        System.out.println("*****************************************************");
        System.out.println("*                                                   *");
        System.out.println("*               Instrucciones del juego:            *");
        System.out.println("*                                                   *");
        System.out.println("*  - Usa las flechas para moverte.                  *");
        System.out.println("*  - Evita las minas y encuentra el tesoro.         *");
        System.out.println("*  - Para ganar recorre el laberinto formando una L.*");
        System.out.println("*  - Tienes 10 movimientos maximos y 3 vidas.       *");
        System.out.println("*****************************************************");
        System.out.println("*             ¡Buena suerte y que comience          *");
        System.out.println("*                    la aventura!                   *");
        System.out.println("*****************************************************");

    }

    public static void menu() {
            Scanner entrada = new Scanner(System.in);
            Game game = new Game();
            boolean continuar = true;
            while (continuar) {
                System.out.println("\nIngresa una opción: ");
                System.out.println("1. Nuevo juego\n2. Ver resultados\n3. Salir");
                System.out.print("\uD83D\uDC49 ");
                int opcion = entrada.nextInt();
                entrada.nextLine(); // Consumir salto de línea

                switch (opcion) {
                    case 1:
                        boolean juegoActivo = game.empezarNuevoJuego(); // Inicia el juego
                        if (!juegoActivo) {
                            System.out.println("El juego terminó.");
                        }
                        break;
                    case 2:
                        game.mostrarResultados(); // Ver resultados
                        break;
                    case 3:
                        game.salir(); // Salir
                        continuar = false;
                        break;
                    default:
                        System.out.println("Opción no válida. Inténtalo de nuevo.");
                }
            }
            entrada.close();
    }
}