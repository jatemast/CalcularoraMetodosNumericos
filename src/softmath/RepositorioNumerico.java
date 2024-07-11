/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package softmath;

import java.text.DecimalFormat;
import java.util.Locale;

/**
 *
 * @author Usuario
 */
public class RepositorioNumerico {

    public static String formatDecimal(double valor, String format) {
        if ((valor + "").length() > 5) {
            Locale.setDefault(Locale.ENGLISH);
            return new DecimalFormat(format).format(valor);
            
        } else {
            return valor + "";
        }

    }
}
