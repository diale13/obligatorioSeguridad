/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import java.util.ArrayList;
import obligatorio.Objeto;
import obligatorio.Sujeto;

/**
 *
 * @author Cono
 */
public class MemoryDataBase {
    private ArrayList<Objeto> objects;
    private ArrayList<Sujeto> subjects;

    public ArrayList<Objeto> getObjects() {
        return objects;
    }

    public void addObject(Objeto object) {
        this.objects.add(object);
    }

    public ArrayList<Sujeto> getSubjects() {
        return subjects;
    }

     public void addSubject(Sujeto sub ) {
        this.subjects.add(sub);
     }   
    
}
