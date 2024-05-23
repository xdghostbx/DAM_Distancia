/*
 contructor, setter y getter para el objeto rectangulo
 */
package pruebas;

/**
 *
 * @author xdGHOSTbx
 */
public class rectangulo {
    private float base = 0;
    private float altura = 0;
    
    
    
    public rectangulo(float base, float altura) {
        this.base = base;
        this.altura = altura;
    }

    public float getBase() {
        return base;
    }

    public void setBase(float base) {
        this.base = base;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }
    
}
