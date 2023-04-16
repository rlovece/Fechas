import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;

public class Main {
    public static void main(String[] args) {

        int opcion = menu();
        switch (opcion){
            case 1:
                ejemplo1();
                break;

            case 2:
                ejemplo2();
                break;

            case 0:
                Consola.escribir("Gracias por su visita 👋");
            default:
                Consola.escribir("Opción incorrecta!");
        }





    }

    public static int menu (){

        Consola.escribir("1. Ingrese su fehca de nacimiento para saber su edad");
        Consola.escribir("2. Cuantos días hay entre dos fechas");
        Consola.escribir("Elige una opción 👆 o 0 para salir!");
        int opcion = Consola.leerInt("Qué opción? 😁\n");
        return opcion;
    }

    ///region Ej1
    /* 1. Crea un programa que pida al usuario una fecha de nacimiento en formato
          dd/MM/yyyy y calcule su edad en años, meses y días. */
    public static void ejemplo1 (){
        String stringEdad = Consola.leerString("Ingrese su edad con formato dd/MM/yyyy");
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        if (verificarFechaString(stringEdad)) {
            try {
                Date nacDate = formatoFecha.parse(stringEdad); /// obtengo fecha en Date
                Calendar nacimiento = Calendar.getInstance();
                nacimiento.setTime(nacDate); /// obtengo fecha Calendar
                Calendar hoy = Calendar.getInstance();
                int edad, edadMeses, edadDias;
                if (hoy.get(Calendar.YEAR)<nacimiento.get(Calendar.YEAR)) {
                    edad = hoy.get(Calendar.YEAR) - nacimiento.get(Calendar.YEAR) - 1;
                } else {
                    edad = hoy.get(Calendar.YEAR) - nacimiento.get(Calendar.YEAR);
                }
                if (hoy.get(Calendar.MARCH) < nacimiento.get(Calendar.MARCH)) {
                    edadMeses = hoy.get(Calendar.MARCH) - nacimiento.get(Calendar.MARCH) + 12;
                } else {
                    edadMeses = hoy.get(Calendar.MARCH) - nacimiento.get(Calendar.MARCH);
                }
                if (hoy.get(Calendar.DAY_OF_MONTH) < nacimiento.get(Calendar.DAY_OF_MONTH)){
                    edadDias = hoy.get(Calendar.DAY_OF_MONTH) - nacimiento.get(Calendar.DAY_OF_MONTH) +
                            nacimiento.getActualMaximum(Calendar.DAY_OF_MONTH);
                } else {
                    edadDias = hoy.get(Calendar.DAY_OF_MONTH) - nacimiento.get(Calendar.DAY_OF_MONTH);
                }
                Consola.escribir( "Usted tiene " + edad + "/" + edadMeses + "/" + edadDias + " (Años/meses/días)");
            } catch (ParseException e) {
                System.out.println("error = " + e);
            }
        }
        else {
            Consola.escribir("La fecha ingresada no tiene formato correcto!");
        }

    }

    public static boolean verificarFechaString (String fecha){
        String[] auxArreglo = fecha.split("/");
        int dia = Integer.parseInt(auxArreglo[0]);
        int mes = Integer.parseInt(auxArreglo[1]);
        int anio = Integer.parseInt(auxArreglo[2]);
        return (1 <= dia && dia <= 31 && 1 <= mes && mes <= 12 && 1<anio && anio <= 2023);
    }


    ///endregion

    ///region Ej2
       /*   Crea un programa que pida al usuario dos fechas en formato dd/MM/yyyy y
            calcule la cantidad de días entre ambas fechas.   */
    public static void ejemplo2 (){
        String stringMasAntigua = Consola.leerString("Ingrese la fecha más antigua fecha dd/MM/yyyy");
        String stringMasCercana = Consola.leerString("Ingrese la fecha más cercana dd/MM/yyyy");
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        if (verificarFechaString(stringMasAntigua) && verificarFechaString(stringMasCercana)) {
            try {
                Date fechaAntiguaDate = formatoFecha.parse(stringMasAntigua); /// obtengo fecha en Date
                Date fechaCercaDate = formatoFecha.parse(stringMasCercana); /// obtengo fecha en Date

                Calendar fechaAntigua = Calendar.getInstance();
                fechaAntigua.setTime(fechaAntiguaDate); /// obtengo fecha Calendar

                Calendar fechaCercana = Calendar.getInstance();
                fechaCercana.setTime(fechaCercaDate); /// obtengo fecha Calendar

                int edad, edadMeses, edadDias;
                if (fechaAntigua.get(Calendar.YEAR) < fechaCercana.get(Calendar.YEAR)) {
                    edad = fechaCercana.get(Calendar.YEAR) - fechaAntigua.get(Calendar.YEAR) - 1;
                } else {
                    edad = fechaCercana.get(Calendar.YEAR) - fechaAntigua.get(Calendar.YEAR);
                }
                if (fechaCercana.get(Calendar.MARCH) < fechaAntigua.get(Calendar.MARCH)) {
                    edadMeses = fechaCercana.get(Calendar.MARCH) - fechaAntigua.get(Calendar.MARCH) + 12;
                } else {
                    edadMeses = fechaCercana.get(Calendar.MARCH) - fechaAntigua.get(Calendar.MARCH);
                }
                if (fechaCercana.get(Calendar.DAY_OF_MONTH) < fechaAntigua.get(Calendar.DAY_OF_MONTH)){
                    edadDias = fechaCercana.get(Calendar.DAY_OF_MONTH) - fechaAntigua.get(Calendar.DAY_OF_MONTH) +
                            fechaCercana.getActualMaximum(Calendar.DAY_OF_MONTH);
                } else {
                    edadDias = fechaCercana.get(Calendar.DAY_OF_MONTH) - fechaAntigua.get(Calendar.DAY_OF_MONTH);
                }
                Consola.escribir( "Entre las fechas ingresadas hay " + (365*edad+edadMeses*30+edadDias+edadMeses/2) + " días");
            } catch (ParseException e) {
                System.out.println("error = " + e);
            }
        }
        else {
            Consola.escribir("La fecha ingresada no tiene formato correcto!");
        }

    }



    ///endregion



}


/*
5. Crea un programa que genere un número aleatorio entre 1 y 100 y le pida al
usuario que adivine el número. El programa debe indicar si el número del
usuario es mayor o menor que el número generado y seguir pidiendo al
usuario que adivine hasta que acierte. El usuario tiene oportunidades
limitadas (a libre elección).
9. Cree una aplicación con menú donde se puedan utilizar los métodos de la
clase Math. Solo los métodos vistos en clase

2. Crea un programa que pida al usuario una cadena de texto y determine si es
un palíndromo (es decir, si se lee igual de izquierda a derecha que de derecha
a izquierda).
3. Crea un programa que pida al usuario una cadena de texto y determine
cuántas veces aparece una subcadena específica en la cadena de texto.
4. Crea un programa que pida al usuario una cadena de texto y la convierta en
una cadena de camelCase. La cadena de texto tiene que separar cada
palabra por un espacio.
6. Crea un programa que pida al usuario una cadena de texto y elimine todas las
vocales de la cadena.
8. Crea un programa que pida al usuario una cadena de texto dividida por
espacios y la convierta en una cadena de snake_case.
 */