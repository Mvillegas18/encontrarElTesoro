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
        System.out.println("*          - Usa las flechas para moverte.          *");
        System.out.println("*          - Evita las minas y encuentra el tesoro. *");
        System.out.println("*                                                   *");
        System.out.println("*****************************************************");
        System.out.println("*             ¡Buena suerte y que comience          *");
        System.out.println("*                    la aventura!                   *");
        System.out.println("*****************************************************");

    }

    public static void menu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingresa una opcion: ");
        System.out.println("1. Nuevo juego\n2. Ver resultados\n3. Salir");
        System.out.print("\uD83D\uDC49 ");

        Game game = new Game();

        int opcion = sc.nextInt();

        if (opcion == 1) {
            game.empezarNuevoJuego();
        }else if (opcion == 2) {
            game.mostrarResultados();
        }else if (opcion == 3) {
            game.salir();
        }

    }
}