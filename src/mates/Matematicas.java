package mates;

import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.LongStream;

/**
 * La clase Matematicas proporciona métodos para realizar cálculos matemáticos.
 */
public class Matematicas {

    /**
     * Genera una aproximación al número Pi mediante el método de Montecarlo.
     * El parámetro `pasos` indica el número de puntos generado.
     *
     * @param pasos El número de pasos para generar puntos.
     * @return Una aproximación del número Pi.
     */
    public static double generarPiParalelamente(long pasos) {
        // Se obtiene una instancia de ThreadLocalRandom para generar números aleatorios seguros en entornos concurrentes
        ThreadLocalRandom rand = ThreadLocalRandom.current();

        // Genera puntos aleatorios en paralelo y cuenta los puntos dentro del círculo
        long puntosDentroCirculo = LongStream.range(0, pasos)
                .parallel() // Realiza en paralelo
                .map(i -> {
                    // Genera coordenadas (x, y) aleatorias dentro del cuadrado unitario
                    double x = rand.nextDouble();
                    double y = rand.nextDouble();
                    // Comprueba si el punto está dentro del círculo unitario
                    return (x * x + y * y <= 1) ? 1 : 0;
                })
                .sum();

        // Calcula la aproximación de Pi
        return 4.0 * (puntosDentroCirculo / (double) pasos);
    }
}
