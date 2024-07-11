/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package softmath;

/**
 *
 * @author Usuario
 */
public class ReturnIntegrall {

    public static double resultadoIntegral(ReturnDelta delta, double sumatoria, Clasificatoria metodo) {

        double integral = 0;
        if (metodo == Clasificatoria.SIMPSON_1_3) {
            integral = (delta.getValor_delta() / 3) * (sumatoria);
        } else if (metodo == Clasificatoria.SIMPSON_3_8) {
            integral = ((3 * delta.getValor_delta()) / 8) * (sumatoria);
        } else if (metodo == Clasificatoria.BOOLE) {
            integral = ((2 * delta.getValor_delta()) / 45) * (sumatoria);
        } else if (metodo == Clasificatoria.TRAPEZOIDAL) {
            integral = ((delta.getValor_delta()) / 2) * (sumatoria);
        } else if (metodo == Clasificatoria.SIMPSON_ABIERTO) {
            integral = ((delta.getValor_delta()) / 3) * (sumatoria);
        }
        return integral;
    }
}
