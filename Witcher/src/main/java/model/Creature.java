/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import controller.Characteristic;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author rifa1
 */
public class Creature {

    private String kind;
    private ArrayList<String> areas;
    private LocalDate date;
    private ArrayList<String> immunities;
    private Recipe recipe;
    private String source;
    private HashMap<String, Object> allCharascteristics;

    public Creature(String source) {
        this.source = source;
        setDefaultCharacteristics();
    }

    private void setDefaultCharacteristics() {
        allCharascteristics = new HashMap<String, Object>();
        allCharascteristics.put(Characteristic.KIND.getName(), "Не известно");
        allCharascteristics.put(Characteristic.DESCRIPTION.getName(), "Не известно");
        allCharascteristics.put(Characteristic.MENACE.getName(), 0);
        allCharascteristics.put(Characteristic.AREAS.getName(), new ArrayList<String>());
        allCharascteristics.put(Characteristic.DATE_OF_FIRST_MENTION.getName(), 0000 - 00 - 00);
        allCharascteristics.put(Characteristic.INVULNAREBILITY.getName(), "Не известно");
        allCharascteristics.put(Characteristic.VULNAREBILITY.getName(), "Не известно");
        allCharascteristics.put(Characteristic.HEIGHT.getName(), 0);
        allCharascteristics.put(Characteristic.WEIGHT.getName(), 0);
        allCharascteristics.put(Characteristic.IMMUNITIES.getName(), new ArrayList<String>());
        allCharascteristics.put(Characteristic.TIME_OF_ACTIVITY.getName(), "Не известно");
        HashMap<String, Object> empytRecipe = new HashMap<String, Object>();
        empytRecipe.put(Characteristic.TYPE.getName(), "Не известно");
        empytRecipe.put(Characteristic.INGREDIENTS.getName(), new HashMap<String, Integer>());
        empytRecipe.put(Characteristic.COOKING_TIME.getName(), 0);
        empytRecipe.put(Characteristic.EFFICIENCY.getName(), "Не известно");
        allCharascteristics.put(Characteristic.RECIPE.getName(), empytRecipe);
    }

    protected String getSource() {
        return source;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public void createAreas() {
        areas = new ArrayList<>();
    }

    public void addToAreas(String area) {
        areas.add(area);
    }

    public void setDate(String date) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            this.date = LocalDate.parse(date, formatter);
        } catch (DateTimeParseException e) {
            throw new NumberFormatException();
        }
    }

    public void createImmunuties() {
        immunities = new ArrayList<>();
    }

    public void addToImmunities(String immunity) {
        immunities.add(immunity);
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public String getKind() {
        return kind;
    }

    public HashMap<String, Object> getAllChararterictics() {
        return allCharascteristics;
    }

    public void checkNewChararterictics(HashMap<String, Object> newCharascteristics) {
        for (String characteristic : newCharascteristics.keySet()) {
            if (characteristic.equals(Characteristic.KIND.getName())) {
                kind = String.valueOf(newCharascteristics.get(characteristic));
            } else if (characteristic.equals(Characteristic.DESCRIPTION.getName())) {
                String description = String.valueOf(newCharascteristics.get(characteristic));
            } else if (characteristic.equals(Characteristic.MENACE.getName())) {
                int menace = Integer.parseInt(String.valueOf(newCharascteristics.get(characteristic)));
            } else if (characteristic.equals(Characteristic.AREAS.getName())) {
                createAreas();
                ArrayList<Object> newAreas = (ArrayList<Object>) newCharascteristics.get(characteristic);
                for (Object newArea : newAreas) {
                    String area = String.valueOf(newArea);
                    addToAreas(area);
                }
            } else if (characteristic.equals(Characteristic.DATE_OF_FIRST_MENTION.getName())) {
                String date_of_mention = String.valueOf(newCharascteristics.get(characteristic));
                setDate(date_of_mention);
            } else if (characteristic.equals(Characteristic.INVULNAREBILITY.getName())) {
                String invulnerability = String.valueOf(newCharascteristics.get(characteristic));
            } else if (characteristic.equals(Characteristic.VULNAREBILITY.getName())) {
                String vulnerability = String.valueOf(newCharascteristics.get(characteristic));
            } else if (characteristic.equals(Characteristic.HEIGHT.getName())) {
                int height_in_metres = Integer.parseInt(String.valueOf(newCharascteristics.get(characteristic)));
            } else if (characteristic.equals(Characteristic.WEIGHT.getName())) {
                int weight_in_kg = Integer.parseInt(String.valueOf(newCharascteristics.get(characteristic)));
            } else if (characteristic.equals(Characteristic.IMMUNITIES.getName())) {
                createImmunuties();
                ArrayList<Object> newImmunities = (ArrayList<Object>) newCharascteristics.get(characteristic);
                for (Object newImmunuty : newImmunities) {
                    String immunutiy = String.valueOf(newImmunuty);
                    addToImmunities(immunutiy);
                }
            } else if (characteristic.equals(Characteristic.TIME_OF_ACTIVITY.getName())) {
                String time_of_activity = String.valueOf(newCharascteristics.get(characteristic));
            } else if (characteristic.equals(Characteristic.RECIPE.getName())) {
                recipe = new Recipe();
                HashMap<String, Object> newRecipe = (HashMap<String, Object>) newCharascteristics.get(characteristic);
                for (String recipeCharacteristic : newRecipe.keySet()) {
                    if (recipeCharacteristic.equals(Characteristic.TYPE.getName())) {
                        String type = String.valueOf(newRecipe.get(recipeCharacteristic));
                        recipe.setRecipeType(type);
                    } else if (recipeCharacteristic.equals(Characteristic.INGREDIENTS.getName())) {
                        recipe.createRecipeIngredients();
                        HashMap<String, Integer> ingredients = (HashMap<String, Integer>) newRecipe.get(recipeCharacteristic);
                        for (String ingredient : ingredients.keySet()) {
                            recipe.setRecipeIngredient(ingredient, ingredients.get(ingredient));
                        }
                    } else if (recipeCharacteristic.equals(Characteristic.COOKING_TIME.getName())) {
                        int time = Integer.parseInt(String.valueOf(newRecipe.get(recipeCharacteristic)));
                        recipe.setTime(time);
                    } else if (recipeCharacteristic.equals(Characteristic.EFFICIENCY.getName())) {
                        String efficiency = String.valueOf(newRecipe.get(recipeCharacteristic));
                        recipe.setEfficiency(efficiency);
                    }
                }
            }
        }
        setNewChararterictics(newCharascteristics);
    }

    private void setNewChararterictics(HashMap<String, Object> newCharascteristics) {
        for (String newCharacteristic : newCharascteristics.keySet()) {
            for (String oldCharacteristic : allCharascteristics.keySet()) {
                if (newCharacteristic.equals(Characteristic.RECIPE.getName()) & oldCharacteristic.equals(Characteristic.RECIPE.getName())) {
                    HashMap<String, Object> newRecipe = (HashMap<String, Object>) newCharascteristics.get(newCharacteristic);
                    HashMap<String, Object> oldRecipe = (HashMap<String, Object>) allCharascteristics.get(oldCharacteristic);
                    for (String newRecipeCharacteristic : newRecipe.keySet()) {
                        for (String oldRecipeCharacteristic : oldRecipe.keySet()) {
                            if (newRecipeCharacteristic.equals(oldRecipeCharacteristic)) {
                                oldRecipe.put(newRecipeCharacteristic, newRecipe.get(newRecipeCharacteristic));
                            }
                        }
                    }
                    allCharascteristics.put(oldCharacteristic, oldRecipe);
                } else if (newCharacteristic.equals(oldCharacteristic)) {
                    allCharascteristics.put(newCharacteristic, newCharascteristics.get(newCharacteristic));
                }
            }
        }
    }

}
