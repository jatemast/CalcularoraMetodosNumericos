/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package softmath;

import java.util.List;
import java.util.Map;

/**
 *
 * @author Usuario
 */
public class Funciones {
    
    public static void iterarMetodoSimpson1_3(List<Map> lista_sumatoria){
        for (int i = 0; i < lista_sumatoria.size(); i++) {
            Map iteracion = lista_sumatoria.get(i);
            if(i==1){
                iteracion.put("producto", 4);
            }
            lista_sumatoria.set(i, iteracion);
        }
    }
    
    public static void iterarMetodoSimpson3_8(List<Map> lista_sumatoria){
        for (int i = 0; i < lista_sumatoria.size(); i++) {
            Map iteracion = lista_sumatoria.get(i);
            if(i>0 && i<(lista_sumatoria.size()-1)){
                iteracion.put("producto", 3);
            }
            lista_sumatoria.set(i, iteracion);
        }
    }
    
    public static void iterarMetodoBoole(List<Map> lista_sumatoria){
        for (int i = 0; i < lista_sumatoria.size(); i++) {
            Map iteracion = lista_sumatoria.get(i);
            if(i==0 || i==(lista_sumatoria.size()-1)){
                iteracion.put("producto", 7);
            }else if(i==1 || i==(lista_sumatoria.size()-2)){
                iteracion.put("producto", 32);
            }else if(i==2){
                iteracion.put("producto", 12);
            }
            lista_sumatoria.set(i, iteracion);
        }
    }
    
    public static void iterarMetodoTrapezoidal(List<Map> lista_sumatoria){
        for (int i = 0; i < lista_sumatoria.size(); i++) {
            Map iteracion = lista_sumatoria.get(i);
            if(i>0 && i<(lista_sumatoria.size()-1)){
                iteracion.put("producto", 2);
            }
            lista_sumatoria.set(i, iteracion);
        }
    }
    
    public static void iterarMetodoSimpson_abierto(List<Map> lista_sumatoria){
        int prod = 2;
        for (int i = 0; i < lista_sumatoria.size(); i++) {
            Map iteracion = lista_sumatoria.get(i);
            if(i==0 || i==(lista_sumatoria.size()-1)){
                iteracion.put("producto", 1);
            }else{
                if(prod==2){
                    prod=4;
                }else{
                    prod=2;
                }
                iteracion.put("producto", prod);
            }
            lista_sumatoria.set(i, iteracion);
        }
    }
    
}
