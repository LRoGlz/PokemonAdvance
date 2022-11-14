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
        this.level = r.nextInt(10)+1;
        this.power = r.nextInt(100)+1;
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
    
    // Pelear contra otro usuario
    public Pokemon fightEnemy (Trainer enemy){
        enemy.getPokeball();
        Random r = new Random();
        int index = r.nextInt(enemy.getPokeball().size());
        Pokemon pokemonEnemy = enemy.getPokeball().get(index);
        return pokemonEnemy;
    }
    
    // Compara los pokemons para ver quien gana
    public boolean comparePokemons (Pokemon pokemonEnemy){
        if (!type.equals(pokemonEnemy.type)) {
            switch (pokemonEnemy.type) {
                case "fuego":
                    if ("planta".equals(type)) {
                        power = power - 30;
                    } else {
                        power = power + 30;
                    }
                    break;
                case "agua":
                    if ("fuego".equals(type)) {
                        power = power - 30;
                    } else {
                        power = power + 30;
                    }
                    break;
                case "planta":
                    if ("agua".equals(type)) {
                        power = power - 30;
                    } else {
                        power = power + 30;
                    }
                    break;
                default:
                    break;

            }
        }
        if (power >= pokemonEnemy.getPower()) {
            level++;
            if (level == 5){
                evolve();
            }
            return true;
        } else {
            return false;
        }
    }
    
    public void train (){
        ++this.level;
        if (level == 5){
            evolve();
        }
    }
    
    public void evolve (){
        power = power + 20;
            switch (this.name) {
                case "Bulbasaur":
                    this.name = "Ivysaur";
                    break;
                case "Charmander":
                    this.name = "Charmeleon";
                    break;
                case "Squirtle":
                    this.name = "Wartortle";
                    break;
                case "Chikorita":
                    this.name = "Bayleef";
                    break;
                case "Piplup":
                    this.name = "Prinplup";
                    break;
                case "Cyndaquil":
                    this.name = "Quilava";
                    break;
                case "Oddish":
                    this.name = "Gloom";
                    break;
                case "Poliwag":
                    this.name = "Poliwhirl";
                    break;
                case "Ponyta":
                    this.name = "Rapidash";
                    break;
                case "Psyduck":
                    this.name = "Golduck";
                    break;
                default:
                    break;
            }
            System.out.println("Tu pokemon ha evolucionado a " + name);
    }
}
