/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

/**
 *
 * @author rifa1
 */
public enum Characteristic {
    KIND("kind"), MENACE("menace"), DESCRIPTION("description"), AREAS("areas"), AREA("area"),
    DATE_OF_FIRST_MENTION("date_of_first_mention"), INVULNAREBILITY("invulnerability"),
    VULNAREBILITY("vulnerability"), HEIGHT("height_in_metres"), WEIGHT("weight_in_kg"), IMMUNITIES("immunities"),
    IMMUNITY("immunity"), TIME_OF_ACTIVITY("time_of_activity"), RECIPE("recipe"), TYPE("type"),
    INGREDIENTS("ingredients"), COOKING_TIME("cooking_time_in_minutes"), EFFICIENCY("efficiency");
    private String name;

    Characteristic(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
