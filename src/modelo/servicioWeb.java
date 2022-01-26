
package modelo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class servicioWeb {
    
    public static Float mostrarContenido(String url) {
        try{
            URL ficheroUrl = new URL(url);
            String valor;
            try (BufferedReader in = new BufferedReader(new InputStreamReader(ficheroUrl.openStream()))) {
                String linea;
                valor = "";
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
            }
            return Float.parseFloat(valor);
        }catch(IOException | NumberFormatException e){
            
        }
        return 0.0f;
    }
    
    
}
