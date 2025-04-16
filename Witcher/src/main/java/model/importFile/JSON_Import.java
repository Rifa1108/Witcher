/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.importFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.*;
import model.*;

/**
 *
 * @author rifa1
 */
public class JSON_Import extends FileImport {

    private Creature creature;
    private Recipe recipe;

    @Override
    public boolean parseFile() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            List newCreatures = mapper.readValue(chosenFile, List.class);
            for (Object addedCreature : newCreatures) {
                creature = new Creature(chosenFile.getName());
                HashMap<String, Object> allCharascteristics = (HashMap<String, Object>) addedCreature;
                creature.checkNewChararterictics(allCharascteristics);
                creatures.addCreature(creature);
            }
            return true;
        } catch (IOException | NumberFormatException | NullPointerException e) {
            return false;
        }
    }

}
