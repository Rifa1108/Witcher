/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.HashMap;

/**
 *
 * @author rifa1
 */
public class Recipe {

    private String type;
    private HashMap<String, Integer> ingredients;
    private int cooking_time_in_minutes;
    private String efficiency;

    public void setRecipeType(String type) {
        this.type = type;
    }

    public void createRecipeIngredients() {
        ingredients = new HashMap<String, Integer>();
    }

    public void setRecipeIngredient(String name, int quantity) {
        ingredients.put(name, quantity);
    }

    public void setTime(int cooking_time_in_minutes) {
        this.cooking_time_in_minutes = cooking_time_in_minutes;
    }

    public void setEfficiency(String efficiency) {
        this.efficiency = efficiency;
    }

}
