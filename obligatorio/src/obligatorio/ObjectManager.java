/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package obligatorio;

import java.util.ArrayList;

/**
 *
 * @author Cono
 */
public class ObjectManager {
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
