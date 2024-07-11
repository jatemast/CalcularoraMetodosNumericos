/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package softmath;

/**
 *
 * @author Usuario
 */
public class ReturnDelta {
    
    private double a;
    private double b;
    private double n;
    
    private double valor_delta;
    
    private Clasificatoria metodo;

    public ReturnDelta(double a, double b, double n, Clasificatoria metodo) {
        this.a = a;
        this.b = b;
        this.n = n;
        this.metodo = metodo;
        this.valor_delta = calcularDelta();
    }
    
    private double calcularDelta(){
        if(metodo==Clasificatoria.SIMPSON_1_3){
            return ((b-a)/2);
        }else if(metodo==Clasificatoria.SIMPSON_3_8){
            return ((b-a)/3);
        }else if(metodo==Clasificatoria.BOOLE){
            return ((b-a)/4);
        }else if(metodo==Clasificatoria.TRAPEZOIDAL){
            return ((b-a)/n);
        }else if(metodo==Clasificatoria.SIMPSON_ABIERTO){
            return ((b-a)/n);
        }
        
        return 0;
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
     * @return the valor_delta
     */
    public double getValor_delta() {
        return valor_delta;
    }

    /**
     * @param valor_delta the valor_delta to set
     */
    public void setValor_delta(double valor_delta) {
        this.valor_delta = valor_delta;
    }
    
    
}
