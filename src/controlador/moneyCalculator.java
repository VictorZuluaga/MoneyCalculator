
package controlador;
import modelo.*;
import vista.*;
public class moneyCalculator {
    
    public static float ejecucion(String d1_nombre, String d2_nombre, float cantidad){
        divisa d1 = new divisa(d1_nombre);
        divisa d2 = new divisa(d2_nombre);
        conversor c1 = new conversor(d1,d2,cantidad);
        return c1.conversion();
    }
    public static void main(String[] args) throws Exception{
        vistaModelo v1 = new vistaModelo();
    }
    
}
