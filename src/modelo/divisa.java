
package modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class divisa {
    
    String nombre;
    String codigo;
    String simbolo;
    
    //Pimer constructor para la divisa
    public divisa(String nombre){
        this.nombre = nombre;
        try{
            String info = info(this.nombre);
            int aux = info.indexOf(",");
            this.codigo = info.substring(0,aux);
            aux = info.lastIndexOf(",");
            this.simbolo = info.substring(aux+2);
        }catch(NullPointerException er){
            this.nombre = null;
            System.out.println("Error divisa no encontrada\n");
        }catch(Exception e){
            System.out.println("Error durante la lectura del archivo\n");
        }
    }
    
    private static String info(String nombre) throws Exception{
        File fichero = new File("divisas.txt");
        BufferedReader bf = new BufferedReader(new FileReader(fichero));
        String linea = bf.readLine();
        String resultado = null;
        while( linea!= null){
            if(linea.contains(nombre)){
                resultado = linea;
                break;
            }
            linea = bf.readLine();
        }
        return resultado;
    }
    
    public String getNombre(){
        return this.nombre;
    }
    public String getCodigo(){
        return this.codigo;
    }
    public String getSimbolo(){
        return this.simbolo;
    }
    
}
