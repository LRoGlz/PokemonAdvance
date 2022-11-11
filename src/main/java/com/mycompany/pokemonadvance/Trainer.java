/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pokemonadvance;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author lrosellg
 */
public class Trainer {

    private String name;
    private String password;
    private String email;
    private boolean firstSession;
    //Esta lista tiene los pokemon de un entrenador, el que esté llamando a esa lista
    private ArrayList<Pokemon> pokeball = new ArrayList();

    public Trainer(String name, String password, String email) {
        this.name = name;
        this.password = password;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ArrayList<Pokemon> getPokeball() {
        return pokeball;
    }

    public void setPokeball(ArrayList<Pokemon> pokeball) {
        this.pokeball = pokeball;
    }

    public boolean isFirstSession() {
        return firstSession;
    }

    public void setFirstSession(boolean firstSession) {
        this.firstSession = firstSession;
    }

    public Pokemon findPokemon(ArrayList<Pokemon> wildPokemon) {
        Random r = new Random();
        int index = r.nextInt(wildPokemon.size());
        Pokemon enemy = wildPokemon.get(index);
        System.out.println("Un " + enemy.getName() + " con nivel " + enemy.getLevel() + " y fuerza " + enemy.getPower() + " salvaje apareció");
        return enemy;
    }

    public void catchPokemon(Pokemon pokemon) {
        System.out.println("Has capturado un " + pokemon.getName());
        pokeball.add(pokemon);
    }

    public void showPokeball() {
         int cont = 1;
        for (Pokemon pokemon : this.pokeball) {
           
            System.out.println(cont  + " -" + pokemon.getName() + " nivel: " + pokemon.getLevel() + " fuerza: " + pokemon.getPower());
            cont++;
        }
    }
    
    public Pokemon choosePokemon(int index){
        return pokeball.get(index);
    }

    public void getFirstPokemon() {
        System.out.println("Tu primer pokemon es...");
        Random rand = new Random();
        int indexRand = rand.nextInt(BBDD.getPokemonsBBDD().size());
        Pokemon firstPokemon = BBDD.getPokemonsBBDD().get(indexRand);
        System.out.println(firstPokemon.getName());
        pokeball.add(firstPokemon);
        this.firstSession = true;
    }

}
