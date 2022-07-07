package co.com.sofka.funcion;


import com.google.common.collect.Streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;



public class Funciones {
    private static final Logger logger = Logger.getLogger(Funciones.class.getName());

    List<Double> lista1 = Arrays.asList(5.0, 4.0, 8.0, 10.0);
    List<Double> lista2 = Arrays.asList(2.0, 0.0, 6.0, 15.0);


    public void sumar(Integer numOne, Integer numTwo) {
        List<Integer> numeros = Arrays.asList(numOne, numTwo);
        Integer sum = numeros.stream()
                .reduce(0, (p1, p2) -> p1 + p2);
        logger.log(Level.INFO, "La suma del numero {0} y el numero {1} es {2}", new Object[]{numOne, numTwo, sum});

    }

    public void resta() {
//        creacion de un contador con la clase AtomicInteger
        AtomicInteger index = new AtomicInteger();
        lista1.stream()
                .map(p1 -> {
                    return p1 + lista2.get(index.getAndIncrement());
                })
                .forEach(p1 -> logger.info(p1.toString()));
    }

    public void multiplicacion() {
//        creacion de un contador con la clase AtomicInteger
        AtomicInteger index = new AtomicInteger();
        lista1.stream()
                .map(p1 -> {
                    return p1 * lista2.get(index.getAndIncrement());
                })
                .forEach(p1 -> logger.info(p1.toString()));
    }

    public void division() {
//        creacion de un contador con la clase AtomicInteger
        AtomicInteger index = new AtomicInteger();

        lista2.stream()
                .map(p2 -> {
                    if (p2.doubleValue() > 0) {
                        return lista1.get(index.getAndIncrement()) / p2;
                    }
                    return 0 / lista1.get(index.getAndIncrement());
                })
                .forEach(p1 -> logger.info(p1.toString()));


    }

    public void modulo() {

        Streams.mapWithIndex(lista1.stream(),
                        (p2, index) -> p2 % lista2.get((int) index))
                .filter(p -> p > 0)
                .forEach(p1 -> logger.info(p1.toString()));

    }


}
