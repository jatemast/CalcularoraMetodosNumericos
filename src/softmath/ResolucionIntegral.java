/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package softmath;

import de.congrace.exp4j.Calculable;
import de.congrace.exp4j.CustomFunction;
import de.congrace.exp4j.ExpressionBuilder;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Usuario
 */
public class ResolucionIntegral {
    
    private double a;
    private double b;
    private double n;
    
    private Clasificatoria metodo;
    
    private ReturnDelta delta;
    
    private double sumatoria;
    private double resultado;

    public ResolucionIntegral(double a, double b, double n,ReturnDelta delta, 
            Clasificatoria metodo) {
        this.a = a;
        this.b = b;
        this.n = n;
        this.metodo = metodo;
        this.delta = delta;
    }
    
    @SuppressWarnings("CallToThreadDumpStack")
    public List<Map> desarrolloSumatoria(String funcion)throws Exception{
        try {
            double acum = a;
            
            List<Map> lista_sumatoria = new ArrayList<Map>();
            for(int i = 1;i<=n;i++){
               Map iteracion = new HashMap();
               
               if(i>1){
                   acum+=delta.getValor_delta();
               }
               
               CustomFunction ln = new CustomFunction("ln") {
                    @Override
                    public double applyFunction(double... doubles) {
                        return Math.log(doubles[0]);
                    }
                };
               
               CustomFunction log = new CustomFunction("log") {
                    @Override
                    public double applyFunction(double... doubles) {
                        return Math.log10(doubles[0]);
                    }
                };
               
               Calculable calculable = new ExpressionBuilder(funcion).
                       withVariable("x", acum).
                       withVariable("e", 2.718281828459045D).
                       withCustomFunction(ln).
                       withCustomFunction(log).
                       build();
               iteracion.put("xi", acum);
               iteracion.put("fxi", calculable.calculate());
               iteracion.put("expresion", reemplazarVariableFuncion(funcion,
                       "x",acum));
               iteracion.put("producto", 1);
               
               lista_sumatoria.add(iteracion);
            }
            iterarListaSumatoriaGeneral(lista_sumatoria);
            return lista_sumatoria;
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Error en la función");
        }
    }
    
    private void iterarListaSumatoriaGeneral(List<Map> lista_sumatoria){
        if(metodo== Clasificatoria.SIMPSON_1_3){
            Funciones.iterarMetodoSimpson1_3(lista_sumatoria);
        }else if(metodo== Clasificatoria.SIMPSON_3_8){
            Funciones.iterarMetodoSimpson3_8(lista_sumatoria);
        }else if(metodo== Clasificatoria.BOOLE){
            Funciones.iterarMetodoBoole(lista_sumatoria);
        }else if(metodo== Clasificatoria.TRAPEZOIDAL){
            Funciones.iterarMetodoTrapezoidal(lista_sumatoria);
        }else if(metodo== Clasificatoria.SIMPSON_ABIERTO){
            Funciones.iterarMetodoSimpson_abierto(lista_sumatoria);
        }
    }
    
    private String reemplazarVariableFuncion(String funcion,
            String variable,double num){
        
        String txt = funcion+"";
        return txt.replaceAll(variable, RepositorioNumerico.formatDecimal(num, 
                "#,##0.00"));
    }
    
    /**
     * @return the a
     */
    public double getA() {
        return a;
    }

    /**
     * @param a the a to set
     */
    public void setA(double a) {
        this.a = a;
    }

    /**
     * @return the b
     */
    public double getB() {
        return b;
    }

    /**
     * @param b the b to set
     */
    public void setB(double b) {
        this.b = b;
    }

    /**
     * @return the n
     */
    public double getN() {
        return n;
    }

    /**
     * @param n the n to set
     */
    public void setN(double n) {
        this.n = n;
    }

    /**
     * @return the metodo
     */
    public Clasificatoria getMetodo() {
        return metodo;
    }

    /**
     * @param metodo the metodo to set
     */
    public void setMetodo(Clasificatoria metodo) {
        this.metodo = metodo;
    }

    /**
     * @return the sumatoria
     */
    public double getSumatoria() {
        return sumatoria;
    }

    /**
     * @param sumatoria the sumatoria to set
     */
    public void setSumatoria(double sumatoria) {
        this.sumatoria = sumatoria;
    }

    /**
     * @return the resultado
     */
    public double getResultado() {
        return resultado;
    }

    /**
     * @param resultado the resultado to set
     */
    public void setResultado(double resultado) {
        this.resultado = resultado;
    }

    /**
     * @return the delta
     */
    public ReturnDelta getDelta() {
        return delta;
    }

    /**
     * @param delta the delta to set
     */
    public void setDelta(ReturnDelta delta) {
        this.delta = delta;
    }
    
    
}
