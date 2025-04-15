/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/**
 *
 * @author rifa1
 */
public class Creatures {

    private HashMap<String, ArrayList<Creature>> creatures = new HashMap<String, ArrayList<Creature>>();

    public void setSource(String source) {
        creatures.put(source, new ArrayList<Creature>());
    }

    public void addCreature(Creature creature) {
        creatures.get(creature.getSource()).add(creature);
    }

    public ArrayList<String> getKinds(String source) {
        ArrayList<String> kinds = new ArrayList<String>();
        for (Creature creature : creatures.get(source)) {
            kinds.add(creature.getKind());
        }
        return kinds;
    }

    public Set<String> getSources() {
        return creatures.keySet();
    }

    public Creature getCreature(String source, int index) {
        return creatures.get(source).get(index);
    }

    public ArrayList<HashMap<String,Object>> getCreatures(String source) {
        ArrayList<Creature> neededCreatures= creatures.get(source);
        ArrayList<HashMap<String,Object>> sendCreatures = new ArrayList<HashMap<String,Object>>();
        for (int i = 0; i < neededCreatures.size(); i++){
            sendCreatures.add(neededCreatures.get(i).getAllChararterictics());
        }     
        return sendCreatures;
    }

}
