package co.com.sofka.main;

import co.com.sofka.funcion.Funciones;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class App {
    private static final Logger logger = Logger.getLogger(Funciones.class.getName());
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Funciones app = new Funciones();

        logger.info("""
                Ingrese una opcion deacuerdo a lo que desea realizar:1.Suma
                2.Resta
                3.Multiplicacion
                4.Division
                5.Modulo
                """
        );
        int option = scanner.nextInt();

        switch (option) {
            case 1:
                logger.log(Level.INFO, "ingrese 2 numeros a sumar seguido por enter");
                app.sumar(scanner.nextInt(), scanner.nextInt());
                break;
            case 2:
                app.resta();
                break;
            case 3:
                app.multiplicacion();
                break;
            case 4:
                app.division();
                break;
            case 5:
                app.modulo();
                break;
            case 6:
                logger.log(Level.INFO, "ingrese una opcion correcta");
        }


    }
}
