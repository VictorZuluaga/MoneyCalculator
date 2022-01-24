
package modelo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class servicioWeb {
    
    public static Float mostrarContenido(String url) {
        try{
            URL ficheroUrl = new URL(url);
            BufferedReader in = new BufferedReader(new InputStreamReader(ficheroUrl.openStream()));
            String linea;
            String valor = "";
            int contador = 0;
            int aux = 0;
            while ((linea = in.readLine()) != null){
                contador++;
                if(contador == 3){
                    aux = linea.indexOf(":")+2;
                    valor = linea.substring(aux);
                    break;
                }
            }
            in.close();
            return Float.parseFloat(valor);
        }catch(Exception e){
            
        }
        return 0.0f;
    }
    
    
}
