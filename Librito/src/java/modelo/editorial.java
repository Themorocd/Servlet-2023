/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Andres
 */
public class editorial {
    String ideditorial;
    String nombreeditorial;

    public editorial(String ideditorial, String nombreeditorial) {
        this.ideditorial = ideditorial;
        this.nombreeditorial = nombreeditorial;
    }

    public String getIdeditorial() {
        return ideditorial;
    }

    public void setIdeditorial(String ideditorial) {
        this.ideditorial = ideditorial;
    }

    public String getNombreeditorial() {
        return nombreeditorial;
    }

    public void setNombreeditorial(String nombreeditorial) {
        this.nombreeditorial = nombreeditorial;
    }
}
