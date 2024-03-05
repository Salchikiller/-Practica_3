package mates;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
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
        Random rand = new Random();
        
        // Generate random points in parallel
        List<Boolean> pointsInCircle = LongStream.range(0, pasos)
                .parallel() // Perform in parallel
                .mapToObj(i -> {
                    double x = rand.nextDouble();
                    double y = rand.nextDouble();
                    return x * x + y * y <= 1;
                })
                .collect(Collectors.toList());

        // Count points inside the circle
        long puntosDentroCirculo = pointsInCircle.stream()
                .filter(isInside -> isInside)
                .count();

        // Calculate Pi approximation
        return 4.0 * ((double) puntosDentroCirculo / pasos);
    }
}
