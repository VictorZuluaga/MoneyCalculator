
package modelo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class listaDivisas {
    
    public static ArrayList<String> lista(){
        ArrayList<String> resultado = new ArrayList<>();
        try{
            BufferedReader bf = new BufferedReader(new FileReader("currencies.txt"));
            String linea = bf.readLine();
            String aux = null;
            int ini = 0;
            int fin = 0;
            while( linea!= null){
                ini = linea.indexOf(",");
                fin = linea.lastIndexOf(",");
                resultado.add(linea.substring(ini+2,fin));
                linea = bf.readLine();
            }
        }catch(IOException e){}
        return resultado;
    }
    
    
    
}
