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
    private String description;
    private int menace;
    private ArrayList<String> areas;
    private LocalDate date;
    private String invulnerability;
    private String vulnerability;
    private int height_in_metres;
    private int weight_in_kg;
    private ArrayList<String> immunities;
    private String time_of_activity;
    private Recipe recipe;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
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

    public void setDescription(String description) {
        this.description = description;
    }

    public void setMenace(int menace) {
        this.menace = menace;
    }

    public void createAreas() {
        areas = new ArrayList<>();
    }

    public void addToAreas(String area) {
        areas.add(area);
    }

    public void setDate(String date) {
        try {
            this.date = LocalDate.parse(date, formatter);
        } catch (DateTimeParseException e) {
            throw new NumberFormatException();
        }
    }

    public void setInvulnerability(String invulnerability) {
        this.invulnerability = invulnerability;

    }

    public void setVulnerability(String vulnerability) {
        this.vulnerability = vulnerability;
    }

    public void setHeight(int height_in_metres) {
        this.height_in_metres = height_in_metres;
    }

    public void setWeigh(int weight_in_kg) {
        this.weight_in_kg = weight_in_kg;
    }

    public void createImmunuties() {
        immunities = new ArrayList<>();
    }

    public void addToImmunities(String immunity) {
        immunities.add(immunity);
    }

    public void setTimeOfActivity(String time_of_activity) {
        this.time_of_activity = time_of_activity;
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

    public void setAllChararterictics(HashMap<String, Object> newCharascteristics) {
        for (String characteristic : newCharascteristics.keySet()) {
            if (characteristic.equals(Characteristic.KIND.getName())) {
                kind = String.valueOf(newCharascteristics.get(characteristic));
            } else if (characteristic.equals(Characteristic.DESCRIPTION.getName())) {
                description = String.valueOf(newCharascteristics.get(characteristic));
            } else if (characteristic.equals(Characteristic.MENACE.getName())) {
                menace = Integer.parseInt(String.valueOf(newCharascteristics.get(characteristic)));
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
                invulnerability = String.valueOf(newCharascteristics.get(characteristic));
            } else if (characteristic.equals(Characteristic.VULNAREBILITY.getName())) {
                vulnerability = String.valueOf(newCharascteristics.get(characteristic));
            } else if (characteristic.equals(Characteristic.HEIGHT.getName())) {
                height_in_metres = Integer.parseInt(String.valueOf(newCharascteristics.get(characteristic)));
            } else if (characteristic.equals(Characteristic.WEIGHT.getName())) {
                weight_in_kg = Integer.parseInt(String.valueOf(newCharascteristics.get(characteristic)));
            } else if (characteristic.equals(Characteristic.IMMUNITIES.getName())) {
                createImmunuties();
                ArrayList<Object> newImmunities = (ArrayList<Object>) newCharascteristics.get(characteristic);
                for (Object newImmunuty : newImmunities) {
                    String immunutiy = String.valueOf(newImmunuty);
                    addToImmunities(immunutiy);
                }
            } else if (characteristic.equals(Characteristic.TIME_OF_ACTIVITY.getName())) {
                time_of_activity = String.valueOf(newCharascteristics.get(characteristic));
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
