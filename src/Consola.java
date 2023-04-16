import java.util.Scanner;

    public class Consola {

        private static Scanner scan = new Scanner (System.in);

        public static void escribir (Object x) {
            System.out.println(x);
        }

        public static String leerString (String mensaje) {
            scan.nextLine();
            Consola.escribir(mensaje);
            return scan.nextLine();
        }

        public static int leerInt (String mensaje) {
            scan.nextLine();
            Consola.escribir(mensaje);
            return scan.nextInt();
        }

        public static float leerFloat (String mensaje) {
            scan.nextLine();
            Consola.escribir(mensaje);
            return scan.nextFloat();
        }
    }
