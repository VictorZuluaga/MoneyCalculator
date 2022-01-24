
package modelo;

public class conversor {
    
    private final divisa d1;
    private final divisa d2;
    private final float cantidad;
    
    public conversor(divisa d1, divisa d2, float cantidad){
        this.d1 = d1;
        this.d2 = d2;
        this.cantidad = cantidad;
    }
    
    public float conversion(){
        String url_1 = "https://cdn.jsdelivr.net/gh/fawazahmed0/currency-api@1/latest/currencies";
        String div_1 = "/"+this.d1.getCodigo().toLowerCase();
        String div_2 = "/"+this.d2.getCodigo().toLowerCase();
        String url_2 = ".json";
        float ratio = servicioWeb.mostrarContenido(url_1+div_1+div_2+url_2);
        float resultado = cantidad*ratio;
        resultado = Math.round(resultado * 100f) / 100f;
        return resultado;
    }
    
    
}
