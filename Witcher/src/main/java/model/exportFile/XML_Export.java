/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.exportFile;

import controller.Characteristic;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

/**
 *
 * @author rifa1
 */
public class XML_Export extends FileExport {

    @Override
    public boolean createFile(ArrayList<HashMap<String, Object>> creatures) {
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.newDocument();
            Element root = doc.createElement("Creatures");
            doc.appendChild(root);
            for (int i = 0; i < creatures.size(); i++) {
                HashMap<String, Object> info = creatures.get(i);
                Element creatureElement = doc.createElement("Creature");
                root.appendChild(creatureElement);
                for (String characteristic : info.keySet()) {
                    if (characteristic.equals(Characteristic.AREAS.getName())) {
                        Element areasElement = doc.createElement(characteristic);
                        creatureElement.appendChild(areasElement);
                        for (String area : (ArrayList<String>) info.get(characteristic)) {
                            Element areaEl = doc.createElement(Characteristic.AREA.getName());
                            areaEl.appendChild(doc.createTextNode(String.valueOf(area)));
                            areasElement.appendChild(areaEl);
                        }
                    } else if (characteristic.equals(Characteristic.IMMUNITIES.getName())) {
                        Element immunitiesElement = doc.createElement(characteristic);
                        creatureElement.appendChild(immunitiesElement);
                        for (String immunity : (ArrayList<String>) info.get(characteristic)) {
                            Element immunityEl = doc.createElement(Characteristic.IMMUNITY.getName());

                            immunityEl.appendChild(doc.createTextNode(String.valueOf(immunity)));
                            immunitiesElement.appendChild(immunityEl);
                        }
                    } else if (characteristic.equals(Characteristic.RECIPE.getName())) {
                        Element recipeElement = doc.createElement(characteristic);
                        creatureElement.appendChild(recipeElement);
                        HashMap<String, Object> recipe = (HashMap<String, Object>) info.get(characteristic);
                        Element typeElement = doc.createElement(Characteristic.TYPE.getName());
                        typeElement.appendChild(doc.createTextNode(String.valueOf(recipe.get(Characteristic.TYPE.getName()))));
                        recipeElement.appendChild(typeElement);
                        Element ingredientsElement = doc.createElement(Characteristic.INGREDIENTS.getName());
                        recipeElement.appendChild(ingredientsElement);
                        HashMap<String, Object> ingredients = (HashMap<String, Object>) recipe.get(Characteristic.INGREDIENTS.getName());
                        for (String ingredient : ingredients.keySet()) {
                            Element ingredientElement = doc.createElement("ingredient");
                            ingredientElement.setAttribute("name", ingredient);
                            ingredientElement.appendChild(doc.createTextNode(String.valueOf(ingredients.get(ingredient))));
                            ingredientsElement.appendChild(ingredientElement);
                        }
                        Element cook_time_Element = doc.createElement(Characteristic.COOKING_TIME.getName());

                        cook_time_Element.appendChild(doc.createTextNode(String.valueOf(recipe.get(Characteristic.COOKING_TIME.getName()))));
                        recipeElement.appendChild(cook_time_Element);
                        Element efficiencyElement = doc.createElement(Characteristic.EFFICIENCY.getName());
                        efficiencyElement.appendChild(doc.createTextNode(String.valueOf(recipe.get(Characteristic.EFFICIENCY.getName()))));
                        recipeElement.appendChild(efficiencyElement);

                    } else {
                        Element element = doc.createElement(characteristic);
                        element.appendChild(doc.createTextNode(String.valueOf(info.get(characteristic))));
                        creatureElement.appendChild(element);
                    }
                }
            }

            //write the content into xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(fileName));
            transformer.transform(source, result);
            return true;

        } catch (ParserConfigurationException | TransformerException e) {
            return false;
        }

    }

}
