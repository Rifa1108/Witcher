/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.importFile;

import java.io.*;
import java.util.*;
import model.*;
import org.yaml.snakeyaml.Yaml;

/**
 *
 * @author rifa1
 */
public class YAML_Import extends FileImport {

    private Creature creature;
    private Recipe recipe;

    @Override
    public boolean parseFile() {
        Yaml yaml = new Yaml();
        try {
            InputStream inputStream = new FileInputStream(super.chosenFile);
            ArrayList<HashMap<String, Object>> newCreatures = yaml.load(inputStream);
            for (HashMap<String, Object> allCharascteristics : newCreatures) {
                creature = new Creature(chosenFile.getName());
                creature.setAllChararterictics(allCharascteristics);
                creatures.addCreature(creature);
            }
            return true;

        } catch (FileNotFoundException | NumberFormatException | NullPointerException ex) {
            return false;
        }

    }

}
