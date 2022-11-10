/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pokemonadvance;

import java.util.Random;

/**
 *
 * @author lrosellg
 */
public class Pokemon {

    private String name;
    private int number;
    private String type;
    private int level;
    private int power;

    public Pokemon(String name, int number, String type) {
        this.name = name;
        this.number = number;
        this.type = type;
        Random r = new Random();
        this.level = r.nextInt(10);
        this.power = r.nextInt(100);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

}
