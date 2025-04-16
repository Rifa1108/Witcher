/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.importFile;

import controller.Characteristic;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import javax.xml.namespace.QName;
import javax.xml.stream.*;
import javax.xml.stream.events.*;
import model.*;

/**
 *
 * @author rifa1
 */
public class XML_Import extends FileImport {

    private Creature creature;
    private Recipe recipe;

    @Override
    public boolean parseFile() {
        try {
            XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
            XMLEventReader reader = xmlInputFactory.createXMLEventReader(new FileInputStream(super.chosenFile));
            HashMap<String, Object> allCharascteristics = new HashMap<String, Object>();
            ArrayList<Object> immunities = new ArrayList<Object>();
            ArrayList<Object> areas = new ArrayList<Object>();
            HashMap<String, Object> newRecipe = new HashMap<String, Object>();
            HashMap<String, Integer> ingredients = new HashMap<String, Integer>();
            while (reader.hasNext()) {
                XMLEvent event = reader.nextEvent();
                if (event.isStartElement()) {
                    StartElement startElement = event.asStartElement();
                    String characteristic = startElement.getName().getLocalPart();
                    if (characteristic.equals("Creature")) {
                        creature = new Creature(chosenFile.getName());
                        allCharascteristics = new HashMap<String, Object>();
                    } else if (characteristic.equals(Characteristic.KIND.getName())
                            || characteristic.equals(Characteristic.DESCRIPTION.getName())
                            || characteristic.equals(Characteristic.MENACE.getName())
                            || characteristic.equals(Characteristic.DATE_OF_FIRST_MENTION.getName())
                            || characteristic.equals(Characteristic.INVULNAREBILITY.getName())
                            || characteristic.equals(Characteristic.VULNAREBILITY.getName())
                            || characteristic.equals(Characteristic.HEIGHT.getName())
                            || characteristic.equals(Characteristic.WEIGHT.getName())
                            || characteristic.equals(Characteristic.TIME_OF_ACTIVITY.getName())) {
                        event = reader.nextEvent();
                        allCharascteristics.put(characteristic, event.asCharacters().getData());
                    } else if (characteristic.equals(Characteristic.AREAS.getName())) {
                        areas = new ArrayList<Object>();
                    } else if (characteristic.equals(Characteristic.IMMUNITIES.getName())) {
                        immunities = new ArrayList<Object>();

                    } else if (characteristic.equals(Characteristic.AREA.getName())) {
                        event = reader.nextEvent();
                        areas.add(event.asCharacters().getData());
                    } else if (characteristic.equals(Characteristic.IMMUNITY.getName())) {
                        event = reader.nextEvent();
                        immunities.add(event.asCharacters().getData());
                    } else if (characteristic.equals(Characteristic.RECIPE.getName())) {
                        newRecipe = new HashMap<String, Object>();
                    } else if (characteristic.equals(Characteristic.TYPE.getName())) {
                        event = reader.nextEvent();
                        newRecipe.put(characteristic, event.asCharacters().getData());
                    } else if (characteristic.equals(Characteristic.INGREDIENTS.getName())) {
                        ingredients = new HashMap<String, Integer>();
                    } else if (characteristic.equals("ingredient")) {
                        Attribute ingredientNameAttr = startElement.getAttributeByName(new QName("name"));
                        if (ingredientNameAttr != null) {
                            String name = ingredientNameAttr.getValue();
                            event = reader.nextEvent();
                            int quantity = Integer.parseInt(event.asCharacters().getData());
                            ingredients.put(name, quantity);
                        } else {
                            throw new NumberFormatException();
                        }
                    } else if (characteristic.equals(Characteristic.COOKING_TIME.getName())) {
                        event = reader.nextEvent();
                        newRecipe.put(characteristic, event.asCharacters().getData());
                    } else if (characteristic.equals(Characteristic.EFFICIENCY.getName())) {
                        event = reader.nextEvent();
                        newRecipe.put(characteristic, event.asCharacters().getData());
                    }
                }
                if (event.isEndElement()) {
                    EndElement endElement = event.asEndElement();
                    if (endElement.getName().getLocalPart().equals("Creature")) {
                        creature.checkNewChararterictics(allCharascteristics);
                        creatures.addCreature(creature);
                    } else if (endElement.getName().getLocalPart().equals(Characteristic.RECIPE.getName())) {
                        allCharascteristics.put(Characteristic.RECIPE.getName(), newRecipe);
                    } else if (endElement.getName().getLocalPart().equals(Characteristic.INGREDIENTS.getName())) {
                        newRecipe.put(Characteristic.INGREDIENTS.getName(), ingredients);
                    } else if (endElement.getName().getLocalPart().equals(Characteristic.AREAS.getName())) {
                        allCharascteristics.put(Characteristic.AREAS.getName(), areas);
                    } else if (endElement.getName().getLocalPart().equals(Characteristic.IMMUNITIES.getName())) {
                        allCharascteristics.put(Characteristic.IMMUNITIES.getName(), immunities);
                    }

                }
            }
            return true;
        } catch (FileNotFoundException | XMLStreamException | NumberFormatException | NullPointerException | ClassCastException e) {
            return false;
        }

    }
}
