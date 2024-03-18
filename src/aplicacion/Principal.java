package aplicacion;

import mates.Matematicas;

/**
 * La clase Principal es la clase principal de la aplicación.
 * Calcula una aproximación del número Pi utilizando el método de Montecarlo.
 */
public class Principal {

    /**
     * El método main es el punto de entrada de la aplicación.
     * Calcula una aproximación del número Pi y lo imprime en la consola.
     *
     * @param args Los argumentos pasados a la aplicación. Se espera que el primer argumento sea el número de pasos para la aproximación de Pi.
     */
    public static void main(String[] args) {
        // Calcula una aproximación de Pi utilizando el método de Montecarlo
        double aproximacionPi = Matematicas.generarPiParalelamente(Integer.parseInt(args[0]));

        // Imprime la aproximación de Pi en la consola
        System.out.println("El número PI es " + aproximacionPi);
    }
}
