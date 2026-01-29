import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Main {

    static int dia = 1;
    static final int DIAS_MAX = 7;

    static int comida = 5;
    static int agua = 5;
    static int salud = 10;

    static boolean juegoActivo = true;

    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();

    public static void main(String[] args) {

        System.out.println("🌍 BIENVENIDO AL NUEVO MUNDO 🌍");

        while (juegoActivo && dia <= DIAS_MAX) {
            mostrarEstado();
            elegirAccion();
            eventoAleatorio();
            comprobarEstado();
            dia++;
        }

        finalJuego();
    }

     static void mostrarEstado() {
        System.out.println("\n📅 Día: " + dia);
        System.out.println("🍞 Comida: " + comida);
        System.out.println("💧 Agua: " + agua);
        System.out.println("❤️ Salud: " + salud);
    }
    /**
     *  Es el bucle principal del programa(el while) está ejecutando siempre que sigas jugando, haciendo que cada vez que se acaba el
     *  bucle de la accion se vuelva a mostrar las estadisticas de tu personaje.
     *  También al final de cada bucle suma un día al contador de días.
     *
     *
     */
    static void elegirAccion() {
        int opcion = 0;

        System.out.println("\n¿Qué quieres hacer?");
        System.out.println("1️⃣ Buscar comida 🍞");
        System.out.println("2️⃣ Beber agua 💧");
        System.out.println("3️⃣ Descansar 😴");
        System.out.println("4️⃣ Explorar 🧭");

        try {
            opcion = scanner.nextInt();
        } catch (InputMismatchException e) {
            scanner.nextLine();
        }

        switch (opcion) {
            case 1 -> comida += 2;
            case 2 -> agua += 2;
            case 3 -> salud += 1;
            case 4 -> {
                comida -= 1;
                agua -= 1;
            }
            default -> System.out.println("❌ Opción inválida");
        }
    }

    static void eventoAleatorio() {
        int evento = random.nextInt(4);

        switch (evento) {
            case 0 -> {
                salud -= 2;
                System.out.println("🤒 Te has enfermado");
            }
            case 1 -> {
                comida += 1;
                System.out.println("🍀 Encuentras lo que buscabas");
            }
            case 2 -> {
                agua -= 2;
                System.out.println("💥 Accidente inesperado");
            }
            case 3 -> System.out.println("🌤️ Día tranquilo");
        }
    }
    /**
     *  Es el bucle que tiene toda la parte del juego donde principalmente te pregunta que es lo que quieres hacer en el día dandote a escojer entre las 4 acciones
     *  una vez escojida un switch con 4 posibles casos te dara una opcion aleatoria con un resultado diferente cada una que puede afectar positivamente o negativamente
     *  a tus estadisticas y, por tanto, restandole valor o sumandole.
     *
     *
     */
    static void comprobarEstado() {
        try {
            if (comida <= 0 || agua <= 0 || salud <= 0) {
                throw new Exception();
            }
        } catch (Exception e) {
            juegoActivo = false;
        }
    }
    /**
     *  Este ya es el final del juego es decir una vez llegue aquie la partida acabará
     *  ya sea porque el contador de días llego a 7 y, por tanto, ganaste la partida
     *  o porque alguna de tus estadisticas llego a 0 siendo comida,
     *  agua o vida y, por lo tanto, perdiste la partida.
     */

    static void finalJuego() {
        if (salud > 0 && comida > 0 && agua > 0) {
            System.out.println("\n🏆 HAS SOBREVIVIDO LOS 7 DÍAS 🏆");
        } else {
            System.out.println("\n☠️ NO LOGRASTE SOBREVIVIR ☠️");
        }
    }
}

