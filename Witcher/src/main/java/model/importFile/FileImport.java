/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.importFile;

import java.io.File;
import model.Creatures;

/**
 *
 * @author rifa1
 */
public abstract class FileImport {

    protected File chosenFile;
    protected Creatures creatures;

    public void setCreatures(Creatures creatures) {
        this.creatures = creatures;
    }

    public void setFile(File chosenFile) {
        this.chosenFile = chosenFile;
    }

    public abstract boolean parseFile();

}
