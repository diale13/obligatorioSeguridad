/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package obligatorio;

/**
 *
 * @author Cono
 */
public class Sujeto {
    private String nombre;
    private int temp;
    private  SecurityLevel level;

    public Sujeto(String nombre) {
        this.nombre = nombre;
        this.temp = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTemp() {
        return temp;
    }

    public void setTemp(int temp) {
        this.temp = temp;
    }    
        
}
