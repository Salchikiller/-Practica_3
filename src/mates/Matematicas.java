package mates;

import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.LongStream;

public class Matematicas {

    /**
     * Genera una aproximación al número Pi mediante el método de Montecarlo.
     * El parámetro `pasos` indica el número de puntos generado.
     *
     * @param pasos El número de pasos para generar puntos.
     * @return Una aproximación del número Pi.
     */
    public static double generarPiParalelamente(long pasos) {
        ThreadLocalRandom rand = ThreadLocalRandom.current();

        // Generate random points in parallel and count points inside the circle
        long puntosDentroCirculo = LongStream.range(0, pasos)
                .parallel() // Perform in parallel
                .map(i -> {
                    double x = rand.nextDouble();
                    double y = rand.nextDouble();
                    return (x * x + y * y <= 1) ? 1 : 0;
                })
                .sum();

        // Calculate Pi approximation
        return 4.0 * (puntosDentroCirculo / (double) pasos);
    }
}
